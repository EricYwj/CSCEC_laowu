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
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.certificates.app.visaTypeEnum;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryCollection;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.eas.zjlw.social.InsurePersonCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryFactory;
import com.kingdee.eas.zjlw.social.InsurePersonEntryInfo;
import com.kingdee.eas.zjlw.social.InsurePersonFactory;
import com.kingdee.eas.zjlw.social.InsurePersonInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LocalInfoControllerBean extends AbstractLocalInfoControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.personmess.app.LocalInfoControllerBean");
    // 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		LocalInfoInfo accInfo = (LocalInfoInfo) model;
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
    	LocalInfoInfo accInfo = (LocalInfoInfo) model;
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
    	LocalInfoInfo info = (LocalInfoInfo) getValue(ctx, pk, getSelector());

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
		//writePersonHis(ctx,info);
		//InsurePerson(ctx,info);
    }
 // 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		LocalInfoInfo info = (LocalInfoInfo) getValue(ctx, pk,getSelector());
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
	//审核通过，判断人员历史信息中是否存在，如果存在，删除人员历史信息，如果不存在，回写人员历史信息
//	protected void writePersonHis(Context ctx,LocalInfoInfo info) throws EASBizException, BOSException{
//		LocalInfoEntryCollection  entryCol = info.getEntrys();
//		for(int i=0;i<entryCol.size();i++){
//			LocalInfoEntryInfo entryInfo = entryCol.get(i);
//			EntityViewInfo view = new EntityViewInfo();
//	    	FilterInfo filter = new FilterInfo();
//			String securityNo=entryInfo.getSecurityNo();
//			filter.getFilterItems().add(new FilterItemInfo("securityNo",securityNo));
//			//view.setFilter(filter);
//			PersonHistoryFactory.getLocalInstance(ctx).delete(filter);
//			PersonHistoryInfo hisInfo = new PersonHistoryInfo();
//			hisInfo.setId(BOSUuid.create(hisInfo.getBOSType()));
//			hisInfo.setSourceBillId(entryInfo.getId().toString());
//			hisInfo.setNumber(info.getNumber());//单据编号
//			hisInfo.setAuditor(info.getAuditor());//审核人
//			hisInfo.setNameCN(entryInfo.getFirstName()+entryInfo.getLastName());//姓名
//			hisInfo.setSex(entryInfo.getSex());//性别
//			hisInfo.setBirthDate(entryInfo.getBirthdate());//出生日期
//			ProvinceInfo provInfo = ProvinceFactory.getLocalInstance(ctx).getProvinceInfo(new ObjectUuidPK(entryInfo.getBirthPlace().getId()));
//			hisInfo.setBirthPlaceCn(provInfo.getDescription());//出生地
//			hisInfo.setMerState(entryInfo.getMaritalStatus());//婚姻状态
//			hisInfo.setFatherName(entryInfo.getFatherName());//父亲姓名
//			hisInfo.setMotherName(entryInfo.getMotherName());//母亲姓名
//			hisInfo.setSecurityNo(entryInfo.getSecurityNo());// 社保号码
//			hisInfo.setWorkOrg(entryInfo.getWorkProgram());//工作项目
//			hisInfo.setCooperation(entryInfo.getCooperation());//合作单位
//			hisInfo.setBsnisState(perBizStateEnum.MESSINPUT);//人员业务状态
//			hisInfo.setVisaType(visaTypeEnum.local);//签证类型
//			PersonHistoryFactory.getLocalInstance(ctx).addnew(hisInfo);
//		}
//	}
	 //反审核删除人员历史信息中的数据
//    public void deletePersonHis(Context ctx,LocalInfoInfo info) throws BOSException, EASBizException{
//    	Set set=new HashSet();
//    	EntityViewInfo view=new EntityViewInfo();
//    	FilterInfo filter=new FilterInfo();
//    	LocalInfoEntryCollection entryCol=info.getEntrys();
//    	for(int i=0;i<entryCol.size();i++){
//    		LocalInfoEntryInfo entryInfo=entryCol.get(i);
//    		String id=entryInfo.getId().toString();
//    		set.add(id);
//    	}
//    	filter.getFilterItems().add(new FilterItemInfo("sourceBillId",set,CompareType.INCLUDE));
//    	PersonHistoryFactory.getLocalInstance(ctx).delete(filter);
//    }
    //审核通过反写阿工参保人员名单
