/**
 * output package name
 */
package com.kingdee.eas.zjlw.social.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.certificates.IfilentryFactory;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryCollection;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryInfo;
import com.kingdee.eas.zjlw.social.ForiPayrollFactory;
import com.kingdee.eas.zjlw.social.ForiPayrollInfo;
import com.kingdee.eas.zjlw.social.PayrollCollection;
import com.kingdee.eas.zjlw.social.PayrollEntryCollection;
import com.kingdee.eas.zjlw.social.PayrollEntryInfo;
import com.kingdee.eas.zjlw.social.PayrollFactory;
import com.kingdee.eas.zjlw.social.PayrollInfo;
import com.kingdee.eas.zjlw.social.ProjFEREntryInfo;
import com.kingdee.eas.zjlw.social.SecuSplitEntryCollection;
import com.kingdee.eas.zjlw.social.SecuSplitEntryInfo;
import com.kingdee.eas.zjlw.social.SecuSplitFactory;
import com.kingdee.eas.zjlw.social.SecuSplitInfo;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.cbos.process.vm.internal.i.adapter.Begin;

/**
 * output class name
 */
public class SecuSplitEditUI extends AbstractSecuSplitEditUI {
	private static final Logger logger = CoreUIObject.getLogger(SecuSplitEditUI.class);
	/**
	 * 属地化缴纳社保人数 coopAlgSc;
	 * 
	 * 外工缴纳社保人数 coopForiSc;
	 * 
	 * 社保缴纳总人数 coopScPers;
	 * 
	 * 社保缴纳总金额 coopScMoney;
	 * 
	 * 外工缴纳休假工资金额 coopForiVcM;
	 * 
	 * 属地化员工缴纳休假工资金额 coopAlgVcM;
	 * 
	 * 属地化员工缴纳社保金额 coopAlgScM;
	 * 
	 * 外工缴纳社保金额 coopForiScM;
	 * 
	 * 属地化员工IRG缴纳总额 localIRGC;
	 * 
	 * 外籍员工IRG缴纳总额 foriIRGC;
	 * 
	 * 休假工资缴纳总额 vcCount;
	 * 
	 * IRG缴纳总额 IRGCount;
	 */
	protected static final String[] footField_entry = { "coopAlgScNew", "coopForiScNew", "coopScPersNew", "coopScMoney", "coopForiVcM", "coopAlgVcM", "coopAlgScM", "coopForiScM", "localIRGC", "foriIRGC", "vcCount", "IRGCount" };

	public void onLoad() throws Exception {
		super.onLoad();
		// 修改简体中文和法文编辑界面的单据名称与列表界面名称一致 modified by wangth on 20170628 start
		String strLanguage = com.kingdee.eas.common.client.SysContext.getSysContext().getLocale().getLanguage();
		if ("L1".equals(strLanguage) || "l1".equals(strLanguage)) {
			setUITitle("");
		} else if ("L2".equals(strLanguage) || "l2".equals(strLanguage)) {
			setUITitle("项目社保和休假工资分摊表");
		} else {
			// setUITitle("");
		}
		// 修改简体中文和法文编辑界面的单据名称与列表界面名称一致 modified by wangth on 20170628 end
		setButtonStatus();
		// 初始化单据
		if (getOprtState().equals("EDIT")) {
			if (!this.editData.isIsOk()) {
				this.kdtEntrys.removeRows();
				SecuSplitInfo info = SecuSplitFactory.getRemoteInstance().getSecuSplitInfo(new ObjectUuidPK(this.editData.getId()));
				info = SecuSplitFactory.getRemoteInstance().initBill(this.editData.getId().toString(), info.getProjName().getId().toString());
				getProj();// 获取法文名和社保号
				syncDataFromDB();
				handleOldData();
				// 增加合计行 TODO
				inniCountRow(info);
			}
		}
		this.kdtEntrys.getColumn("coopAlgScM").getStyleAttributes().setNumberFormat("###,###,##0.00");// 属地化员工社保缴纳总额
		this.kdtEntrys.getColumn("coopAlgVcM").getStyleAttributes().setNumberFormat("###,###,##0.00");// 属地化员工休假工资缴纳总额
		this.kdtEntrys.getColumn("localIRGC").getStyleAttributes().setNumberFormat("###,###,##0.00");// 属地化员工IRG缴纳总额
		this.kdtEntrys.getColumn("coopForiScM").getStyleAttributes().setNumberFormat("###,###,##0.00");// 外籍员工社保缴纳总额
		this.kdtEntrys.getColumn("coopForiVcM").getStyleAttributes().setNumberFormat("###,###,##0.00");// 外籍员工休假工资缴纳总额
		this.kdtEntrys.getColumn("foriIRGC").getStyleAttributes().setNumberFormat("###,###,##0.00");// 外籍员工IRG缴纳总额
		this.kdtEntrys.getColumn("coopScMoney").getStyleAttributes().setNumberFormat("###,###,##0.00");// 社保缴纳总额
		this.kdtEntrys.getColumn("vcCount").getStyleAttributes().setNumberFormat("###,###,##0.00");// 休假工资缴纳总额
		this.kdtEntrys.getColumn("IRGCount").getStyleAttributes().setNumberFormat("###,###,##0.00");// IRG缴纳总额

		this.chkisOk.setVisible(false);
		// 添加合计行
		// TableHelper.appendFootRow(kdtEntrys, footField_entry, TableHelper.getFormatString(2));
	}

