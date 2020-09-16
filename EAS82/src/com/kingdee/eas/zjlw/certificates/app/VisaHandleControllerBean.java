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

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelEntryInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelFactory;
import com.kingdee.eas.zjlw.certificates.ASCancelInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryCollection;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleInfo;
import com.kingdee.eas.zjlw.certificates.WorkVisacancelEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkVisacancelFactory;
import com.kingdee.eas.zjlw.certificates.WorkVisacancelInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class VisaHandleControllerBean extends AbstractVisaHandleControllerBean {
	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.zjlw.certificates.app.VisaHandleControllerBean");

	// 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		VisaHandleInfo accInfo = (VisaHandleInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
//		// 设置编码
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
		VisaHandleInfo accInfo = (VisaHandleInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
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
		return super._submit(ctx, accInfo);
	}

	// 审核通过
	protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		VisaHandleInfo info = (VisaHandleInfo) getValue(ctx, pk, getSelector());

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
		writeBack(ctx, info, true);

	}

	// 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		VisaHandleInfo info = (VisaHandleInfo) getValue(ctx, pk, getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(
				new FilterItemInfo("billSate", "30", CompareType.NOTEQUALS));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("所选行已存在审核通过的数据，不能审核！");
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
		writeBack(ctx, info, false);
	}

	/**
	 * 回写数据
	 * 
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeBack(Context ctx, VisaHandleInfo info, boolean audMark)throws BOSException, EASBizException {
		VisaHandleEntryCollection entryCol = info.getEntrys();
		VisaHandleEntryInfo entryInfo = new VisaHandleEntryInfo();
		for (int i = 0; i < entryCol.size(); i++) {
			entryInfo = entryCol.get(i);
			boolean cancelSta = entryInfo.isIsCancel();
			if (cancelSta){//停办
				if (audMark) {// 审核通过，回写反签停办人员表
					writeAntipers(ctx, info, entryInfo);
				}else{//反审核
					deletePersonHis(ctx, info.getId().toString());// 删除停办人员信息表中的数据
				}
			}
			updatePerHis(ctx, entryInfo,cancelSta, audMark);//更新人员状态
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
		sic.add("useAmount");
		sic.add("leftAmount");
		sic.add("totalAmount");
		if (id != null && !"".equals(id)) {
			ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx)
					.getProjectWorkInfo(new ObjectUuidPK(id), sic);
			if (audMark) {//非正常状态，审核通过，释放指标，工种使用数量减一
				pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
			} else {//非正常状态，反审核通过，释放指标，工种使用数量加一
				pwInfo.setUseAmount(pwInfo.getUseAmount() + 1);
			}
			pwInfo.setLeftAmount(pwInfo.getTotalAmount()- pwInfo.getUseAmount());
			ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
		}
		
	}
	/**
	 * 回写工作签停办人员表
	 * 
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeAntipers(Context ctx, VisaHandleInfo info,VisaHandleEntryInfo entryInfo) throws EASBizException, BOSException {
		// 表头
		WorkVisacancelInfo ascInfo = new WorkVisacancelInfo();
		ascInfo.setId(BOSUuid.create(ascInfo.getBOSType()));
		ascInfo.setSourceBillId(info.getId().toString());
		ascInfo.setNumber(info.getNumber());
		ascInfo.setBizDate(new Date());
		ascInfo.setISubtime(info.getAuditDate());
		ascInfo.setISubmitor(info.getAuditor());
		// 表体
		WorkVisacancelEntryInfo cancelEntryInfo = new WorkVisacancelEntryInfo();
		cancelEntryInfo.setId(BOSUuid.create(cancelEntryInfo.getBOSType()));
		cancelEntryInfo.setName(entryInfo.getName());// 姓名
		cancelEntryInfo.setSex(entryInfo.getSex());// 性别
		cancelEntryInfo.setBornDate(entryInfo.getBornDate());// 出生日期
		cancelEntryInfo.setNatioNal(entryInfo.getNatioNal());//国籍
		cancelEntryInfo.setPasspNo(entryInfo.getPasspNo());// 护照号码
		cancelEntryInfo.setPrmtPro(entryInfo.getPrmtPro());// 指标项目
		cancelEntryInfo.setWorkPro(entryInfo.getWorkPro());// 工作项目
		cancelEntryInfo.setPartner(entryInfo.getPartner());// 合作单位
		cancelEntryInfo.setLaborSignNo(entryInfo.getLaborSignNo());//劳动局返签号
		cancelEntryInfo.setAntiEndTime(entryInfo.getAntiEndTime());//返签到期时间
		cancelEntryInfo.setDocAffiliated(entryInfo.isDocAffiliated());//返签批件挂靠人
		cancelEntryInfo.setIsCancel(entryInfo.isIsCancel());//是否停办
		cancelEntryInfo.setCancelDate(entryInfo.getCancelDate());//停办时间
		cancelEntryInfo.setStopRsn(entryInfo.getStopRsn());//停办理由
		cancelEntryInfo.setIdNum(entryInfo.getIdNum());// 身份证号
		cancelEntryInfo.setDesCription(entryInfo.getDesCription());// 备注
		
		cancelEntryInfo.setSourceEntryID(entryInfo.getId().toString());//来源分录
		cancelEntryInfo.setPersonID(entryInfo.getPersonID());//人员id
		cancelEntryInfo.setPassoTime(entryInfo.getPassoTime());// 护照签发日期
		cancelEntryInfo.setPasspDate(entryInfo.getPasspDate());// 护照失效日期
		cancelEntryInfo.setPmtProfc(entryInfo.getPmtProfc());// 指标工种
		cancelEntryInfo.setCuproff(entryInfo.getCuproff());// 指标工种法语
		cancelEntryInfo.setActProff(entryInfo.getActProff());// 实际专业或工种
		cancelEntryInfo.setAnSgetDate(entryInfo.getAnSgetDate());// 反签批件收到时间
		cancelEntryInfo.setVgetTime(entryInfo.getVgetTime());// 签证资料收到时间
		cancelEntryInfo.setVSentTime(entryInfo.getVSentTime());// 签证送签时间（递交使馆日期）
		cancelEntryInfo.setVcompTime(entryInfo.getVcompTime());// 签证办理完毕时间
		cancelEntryInfo.setVsTime(entryInfo.getVsTime());// 签证签发日期
		cancelEntryInfo.setVeTime(entryInfo.getVeTime());// 签证到期日期
		ascInfo.getEntrys().add(cancelEntryInfo);
		WorkVisacancelFactory.getLocalInstance(ctx).addnew(ascInfo);
	}
	// 反审核删除反签停办中的数据
	public void deletePersonHis(Context ctx, String ids)throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId", ids));
		WorkVisacancelFactory.getLocalInstance(ctx).delete(filter);

	}


	/**
	 * 更新人员信息表的人员状态
	 * 
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	private void updatePerHis(Context ctx,VisaHandleEntryInfo entryInfo,boolean cancel, boolean audMark) throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		//filter.getFilterItems().add(new FilterItemInfo("idNum", idNum));
		//filter.getFilterItems().add(new FilterItemInfo("passportNo", passportNo));
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId",entryInfo.getPersonID()));
		view.setFilter(filter);
		view.setSelector(sic);
		sic.add("bsnisState");
		sic.add("hBsnisState");
		PersonHistoryCollection personCol = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
		for(int i=0;i<personCol.size();i++){
			PersonHistoryInfo newper =personCol.get(i);
			perBizStateEnum hState = newper.getHBsnisState();
			newper.setHBsnisState(newper.getBsnisState());
//			if (cancel) {
//				newper.setBsnisState(audMark ? perBizStateEnum.VISASTOP : hState);
//			}
			newper.setBsnisState(audMark ? perBizStateEnum.VISA : perBizStateEnum.ANTISIGNED);
			PersonHistoryFactory.getLocalInstance(ctx).updatePartial(newper, sic);
		}
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