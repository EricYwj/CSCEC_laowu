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
import com.kingdee.bos.metadata.MetaDataPK; //import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean; //import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelEntryCollection;
import com.kingdee.eas.zjlw.certificates.ASCancelEntryInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelFactory;
import com.kingdee.eas.zjlw.certificates.ASCancelInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryCollection;
import com.kingdee.eas.zjlw.certificates.VisaHandleInfo;
import com.kingdee.eas.fm.nt.client.NTWarnLedgerUIHandler.EntryInfo;
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
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnit;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.person.PersonStates;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AntiSignedControllerBean extends AbstractAntiSignedControllerBean {
	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.zjlw.certificates.app.AntiSignedControllerBean");

	// 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		AntiSignedInfo accInfo = (AntiSignedInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
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
	protected IObjectPK _submit(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		AntiSignedInfo accInfo = (AntiSignedInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
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
		AntiSignedInfo info = (AntiSignedInfo) getValue(ctx, pk, getSelector());
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
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),
				pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeBack(ctx, info, true,false);

	}

	// 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
		AntiSignedInfo info = (AntiSignedInfo) getValue(ctx, pk, getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(
				new FilterItemInfo("billSate", "30", CompareType.NOTEQUALS));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("所选行在审核不通过中");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(),
				pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);

		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeBack(ctx, info, false,false);
	}