	protected void handleOldData() {
		if (!("VIEW".equals(getOprtState()))) {
			storeFields();
			initOldData(this.editData);
		}
	}

	protected void syncDataFromDB() throws Exception {
		if (getUIContext().get("ID") == null) {
			String s = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_IDIsNull");
			MsgBox.showError(s);
			SysUtil.abort();
		}
		IObjectPK pk = new ObjectUuidPK(BOSUuid.read(getUIContext().get("ID").toString()));
		setDataObject(getValue(pk));
		loadFields();
	}

	protected void setButtonStatus() {
		SecuSplitInfo bill;
		if ("VIEW".equals(getOprtState())) {
			bill = (SecuSplitInfo) this.editData;
			if (this.editData != null) {
				if (BillStateEnum.CHECKED.equals(bill.getBillSate())) {
					this.actionEdit.setEnabled(false);
					this.actionRemove.setEnabled(false);
				} else {
					this.actionRemove.setEnabled(true);
					this.actionEdit.setEnabled(true);
				}
			}
			this.actionAddLine.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionInsertLine.setEnabled(false);
		} else {
			bill = (SecuSplitInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null) && (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(false);
			}
		}
		if (((BillStateEnum.CHECKED.equals(bill.getBillSate()))) || ("ADDNEW".equalsIgnoreCase(getOprtState()))) {
			this.actionPrint.setEnabled(false);
			this.actionPrintPreview.setEnabled(false);
			this.actionAttachment.setEnabled(false);
		} else {
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(true);
		}
		if (this.editData != null) {
			bill = (SecuSplitInfo) this.editData;
			if (!(BillStateEnum.DRAFT.equals(bill.getBillSate()))) {
				this.actionAuditResult.setEnabled(true);
				this.actionMultiapprove.setEnabled(true);
				this.actionNextPerson.setEnabled(true);
				this.actionWorkflowList.setEnabled(true);
				this.actionAuditResult.setVisible(true);
				this.actionMultiapprove.setVisible(true);
				this.actionNextPerson.setVisible(true);
				this.actionWorkflowList.setVisible(true);
			} else {
				this.actionAuditResult.setEnabled(false);
				this.actionMultiapprove.setEnabled(false);
				this.actionNextPerson.setEnabled(false);
				this.actionWorkflowList.setEnabled(false);

				this.actionAuditResult.setVisible(false);
				this.actionMultiapprove.setVisible(false);
				this.actionNextPerson.setVisible(false);
				this.actionWorkflowList.setVisible(false);
			}
		}
	}

