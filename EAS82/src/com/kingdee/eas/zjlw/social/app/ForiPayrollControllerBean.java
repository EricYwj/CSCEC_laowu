package com.kingdee.eas.zjlw.social.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.metadata.IMetaDataPK;
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
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.certificates.IfilentryFactory;
import com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.social.ForiCheckedEntryCollection;
import com.kingdee.eas.zjlw.social.ForiCheckedEntryInfo;
import com.kingdee.eas.zjlw.social.ForiCheckedInfo;
import com.kingdee.eas.zjlw.social.ForiPayrollCollection;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryCollection;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryFactory;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryInfo;
import com.kingdee.eas.zjlw.social.ForiPersEntryFactory;
import com.kingdee.eas.zjlw.social.ForiPersEntryInfo;
import com.kingdee.eas.zjlw.social.PayrollEntryCollection;
import com.kingdee.eas.zjlw.social.PayrollEntryInfo;
import com.kingdee.eas.zjlw.social.PayrollInfo;
import com.kingdee.eas.zjlw.social.SecuPayCountCollection;
import com.kingdee.eas.zjlw.social.SecuPayCountFactory;
import com.kingdee.eas.zjlw.social.SecuPayCountInfo;
import com.kingdee.eas.zjlw.social.SecuSplitCollection;
import com.kingdee.eas.zjlw.social.SecuSplitEntryInfo;
import com.kingdee.eas.zjlw.social.SecuSplitFactory;
import com.kingdee.eas.zjlw.social.SecuSplitInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.zjlw.social.ForiPayrollInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ForiPayrollControllerBean extends AbstractForiPayrollControllerBean
{
    private static Logger logger = Logger.getLogger("com.kingdee.eas.zjlw.social.app.ForiPayrollControllerBean");
    

	/**
	 * 更新错误数据
	 * 
	 * @author ywj 2018-7-3
	 */
	protected void _updateErrData(Context ctx,String projId) throws BOSException {
		// 获取工资数据分录集合
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("*");
		EntityViewInfo view = new EntityViewInfo();
		view.setSelector(sic);
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("parent.projName.id",projId));
		view.setFilter(filter);
		ForiPayrollEntryCollection foriPayrollEtyCol = ForiPayrollEntryFactory.getLocalInstance(ctx).getForiPayrollEntryCollection(view);
		// 循环工资数据分录集合，查询对应的参保人员名单，更新personid
		if (foriPayrollEtyCol != null && foriPayrollEtyCol.size() > 0) {
			for (int i = 0; i < foriPayrollEtyCol.size(); i++) {
				ForiPayrollEntryInfo ForiPayrollEtyInfo = foriPayrollEtyCol.get(i);
				String insurePrsPersonId;
				try {
					insurePrsPersonId = getInsurePrsEtyCol(ctx, ForiPayrollEtyInfo);
					if (insurePrsPersonId != null && !"".equals(insurePrsPersonId))
						updateData(ctx, ForiPayrollEtyInfo.getPersonID(), insurePrsPersonId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 更新错误数据
	 * 
	 * @author ywj 2018-7-3
	 * @param ctx
	 * @param personID
	 * @param insurePrsPersonId
	 * @throws BOSException
	 */
	private void updateData(Context ctx, String personID, String insurePrsPersonId) throws BOSException {
		// 备份personId
		String bakUpSql = "update CT_SOC_ForiPayrollEntry set cfOripersonid = '" + personID + "' where cfpersonid = '" + personID + "'";
		DbUtil.execute(ctx, bakUpSql);
		// 更新personId
		String updateSql = "update CT_SOC_ForiPayrollEntry set cfpersonid = '" + insurePrsPersonId + "' where cfpersonid = '" + personID + "'";
		DbUtil.execute(ctx, updateSql);
	}

	/**
	 * 获取参保人员名单 (姓and名and社保项目)
	 * 
	 * @param ctx
	 * @param ForiPayrollEtyInfo
	 * @return
	 * @throws BOSException
	 * @throws SQLException
	 */
	private String getInsurePrsEtyCol(Context ctx, ForiPayrollEntryInfo ForiPayrollEtyInfo) throws BOSException, SQLException {
		String payRolletyFid = "";
		String personid = "";
		if (ForiPayrollEtyInfo.getId() != null) {
			payRolletyFid = ForiPayrollEtyInfo.getId().toString();
		}
		if (payRolletyFid != null && !"".equals(payRolletyFid)) {
			String lastName = ForiPayrollEtyInfo.getLastName();
			String firstName = ForiPayrollEtyInfo.getFirstName();
			String secuNo = ForiPayrollEtyInfo.getSecurityNo();
			String ccpNo = ForiPayrollEtyInfo.getCCPNo();
			// FilterInfo filter = new FilterInfo();
			// EntityViewInfo view = new EntityViewInfo();
			// SelectorItemCollection sic = new SelectorItemCollection();
			// filter.getFilterItems().add(new FilterItemInfo("parent.permitOrg.id", payRollProj));
			// filter.getFilterItems().add(new FilterItemInfo("lastName", lastName));
			// filter.getFilterItems().add(new FilterItemInfo("firstName", firstName));
			// filter.getFilterItems().add(new FilterItemInfo("replace(cfse,' ','')", firstName));
			// sic.add("*");
			// view.setFilter(filter);
			// view.setSelector(sic);
			// ForiPersEntryCollection insurePrsEtyCol = ForiPersEntryFactory.getLocalInstance(ctx).getForiPersEntryCollection(view);
			StringBuffer getIPpersonIdsql = new StringBuffer();
			getIPpersonIdsql.append("    SELECT                                ");
			getIPpersonIdsql.append("         ipety.cfpersonid  as personid                              ");
			getIPpersonIdsql.append("     FROM");
			getIPpersonIdsql.append("         CT_SOC_ForiPersEntry ipety   ");
			getIPpersonIdsql.append("     LEFT OUTER JOIN");
			getIPpersonIdsql.append("         CT_SOC_ForiPers ip       ");
			getIPpersonIdsql.append("             on ipety.fparentid = ip.fid   ");
			getIPpersonIdsql.append("     where");
			getIPpersonIdsql.append("          ip.cfpermitorgid = ( SELECT cfprojnameid  FROM CT_SOC_ForiPayrollEntry ety  LEFT OUTER JOIN CT_SOC_ForiPayroll bill  on ety.fparentid = bill.fid  where ety.fid = '");
			getIPpersonIdsql.append(payRolletyFid.replaceAll(" ", ""));
			getIPpersonIdsql.append("' and rownum = 1 ) ");
			getIPpersonIdsql.append("         and (");
			getIPpersonIdsql.append("             (");
			getIPpersonIdsql.append("                 replace(ipety.cfsecurityno,' ','') = '");
			if (secuNo != null && !"".equals(secuNo))
				getIPpersonIdsql.append(secuNo.replaceAll(" ", ""));
			getIPpersonIdsql.append("'");
			getIPpersonIdsql.append("                 or replace(ipety.cfccpno,' ','') = '");
			if (ccpNo != null && !"".equals(ccpNo))
				getIPpersonIdsql.append(ccpNo.replaceAll(" ", ""));
			getIPpersonIdsql.append("'");
			getIPpersonIdsql.append("             )              ");
			getIPpersonIdsql.append("             or(");
			getIPpersonIdsql.append("                 ipety.cffirstnameapl = '");
			if (firstName != null && !"".equals(firstName))
				getIPpersonIdsql.append(firstName.replaceAll("'", "''"));
			getIPpersonIdsql.append("'");
			getIPpersonIdsql.append("                 and ipety.cflastnameapl = '");
			if (lastName != null && !"".equals(lastName))
				getIPpersonIdsql.append(lastName.replaceAll("'", "''"));
			getIPpersonIdsql.append("'");
			getIPpersonIdsql.append(")                ");
			getIPpersonIdsql.append(") group by cfpersonid");
			IRowSet rowSet = DbUtil.executeQuery(ctx, getIPpersonIdsql.toString());
			while (rowSet.next()) {
				personid = rowSet.getString("personid");
			}
		}
		return personid;
	}
    
    // 保存
   	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
   		ForiPayrollInfo accInfo = (ForiPayrollInfo) model;
   		accInfo.setBillSate(BillStateEnum.DRAFT);
   		//设置编码
//       	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
//       	CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
//       	String orgId = currentCompany.getId().toString();
//       	ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
//   	    	if(codFactory.isExist(accInfo, orgId)){
//   	    		//不允许断号
//   	    		if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
//   	    			accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//   	    		}else{
//   	    			if(codFactory.isAddView(accInfo, orgId)){//新增显示
//   	    				
//   	    			}else{//什么都没勾选
//   	    				accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//   	    			}
//   	    		}
//   	    	}
//       	}
   		return super._save(ctx, accInfo);
   	}
   	//提交 
       protected IObjectPK _submit(Context ctx, IObjectValue model)throws BOSException, EASBizException {
    	ForiPayrollInfo accInfo = (ForiPayrollInfo) model;
       	accInfo.setBillSate(BillStateEnum.SUBMIT);
       	//设置编码
//       	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
//       		CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
//       		String orgId = currentCompany.getId().toString();
//       		ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
//       		if(codFactory.isExist(accInfo, orgId)){
//       			//不允许断号
//       			if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
//       				accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//       			}else{
//       				if(codFactory.isAddView(accInfo, orgId)){//新增显示
   //
//       				}else{//什么都没勾选
//       					accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//       				}
//       			}
//       		}
//       	}
       	return super._submit(ctx, accInfo);
       }
       
       /**
        * 审核通过
        */
       protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
    	ForiPayrollInfo info = (ForiPayrollInfo) getValue(ctx, pk, getSelector());
   		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),pk, info.getNumber());
   		SelectorItemCollection sic = new SelectorItemCollection();
   		sic.add("billSate");
   		sic.add("auditor");
   		sic.add("AuditDate");
   		info.setBillSate(BillStateEnum.CHECKED);
   		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
   		info.setAuditDate(new Date());
   		updatePartial(ctx, info, sic);
   		LogUtil.afterLog(ctx, logPK);
   		dealAll(ctx, info,true);
   		writeBack(ctx, info,true);
       }
   
	/**
   	 * 审核不通过
   	 */
   	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
   		ForiPayrollInfo info = (ForiPayrollInfo) getValue(ctx, pk,getSelector());
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
   		dealAll(ctx, info,false);
   	}
   	private void writeBack(Context ctx, ForiPayrollInfo info, boolean audit) throws EASBizException, BOSException {
		// 反写参保人员
		writeBackIns(ctx, info, audit);
	}
	/**
	 * 反写参保人员
	 */
   	private void writeBackIns(Context ctx, ForiPayrollInfo info, boolean audit) throws BOSException, EASBizException {
   		ForiPayrollEntryCollection foriEntryCol = info.getEntrys();
   		for (int i = 0; i < foriEntryCol.size(); i++) {
   			ForiPayrollEntryInfo entryInfo = foriEntryCol.get(i);
   			String personID = entryInfo.getPersonID();
   			//String foriPersId = entryInfo.getForiPersID();
   			FilterInfo filter = new FilterInfo();
   			EntityViewInfo view = new EntityViewInfo();
   			filter.getFilterItems().add(new FilterItemInfo("personID",personID));
   			view.setFilter(filter);
   			ForiPersEntryInfo insEntryInfo = ForiPersEntryFactory.getLocalInstance(ctx).getForiPersEntryCollection(view).get(0);
   			if (insEntryInfo!=null) {
   				insEntryInfo.setForiPersID(entryInfo.getForiPersID());
   				insEntryInfo.setForiPersID(entryInfo.getForiPersID());//外会人员编码
   	   			SelectorItemCollection sic = new SelectorItemCollection();
   	   			sic.add("foriPersID");
   	   			ForiPersEntryFactory.getLocalInstance(ctx).updatePartial(insEntryInfo, sic);
			}
   		}
	}
   	
   	/**
   	 * 处理所有事物
   	 * @param ctx
   	 * @param info
   	 * @param audit
   	 * @throws BOSException 
   	 * @throws EASBizException 
   	 */
	public void dealAll(Context ctx, ForiPayrollInfo info, boolean audit) throws BOSException, EASBizException {
		//生成社保分摊表
		initBlankSecuSplit(ctx, info,audit);
		//生成分摊汇总表
		initBlankSecuPayCount(ctx, info,audit);
//		dealSecuSplit(ctx, info,audit);
	}
	private void initBlankSecuSplit(Context ctx, ForiPayrollInfo info, boolean audit) throws BOSException, EASBizException {
		//审核或反审核
   		if (audit) {
			//审核，生成分摊表
   			if (!isSecuSplit(ctx,info)) {//无分摊表数据
   				AdminOrgUnitInfo Proj = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(info.getProjName()==null?null:info.getProjName().getId()));
   				PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo((new ObjectUuidPK(info.getMonthYearr()==null?null:info.getMonthYearr().getId())));
   				SecuSplitInfo ssInfo = new SecuSplitInfo();
   				ssInfo.setId(BOSUuid.create(ssInfo.getBOSType()));
   				ssInfo.setSourceBillId(info.getId().toString());
   				ssInfo.setNumber(info.getNumber());//单据编号
   				ssInfo.setBillSate(BillStateEnum.DRAFT);//单据状态
   				ssInfo.setBizDate(new Date());//业务日期
   				ssInfo.setProjName(Proj);//项目
   				ssInfo.setMonthYearr(monthYear);//年月
   				SecuSplitFactory.getLocalInstance(ctx).addnew(ssInfo);
   			}
		}else{
			//反审核，删除
			FilterInfo filter = new FilterInfo();
			AdminOrgUnitInfo Proj = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(info.getProjName()==null?null:info.getProjName().getId()));
			PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo((new ObjectUuidPK(info.getMonthYearr()==null?null:info.getMonthYearr().getId())));
			filter.getFilterItems().add(new FilterItemInfo("projName.id",Proj.getId()));
			filter.getFilterItems().add(new FilterItemInfo("monthYearr.id",monthYear.getId()));
			SecuSplitFactory.getLocalInstance(ctx).delete(filter);
		}
		
	}
	/**
	 * 判断是否已经有分摊表数据
	 * @param ctx
	 * @param info
	 * @return true:有数据；false:无数据
	 * @throws BOSException 
	 */
	private boolean isSecuSplit(Context ctx, ForiPayrollInfo info) throws BOSException {
		PeriodInfo monthYear = info.getMonthYearr();
		AdminOrgUnitInfo  proj = info.getProjName();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("monthYearr.id",monthYear==null?null:monthYear.getId()));
		filter.getFilterItems().add(new FilterItemInfo("projName.id",proj==null?null:proj.getId()));
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		SecuSplitCollection  ssCol = SecuSplitFactory.getLocalInstance(ctx).getSecuSplitCollection(view);
		if (ssCol.size()>0) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 生成分摊汇总表
	 * @param ctx
	 * @param info
	 * @param audit
	 * @throws EASBizException
	 * @throws BOSException
	 */
	private void initBlankSecuPayCount(Context ctx, ForiPayrollInfo info,boolean audit) throws EASBizException, BOSException {
		//审核或反审核
   		if (audit) {
			//审核，生成汇总表
   			if (!isSecuPayCount(ctx,info)) {//无汇总表数据
   				BelongAreaEnum area = getArea(ctx,info);
   				PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo((new ObjectUuidPK(info.getMonthYearr()==null?null:info.getMonthYearr().getId())));
   				SecuPayCountInfo ssInfo = new SecuPayCountInfo();
   				ssInfo.setId(BOSUuid.create(ssInfo.getBOSType()));
   				ssInfo.setSourceBillId(info.getId().toString());
   				ssInfo.setNumber(info.getNumber());//单据编号
   				ssInfo.setBillSate(BillStateEnum.DRAFT);//单据状态
   				ssInfo.setBizDate(new Date());//业务日期
   				ssInfo.setMonthYear(monthYear);//年月
   				ssInfo.setAera(area);
   				SecuPayCountFactory.getLocalInstance(ctx).addnew(ssInfo);
   			}
   		}
//		}else{
//			//反审核，删除
//			FilterInfo filter = new FilterInfo();
//			PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo((new ObjectUuidPK(info.getMonthYearr()==null?null:info.getMonthYearr().getId())));
//			filter.getFilterItems().add(new FilterItemInfo("monthYear.id",monthYear.getId()));
//			SecuSplitFactory.getLocalInstance(ctx).delete(filter);
//		}
		
	}
	/**
	 * 判断是否已经有汇总表表数据
	 * @param ctx
	 * @param info
	 * @return true:有数据；false:无数据
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private boolean isSecuPayCount(Context ctx, ForiPayrollInfo info) throws BOSException, EASBizException {
		PeriodInfo my = info.getMonthYearr();
		PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(my.getId()));
		BelongAreaEnum area = getArea(ctx,info);
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("monthYear.id",monthYear==null?null:monthYear.getId()));
		filter.getFilterItems().add(new FilterItemInfo("aera",area));
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		SecuPayCountCollection  ssCol = SecuPayCountFactory.getLocalInstance(ctx).getSecuPayCountCollection(view);
		if (ssCol.size()>0) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 查询项目所属区域
	 * @author yingwj
	 * @date 2016-10-3
	 * @param ctx
	 * @param info
	 * @return 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private BelongAreaEnum getArea(Context ctx, ForiPayrollInfo info) throws EASBizException, BOSException {
		AdminOrgUnitInfo secu = info.getProjName();
		AdminOrgUnitInfo secuInfo = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(secu.getId()));
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("proCom.id",secuInfo.getId().toString()));
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("area");
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		view.setSelector(sic);
		ProjectOrgInfo proj = ProjectOrgFactory.getLocalInstance(ctx).getProjectOrgCollection(view).get(0);
		BelongAreaEnum area = null;
		if (proj != null) {
			area = proj.getArea();
		}
		return area;
	}
   	
	/**
	 * 生成社保分摊表
	 * @param ctx
	 * @param info
	 * @param audit
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	protected SelectorItemCollection getSelector() {
   		SelectorItemCollection sic = new SelectorItemCollection();
   		sic.add("billSate");
   		sic.add("number");
   		sic.add("entrys.*");
   		sic.add("projName");
   		sic.add("monthYearr");
   		return sic;
   	}
}