//	
//	protected void _logOut(Context ctx, IObjectPK pk) throws BOSException,EASBizException {
//		AntiSignedInfo info = (AntiSignedInfo) getValue(ctx, pk, getSelector());
//		//校验是否为审核通过状态
//		FilterInfo filter = new FilterInfo();
//		filter.getFilterItems().add(new FilterItemInfo("billSate", "40", CompareType.NOTEQUALS));
//		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
//		if (super._exists(ctx, filter)) {
//			try {
//				throw new Exception("非审核通过状态，不允许注销！");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		//更新单据状态为注销
//		SelectorItemCollection sic = new SelectorItemCollection();
//		sic.add("billSate");
//		info.setBillSate(BillStateEnum.DSTRY);
//		updatePartial(ctx, info, sic);
//		//更新人员状态为注销,释放指标
//		writeBack(ctx, info, true,true);
//	}
//	/**
//	 * 注销
//	 *	1.更改单据状态为注销 	
//	 * 	2.更新人员状态为注销
//	 * 	3.释放指标
//	 * @throws EASBizException 
//	 */
////	public void logOut(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
////		AntiSignedInfo info = (AntiSignedInfo) getValue(ctx, pk, getSelector());
////		//校验是否为审核通过状态
////		FilterInfo filter = new FilterInfo();
////		filter.getFilterItems().add(new FilterItemInfo("billSate", "40", CompareType.NOTEQUALS));
////		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
////		if (super._exists(ctx, filter)) {
////			try {
////				throw new Exception("非审核通过状态，不允许注销！");
////			} catch (Exception e) {
////				e.printStackTrace();
////			}
////		}
////		//更新单据状态为注销
////		SelectorItemCollection sic = new SelectorItemCollection();
////		sic.add("billSate");
////		info.setBillSate(BillStateEnum.DSTRY);
////		updatePartial(ctx, info, sic);
////		//更新人员状态为注销,释放指标
////		writeBack(ctx, info, true,true);
////	}
//	
//	
	/**
	 * 回写数据
	 * 
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeBack(Context ctx, AntiSignedInfo info, boolean audMark,boolean logoutMark)throws BOSException, EASBizException {
		AntiSignedEntryCollection entryCol = info.getEntrys();
		AntiSignedEntryInfo entryInfo = new AntiSignedEntryInfo();
		boolean cancelSta = true;
		boolean isLogout = true;
		for (int i = 0; i < entryCol.size(); i++) {
			entryInfo = entryCol.get(i);
			cancelSta = entryInfo.isIsCancel();
			isLogout = entryInfo.isIsLogout();
			if(!cancelSta && !isLogout) {// 正常状态
				updatePerHis(ctx,entryInfo,true,true,audMark);//更新人员状态
			}else {
				//停办
				if(cancelSta){
					if (audMark) {// 审核通过，回写反签停办人员表
						writeAntipers(ctx, info, entryInfo);
					}else{//反审核
						deletePersonHis(ctx, info.getId().toString());// 删除停办人员信息表中的数据
					}
				}
				writeProjectWork(ctx, entryInfo.getQuProf().getId().toString(),audMark);//释放指标
				updatePerHis(ctx,entryInfo,false,cancelSta, audMark);//更新人员状态
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
	private void writeProjectWork(Context ctx, String id, boolean audMark)
			throws EASBizException, BOSException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("useAmount");
		sic.add("leftAmount");
		sic.add("totalAmount");
		if (id != null && !"".equals(id)) {
			ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx)
					.getProjectWorkInfo(new ObjectUuidPK(id), sic);
			if (audMark) {//非正常状态，审核通过；或注销，释放指标，工种使用数量减一
				pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
			} else {//非正常状态，反审核通过，释放指标，工种使用数量加一
				pwInfo.setUseAmount(pwInfo.getUseAmount() + 1);
			}
			pwInfo.setLeftAmount(pwInfo.getTotalAmount()- pwInfo.getUseAmount());
			ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
		}
		
	}

	/**
	 * 回写反签停办人员表
	 * 
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeAntipers(Context ctx, AntiSignedInfo info,AntiSignedEntryInfo entryInfo) throws EASBizException, BOSException {
		// 表头
		ASCancelInfo ascInfo = new ASCancelInfo();
		ascInfo.setId(BOSUuid.create(ascInfo.getBOSType()));
		ascInfo.setSourceBillId(info.getId().toString());
		ascInfo.setNumber(info.getNumber());
		ascInfo.setLSubtime(info.getAuditDate());
		ascInfo.setISubmitor(info.getAuditor());
		// 表体
		// 添加分录
		ASCancelEntryInfo cancelEntryInfo = new ASCancelEntryInfo();
		cancelEntryInfo.setId(BOSUuid.create(cancelEntryInfo.getBOSType()));
		cancelEntryInfo.setName(entryInfo.getName());// 姓名
		cancelEntryInfo.setLastName(entryInfo.getLastName());//姓拼音
		cancelEntryInfo.setFirstName(entryInfo.getFirstName());//名拼音
		cancelEntryInfo.setSex(entryInfo.getSex());// 性别
		cancelEntryInfo.setBirDate(entryInfo.getBirDate());// 出生日期
		cancelEntryInfo.setNatioNal(entryInfo.getNatioNal());// 国籍
		cancelEntryInfo.setPasspNo(entryInfo.getPasspNo());// 护照号码
		cancelEntryInfo.setQuProf(entryInfo.getQuProf());// 指标工种中文
		cancelEntryInfo.setPmtProfFr(entryInfo.getPmtProfFr());//指标工种法文
		cancelEntryInfo.setSendLaBuDate(entryInfo.getSendLaBuDate());// 递交劳动局时间
		cancelEntryInfo.setIsCancel(entryInfo.isIsCancel());//是否停办
		cancelEntryInfo.setCancelDate(entryInfo.getCancelDate());//停办时间
		cancelEntryInfo.setCancelReson(entryInfo.getCancelReson());//停办理由
		cancelEntryInfo.setPmtProj(entryInfo.getPmtProj());// 指标项目
		cancelEntryInfo.setTaskProj(entryInfo.getTaskProj());// 工作项目
		cancelEntryInfo.setPartner(entryInfo.getPartner());// 合作单位
		cancelEntryInfo.setSignNum(entryInfo.getSignNum());//第几次报签
		cancelEntryInfo.setIdNum(entryInfo.getIdNum());//身份证号码
		cancelEntryInfo.setRemark(entryInfo.getRemark());// 备注
		cancelEntryInfo.setPersonID(entryInfo.getPersonID());//人员主键
		cancelEntryInfo.setSourceEntryID(entryInfo.getId().toString());//来源分录
		cancelEntryInfo.setPasspIssDate(entryInfo.getPasspIssDate());// 护照签发日期
		cancelEntryInfo.setPasspExDate(entryInfo.getPasspExDate());// 护照失效日期
		cancelEntryInfo.setBirAddrCn(entryInfo.getBirAddrCn());// 出生地
		cancelEntryInfo.setFName(entryInfo.getFName());// 父亲姓名
		cancelEntryInfo.setAlphFName(entryInfo.getAlphFName());// 父亲拼音
		cancelEntryInfo.setMName(entryInfo.getMName());// 母亲姓名
		cancelEntryInfo.setAlphMName(entryInfo.getAlphMName());// 母亲姓名拼音
		cancelEntryInfo.setMayrStat(entryInfo.getMayrStat());// 婚姻状况
		cancelEntryInfo.setActproff(entryInfo.getActproff());// 实际专业或工种
		cancelEntryInfo.setAntiSgTime(entryInfo.getAntiSgTime());// 返签办理完毕时间
		cancelEntryInfo.setWorkExp(entryInfo.getWorkExp());// 工作经验
		ascInfo.getEntrys().add(cancelEntryInfo);
		ASCancelFactory.getLocalInstance(ctx).addnew(ascInfo);
	}

	/**
	 * 更新人员信息表的人员状态
	 * 
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	private void updatePerHis(Context ctx,AntiSignedEntryInfo entryInfo,boolean isNormal,boolean isStop, boolean audMark) throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		//filter.getFilterItems().add(new FilterItemInfo("idNum", idNum));
		//filter.getFilterItems().add(new FilterItemInfo("passportNo", passportNo));
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId",entryInfo.getPersonID()));
		sic.add("bsnisState");
		sic.add("hBsnisState");
		view.setFilter(filter);
		view.setSelector(sic);
		PersonHistoryCollection personCol = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
		for(int i=0;i<personCol.size();i++){
			PersonHistoryInfo newper =personCol.get(i);
			perBizStateEnum hState = newper.getHBsnisState();
			if(audMark){//审核通过
				newper.setHBsnisState(newper.getBsnisState());
				if(isNormal){//正常办理
					newper.setBsnisState(perBizStateEnum.ANTISIGNED);
				}else{//非正常办理
					newper.setBsnisState(isStop?perBizStateEnum.ANTISTOP:perBizStateEnum.ANTINOT);
				}
			}else{//反审核
				newper.setBsnisState( perBizStateEnum.INDEXALLOT);
			}
			PersonHistoryFactory.getLocalInstance(ctx).updatePartial(newper, sic);
		}
	}

	// 反审核删除反签停办中的数据
	public void deletePersonHis(Context ctx, String ids)throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId", ids));
		ASCancelFactory.getLocalInstance(ctx).delete(filter);

	}

	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		return sic;
	}
}