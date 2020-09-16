package com.kingdee.eas.zjlw.personmess.app;

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
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.certificates.app.visaTypeEnum;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntry;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaFactory;
import com.kingdee.eas.zjlw.personmess.BusinessVisaInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaCollection;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BusinessVisaControllerBean extends AbstractBusinessVisaControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.personmess.app.BusinessVisaControllerBean");
   // 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		BusinessVisaInfo accInfo = (BusinessVisaInfo) model;
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
    	BusinessVisaInfo accInfo = (BusinessVisaInfo) model;
    	accInfo.setBillSate(BillStateEnum.SUBMIT);
	   	//设置编码
    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
    		AdminOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentAdmin();
    		String orgId = currentCompany.getId().toString();
    		ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
    		if(codFactory.isExist(accInfo, orgId)){
    			//不允许断号
    			if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
    				accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
    			}else{
    				if(codFactory.isAddView(accInfo, orgId)){//新增显示

    				}else{//什么都没勾选
    					accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
    				}
    			}
    		}
    	}
    	return super._submit(ctx, accInfo);
    }
    //审核通过
    protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)
    		throws EASBizException, BOSException {
    	BusinessVisaInfo info = (BusinessVisaInfo) getValue(ctx, pk, getSelector());

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
		writePersonHis(ctx,info);
    }
    // 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		BusinessVisaInfo info = (BusinessVisaInfo) getValue(ctx, pk,
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
		deletePersonHis(ctx,info);
	}
	//审核通过，判断人员历史信息中是否存在，如果存在，删除人员历史信息，如果不存在，回写人员历史信息
	protected void writePersonHis(Context ctx,BusinessVisaInfo info) throws EASBizException, BOSException{
		BusinessVisaEntryCollection  entryCol = info.getEntrys();
		for(int i=0;i<entryCol.size();i++){
			BusinessVisaEntryInfo entryInfo = entryCol.get(i);
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
			String idNum=entryInfo.getIdNum();
			String passportNo=entryInfo.getPassportNo();
			filter.getFilterItems().add(new FilterItemInfo("idNum",idNum));
			filter.getFilterItems().add(new FilterItemInfo("passportNo",passportNo));
			//filter.setMaskString("#0 or #1");
			//view.setFilter(filter);
			PersonHistoryFactory.getLocalInstance(ctx).delete(filter);
			PersonHistoryInfo hisInfo = new PersonHistoryInfo();
			hisInfo.setId(BOSUuid.create(hisInfo.getBOSType()));
			hisInfo.setSourceBillId(entryInfo.getId().toString());
			hisInfo.setNumber(info.getNumber());//单据编号
			hisInfo.setAuditor(info.getAuditor());//审核人
			hisInfo.setNameCN(entryInfo.getName());//姓名
			hisInfo.setFirstNameAlp(entryInfo.getFirstName());//姓拼音
			hisInfo.setLastNameApl(entryInfo.getLastName());//名拼音
			hisInfo.setSex(entryInfo.getSex());//性别
			hisInfo.setIdNum(entryInfo.getIdNum());//身份证号
			hisInfo.setNation(entryInfo.getNational());//国籍
			hisInfo.setBirthDate(entryInfo.getBirthdate());//出生日期
			hisInfo.setBirthPlaceCn(entryInfo.getBirthPlaceCn());//出生地
			hisInfo.setPassportNo(entryInfo.getPassportNo());//护照号码
			hisInfo.setPassportIssueDate(entryInfo.getPassportIssueDate());//护照签发日期
			hisInfo.setPassportExpireDate(entryInfo.getPassportExpireDate());//护照失效日期
			hisInfo.setFatherName(entryInfo.getFatherName());//父亲姓名
			hisInfo.setMotherName(entryInfo.getMotherName());//母亲姓名
			hisInfo.setCoupleName(entryInfo.getCoupleName());//配偶姓名
			hisInfo.setCooperation(entryInfo.getCooperation());//合作单位
			hisInfo.setWorkOrg(entryInfo.getWorkProgram());//工作项目
			hisInfo.setBsnisState(perBizStateEnum.MESSINPUT);//人员业务状态
			hisInfo.setVisaType(visaTypeEnum.buss);//签证类型
			PersonHistoryFactory.getLocalInstance(ctx).addnew(hisInfo);
		}
	}
	 //反审核删除人员历史信息中的数据
    public void deletePersonHis(Context ctx,BusinessVisaInfo info) throws BOSException, EASBizException{
    	Set set=new HashSet();
    	EntityViewInfo view=new EntityViewInfo();
    	FilterInfo filter=new FilterInfo();
    	BusinessVisaEntryCollection entryCol=info.getEntrys();
    	for(int i=0;i<entryCol.size();i++){
    		BusinessVisaEntryInfo entryInfo=entryCol.get(i);
    		String id=entryInfo.getId().toString();
    		set.add(id);
    	}
    	filter.getFilterItems().add(new FilterItemInfo("sourceBillId",set,CompareType.INCLUDE));
    	PersonHistoryFactory.getLocalInstance(ctx).delete(filter);
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