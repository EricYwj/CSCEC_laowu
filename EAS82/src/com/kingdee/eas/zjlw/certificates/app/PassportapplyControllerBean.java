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
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.certificates.PassportapplyCollection;
import com.kingdee.eas.zjlw.certificates.PassportapplyEntryCollection;
import com.kingdee.eas.zjlw.certificates.PassportapplyEntryInfo;

import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.zjlw.certificates.PassportapplyInfo;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.NoCCEntryCollection;
import com.kingdee.eas.zjlw.personmess.NoCCEntryInfo;
import com.kingdee.eas.zjlw.personmess.NoCCInfo;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PassportapplyControllerBean extends AbstractPassportapplyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.PassportapplyControllerBean");
 // 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		PassportapplyInfo accInfo = (PassportapplyInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		//设置编码
//    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
//    	AdminOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentAdmin();
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
//    	  }
//    	}
		return super._save(ctx, accInfo);
	}
	//提交 
    protected IObjectPK _submit(Context ctx, IObjectValue model)
    throws BOSException, EASBizException {
    	PassportapplyInfo accInfo = (PassportapplyInfo) model;
    	accInfo.setBillSate(BillStateEnum.SUBMIT);
	   	//设置编码
//    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
//    		AdminOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentAdmin();
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
    	PassportapplyInfo info = (PassportapplyInfo) getValue(ctx, pk, getSelector());

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
		writeBack(ctx,info,true);
    }
   // 
	 private void writeBack(Context ctx, PassportapplyInfo info, boolean audit) throws EASBizException, BOSException {
		 PassportapplyEntryCollection passCol = info.getEntrys();
		 for (int i = 0; i < passCol.size(); i++) {
			 PassportapplyEntryInfo entryInfo = passCol.get(i);
			 if (!entryInfo.isIsCancel()) {//正常人员

			 }
			 writePerHis(ctx,entryInfo,audit);
		 }
	}
	 //反写历史人员状态
	private void writePerHis(Context ctx, PassportapplyEntryInfo entryInfo, boolean audit) throws EASBizException, BOSException {
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		//filter.getFilterItems().add(new FilterItemInfo("idNum", entryInfo.getIdNum()));
		//filter.getFilterItems().add(new FilterItemInfo("passportNo", entryInfo.getPasspNum()));
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId",entryInfo.getPersonID()));
		view.setFilter(filter);
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("bsnisState");
		sic.add("hBsnisState");
		view.setSelector(sic);
		PersonHistoryCollection personCol = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
		for(int i=0;i<personCol.size();i++){//正常状态
			PersonHistoryInfo newper =personCol.get(i);
			perBizStateEnum hState = newper.getHBsnisState();
			newper.setHBsnisState(newper.getBsnisState());
			if(audit){
				newper.setBsnisState(perBizStateEnum.PASSPORTISSUED);
			}else{
				if(entryInfo.isIfUnexpect()){
					newper.setBsnisState(perBizStateEnum.IMMIGRATIONOUT);
				}else{
					newper.setBsnisState(perBizStateEnum.IMMIGRATION);
				}
			}
			PersonHistoryFactory.getLocalInstance(ctx).updatePartial(newper, sic);
		}	
	}
// 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		PassportapplyInfo info = (PassportapplyInfo) getValue(ctx, pk,getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("billSate", "30", CompareType.NOTEQUALS));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("所选行在审核不通过中");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeBack(ctx,info,false);
	}
	
	protected SelectorItemCollection getSelector(){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("billSate");
			sic.add("number");
			sic.add("company.id");
			sic.add("entrys.*");
			return sic;
	}
}