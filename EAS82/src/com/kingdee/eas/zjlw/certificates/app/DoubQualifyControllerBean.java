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
import com.kingdee.bos.bi.model.common.mm.general.Filtering;
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
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeEntryCollection;
import com.kingdee.eas.zjlw.certificates.FiIncomeEntryInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationCollection;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryCollection;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryFactory;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationFactory;
import com.kingdee.eas.zjlw.certificates.ImmigrationInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyInfo;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DoubQualifyControllerBean extends AbstractDoubQualifyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.DoubQualifyControllerBean");
 // 保存
    protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
    	DoubQualifyInfo accInfo = (DoubQualifyInfo) model;
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
    	DoubQualifyInfo accInfo = (DoubQualifyInfo) model;
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
    protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
    	DoubQualifyInfo info = (DoubQualifyInfo) getValue(ctx, pk, getSelector());
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
		dealAll(ctx,info,true);
    }
    
	// 审核不通过
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
		DoubQualifyInfo info = (DoubQualifyInfo) getValue(ctx, pk,getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("billSate", "30", CompareType.NOTEQUALS));
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
		dealAll(ctx,info,false);
	}
	
	private void dealAll(Context ctx,DoubQualifyInfo info,boolean isAudit) throws EASBizException, BOSException {
		DoubQualifyEntryCollection entryCol = info.getEntrys();
		DoubQualifyEntryInfo entryInfo = new DoubQualifyEntryInfo();
		if(!info.isIfNeed()){
			for (int i = 0; i < entryCol.size(); i++) {
				entryInfo = entryCol.get(i);
				boolean ifilen = entryInfo.isIsIfilentry();//是否违规入境
				boolean ifStop = entryInfo.isIfstop();//是否停办
				if(ifilen == false){
					if(ifStop == true){
						//writePersonHis(ctx,entryInfo,isAudit,ifStop);// 反写人员历史信息状态(审核：双认证停办状态,反审核：信息录入)
						writeProjectWork(ctx, entryInfo.getPmtProf().getId().toString(),isAudit);//同时改变指 标工种数量
					}else{
						//writePersonHis(ctx,entryInfo,isAudit,ifStop); // 反写人员历史信息状态(审核：双认证办理,反审核：信息录入)
						writeImmi(ctx,info,entryInfo,isAudit,ifilen); //反写入境表体认证完成日期=双认证表体双认证办理完成时间
					}
				}else{
					writeImmi(ctx,info,entryInfo,isAudit,ifilen);//反写入境表体违规入境为true
				}
			}
		}
	}
	
	/**
	 * 反写入境中双认证完成时间和是否违规入境
	 * 非违规入境
	 * 		审核通过：入境单据-“双认证办理完成时间” = 双认证-“认证完成日期”
	 * 		反审核：入境单据-“双认证办理完成时间” = null
	 * 违规入境
	 * 		违规入境：true/false
	 * @param ctx
	 * @param info
	 * @param isAudit
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	private void writeImmi(Context ctx,DoubQualifyInfo info,DoubQualifyEntryInfo entryInfo,boolean isAudit,boolean ifilen) throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("dbCmpTime");
		sic.add("qualDate");
		SelectorItemCollection sic1 = new SelectorItemCollection();
		sic1.add("ifUnexpect");
		String idNum = entryInfo.getIdNum();//身份证号
		String passpNo = entryInfo.getPasspNo();//护照号码
		String number = info.getNumber();//批次号
		Date qualDate = entryInfo.getQualDate();//双认证完成日期
		FilterInfo filter = new FilterInfo();
//		filter.getFilterItems().add(new FilterItemInfo("IdNum",idNum));
//		filter.getFilterItems().add(new FilterItemInfo("passpNum",passpNo));
//		filter.getFilterItems().add(new FilterItemInfo("parent.number",number));
		filter.getFilterItems().add(new FilterItemInfo("personID",entryInfo.getPersonID()));
		EntityViewInfo ev = new EntityViewInfo();
		ev.setFilter(filter);
		//申请入境
		ImmigrationEntryCollection immiEntryCol = ImmigrationEntryFactory.getLocalInstance(ctx).getImmigrationEntryCollection(ev);
		for (int j = 0; j < immiEntryCol.size(); j++) {
			ImmigrationEntryInfo immiEntryInfo = immiEntryCol.get(j);
			if (ifilen) {//违规入境
				immiEntryInfo.setIfUnexpect(isAudit);
				ImmigrationEntryFactory.getLocalInstance(ctx).updatePartial(immiEntryInfo, sic1);
			}else{//正常办理
				immiEntryInfo.setDbCmpTime(isAudit ? qualDate : null);
				ImmigrationEntryFactory.getLocalInstance(ctx).updatePartial(immiEntryInfo, sic);
			}
		}
		//劳动证办理
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("personID",entryInfo.getPersonID()));
		ev = new EntityViewInfo();
		ev.setFilter(filter);
		WorkPmtEntryCollection wpCol = WorkPmtEntryFactory.getLocalInstance(ctx).getWorkPmtEntryCollection(ev);
		for (int j = 0; j < wpCol.size(); j++) {
			WorkPmtEntryInfo wpInfo = wpCol.get(j);
			wpInfo.setQualDate(isAudit ? qualDate : null);
			WorkPmtEntryFactory.getLocalInstance(ctx).updatePartial(wpInfo, sic);
		}
	}
	
	//更新人员历史信息中人员业务状态
	private void writePersonHis(Context ctx,DoubQualifyEntryInfo entryInfo,boolean isAudit,boolean ifStop) throws EASBizException, BOSException{
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("bsnisState");
		sic.add("hBsnisState");
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		String idNum = entryInfo.getIdNum();
		String passportNo = entryInfo.getPasspNo();
		filter.getFilterItems().add(new FilterItemInfo("idNum", idNum));
		filter.getFilterItems().add(new FilterItemInfo("passportNo", passportNo));
//		filter.setMaskString("#0 or #1");
		view.setFilter(filter);
		view.setSelector(sic);
		PersonHistoryCollection person = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
		PersonHistoryInfo newper =person.get(0);
		perBizStateEnum hState = newper.getHBsnisState();
		newper.setHBsnisState(newper.getBsnisState());
		if(isAudit){//审核通过：停办：为双认证停办状态；非停办：双认证办理
			newper.setBsnisState(ifStop ? perBizStateEnum.CERTISTOP : perBizStateEnum.CERTIFICATION);
		}else{//反审核：为信息录入状态
			newper.setBsnisState(hState);
		} 
		PersonHistoryFactory.getLocalInstance(ctx).updatePartial(newper, sic);
	}
	
	/**
	 * 更改指标数量
	 * @param ctx
	 * @param id
	 * @param isAudit
	 * @throws EASBizException
	 * @throws BOSException
	 */
	private void writeProjectWork(Context ctx, String id, boolean audMark)throws EASBizException, BOSException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("useAmount");
		sic.add("leftAmount");
		sic.add("totalAmount");
		if (id != null && !"".equals(id)) {
			ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx).getProjectWorkInfo(new ObjectUuidPK(id), sic);
			if (audMark) {//停办审核通过，更改指标，工种使用数量减一
				pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
			} else {//停办反审核，更改指标，工种使用数量加一
				pwInfo.setUseAmount(pwInfo.getUseAmount() + 1);
			}
			pwInfo.setLeftAmount(pwInfo.getTotalAmount()- pwInfo.getUseAmount());
			ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
		}
		
	}
	
	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		sic.add("bNum");
		sic.add("ifNeed");
		
		return sic;
	}
}