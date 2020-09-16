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
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
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

import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelEntryInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelFactory;
import com.kingdee.eas.zjlw.certificates.ASCancelInfo;
import com.kingdee.eas.zjlw.certificates.AntiLogoutCollection;
import com.kingdee.eas.zjlw.certificates.AntiLogoutEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiLogoutEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.IfilentryFactory;
import com.kingdee.eas.zjlw.certificates.IfilentryInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationCollection;
import com.kingdee.eas.zjlw.certificates.ImmigrationFactory;
import com.kingdee.eas.zjlw.certificates.ImmigrationInfo;
import com.kingdee.eas.zjlw.certificates.PassportapplyCollection;
import com.kingdee.eas.zjlw.certificates.PassportapplyFactory;
import com.kingdee.eas.zjlw.certificates.PassportapplyInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleCollection;
import com.kingdee.eas.zjlw.certificates.VisaHandleFactory;
import com.kingdee.eas.zjlw.certificates.VisaHandleInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.zjlw.certificates.AntiLogoutInfo;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AntiLogoutControllerBean extends AbstractAntiLogoutControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.AntiLogoutControllerBean");
 // 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		AntiLogoutInfo accInfo = (AntiLogoutInfo) model;
		accInfo.setBillState(BillStateEnum.DRAFT);
		// 设置编码
//		if (accInfo.getNumber() == null || "".equals(accInfo.getNumber())) {
//			CompanyOrgUnitInfo currentCompany = ContextHelperFactory
//					.getLocalInstance(ctx).getCurrentCompany();
//			String orgId = currentCompany.getId().toString();
//			ICodingRuleManager codFactory = CodingRuleManagerFactory
//					.getLocalInstance(ctx);
//			if (codFactory.isExist(accInfo, orgId)) {
//				// 不允许断号
//				if (codFactory.isUseIntermitNumber(accInfo, orgId)
//						&& (!codFactory.isUserSelect(accInfo, orgId))) {
//					accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//				} else {
//					if (codFactory.isAddView(accInfo, orgId)) {// 新增显示
//
//					} else {// 什么都没勾选
//						accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//					}
//				}
//			}
//		}
		return super._save(ctx, accInfo);
	}

	// 提交
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		AntiLogoutInfo accInfo = (AntiLogoutInfo) model;
		accInfo.setBillState(BillStateEnum.SUBMIT);
