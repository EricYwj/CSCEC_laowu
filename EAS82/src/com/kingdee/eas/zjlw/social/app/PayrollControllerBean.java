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
	 * ���´�������
	 * 
	 * @author ywj 2018-7-3
	 */
	protected void _updateErrData(Context ctx,String projId) throws BOSException {
		// ��ȡ�������ݷ�¼����
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
		// ѭ���������ݷ�¼���ϣ���ѯ��Ӧ�Ĳα���Ա����������personid
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
	 * ���´�������
	 * 
	 * @author ywj 2018-7-3
	 * @param ctx
	 * @param personID
	 * @param insurePrsPersonId
	 * @throws BOSException
	 */
	private void updateData(Context ctx, String personID, String insurePrsPersonId) throws BOSException {
		// ����personId
		String bakUpSql = "update CT_SOC_PayrollEntry set cfOripersonid = '" + personID + "' where cfpersonid = '" + personID + "'";
		DbUtil.execute(ctx, bakUpSql);
		// ����personId
		String updateSql = "update CT_SOC_PayrollEntry set cfpersonid = '" + insurePrsPersonId + "' where cfpersonid = '" + personID + "'";
		DbUtil.execute(ctx, updateSql);
	}

	/**
	 * ��ȡ�α���Ա���� (��and��and�籣��Ŀ)
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

	// ����
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		PayrollInfo accInfo = (PayrollInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		// ���ñ���
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //������Ϻ�
		// if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }else{
		// if(codFactory.isAddView(accInfo, orgId)){//������ʾ
		//   	    				
		// }else{//ʲô��û��ѡ
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }
		// }
		// }
		// }
		return super._save(ctx, accInfo);
	}

	// �ύ
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		PayrollInfo accInfo = (PayrollInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
		// ���ñ���
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //������Ϻ�
		// if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }else{
		// if(codFactory.isAddView(accInfo, orgId)){//������ʾ
		//
		// }else{//ʲô��û��ѡ
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }
		// }
		// }
		// }
		return super._submit(ctx, accInfo);
	}

	/**
	 * ���ͨ��
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
	 * ��˲�ͨ��
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

	// ���ͨ����д��д�α���Ա��������Ϣ¼��
	private void writeBack(Context ctx, PayrollInfo info, boolean audit) throws EASBizException, BOSException {
		// ��д�α���Ա
		writeBackIns(ctx, info, audit);
		// ��д���ػ���Ϣ¼��
		writeLocalInfo(ctx, info, audit);

	}

	/**
	 * ��д�α���Ա
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
				insEntryInfo.setForiPersID(foriPersId);// �����Ա���
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("foriPersID");
				InsurePersonEntryFactory.getLocalInstance(ctx).updatePartial(insEntryInfo, sic);
			}
		}
	}

	/**
	 * ��д���ػ���Ϣ¼��
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
				liEntryInfo.setForiPersID(entryInfo.getForiPersID());// �����Ա���
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("foriPersID");
				LocalInfoEntryFactory.getLocalInstance(ctx).updatePartial(liEntryInfo, sic);
			}
		}
	}

	/**
	 * ������������
	 * 
	 * @param ctx
	 * @param info
	 * @param audit
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public void dealAll(Context ctx, PayrollInfo info, boolean audit) throws BOSException, EASBizException {
		// �����籣��̯��
		initBlankSecuSplit(ctx, info, audit);
		// ���ɷ�̯���ܱ�
		initBlankSecuPayCount(ctx, info, audit);
		// dealSecuSplit(ctx, info,audit);
	}

	/**
	 * ���ɷ�̯���ܱ�
	 * 
	 * @param ctx
	 * @param info
	 * @param audit
	 * @throws EASBizException
	 * @throws BOSException
	 */
	private void initBlankSecuPayCount(Context ctx, PayrollInfo info, boolean audit) throws EASBizException, BOSException {
		// ��˻����
		if (audit) {
			// ��ˣ����ɻ��ܱ�
			if (!isSecuPayCount(ctx, info)) {// �޻��ܱ�����
				BelongAreaEnum area = getArea(ctx, info);
				PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo((new ObjectUuidPK(info.getMonthYearr() == null ? null : info.getMonthYearr().getId())));
				SecuPayCountInfo ssInfo = new SecuPayCountInfo();
				ssInfo.setId(BOSUuid.create(ssInfo.getBOSType()));
				ssInfo.setSourceBillId(info.getId().toString());
				ssInfo.setNumber(info.getNumber());// ���ݱ��
				ssInfo.setBillSate(BillStateEnum.DRAFT);// ����״̬
				ssInfo.setBizDate(new Date());// ҵ������
				ssInfo.setMonthYear(monthYear);// ����
				ssInfo.setAera(area);
				SecuPayCountFactory.getLocalInstance(ctx).addnew(ssInfo);
			}
		}
		// }else{
		// //����ˣ�ɾ��
		// FilterInfo filter = new FilterInfo();
		// PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo((new ObjectUuidPK(info.getMonthYearr()==null?null:info.getMonthYearr().getId())));
		// filter.getFilterItems().add(new FilterItemInfo("monthYear.id",monthYear.getId()));
		// SecuSplitFactory.getLocalInstance(ctx).delete(filter);
		// }

	}

	/**
	 * �����籣��̯��
	 * 
	 * @param ctx
	 * @param info
	 * @param audit
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void initBlankSecuSplit(Context ctx, PayrollInfo info, boolean audit) throws BOSException, EASBizException {
		// ��˻����
		if (audit) {
			// ��ˣ����ɷ�̯��
			if (!isSecuSplit(ctx, info)) {// �޷�̯������
				AdminOrgUnitInfo Proj = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(info.getProjName() == null ? null : info.getProjName().getId()));
				PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo((new ObjectUuidPK(info.getMonthYearr() == null ? null : info.getMonthYearr().getId())));
				SecuSplitInfo ssInfo = new SecuSplitInfo();
				ssInfo.setId(BOSUuid.create(ssInfo.getBOSType()));
				ssInfo.setSourceBillId(info.getId().toString());
				ssInfo.setNumber(info.getNumber());// ���ݱ��
				ssInfo.setBillSate(BillStateEnum.DRAFT);// ����״̬
				ssInfo.setBizDate(new Date());// ҵ������
				ssInfo.setProjName(Proj);// ��Ŀ
				ssInfo.setMonthYearr(monthYear);// ����
				SecuSplitFactory.getLocalInstance(ctx).addnew(ssInfo);
			}
		} else {
			// ����ˣ�ɾ��
			FilterInfo filter = new FilterInfo();
			AdminOrgUnitInfo Proj = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(info.getProjName() == null ? null : info.getProjName().getId()));
			PeriodInfo monthYear = PeriodFactory.getLocalInstance(ctx).getPeriodInfo((new ObjectUuidPK(info.getMonthYearr() == null ? null : info.getMonthYearr().getId())));
			filter.getFilterItems().add(new FilterItemInfo("projName.id", Proj.getId()));
			filter.getFilterItems().add(new FilterItemInfo("monthYearr.id", monthYear.getId()));
			SecuSplitFactory.getLocalInstance(ctx).delete(filter);
		}
	}

	/**
	 * �����籣��̯��
	 * 
	 * @param audit
	 * @param info
	 * @param ctx
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void dealSecuSplit(Context ctx, PayrollInfo info, boolean audit) throws BOSException, EASBizException {
		// ��˻����
		if (audit) {
			// ��ˣ����ɷ�̯��
			initSecuSplit(ctx, info);
		} else {
			// ����ˣ������⹤�����������ɷ�̯��ķ���
		}
	}

	/**
	 * ���ɷ�̯��
	 * 
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void initSecuSplit(Context ctx, PayrollInfo info) throws BOSException, EASBizException {
		// �ж��Ƿ��Ѿ��з�̯������
		if (isSecuSplit(ctx, info)) {// ������
			// ��ѯ�������⹤���ʷ�¼����
			ForiPayrollEntryCollection fprEntryCol = getForiPayrollInfo(ctx, info);
			// �����⹤�����������ɷ�̯��
			PayrollEntryCollection prEntryCol = info.getEntrys();
			initSecuSplitWithForiPayroll(ctx, info, prEntryCol, fprEntryCol);
		} else {// ������
			// �������ɷ�̯��

		}
	}

	/**
	 * �ж��Ƿ��Ѿ��з�̯������
	 * 
	 * @param ctx
	 * @param info
	 * @return true:�����ݣ�false:������
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
	 * �ж��Ƿ��Ѿ��л��ܱ������
	 * 
	 * @param ctx
	 * @param info
	 * @return true:�����ݣ�false:������
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
	 * ��ѯ��Ŀ��������
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
	 * ��ѯ�������⹤��������
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
	 * �����⹤�����������ɷ�̯��
	 * 
	 * @param ctx
	 * @param info
	 * @param prEntryCol
	 * @param fprEntryCol
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void initSecuSplitWithForiPayroll(Context ctx, PayrollInfo info, PayrollEntryCollection prEntryCol, ForiPayrollEntryCollection fprEntryCol) throws EASBizException, BOSException {
		// ��ȡ�������ݵķ��ͼ���
		Set payEntrySet = getPayObjectSet(prEntryCol, fprEntryCol);
		// ���ݹ������ݻ�ȡ������λ�ļ���
		Set coopSet = getCoopSet(payEntrySet);
		// ѭ�����ϸ�ֵ����
		// ��ͷ
		SecuSplitInfo ssInfo = new SecuSplitInfo();
		ssInfo.setId(BOSUuid.create(ssInfo.getBOSType()));
		ssInfo.setSourceBillId(info.getId().toString());
		ssInfo.setNumber(info.getNumber());// ���ݱ��
		ssInfo.setBillSate(BillStateEnum.DRAFT);// ����״̬
		ssInfo.setBizDate(new Date());// ҵ������
		// ����
		if (coopSet.size() > 0) {
			for (Object coopObj : coopSet) {
				AdminOrgUnitInfo coopInfo = (AdminOrgUnitInfo) coopObj;
				if (coopInfo != null) {
					String coopCode = "";// ������λ����
					int coopAlgSc = 0;// ������λ���ػ������籣����
					int coopForiSc = 0;// ������λ�⹤�����籣����
					int coopScPers = 0;// ������λ�����籣������
					BigDecimal coopAlgScM = BigDecimal.ZERO;
					BigDecimal coopAlgVcM = BigDecimal.ZERO;
					BigDecimal coopForiScM = BigDecimal.ZERO;
					BigDecimal coopForiVcM = BigDecimal.ZERO;
					BigDecimal coopScMoney = BigDecimal.ZERO;// ������λ�籣�����ܽ��
					SecuSplitEntryInfo IfilentryEntryInfo = new SecuSplitEntryInfo();
					IfilentryEntryInfo.setId(BOSUuid.create(IfilentryEntryInfo.getBOSType()));
					// ѭ���������ݷ�¼����
					for (Object obj : payEntrySet) {
						// ����
						if (obj instanceof PayrollEntryInfo) {
							PayrollEntryInfo payEntryInfo = (PayrollEntryInfo) obj;
							AdminOrgUnitInfo coopNow = payEntryInfo.getCooperation();
							if (coopNow != null && coopInfo.equals(coopNow)) {
								coopAlgSc++;// ������λ���ػ������籣����
								coopAlgScM = coopAlgScM.add(payEntryInfo.getSecuDebit() == null ? BigDecimal.ZERO : payEntryInfo.getSecuDebit());
								coopAlgVcM = coopAlgVcM.add(payEntryInfo.getVacaDebit() == null ? BigDecimal.ZERO : payEntryInfo.getVacaDebit());
							}
							coopScMoney = coopScMoney.add(payEntryInfo.getSecuDebit() == null ? BigDecimal.ZERO : payEntryInfo.getSecuDebit()).add(payEntryInfo.getVacaDebit() == null ? BigDecimal.ZERO : payEntryInfo.getVacaDebit());// ������λ�籣�����ܽ��
							// �⹤
						} else if (obj instanceof ForiPayrollInfo) {
							ForiPayrollEntryInfo payEntryInfo = (ForiPayrollEntryInfo) obj;
							AdminOrgUnitInfo coopNow = payEntryInfo.getCooperation();
							if (coopNow != null && coopInfo.equals(coopNow)) {
								coopForiSc++;// ������λ�⹤�����籣����
								coopForiScM = coopForiScM.add(payEntryInfo.getSecuDebit() == null ? BigDecimal.ZERO : payEntryInfo.getSecuDebit());
								coopForiVcM = coopForiVcM.add(payEntryInfo.getVacaDebit() == null ? BigDecimal.ZERO : payEntryInfo.getVacaDebit());
								coopScMoney = coopScMoney.add(payEntryInfo.getSecuDebit() == null ? BigDecimal.ZERO : payEntryInfo.getSecuDebit()).add(payEntryInfo.getVacaDebit() == null ? BigDecimal.ZERO : payEntryInfo.getVacaDebit());// ������λ�籣�����ܽ��
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
	 * ��ȡ�������ݵļ���
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
	 * ȡ�����к�����λ�ļ���
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