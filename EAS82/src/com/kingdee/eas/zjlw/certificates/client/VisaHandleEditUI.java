/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.certificates.ASCancelInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageFactory;
import com.kingdee.eas.zjlw.certificates.LeaveManageInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleFactory;
import com.kingdee.eas.zjlw.certificates.VisaHandleInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.bos.ctrl.common.util.DateUtil;
import com.kingdee.bos.ctrl.data.engine.script.beanshell.function.datetime.MONTHS_BETWEEN;
import com.kingdee.bos.ctrl.data.process.function.Functions.MONTH;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class VisaHandleEditUI extends AbstractVisaHandleEditUI {
	private static final Logger logger = CoreUIObject.getLogger(VisaHandleEditUI.class);

	/**
	 * output class constructor
	 */
	public VisaHandleEditUI() throws Exception {
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

	public void onLoad() throws Exception {
		this.txtNumber.setEnabled(false);
		super.onLoad();
		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
		setButtonStatus();
		btnAddNew.setVisible(false);
		btnWorkFlowG.setVisible(false);
		btnAuditResult.setVisible(false);
		btnCopy.setVisible(false);
		btnCreateFrom.setVisible(false);
		btnCreateTo.setVisible(false);
		btnMultiapprove.setVisible(false);
		btnNextPerson.setVisible(false);
		btnFirst.setVisible(false);
		btnPre.setVisible(false);
		btnNext.setVisible(false);
		btnLast.setVisible(false);
		this.billSate.setEditable(false);
		setEntryLocked();// 设置表格列是否可编辑

	}

	// 勾选停办：设置表格列是否可编辑
	protected void setEntryLocked() {
		int rowCount = kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			// row.getCell("visaNum").getStyleAttributes().setHided(true);
			// 是否停办
			if (row.getCell("isCancel").getValue().equals(true)) {
				row.getCell("vgetTime").getStyleAttributes().setLocked(true);
				row.getCell("vSentTime").getStyleAttributes().setLocked(true);
				row.getCell("vcompTime").getStyleAttributes().setLocked(true);
				// row.getCell("visaNum").getStyleAttributes().setLocked(true);
				row.getCell("vsTime").getStyleAttributes().setLocked(true);
				row.getCell("veTime").getStyleAttributes().setLocked(true);
				row.getCell("cancelDate").getStyleAttributes().setLocked(false);
				row.getCell("stopRsn").getStyleAttributes().setLocked(false);
			}
			// 分录关于护照的字段皆可编辑 ywj 2017-11-14
			row.getCell("passpNo").getStyleAttributes().setLocked(false);// 护照号码
			row.getCell("passoTime").getStyleAttributes().setLocked(false);// 护照签发日期
			row.getCell("passpDate").getStyleAttributes().setLocked(false);// 护照失效日期
		}
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
		// 只有暂存状态可以保存
		if (this.editData != null && this.editData.getId() != null) {
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			VisaHandleInfo fiInfo = VisaHandleFactory.getRemoteInstance().getVisaHandleInfo(new ObjectUuidPK(this.editData.getId()), sic);
			if (fiInfo.getBillSate() != null && !BillStateEnum.DRAFT.equals(fiInfo.getBillSate())) {
				MsgBox.showInfo("当前单据状态为【" + fiInfo.getBillSate().getAlias() + "】不允许重复保存！");
				abort();
			}
		}
		super.actionSave_actionPerformed(e);
		setEntryLocked();// 设置表格列是否可编辑
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
		setEntryLocked();// 设置表格列是否可编辑
	}

	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		// 只有暂存或者已提交状态可以提交
		if (this.editData != null && this.editData.getId() != null) {
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			VisaHandleInfo fiInfo = VisaHandleFactory.getRemoteInstance().getVisaHandleInfo(new ObjectUuidPK(this.editData.getId()), sic);
			if (fiInfo.getBillSate() != null && !(BillStateEnum.DRAFT.equals(fiInfo.getBillSate()) || BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))) {
				MsgBox.showInfo("当前单据状态为【" + fiInfo.getBillSate().getAlias() + "】不允许重复提交！");
				abort();
			}
		}
		checkNull();
		super.doBeforeSubmit(e);
	}

	private void checkNull() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		int rowCount = this.kdtEntrys.getRowCount();
		if (rowCount == 0) {
			MsgBox.showInfo("未添加人员信息，不允许提交！");
			abort();
		}
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("isCancel").getValue().equals(false)) {
				if (row.getCell("vgetTime").getValue() == null) {
					MsgBox.showInfo("签证资料收到时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("vSentTime").getValue() == null) {
					MsgBox.showInfo("签证送签时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("vcompTime").getValue() == null) {
					MsgBox.showInfo("签证办理完毕时间为空，不允许提交！");
					abort();
				}
				// 2017-02-23 赵总修改
				// if (row.getCell("visaNum").getValue() ==
				// null||"".equals(row.getCell("visaNum").getValue())) {
				// MsgBox.showInfo("签证号码为空，不允许提交！");
				// abort();
				// }
				if (row.getCell("vsTime").getValue() == null) {
					MsgBox.showInfo("签证签发日期为空，不允许提交！");
					abort();
				}
				if (row.getCell("veTime").getValue() == null) {
					MsgBox.showInfo("签证到期日期为空，不允许提交！");
					abort();
				}
				Date vgetTime = (Date) row.getCell("vgetTime").getValue();
				vgetTime = sdf.parse(sdf.format(vgetTime));
				Date vSentTime = (Date) row.getCell("vSentTime").getValue();
				vSentTime = sdf.parse(sdf.format(vSentTime));
				Date vcompTime = (Date) row.getCell("vcompTime").getValue();
				vcompTime = sdf.parse(sdf.format(vcompTime));
				Date vsTime = (Date) row.getCell("vsTime").getValue();
				vsTime = sdf.parse(sdf.format(vsTime));
				Date veTime = (Date) row.getCell("veTime").getValue();
				veTime = sdf.parse(sdf.format(veTime));
				// 1.签证送签时间>=签证资料收到时间
				if (vSentTime.compareTo(vgetTime) < 0) {
					MsgBox.showInfo("签证送签时间必须大于等于签证资料收到时间，请重新填写！");
					abort();
				}
				// 签证送签时间>=返签批件上传时间
				Date anSgetDate = (Date) row.getCell("anSgetDate").getValue();
				anSgetDate = sdf.parse(sdf.format(anSgetDate));
				if (vSentTime.compareTo(anSgetDate) < 0) {
					MsgBox.showInfo("签证送签时间必须大于等于返签批件上传时间，请重新填写！");
					abort();
				}
				// 2.签证办理完毕时间>=签证送签时间
				if (vcompTime.compareTo(vSentTime) < 0) {
					MsgBox.showInfo("签证办理完毕时间必须大于等于签证送签时间，请重新填写！");
					abort();
				}
				// 3.签证到期日期>签证签发日期
				if (veTime.compareTo(vsTime) <= 0) {
					MsgBox.showInfo("签证到期日期必须大于签证签发日期，请重新填写！");
					abort();
				}
				// 签证签发日期>签证资料收到日期
				if (vsTime.compareTo(vgetTime) < 0) {
					MsgBox.showInfo("签证签发日期必须大于等于签证资料收到日期，请重新填写！");
					abort();
				}

				// 护照有限期不足6个月，不允许提交 ywj 2017-11-14    2018-9-14修复bug
				if (row.getCell("passpDate").getValue() != null) {
					Date fromDate = (Date) row.getCell("passpDate").getValue();
					Date toDate = new Date();
					int result = (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 3600 * 24));
					if (Math.abs(result) <= 180) {
						MsgBox.showInfo("护照有效期已不足6个月，不允许提交！");
						abort();
					}
				} else {
					MsgBox.showInfo("护照到期日期为空，请重新填写！");
					abort();
				}
			} else {
				if (row.getCell("cancelDate").getValue() == null) {
					MsgBox.showInfo("勾选停办后，停办时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("stopRsn").getValue() == null) {
					MsgBox.showInfo("勾选停办后，停办理由为空，不允许提交！");
					abort();
				}
				Date anSgetDate = (Date) row.getCell("anSgetDate").getValue();
				anSgetDate = sdf.parse(sdf.format(anSgetDate));
				Date cancelDate = (Date) row.getCell("cancelDate").getValue();
				cancelDate = sdf.parse(sdf.format(cancelDate));
				if (cancelDate.compareTo(anSgetDate) < 0) {
					MsgBox.showInfo("停办时间必须大于等于返签批件上传时间，请重新填写！");
					abort();
				}
			}

		}

	}

	protected void kdtEntrys_editStopped(KDTEditEvent e) throws Exception {
		Object oldValue = e.getOldValue();
		Object newValue = e.getValue();

		if (EcClientHelper.isEqual(oldValue, newValue)) {
			return;
		}
		KDTable tblDetail = (KDTable) e.getSource();
		int colIndex = e.getColIndex();
		int rowIndex = e.getRowIndex();
		tblDetail.putUserProperty("INIT_USERPROPERTIES", Boolean.TRUE);
		Map scaleMap = (Map) tblDetail.getUserProperty("TABLE_SCALE_MAP");
		if (null != scaleMap) {
			Set columnNameSet = scaleMap.keySet();
			String key = tblDetail.getColumnKey(colIndex);
			if ((columnNameSet.contains(key)) && (((oldValue == newValue || 0 == EcClientHelper.compareValue(oldValue, newValue))))) {
				return;
			}
		}
		afterEditStopped(tblDetail, oldValue, newValue, colIndex, rowIndex);
	}

	protected void afterEditStopped(KDTable table, Object oldValue, Object newValue, int colIndex, int rowIndex) throws Exception {
		String key = table.getColumn(colIndex).getKey();
		IRow row = table.getRow(rowIndex);
		Date date = new Date();
		// 递交资料日期
		// if ("vSentTime".equals(key)){
		// Date papSTime=(Date) row.getCell("vSentTime").getValue();
		// if(papSTime!=null){
		// long time=(papSTime.getTime()-date.getTime())/86400000;
		// if(time<0){
		// MsgBox.showInfo("签证送签时间不可早于当前时间，请重新填写！");
		// row.getCell("vSentTime").setValue(null);
		// }
		// }
		// }
		// //劳动证出证日期
		// if ("vcompTime".equals(key)){
		// Date wPmtGTime=(Date) row.getCell("vcompTime").getValue();
		// if(wPmtGTime!=null){
		// long time=(wPmtGTime.getTime()-date.getTime())/86400000;
		// if(time<0){
		// MsgBox.showInfo("签证办理完毕时间不可早于当前时间，请重新填写！");
		// row.getCell("vcompTime").setValue(null);
		// }
		// if (row.getCell("isCancel").getValue().equals(true)) {
		// MsgBox.showInfo("签证办理完成人员不允许停办！");
		// abort();
		// }
		// }
		// }
		// 签证签发日期
		if ("vsTime".equals(key)) {
			if (row.getCell("vsTime").getValue() != null) {
				// 签证到期日期 = 签证签发日期+89天
				Date vsTime = (Date) row.getCell("vsTime").getValue();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(vsTime);
				// calendar.add(Calendar.DATE, 89);
				calendar.add(Calendar.DATE, 90);
				row.getCell("veTime").setValue(calendar.getTime());

			}
		}
		// 是否停办
		if ("isCancel".equals(key)) {
			if (row.getCell("isCancel").getValue().equals(true)) {
				row.getCell("vgetTime").getStyleAttributes().setLocked(true);
				row.getCell("vSentTime").getStyleAttributes().setLocked(true);
				row.getCell("vcompTime").getStyleAttributes().setLocked(true);
				// row.getCell("visaNum").getStyleAttributes().setLocked(true);
				row.getCell("vsTime").getStyleAttributes().setLocked(true);
				row.getCell("veTime").getStyleAttributes().setLocked(true);
				row.getCell("vgetTime").setValue(null);
				row.getCell("vSentTime").setValue(null);
				row.getCell("vcompTime").setValue(null);
				// row.getCell("visaNum").setValue(null);
				row.getCell("vsTime").setValue(null);
				row.getCell("veTime").setValue(null);
				row.getCell("cancelDate").getStyleAttributes().setLocked(false);
				row.getCell("stopRsn").getStyleAttributes().setLocked(false);
			} else {
				row.getCell("vgetTime").getStyleAttributes().setLocked(false);
				row.getCell("vSentTime").getStyleAttributes().setLocked(false);
				row.getCell("vcompTime").getStyleAttributes().setLocked(false);
				// row.getCell("visaNum").getStyleAttributes().setLocked(false);
				row.getCell("vsTime").getStyleAttributes().setLocked(false);
				row.getCell("veTime").getStyleAttributes().setLocked(false);
				row.getCell("cancelDate").setValue(null);
				row.getCell("stopRsn").setValue(null);
				row.getCell("cancelDate").getStyleAttributes().setLocked(true);
				row.getCell("stopRsn").getStyleAttributes().setLocked(true);
			}
		}
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
		return com.kingdee.eas.zjlw.certificates.VisaHandleFactory.getRemoteInstance();
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
		com.kingdee.eas.zjlw.certificates.VisaHandleInfo objectValue = new com.kingdee.eas.zjlw.certificates.VisaHandleInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		return objectValue;
	}

	protected void setButtonStatus() {
		VisaHandleInfo bill;
		if ("VIEW".equals(getOprtState())) {
			this.actionAudit.setVisible(false);
			this.actionUnAudit.setVisible(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);

			bill = (VisaHandleInfo) this.editData;
			if (this.editData != null) {
				if ((BillStateEnum.CHECKED.equals(bill.getBillSate())) || (BillStateEnum.DSTRY.equals(bill.getBillSate()))) {//
					// this.actionUnAudit.setVisible(true);
					// this.actionUnAudit.setEnabled(true);
					// this.actionAudit.setVisible(false);
					// this.actionAudit.setEnabled(false);
					this.actionEdit.setEnabled(false);
					this.actionRemove.setEnabled(false);
				} else {
					// this.actionUnAudit.setVisible(false);
					// this.actionUnAudit.setEnabled(false);
					// this.actionAudit.setVisible(true);
					// this.actionAudit.setEnabled(true);
					this.actionRemove.setEnabled(true);
					this.actionEdit.setEnabled(true);
				}
			}

			this.actionAddLine.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionInsertLine.setEnabled(false);
		} else {
			bill = (VisaHandleInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null) && (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(false);
			}

			this.actionAudit.setVisible(false);
			this.actionUnAudit.setVisible(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
		}
		if (((this.editData != null) && (BillStateEnum.CHECKED.equals(bill.getBillSate()))) || ("ADDNEW".equalsIgnoreCase(getOprtState()))) {
			this.actionPrint.setEnabled(false);
			this.actionPrintPreview.setEnabled(false);
			this.actionAttachment.setEnabled(false);
		} else {
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(true);
		}

		if (this.editData != null) {
			bill = (VisaHandleInfo) this.editData;
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
}