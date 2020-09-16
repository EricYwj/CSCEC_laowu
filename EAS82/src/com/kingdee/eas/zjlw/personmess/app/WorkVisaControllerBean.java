package com.kingdee.eas.zjlw.personmess.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK; //import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean; //import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.certificates.app.visaTypeEnum;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryCollection;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryFactory;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WorkVisaControllerBean extends AbstractWorkVisaControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.zjlw.personmess.app.WorkVisaControllerBean");

	// 保存
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		WorkVisaInfo accInfo = (WorkVisaInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		// 设置编码
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// AdminOrgUnitInfo currentCompany =
		// ContextHelperFactory.getLocalInstance(ctx).getCurrentAdmin();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory =
		// CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //不允许断号
		// if(codFactory.isUseIntermitNumber(accInfo,
		// orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }else{
		// if(codFactory.isAddView(accInfo, orgId)){//新增显示
		//    				
		// }else{//什么都没勾选
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }
		// }
		// }
		// }
		return super._save(ctx, accInfo);
	}

	// 提交
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		WorkVisaInfo accInfo = (WorkVisaInfo) model;
		accInfo.setBillSate(BillStateEnum.CHECKING);
		// 设置编码
		if (accInfo.getNumber() == null || "".equals(accInfo.getNumber())) {
			AdminOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentAdmin();
			String orgId = currentCompany.getId().toString();
			ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
			if (codFactory.isExist(accInfo, orgId)) {
				// 不允许断号
				if (codFactory.isUseIntermitNumber(accInfo, orgId) && (!codFactory.isUserSelect(accInfo, orgId))) {
					accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
				} else {
					if (codFactory.isAddView(accInfo, orgId)) {// 新增显示

					} else {// 什么都没勾选
						accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
					}
				}
			}
		}
		return super._submit(ctx, accInfo);
	}

	// 国内工作部审核
	protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		int a = 0;
		WorkVisaInfo info = (WorkVisaInfo) getValue(ctx, pk, getSelector());
		// FilterInfo filter = new FilterInfo();
		// filter.getFilterItems().add(new FilterItemInfo("billSate", "40"));
		// filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		// if (super._exists(ctx, filter)) {
		// try {
		// throw new Exception("所选行已存在审核通过的数据，不能审核！");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),
		// pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.CHECKING);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		// LogUtil.afterLog(ctx, logPK);
	}

	// 指标业务项目人员审核
	protected void _bizPersonAudit(Context ctx, IObjectPK pk) throws EASBizException, BOSException {
		// super._bizPersonAudit(ctx, pk);
		WorkVisaInfo info = (WorkVisaInfo) getValue(ctx, pk, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("programAuditor");
		sic.add("programAuditDate");
		info.setBillSate(BillStateEnum.CHECKING);
		info.setProgramAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setProgramAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
	}

	// 指标项目经理审核
	protected void _projectMessAudit(Context ctx, IObjectPK pk) throws EASBizException, BOSException {
		// super._projectMessAudit(ctx, pk);
		WorkVisaInfo info = (WorkVisaInfo) getValue(ctx, pk, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("projectAuditor");
		sic.add("projectAuditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setProjectAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setProjectAuditDate(new Date());
//		updatePartial(ctx, info, sic);
//		LogUtil.afterLog(ctx, logPK);
		writePersonHis(ctx, info);
	}

	// 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		WorkVisaInfo info = (WorkVisaInfo) getValue(ctx, pk, getSelector());
		// FilterInfo filter = new FilterInfo();
		// filter.getFilterItems().add(new FilterItemInfo("billSate", "30",
		// CompareType.NOTEQUALS));
		// filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		// if (super._exists(ctx, filter)) {
		// try {
		// throw new Exception("所选行在审核不通过中");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		sic.add("programAuditor");
		sic.add("programAuditDate");
		sic.add("projectAuditor");
		sic.add("projectAuditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);
		info.setProgramAuditor(null);
		info.setProgramAuditDate(null);
		info.setProjectAuditor(null);
		info.setProjectAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		deletePersonHis(ctx, info);
	}

	// 审核通过，判断人员历史信息中是否存在，如果存在，删除人员历史信息，如果不存在，回写人员历史信息
	protected void writePersonHis(Context ctx, WorkVisaInfo info) throws EASBizException, BOSException {
		WorkVisaEntryCollection entryCol = info.getEntrys();
		for (int i = 0; i < entryCol.size(); i++) {
			WorkVisaEntryInfo entryInfo = entryCol.get(i);
			FilterInfo filter = new FilterInfo();
			String idNum = entryInfo.getIdNum();
			String passportNo = entryInfo.getPassportNo();
			if ("C01".equals(entryInfo.getNational().getNumber())) {
				filter.getFilterItems().add(new FilterItemInfo("idNum", idNum));
			} else {
				filter.getFilterItems().add(new FilterItemInfo("passportNo", passportNo));
			}
			PersonHistoryFactory.getLocalInstance(ctx).delete(filter);
			PersonHistoryInfo hisInfo = new PersonHistoryInfo();
			hisInfo.setId(BOSUuid.create(hisInfo.getBOSType()));
			hisInfo.setSourceBillId(entryInfo.getId().toString());
			hisInfo.setNumber(info.getNumber());// 单据编号
			hisInfo.setAuditor(info.getAuditor());// 审核人
			hisInfo.setNameCN(entryInfo.getName());// 中文姓名
			hisInfo.setFirstNameAlp(entryInfo.getLastName());// 姓拼音
			hisInfo.setLastNameApl(entryInfo.getFirstName());// 名拼音
			hisInfo.setSex(entryInfo.getSex());// 性别
			hisInfo.setBirthDate(entryInfo.getBirthdate());// 出生日期
			hisInfo.setNation(entryInfo.getNational());// 国籍
			hisInfo.setIdNum(entryInfo.getIdNum());// 身份证号
			hisInfo.setRealProf(entryInfo.getAcProf());// 实际工种
			hisInfo.setPermitProfession(entryInfo.getPmtProfC());// 指标工种
			hisInfo.setWorkOrg(entryInfo.getWorkProgram());// 工作项目
			hisInfo.setPermitOrg(entryInfo.getPermitProgram());// 指标项目
			hisInfo.setCooperation(entryInfo.getCooperation());// 合作单位
			hisInfo.setPassportNo(entryInfo.getPassportNo());// 护照号码
			hisInfo.setPassportIssueDate(entryInfo.getPassportIssueDate());// 护照签发日期
			hisInfo.setPassportExpireDate(entryInfo.getPassportExpireDate());// 护照失效日期
			hisInfo.setPassportInst(entryInfo.getPassportAgence().getAlias());// 护照颁发机构
			hisInfo.setBirthPlaceCn(entryInfo.getBirthPlaceCn());// 出生地中文
			hisInfo.setBirthPlaceFr(entryInfo.getBirthPlaceFr());// 出生地法文
			hisInfo.setFatherName(entryInfo.getFatherName());// 父亲姓名
			hisInfo.setFatherNameAlphabet(entryInfo.getFatherNameAlphabet());// 父亲姓名拼音
			hisInfo.setMotherName(entryInfo.getMotherName());// 母亲姓名
			hisInfo.setMotherNameAlphabet(entryInfo.getMotherNameAlphabet());// 母亲姓名拼音
			hisInfo.setMerState(entryInfo.getMaritalStatus());// 婚姻状态
			hisInfo.setCoupleName(entryInfo.getCoupleName());// 配偶姓名
			hisInfo.setCoupleNameAlphabet(entryInfo.getCoupleNameAlphabet());// 配偶姓名拼音
			hisInfo.setCoupleBirthDate(entryInfo.getCoupleBirthDate());// 配偶出生日期
			hisInfo.setCoupleBirthPlace(entryInfo.getCoupleBirthPlace());// 配偶出生地
			hisInfo.setCoupleWorkPlace(entryInfo.getCoupleWorkPlace());// 配偶工作单位
			hisInfo.setCoupleNation(entryInfo.getCoupleNational());// 配偶国籍
			hisInfo.setPassportCity(entryInfo.getPassportCity());// 护照签发地中文
			hisInfo.setPassportCityF(entryInfo.getPassportCityF());// 护照签发地拼音
			hisInfo.setContactway(entryInfo.getContactway());// 国内联系方式
			hisInfo.setInnerAddress(entryInfo.getResidence());// 国内联系地址
			hisInfo.setOldPassport(entryInfo.getOldPassport());// 旧护照号
			hisInfo.setRemark(entryInfo.getRemark());// 备注
			hisInfo.setBsnisState(perBizStateEnum.MESSINPUT);// 人员业务状态：信息录入
			hisInfo.setVisaType(visaTypeEnum.work);// 签证类型
			PersonHistoryFactory.getLocalInstance(ctx).addnew(hisInfo);
		}
	}

	// 反审核删除人员历史信息中的数据
	public void deletePersonHis(Context ctx, WorkVisaInfo info) throws BOSException, EASBizException {
		Set set = new HashSet();
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		WorkVisaEntryCollection entryCol = info.getEntrys();
		for (int i = 0; i < entryCol.size(); i++) {
			WorkVisaEntryInfo entryInfo = entryCol.get(i);
			String id = entryInfo.getId().toString();
			set.add(id);
			// view = new EntityViewInfo();
			// filter = new FilterInfo();
			// filter.getFilterItems().add(new FilterItemInfo("sourceBillId",
			// id));
			// view.setFilter(filter);
			// PersonHistoryCollection entryCoy
			// =PersonHistoryFactory.getLocalInstance
			// (ctx).getPersonHistoryCollection(view);
			// if(entryCoy!=null && entryCoy.size()>0){
			// PersonHistoryInfo phInfo = entryCoy.get(0);
			// PersonHistoryFactory.getLocalInstance(ctx).delete(new
			// ObjectUuidPK(phInfo.getId()));
			// }
		}
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId", set, CompareType.INCLUDE));
		PersonHistoryFactory.getLocalInstance(ctx).delete(filter);
	}

	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		sic.add("entrys.national.number");
		return sic;
	}
}