//    protected void InsurePerson(Context ctx,LocalInfoInfo info) throws EASBizException, BOSException{
//    	LocalInfoEntryCollection  entryCol = info.getEntrys();
//    	EntityViewInfo view = new EntityViewInfo();
//    	FilterInfo filter = new FilterInfo();
//    	for(int i=0;i<entryCol.size();i++){
//			LocalInfoEntryInfo loEntryInfo = entryCol.get(i);
//			String securityNo=loEntryInfo.getSecurityNo();
//			AdminOrgUnitInfo adInfo=(AdminOrgUnitInfo)loEntryInfo.getWorkProgram();
//			BOSUuid id=adInfo.getId();
//			filter.getFilterItems().add(new FilterItemInfo("workProgram.id",id,CompareType.INCLUDE));
//			//filter.getFilterItems().add(new FilterItemInfo("entrys.securityNo",securityNo,CompareType.NOTINCLUDE));
//			view.setFilter(filter);
//			InsurePersonCollection col=InsurePersonFactory.getLocalInstance(ctx).getInsurePersonCollection();
//			if(col!=null&&col.size()>0){
//				InsurePersonInfo ipInfo=col.get(i);
//				InsurePersonEntryInfo ipEntryInfo=new InsurePersonEntryInfo();
//				ipEntryInfo.setLastName(loEntryInfo.getLastName());//姓
//				ipEntryInfo.setFirstName(loEntryInfo.getFirstName());//名
//				ipEntryInfo.setSex(loEntryInfo.getSex());//性别
//				ipEntryInfo.setBirthdate(loEntryInfo.getBirthdate());//出生日期
//				//ipEntryInfo.setProvince(loEntryInfo.getProvinces());//省份
//				ipEntryInfo.setBirthPlaceCn(loEntryInfo.getBirthPlaceCn());//出生地
//				ipEntryInfo.setMaritalStatus(loEntryInfo.getMaritalStatus());//婚姻状况
//				ipEntryInfo.setFatherName(loEntryInfo.getFatherName());//父亲姓名
//				ipEntryInfo.setMotherName(loEntryInfo.getMotherName());//母亲姓名
//				ipEntryInfo.setTelephone(loEntryInfo.getTelephone());//联系方式
//				ipEntryInfo.setSecurityNo(loEntryInfo.getSecurityNo());//社保号
//				ipEntryInfo.setCCPNo(loEntryInfo.getCCPNo());//CCPN账号
//				ipEntryInfo.setAddress(loEntryInfo.getAddress());//家庭住址
//				ipEntryInfo.setWorkProgram(loEntryInfo.getWorkProgram());//工作项目
//				ipEntryInfo.setCooperation(loEntryInfo.getCooperation());//合作单位
//				ipEntryInfo.setCooperationId(loEntryInfo.getCooperationId());//合作单位代码
//				ipEntryInfo.setProfession(loEntryInfo.getProf());//工种
//				ipEntryInfo.setContractNo(loEntryInfo.getContractNo());//合同编号
//				ipEntryInfo.setApproachTime(loEntryInfo.getApproachTime());//进场日期
//				ipEntryInfo.setContrachSigDate(loEntryInfo.getContrachSigDate());//合同签订日期
//				ipEntryInfo.setContractTime(loEntryInfo.getContractTime());//合同到期日期
//				ipInfo.getEntrys().add(ipEntryInfo);
//				InsurePersonEntryFactory.getLocalInstance(ctx).addnew(ipEntryInfo);
//			}else{
//				InsurePersonInfo ipInfo=new InsurePersonInfo();
//				ipInfo.setId(BOSUuid.create(ipInfo.getBOSType()));
//				ipInfo.setSourceBillId(info.getId().toString());
//				ipInfo.setNumber(info.getNumber());
//				ipInfo.setBizDate(info.getBizDate());
//				ipInfo.setBillSate(BillStateEnum.DRAFT);
//				InsurePersonEntryInfo ipEntryInfo=new InsurePersonEntryInfo();
//				//分录
//				ipEntryInfo.setLastName(loEntryInfo.getLastName());//姓
//				ipEntryInfo.setFirstName(loEntryInfo.getFirstName());//名
//				ipEntryInfo.setSex(loEntryInfo.getSex());//性别
//				ipEntryInfo.setBirthdate(loEntryInfo.getBirthdate());//出生日期
//				//ipEntryInfo.setProvince(loEntryInfo.getProvinces());//省份
//				ipEntryInfo.setBirthPlaceCn(loEntryInfo.getBirthPlaceCn());//出生地
//				ipEntryInfo.setMaritalStatus(loEntryInfo.getMaritalStatus());//婚姻状况
//				ipEntryInfo.setFatherName(loEntryInfo.getFatherName());//父亲姓名
//				ipEntryInfo.setMotherName(loEntryInfo.getMotherName());//母亲姓名
//				ipEntryInfo.setTelephone(loEntryInfo.getTelephone());//联系方式
//				ipEntryInfo.setSecurityNo(loEntryInfo.getSecurityNo());//社保号
//				ipEntryInfo.setCCPNo(loEntryInfo.getCCPNo());//CCPN账号
//				ipEntryInfo.setAddress(loEntryInfo.getAddress());//家庭住址
//				ipEntryInfo.setWorkProgram(loEntryInfo.getWorkProgram());//工作项目
//				ipEntryInfo.setCooperation(loEntryInfo.getCooperation());//合作单位
//				ipEntryInfo.setCooperationId(loEntryInfo.getCooperationId());//合作单位代码
//				ipEntryInfo.setProfession(loEntryInfo.getProf());//工种
//				ipEntryInfo.setContractNo(loEntryInfo.getContractNo());//合同编号
//				ipEntryInfo.setApproachTime(loEntryInfo.getApproachTime());//进场日期
//				ipEntryInfo.setContrachSigDate(loEntryInfo.getContrachSigDate());//合同签订日期
//				ipEntryInfo.setContractTime(loEntryInfo.getContractTime());//合同到期日期
//				ipInfo.getEntrys().add(ipEntryInfo);
//				InsurePersonFactory.getLocalInstance(ctx).addnew(ipInfo);
//			}
//    	}
//    	
//    	
//    }
	protected SelectorItemCollection getSelector(){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("billSate");
			sic.add("number");
			sic.add("company.id");
			sic.add("entrys.*");
			return sic;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}