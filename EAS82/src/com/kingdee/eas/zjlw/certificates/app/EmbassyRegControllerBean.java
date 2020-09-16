package com.kingdee.eas.zjlw.certificates.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyInfo;
import com.kingdee.eas.zjlw.certificates.EmbassyRegCollection;
import com.kingdee.eas.zjlw.certificates.EmbassyRegEntryCollection;
import com.kingdee.eas.zjlw.certificates.EmbassyRegEntryInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryCollection;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageInfo;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.zjlw.certificates.EmbassyRegInfo;
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
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EmbassyRegControllerBean extends AbstractEmbassyRegControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.EmbassyRegControllerBean");
    // 保存
    protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
    	EmbassyRegInfo accInfo = (EmbassyRegInfo) model;
    	accInfo.setBillSate(BillStateEnum.DRAFT);
    	//设置编码
    	//    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
    	//    	CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
    	//    	String orgId = currentCompany.getId().toString();
    	//    	ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
    	//    	if(codFactory.isExist(accInfo, orgId)){
    	//    		//不允许断号
    	//    		if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
    	//    			accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
    	//    		}else{
    	//    			if(codFactory.isAddView(accInfo, orgId)){//新增显示
    	//    				
    	//    			}else{//什么都没勾选
    	//    				accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
    	//    			}
    	//    		}
    	//    	}
    	//    	}


    	return super._save(ctx, accInfo);
    }
	//提交 
    protected IObjectPK _submit(Context ctx, IObjectValue model)
    throws BOSException, EASBizException {
    	EmbassyRegInfo accInfo = (EmbassyRegInfo) model;
    	accInfo.setBillSate(BillStateEnum.SUBMIT);
    	//设置编码
    	//    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
    	//    		CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
    	//    		String orgId = currentCompany.getId().toString();
    	//    		ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
    	//    		if(codFactory.isExist(accInfo, orgId)){
    	//    			//不允许断号
    	//    			if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
    	//    				accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
    	//    			}else{
    	//    				if(codFactory.isAddView(accInfo, orgId)){//新增显示
    	//
    	//    				}else{//什么都没勾选
    	//    					accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
    	//    				}
    	//    			}
    	//    		}
    	//    	}
    	return super._submit(ctx, accInfo);
    }
    //审核通过
    protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)
    		throws EASBizException, BOSException {
    	EmbassyRegInfo info = (EmbassyRegInfo) getValue(ctx, pk, getSelector());

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
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
//		updatePerHis(ctx,info,true);
		
    }
    // 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		EmbassyRegInfo info = (EmbassyRegInfo) getValue(ctx, pk,
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
//		updatePerHis(ctx,info,false);
	}
	
    private void updatePerHis(Context ctx,EmbassyRegInfo info,boolean audit) throws BOSException, EASBizException {
    	EmbassyRegEntryCollection entryCol = info.getEntrys();
    	EmbassyRegEntryInfo entryInfo = new EmbassyRegEntryInfo();
		for (int i = 0; i < entryCol.size(); i++) {
			entryInfo = entryCol.get(i);
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("bsnisState");
			sic.add("hBsnisState");
	    	EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("idNum", entryInfo.getIdNum() == null ? null : entryInfo.getIdNum().toString()));
			filter.getFilterItems().add(new FilterItemInfo("passportNo", entryInfo.getPasspNum() == null ? null : entryInfo.getPasspNum().toString()));
			view.setFilter(filter);
			view.setSelector(sic);
			PersonHistoryCollection personCol = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
			for(int j=0;j<personCol.size();j++){
				PersonHistoryInfo newper =personCol.get(j);
				perBizStateEnum hState = newper.getHBsnisState();
				newper.setHBsnisState(newper.getBsnisState());
				newper.setBsnisState(audit ? perBizStateEnum.REGISTERED : hState);
				PersonHistoryFactory.getLocalInstance(ctx).updatePartial(newper, sic);
			}
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