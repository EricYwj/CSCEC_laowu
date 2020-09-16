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

	// 保存
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		SecuSplitInfo accInfo = (SecuSplitInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		// 设置编码
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany =
		// ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory =
		// CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //不允许断号
		// if(codFactory.isUseIntermitNumber(accInfo,
		// orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
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
		SecuSplitInfo accInfo = (SecuSplitInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
		// 设置编码
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany =
		// ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory =
		// CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //不允许断号
		// if(codFactory.isUseIntermitNumber(accInfo,
		// orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
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
	 * 审核不通过
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
	 * 初始化或删除单据
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
		if (b) {// 审核通过
			if (col.size() == 0) {
				// 新增汇总
				SecuPayCountInfo spcInfo = new SecuPayCountInfo();
				// 表头
				spcInfo.setId(BOSUuid.create(spcInfo.getBOSType()));
				spcInfo.setSourceBillId(info.getId().toString());
				spcInfo.setNumber(info.getNumber());// 单据编号
				spcInfo.setBillSate(BillStateEnum.DRAFT);// 单据状态
				spcInfo.setBizDate(new Date());// 业务日期
				spcInfo.setMonthYear(monthYearr);// 年月
				SecuPayCountFactory.getLocalInstance(ctx).addnew(spcInfo);
			}
		} else {// 反审核
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
	 * 实例化单据
	 * 
	 * @author ywj 2017-11-23
	 */
	protected IObjectValue _initBill(Context ctx, String PK, String fullInfoPk) throws BOSException, EASBizException {
		// 初始化单据对象
		SecuSplitInfo info = new SecuSplitInfo();

		// 删除所有分录
		info = SecuSplitFactory.getLocalInstance(ctx).getSecuSplitInfo(new ObjectUuidPK(PK));
		SecuSplitEntryCollection col = info.getEntrys();
		for (int i = 0; i < col.size(); i++)
			SecuSplitEntryFactory.getLocalInstance(ctx).delete(new ObjectUuidPK(col.get(i).getId()));
		// 赋值法文名和社保号
		if (!getFranceNameAndSecuNumber(info, fullInfoPk, ctx))// 获取法文名和社保号
			return null;

		// 查询阿工工资数据单据
		PayrollInfo payInfo = getAlgPayrollData(info, fullInfoPk, ctx);

		// 查询外工工资数据单据
		ForiPayrollInfo foripayInfo = getforiPayrollData(info, fullInfoPk, ctx);

		// 判断工资数据是否全
		if (payInfo == null && foripayInfo == null)
			return null;

		// 初始化表体
		inniEntry(info, ctx, payInfo, foripayInfo);

		return info;
	}

	/**
	 * 初始化表体
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
		// 获取工资数据的泛型集合
		Set payEntrySet = getPayObjectSet(ctx, payInfo, foripayInfo);
		// 根据工资数据获取合作单位的集合
		Set coopSet = getCoopSet(ctx, payEntrySet);
		// 根据合作单位集合获取合作单位和工作单位的集合
		Set coopAndWorkSet = getCoopAndWorkSet(ctx, coopSet, payEntrySet);
		// 循环集合赋值表体
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
							// String coopCode = "";//合作单位代码
							int coopAlgSc = 0;// 合作单位属地化缴纳社保人数
							int coopForiSc = 0;// 合作单位外工缴纳社保人数
							int coopScPers = 0;// 合作单位缴纳社保总人数
							BigDecimal coopAlgScM = BigDecimal.ZERO;
							BigDecimal coopAlgVcM = BigDecimal.ZERO;
							BigDecimal coopForiScM = BigDecimal.ZERO;
							BigDecimal coopForiVcM = BigDecimal.ZERO;
							BigDecimal localIRGC = BigDecimal.ZERO;
							BigDecimal foriIRGC = BigDecimal.ZERO;
							BigDecimal vcCount = BigDecimal.ZERO;
							BigDecimal IRGCount = BigDecimal.ZERO;
							BigDecimal coopScMoney = BigDecimal.ZERO;// 合作单位社保缴纳总金额
							// 循环工资数据分录集合
							for (Object obj : payEntrySet) {
								// 阿工
								if (obj instanceof PayrollEntryInfo) {
									PayrollEntryInfo payEntryInfo = (PayrollEntryInfo) obj;
									if (payEntryInfo.getNWorkDay() != null) {
										if (payEntryInfo.getCooperation() != null && payEntryInfo.getWorkProgram() != null && coopInfo.getId().equals(payEntryInfo.getCooperation().getId()) && workProj.getId().equals(payEntryInfo.getWorkProgram().getId())) {
											coopAlgSc++;// 合作单位属地化缴纳社保人数
											coopAlgScM = coopAlgScM.add(payEntryInfo.getSociaLevyBase() == null ? BigDecimal.ZERO : payEntryInfo.getSociaLevyBase());// 社保征收基数
											localIRGC = localIRGC.add(payEntryInfo.getIRGDPerson() == null ? BigDecimal.ZERO : payEntryInfo.getIRGDPerson());// IRG
											coopScMoney = coopScMoney.add(payEntryInfo.getSociaLevyBase() == null ? BigDecimal.ZERO : payEntryInfo.getSociaLevyBase());// 合作单位社保缴纳总金额
											IRGCount = IRGCount.add(payEntryInfo.getIRGDPerson() == null ? BigDecimal.ZERO : payEntryInfo.getIRGDPerson());// IRG合计
										}
									}
									// 外工
								} else if (obj instanceof ForiPayrollEntryInfo) {
									ForiPayrollEntryInfo payEntryInfo = (ForiPayrollEntryInfo) obj;
									if (payEntryInfo.getNWorkDay() != null) {
										if (payEntryInfo.getCooperation() != null && payEntryInfo.getWorkProgram() != null && coopInfo.getId().equals(payEntryInfo.getCooperation().getId()) && workProj.getId().equals(payEntryInfo.getWorkProgram().getId())) {
											coopForiSc++;// 合作单位外工缴纳社保人数
											coopForiScM = coopForiScM.add(payEntryInfo.getSociaLevyBase() == null ? BigDecimal.ZERO : payEntryInfo.getSociaLevyBase());
											foriIRGC = foriIRGC.add(payEntryInfo.getIRGDPerson() == null ? BigDecimal.ZERO : payEntryInfo.getIRGDPerson());
											coopScMoney = coopScMoney.add(payEntryInfo.getSociaLevyBase() == null ? BigDecimal.ZERO : payEntryInfo.getSociaLevyBase());// 合作单位社保缴纳总金额
											IRGCount = IRGCount.add(payEntryInfo.getIRGDPerson() == null ? BigDecimal.ZERO : payEntryInfo.getIRGDPerson());// 合作单位社保缴纳总金额
										}
									}
								}
							}
							// 新增分录
							SecuSplitEntryInfo etyInfo = new SecuSplitEntryInfo();
							etyInfo.setId(BOSUuid.create(etyInfo.getBOSType()));
							AdminOrgUnitInfo coop = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(coopInfo.getId()));
							AdminOrgUnitInfo workProj1 =AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(workProj.getId()));
							etyInfo.setCooperation(coop);// 合作单位
							etyInfo.setWorkProj(workProj1);// 工作单位
							etyInfo.setCoopCode(coop.getNumber());// 合作单位代码
							etyInfo.setCoopAlgSc(coopAlgSc);// 属地化社保缴纳人数
							etyInfo.setCoopForiSc(coopForiSc);// 外籍员工社保缴纳人数
							etyInfo.setCoopScPers(coopAlgSc + coopForiSc);// 总人数
							etyInfo.setCoopAlgScNew(new BigDecimal(coopAlgSc));// 属地化社保缴纳人数
							etyInfo.setCoopForiScNew(new BigDecimal(coopForiSc));// 外籍员工社保缴纳人数
							etyInfo.setCoopScPersNew(new BigDecimal(coopAlgSc + coopForiSc));// 总人数
							etyInfo.setCoopScMoney((coopForiScM.add(coopAlgScM)).multiply(new BigDecimal("0.3513")));// 总金额
							etyInfo.setCoopAlgScM(coopAlgScM.multiply(new BigDecimal("0.3513")));// 属地化社保金额
							etyInfo.setCoopAlgVcM(coopAlgScM.multiply(new BigDecimal("0.1296")));// 属地化休假工资
							etyInfo.setCoopForiScM(coopForiScM.multiply(new BigDecimal("0.3513")));// 外籍员工社保金额
							etyInfo.setCoopForiVcM(coopForiScM.multiply(new BigDecimal("0.1296")));// 外籍员工休假工资金额
							etyInfo.setLocalIRGC(localIRGC);// 属地化IRG
							etyInfo.setForiIRGC(foriIRGC);// 外籍IRG
							etyInfo.setVcCount(coopAlgScM.multiply(new BigDecimal("0.1296")).add(coopForiScM.multiply(new BigDecimal("0.1296"))));// 休假工资总额
							etyInfo.setIRGCount(IRGCount);// IRG总额
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
	 * 查询外工工资数据单据
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
	 * 查询阿工工资数据单据
	 * 
	 * @author ywj 2017-11-23
	 * @param info
	 * @param fullInfoPk
	 * @param ctx
	 * @return 获取失败，返回null，成功则返回业务对象
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
	 * 获取法文名和社保号
	 * 
	 * @author ywj 2017-11-23
	 * @param info
	 * @param fullInfoPk
	 * @param ctx
	 * @return 获取失败，返回false，成功则返回true
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private boolean getFranceNameAndSecuNumber(SecuSplitInfo info, String fullInfoPk, Context ctx) throws BOSException, EASBizException {
		// 查询项目
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
		// 更新
		info.setProjFR(projInfo.getNameFR());
		info.setProjSC(projInfo.getInsuranceAcc());
		updatePartial(ctx, info, sic);
		return true;
	}

	/**
	 * 获取工资数据的集合
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
	 * 取出所有合作单位的集合 【如果合作单位为中建管理人员（number=HCSCEC），则向集合中添加该人员的工作项目】
	 * 【正常人员，向集合中添加该人员的合作单位】
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