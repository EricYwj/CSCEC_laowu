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
import com.kingdee.eas.zjlw.certificates.LivepermitCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtInfo;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WkPmtUpdtControllerBean extends AbstractWkPmtUpdtControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.WkPmtUpdtControllerBean");
    // 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		WkPmtUpdtInfo accInfo = (WkPmtUpdtInfo) model;
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
    	WkPmtUpdtInfo accInfo = (WkPmtUpdtInfo) model;
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
    	WkPmtUpdtInfo info = (WkPmtUpdtInfo) getValue(ctx, pk, getSelector());

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
		
		writeWorkPmt(ctx,info);
		writeLivePermit(ctx,info);
		
    }
    // 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		WkPmtUpdtInfo info = (WkPmtUpdtInfo) getValue(ctx, pk,getSelector());
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
		//writeWorkPmt1(ctx,info);
		
	}
	//审核通过，劳动证更新反写到劳动证办理。
	protected void writeWorkPmt(Context ctx,WkPmtUpdtInfo info) throws BOSException, EASBizException{
		WkPmtUpdtEntryCollection entryCol=info.getEntrys();
    	SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("papSTime");//递交资料日期
		sic.add("pType");//劳动证类型
		sic.add("wPmtNum");//劳动证号
		sic.add("wPmtGTime");//劳动证出证日期
		sic.add("laboreffDate");//劳动证生效日期
		sic.add("wPmtSTime");//劳动证到证日期
		sic.add("sPAfPerson");//劳动证申请签收件挂靠人
		sic.add("workOrg");//工作项目
		sic.add("passpNum");//护照号码
		sic.add("passportIssueDate");//护照签发日期
		sic.add("passpExDate");//护照到期日期
		sic.add("passportAgence");//护照颁发机构
		sic.add("passportCityCC");//护照签发地（中文）
		sic.add("passportCityF");//护照签发地（拼音）
		sic.add("oldPassport");//旧护照号码
		for(int i=0;i<entryCol.size();i++){
			WkPmtUpdtEntryInfo wueInfo=entryCol.get(i);
	    	EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
	    	//filter.getFilterItems().add(new FilterItemInfo("parent.sourceBillId",info.getSourceBillId()));
			filter.getFilterItems().add(new FilterItemInfo("id",wueInfo.getSourceEntryID()));
			filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
			view.setFilter(filter);
			WorkPmtEntryCollection col = WorkPmtEntryFactory.getLocalInstance(ctx).getWorkPmtEntryCollection(view);
			if(col!=null&&col.size()>0){
				WorkPmtEntryInfo phInfo=col.get(0);
				phInfo.setPasspNum(wueInfo.getPasspNum());//护照号码
				phInfo.setPassportIssueDate(wueInfo.getPassportIssueDate());//护照签发日期
				phInfo.setPasspExDate(wueInfo.getPasspExDate());//护照到期日期
				phInfo.setPassportAgence(wueInfo.getPassportAgence());//护照颁发机构
				phInfo.setPassportCityCC(wueInfo.getPassportCityC());//护照签发地（中文）
				phInfo.setPassportCityF(wueInfo.getPassportCityF());//护照签发地（拼音）
				phInfo.setPapSTime(wueInfo.getPapSTime());//劳动证递交资料日期
				phInfo.setPType(wueInfo.getPType());//劳动证类型
				phInfo.setWPmtNum(wueInfo.getWPmtNum());//劳动证号
				phInfo.setWPmtGTime(wueInfo.getWPmtGTime());//劳动证出证日期
				phInfo.setLaboreffDate(wueInfo.getLaboreffDate());//劳动证生效日期
				phInfo.setWPmtSTime(wueInfo.getWPmtSTime());//劳动证到证日期
				phInfo.setSPAfPerson(wueInfo.isSPAfPerson());//劳动证申请签收件挂靠人
				phInfo.setWorkOrg(wueInfo.getWorkOrg());//工作项目
				phInfo.setOldPassport(wueInfo.getOldPassport());//旧护照号码
				WorkPmtEntryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);
			}
		}
	}
	//审核通过，劳动证更新反写到 居住证证办理。
	protected void writeLivePermit(Context ctx, WkPmtUpdtInfo info) throws BOSException, EASBizException{
		WkPmtUpdtEntryCollection entryCol=info.getEntrys();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("passpNum");//护照号码
		sic.add("passportIssueDate");//护照签发日期
		sic.add("passpExDate");//护照到期日期
		sic.add("passportAgence");//护照颁发机构
		sic.add("passportCityC");//护照签发地（中文）
		sic.add("passportCityF");//护照签发地（拼音）
		sic.add("wPmtNum");//劳动证号
		sic.add("wPmtGTime");//劳动证出证日期
		sic.add("laboreffDate");//劳动证生效日期
		sic.add("wPmtSTime");//劳动证到证日期
		sic.add("workOrg");//工作项目
		sic.add("oldPassport");//旧护照号码
		for(int i=0;i<entryCol.size();i++){
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
	    	WkPmtUpdtEntryInfo wueInfo=entryCol.get(i);
	    	String id=info.getSourceBillId();
	    	String sourceEntryID=wueInfo.getSourceEntryID();
	    	//filter.getFilterItems().add(new FilterItemInfo("parent.sourceBillId",id));
			filter.getFilterItems().add(new FilterItemInfo("sourceEntryID",sourceEntryID));
			view.setFilter(filter);
			LivepermitEntryCollection col=LivepermitEntryFactory.getLocalInstance(ctx).getLivepermitEntryCollection(view);
			if(col!=null&& col.size()>0){
				LivepermitEntryInfo lpInfo=col.get(0);
				lpInfo.setPasspNum(wueInfo.getPasspNum());//护照号码
				lpInfo.setPassportIssueDate(wueInfo.getPassportIssueDate());//护照签发日期
				lpInfo.setPasspExDate(wueInfo.getPasspExDate());//护照到期日期
				lpInfo.setPassportAgence(wueInfo.getPassportAgence());//护照颁发机构
				lpInfo.setPassportCityC(wueInfo.getPassportCityC());//护照签发地（中文）
				lpInfo.setPassportCityF(wueInfo.getPassportCityF());//护照签发地（拼音）
				lpInfo.setWPmtNum(wueInfo.getWPmtNum());//劳动证号
				lpInfo.setWPmtGTime(wueInfo.getWPmtGTime());//劳动证出证时间
				lpInfo.setLaboreffDate(wueInfo.getLaboreffDate());//劳动证生效日期
				lpInfo.setWPmtSTime(wueInfo.getWPmtSTime());//劳动证到证时间
				lpInfo.setWorkOrg(wueInfo.getWorkOrg());//工作项目
				lpInfo.setOldPassport(wueInfo.getOldPassport());//旧护照号码
				LivepermitEntryFactory.getLocalInstance(ctx).updatePartial(lpInfo, sic);
			}
		}
	}
	//审核不通过，反写劳动证办理，原劳动证到期日期 -劳动证到期日期。
//	protected void writeWorkPmt1(Context ctx,WkPmtUpdtInfo info) throws BOSException{
//		WkPmtUpdtEntryCollection entryCol=info.getEntrys();
//		EntityViewInfo view = new EntityViewInfo();
//    	FilterInfo filter = new FilterInfo();
//		for(int i=0;i<entryCol.size();i++){
//			WkPmtUpdtEntryInfo wueInfo=entryCol.get(i);
//			String idNum=wueInfo.getIdNum();
//			String passpNum=wueInfo.getPasspNum();
//			filter.getFilterItems().add(new FilterItemInfo("idNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passportNo",passpNum));
//			filter.setMaskString("#0 OR #1");
//			view.setFilter(filter);
//			WorkPmtEntryInfo phInfo = WorkPmtEntryFactory.getLocalInstance(ctx).getWorkPmtEntryCollection(view).get(0);
//			phInfo.setWPmtSTime(wueInfo.getWPmtSTime());
//		}
//	}
	
	protected SelectorItemCollection getSelector(){
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		sic.add("sourceBillId");
		return sic;
	}
}