//		// 设置编码
//		if (accInfo.getNumber() == null || "".equals(accInfo.getNumber())) {
//			CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
//			String orgId = currentCompany.getId().toString();
//			ICodingRuleManager codFactory = CodingRuleManagerFactory
//					.getLocalInstance(ctx);
//			if (codFactory.isExist(accInfo, orgId)) {
//				// 不允许断号
//				if (codFactory.isUseIntermitNumber(accInfo, orgId)
//						&& (!codFactory.isUserSelect(accInfo, orgId))) {
//					accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//				} else {
//					if (codFactory.isAddView(accInfo, orgId)) {// 新增显示
//
//					} else {// 什么都没勾选
//						accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//					}
//				}
//			}
//		}
		return super._submit(ctx, accInfo);
	}

	// 审核通过
	protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
		AntiLogoutInfo info = (AntiLogoutInfo) getValue(ctx, pk, getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("billState", "40"));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("所选行已存在审核通过的数据，不能审核！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billState");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillState(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeBack(ctx, info, true);
		changeState(info,ctx,true);//更新上游单据业务状态
	}

	// 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
		AntiLogoutInfo info = (AntiLogoutInfo) getValue(ctx, pk, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billState");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillState(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);

		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeBack(ctx, info, false);
		changeState(info,ctx,false);//更新上游单据业务状态
	} 
	
	/**
	 * 回写数据
	 * 
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeBack(Context ctx, AntiLogoutInfo info, boolean audMark)throws BOSException, EASBizException {
		AntiLogoutEntryCollection entryCol = info.getEntrys();
		for (int i = 0; i < entryCol.size(); i++) {
			AntiLogoutEntryInfo entryInfo = entryCol.get(i);
			writeProjectWork(ctx, entryInfo.getQuProf().getId().toString(),audMark);//释放指标
			updatePerHis(ctx, entryInfo, audMark);//更新人员状态
		}
		
	}
	
	/**
	 * 更新上游单据业务状态
	 * @param entryInfo
	 * @param ctx
	 * @param type
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	private void changeState(AntiLogoutInfo info, Context ctx,boolean isAudit) throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		if(info.getSourceBillId()!=null && !"".equals(info.getSourceBillId())){
			String bosobjecttype = BOSUuid.read(info.getSourceBillId()).getType().toString();
			if("EFBAA22F".equals(bosobjecttype)){//上游单据为反签
				AntiSignedInfo antiInfo = AntiSignedFactory.getLocalInstance(ctx).getAntiSignedInfo(new ObjectUuidPK(info.getSourceBillId()));
				antiInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
				AntiSignedFactory.getLocalInstance(ctx).updatePartial(antiInfo, sic);
			}else if("F224B6DA".equals(bosobjecttype)){//上游单据为签证（包括停办与不停办）
				//签证改为注销
				VisaHandleInfo visInfo = VisaHandleFactory.getLocalInstance(ctx).getVisaHandleInfo(new ObjectUuidPK(info.getSourceBillId()));
				visInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
				VisaHandleFactory.getLocalInstance(ctx).updatePartial(visInfo, sic);
				//反签改为注销
				AntiSignedInfo antiInfo = AntiSignedFactory.getLocalInstance(ctx).getAntiSignedInfo(new ObjectUuidPK(visInfo.getSourceBillId()));
				antiInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
				AntiSignedFactory.getLocalInstance(ctx).updatePartial(antiInfo, sic);
			}else if("DD9D3C39".equals(bosobjecttype)){//上游单据为入境
				//入境改为注销
				ImmigrationInfo immiInfo = ImmigrationFactory.getLocalInstance(ctx).getImmigrationInfo(new ObjectUuidPK(info.getSourceBillId()));
				immiInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
				ImmigrationFactory.getLocalInstance(ctx).updatePartial(immiInfo, sic);
				//签证改为注销
				VisaHandleInfo visInfo = VisaHandleFactory.getLocalInstance(ctx).getVisaHandleInfo(new ObjectUuidPK(immiInfo.getSourceBillId()));
				visInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
				VisaHandleFactory.getLocalInstance(ctx).updatePartial(visInfo, sic);
				//反签改为注销
				AntiSignedInfo antiInfo = AntiSignedFactory.getLocalInstance(ctx).getAntiSignedInfo(new ObjectUuidPK(visInfo.getSourceBillId()));
				antiInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
				AntiSignedFactory.getLocalInstance(ctx).updatePartial(antiInfo, sic);
			}else if("9E5937EB".equals(bosobjecttype)){//上游单据为申请护照发放
				//申请护照发票
				PassportapplyInfo passpInfo = PassportapplyFactory.getLocalInstance(ctx).getPassportapplyInfo(new ObjectUuidPK(info.getSourceBillId()));
				passpInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
				PassportapplyFactory.getLocalInstance(ctx).updatePartial(passpInfo, sic);
				String passpBosobjecttype = BOSUuid.read(passpInfo.getSourceBillId()).getType().toString();
				if("DD9D3C39".equals(passpBosobjecttype)){//上游单据为入境
					//入境改为注销
 					ImmigrationInfo objInfo = ImmigrationFactory.getLocalInstance(ctx).getImmigrationInfo(new ObjectUuidPK(passpInfo.getSourceBillId()));
					objInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
					ImmigrationFactory.getLocalInstance(ctx).updatePartial(objInfo, sic);
					//签证改为注销
					VisaHandleInfo visInfo = VisaHandleFactory.getLocalInstance(ctx).getVisaHandleInfo(new ObjectUuidPK(objInfo.getSourceBillId()));
					visInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
					VisaHandleFactory.getLocalInstance(ctx).updatePartial(visInfo, sic);
					//反签改为注销
					AntiSignedInfo antiInfo = AntiSignedFactory.getLocalInstance(ctx).getAntiSignedInfo(new ObjectUuidPK(visInfo.getSourceBillId()));
					antiInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
					AntiSignedFactory.getLocalInstance(ctx).updatePartial(antiInfo, sic);
				}else if("8E28A641".equals(passpBosobjecttype)){//上游单据为违规入境
					IfilentryInfo objInfo = IfilentryFactory.getLocalInstance(ctx).getIfilentryInfo(new ObjectUuidPK(passpInfo.getSourceBillId()));
					objInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
					IfilentryFactory.getLocalInstance(ctx).updatePartial(objInfo, sic);
					//入境改为注销
					ImmigrationInfo immiInfo = ImmigrationFactory.getLocalInstance(ctx).getImmigrationInfo(new ObjectUuidPK(objInfo.getSourceBillId()));
					immiInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
					ImmigrationFactory.getLocalInstance(ctx).updatePartial(immiInfo, sic);
					//签证改为注销
					VisaHandleInfo visInfo = VisaHandleFactory.getLocalInstance(ctx).getVisaHandleInfo(new ObjectUuidPK(immiInfo.getSourceBillId()));
					visInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
					VisaHandleFactory.getLocalInstance(ctx).updatePartial(visInfo, sic);
					//反签改为注销
					AntiSignedInfo antiInfo = AntiSignedFactory.getLocalInstance(ctx).getAntiSignedInfo(new ObjectUuidPK(visInfo.getSourceBillId()));
					antiInfo.setBillSate(isAudit?BillStateEnum.DSTRY:BillStateEnum.CHECKED);
					AntiSignedFactory.getLocalInstance(ctx).updatePartial(antiInfo, sic);
				}
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
	private void writeProjectWork(Context ctx, String id, boolean audMark)throws EASBizException, BOSException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("name");
		sic.add("useAmount");
		sic.add("leftAmount");
		sic.add("totalAmount");
		if (id != null && !"".equals(id)) {
			ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx).getProjectWorkInfo(new ObjectUuidPK(id), sic);
			if (audMark) {//审核通过，释放指标，工种使用数量减一
				pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
			} else {//反审核通过，重新占用指标，工种使用数量加一
				if(pwInfo.getLeftAmount()<1){
					throw new EASBizException(new NumericExceptionSubItem("0001","指标工种【"+pwInfo.getName()+"】额度不足，不允许反审核！"));
				}
				
				pwInfo.setUseAmount(pwInfo.getUseAmount() + 1);
			}
			pwInfo.setLeftAmount(pwInfo.getTotalAmount()- pwInfo.getUseAmount());
			ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
		}
		
	}


	/**
	 * 更新人员信息表的人员状态
	 * 
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	private void updatePerHis(Context ctx,AntiLogoutEntryInfo entryInfo, boolean audMark) throws BOSException, EASBizException {
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		//filter.getFilterItems().add(new FilterItemInfo("idNum",entryInfo.getIdNum()));
		//filter.getFilterItems().add(new FilterItemInfo("passportNo",entryInfo.getPasspNum()));
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId",entryInfo.getPersonID()));
//		filter.setMaskString("#0 or #1");
		view.setFilter(filter);
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("bsnisState");
		sic.add("hBsnisState");
		view.setSelector(sic);
		PersonHistoryCollection personCol = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
		for(int i=0;i<personCol.size();i++){
			PersonHistoryInfo newper =personCol.get(i);
			perBizStateEnum hState = newper.getHBsnisState();
			newper.setHBsnisState(newper.getBsnisState());
			if(audMark){//审核通过
				if(logoutTypeEnum.ANTIOVER.equals(entryInfo.getLogoutType())){
					newper.setBsnisState(perBizStateEnum.ANTIDSTRY);//反签注销
				}else if(logoutTypeEnum.VISAOVER.equals(entryInfo.getLogoutType())){
					newper.setBsnisState(perBizStateEnum.VISADSTRY);//签证注销
				}else if(logoutTypeEnum.VISASTOP.equals(entryInfo.getLogoutType())){
					newper.setBsnisState(perBizStateEnum.VISASTOP);//签证停办
				}else if(logoutTypeEnum.IMMISTOP.equals(entryInfo.getLogoutType())){
					newper.setBsnisState(perBizStateEnum.IMMIGRATIONSTOP);//入境停办
				}else if(logoutTypeEnum.PASSPNOGET.equals(entryInfo.getLogoutType())){
					newper.setBsnisState(perBizStateEnum.PASSPORTISSUEDSTOP);//护照发放停办
				}
			}else{//反审核
				if(logoutTypeEnum.ANTIOVER.equals(entryInfo.getLogoutType())){
					newper.setBsnisState(perBizStateEnum.ANTISIGNED);//反签
				}else if(logoutTypeEnum.VISAOVER.equals(entryInfo.getLogoutType())){
					newper.setBsnisState(perBizStateEnum.VISA);//签证
				}else if(logoutTypeEnum.VISASTOP.equals(entryInfo.getLogoutType())){
					newper.setBsnisState(perBizStateEnum.VISA);//签证
				}else if(logoutTypeEnum.IMMISTOP.equals(entryInfo.getLogoutType())){
					newper.setBsnisState(perBizStateEnum.IMMIGRATION);//申请入境
				}else if(logoutTypeEnum.PASSPNOGET.equals(entryInfo.getLogoutType())){
					newper.setBsnisState(perBizStateEnum.PASSPORTISSUED);//护照发放
				}
			}
			PersonHistoryFactory.getLocalInstance(ctx).updatePartial(newper, sic);
		}
	}
	
	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("sourceBillId");
		sic.add("billState");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		return sic;
	}
}