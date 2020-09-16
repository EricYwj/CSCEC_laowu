package com.kingdee.eas.zjlw.social.app;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.util.FilerImpl;

import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK; //import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean; //import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.ctrl.kdf.table.IRow;
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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryFactory;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo;
import com.kingdee.eas.zjlw.social.CheckCountEntryCollection;
import com.kingdee.eas.zjlw.social.CheckCountEntryFactory;
import com.kingdee.eas.zjlw.social.CheckCountEntryInfo;
import com.kingdee.eas.zjlw.social.CheckCountFactory;
import com.kingdee.eas.zjlw.social.CheckCountInfo;
import com.kingdee.eas.zjlw.social.CheckCountCollection;
import com.kingdee.eas.zjlw.social.ForiCheckedCollection;
import com.kingdee.eas.zjlw.social.ForiCheckedEntryCollection;
import com.kingdee.eas.zjlw.social.ForiCheckedEntryInfo;
import com.kingdee.eas.zjlw.social.ForiCheckedInfo;
import com.kingdee.eas.zjlw.social.InsurePersonEntryCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryFactory;
import com.kingdee.eas.zjlw.social.InsurePersonEntryInfo;
import com.kingdee.eas.zjlw.social.InsurePersonFactory;
import com.kingdee.eas.zjlw.social.InsurePersonInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CheckCountControllerBean extends AbstractCheckCountControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.zjlw.social.app.CheckCountControllerBean");

	// 保存
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		CheckCountInfo accInfo = (CheckCountInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		// 设置编码
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany =
		// ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
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
		CheckCountInfo accInfo = (CheckCountInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
		// 设置编码
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany =
		// ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
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
		return super._submit(ctx, accInfo);
	}

	/**
	 * 审核通过
	 */
	protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		CheckCountInfo info = (CheckCountInfo) getValue(ctx, pk, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("AuditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeBackIns(ctx, info, true);
		writeLocalInfo(ctx, info, true);

	}

	/**
	 * 审核不通过
	 */
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		CheckCountInfo info = (CheckCountInfo) getValue(ctx, pk, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("AuditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
	}

	/**
	 * 反写
	 * 
	 * @param ctx
	 * @param info
	 * @param audit
	 * @throws BOSException
	 * @throws EASBizException
	 */
	// private void writeBack(Context ctx, CheckCountInfo info, boolean audit)
	// throws EASBizException, BOSException {
	// // 反写参保人员
	// if(audit){
	// writeBackIns(ctx, info, audit);
	// }
	// }
	/**
	 * 反写参保人员
	 */
	private void writeBackIns(Context ctx, CheckCountInfo info, boolean audit) throws BOSException, EASBizException {
		CheckCountEntryCollection foriEntryCol = info.getEntrys();
		for (int i = 0; i < foriEntryCol.size(); i++) {
			CheckCountEntryInfo entryInfo = foriEntryCol.get(i);
			String personID = entryInfo.getPersonID();
			String foriPersId = entryInfo.getForiPersID();
			FilterInfo filter = new FilterInfo();
			EntityViewInfo view = new EntityViewInfo();
			filter.getFilterItems().add(new FilterItemInfo("personID", personID));
			view.setFilter(filter);
			InsurePersonEntryInfo insEntryInfo = InsurePersonEntryFactory.getLocalInstance(ctx).getInsurePersonEntryCollection(view).get(0);
			if (audit) {
				if (insEntryInfo != null) {
					insEntryInfo.setForiPersID(foriPersId);// 外会人员编号
					insEntryInfo.setSecurityNo(entryInfo.getSecuNum());// 社保号
					insEntryInfo.setEndDate(entryInfo.getEndDate());// 离场日期
					insEntryInfo.setCCPNo(entryInfo.getCCPNo());// CCP账户
					insEntryInfo.setSecuProf(entryInfo.getSecuProf());// 社保工种
					//2019-8-8  ywj  新增   开始
					insEntryInfo.setIDNumber(entryInfo.getIDNumber());//  身份证号码
					insEntryInfo.setBirthIDNumber(entryInfo.getBirthIDNumber());// 出生证明号码
					//2019-8-8  ywj  新增   结束
					SelectorItemCollection sic = new SelectorItemCollection();
					sic.add("foriPersID");
					sic.add("securityNo");
					sic.add("endDate");
					sic.add("CCPNo");
					//2019-8-8  ywj  新增   开始
					sic.add("IDNumber");
					sic.add("birthIDNumber");
					//2019-8-8  ywj  新增   结束
					InsurePersonEntryFactory.getLocalInstance(ctx).updatePartial(insEntryInfo, sic);
				}
			}
		}
	}

	/**
	 * 反写属地化信息录入
	 */
	private void writeLocalInfo(Context ctx, CheckCountInfo info, boolean audit) throws BOSException, EASBizException {
		CheckCountEntryCollection foriEntryCol = info.getEntrys();
		for (int i = 0; i < foriEntryCol.size(); i++) {
			CheckCountEntryInfo entryInfo = foriEntryCol.get(i);
			String personID = entryInfo.getPersonID();
			FilterInfo filter = new FilterInfo();
			EntityViewInfo view = new EntityViewInfo();
			filter.getFilterItems().add(new FilterItemInfo("id", personID));
			view.setFilter(filter);
			LocalInfoEntryInfo liEntryInfo = LocalInfoEntryFactory.getLocalInstance(ctx).getLocalInfoEntryCollection(view).get(0);
			if (audit) {
				if (liEntryInfo != null) {
					liEntryInfo.setForiPersID(entryInfo.getForiPersID());// 外会人员编号
					liEntryInfo.setSecurityNo(entryInfo.getSecuNum());// 社保号
					liEntryInfo.setEndDate(entryInfo.getEndDate());// 离场日期
					liEntryInfo.setSecuProf(entryInfo.getSecuProf());// 社保工种
					liEntryInfo.setCCPNo(entryInfo.getCCPNo());// CCP账户
					//2019-8-8  ywj  新增   开始
					liEntryInfo.setIDNumber(entryInfo.getIDNumber());// 身份证号码
					liEntryInfo.setBirthIDNumber(entryInfo.getBirthIDNumber());// 出生证明号码
					//2019-8-8  ywj  新增   结束
					SelectorItemCollection sic = new SelectorItemCollection();
					sic.add("foriPersID");
					sic.add("securityNo");
					sic.add("endDate");
					sic.add("CCPNo");
					//2019-8-8  ywj  新增   开始
					sic.add("IDNumber");
					sic.add("birthIDNumber");
					//2019-8-8  ywj  新增   结束
					LocalInfoEntryFactory.getLocalInstance(ctx).updatePartial(liEntryInfo, sic);
				}
			}
		}
	}

	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("entrys.*");
		return sic;
	}

	/**
	 * 实例化单据
	 * 
	 * @author ywj 2017-11-20
	 */
	protected IObjectValue _initBill(Context ctx, IObjectValue info) throws BOSException, EASBizException {
		AdminOrgUnitInfo workPInfo;
		AdminOrgUnitInfo cooperation;
		AdminOrgUnitInfo secuProj;
		CheckCountInfo checkCountInfo = (CheckCountInfo) info;
		InsurePersonEntryCollection insPersEntryCol = getAlg(ctx, info);// 查询参保名单中勾选参保的数据
		getAlgAll(ctx, info);
		// 赋值分录
		for (int i = 0; i < insPersEntryCol.size(); i++) {
			InsurePersonEntryInfo insPersEntryInfo = insPersEntryCol.get(i);
			CheckCountEntryInfo etyInfo = new CheckCountEntryInfo();
			if (insPersEntryInfo.getWorkProgram() != null && insPersEntryInfo.getWorkProgram().getId() != null) {
				workPInfo = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(insPersEntryInfo.getWorkProgram().getId()));
				etyInfo.setWorkProgram(workPInfo);// 工作项目
			}
			if (insPersEntryInfo.getCooperation() != null && insPersEntryInfo.getCooperation().getId() != null) {
				cooperation = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(insPersEntryInfo.getCooperation().getId()));
				etyInfo.setCooperation(cooperation);// 合作单位
			}
//			if (insPersEntryInfo.getSecuProj() != null) {
//				secuProj = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(insPersEntryInfo.getSecuProj()));
//				etyInfo.setSecuProj(secuProj);// 社保项目
//			}
			if (insPersEntryInfo.getSecuProf() != null) {
				ProjSecuProfInfo pspInfo = ProjSecuProfFactory.getLocalInstance(ctx).getProjSecuProfInfo(new ObjectUuidPK(insPersEntryInfo.getSecuProf().getId()));
				etyInfo.setSecuProf(pspInfo);// 社保工种
			}
			etyInfo.setProjSocialNo(insPersEntryInfo.getProjSocialNo());
			etyInfo.setPersonID(insPersEntryInfo.getPersonID());// 人员主键
			etyInfo.setForiPersID(insPersEntryInfo.getForiPersID());// 外会人员编码
			etyInfo.setLastName(insPersEntryInfo.getLastName());// 姓
			etyInfo.setFirstName(insPersEntryInfo.getFirstName());// 名
			etyInfo.setSex(insPersEntryInfo.getSex());// 性别
			etyInfo.setBirthdate(insPersEntryInfo.getBirthdate());// 出生日期
			etyInfo.setBirthPlace(insPersEntryInfo.getBirthPlaceCn());// 出生地
			if (insPersEntryInfo.getCountry() != null) {
				CountryInfo country = CountryFactory.getLocalInstance(ctx).getCountryInfo(new ObjectUuidPK(insPersEntryInfo.getCountry() == null ? null : insPersEntryInfo.getCountry().getId()));
				etyInfo.setNation(country);// 国家
			}
			etyInfo.setMariState(insPersEntryInfo.getMaritalStatus());// 婚姻状况
			etyInfo.setSecuNum(insPersEntryInfo.getSecurityNo());// 社保号码
			etyInfo.setCCPNo(insPersEntryInfo.getCCPNo());// CCP账户
			etyInfo.setAddress(insPersEntryInfo.getAddress());// 家庭住址
			etyInfo.setCoopCode(insPersEntryInfo.getCooperationId());// 合作单位代码
			etyInfo.setApprTime(insPersEntryInfo.getApproachTime());// 进场日期
			etyInfo.setStartDate(insPersEntryInfo.getApproachTime());// 注册日期
			etyInfo.setEndDate(insPersEntryInfo.getEndDate());// 离场日期
			etyInfo.setNBasePay(insPersEntryInfo.getNBasePay());// 基本工资
			etyInfo.setNSeniority(insPersEntryInfo.getNSeniority());// 工龄
			etyInfo.setSeniPay(insPersEntryInfo.getSeniPay());// 工龄工资
			etyInfo.setParent(checkCountInfo);
			checkCountInfo.getEntrys().add(etyInfo);
		}
		return checkCountInfo;
	}

	/**
	 * 查询参保名单中勾选参保的数据
	 * 
	 * @param ctx
	 * @param info
	 * 
	 * @throws BOSException
	 */
	private InsurePersonEntryCollection getAlg(Context ctx, IObjectValue info) throws BOSException {
		CheckCountInfo checkCountInfo = (CheckCountInfo) info;
		AdminOrgUnitInfo adminInfo = checkCountInfo.getPermProj();
		SelectorItemCollection sic = new SelectorItemCollection();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("join", true));
		filter.getFilterItems().add(new FilterItemInfo("endDate", null, CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("parent.permitOrg.id", adminInfo.getId()));
		EntityViewInfo view = new EntityViewInfo();
		sic.add("*");
		view.setSelector(sic);
		view.setFilter(filter);
		InsurePersonEntryCollection insPersCol = InsurePersonEntryFactory.getLocalInstance(ctx).getInsurePersonEntryCollection(view);
		if (insPersCol.size() == 0) {
			MsgBox.showInfo("所选项目暂无参保人员，无法建立考勤表！");
		}
		return insPersCol;
	}

	private void getAlgAll(Context ctx, IObjectValue info) throws BOSException, EASBizException {
		CheckCountInfo checkCountInfo = (CheckCountInfo) info;
		AdminOrgUnitInfo adminInfo = checkCountInfo.getPermProj();
		SelectorItemCollection sic = new SelectorItemCollection();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("parent.permitOrg.id", adminInfo.getId()));
		filter.getFilterItems().add(new FilterItemInfo("endDate", null, CompareType.EQUALS));
		EntityViewInfo view = new EntityViewInfo();
		sic.add("entrys.*");
		view.setSelector(sic);
		InsurePersonEntryCollection insPersCol = InsurePersonEntryFactory.getLocalInstance(ctx).getInsurePersonEntryCollection(view);
		checkCountInfo.setShCount(insPersCol.size());
		SelectorItemCollection sic1 = new SelectorItemCollection();
		sic1.add("shCount");
		CheckCountFactory.getLocalInstance(ctx).updatePartial(checkCountInfo, sic1);
	}

}