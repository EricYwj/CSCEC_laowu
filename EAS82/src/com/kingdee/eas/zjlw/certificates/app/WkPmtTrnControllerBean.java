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
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.baseinfo.BlackListCollection;
import com.kingdee.eas.zjlw.baseinfo.BlackListFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
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
import com.kingdee.eas.zjlw.certificates.WkPmtTrnCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WkPmtTrnControllerBean extends AbstractWkPmtTrnControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.WkPmtTrnControllerBean");
    // 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		WkPmtTrnInfo accInfo = (WkPmtTrnInfo) model;
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
    	WkPmtTrnInfo accInfo = (WkPmtTrnInfo) model;
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
    	WkPmtTrnInfo info = (WkPmtTrnInfo) getValue(ctx, pk, getSelector());

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
		writePersonHis(ctx,info);
		writeLivePermit(ctx,info);
    }
    // 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		WkPmtTrnInfo info = (WkPmtTrnInfo) getValue(ctx, pk,getSelector());
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
	}
	//反写人员历史信息
	protected void writePersonHis(Context ctx,WkPmtTrnInfo info) throws BOSException, EASBizException {
		WkPmtTrnEntryCollection entryCol=info.getEntrys();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("permitOrg");//指标项目
		sic.add("workOrg");//工作项目
		sic.add("permitProfession");//指标工种
		for(int i=0;i<entryCol.size();i++){
			WkPmtTrnEntryInfo wpInfo=entryCol.get(i);
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
//			String idNum=wpInfo.getIdNum();
//			String passpNum=wpInfo.getPasspNum();
			//String number=info.getNumber();
//			filter.getFilterItems().add(new FilterItemInfo("idNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passportNo",passpNum));
			filter.getFilterItems().add(new FilterItemInfo("sourceBillId",wpInfo.getPersonID()));
//			filter.setMaskString("#0 OR #1");
			view.setFilter(filter);
			PersonHistoryCollection col = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
			if(col!=null&&col.size()>0){
				PersonHistoryInfo phInfo=col.get(0);
				if(wpInfo.getQuProf()!=null&&!"".equals(wpInfo.getQuProf())){
					//如果原指标工种和现指标工种一样，则不反写人员历时性息
				    if(wpInfo.getQuProf().equals(wpInfo.getHQuProf())){
				    }
					//如果原指标工种和现指标工种不一样，则反写人员历史信息，并释放指标。
					if(!wpInfo.getQuProf().equals(wpInfo.getHQuProf())){
						if(wpInfo.getHQuProf()!=null){
							String id=wpInfo.getHQuProf().getId().toString();
							checkProjectWork(ctx,id);//释放原指标数量-1
							phInfo.setPermitOrg(wpInfo.getPmtProj());//指标项目
							phInfo.setWorkOrg(wpInfo.getPmtProj());//工作项目
							phInfo.setPermitProfession(wpInfo.getQuProf());//指标工种
							PersonHistoryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);
							String id1=wpInfo.getQuProf().getId().toString();
							checkProjectWork1(ctx,id1);//新指标数量+1
						}
					}
			    }
			}
		}		
	}
	//审核通过，释放指标工种指标
	private void checkProjectWork(Context ctx, String id)throws EASBizException, BOSException {
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("useAmount");
			sic.add("leftAmount");
			sic.add("totalAmount");
			if (id != null && !"".equals(id)) {
				ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx).getProjectWorkInfo(new ObjectUuidPK(id), sic);
				pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
				pwInfo.setLeftAmount(pwInfo.getTotalAmount()-pwInfo.getUseAmount());
				ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
			}
     }
	//审核通过，释放指标工种指标
	private void checkProjectWork1(Context ctx, String id)throws EASBizException, BOSException {
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("useAmount");
			sic.add("leftAmount");
			sic.add("totalAmount");
			if (id != null && !"".equals(id)) {
				ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx).getProjectWorkInfo(new ObjectUuidPK(id), sic);
					pwInfo.setUseAmount(pwInfo.getUseAmount() +1);
					pwInfo.setLeftAmount(pwInfo.getTotalAmount()-pwInfo.getUseAmount());
					ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
			}
     }
	//审核通过，劳动证调转反写到劳动证办理。
	protected void writeWorkPmt(Context ctx,WkPmtTrnInfo info) throws BOSException, EASBizException{
		WkPmtTrnEntryCollection entryCol=info.getEntrys();
    	SelectorItemCollection sic = new SelectorItemCollection();
    	sic.add("passpNum");//护照号码
    	sic.add("passportIssueDate");//护照签发日期
    	sic.add("passpExDate");//护照到期日期
    	sic.add("passportAgence");//护照颁发机构
    	sic.add("passportCityCC");//护照签发地（中文）
    	sic.add("passportCityF");//护照签发地（拼音）
    	sic.add("quProf");//指标工种
		sic.add("quprofF");//指标工种(法文)
    	sic.add("qualDate");//双认证完成时间
    	sic.add("authType");//公证认证类型
		sic.add("papSTime");//递交资料日期
		sic.add("wPmtNum");//劳动证号
		sic.add("pType");//劳动证类型
		sic.add("wPmtGTime");//劳动证出证日期
		sic.add("laboreffDate");//劳动证生效日期
		sic.add("wPmtSTime");//劳动证到证日期
		sic.add("sPAfPerson");//劳动证申请签收件挂靠人
		sic.add("pmtProj");//指标项目
		sic.add("workOrg");//工作项目
		sic.add("oldPassport");//旧护照号码
		for(int i=0;i<entryCol.size();i++){
			WkPmtTrnEntryInfo wteInfo=entryCol.get(i);
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
//			String idNum=wteInfo.getIdNum();
//			String passpNum=wteInfo.getPasspNum();
//			String number=info.getNumber();
//			filter.getFilterItems().add(new FilterItemInfo("IdNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passpNum",passpNum));
//			filter.getFilterItems().add(new FilterItemInfo("parent.number",number));
	    	//filter.getFilterItems().add(new FilterItemInfo("parent.sourceBillId",id));
			filter.getFilterItems().add(new FilterItemInfo("id",wteInfo.getSourceEntryID()));
			filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
			view.setFilter(filter);
			WorkPmtEntryCollection col = WorkPmtEntryFactory.getLocalInstance(ctx).getWorkPmtEntryCollection(view);
			if(col!=null&&col.size()>0){
				WorkPmtEntryInfo phInfo=col.get(0);
				phInfo.setPasspNum(wteInfo.getPasspNum());//护照号码
				phInfo.setPassportIssueDate(wteInfo.getPassportIssueDate());//护照签发日期
				phInfo.setPasspExDate(wteInfo.getPasspExDate());//护照到期日期
				phInfo.setPassportAgence(wteInfo.getPassportAgence());//护照颁发机构
				phInfo.setPassportCityCC(wteInfo.getPassportCityC());//护照签发地（中文）
				phInfo.setPassportCityF(wteInfo.getPassportCityF());//护照签发地（拼音）
				phInfo.setQuProf(wteInfo.getQuProf());//指标工种(中文)
				phInfo.setQuprofF(wteInfo.getQuProff());//指标工种(法文)
				phInfo.setQualDate(wteInfo.getQualDate());//双认证完成时间
				phInfo.setAuthType(wteInfo.getAuthType());//公证认证类型
				phInfo.setPapSTime(wteInfo.getPapSTime());//递交资料日期
				phInfo.setPType(wteInfo.getPType());//劳动证类型
				phInfo.setWPmtNum(wteInfo.getWPmtNum());//劳动证号
				phInfo.setWPmtGTime(wteInfo.getWPmtGTime());//劳动证出证日期
				phInfo.setLaboreffDate(wteInfo.getLaboreffDate());//劳动证生效日期
				phInfo.setWPmtSTime(wteInfo.getWPmtSTime());//劳动证到证日期
				phInfo.setSPAfPerson(wteInfo.isSPAffPerson());//劳动证申请签收件挂靠人
				phInfo.setPmtProj(wteInfo.getPmtProj());//指标项目
				phInfo.setWorkOrg(wteInfo.getWorkOrg());//工作项目
				phInfo.setOldPassport(wteInfo.getOldPassport());//旧护照号码
				WorkPmtEntryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);
			}
		}
	}
	//审核通过，劳动证调转反写到居住证办理。
	protected void writeLivePermit(Context ctx, WkPmtTrnInfo info) throws BOSException, EASBizException{
		WkPmtTrnEntryCollection entryCol=info.getEntrys();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("wPmtNum");//劳动证号
		sic.add("wPmtGTime");//劳动证出证日期
		sic.add("laboreffDate");//劳动证生效日期
		sic.add("wPmtSTime");//劳动证到证日期
		//sic.add("pmtProj");//指标项目
		sic.add("workOrg");//工作项目
		sic.add("quProf");//指标工种
		sic.add("prmtProf");//指标工种法文
		sic.add("passpNum");//护照号码
		sic.add("passportIssueDate");//护照签发日期
		sic.add("passpExDate");//护照到期日期
		sic.add("passportAgence");//护照颁发机构
		sic.add("passportCityC");//护照签发地（中文）
		sic.add("passportCityF");//护照签发地（拼音）
		sic.add("oldPassport");//旧护照号码
		for(int i=0;i<entryCol.size();i++){
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
	    	WkPmtTrnEntryInfo wueInfo=entryCol.get(i);
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
				lpInfo.setPassportAgence(wueInfo.getPassportAgence());//护照颁发机构
				lpInfo.setPasspExDate(wueInfo.getPasspExDate());//护照到期日期
				lpInfo.setPassportCityC(wueInfo.getPassportCityC());//护照签发地（中文）
				lpInfo.setPassportCityF(wueInfo.getPassportCityF());//护照签发地（拼音）
				lpInfo.setQuProf(wueInfo.getQuProf());//指标工种
				lpInfo.setPrmtProf(wueInfo.getQuProff());//指标工种法文
				lpInfo.setWPmtNum(wueInfo.getWPmtNum());//劳动证号
				lpInfo.setWPmtGTime(wueInfo.getWPmtGTime());//劳动证出证时间
				lpInfo.setLaboreffDate(wueInfo.getLaboreffDate());//劳动证生效日期
				lpInfo.setWPmtSTime(wueInfo.getWPmtSTime());//劳动证到证时间
				//lpInfo.setPmtProj(wueInfo.getPmtProj());//指标项目
				lpInfo.setWorkOrg(wueInfo.getWorkOrg());//工作项目
				lpInfo.setOldPassport(wueInfo.getOldPassport());//旧护照号码
				LivepermitEntryFactory.getLocalInstance(ctx).updatePartial(lpInfo, sic);
			}
		}
	}
//	//审核不通过，释放指标
//	protected void writeProjectWork(Context ctx,WkPmtTrnInfo info) throws EASBizException, BOSException {
//		WkPmtTrnEntryCollection entryCol=info.getEntrys();
//		for(int i=0;i<entryCol.size();i++){
//			WkPmtTrnEntryInfo wpInfo=entryCol.get(i);
//			String id=wpInfo.getHQuProf().getId().toString();
//			String id1=wpInfo.getQuProf().getId().toString();
//			checkProjectWork1(ctx,id);
//			checkProjectWork(ctx,id1);
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