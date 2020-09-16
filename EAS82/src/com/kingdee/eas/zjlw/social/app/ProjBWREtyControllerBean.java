package com.kingdee.eas.zjlw.social.app;

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
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryInfo;
import com.kingdee.eas.zjlw.social.ForiPayrollInfo;
import com.kingdee.eas.zjlw.social.ProjBWRAssdCollection;
import com.kingdee.eas.zjlw.social.ProjBWRAssdFactory;
import com.kingdee.eas.zjlw.social.ProjBWRAssdInfo;
import com.kingdee.eas.zjlw.social.ProjBWREtyCollection;
import com.kingdee.eas.zjlw.social.ProjBWREtyEntryCollection;
import com.kingdee.eas.zjlw.social.ProjBWREtyEntryInfo;
import com.kingdee.eas.zjlw.social.ProjBWREtyFactory;
import com.kingdee.eas.zjlw.social.SecuSplitCollection;
import com.kingdee.eas.zjlw.social.SecuSplitFactory;
import com.kingdee.eas.zjlw.social.SecuSplitInfo;
import com.kingdee.eas.zjlw.social.VabaweatherInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.zjlw.social.ProjBWREtyInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ProjBWREtyControllerBean extends AbstractProjBWREtyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.social.app.ProjBWREtyControllerBean");
  //提交 
    protected IObjectPK _submit(Context ctx, IObjectValue model)
    throws BOSException, EASBizException {
    	ProjBWREtyInfo accInfo = (ProjBWREtyInfo) model;
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
    
    /**
     * 审核通过
     */
    protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
    	ProjBWREtyInfo info = (ProjBWREtyInfo) getValue(ctx, pk, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("*");
		sic.add("auditor");
		sic.add("AuditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		dealAll(ctx,info,true);
    }
	/**
	 * 审核不通过
	 */
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
		ProjBWREtyInfo info = (ProjBWREtyInfo) getValue(ctx, pk,getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("AuditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		dealAll(ctx,info,false);
	}
	public void dealAll(Context ctx, ProjBWREtyInfo info, boolean audit) throws BOSException, EASBizException {
		//生成恶劣天气返还分摊表
		initBlankSecuSplit(ctx, info,audit);
//		dealSecuSplit(ctx, info,audit);
	}
	private void initBlankSecuSplit(Context ctx, ProjBWREtyInfo info, boolean audit) throws BOSException, EASBizException {
		//审核或反审核
   		if (audit) {
			//审核，生成分摊表
//   			if (!isSecuSplit(ctx,info)) {//无分摊表数据
   				AdminOrgUnitInfo Proj = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(info.getProjName()==null?null:info.getProjName().getId()));
   				ProjBWRAssdInfo ssInfo = new ProjBWRAssdInfo();
   				ssInfo.setId(BOSUuid.create(ssInfo.getBOSType()));
   				ssInfo.setSourceBillId(info.getId().toString());
   				ssInfo.setNumber(info.getNumber());//单据编号
   				ssInfo.setBillSate(BillStateEnum.DRAFT);//单据状态
   				ssInfo.setBizDate(new Date());//业务日期
   				ssInfo.setProjName(Proj);//项目
   				ssInfo.setProjSoclNum(info.getProjSoclNum());//项目社保号
   				ssInfo.setStopDate(info.getStopDate());//停工日期
   				ssInfo.setRetToWorkDate(info.getRetToWorkDate());//复工日期
   				ssInfo.setDownTimeHours(info.getDownTimeHours());//停工小时数
   				ssInfo.setStoppageBy(info.getStoppageBy());//停工事由
   				ProjBWRAssdFactory.getLocalInstance(ctx).addnew(ssInfo);
//   			}
		}else{
			//反审核，删除
//			Set set = new HashSet();
//			EntityViewInfo view = new EntityViewInfo();
//			FilterInfo filter = new FilterInfo();
//			ProjBWREtyEntryCollection entryCol = info.getEntrys();
//			for (int i = 0; i < entryCol.size(); i++) {
//				ProjBWREtyEntryInfo entryInfo = entryCol.get(i);
//				String id = entryInfo.getId().toString();
//				set.add(id);
//				filter.getFilterItems().add(new FilterItemInfo("sourceI", set, CompareType.INCLUDE));
//				ProjBWRAssdFactory.getLocalInstance(ctx).delete(filter);
//			}
			FilterInfo filter = new FilterInfo();
			AdminOrgUnitInfo Proj = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(info.getProjName()==null?null:info.getProjName().getId()));
			filter.getFilterItems().add(new FilterItemInfo("sourceBillId",info.getId().toString()));
			ProjBWRAssdFactory.getLocalInstance(ctx).delete(filter);
		}
		
	}
	private boolean isSecuSplit(Context ctx, ProjBWREtyInfo info) throws BOSException {
		AdminOrgUnitInfo  proj = info.getProjName();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("projName.name",proj==null?null:proj.getName()));
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		ProjBWRAssdCollection  ssCol = ProjBWRAssdFactory.getLocalInstance(ctx).getProjBWRAssdCollection(view);
		if (ssCol.size()>0) {
			return true;
		}else{
			return false;
		}
	}
	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("projName");
		//sic.add("sourceBillId");
		sic.add("*");
		sic.add("entrys.*");
		return sic;
	}
}