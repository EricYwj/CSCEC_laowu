package com.kingdee.eas.zjlw.certificates.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
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
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.certificates.ASCancelEntryCollection;
import com.kingdee.eas.zjlw.certificates.ASCancelInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ASCancelControllerBean extends AbstractASCancelControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.ASCancelControllerBean");
 // 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		ASCancelInfo accInfo = (ASCancelInfo) model;
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
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		ASCancelInfo accInfo = (ASCancelInfo) model;
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
		ASCancelInfo info = (ASCancelInfo) getValue(ctx, pk, getSelector());
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
		updatePerHis(ctx,info,true);
	}
	/**
	 * 人员信息表的人员状态更新为反签办理
	 * 
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	private void updatePerHis(Context ctx, ASCancelInfo info,boolean audMark)throws BOSException, EASBizException {
		ASCancelEntryCollection entryCol = info.getEntrys();
		for (int i = 0; i < entryCol.size(); i++) {
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("passportNo", entryCol.get(i).getPasspNo()));
			EntityViewInfo ev = new EntityViewInfo();
			ev.setFilter(filter);
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("bsnisState");
			PersonHistoryCollection phCol = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(ev);
			for (int j = 0; j < phCol.size(); j++) {
				PersonHistoryInfo hisInfo = phCol.get(j);
				hisInfo.setBsnisState(audMark?perBizStateEnum.ANTISTOP:perBizStateEnum.INDEXALLOT);
				PersonHistoryFactory.getLocalInstance(ctx).updatePartial(hisInfo, sic);
			}
		}
	}
		// 审核不通过
		protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
				throws EASBizException, BOSException {
			ASCancelInfo info = (ASCancelInfo) getValue(ctx, pk,
					getSelector());
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
			updatePerHis(ctx,info,false);
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