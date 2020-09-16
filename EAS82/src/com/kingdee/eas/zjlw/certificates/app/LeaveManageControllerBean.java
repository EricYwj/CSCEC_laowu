package com.kingdee.eas.zjlw.certificates.app;

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
import com.kingdee.bos.metadata.MetaDataPK; // import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean; // import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.AntiLogoutInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.ExilivepermitFactory;
import com.kingdee.eas.zjlw.certificates.ExilivepermitInfo;
import com.kingdee.eas.zjlw.certificates.IfilentryFactory;
import com.kingdee.eas.zjlw.certificates.IfilentryInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationFactory;
import com.kingdee.eas.zjlw.certificates.ImmigrationInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryCollection;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitInfo;
import com.kingdee.eas.zjlw.certificates.PassportapplyFactory;
import com.kingdee.eas.zjlw.certificates.PassportapplyInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryCollection;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryFactory;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleFactory;
import com.kingdee.eas.zjlw.certificates.VisaHandleInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.zjlw.certificates.LeaveManageInfo;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryFactory;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryInfo;

import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LeaveManageControllerBean extends AbstractLeaveManageControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.LeaveManageControllerBean");

	// 保存
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		LeaveManageInfo accInfo = (LeaveManageInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		// 设置编码
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //不允许断号
		// if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
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
		LeaveManageInfo accInfo = (LeaveManageInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
		// 设置编码
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //不允许断号
		// if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
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

	// 审核通过
	protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		LeaveManageInfo info = (LeaveManageInfo) getValue(ctx, pk, getSelector());

		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("billSate", "40"));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("所选行已存在审核通过的数据，不能审核！");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		updatePerHis(ctx, info, true);
		changeState(info, ctx, true);
		updateLeaveTime(ctx, info, true);
	}

	/**
	 * 离境审核通过人员反写反签办理，修改分录‘人员状态’为已注销，反之为反签办理 ywj 2016-11-8
	 * 
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void updateLeaveTime(Context ctx, LeaveManageInfo info, boolean audit) throws BOSException, EASBizException {
		LeaveManageEntryCollection entryCol = info.getEntrys();
		LeaveManageEntryInfo entryInfo = new LeaveManageEntryInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("leaveTime");
		Set passportNo = new HashSet();
		for (int i = 0; i < entryCol.size(); i++) {
			entryInfo = entryCol.get(i);
			String id = entryInfo.getPersonID();
			Date leaveTime = entryInfo.getDptrTime();
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("personID", id));
			view.setFilter(filter);
			// --------------更新工作签信息录入中的离境时间
			/*
			 * ywj 2018-6-8 工作签中添加personid字段，此处直接使用personid查询 EntityViewInfo view1 = new EntityViewInfo(); FilterInfo filter1 = new FilterInfo(); filter1.getFilterItems().add(new FilterItemInfo("id",id)); view1.setFilter(filter1);
			 */
			WorkVisaEntryCollection wkvCol = WorkVisaEntryFactory.getLocalInstance(ctx).getWorkVisaEntryCollection(view);
			for (int j = 0; j < wkvCol.size(); j++) {
				WorkVisaEntryInfo etyInfo = wkvCol.get(i);
				if (etyInfo != null && audit) {
					etyInfo.setLeaveTime(leaveTime);
				} else {
					etyInfo.setLeaveTime(null);
				}
				WorkVisaEntryFactory.getLocalInstance(ctx).updatePartial(etyInfo, sic);
			}

			// ywj add 2017-11-27==============================================================================BEGIN
			// --------------更新签证办理中的离境时间
			VisaHandleEntryCollection visaCol = VisaHandleEntryFactory.getLocalInstance(ctx).getVisaHandleEntryCollection(view);
			for (int j = 0; j < visaCol.size(); j++) {
				VisaHandleEntryInfo visaEtyInfo = visaCol.get(i);
				if (visaEtyInfo != null && audit) {
					visaEtyInfo.setLeaveTime(leaveTime);
				} else {
					visaEtyInfo.setLeaveTime(null);
				}
				VisaHandleEntryFactory.getLocalInstance(ctx).updatePartial(visaEtyInfo, sic);
			}
			// ywj add 2017-11-27==============================================================================END

			// --------------更新反签中的离境时间
			AntiSignedEntryCollection antiCol = AntiSignedEntryFactory.getLocalInstance(ctx).getAntiSignedEntryCollection(view);
			for (int j = 0; j < antiCol.size(); j++) {
				AntiSignedEntryInfo antietyInfo = antiCol.get(i);
				if (antietyInfo != null && audit) {
					antietyInfo.setLeaveTime(leaveTime);
				} else {
					antietyInfo.setLeaveTime(null);
				}
				AntiSignedEntryFactory.getLocalInstance(ctx).updatePartial(antietyInfo, sic);
			}
			// --------------更新劳动证办理中的离境时间
			WorkPmtEntryCollection wpEtyCol = WorkPmtEntryFactory.getLocalInstance(ctx).getWorkPmtEntryCollection(view);
			for (int k = 0; k < wpEtyCol.size(); k++) {
				WorkPmtEntryInfo wpEtyInfo = wpEtyCol.get(k);
				if (wpEtyInfo != null && audit) {
					wpEtyInfo.setLeaveTime(leaveTime);
				} else {
					wpEtyInfo.setLeaveTime(null);
				}
				WorkPmtEntryFactory.getLocalInstance(ctx).updatePartial(wpEtyInfo, sic);
			}
			// --------------更新居住证办理中的离境时间
			LivepermitEntryCollection lpEtyCol = LivepermitEntryFactory.getLocalInstance(ctx).getLivepermitEntryCollection(view);
			for (int k = 0; k < lpEtyCol.size(); k++) {
				LivepermitEntryInfo lpEtyInfo = lpEtyCol.get(k);
				if (lpEtyInfo != null && audit) {
					lpEtyInfo.setLeaveTime(leaveTime);
				} else {
					lpEtyInfo.setLeaveTime(null);
				}
				LivepermitEntryFactory.getLocalInstance(ctx).updatePartial(lpEtyInfo, sic);
			}
		}
	}

	private void updatePerHis(Context ctx, LeaveManageInfo info, boolean audit) throws BOSException, EASBizException {
		LeaveManageEntryCollection entryCol = info.getEntrys();
		LeaveManageEntryInfo entryInfo = new LeaveManageEntryInfo();
		Set idNum = new HashSet();
		Set passportNo = new HashSet();
		for (int i = 0; i < entryCol.size(); i++) {
			entryInfo = entryCol.get(i);
			if (entryInfo.getQuProf() != null && entryInfo.getQuProf().getId() != null) {
				writeProjectWork(ctx, entryInfo.getQuProf().getId().toString(), audit);// 释放指标
			}
			EntityViewInfo view = new EntityViewInfo();
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("bsnisState");
			sic.add("hBsnisState");
			FilterInfo filter = new FilterInfo();
			// filter.getFilterItems().add(new FilterItemInfo("idNum", entryInfo.getIdNum() == null ? null : entryInfo.getIdNum().toString()));
			// filter.getFilterItems().add(new FilterItemInfo("passportNo", entryInfo.getPasspNum() == null ? null : entryInfo.getPasspNum().toString()));
			filter.getFilterItems().add(new FilterItemInfo("sourceBillId", entryInfo.getPersonID()));
			view.setFilter(filter);
			view.setSelector(sic);
			PersonHistoryCollection personCol = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
			for (int j = 0; j < personCol.size(); j++) {
				PersonHistoryInfo newper = personCol.get(j);
				perBizStateEnum hState = newper.getHBsnisState();
				newper.setHBsnisState(newper.getBsnisState());
				newper.setBsnisState(audit ? perBizStateEnum.DEPARTURE : perBizStateEnum.APPLEAVE);
				if (audit) {
					newper.setBsnisState(perBizStateEnum.DEPARTURE);
				} else {
					if (leaveTypeEnum.WORKNO.equals(entryInfo.getLeaveType()) || leaveTypeEnum.WORKSTOP.equals(entryInfo.getLeaveType())) {
						newper.setBsnisState(perBizStateEnum.WORKPERMIT);
					} else if (leaveTypeEnum.LEAVENO.equals(entryInfo.getLeaveType()) || leaveTypeEnum.LEAVESTOP.equals(entryInfo.getLeaveType())) {
						newper.setBsnisState(perBizStateEnum.RESIDENCE);
					} else {
						newper.setBsnisState(perBizStateEnum.APPLEAVE);
					}
				}
				PersonHistoryFactory.getLocalInstance(ctx).updatePartial(newper, sic);
			}
		}
	}

	/**
	 * 更改指标数量
	 * 
	 * @param ctx
	 * @param id
	 * @param isAudit
	 * @throws EASBizException
	 * @throws BOSException
	 */
	private void writeProjectWork(Context ctx, String id, boolean audMark) throws EASBizException, BOSException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("useAmount");
		sic.add("leftAmount");
		sic.add("totalAmount");
		if (id != null && !"".equals(id)) {
			ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx).getProjectWorkInfo(new ObjectUuidPK(id), sic);
			if (audMark) {// 非正常状态，审核通过；或注销，释放指标，工种使用数量减一
				pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
			} else {// 非正常状态，反审核通过，释放指标，工种使用数量加一
				pwInfo.setUseAmount(pwInfo.getUseAmount() + 1);
			}
			pwInfo.setLeftAmount(pwInfo.getTotalAmount() - pwInfo.getUseAmount());
			ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
		}

	}

	// 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		LeaveManageInfo info = (LeaveManageInfo) getValue(ctx, pk, getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("billSate", "30", CompareType.NOTEQUALS));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("所选行已存在审核通过的数据，不能审核！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		updatePerHis(ctx, info, false);
		changeState(info, ctx, false);
		updateLeaveTime(ctx, info, false);
	}

	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		sic.add("sourceBillId");
		sic.add("id");
		return sic;
	}

	/**
	 * 更新上游单据业务状态
	 * <ul>
	 * 【2018-11-14 更新逻辑 ywj】
	 * <li>分录一条：直接更新单据状态；
	 * <li>分录多条：若存在'离境时间'为空的分录，则不更新单据状态，若所有分录‘离境时间’都有值，则更新单据状态
	 * <li>审核：进行判断，反审核：无论何种情况，都变为审核通过状态<ul/>
	 * 
	 * @param entryInfo
	 * @param ctx
	 * @param type
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void changeState(LeaveManageInfo info, Context ctx, boolean isAudit) throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		if (info.getSourceBillId() != null && !"".equals(info.getSourceBillId())) {
			String bosobjecttype = BOSUuid.read(info.getSourceBillId()).getType().toString();
			if ("A3BABFEC".equals(bosobjecttype)) {// 上游单据为离境申请
				// 离境申请改为已离境
				ExilivepermitInfo exiInfo = ExilivepermitFactory.getLocalInstance(ctx).getExilivepermitInfo(new ObjectUuidPK(info.getSourceBillId()));
				exiInfo.setBillSate(isAudit ? BillStateEnum.LEAVE : BillStateEnum.CHECKED);
				ExilivepermitFactory.getLocalInstance(ctx).updatePartial(exiInfo, sic);
				// 居住证办理改为注销
				LivepermitInfo liveInfo = LivepermitFactory.getLocalInstance(ctx).getLivepermitInfo(new ObjectUuidPK(exiInfo.getSourceBillId()));
				if (isAudit) {
					if (liveInfo.getEntrys().size() > 1) {
						if (checkEty(liveInfo, ctx)) {
							liveInfo.setBillSate(BillStateEnum.DSTRY);
							LivepermitFactory.getLocalInstance(ctx).updatePartial(liveInfo, sic);
						}
					} else {
						liveInfo.setBillSate(BillStateEnum.DSTRY);
						LivepermitFactory.getLocalInstance(ctx).updatePartial(liveInfo, sic);
					}
				} else {
					liveInfo.setBillSate(BillStateEnum.CHECKED);
					LivepermitFactory.getLocalInstance(ctx).updatePartial(liveInfo, sic);
				}
			} else if ("B6FEE918".equals(bosobjecttype)) {// 上游单据为居住证办理
				// 居住证办理改为注销
				LivepermitInfo liveInfo = LivepermitFactory.getLocalInstance(ctx).getLivepermitInfo(new ObjectUuidPK(info.getSourceBillId()));
				if (isAudit) {
					if (liveInfo.getEntrys().size() > 1) {
						if (checkEty(liveInfo, ctx)) {
							liveInfo.setBillSate(BillStateEnum.DSTRY);
							LivepermitFactory.getLocalInstance(ctx).updatePartial(liveInfo, sic);
						}
					} else {
						liveInfo.setBillSate(BillStateEnum.DSTRY);
						LivepermitFactory.getLocalInstance(ctx).updatePartial(liveInfo, sic);
					}
				} else {
					liveInfo.setBillSate(BillStateEnum.CHECKED);
					LivepermitFactory.getLocalInstance(ctx).updatePartial(liveInfo, sic);
				}
			}
		}
	}

	/**
	 * 判断分录中离境时间是否有值
	 * 
	 * @param ctx
	 * @param liveInfo
	 * @return true:所有-1 的分录全部有离境时间，则说明此条为最后一条离境数据，则更新单据状态 false:并不是所有人都离境，不更新
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private boolean checkEty(LivepermitInfo liveInfo, Context ctx) throws EASBizException, BOSException {
		LivepermitEntryCollection etyCol = liveInfo.getEntrys();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("id");
		sic.add("name");
		sic.add("number");
		sic.add("leaveTime");
		int intMark = 0;
		if (etyCol != null && etyCol.size() > 0) {
			for (int i = 0; i < etyCol.size(); i++) {
				LivepermitEntryInfo etyInfo = etyCol.get(i);
				LivepermitEntryInfo etyInfoWithLeaveTime = LivepermitEntryFactory.getLocalInstance(ctx).getLivepermitEntryInfo(new ObjectUuidPK(etyInfo.getId()), sic);
				if (etyInfoWithLeaveTime.getLeaveTime() == null)
					intMark++;
			}
		}
		if (intMark == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * // * 反写劳动证办理分录字段离境日期 // * @param ctx // * @param info // * @param isAudit // * @throws BOSException // * @throws EASBizException //
	 */
	// private void updateWorkPmt(Context ctx, LeaveManageInfo info, boolean isAudit) throws BOSException, EASBizException {
	// LeaveManageEntryCollection col = info.getEntrys();
	// if(col != null && col.size() > 0){
	// for (int j = 0; j < col.size(); j++) {
	// LeaveManageEntryInfo etyInfo = col.get(j);
	// String id = etyInfo.getPersonID();
	// Date leaveTime = etyInfo.getDptrTime();
	// FilterInfo filter = new FilterInfo();
	// filter.getFilterItems().add(new FilterItemInfo("personID",id));
	// EntityViewInfo view = new EntityViewInfo();
	// view.setFilter(filter);
	// SelectorItemCollection sic1 = new SelectorItemCollection();
	// sic1.add("leaveTime");
	// view.setSelector(sic1);
	// WorkPmtEntryCollection wpEtyCol = WorkPmtEntryFactory.getLocalInstance(ctx).getWorkPmtEntryCollection(view);
	// for (int i = 0; i < wpEtyCol.size(); i++) {
	// WorkPmtEntryInfo wpEtyInfo = wpEtyCol.get(i);
	// if (isAudit) {
	// wpEtyInfo.setLeaveTime(leaveTime);
	// WorkPmtEntryFactory.getLocalInstance(ctx).updatePartial(wpEtyInfo, sic1);
	// }else{
	// wpEtyInfo.setLeaveTime(null);
	// WorkPmtEntryFactory.getLocalInstance(ctx).updatePartial(wpEtyInfo, sic1);
	// }
	// }
	// }
	// }
	// }
}