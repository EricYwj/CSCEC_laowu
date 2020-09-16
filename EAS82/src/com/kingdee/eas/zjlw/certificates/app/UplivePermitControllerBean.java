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
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitFactory;
import com.kingdee.eas.zjlw.certificates.UplivePermitCollection;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.UplivePermitInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class UplivePermitControllerBean extends AbstractUplivePermitControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.UplivePermitControllerBean");
 // 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		UplivePermitInfo accInfo = (UplivePermitInfo) model;
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
    	UplivePermitInfo accInfo = (UplivePermitInfo) model;
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
    	UplivePermitInfo info = (UplivePermitInfo) getValue(ctx, pk, getSelector());

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
		writeLivepermit(ctx,info);
    }
 // 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		UplivePermitInfo info = (UplivePermitInfo) getValue(ctx, pk,getSelector());
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
		
		//deletePersonHis(ctx,info);
	}
	//审核通过，居住证更新反写到居住证办理。
	protected void writeLivepermit(Context ctx,UplivePermitInfo info) throws BOSException, EASBizException{
		UplivePermitEntryCollection entryCol=info.getEntrys();
    	SelectorItemCollection sic = new SelectorItemCollection();
    	sic.add("passpNum");//护照号码
    	sic.add("passportIssueDate");//护照签发日期
    	sic.add("passpExDate");//护照到期日期
    	sic.add("passportAgence");//护照颁发机构
    	sic.add("passportCityC");//护照签发地（中文）
    	sic.add("passportCityF");//护照签发地（拼音）
		sic.add("papSTime");//居住证递交资料日期
		sic.add("docType");//证件类型
		sic.add("rePmtNum");//临居号码
		sic.add("sRePmtSTime");//临时居住证出期日期
		sic.add("rePmtETime");//临时居住证到证日期
		sic.add("pmtSTime");//正式居住证出证日期
		sic.add("pmtNum");//正式居住证号码
		sic.add("pmtETime");//正式居住证到期日期
		sic.add("pmteffDate");//正式居住证生效日期
		sic.add("workOrg");//工作项目
		for(int i=0;i<entryCol.size();i++){
			UplivePermitEntryInfo upInfo=entryCol.get(i);
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
//			String idNum=upInfo.getIdNum();
//			String passpNum=upInfo.getPasspNum();
//			String number=info.getNumber();
//			filter.getFilterItems().add(new FilterItemInfo("IdNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passpNum",passpNum));
//			filter.getFilterItems().add(new FilterItemInfo("parent.number",number));
			filter.getFilterItems().add(new FilterItemInfo("id",upInfo.getSourceEntryID()));
			view.setFilter(filter);
			LivepermitEntryCollection col = LivepermitEntryFactory.getLocalInstance(ctx).getLivepermitEntryCollection(view);
			if(col!=null&&col.size()>0){
				LivepermitEntryInfo phInfo=col.get(0);
	    		phInfo.setDocType(upInfo.getDocType());//证件类型
	    		phInfo.setPasspNum(upInfo.getPasspNum());//护照号码
	    		phInfo.setPassportIssueDate(upInfo.getPassportIssueDate());//护照签发日期
	    		phInfo.setPasspExDate(upInfo.getPasspExDate());//护照到期日期
	    		phInfo.setPassportAgence(upInfo.getPassportAgence());//护照颁发机构
	    		phInfo.setPassportCityC(upInfo.getPassportCityC());//护照签发地（中文）
	    		phInfo.setPassportCityF(upInfo.getPassportCityF());//护照签发地（拼音）
	    		phInfo.setWorkOrg(upInfo.getWorkOrg());//工作项目
	    		phInfo.setPapSTime(upInfo.getPapSTime());//居住证递交资料日期
	    		phInfo.setRePmtNum(upInfo.getRePmtNum());//临居号码
    			phInfo.setSRePmtSTime(upInfo.getSRePmtSTime());//临时居住证出期日期
				phInfo.setRePmtETime(upInfo.getRePmtETime());//临时居住证到证日期
				phInfo.setPmtNum(upInfo.getPmtNum());//正式居住证号码
				phInfo.setPmtSTime(upInfo.getPmtSTime());//正居到期日期
				phInfo.setPmteffDate(upInfo.getPmteffDate());//正式居住证生效日期
				phInfo.setPmtETime(upInfo.getPmtETime());//正居到期日期
				LivepermitEntryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);	
			}
		}
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