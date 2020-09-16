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
import com.kingdee.bos.metadata.MetaDataPK; // import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean; // import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.ctrl.kdf.table.IRow;
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
import com.kingdee.eas.zjlw.certificates.IfilentryEntryInfo;
import com.kingdee.eas.zjlw.certificates.IfilentryFactory;
import com.kingdee.eas.zjlw.certificates.IfilentryInfo;
import com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryFactory;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo;
import com.kingdee.eas.zjlw.social.CheckCountEntryCollection;
import com.kingdee.eas.zjlw.social.CheckCountEntryInfo;
import com.kingdee.eas.zjlw.social.CheckCountInfo;
import com.kingdee.eas.zjlw.social.ForiPayrollCollection;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryCollection;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryFactory;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryInfo;
import com.kingdee.eas.zjlw.social.ForiPayrollFactory;
import com.kingdee.eas.zjlw.social.ForiPayrollInfo;
import com.kingdee.eas.zjlw.social.InsurePersonEntryCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryFactory;
import com.kingdee.eas.zjlw.social.InsurePersonEntryInfo;
import com.kingdee.eas.zjlw.social.PayrollCollection;
import com.kingdee.eas.zjlw.social.PayrollEntryCollection;
import com.kingdee.eas.zjlw.social.PayrollEntryFactory;
import com.kingdee.eas.zjlw.social.PayrollEntryInfo;
import com.kingdee.eas.zjlw.social.PayrollFactory;
import com.kingdee.eas.zjlw.social.SecuPayCountCollection;
import com.kingdee.eas.zjlw.social.SecuPayCountFactory;
import com.kingdee.eas.zjlw.social.SecuPayCountInfo;
import com.kingdee.eas.zjlw.social.SecuSplitCollection;
import com.kingdee.eas.zjlw.social.SecuSplitEntryInfo;
import com.kingdee.eas.zjlw.social.SecuSplitFactory;
import com.kingdee.eas.zjlw.social.SecuSplitInfo;
import com.kingdee.eas.zjlw.social.VabaweatherInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.zjlw.social.PayrollInfo;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PayrollControllerBean extends AbstractPayrollControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.zjlw.social.app.PayrollControllerBean");

	/**
	 * 更新错误数据
	 * 
	 * @author ywj 2018-7-3
	 */
	protected void _updateErrData(Context ctx,String projId) throws BOSException {
		// 获取工资数据分录集合
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("*");
		sic.add("parent.id");
		sic.add("parent.name");
		sic.add("parent.number");
		sic.add("parent.permitOrg.id");
		sic.add("parent.permitOrg.name");
		sic.add("parent.permitOrg.number");
		EntityViewInfo view = new EntityViewInfo();
		view.setSelector(sic);
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("parent.projName.id",projId));
		view.setFilter(filter);
		PayrollEntryCollection payRollEtyCol = PayrollEntryFactory.getLocalInstance(ctx).getPayrollEntryCollection(view);
		// 循环工资数据分录集合，查询对应的参保人员名单，更新personid
		if (payRollEtyCol != null && payRollEtyCol.size() > 0) {
			for (int i = 0; i < payRollEtyCol.size(); i++) {
				PayrollEntryInfo payRollEtyInfo = payRollEtyCol.get(i);
				String insurePrsPersonId;
				try {
					insurePrsPersonId = getInsurePrsEtyCol(ctx, payRollEtyInfo);
					if (insurePrsPersonId != null && !"".equals(insurePrsPersonId))
						updateData(ctx, payRollEtyInfo.getPersonID(), insurePrsPersonId);
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
		String bakUpSql = "update CT_SOC_PayrollEntry set cfOripersonid = '" + personID + "' where cfpersonid = '" + personID + "'";
		DbUtil.execute(ctx, bakUpSql);
		// 更新personId
		String updateSql = "update CT_SOC_PayrollEntry set cfpersonid = '" + insurePrsPersonId + "' where cfpersonid = '" + personID + "'";
		DbUtil.execute(ctx, updateSql);
	}

	/**
	 * 获取参保人员名单 (姓and名and社保项目)
	 * 
	 * @param ctx
	 * @param payRollEtyInfo
	 * @return
	 * @throws BOSException
	 * @throws SQLException
	 */
	private String getInsurePrsEtyCol(Context ctx, PayrollEntryInfo payRollEtyInfo) throws BOSException, SQLException {
		String payRolletyFid = "";
		String personid = "";
		if (payRollEtyInfo.getId() != null) {
			payRolletyFid = payRollEtyInfo.getId().toString();
		}
		if (payRolletyFid != null && !"".equals(payRolletyFid)) {
			String lastName = payRollEtyInfo.getLastName();
			String firstName = payRollEtyInfo.getFirstName();
			String secuNo = payRollEtyInfo.getSecurityNo();
			String ccpNo = payRollEtyInfo.getCCPNo();
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
			// InsurePersonEntryCollection insurePrsEtyCol = InsurePersonEntryFactory.getLocalInstance(ctx).getInsurePersonEntryCollection(view);
			StringBuffer getIPpersonIdsql = new StringBuffer();
			getIPpersonIdsql.append("    SELECT                                ");
			getIPpersonIdsql.append("         ipety.cfpersonid  as personid                              ");
			getIPpersonIdsql.append("     FROM");
			getIPpersonIdsql.append("         CT_SOC_InsurePersonEntry ipety   ");
			getIPpersonIdsql.append("     LEFT OUTER JOIN");
			getIPpersonIdsql.append("         CT_SOC_InsurePerson ip       ");
			getIPpersonIdsql.append("             on ipety.fparentid = ip.fid   ");
			getIPpersonIdsql.append("     where");
			getIPpersonIdsql.append("          ip.cfpermitorgid = ( SELECT cfprojnameid  FROM CT_SOC_PayrollEntry ety  LEFT OUTER JOIN CT_SOC_Payroll bill  on ety.fparentid = bill.fid  where ety.fid = '");
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
			getIPpersonIdsql.append("                 ipety.cffirstname = '");
			if (firstName != null && !"".equals(firstName))
				getIPpersonIdsql.append(firstName.replaceAll("'", "''"));
			getIPpersonIdsql.append("'");
			getIPpersonIdsql.append("                 and ipety.cflastname = '");
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
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		PayrollInfo accInfo = (PayrollInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		// 设置编码
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //不允许断号
		// if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }else{
		// if(codFactory.isAddView(accInfo, orgId)){//新增显示
		//   	    				
		// }else{//什么都没勾选
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }
		// }
		// }
		// }
		return super._save(ctx, accInfo);
	}

	// 提交
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		PayrollInfo accInfo = (PayrollInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
		// 设置编码
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //不允许断号
		// if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }else{
		// if(codFactory.isAddView(accInfo, orgId)){//新增显示
		//
		// }else{//什么都没勾选
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }
		// }
		// }
		// }
		return super._submit(ctx, accInfo);
	}

	/**
	 * 审核通过
	 */
	protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		PayrollInfo info = (PayrollInfo) getValue(ctx, pk, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("AuditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		dealAll(ctx, info, true);
		writeBack(ctx, info, true);
	}

	/**
	 * 审核不通过
	 */
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		PayrollInfo info = (PayrollInfo) getValue(ctx, pk, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("AuditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		dealAll(ctx, info, false);
	}

	// 审核通过反写返写参保人员名单和信息录入
	private void writeBack(Context ctx, PayrollInfo info, boolean audit) throws EASBizException, BOSException {
		// 反写参保人员
		writeBackIns(ctx, info, audit);
		// 反写属地化信息录入
		writeLocalInfo(ctx, info, audit);

	}

	/**
	 * 反写参保人员
	 */
	private void writeBackIns(Context ctx, PayrollInfo info, boolean audit) throws BOSException, EASBizException {
		PayrollEntryCollection foriEntryCol = info.getEntrys();
		for (int i = 0; i < foriEntryCol.size(); i++) {
			PayrollEntryInfo entryInfo = foriEntryCol.get(i);
			String personID = entryInfo.getPersonID();
			String foriPersId = entryInfo.getForiPersID();
			FilterInfo filter = new FilterInfo();
			EntityViewInfo view = new EntityViewInfo();
			filter.getFilterItems().add(new FilterItemInfo("personID", personID));
			view.setFilter(filter);
			InsurePersonEntryInfo insEntryInfo = InsurePersonEntryFactory.getLocalInstance(ctx).getInsurePersonEntryCollection(view).get(0);
			if (insEntryInfo != null) {
				insEntryInfo.setForiPersID(foriPersId);// 外会人员编号
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("foriPersID");
				InsurePersonEntryFactory.getLocalInstance(ctx).updatePartial(insEntryInfo, sic);
			}
		}
	}

	/**
	 * 反写属地化信息录入
	 */
	private void writeLocalInfo(Context ctx, PayrollInfo info, boolean audit) throws BOSException, EASBizException {
		PayrollEntryCollection foriEntryCol = info.getEntrys();
		for (int i = 0; i < foriEntryCol.size(); i++) {
			PayrollEntryInfo entryInfo = foriEntryCol.get(i);
			String personID = entryInfo.getPersonID();
			FilterInfo filter = new FilterInfo();
			EntityViewInfo view = new EntityViewInfo();
			filter.getFilterItems().add(new FilterItemInfo("id", personID));
			view.setFilter(filter);
			LocalInfoEntryInfo liEntryInfo = LocalInfoEntryFactory.getLocalInstance(ctx).getLocalInfoEntryCollection(view).get(0);
			if (liEntryInfo != null) {
				liEntryInfo.setForiPersID(entryInfo.getForiPersID());// 外会人员编号
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("foriPersID");
				LocalInfoEntryFactory.getLocalInstance(ctx).updatePartial(liEntryInfo, sic);
			}
		}
	}

	/**
	 * 处理所有事物
	 * 
	 * @param ctx
	 * @param info
	 * @param audit
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public void dealAll(Context ctx, PayrollInfo info, boolean audit) throws BOSException, EASBizException {
		// 生成社保分摊表
		initBlankSecuSplit(ctx, info, audit);
		// 生成分摊汇总表
		initBlankSecuPayCount(ctx, info, audit);
		// dealSecuSplit(ctx, info,audit);
	}

	/**
	 * 生成分摊汇总表
	 * 
	 * @param ctx
	 * @param info
	 * @param audit
	 * @throws EASBizException
	 * @throws BOSException
	 */
	private void initBlankSecuPayCount(Context ctx, PayrollInfo info, boolean audit) throws EASBizException, BOSException {
		// 审核或反审核
		if (audit) {
			// 审核，生成汇总表
			if (!isSecuPayCount(ctx, info)) {// 无汇总表数据
				BelongAreaEnum area = getArea(ctx, info);
				PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo((new ObjectUuidPK(info.getMonthYearr() == null ? null : info.getMonthYearr().getId())));
				SecuPayCountInfo ssInfo = new SecuPayCountInfo();
				ssInfo.setId(BOSUuid.create(ssInfo.getBOSType()));
				ssInfo.setSourceBillId(info.getId().toString());
				ssInfo.setNumber(info.getNumber());// 单据编号
				ssInfo.setBillSate(BillStateEnum.DRAFT);// 单据状态
				ssInfo.setBizDate(new Date());// 业务日期
				ssInfo.setMonthYear(monthYear);// 年月
				ssInfo.setAera(area);
				SecuPayCountFactory.getLocalInstance(ctx).addnew(ssInfo);
			}
		}
		// }else{
		// //反审核，删除
		// FilterInfo filter = new FilterInfo();
		// PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo((new ObjectUuidPK(info.getMonthYearr()==null?null:info.getMonthYearr().getId())));
		// filter.getFilterItems().add(new FilterItemInfo("monthYear.id",monthYear.getId()));
		// SecuSplitFactory.getLocalInstance(ctx).delete(filter);
		// }

	}

	/**
	 * 生成社保分摊表
	 * 
	 * @param ctx
	 * @param info
	 * @param audit
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void initBlankSecuSplit(Context ctx, PayrollInfo info, boolean audit) throws BOSException, EASBizException {
		// 审核或反审核
		if (audit) {
			// 审核，生成分摊表
			if (!isSecuSplit(ctx, info)) {// 无分摊表数据
				AdminOrgUnitInfo Proj = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(info.getProjName() == null ? null : info.getProjName().getId()));
				PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo((new ObjectUuidPK(info.getMonthYearr() == null ? null : info.getMonthYearr().getId())));
				SecuSplitInfo ssInfo = new SecuSplitInfo();
				ssInfo.setId(BOSUuid.create(ssInfo.getBOSType()));
				ssInfo.setSourceBillId(info.getId().toString());
				ssInfo.setNumber(info.getNumber());// 单据编号
				ssInfo.setBillSate(BillStateEnum.DRAFT);// 单据状态
				ssInfo.setBizDate(new Date());// 业务日期
				ssInfo.setProjName(Proj);// 项目
				ssInfo.setMonthYearr(monthYear);// 年月
				SecuSplitFactory.getLocalInstance(ctx).addnew(ssInfo);
			}
		} else {
			// 反审核，删除
			FilterInfo filter = new FilterInfo();
			AdminOrgUnitInfo Proj = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(info.getProjName() == null ? null : info.getProjName().getId()));
			PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo((new ObjectUuidPK(info.getMonthYearr() == null ? null : info.getMonthYearr().getId())));
			filter.getFilterItems().add(new FilterItemInfo("projName.id", Proj.getId()));
			filter.getFilterItems().add(new FilterItemInfo("monthYearr.id", monthYear.getId()));
			SecuSplitFactory.getLocalInstance(ctx).delete(filter);
		}
	}

	/**
	 * 生成社保分摊表
	 * 
	 * @param audit
	 * @param info
	 * @param ctx
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void dealSecuSplit(Context ctx, PayrollInfo info, boolean audit) throws BOSException, EASBizException {
		// 审核或反审核
		if (audit) {
			// 审核，生成分摊表
			initSecuSplit(ctx, info);
		} else {
			// 反审核，调用外工工资数据生成分摊表的方法
		}
	}

	/**
	 * 生成分摊表
	 * 
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void initSecuSplit(Context ctx, PayrollInfo info) throws BOSException, EASBizException {
		// 判断是否已经有分摊表数据
		if (isSecuSplit(ctx, info)) {// 有数据
			// 查询关联的外工工资分录数据
			ForiPayrollEntryCollection fprEntryCol = getForiPayrollInfo(ctx, info);
			// 关联外工工资数据生成分摊表
			PayrollEntryCollection prEntryCol = info.getEntrys();
			initSecuSplitWithForiPayroll(ctx, info, prEntryCol, fprEntryCol);
		} else {// 无数据
			// 本表生成分摊表

		}
	}

	/**
	 * 判断是否已经有分摊表数据
	 * 
	 * @param ctx
	 * @param info
	 * @return true:有数据；false:无数据
	 * @throws BOSException
	 */
	private boolean isSecuSplit(Context ctx, PayrollInfo info) throws BOSException {
		PeriodInfo monthYear = info.getMonthYearr();
		AdminOrgUnitInfo proj = info.getProjName();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("monthYearr.id", monthYear == null ? null : monthYear.getId()));
		filter.getFilterItems().add(new FilterItemInfo("projName.id", proj == null ? null : proj.getId()));
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		SecuSplitCollection ssCol = SecuSplitFactory.getLocalInstance(ctx).getSecuSplitCollection(view);
		if (ssCol.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否已经有汇总表表数据
	 * 
	 * @param ctx
	 * @param info
	 * @return true:有数据；false:无数据
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private boolean isSecuPayCount(Context ctx, PayrollInfo info) throws BOSException, EASBizException {
		PeriodInfo my = info.getMonthYearr();
		PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(my.getId()));
		BelongAreaEnum area = getArea(ctx, info);
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("monthYear.id", monthYear == null ? null : monthYear.getId()));
		filter.getFilterItems().add(new FilterItemInfo("aera", area));
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		SecuPayCountCollection ssCol = SecuPayCountFactory.getLocalInstance(ctx).getSecuPayCountCollection(view);
		if (ssCol.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 查询项目所属区域
	 * 
	 * @author yingwj
	 * @date 2016-10-3
	 * @param ctx
	 * @param info
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private BelongAreaEnum getArea(Context ctx, PayrollInfo info) throws EASBizException, BOSException {
		AdminOrgUnitInfo secu = info.getProjName();
		AdminOrgUnitInfo secuInfo = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(secu.getId()));
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("proCom.id", secuInfo.getId().toString()));
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
	 * 查询关联的外工工资数据
	 * 
	 * @param ctx
	 * @param info
	 * @return
	 * @throws BOSException
	 */
	private ForiPayrollEntryCollection getForiPayrollInfo(Context ctx, PayrollInfo info) throws BOSException {
		PeriodInfo monthYear = info.getMonthYearr();
		AdminOrgUnitInfo proj = info.getProjName();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("parent.monthYearr.id", monthYear == null ? null : monthYear.getId()));
		filter.getFilterItems().add(new FilterItemInfo("parent.projName.id", proj == null ? null : proj.getId()));
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		ForiPayrollEntryCollection fprEntryCol = ForiPayrollEntryFactory.getLocalInstance(ctx).getForiPayrollEntryCollection(view);
		return fprEntryCol;
	}

	/**
	 * 关联外工工资数据生成分摊表
	 * 
	 * @param ctx
	 * @param info
	 * @param prEntryCol
	 * @param fprEntryCol
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void initSecuSplitWithForiPayroll(Context ctx, PayrollInfo info, PayrollEntryCollection prEntryCol, ForiPayrollEntryCollection fprEntryCol) throws EASBizException, BOSException {
		// 获取工资数据的泛型集合
		Set payEntrySet = getPayObjectSet(prEntryCol, fprEntryCol);
		// 根据工资数据获取合作单位的集合
		Set coopSet = getCoopSet(payEntrySet);
		// 循环集合赋值表体
		// 表头
		SecuSplitInfo ssInfo = new SecuSplitInfo();
		ssInfo.setId(BOSUuid.create(ssInfo.getBOSType()));
		ssInfo.setSourceBillId(info.getId().toString());
		ssInfo.setNumber(info.getNumber());// 单据编号
		ssInfo.setBillSate(BillStateEnum.DRAFT);// 单据状态
		ssInfo.setBizDate(new Date());// 业务日期
		// 表体
		if (coopSet.size() > 0) {
			for (Object coopObj : coopSet) {
				AdminOrgUnitInfo coopInfo = (AdminOrgUnitInfo) coopObj;
				if (coopInfo != null) {
					String coopCode = "";// 合作单位代码
					int coopAlgSc = 0;// 合作单位属地化缴纳社保人数
					int coopForiSc = 0;// 合作单位外工缴纳社保人数
					int coopScPers = 0;// 合作单位缴纳社保总人数
					BigDecimal coopAlgScM = BigDecimal.ZERO;
					BigDecimal coopAlgVcM = BigDecimal.ZERO;
					BigDecimal coopForiScM = BigDecimal.ZERO;
					BigDecimal coopForiVcM = BigDecimal.ZERO;
					BigDecimal coopScMoney = BigDecimal.ZERO;// 合作单位社保缴纳总金额
					SecuSplitEntryInfo IfilentryEntryInfo = new SecuSplitEntryInfo();
					IfilentryEntryInfo.setId(BOSUuid.create(IfilentryEntryInfo.getBOSType()));
					// 循环工资数据分录集合
					for (Object obj : payEntrySet) {
						// 阿工
						if (obj instanceof PayrollEntryInfo) {
							PayrollEntryInfo payEntryInfo = (PayrollEntryInfo) obj;
							AdminOrgUnitInfo coopNow = payEntryInfo.getCooperation();
							if (coopNow != null && coopInfo.equals(coopNow)) {
								coopAlgSc++;// 合作单位属地化缴纳社保人数
								coopAlgScM = coopAlgScM.add(payEntryInfo.getSecuDebit() == null ? BigDecimal.ZERO : payEntryInfo.getSecuDebit());
								coopAlgVcM = coopAlgVcM.add(payEntryInfo.getVacaDebit() == null ? BigDecimal.ZERO : payEntryInfo.getVacaDebit());
							}
							coopScMoney = coopScMoney.add(payEntryInfo.getSecuDebit() == null ? BigDecimal.ZERO : payEntryInfo.getSecuDebit()).add(payEntryInfo.getVacaDebit() == null ? BigDecimal.ZERO : payEntryInfo.getVacaDebit());// 合作单位社保缴纳总金额
							// 外工
						} else if (obj instanceof ForiPayrollInfo) {
							ForiPayrollEntryInfo payEntryInfo = (ForiPayrollEntryInfo) obj;
							AdminOrgUnitInfo coopNow = payEntryInfo.getCooperation();
							if (coopNow != null && coopInfo.equals(coopNow)) {
								coopForiSc++;// 合作单位外工缴纳社保人数
								coopForiScM = coopForiScM.add(payEntryInfo.getSecuDebit() == null ? BigDecimal.ZERO : payEntryInfo.getSecuDebit());
								coopForiVcM = coopForiVcM.add(payEntryInfo.getVacaDebit() == null ? BigDecimal.ZERO : payEntryInfo.getVacaDebit());
								coopScMoney = coopScMoney.add(payEntryInfo.getSecuDebit() == null ? BigDecimal.ZERO : payEntryInfo.getSecuDebit()).add(payEntryInfo.getVacaDebit() == null ? BigDecimal.ZERO : payEntryInfo.getVacaDebit());// 合作单位社保缴纳总金额
							}
						}
					}
					AdminOrgUnitInfo coop = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(coopInfo.getId()));
					IfilentryEntryInfo.setCooperation(coop);
					IfilentryEntryInfo.setCoopCode(coopCode);
					IfilentryEntryInfo.setCoopAlgSc(coopAlgSc);
					IfilentryEntryInfo.setCoopForiSc(coopForiSc);
					IfilentryEntryInfo.setCoopScPers(coopScPers);
					IfilentryEntryInfo.setCoopScMoney(coopScMoney);
					IfilentryEntryInfo.setCoopAlgScM(coopAlgScM);
					IfilentryEntryInfo.setCoopAlgVcM(coopAlgVcM);
					IfilentryEntryInfo.setCoopForiScM(coopForiScM);
					IfilentryEntryInfo.setCoopForiVcM(coopForiVcM);
					ssInfo.getEntrys().add(IfilentryEntryInfo);
				}
			}
		}
		IfilentryFactory.getLocalInstance(ctx).addnew(ssInfo);
	}

	/**
	 * 获取工资数据的集合
	 * 
	 * @param prEntryCol
	 * @param fprEntryCol
	 * @return
	 */
	private Set getPayObjectSet(PayrollEntryCollection prEntryCol, ForiPayrollEntryCollection fprEntryCol) {
		Set<Object> set = new HashSet<Object>();
		if (prEntryCol != null) {
			for (int i = 0; i < prEntryCol.size(); i++) {
				set.add(prEntryCol.get(i));
			}
		}
		if (fprEntryCol != null) {
			for (int i = 0; i < fprEntryCol.size(); i++) {
				set.add(fprEntryCol.get(i));
			}
		}
		return set;
	}

	/**
	 * 取出所有合作单位的集合
	 * 
	 * @param foripayInfo
	 */
	private Set getCoopSet(Set paySet) {
		Set coopSet = new HashSet<AdminOrgUnitInfo>();
		for (Object obj : paySet) {
			if (obj instanceof PayrollEntryInfo) {
				PayrollEntryInfo pay = (PayrollEntryInfo) obj;
				coopSet.add(pay.getCooperation());
			} else if (obj instanceof ForiPayrollEntryInfo) {
				ForiPayrollInfo foriPay = (ForiPayrollInfo) obj;
				coopSet.add(foriPay.getCooperatedOrgName());
			}
		}
		return coopSet;
	}

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