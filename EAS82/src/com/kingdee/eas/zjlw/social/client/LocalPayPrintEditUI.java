/**
 * output package name
 */
package com.kingdee.eas.zjlw.social.client;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.social.LocalPayPrintFactory;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class LocalPayPrintEditUI extends AbstractLocalPayPrintEditUI {
	private static final Logger logger = CoreUIObject.getLogger(LocalPayPrintEditUI.class);

	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		setButtonAndCont();
	}

	/**
	 * 设置按钮及字段属性
	 */
	private void setButtonAndCont() {
		this.contprojNameFr.setVisible(false);
		this.txtprojNameFr.setVisible(false);
		this.txtProjAddress.setVisible(false);
		this.txtprojSCNum.setVisible(false);
		this.contprojName.setEnabled(true);
		this.prmtprojName.setEnabled(true);
		this.contmonthYearr.setEnabled(true);
		this.prmtmonthYearr.setEnabled(true);
		this.btnInitBill.setEnabled(true);
		this.kdtEntrys.getHeadRow(0).getCell("fadd").setValue("原业务年月");
		this.kdtEntrys.getHeadRow(0).getCell("monthYear").setValue("家庭住址");
	}

	// 数据查询按钮
	public void actionInitBill_actionPerformed(ActionEvent e) throws Exception {
		super.actionInitBill_actionPerformed(e);
		updateQuery();
		actionSave_actionPerformed(e);

		// 获取条件字段
		String pSecuNumber = this.txtpSecuNumber.getText();
		String beginDateNumber = "";
		if (prmtmonthYearr.getValue() != null) {
			PeriodInfo beginDateInfo = PeriodFactory.getRemoteInstance().getPeriodInfo(new ObjectUuidPK(((PeriodInfo) prmtmonthYearr.getValue()).getId()));
			beginDateNumber = String.valueOf(beginDateInfo.getNumber());
		}
		String endDateNumber = "";
		if (prmtendDate.getValue() != null) {
			PeriodInfo endDateInfo = PeriodFactory.getRemoteInstance().getPeriodInfo(new ObjectUuidPK(((PeriodInfo) prmtendDate.getValue()).getId()));
			endDateNumber = String.valueOf(endDateInfo.getNumber());
		}
		String lastName = "";
		if (txtlastName.getText() != null) {
			lastName = txtlastName.getText();
		}
		String firstName = "";
		if (txtfirstName.getText() != null) {
			firstName = txtfirstName.getText();
		}
		Date birthday = null;
		if (pkbirthday.getValue() != null) {
			birthday = (Date) pkbirthday.getValue();
		}
		// ************************执行sql查询****************************
		// 删除原有数据
		String delEntrySql = "delete from CT_SOC_LocalPayPrintEntry";
		LocalPayPrintFactory.getRemoteInstance().initBill(delEntrySql.toString());
		// 插入新数据
		StringBuffer initEntrySql = new StringBuffer("INSERT INTO CT_SOC_LocalPayPrintEntry SELECT * FROM (SELECT entry.*,");
		initEntrySql.append("       pers.cfapproachtime as finDate,");
		initEntrySql.append("       pers.cfenddate as foutDate,");
		initEntrySql.append("       ProjSecuProf.fname_l2 as cfsecuproffr,");
		initEntrySql.append("       pers.cfbirthdate as cfbirthdate,");
		initEntrySql.append("       pers.cfbirthplacecn as cfcfbirthplacecn,");
		initEntrySql.append("       pers.cfaddress as cffadd,");
		initEntrySql.append("       PERIOD.fnumber as cfmonthYear");
		initEntrySql.append("  FROM CT_SOC_PayrollEntry entry");
		initEntrySql.append("  LEFT JOIN CT_SOC_Payroll bill ON entry.fparentid = bill.fid");
		initEntrySql.append("  LEFT JOIN T_BD_PERIOD PERIOD ON bill.CFMONTHYEARRID = PERIOD.FID");
		initEntrySql.append("  LEFT JOIN T_org_baseunit org on org.fid = bill.cfprojNameid");
		initEntrySql.append("  LEFT JOIN CT_SOC_InsurePersonEntry pers ON entry.cfpersonid = pers.cfpersonid and org.fname_l2 = pers.CFSECUPROJ");
		initEntrySql.append("  left join CT_BAS_ProjSecuProf ProjSecuProf on entry.cfsecuprofid = ProjSecuProf.Fid");
		initEntrySql.append("  WHERE bill.cfbillsate = '40' ");
		if (prmtprojName.getValue() != null) {
			AdminOrgUnitInfo proj = (AdminOrgUnitInfo) prmtprojName.getValue();
			initEntrySql.append("AND bill.cfprojNameid = '");
			initEntrySql.append(proj.getId());
			initEntrySql.append("' ");
		}
		if (prmtworkProj.getValue() != null) {
			AdminOrgUnitInfo workProj = (AdminOrgUnitInfo) prmtworkProj.getValue();
			initEntrySql.append("AND entry.cfworkprogramid =  '");
			initEntrySql.append(workProj.getId());
			initEntrySql.append("' ");
		}
		if (prmtcooperation.getValue() != null) {
			AdminOrgUnitInfo cooperation1 = (AdminOrgUnitInfo) prmtcooperation.getValue();
			initEntrySql.append("AND entry.cfcooperationid =  '");
			initEntrySql.append(cooperation1.getId());
			initEntrySql.append("' ");
		}
		if (!"".equals(pSecuNumber)) {
			initEntrySql.append("AND entry.cfsecurityNo = '");
			initEntrySql.append(pSecuNumber);
			initEntrySql.append("' ");
		}
		if (!"".equals(endDateNumber)) {
			initEntrySql.append("AND PERIOD.fnumber <='");
			initEntrySql.append(endDateNumber);
			initEntrySql.append("' ");
		}
		if (!"".equals(beginDateNumber)) {
			initEntrySql.append("AND PERIOD.fnumber >='");
			initEntrySql.append(beginDateNumber);
			initEntrySql.append("' ");
		}
		if (!"".equals(lastName)) {
			initEntrySql.append("AND entry.cflastName = '");
			initEntrySql.append(lastName);
			initEntrySql.append("' ");
		}
		if (!"".equals(firstName)) {
			initEntrySql.append("AND entry.cffirstName = '");
			initEntrySql.append(firstName);
			initEntrySql.append("' ");
		}
		if (birthday != null) {
			initEntrySql.append("AND to_char(pers.cfbirthdate,'yyyy-MM-dd') = '");
			initEntrySql.append(new SimpleDateFormat("yyyy-MM-dd").format(birthday));
			initEntrySql.append("' ");
		}
		initEntrySql.append(" order by entry.cfenterDate,entry.cflastname,entry.cffirstname,PERIOD.fnumber)");
		LocalPayPrintFactory.getRemoteInstance().initBill(initEntrySql.toString());
		// 更新分录parentid，绑定分录至本张单据
		String updateSql = "update CT_SOC_LocalPayPrintEntry set fparentid = '" + this.getEditData().getId().toString() + "'";
		LocalPayPrintFactory.getRemoteInstance().initBill(updateSql.toString());
		syncDataFromDB();// 重新加载分录信息
		handleOldData();
		// 更新表头数据
		updateBillDate();
		actionSave_actionPerformed(e);
		this.kdtEntrys.getHeadRow(0).getCell("fadd").setValue("原业务年月");
		this.kdtEntrys.getHeadRow(0).getCell("monthYear").setValue("家庭住址");
	}


	/**
	 * 更新表头日期字段
	 */
	private void updateBillDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int rowCount = this.kdtEntrys.getRowCount();
		Date inDate = null;
		Date outDate = null;
		Date birthdate = null;
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("indate").getValue() != null)
				inDate = (Date) row.getCell("indate").getValue();
			if (row.getCell("outdate").getValue() != null)
				outDate = (Date) row.getCell("outdate").getValue();
			if (row.getCell("birthdate").getValue() != null)
				birthdate = (Date) row.getCell("birthdate").getValue();
		}
		if (birthdate != null) {
			String inDateStr = sdf.format(birthdate);
			String d1 = inDateStr.substring(8,9);
			String d2 = inDateStr.substring(9);
			String m1 = inDateStr.substring(5,6);
			String m2 = inDateStr.substring(6,7);
			String y1 = inDateStr.substring(2, 3);
			String y2 = inDateStr.substring(3,4);
			this.txtbD1.setText(d1);
			this.txtbD2.setText(d2);
			this.txtbM1.setText(m1);
			this.txtbM2.setText(m2);
			this.txtbyear1.setText(y1);
			this.txtbyear2.setText(y2);
		}
		if (outDate != null) {
			String inDateStr = sdf.format(outDate);
			String d1 = inDateStr.substring(8,9);
			String d2 = inDateStr.substring(9);
			String m1 = inDateStr.substring(5,6);
			String m2 = inDateStr.substring(6,7);
			String y1 = inDateStr.substring(2, 3);
			String y2 = inDateStr.substring(3,4);
			this.txtod1.setText(d1);
			this.txtod2.setText(d2);
			this.txtom1.setText(m1);
			this.txtom2.setText(m2);
			this.txtoy1.setText(y1);
			this.txtoy2.setText(y2);
		}
		if (inDate != null) {
			String inDateStr = sdf.format(inDate);
			String d1 = inDateStr.substring(8,9);
			String d2 = inDateStr.substring(9);
			String m1 = inDateStr.substring(5,6);
			String m2 = inDateStr.substring(6,7);
			String y1 = inDateStr.substring(2, 3);
			String y2 = inDateStr.substring(3,4);
			this.txtiday1.setText(d1);
			this.txtiday2.setText(d2);
			this.txtimon1.setText(m1);
			this.txtimon2.setText(m2);
			this.txtiy1.setText(y1);
			this.txtiy2.setText(y2);
		}
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
	
	/**
	 * 更新项目社保号，项目法文名称，项目所在省份，项目地址法文
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void updateQuery() throws EASBizException, BOSException {
		if (prmtprojName.getValue() != null) {
			AdminOrgUnitInfo proj = (AdminOrgUnitInfo) prmtprojName.getValue();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("proCom.id",proj.getId().toString()));
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("name");
			sic.add("number");
			sic.add("nameFR");
			sic.add("addressFR");
			sic.add("province");
			sic.add("insuranceAcc");
			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(filter);
			view.setSelector(sic);
			ProjectOrgCollection col = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view);
			if (col!=null&&col.size()!=0) {
				ProjectOrgInfo info = col.get(0);
				txtprojSCNum.setText(info.getInsuranceAcc());
				txtprojNameFr.setText(info.getNameFR());
				prmtprojPri.setValue(info.getProvince());
				txtProjAddress.setText(info.getAddressFR());
			}
		}
	}

	/**
	 * output class constructor
	 */
	public LocalPayPrintEditUI() throws Exception {
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
	 * output kdtEntrys_editStopped method
	 */
	protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception {
		super.kdtEntrys_editStopped(e);
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
		return com.kingdee.eas.zjlw.social.LocalPayPrintFactory.getRemoteInstance();
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
		com.kingdee.eas.zjlw.social.LocalPayPrintInfo objectValue = new com.kingdee.eas.zjlw.social.LocalPayPrintInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

}