	/**
	 * 增加合计行
	 * 
	 * @param payInfo
	 * @param foripayInfo
	 * @throws Exception 
	 */
	private void inniCountRow(SecuSplitInfo info) throws Exception {
		int foriScCount = 0;// 外工缴纳社保人数
		int algScCount = 0;// 属地化缴纳社保人数
		BigDecimal algScMoney = BigDecimal.ZERO;// 属地化缴纳社保金额
		BigDecimal algVcCount = BigDecimal.ZERO;// 属地化休假工资总金额
		BigDecimal algIRG = BigDecimal.ZERO;// 属地化IRG
		BigDecimal foriScMoney = BigDecimal.ZERO;// 外工缴纳社保金额
		BigDecimal foriVcCount = BigDecimal.ZERO;// 外工休假工资总金额
		BigDecimal foriIRG = BigDecimal.ZERO;// 外工IRG
		SecuSplitEntryCollection etyCol = info.getEntrys();
		for (int i = 0; i < etyCol.size(); i++) {
			SecuSplitEntryInfo etyInfo = etyCol.get(i);
			if (etyInfo.getWorkProj() != null) {
				// 人数
				foriScCount = foriScCount + etyInfo.getCoopForiSc();
				algScCount = algScCount + etyInfo.getCoopAlgSc();
				// 社保
				algScMoney = algScMoney.add(etyInfo.getCoopAlgScM());
				foriScMoney = foriScMoney.add(etyInfo.getCoopForiScM());
				// 休假工资
				algVcCount = algVcCount.add(etyInfo.getCoopAlgVcM());
				foriVcCount = foriVcCount.add(etyInfo.getCoopForiVcM());
				// IRG
				algIRG = algIRG.add(etyInfo.getLocalIRGC());
				foriIRG = foriIRG.add(etyInfo.getForiIRGC());
			}
		}
		IRow row = this.kdtEntrys.addRow(0);
		FilterInfo coopFilter = new FilterInfo();
		coopFilter.getFilterItems().add(new FilterItemInfo("number", "HCount"));
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(coopFilter);
		AdminOrgUnitInfo coop = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitCollection(view).get(0);
		row.getCell("cooperation").setValue(coop);
		row.getCell("coopCode").setValue(null);
		row.getCell("coopAlgSc").setValue(algScCount);// 属地化缴纳社保人数
		row.getCell("coopAlgScNew").setValue(algScCount);// 属地化缴纳社保人数
		row.getCell("coopForiSc").setValue(foriScCount);// 外工缴纳社保人数
		row.getCell("coopForiScNew").setValue(foriScCount);// 外工缴纳社保人数
		row.getCell("coopScPers").setValue(foriScCount + algScCount);// 社保缴纳总人数
		row.getCell("coopScPersNew").setValue(foriScCount + algScCount);// 社保缴纳总人数
		row.getCell("coopAlgScM").setValue(algScMoney);// 属地化缴纳社保金额
		row.getCell("coopForiScM").setValue(foriScMoney);// 外工缴纳社保金额
		row.getCell("coopScMoney").setValue(algScMoney.add(foriScMoney));// 社保总金额
		row.getCell("coopAlgVcM").setValue(algVcCount);// 属地化缴纳休假工资金额
		row.getCell("coopForiVcM").setValue(foriVcCount);// 外工缴纳休假工资金额
		row.getCell("vcCount").setValue(algVcCount.add(foriVcCount));
		row.getCell("foriIRGC").setValue(foriIRG);// 外工IRG
		row.getCell("localIRGC").setValue(algIRG);// 属地化IRG
		row.getCell("IRGCount").setValue(foriIRG.add(algIRG));// IRG合计
	}

	/**
	 * 查询阿工工资数据单据
	 * 
	 * @throws BOSException
	 */
	private PayrollInfo getAlgPayrollData() throws BOSException {
		FilterInfo filter = new FilterInfo();
		PeriodInfo perInfo = (PeriodInfo) this.prmtmonthYearr.getValue();
		AdminOrgUnitInfo projInfo = (AdminOrgUnitInfo) this.prmtprojName.getValue();
		filter.getFilterItems().add(new FilterItemInfo("monthyearr.id", perInfo == null ? null : perInfo.getId()));
		filter.getFilterItems().add(new FilterItemInfo("projName.id", projInfo == null ? null : projInfo.getId()));
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("entrys.*");
		view.setFilter(filter);
		view.setSelector(sic);
		PayrollInfo payInfo = PayrollFactory.getRemoteInstance().getPayrollCollection(view).get(0);
		return payInfo;
	}

