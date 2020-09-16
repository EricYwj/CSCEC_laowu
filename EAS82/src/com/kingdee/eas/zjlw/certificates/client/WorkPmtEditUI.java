/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoInfo;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryFactory;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtECEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtECEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtECFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtECInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.DOCTYPE;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class WorkPmtEditUI extends AbstractWorkPmtEditUI {
	private static final Logger logger = CoreUIObject.getLogger(WorkPmtEditUI.class);

	/**
	 * output class constructor
	 */
	public WorkPmtEditUI() throws Exception {
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

	// 表格编辑事件
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
		// //递交资料日期
		// if ("papSTime".equals(key)){
		// Date papSTime=(Date) row.getCell("papSTime").getValue();
		// if(papSTime!=null){
		// long time=(papSTime.getTime()-date.getTime())/86400000;
		// if(time<0){
		// MsgBox.showInfo("递交资料日期不能小于当前时间，请重新选择！");
		// row.getCell("papSTime").setValue(null);
		// }
		// }
		// }
		// //劳动证出证日期
		// if ("wPmtGTime".equals(key)){
		// Date wPmtGTime=(Date) row.getCell("wPmtGTime").getValue();
		// if(wPmtGTime!=null){
		// long time1=(wPmtGTime.getTime()-date.getTime())/86400000;
		// if(time1<0){
		// MsgBox.showInfo("劳动证出证日期不能小于当前时间，请重新选择！");
		// row.getCell("wPmtGTime").setValue(null);
		// }
		// }
		// }
		// //劳动证到期日期
		// if ("wPmtSTime".equals(key)){
		// Date wPmtSTime=(Date) row.getCell("wPmtSTime").getValue();//劳动证到期日期
		// if(wPmtSTime!=null){
		// long time2=(wPmtSTime.getTime()-date.getTime())/86400000;
		// if(time2<0){
		// MsgBox.showInfo("劳动证到期日期不能小于当前时间，请重新选择！");
		// row.getCell("wPmtSTime").setValue(null);
		// }
		// }
		// }
		// 是否未交资料离境
		// 如果勾选：
		// 1.劳动证递交资料时间为零 papSTime
		// 2.劳动证类型为零 pType
		// 3.劳动证号为零 wPmtNum
		// 4.劳动证生效日期为零 laboreffDate
		if ("departure".equals(key)) {
			Boolean departure = (Boolean) row.getCell("departure").getValue();
			if (departure) {
				row.getCell("isStop").getStyleAttributes().setLocked(true);
				row.getCell("papSTime").getStyleAttributes().setLocked(true);
				row.getCell("pType").getStyleAttributes().setLocked(true);
				row.getCell("wPmtNum").getStyleAttributes().setLocked(true);
				row.getCell("wPmtGTime").getStyleAttributes().setLocked(true);
				row.getCell("laboreffDate").getStyleAttributes().setLocked(true);
				row.getCell("wPmtSTime").getStyleAttributes().setLocked(true);
				row.getCell("sPAfPerson").getStyleAttributes().setLocked(true);
				row.getCell("papSTime").setValue(null);
				row.getCell("pType").setValue(DOCTYPE.EMPTY);
				row.getCell("wPmtNum").setValue(null);
				row.getCell("wPmtGTime").setValue(null);
				row.getCell("laboreffDate").setValue(null);
				row.getCell("wPmtSTime").setValue(null);
				row.getCell("sPAfPerson").setValue(false);
			} else {
				row.getCell("isStop").getStyleAttributes().setLocked(false);
				row.getCell("papSTime").getStyleAttributes().setLocked(false);
				row.getCell("pType").getStyleAttributes().setLocked(false);
				row.getCell("wPmtNum").getStyleAttributes().setLocked(false);
				row.getCell("wPmtGTime").getStyleAttributes().setLocked(false);
				row.getCell("laboreffDate").getStyleAttributes().setLocked(false);
				row.getCell("wPmtSTime").getStyleAttributes().setLocked(false);
				row.getCell("sPAfPerson").getStyleAttributes().setLocked(false);
			}
		}
		// 是否停办
		// 如果勾选：
		// 1.劳动证资料递交时间不为零 papSTime
		// 2.劳动证类型为零 pType
		// 3.劳动证号为零 wPmtNum
		// 4.劳动证出证日期为零 wPmtGTime
		// 5.劳动证生效日期为零 laboreffDate
		// 6.劳动证到期日期为零 wPmtSTime
		if ("isStop".equals(key)) {
			Boolean isStop = (Boolean) row.getCell("isStop").getValue();
			if (isStop) {
				row.getCell("departure").getStyleAttributes().setLocked(true);
				row.getCell("pType").getStyleAttributes().setLocked(true);
				row.getCell("wPmtNum").getStyleAttributes().setLocked(true);
				row.getCell("wPmtGTime").getStyleAttributes().setLocked(true);
				row.getCell("laboreffDate").getStyleAttributes().setLocked(true);
				row.getCell("wPmtSTime").getStyleAttributes().setLocked(true);
				row.getCell("pType").setValue(DOCTYPE.EMPTY);
				row.getCell("wPmtNum").setValue(null);
				row.getCell("wPmtGTime").setValue(null);
				row.getCell("laboreffDate").setValue(null);
				row.getCell("wPmtSTime").setValue(null);
				row.getCell("endTime").getStyleAttributes().setLocked(false);
				row.getCell("cancelReson").getStyleAttributes().setLocked(false);
			} else {
				row.getCell("departure").getStyleAttributes().setLocked(false);
				row.getCell("pType").getStyleAttributes().setLocked(false);
				row.getCell("wPmtNum").getStyleAttributes().setLocked(false);
				row.getCell("wPmtGTime").getStyleAttributes().setLocked(false);
				row.getCell("laboreffDate").getStyleAttributes().setLocked(false);
				row.getCell("wPmtSTime").getStyleAttributes().setLocked(false);
				row.getCell("endTime").getStyleAttributes().setLocked(true);
				row.getCell("cancelReson").getStyleAttributes().setLocked(true);
				row.getCell("endTime").setValue(null);
				row.getCell("cancelReson").setValue(null);
			}
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

	public void onLoad() throws Exception {
		this.pkauditDate.setEnabled(false);
		super.onLoad();
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
		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
		this.billSate.setEditable(false);
		if (getUIContext().get("BOTPViewStatus") != null) {
			// this.pkBizDate.setValue(new Date());
		}
		if (getOprtState().equals("EDIT")) {
			int rowCount = this.kdtEntrys.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				IRow row = this.kdtEntrys.getRow(i);
				// 查询双认证完成时间
				if (row.getCell("personID").getValue() != null) {
					FilterInfo filter = new FilterInfo();
					filter.getFilterItems().add(new FilterItemInfo("personID", row.getCell("personID").getValue()));
					filter.getFilterItems().add(new FilterItemInfo("parent.billSate", BillStateEnum.CHECKED));
					EntityViewInfo view = new EntityViewInfo();
					view.setFilter(filter);
					SelectorItemCollection sic = new SelectorItemCollection();
					sic.add("qualDate");
					view.setSelector(sic);
					DoubQualifyEntryCollection doubCol = DoubQualifyEntryFactory.getRemoteInstance().getDoubQualifyEntryCollection(view);
					for (int j = 0; j < doubCol.size(); j++) {
						DoubQualifyEntryInfo doubEntryInfo = doubCol.get(j);
						row.getCell("qualDate").setValue(doubEntryInfo.getQualDate());
					}
				}
			}
		}
		setEntryLocked();
	}

	protected void setEntryLocked() {
		// 设置表格列是否可编辑
		int rowCount = kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			// 是否停办
			if (row.getCell("isStop").getValue().equals(true)) {
				row.getCell("departure").getStyleAttributes().setLocked(true);
				row.getCell("pType").getStyleAttributes().setLocked(true);
				row.getCell("wPmtNum").getStyleAttributes().setLocked(true);
				row.getCell("wPmtGTime").getStyleAttributes().setLocked(true);
				row.getCell("laboreffDate").getStyleAttributes().setLocked(true);
				row.getCell("wPmtSTime").getStyleAttributes().setLocked(true);
				row.getCell("endTime").getStyleAttributes().setLocked(false);
				row.getCell("cancelReson").getStyleAttributes().setLocked(false);
			}
			// departure 是否离境
			if (row.getCell("departure").getValue().equals(true)) {
				row.getCell("isStop").getStyleAttributes().setLocked(true);
				row.getCell("papSTime").getStyleAttributes().setLocked(true);
				row.getCell("pType").getStyleAttributes().setLocked(true);
				row.getCell("wPmtNum").getStyleAttributes().setLocked(true);
				row.getCell("wPmtGTime").getStyleAttributes().setLocked(true);
				row.getCell("laboreffDate").getStyleAttributes().setLocked(true);
				row.getCell("wPmtSTime").getStyleAttributes().setLocked(true);
				row.getCell("sPAfPerson").getStyleAttributes().setLocked(true);
			}
			// 2018-11-5 ywj 合作单位允许编辑
			row.getCell("cooperation").getStyleAttributes().setLocked(false);
		}
	}

	protected void setButtonStatus() {
		WorkPmtInfo bill;
		if ("VIEW".equals(getOprtState())) {
			// this.actionAudit.setVisible(true);
			// this.actionUnAudit.setVisible(true);
			// this.actionAudit.setEnabled(true);
			// this.actionUnAudit.setEnabled(true);

			bill = (WorkPmtInfo) this.editData;
			if (this.editData != null) {
				if (BillStateEnum.CHECKED.equals(bill.getBillSate()) || BillStateEnum.DSTRY.equals(bill.getBillSate())) {// (
					// BillStateEnum
					// .
					// SIGNE
					// .
					// equals
					// (
					// bill
					// .
					// getBillSate
					// (
					// )
					// )
					// )
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
			bill = (WorkPmtInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null) && (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(false);
			}

			// this.actionAudit.setVisible(false);
			// this.actionUnAudit.setVisible(false);
			// this.actionAudit.setEnabled(false);
			// this.actionUnAudit.setEnabled(false);
		}
		if (((this.editData != null) && (BillStateEnum.CHECKED.equals(bill.getBillSate()) || BillStateEnum.DSTRY.equals(bill.getBillSate()))) || ("ADDNEW".equalsIgnoreCase(getOprtState()))) {
			this.actionPrint.setEnabled(false);
			this.actionPrintPreview.setEnabled(false);
			this.actionAttachment.setEnabled(false);
		} else {
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(true);
		}

		if (this.editData != null) {
			bill = (WorkPmtInfo) this.editData;
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
			WorkPmtInfo fiInfo = WorkPmtFactory.getRemoteInstance().getWorkPmtInfo(new ObjectUuidPK(this.editData.getId()), sic);
			if (fiInfo.getBillSate() != null && !BillStateEnum.DRAFT.equals(fiInfo.getBillSate())) {
				MsgBox.showInfo("当前单据状态为【" + fiInfo.getBillSate().getAlias() + "】不允许重复保存！");
				abort();
			}
		}
		super.actionSave_actionPerformed(e);
		setEntryLocked();

	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
		setEntryLocked();
	}

	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		// 只有暂存或者已提交状态可以提交
		if (this.editData != null && this.editData.getId() != null) {
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			WorkPmtInfo fiInfo = WorkPmtFactory.getRemoteInstance().getWorkPmtInfo(new ObjectUuidPK(this.editData.getId()), sic);
			if (fiInfo.getBillSate() != null && !(BillStateEnum.DRAFT.equals(fiInfo.getBillSate()) || BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))) {
				MsgBox.showInfo("当前单据状态为【" + fiInfo.getBillSate().getAlias() + "】不允许重复提交！");
				abort();
			}
		}
		checkDstry();

		super.doBeforeSubmit(e);
		// checkDate();
	}

	protected void checkDstry() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int rowCount = kdtEntrys.getRowCount();
		Date date = new Date();
		int sPAfPersonCount = 0;
		int departureCount = 0;
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			Boolean departure = (Boolean) row.getCell("departure").getValue();
			Boolean isStop = (Boolean) row.getCell("isStop").getValue();
			Boolean sPAfPerson = (Boolean) row.getCell("sPAfPerson").getValue();
			if (!departure && !isStop) {
				if (row.getCell("immiTime").getValue() == null) {
					MsgBox.showInfo("姓名【" + row.getCell("immiTime").getValue() + "】的入阿时间为空，无法提交，请重新填入！");
					this.abort();
				}
				if (row.getCell("papSTime").getValue() == null) {
					MsgBox.showInfo("姓名【" + row.getCell("papSTime").getValue() + "】的劳动证资料递交时间为空，无法提交，请重新填入！");
					this.abort();
				}
				if (row.getCell("pType").getValue() == null) {
					MsgBox.showInfo("姓名【" + row.getCell("pType").getValue() + "】的劳动证类型为空，无法提交，请重新填入！");
					this.abort();
				}
				if (row.getCell("wPmtNum").getValue() == null) {
					MsgBox.showInfo("姓名【" + row.getCell("wPmtNum").getValue() + "】的劳动证号为空，无法提交，请重新填入！");
					this.abort();
				}
				if (row.getCell("wPmtGTime").getValue() == null) {
					MsgBox.showInfo("姓名【" + row.getCell("wPmtGTime").getValue() + "】的劳动证出证日期为空，无法提交，请重新填入！");
					this.abort();
				}
				if (row.getCell("laboreffDate").getValue() == null) {
					MsgBox.showInfo("姓名【" + row.getCell("laboreffDate").getValue() + "】的劳动证生效日期为空，无法提交，请重新填入！");
					this.abort();
				}
				if (row.getCell("wPmtSTime").getValue() == null) {
					MsgBox.showInfo("姓名【" + row.getCell("wPmtSTime").getValue() + "】的劳动证到期日期为空，无法提交，请重新填入！");
					this.abort();
				}
				if (sPAfPerson) {
					sPAfPersonCount++;
				}
				if (row.getCell("papSTime").getValue() != null && row.getCell("immiTime").getValue() != null) {
					Date papSTime = (Date) row.getCell("papSTime").getValue();
					Date immiTime = (Date) row.getCell("immiTime").getValue();
					if (papSTime.compareTo(immiTime) < 0) {
						MsgBox.showInfo("所选行劳动证资料递交时间小于入阿时间，无法提交，请重新填入日期！");
						this.abort();
					}
				}
				// 劳动证出证日期>=劳动证资料递交时间
				if (row.getCell("wPmtGTime").getValue() != null && row.getCell("papSTime").getValue() != null) {
					Date wPmtGTime = (Date) row.getCell("wPmtGTime").getValue();
					Date papSTime = (Date) row.getCell("papSTime").getValue();
					if (wPmtGTime.before(papSTime)) {
						MsgBox.showInfo("所选行劳动证出证日期小于劳动证资料递交时间，无法提交，请重新填入日期！");
						this.abort();
					}
				}
				// 劳动证生效日期>入阿时间
				if (row.getCell("laboreffDate").getValue() != null && row.getCell("immiTime").getValue() != null) {
					Date laboreffDate = (Date) row.getCell("laboreffDate").getValue();
					Date immiTime = (Date) row.getCell("immiTime").getValue();
					// long
					// time=(laboreffDate.getTime()-immiTime.getTime())/86400000
					// ;
					if (laboreffDate.compareTo(immiTime) < 0) {
						MsgBox.showInfo("所选行劳动证生效日期小于入阿时间，无法提交，请重新填入日期！");
						this.abort();
					}
				}
				// 劳动证到期日期>劳动证生效时间
				if (row.getCell("wPmtSTime").getValue() != null && row.getCell("laboreffDate").getValue() != null) {
					Date wPmtSTime = (Date) row.getCell("wPmtSTime").getValue();
					Date laboreffDate = (Date) row.getCell("laboreffDate").getValue();
					// long
					// time=(wPmtSTime.getTime()-laboreffDate.getTime())/86400000
					// ;
					if (wPmtSTime.compareTo(laboreffDate) <= 0) {
						MsgBox.showInfo("所选行劳动证到期日期小于等于劳动证生效时间，无法提交，请重新填入日期！");
						this.abort();
					}
				}
				// 劳动证到期日期>劳动证出证时间
				if (row.getCell("wPmtSTime").getValue() != null && row.getCell("wPmtGTime").getValue() != null) {
					Date wPmtSTime = (Date) row.getCell("wPmtSTime").getValue();
					Date wPmtGTime = (Date) row.getCell("wPmtGTime").getValue();
					// long
					// time=(wPmtSTime.getTime()-wPmtGTime.getTime())/86400000;
					if (wPmtSTime.compareTo(wPmtGTime) <= 0) {
						MsgBox.showInfo("所选行劳动证到期日期小于等于劳动证出证时间 ，无法提交，请重新填入日期！");
						this.abort();
					}
				}
			}

			if (departure && isStop) {
				MsgBox.showInfo("是否离境与是否停办不能同时勾选，请重新填入！");
				this.abort();
			}
			if (isStop) {
				if (row.getCell("immiTime").getValue() == null) {
					MsgBox.showInfo("姓名【" + row.getCell("name").getValue() + "】的入阿时间为空，无法提交，请重新填入！");
					this.abort();
				}
				if (row.getCell("papSTime").getValue() == null) {
					MsgBox.showInfo("勾选停办，劳动证资料递交时间不能为空！");
					this.abort();
				}
				if (row.getCell("endTime").getValue() == null) {
					MsgBox.showInfo("勾选是否停办，请填入停办注销时间！");
					this.abort();
				}
				if (row.getCell("cancelReson").getValue() == null) {
					MsgBox.showInfo("勾选是否停办，请填入停办理由！");
					this.abort();
				}
				// 停办注销时间>劳动证资料递交时间
				Date papSTime = (Date) row.getCell("papSTime").getValue();
				papSTime = sdf.parse(sdf.format(papSTime));
				Date endTime = (Date) row.getCell("endTime").getValue();
				endTime = sdf.parse(sdf.format(endTime));
				if (endTime.compareTo(papSTime) <= 0) {
					MsgBox.showInfo("停办注销时间小于等于劳动证资料递交时间，无法提交，请重新填入日期！");
					this.abort();
				}
				if (sPAfPerson) {
					MsgBox.showInfo("姓名【" + row.getCell("name").getValue() + "】已停办，不应勾选劳动证申请签收件挂靠人！");
					this.abort();
				}
				departureCount++;
			}
			if (departure) {
				if (row.getCell("immiTime").getValue() == null) {
					MsgBox.showInfo("姓名【" + row.getCell("name").getValue() + "】的入阿时间为空，无法提交，请重新填入！");
					this.abort();
				}
				if (sPAfPerson) {
					MsgBox.showInfo("姓名【" + row.getCell("name").getValue() + "】已离境，不应勾选劳动证申请签收件挂靠人！");
					this.abort();
				}
				departureCount++;
			}
		}
		// 若全停办或全离境，不应该有人勾选，否则，应只有一个人勾选
		if (rowCount != departureCount) {
			if (sPAfPersonCount != 1) {
				MsgBox.showInfo("劳动证申请签收件挂靠人必须且仅可勾选一人！");
				this.abort();
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
		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			// 查询双认证完成时间
			if (row.getCell("personID").getValue() != null) {
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("personID", row.getCell("personID").getValue()));
				filter.getFilterItems().add(new FilterItemInfo("parent.billSate", BillStateEnum.CHECKED));
				EntityViewInfo view = new EntityViewInfo();
				view.setFilter(filter);
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("qualDate");
				view.setSelector(sic);
				DoubQualifyEntryCollection doubCol = DoubQualifyEntryFactory.getRemoteInstance().getDoubQualifyEntryCollection(view);
				for (int j = 0; j < doubCol.size(); j++) {
					DoubQualifyEntryInfo doubEntryInfo = doubCol.get(j);
					row.getCell("qualDate").setValue(doubEntryInfo.getQualDate());
				}
			}
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
		return com.kingdee.eas.zjlw.certificates.WorkPmtFactory.getRemoteInstance();
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
		com.kingdee.eas.zjlw.certificates.WorkPmtInfo objectValue = new com.kingdee.eas.zjlw.certificates.WorkPmtInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		return objectValue;
	}

}