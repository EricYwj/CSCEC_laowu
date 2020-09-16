package com.kingdee.eas.zjlw.social.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK; //import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean; //import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.certificates.IfilentryFactory;
import com.kingdee.eas.zjlw.certificates.IfilentryInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryCollection;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryInfo;
import com.kingdee.eas.zjlw.social.ForiPayrollFactory;
import com.kingdee.eas.zjlw.social.ForiPayrollInfo;
import com.kingdee.eas.zjlw.social.PayrollEntryCollection;
import com.kingdee.eas.zjlw.social.PayrollEntryInfo;
import com.kingdee.eas.zjlw.social.PayrollFactory;
import com.kingdee.eas.zjlw.social.PayrollInfo;
import com.kingdee.eas.zjlw.social.SecuPayCountCollection;
import com.kingdee.eas.zjlw.social.SecuPayCountFactory;
import com.kingdee.eas.zjlw.social.SecuPayCountInfo;
import com.kingdee.eas.zjlw.social.SecuSplitEntryCollection;
import com.kingdee.eas.zjlw.social.SecuSplitEntryFactory;
import com.kingdee.eas.zjlw.social.SecuSplitEntryInfo;
import com.kingdee.eas.zjlw.social.SecuSplitFactory;
import com.kingdee.eas.zjlw.social.SecuSplitInfo;
import com.kingdee.eas.zjlw.social.VabaweatherInfo;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.zjlw.social.SecuSplitCollection;
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
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SecuSplitControllerBean extends AbstractSecuSplitControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.zjlw.social.app.SecuSplitControllerBean");

	// ����
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		SecuSplitInfo accInfo = (SecuSplitInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		// ���ñ���
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany =
		// ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory =
		// CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //������Ϻ�
		// if(codFactory.isUseIntermitNumber(accInfo,
		// orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
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
		SecuSplitInfo accInfo = (SecuSplitInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
		// ���ñ���
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany =
		// ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory =
		// CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //������Ϻ�
		// if(codFactory.isUseIntermitNumber(accInfo,
		// orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
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
		SecuSplitInfo info = (SecuSplitInfo) getValue(ctx, pk, getSelector());
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
		initSecuPayCount(ctx, info, true);
	}

	/**
	 * ��˲�ͨ��
	 */
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		SecuSplitInfo info = (SecuSplitInfo) getValue(ctx, pk, getSelector());
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
		initSecuPayCount(ctx, info, false);
	}

	/**
	 * ��ʼ����ɾ������
	 * 
	 * @param ctx
	 * @param info
	 * @param b
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void initSecuPayCount(Context ctx, SecuSplitInfo info, boolean b) throws EASBizException, BOSException {
		PeriodInfo month = info.getMonthYearr();
		PeriodInfo monthYearr = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(month.getId()));
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("monthYear.id", monthYearr.getId()));
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		SecuPayCountCollection col = SecuPayCountFactory.getLocalInstance(ctx).getSecuPayCountCollection(view);
		if (b) {// ���ͨ��
			if (col.size() == 0) {
				// ��������
				SecuPayCountInfo spcInfo = new SecuPayCountInfo();
				// ��ͷ
				spcInfo.setId(BOSUuid.create(spcInfo.getBOSType()));
				spcInfo.setSourceBillId(info.getId().toString());
				spcInfo.setNumber(info.getNumber());// ���ݱ��
				spcInfo.setBillSate(BillStateEnum.DRAFT);// ����״̬
				spcInfo.setBizDate(new Date());// ҵ������
				spcInfo.setMonthYear(monthYearr);// ����
				SecuPayCountFactory.getLocalInstance(ctx).addnew(spcInfo);
			}
		} else {// �����
			SecuPayCountFactory.getLocalInstance(ctx).delete(filter);
		}
	}

	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("monthYearr");
		sic.add("entrys.*");
		return sic;
	}

	/**
	 * ʵ��������
	 * 
	 * @author ywj 2017-11-23
	 */
	protected IObjectValue _initBill(Context ctx, String PK, String fullInfoPk) throws BOSException, EASBizException {
		// ��ʼ�����ݶ���
		SecuSplitInfo info = new SecuSplitInfo();

		// ɾ�����з�¼
		info = SecuSplitFactory.getLocalInstance(ctx).getSecuSplitInfo(new ObjectUuidPK(PK));
		SecuSplitEntryCollection col = info.getEntrys();
		for (int i = 0; i < col.size(); i++)
			SecuSplitEntryFactory.getLocalInstance(ctx).delete(new ObjectUuidPK(col.get(i).getId()));
		// ��ֵ���������籣��
		if (!getFranceNameAndSecuNumber(info, fullInfoPk, ctx))// ��ȡ���������籣��
			return null;

		// ��ѯ�����������ݵ���
		PayrollInfo payInfo = getAlgPayrollData(info, fullInfoPk, ctx);

		// ��ѯ�⹤�������ݵ���
		ForiPayrollInfo foripayInfo = getforiPayrollData(info, fullInfoPk, ctx);

		// �жϹ��������Ƿ�ȫ
		if (payInfo == null && foripayInfo == null)
			return null;

		// ��ʼ������
		inniEntry(info, ctx, payInfo, foripayInfo);

		return info;
	}

	/**
	 * ��ʼ������
	 * 
	 * @author ywj 2017-11-23
	 * @param ctx
	 * @param info
	 * @param payInfo
	 * @param foripayInfo
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void inniEntry(SecuSplitInfo info, Context ctx, PayrollInfo payInfo, ForiPayrollInfo foripayInfo) throws EASBizException, BOSException {
		// ��ȡ�������ݵķ��ͼ���
		Set payEntrySet = getPayObjectSet(ctx, payInfo, foripayInfo);
		// ���ݹ������ݻ�ȡ������λ�ļ���
		Set coopSet = getCoopSet(ctx, payEntrySet);
		// ���ݺ�����λ���ϻ�ȡ������λ�͹�����λ�ļ���
		Set coopAndWorkSet = getCoopAndWorkSet(ctx, coopSet, payEntrySet);
		// ѭ�����ϸ�ֵ����
		if (coopAndWorkSet.size() > 0) {
			System.out.println("coopAndWorkSet" + coopAndWorkSet.size());
			for (Object coopAndWorkObj : coopAndWorkSet) {
				Map coopAndWorkMap = (Map) coopAndWorkObj;
				for (Object key : coopAndWorkMap.keySet()) {
					AdminOrgUnitInfo coopInfo = (AdminOrgUnitInfo) key;
					if (coopInfo != null) {
						Set workSet = (Set) coopAndWorkMap.get(coopInfo);
						System.out.println("workSet" + workSet.size());
						for (Object workProjId : workSet) {
							AdminOrgUnitInfo workProj = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(workProjId.toString()));
							// String coopCode = "";//������λ����
							int coopAlgSc = 0;// ������λ���ػ������籣����
							int coopForiSc = 0;// ������λ�⹤�����籣����
							int coopScPers = 0;// ������λ�����籣������
							BigDecimal coopAlgScM = BigDecimal.ZERO;
							BigDecimal coopAlgVcM = BigDecimal.ZERO;
							BigDecimal coopForiScM = BigDecimal.ZERO;
							BigDecimal coopForiVcM = BigDecimal.ZERO;
							BigDecimal localIRGC = BigDecimal.ZERO;
							BigDecimal foriIRGC = BigDecimal.ZERO;
							BigDecimal vcCount = BigDecimal.ZERO;
							BigDecimal IRGCount = BigDecimal.ZERO;
							BigDecimal coopScMoney = BigDecimal.ZERO;// ������λ�籣�����ܽ��
							// ѭ���������ݷ�¼����
							for (Object obj : payEntrySet) {
								// ����
								if (obj instanceof PayrollEntryInfo) {
									PayrollEntryInfo payEntryInfo = (PayrollEntryInfo) obj;
									if (payEntryInfo.getNWorkDay() != null) {
										if (payEntryInfo.getCooperation() != null && payEntryInfo.getWorkProgram() != null && coopInfo.getId().equals(payEntryInfo.getCooperation().getId()) && workProj.getId().equals(payEntryInfo.getWorkProgram().getId())) {
											coopAlgSc++;// ������λ���ػ������籣����
											coopAlgScM = coopAlgScM.add(payEntryInfo.getSociaLevyBase() == null ? BigDecimal.ZERO : payEntryInfo.getSociaLevyBase());// �籣���ջ���
											localIRGC = localIRGC.add(payEntryInfo.getIRGDPerson() == null ? BigDecimal.ZERO : payEntryInfo.getIRGDPerson());// IRG
											coopScMoney = coopScMoney.add(payEntryInfo.getSociaLevyBase() == null ? BigDecimal.ZERO : payEntryInfo.getSociaLevyBase());// ������λ�籣�����ܽ��
											IRGCount = IRGCount.add(payEntryInfo.getIRGDPerson() == null ? BigDecimal.ZERO : payEntryInfo.getIRGDPerson());// IRG�ϼ�
										}
									}
									// �⹤
								} else if (obj instanceof ForiPayrollEntryInfo) {
									ForiPayrollEntryInfo payEntryInfo = (ForiPayrollEntryInfo) obj;
									if (payEntryInfo.getNWorkDay() != null) {
										if (payEntryInfo.getCooperation() != null && payEntryInfo.getWorkProgram() != null && coopInfo.getId().equals(payEntryInfo.getCooperation().getId()) && workProj.getId().equals(payEntryInfo.getWorkProgram().getId())) {
											coopForiSc++;// ������λ�⹤�����籣����
											coopForiScM = coopForiScM.add(payEntryInfo.getSociaLevyBase() == null ? BigDecimal.ZERO : payEntryInfo.getSociaLevyBase());
											foriIRGC = foriIRGC.add(payEntryInfo.getIRGDPerson() == null ? BigDecimal.ZERO : payEntryInfo.getIRGDPerson());
											coopScMoney = coopScMoney.add(payEntryInfo.getSociaLevyBase() == null ? BigDecimal.ZERO : payEntryInfo.getSociaLevyBase());// ������λ�籣�����ܽ��
											IRGCount = IRGCount.add(payEntryInfo.getIRGDPerson() == null ? BigDecimal.ZERO : payEntryInfo.getIRGDPerson());// ������λ�籣�����ܽ��
										}
									}
								}
							}
							// ������¼
							SecuSplitEntryInfo etyInfo = new SecuSplitEntryInfo();
							etyInfo.setId(BOSUuid.create(etyInfo.getBOSType()));
							AdminOrgUnitInfo coop = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(coopInfo.getId()));
							AdminOrgUnitInfo workProj1 =AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(workProj.getId()));
							etyInfo.setCooperation(coop);// ������λ
							etyInfo.setWorkProj(workProj1);// ������λ
							etyInfo.setCoopCode(coop.getNumber());// ������λ����
							etyInfo.setCoopAlgSc(coopAlgSc);// ���ػ��籣��������
							etyInfo.setCoopForiSc(coopForiSc);// �⼮Ա���籣��������
							etyInfo.setCoopScPers(coopAlgSc + coopForiSc);// ������
							etyInfo.setCoopAlgScNew(new BigDecimal(coopAlgSc));// ���ػ��籣��������
							etyInfo.setCoopForiScNew(new BigDecimal(coopForiSc));// �⼮Ա���籣��������
							etyInfo.setCoopScPersNew(new BigDecimal(coopAlgSc + coopForiSc));// ������
							etyInfo.setCoopScMoney((coopForiScM.add(coopAlgScM)).multiply(new BigDecimal("0.3513")));// �ܽ��
							etyInfo.setCoopAlgScM(coopAlgScM.multiply(new BigDecimal("0.3513")));// ���ػ��籣���
							etyInfo.setCoopAlgVcM(coopAlgScM.multiply(new BigDecimal("0.1296")));// ���ػ��ݼٹ���
							etyInfo.setCoopForiScM(coopForiScM.multiply(new BigDecimal("0.3513")));// �⼮Ա���籣���
							etyInfo.setCoopForiVcM(coopForiScM.multiply(new BigDecimal("0.1296")));// �⼮Ա���ݼٹ��ʽ��
							etyInfo.setLocalIRGC(localIRGC);// ���ػ�IRG
							etyInfo.setForiIRGC(foriIRGC);// �⼮IRG
							etyInfo.setVcCount(coopAlgScM.multiply(new BigDecimal("0.1296")).add(coopForiScM.multiply(new BigDecimal("0.1296"))));// �ݼٹ����ܶ�
							etyInfo.setIRGCount(IRGCount);// IRG�ܶ�
							etyInfo.setParent(info);
							SecuSplitEntryFactory.getLocalInstance(ctx).addnew(etyInfo);
//							info.getEntrys().add(etyInfo);
//							SelectorItemCollection sic = new SelectorItemCollection();
//							sic.add("entrys");
//							updatePartial(ctx, info, sic);
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private Set getCoopAndWorkSet(Context ctx, Set coopSet, Set payEntrySet) {
		Set coopAndWorkSet = new HashSet();
		for (Iterator iterator = coopSet.iterator(); iterator.hasNext();) {
			Object coop = (Object) iterator.next();
			Map coopAndWorkMap = new HashMap();
			Set workSet = new HashSet();
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("*");
			for (Object obj : payEntrySet) {
				if (obj instanceof PayrollEntryInfo) {
					PayrollEntryInfo pay = (PayrollEntryInfo) obj;
					if (((AdminOrgUnitInfo) coop).getId().toString().equals(pay.getCooperation().getId().toString()))
						workSet.add(pay.getWorkProgram().getId());
				} else if (obj instanceof ForiPayrollEntryInfo) {
					ForiPayrollEntryInfo foriPay = (ForiPayrollEntryInfo) obj;
					if (((AdminOrgUnitInfo) coop).getId().toString().equals(foriPay.getCooperation().getId().toString()))
						workSet.add(foriPay.getWorkProgram().getId());
				}
			}
			coopAndWorkMap.put(coop, workSet);
			coopAndWorkSet.add(coopAndWorkMap);
		}
		return coopAndWorkSet;
	}

	/**
	 * ��ѯ�⹤�������ݵ���
	 * 
	 * @param info
	 * @param fullInfoPk
	 * @param ctx
	 * @return
	 * @throws BOSException
	 */
	private ForiPayrollInfo getforiPayrollData(SecuSplitInfo info, String fullInfoPk, Context ctx) throws BOSException {
		FilterInfo filter = new FilterInfo();
		PeriodInfo perInfo = (PeriodInfo) info.getMonthYearr();
		AdminOrgUnitInfo projInfo = (AdminOrgUnitInfo) info.getProjName();
		filter.getFilterItems().add(new FilterItemInfo("monthyearr.id", perInfo == null ? null : perInfo.getId()));
		filter.getFilterItems().add(new FilterItemInfo("projName.id", projInfo == null ? null : projInfo.getId()));
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("entrys.*");
		view.setFilter(filter);
		view.setSelector(sic);
		ForiPayrollInfo payInfo = ForiPayrollFactory.getLocalInstance(ctx).getForiPayrollCollection(view).get(0);
		return payInfo;
	}

	/**
	 * ��ѯ�����������ݵ���
	 * 
	 * @author ywj 2017-11-23
	 * @param info
	 * @param fullInfoPk
	 * @param ctx
	 * @return ��ȡʧ�ܣ�����null���ɹ��򷵻�ҵ�����
	 * @throws BOSException
	 */
	private PayrollInfo getAlgPayrollData(SecuSplitInfo info, String fullInfoPk, Context ctx) throws BOSException {

		FilterInfo filter = new FilterInfo();
		PeriodInfo perInfo = (PeriodInfo) info.getMonthYearr();
		AdminOrgUnitInfo projInfo = (AdminOrgUnitInfo) info.getProjName();
		filter.getFilterItems().add(new FilterItemInfo("monthyearr.id", perInfo == null ? null : perInfo.getId()));
		filter.getFilterItems().add(new FilterItemInfo("projName.id", projInfo == null ? null : projInfo.getId()));
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("entrys.*");
		view.setFilter(filter);
		view.setSelector(sic);
		PayrollInfo payInfo = PayrollFactory.getLocalInstance(ctx).getPayrollCollection(view).get(0);
		return payInfo;
	}

	/**
	 * ��ȡ���������籣��
	 * 
	 * @author ywj 2017-11-23
	 * @param info
	 * @param fullInfoPk
	 * @param ctx
	 * @return ��ȡʧ�ܣ�����false���ɹ��򷵻�true
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private boolean getFranceNameAndSecuNumber(SecuSplitInfo info, String fullInfoPk, Context ctx) throws BOSException, EASBizException {
		// ��ѯ��Ŀ
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		filter.getFilterItems().add(new FilterItemInfo("proCom.id", fullInfoPk));
		sic.add("nameFR");
		sic.add("insuranceAcc");
		view.setFilter(filter);
		view.setSelector(sic);
		ProjectOrgInfo projInfo = ProjectOrgFactory.getLocalInstance(ctx).getProjectOrgCollection(view).get(0);
		if (projInfo == null)
			return false;
		// ����
		info.setProjFR(projInfo.getNameFR());
		info.setProjSC(projInfo.getInsuranceAcc());
		updatePartial(ctx, info, sic);
		return true;
	}

	/**
	 * ��ȡ�������ݵļ���
	 * 
	 * @param ctx
	 * 
	 * @param payInfo
	 * @param foripayInfo
	 * @return
	 */
	private Set getPayObjectSet(Context ctx, PayrollInfo payInfo, ForiPayrollInfo foripayInfo) {
		Set<Object> set = new HashSet<Object>();
		PayrollEntryCollection payEntryCol = new PayrollEntryCollection();
		ForiPayrollEntryCollection foriPayEntryCol = new ForiPayrollEntryCollection();
		if (payInfo != null) {
			payEntryCol = payInfo.getEntrys();
			for (int i = 0; i < payEntryCol.size(); i++) {
				set.add(payEntryCol.get(i));
			}
		}
		if (foripayInfo != null) {
			foriPayEntryCol = foripayInfo.getEntrys();
			for (int i = 0; i < foriPayEntryCol.size(); i++) {
				set.add(foriPayEntryCol.get(i));
			}
		}
		return set;
	}

	/**
	 * ȡ�����к�����λ�ļ��� �����������λΪ�н�������Ա��number=HCSCEC�������򼯺�����Ӹ���Ա�Ĺ�����Ŀ��
	 * ��������Ա���򼯺�����Ӹ���Ա�ĺ�����λ��
	 * 
	 * @param ctx
	 * 
	 * @param foripayInfo
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private Set getCoopSet(Context ctx, Set paySet) throws EASBizException, BOSException {
		Set coopSet = new HashSet<AdminOrgUnitInfo>();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("*");
		for (Object obj : paySet) {
			if (obj instanceof PayrollEntryInfo) {
				PayrollEntryInfo pay = (PayrollEntryInfo) obj;
				AdminOrgUnitInfo coop = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(pay.getCooperation().getId()), sic);
				if ("HCSCEC".equals(coop.getNumber())) {
					AdminOrgUnitInfo workOrg = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(pay.getWorkProgram().getId()), sic);
					pay.setCooperation(workOrg);
					coopSet.add(workOrg);
				} else {
					coopSet.add(coop);
				}

			} else if (obj instanceof ForiPayrollEntryInfo) {
				ForiPayrollEntryInfo foriPay = (ForiPayrollEntryInfo) obj;
				AdminOrgUnitInfo coop = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(foriPay.getCooperation().getId()), sic);
				if ("HCSCEC".equals(coop.getNumber())) {
					AdminOrgUnitInfo workOrg = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(foriPay.getWorkProgram().getId()), sic);
					foriPay.setCooperation(workOrg);
					coopSet.add(workOrg);
				} else {
					coopSet.add(coop);
				}
			}
		}
		return coopSet;
	}

}