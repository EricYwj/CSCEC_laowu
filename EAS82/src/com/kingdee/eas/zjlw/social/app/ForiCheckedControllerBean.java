package com.kingdee.eas.zjlw.social.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
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
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryFactory;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo;
import com.kingdee.eas.zjlw.social.CheckCountEntryCollection;
import com.kingdee.eas.zjlw.social.CheckCountEntryInfo;
import com.kingdee.eas.zjlw.social.CheckCountFactory;
import com.kingdee.eas.zjlw.social.CheckCountInfo;
import com.kingdee.eas.zjlw.social.ForiCheckedEntryCollection;
import com.kingdee.eas.zjlw.social.ForiCheckedEntryInfo;
import com.kingdee.eas.zjlw.social.ForiCheckedFactory;
import com.kingdee.eas.zjlw.social.ForiCheckedInfo;
import com.kingdee.eas.zjlw.social.ForiPersEntryCollection;
import com.kingdee.eas.zjlw.social.ForiPersEntryFactory;
import com.kingdee.eas.zjlw.social.ForiPersEntryInfo;
import com.kingdee.eas.zjlw.social.InsurePersonEntryFactory;
import com.kingdee.eas.zjlw.social.InsurePersonEntryInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.social.ForiCheckedCollection;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ForiCheckedControllerBean extends AbstractForiCheckedControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.zjlw.social.app.ForiCheckedControllerBean");

	// 保存
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		ForiCheckedInfo accInfo = (ForiCheckedInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		return super._save(ctx, accInfo);
	}

	// 提交
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		ForiCheckedInfo accInfo = (ForiCheckedInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
		return super._submit(ctx, accInfo);
	}

	/**
	 * 审核通过
	 */
	protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		ForiCheckedInfo info = (ForiCheckedInfo) getValue(ctx, pk, getSelector());
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
		// writePersonHistoryInfo(ctx, info, true);
	}

	/**
	 * 审核不通过
	 */
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		ForiCheckedInfo info = (ForiCheckedInfo) getValue(ctx, pk, getSelector());
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
	// private void writeBack(Context ctx, ForiCheckedInfo info, boolean audit)
	// throws EASBizException, BOSException {
	// // 反写参保人员
	// writeBackIns(ctx, info, audit);
	// }
	/**
	 * 反写参保人员
	 */
	private void writeBackIns(Context ctx, ForiCheckedInfo info, boolean audit) throws BOSException, EASBizException {
		ForiCheckedEntryCollection foriEntryCol = info.getEntrys();
		for (int i = 0; i < foriEntryCol.size(); i++) {
			ForiCheckedEntryInfo entryInfo = foriEntryCol.get(i);
			String personID = entryInfo.getPersonID();
			// String foriPersId = entryInfo.getForiPersID();
			FilterInfo filter = new FilterInfo();
			EntityViewInfo view = new EntityViewInfo();
			filter.getFilterItems().add(new FilterItemInfo("personID", personID));
			view.setFilter(filter);
			ForiPersEntryInfo insEntryInfo = ForiPersEntryFactory.getLocalInstance(ctx).getForiPersEntryCollection(view).get(0);
			if (audit) {
				if (insEntryInfo != null) {
					insEntryInfo.setForiPersID(entryInfo.getForiPersID());
					insEntryInfo.setSecurityNo(entryInfo.getSecuNum());// 社保号
					insEntryInfo.setEndDate(entryInfo.getEndDate());// 离场日期
					insEntryInfo.setForiPersID(entryInfo.getForiPersID());// 外会人员编码
					// insEntryInfo.setCCPNo(entryInfo.getCCPNo());//CCP账户
					SelectorItemCollection sic = new SelectorItemCollection();
					sic.add("foriPersID");
					sic.add("securityNo");
					sic.add("endDate");
					// sic.add("CCPNo");
					ForiPersEntryFactory.getLocalInstance(ctx).updatePartial(insEntryInfo, sic);
				}
			}
		}
	}

	/**
	 * 反写属地化信息录入
	 */
	// private void writePersonHistoryInfo(Context ctx, ForiCheckedInfo info,
	// boolean audit) throws BOSException, EASBizException{
	// ForiCheckedEntryCollection foriEntryCol = info.getEntrys();
	// for (int i = 0; i < foriEntryCol.size(); i++) {
	// ForiCheckedEntryInfo entryInfo = foriEntryCol.get(i);
	// String personID = entryInfo.getPersonID();
	// FilterInfo filter = new FilterInfo();
	// EntityViewInfo view = new EntityViewInfo();
	// filter.getFilterItems().add(new FilterItemInfo("sourceBillId",personID));
	// view.setFilter(filter);
	// PersonHistoryInfo phInfo=PersonHistoryFactory.getLocalInstance(ctx).
	// getPersonHistoryCollection(view).get(0);
	// if(phInfo!=null){
	// //phInfo.setForiPersID(entryInfo.getForiPersID());//外会人员编号
	// phInfo.setSecurityNo(entryInfo.getSecuNum());//社保号
	// //phInfo.setEndDate(entryInfo.getEndDate());//离场日期
	// //liEntryInfo.setCCPNo(entryInfo.getCCPNo());//CCP账户
	// SelectorItemCollection sic = new SelectorItemCollection();
	// sic.add("securityNo");
	// // sic.add("foriPersID");
	// // sic.add("endDate");
	// // sic.add("CCPNo");
	// PersonHistoryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);
	// }
	// }
	// }
	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("entrys.*");
		return sic;
	}

	protected IObjectValue _initBill(Context ctx, String infoId) throws BOSException, EASBizException {
		ForiCheckedInfo info = new ForiCheckedInfo();
		
		// 获取社保项目
		SelectorItemCollection sic2 = new SelectorItemCollection();
		sic2.add(new SelectorItemInfo("id"));
		sic2.add(new SelectorItemInfo("number"));
		sic2.add(new SelectorItemInfo("name"));
		AdminOrgUnitInfo adminInfo = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(infoId), sic2);
		
		// 查询参保名单中勾选参保的数据
		ForiPersEntryCollection insPersEntryCol = getAlg(ctx, adminInfo);

		// 表头字段赋值
		info.setId(BOSUuid.create(info.getBOSType()));

		// 分录赋值
		for (int i = 0; i < insPersEntryCol.size(); i++) {
			ForiCheckedEntryInfo etyInfo = new ForiCheckedEntryInfo();
			ForiPersEntryInfo insPersEntryInfo = insPersEntryCol.get(i);
			if (insPersEntryInfo.getWorkProgram() != null && insPersEntryInfo.getWorkProgram().getId() != null) {
				AdminOrgUnitInfo workPInfo = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(insPersEntryInfo.getWorkProgram().getId()));
				etyInfo.setWorkProgram(workPInfo);// 工作项目
			}
			if (insPersEntryInfo.getCooperation() != null && insPersEntryInfo.getCooperation().getId() != null) {
				AdminOrgUnitInfo cooperation = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(insPersEntryInfo.getCooperation().getId()));
				etyInfo.setCooperation(cooperation);// 合作单位
			}
			if (insPersEntryInfo.getSecuProf() != null) {
				ProjSecuProfInfo pspInfo = ProjSecuProfFactory.getLocalInstance(ctx).getProjSecuProfInfo(new ObjectUuidPK(insPersEntryInfo.getSecuProf() == null ? null : insPersEntryInfo.getSecuProf().getId()));
				etyInfo.setSecuProf(pspInfo);// 社保工种
			}
			// ProjectWorkInfo projInfo =
			// ProjectWorkFactory.getLocalInstance(ctx).getProjectWorkInfo(new
			// ObjectUuidPK(insPersEntryInfo.getProf() == null ? null :
			// insPersEntryInfo.getProf().getId()));
			etyInfo.setProjSocialNo(insPersEntryInfo.getProjSocialNo());
			etyInfo.setPersonID(insPersEntryInfo.getPersonID());// 人员主键
			etyInfo.setForiPersID(insPersEntryInfo.getForiPersID());// 外会人员编码
			etyInfo.setLastName(insPersEntryInfo.getFirstNameApl());// 姓
			etyInfo.setFirstName(insPersEntryInfo.getLastNameApl());// 名
			if (insPersEntryInfo.getCountry() != null) {
				CountryInfo country = CountryFactory.getLocalInstance(ctx).getCountryInfo(new ObjectUuidPK(insPersEntryInfo.getCountry() == null ? null : insPersEntryInfo.getCountry().getId()));
				etyInfo.setNation(country);// 国籍
			}
			etyInfo.setSex(insPersEntryInfo.getSex());// 性别
			etyInfo.setBirthdate(insPersEntryInfo.getBirthdate());// 出生日期
			etyInfo.setBirthPlace(insPersEntryInfo.getBirthPlaceCn());// 出生地
			etyInfo.setMariState(insPersEntryInfo.getMaritalStatus());// 婚姻状况
			etyInfo.setSecuNum(insPersEntryInfo.getSecurityNo());// 社保号码
			etyInfo.setCoopCode(insPersEntryInfo.getCooperationId());// 合作单位代码
			etyInfo.setApprTime(insPersEntryInfo.getApproachTime());// 进场日期
			// etyInfo.setSecuProj(insPersEntryInfo.getSecuProj());// 社保
			etyInfo.setStartDate(insPersEntryInfo.getApproachTime());// 注册日期
			etyInfo.setEndDate(insPersEntryInfo.getEndDate());// 离场日期
			etyInfo.setNBasePay(insPersEntryInfo.getNBasePay());// 基本工资
			info.getEntrys().add(etyInfo);
		}
		
		// 更新参保人数
		getAlgAll(ctx, info, infoId);

		return info;
	}

	private void getAlgAll(Context ctx, ForiCheckedInfo info, String infoId) throws BOSException, EASBizException {
		//赋值因参保人数
		ForiCheckedInfo foriCheckedInfo = info;
		SelectorItemCollection sic = new SelectorItemCollection();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("join", true));
		filter.getFilterItems().add(new FilterItemInfo("endDate", null, CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("secilProgram.id", infoId));
		EntityViewInfo view = new EntityViewInfo();
		sic.add("entrys.*");
		sic.add("*");
		view.setSelector(sic);
		view.setFilter(filter);
		ForiPersEntryCollection insPersCol = ForiPersEntryFactory.getLocalInstance(ctx).getForiPersEntryCollection(view);
		foriCheckedInfo.setShCount(insPersCol.size());
		
		// 赋值社保项目
		SelectorItemCollection sic2 = new SelectorItemCollection();
		sic2.add(new SelectorItemInfo("id"));
		sic2.add(new SelectorItemInfo("number"));
		sic2.add(new SelectorItemInfo("name"));
		AdminOrgUnitInfo adminInfo = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(infoId), sic2);
		foriCheckedInfo.setPermProj(adminInfo);
		
		//更新赋值项
		SelectorItemCollection sic1 = new SelectorItemCollection();
		sic1.add("shCount");
		sic1.add("permProj");
		ForiCheckedFactory.getLocalInstance(ctx).updatePartial(foriCheckedInfo, sic1);
	}

	/**
	 * 查询参保名单中勾选参保的数据
	 * 
	 * @param ctx
	 * @param adminInfo2
	 * 
	 * @throws BOSException
	 */
	private ForiPersEntryCollection getAlg(Context ctx, AdminOrgUnitInfo admin) throws BOSException {
		AdminOrgUnitInfo adminInfo = admin;
		SelectorItemCollection sic = new SelectorItemCollection();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("join", true));
		filter.getFilterItems().add(new FilterItemInfo("endDate", null, CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("secilProgram.id", adminInfo.getId()));
		EntityViewInfo view = new EntityViewInfo();
		sic.add("*");
		view.setSelector(sic);
		view.setFilter(filter);
		ForiPersEntryCollection insPersCol = ForiPersEntryFactory.getLocalInstance(ctx).getForiPersEntryCollection(view);
		return insPersCol;
	}

}