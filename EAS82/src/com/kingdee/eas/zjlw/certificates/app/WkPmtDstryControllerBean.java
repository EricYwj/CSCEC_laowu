package com.kingdee.eas.zjlw.certificates.app;

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
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.ExilivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.ExilivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.ExilivepermitFactory;
import com.kingdee.eas.zjlw.certificates.ExilivepermitInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryCollection;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryFactory;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageFactory;
import com.kingdee.eas.zjlw.certificates.LeaveManageInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WkPmtDstryControllerBean extends AbstractWkPmtDstryControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.WkPmtDstryControllerBean");
    // 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		WkPmtDstryInfo accInfo = (WkPmtDstryInfo) model;
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
    	WkPmtDstryInfo accInfo = (WkPmtDstryInfo) model;
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
    	WkPmtDstryInfo info = (WkPmtDstryInfo) getValue(ctx, pk, getSelector());

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
		
//		writeWorkPmt(ctx,info,true);
		//writePersonHis(ctx,info,true);
		writeLaveManager(ctx,info,true);
    }
 // 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		WkPmtDstryInfo info = (WkPmtDstryInfo) getValue(ctx, pk,getSelector());
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
//		writeWorkPmt(ctx,info,false);
		//writePersonHis(ctx,info,false);
		writeLaveManager(ctx,info,false);
		
	}
	//反写人员历史信息
//	protected void writePersonHis(Context ctx,WkPmtDstryInfo info,boolean isAudit) throws EASBizException, BOSException{
//		WkPmtDstryEntryCollection  entryCol = info.getEntrys();
//    	SelectorItemCollection sic = new SelectorItemCollection();
//    	sic.add("bsnisState");
//    	sic.add("HBsnisState");
//		for(int i=0;i<entryCol.size();i++){
//			EntityViewInfo view = new EntityViewInfo();
//			FilterInfo filter = new FilterInfo();
//			WkPmtDstryEntryInfo entryInfo = entryCol.get(i);
//			//String id=entryInfo.getQuProf().getId().toString();
//			String idNum=entryInfo.getIdNum();
//			String passNum=entryInfo.getPasspNum();
//			String number=info.getNumber();
//			//checkProjectWork(ctx,id,isAudit);
//			filter.getFilterItems().add(new FilterItemInfo("idNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passportNo",passNum));
//			filter.getFilterItems().add(new FilterItemInfo("number",number));
////			filter.setMaskString("#0 OR #1");
//			view.setFilter(filter);
//			PersonHistoryCollection col=PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
//			if(col!=null&& col.size()>0){
//				PersonHistoryInfo hisInfo=col.get(i);
//				if(isAudit){
//					hisInfo.setHBsnisState(hisInfo.getBsnisState());
//					hisInfo.setBsnisState(perBizStateEnum.WKDSTRY);
//				}else{
//					hisInfo.setBsnisState(hisInfo.getHBsnisState());
//				}
//			    PersonHistoryFactory.getLocalInstance(ctx).updatePartial(hisInfo, sic);
//			}
//		}
//	}
	
	//审核通过，释放指标工种指标
//	private void checkProjectWork(Context ctx, String id,boolean isAudit)throws EASBizException, BOSException {
//		SelectorItemCollection sic = new SelectorItemCollection();
//		sic.add("useAmount");
//		sic.add("leftAmount");
//		sic.add("totalAmount");
//		if(id!=null &&!"".equals(id)){
//			ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx).getProjectWorkInfo(new ObjectUuidPK(id), sic);
//			if(isAudit){
//				pwInfo.setUseAmount(pwInfo.getUseAmount()-1);
//			}else{
//				pwInfo.setUseAmount(pwInfo.getUseAmount()+1);
//			}
//			pwInfo.setLeftAmount(pwInfo.getTotalAmount()-pwInfo.getUseAmount());
//			ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
//		}
//	}
	//审核通过，反写劳动证办理状态为已注销
//	protected void writeWorkPmt(Context ctx,WkPmtDstryInfo info,boolean isAudit) throws BOSException, EASBizException{
		//2016-12-28  暂时不反写劳动证办理状态