	/**
	 * 查询外工工资数据单据
	 * 
	 * @throws BOSException
	 */
	private ForiPayrollInfo getforiPayrollData() throws BOSException {
		FilterInfo filter = new FilterInfo();
		PeriodInfo perInfo = (PeriodInfo) this.prmtmonthYearr.getValue();
		AdminOrgUnitInfo projInfo = (AdminOrgUnitInfo) this.prmtprojName.getValue();
		filter.getFilterItems().add(new FilterItemInfo("monthyearr.id", perInfo == null ? null : perInfo.getId()));
		filter.getFilterItems().add(new FilterItemInfo("projName.id", projInfo == null ? null : projInfo.getId()));
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("entrys.*");
		view.setFilter(filter);
		view.setSelector(sic);
		ForiPayrollInfo payInfo = ForiPayrollFactory.getRemoteInstance().getForiPayrollCollection(view).get(0);
		return payInfo;
	}

	/**
	 * 获取工资数据的集合
	 * 
	 * @param payInfo
	 * @param foripayInfo
	 * @return
	 */
	private Set getPayObjectSet(PayrollInfo payInfo, ForiPayrollInfo foripayInfo) {
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
	 * 取出所有合作单位的集合 【如果合作单位为中建管理人员（number=HCSCEC），则向集合中添加该人员的工作项目】 【正常人员，向集合中添加该人员的合作单位】
	 * 
	 * @param foripayInfo
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private Set getCoopSet(Set paySet) throws EASBizException, BOSException {
		Set coopSet = new HashSet<AdminOrgUnitInfo>();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("*");
		for (Object obj : paySet) {
			if (obj instanceof PayrollEntryInfo) {
				PayrollEntryInfo pay = (PayrollEntryInfo) obj;
				AdminOrgUnitInfo coop = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(pay.getCooperation().getId()), sic);
				if ("HCSCEC".equals(coop.getNumber())) {
					AdminOrgUnitInfo workOrg = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(pay.getWorkProgram().getId()), sic);
					pay.setCooperation(workOrg);
					coopSet.add(workOrg);
				} else {
					coopSet.add(coop);
				}

			} else if (obj instanceof ForiPayrollEntryInfo) {
				ForiPayrollEntryInfo foriPay = (ForiPayrollEntryInfo) obj;
				AdminOrgUnitInfo coop = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(foriPay.getCooperation().getId()), sic);
				if ("HCSCEC".equals(coop.getNumber())) {
					AdminOrgUnitInfo workOrg = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(foriPay.getWorkProgram().getId()), sic);
					foriPay.setCooperation(workOrg);
					coopSet.add(workOrg);
				} else {
					coopSet.add(coop);
				}
			}
		}
		return coopSet;
	}

	/**
	 * 根据项目名称获取项目法文名和项目社保号
	 * 
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void getProj() throws EASBizException, BOSException {
		AdminOrgUnitInfo proj = (AdminOrgUnitInfo) this.prmtprojName.getValue();
		if (proj != null) {
			FilterInfo filter = new FilterInfo();
			EntityViewInfo view = new EntityViewInfo();
			SelectorItemCollection sic = new SelectorItemCollection();
			filter.getFilterItems().add(new FilterItemInfo("proCom.id", proj == null ? null : proj.getId()));
			sic.add("nameFR");
			sic.add("insuranceAcc");
			view.setFilter(filter);
			view.setSelector(sic);
			ProjectOrgInfo projInfo = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view).get(0);
			if (projInfo == null) {
				MsgBox.showInfo("所选项目未建立基础信息，请重新选择！");
				this.prmtprojName.setValue(null);
				this.txtprojFR.setText("");
				this.txtprojSC.setText("");
				abort();
			}
			this.txtprojFR.setText(projInfo.getNameFR());
			this.txtprojSC.setText(projInfo.getInsuranceAcc());
		}
	}

	/**
	 * output class constructor
	 */
	public SecuSplitEditUI() throws Exception {
		super();
	}

	/**
	 * output loadFields method
	 */
	public void loadFields() {
		super.loadFields();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();
	}

	/**
	 * output btnAddLine_actionPerformed method
	 */
	protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception {
		super.btnAddLine_actionPerformed(e);
	}

	/**
	 * output menuItemEnterToNextRow_itemStateChanged method
	 */
	protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception {
		super.menuItemEnterToNextRow_itemStateChanged(e);
	}

	/**
	 * output actionPageSetup_actionPerformed
	 */
	public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception {
		super.actionPageSetup_actionPerformed(e);
	}

	/**
	 * output actionExitCurrent_actionPerformed
	 */
	public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception {
		super.actionExitCurrent_actionPerformed(e);
	}

	/**
	 * output actionHelp_actionPerformed
	 */
	public void actionHelp_actionPerformed(ActionEvent e) throws Exception {
		super.actionHelp_actionPerformed(e);
	}

	/**
	 * output actionAbout_actionPerformed
	 */
	public void actionAbout_actionPerformed(ActionEvent e) throws Exception {
		super.actionAbout_actionPerformed(e);
	}

	/**
	 * output actionOnLoad_actionPerformed
	 */
	public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception {
		super.actionOnLoad_actionPerformed(e);
	}

	/**
	 * output actionSendMessage_actionPerformed
	 */
	public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception {
		super.actionSendMessage_actionPerformed(e);
	}

	/**
	 * output actionCalculator_actionPerformed
	 */
	public void actionCalculator_actionPerformed(ActionEvent e) throws Exception {
		super.actionCalculator_actionPerformed(e);
	}

	/**
	 * output actionExport_actionPerformed
	 */
	public void actionExport_actionPerformed(ActionEvent e) throws Exception {
		super.actionExport_actionPerformed(e);
	}

	/**
	 * output actionExportSelected_actionPerformed
	 */
	public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception {
		super.actionExportSelected_actionPerformed(e);
	}

	/**
	 * output actionRegProduct_actionPerformed
	 */
	public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception {
		super.actionRegProduct_actionPerformed(e);
	}

	/**
	 * output actionPersonalSite_actionPerformed
	 */
	public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception {
		super.actionPersonalSite_actionPerformed(e);
	}

	/**
	 * output actionProcductVal_actionPerformed
	 */
	public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception {
		super.actionProcductVal_actionPerformed(e);
	}

	/**
	 * output actionExportSave_actionPerformed
	 */
	public void actionExportSave_actionPerformed(ActionEvent e) throws Exception {
		super.actionExportSave_actionPerformed(e);
	}

	/**
	 * output actionExportSelectedSave_actionPerformed
	 */
	public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception {
		super.actionExportSelectedSave_actionPerformed(e);
	}

	/**
	 * output actionKnowStore_actionPerformed
	 */
	public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception {
		super.actionKnowStore_actionPerformed(e);
	}

	/**
	 * output actionAnswer_actionPerformed
	 */
	public void actionAnswer_actionPerformed(ActionEvent e) throws Exception {
		super.actionAnswer_actionPerformed(e);
	}

	/**
	 * output actionRemoteAssist_actionPerformed
	 */
	public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception {
		super.actionRemoteAssist_actionPerformed(e);
	}

	/**
	 * output actionPopupCopy_actionPerformed
	 */
	public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception {
		super.actionPopupCopy_actionPerformed(e);
	}

	/**
	 * output actionHTMLForMail_actionPerformed
	 */
	public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception {
		super.actionHTMLForMail_actionPerformed(e);
	}

	/**
	 * output actionExcelForMail_actionPerformed
	 */
	public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception {
		super.actionExcelForMail_actionPerformed(e);
	}

	/**
	 * output actionHTMLForRpt_actionPerformed
	 */
	public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception {
		super.actionHTMLForRpt_actionPerformed(e);
	}

	/**
	 * output actionExcelForRpt_actionPerformed
	 */
	public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception {
		super.actionExcelForRpt_actionPerformed(e);
	}

	/**
	 * output actionLinkForRpt_actionPerformed
	 */
	public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception {
		super.actionLinkForRpt_actionPerformed(e);
	}

	/**
	 * output actionPopupPaste_actionPerformed
	 */
	public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception {
		super.actionPopupPaste_actionPerformed(e);
	}

	/**
	 * output actionToolBarCustom_actionPerformed
	 */
	public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception {
		super.actionToolBarCustom_actionPerformed(e);
	}

	/**
	 * output actionCloudFeed_actionPerformed
	 */
	public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception {
		super.actionCloudFeed_actionPerformed(e);
	}

	/**
	 * output actionCloudShare_actionPerformed
	 */
	public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception {
		super.actionCloudShare_actionPerformed(e);
	}

	/**
	 * output actionCloudScreen_actionPerformed
	 */
	public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception {
		super.actionCloudScreen_actionPerformed(e);
	}

	/**
	 * output actionXunTongFeed_actionPerformed
	 */
	public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception {
		super.actionXunTongFeed_actionPerformed(e);
	}

	/**
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// 计算合计行
		// TableHelper.setSumToRow(kdtEntrys, footField_entry);
		super.actionSave_actionPerformed(e);
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
	}

	/**
	 * output actionCancel_actionPerformed
	 */
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		super.actionCancel_actionPerformed(e);
	}

	/**
	 * output actionCancelCancel_actionPerformed
	 */
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception {
		super.actionCancelCancel_actionPerformed(e);
	}

	/**
	 * output actionFirst_actionPerformed
	 */
	public void actionFirst_actionPerformed(ActionEvent e) throws Exception {
		super.actionFirst_actionPerformed(e);
	}

	/**
	 * output actionPre_actionPerformed
	 */
	public void actionPre_actionPerformed(ActionEvent e) throws Exception {
		super.actionPre_actionPerformed(e);
	}

	/**
	 * output actionNext_actionPerformed
	 */
	public void actionNext_actionPerformed(ActionEvent e) throws Exception {
		super.actionNext_actionPerformed(e);
	}

	/**
	 * output actionLast_actionPerformed
	 */
	public void actionLast_actionPerformed(ActionEvent e) throws Exception {
		super.actionLast_actionPerformed(e);
	}

	/**
	 * output actionPrint_actionPerformed
	 */
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		super.actionPrint_actionPerformed(e);
	}

	/**
	 * output actionPrintPreview_actionPerformed
	 */
	public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception {
		super.actionPrintPreview_actionPerformed(e);
	}

	/**
	 * output actionCopy_actionPerformed
	 */
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		super.actionCopy_actionPerformed(e);
	}

	/**
	 * output actionAddNew_actionPerformed
	 */
	public void actionAddNew_actionPerformed(ActionEvent e) throws Exception {
		super.actionAddNew_actionPerformed(e);
	}

	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		super.actionEdit_actionPerformed(e);
		if (!this.editData.isIsOk()) {
			this.kdtEntrys.removeRows();
			SecuSplitInfo info = SecuSplitFactory.getRemoteInstance().getSecuSplitInfo(new ObjectUuidPK(this.editData.getId()));
			info = SecuSplitFactory.getRemoteInstance().initBill(this.editData.getId().toString(), info.getProjName().getId().toString());
			getProj();// 获取法文名和社保号
			syncDataFromDB();
			handleOldData();
			// 增加合计行 TODO
			inniCountRow(info);
//			syncDataFromDB();
//			handleOldData();
		}
	}

	/**
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		super.actionRemove_actionPerformed(e);
	}

	/**
	 * output actionAttachment_actionPerformed
	 */
	public void actionAttachment_actionPerformed(ActionEvent e) throws Exception {
		super.actionAttachment_actionPerformed(e);
	}

	/**
	 * output actionSubmitOption_actionPerformed
	 */
	public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmitOption_actionPerformed(e);
	}

	/**
	 * output actionReset_actionPerformed
	 */
	public void actionReset_actionPerformed(ActionEvent e) throws Exception {
		super.actionReset_actionPerformed(e);
	}

	/**
	 * output actionMsgFormat_actionPerformed
	 */
	public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception {
		super.actionMsgFormat_actionPerformed(e);
	}

	/**
	 * output actionAddLine_actionPerformed
	 */
	public void actionAddLine_actionPerformed(ActionEvent e) throws Exception {
		super.actionAddLine_actionPerformed(e);
	}

	/**
	 * output actionCopyLine_actionPerformed
	 */
	public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception {
		super.actionCopyLine_actionPerformed(e);
	}

	/**
	 * output actionInsertLine_actionPerformed
	 */
	public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception {
		super.actionInsertLine_actionPerformed(e);
	}

	/**
	 * output actionRemoveLine_actionPerformed
	 */
	public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception {
		super.actionRemoveLine_actionPerformed(e);
	}

	/**
	 * output actionCreateFrom_actionPerformed
	 */
	public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception {
		super.actionCreateFrom_actionPerformed(e);
	}

	/**
	 * output actionCopyFrom_actionPerformed
	 */
	public void actionCopyFrom_actionPerformed(ActionEvent e) throws Exception {
		super.actionCopyFrom_actionPerformed(e);
	}

	/**
	 * output actionAuditResult_actionPerformed
	 */
	public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception {
		super.actionAuditResult_actionPerformed(e);
	}

	/**
	 * output actionTraceUp_actionPerformed
	 */
	public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception {
		super.actionTraceUp_actionPerformed(e);
	}

	/**
	 * output actionTraceDown_actionPerformed
	 */
	public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception {
		super.actionTraceDown_actionPerformed(e);
	}

	/**
	 * output actionViewSubmitProccess_actionPerformed
	 */
	public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception {
		super.actionViewSubmitProccess_actionPerformed(e);
	}

	/**
	 * output actionViewDoProccess_actionPerformed
	 */
	public void actionViewDoProccess_actionPerformed(ActionEvent e) throws Exception {
		super.actionViewDoProccess_actionPerformed(e);
	}

	/**
	 * output actionMultiapprove_actionPerformed
	 */
	public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception {
		super.actionMultiapprove_actionPerformed(e);
	}

	/**
	 * output actionNextPerson_actionPerformed
	 */
	public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception {
		super.actionNextPerson_actionPerformed(e);
	}

	/**
	 * output actionStartWorkFlow_actionPerformed
	 */
	public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception {
		super.actionStartWorkFlow_actionPerformed(e);
	}

	/**
	 * output actionVoucher_actionPerformed
	 */
	public void actionVoucher_actionPerformed(ActionEvent e) throws Exception {
		super.actionVoucher_actionPerformed(e);
	}

	/**
	 * output actionDelVoucher_actionPerformed
	 */
	public void actionDelVoucher_actionPerformed(ActionEvent e) throws Exception {
		super.actionDelVoucher_actionPerformed(e);
	}

	/**
	 * output actionWorkFlowG_actionPerformed
	 */
	public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception {
		super.actionWorkFlowG_actionPerformed(e);
	}

	/**
	 * output actionCreateTo_actionPerformed
	 */
	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
		super.actionCreateTo_actionPerformed(e);
	}

	/**
	 * output actionSendingMessage_actionPerformed
	 */
	public void actionSendingMessage_actionPerformed(ActionEvent e) throws Exception {
		super.actionSendingMessage_actionPerformed(e);
	}

	/**
	 * output actionSignature_actionPerformed
	 */
	public void actionSignature_actionPerformed(ActionEvent e) throws Exception {
		super.actionSignature_actionPerformed(e);
	}

	/**
	 * output actionWorkflowList_actionPerformed
	 */
	public void actionWorkflowList_actionPerformed(ActionEvent e) throws Exception {
		super.actionWorkflowList_actionPerformed(e);
	}

	/**
	 * output actionViewSignature_actionPerformed
	 */
	public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception {
		super.actionViewSignature_actionPerformed(e);
	}

	/**
	 * output actionSendMail_actionPerformed
	 */
	public void actionSendMail_actionPerformed(ActionEvent e) throws Exception {
		super.actionSendMail_actionPerformed(e);
	}

	/**
	 * output actionLocate_actionPerformed
	 */
	public void actionLocate_actionPerformed(ActionEvent e) throws Exception {
		super.actionLocate_actionPerformed(e);
	}

	/**
	 * output actionNumberSign_actionPerformed
	 */
	public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception {
		super.actionNumberSign_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception {
		return com.kingdee.eas.zjlw.social.SecuSplitFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table) {

		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData() {
		com.kingdee.eas.zjlw.social.SecuSplitInfo objectValue = new com.kingdee.eas.zjlw.social.SecuSplitInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

}