//		WkPmtDstryEntryCollection entryCol=info.getEntrys();
//    	SelectorItemCollection sic = new SelectorItemCollection();
//    	sic.add("billSate");
//    	String sourceBillID = info.getSourceBillId();
//    	if(sourceBillID!=null &&!"".equals(sourceBillID)){
//    		String bosobjecttype = BOSUuid.read(info.getSourceBillId()).getType().toString();
//    		// wpInfo=WorkPmtFactory.getLocalInstance(ctx).getWorkPmtInfo(new ObjectUuidPK(sourceBillID));
//    		//上游单据为居住证办理 
//    		if("B6FEE918".equals(bosobjecttype)){
//    			//居住证办理单据
//    			LivepermitInfo lpInfo=LivepermitFactory.getLocalInstance(ctx).getLivepermitInfo(new ObjectUuidPK(sourceBillID));
//    			//劳动证办理
//    			WorkPmtInfo wpInfo=WorkPmtFactory.getLocalInstance(ctx).getWorkPmtInfo(new ObjectUuidPK(lpInfo.getSourceBillId()));
//    			wpInfo.setBillSate(isAudit? BillStateEnum.DSTRY:BillStateEnum.CHECKED);
//    			WorkPmtFactory.getLocalInstance(ctx).updatePartial(wpInfo, sic);
//    		 }
//    		//上游单据为居住证注销
//    		 if("A3BABFEC".equals(bosobjecttype)){
//    			 //居住证注销单据
//    			 ExilivepermitInfo elInfo=ExilivepermitFactory.getLocalInstance(ctx).getExilivepermitInfo(new ObjectUuidPK(sourceBillID));
//    			 //居住证办理
//    			 LivepermitInfo lpInfo=LivepermitFactory.getLocalInstance(ctx).getLivepermitInfo(new ObjectUuidPK(elInfo.getSourceBillId()));
//    			 //劳动证办理
//    			 WorkPmtInfo wpInfo=WorkPmtFactory.getLocalInstance(ctx).getWorkPmtInfo(new ObjectUuidPK(lpInfo.getSourceBillId()));
//    			 if(isAudit){
//    	    			wpInfo.setBillSate(BillStateEnum.DSTRY);
//    	    		}else{
//    	    			wpInfo.setBillSate(BillStateEnum.CHECKED);
//    	    		}
//    	    		WorkPmtFactory.getLocalInstance(ctx).updatePartial(wpInfo, sic);
////     			 wpInfo.setBillSate(isAudit? BillStateEnum.DSTRY:BillStateEnum.CHECKED);
////     			 WorkPmtFactory.getLocalInstance(ctx).updatePartial(wpInfo, sic);
//    		 }
//    		
//    	}
//	}
	//审核通过反写离境，劳动证注销时间
	protected void writeLaveManager(Context ctx,WkPmtDstryInfo info, Boolean isWrite) throws BOSException, EASBizException{
		WkPmtDstryEntryCollection  entryCol = info.getEntrys();
    	SelectorItemCollection sic = new SelectorItemCollection();
    	sic.add("exitTime");
		for(int i=0;i<entryCol.size();i++){
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			WkPmtDstryEntryInfo entryInfo = entryCol.get(i);
//			String idNum=entryInfo.getIdNum();
//			String passNum=entryInfo.getPasspNum();
//			String number=info.getNumber();
//			filter.getFilterItems().add(new FilterItemInfo("idNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passpNum",passNum));
//			filter.getFilterItems().add(new FilterItemInfo("parent.number",number));
//			filter.getFilterItems().add(new FilterItemInfo("leaveType",leaveTypeEnum.LEAVENO));
//			filter.getFilterItems().add(new FilterItemInfo("leaveType",leaveTypeEnum.LEAVESTOP));
//			filter.setMaskString("#0 and #1 and (#2 or #3)");
			filter.getFilterItems().add(new FilterItemInfo("personID",entryInfo.getPersonID()));
			view.setFilter(filter);
			LeaveManageEntryCollection col = LeaveManageEntryFactory.getLocalInstance(ctx).getLeaveManageEntryCollection(view);
			if(col!=null&&col.size()>0){
				LeaveManageEntryInfo phInfo=col.get(0);
				if(isWrite){
					phInfo.setExitTime(entryInfo.getDstryTime());	
				}else{
					phInfo.setExitTime(null);
				}
				LeaveManageEntryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);
			}
		}
	}
	protected SelectorItemCollection getSelector(){
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		sic.add("sourceBillID");
		return sic;
    }
}