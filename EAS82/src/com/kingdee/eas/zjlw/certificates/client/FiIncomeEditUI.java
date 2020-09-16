/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.BlackListCollection;
import com.kingdee.eas.zjlw.baseinfo.BlackListFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeEntryCollection;
import com.kingdee.eas.zjlw.certificates.FiIncomeEntryInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;

/**
 * output class name
 */
public class FiIncomeEditUI extends AbstractFiIncomeEditUI {
	private static final Logger logger = CoreUIObject.getLogger(FiIncomeEditUI.class);

	/**
	 * 表格编辑事件
	 */
	protected void kdtEntrys_editStopped(KDTEditEvent e) throws Exception {
		Object oldValue = e.getOldValue();
		Object newValue = e.getValue();

		if (isEqual(oldValue, newValue)) {
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
			if ((columnNameSet.contains(key)) && (((oldValue == newValue) || (0 == toBigDecimal(oldValue).compareTo(toBigDecimal(newValue)))))) {
				return;
			}
		}
		afterEditStopped(tblDetail, oldValue, newValue, colIndex, rowIndex);
	}

	protected void afterEditStopped(KDTable table, Object oldValue, Object newValue, int colIndex, int rowIndex) throws Exception {
		String key = table.getColumn(colIndex).getKey();
		IRow row = table.getRow(rowIndex);
		// 指标项目
		if ("pmtProj".equals(key)) {
			AdminOrgUnitInfo orgInfo = (AdminOrgUnitInfo) row.getCell("pmtProj").getValue();
			Date now = new Date();
			if (orgInfo != null) {
				FilterInfo filter = new FilterInfo();
				EntityViewInfo view = new EntityViewInfo();
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("permitEndDate");
				view.setFilter(filter);
				view.setSelector(sic);
				filter.getFilterItems().add(new FilterItemInfo("proCom", orgInfo));
				view.setFilter(filter);
				ProjectOrgCollection poCol = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view);
				ProjectOrgInfo poInfo = poCol.get(0);
				Date permitEndDate = poInfo.getPermitEndDate();
				if (permitEndDate != null && permitEndDate.before(now)) {
					MsgBox.showInfo("该人员所属项目已停止证件办理！");
				}
			}

		}
	}

	public static boolean isEqual(Object objA, Object objB) {
		if (objA == objB) {
			return true;
		}

		if ((objA instanceof String) && (objB == null))
			objB = "";
		else if ((objB instanceof String) && (objA == null))
			objA = "";
		else if (((objA == null) && (objB != null)) || ((objA != null) && (objB == null))) {
			return false;
		}

		if ((objA instanceof CoreBaseInfo) && (objB instanceof CoreBaseInfo)) {
			CoreBaseInfo obj1 = (CoreBaseInfo) objA;
			CoreBaseInfo obj2 = (CoreBaseInfo) objB;
			return obj1.getId().equals(obj2.getId());
		}
		if ((objA instanceof BigDecimal) && (objB instanceof BigDecimal)) {
			BigDecimal big1 = (BigDecimal) objA;
			BigDecimal big2 = (BigDecimal) objB;
			return (big1.compareTo(big2) == 0);
		}
		return objA.equals(objB);
	}

	public static BigDecimal toBigDecimal(Object obj) {
		BigDecimal bigDecimal = new BigDecimal(0.0);

		if (null != obj) {
			if (obj instanceof BigDecimal) {
				bigDecimal = (BigDecimal) obj;
			} else {
				NumberFormat numberFormat = NumberFormat.getInstance();

				String str = obj.toString().trim();
				Number number = null;
				try {
					number = numberFormat.parse(str);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				if (null != number)
					try {
						str = number.toString();
						bigDecimal = new BigDecimal(str);
					} catch (Exception e) {
					}
			}
		}
		return bigDecimal;
	}

	/**
	 * output class constructor
	 */
	public FiIncomeEditUI() throws Exception {
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

	// onload 方法
	public void onLoad() throws Exception {
		this.contbillSate.setEnabled(false);
		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
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
		btnAudit.setVisible(false);
		btnUnAudit.setVisible(false);
		// 判断以编辑方式打开界面查询时候报签次数
		if (getOprtState().equals("EDIT")) {
			getAntiTimes();
		}
		filterProf();// 过滤分录指标工种
		// 修改分录字段名称
		String strLanguage = com.kingdee.eas.common.client.SysContext.getSysContext().getLocale().getLanguage();
		if ("L2".equals(strLanguage) || "l2".equals(strLanguage)) {
			this.kdtEntrys.getHeadRow(0).getCell("wkPmtGet").setValue("是否同时办理工作经验证明");
		} else if ("L3".equals(strLanguage) || "l3".equals(strLanguage)) {
			this.kdtEntrys.getHeadRow(0).getCell("wkPmtGet").setValue("certification de AT et diplome");
		}
		// 工作经验允许编辑 ywj 2017-11-21
		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			row.getCell("workSuffer").getStyleAttributes().setLocked(false);
		}
	}

	// 分录指标工种根据指标项目过滤
	// private void filterProf(){
	// int rowCount = this.kdtEntrys.getRowCount();
	// for(int i=0;i<rowCount;i++){
	// IRow row = this.kdtEntrys.getRow(i);
	// if(row.getCell("pmtProj").getValue()!=null){
	// AdminOrgUnitInfo admin = (AdminOrgUnitInfo)
	// row.getCell("pmtProj").getValue();
	// KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
	// settNumPromptBox.setEditable(true);
	// settNumPromptBox.setDisplayFormat("$name$");
	// settNumPromptBox.setEditFormat("$number$");
	// settNumPromptBox.setCommitFormat("$number$");
	// settNumPromptBox.setQueryInfo("");
	// EntityViewInfo evi = new EntityViewInfo();
	// FilterInfo filterInfo = new FilterInfo();
	// filterInfo.getFilterItems().add(new
	// FilterItemInfo("accountTableID.id",""));
	// evi.setFilter(filterInfo);
	// settNumPromptBox.setEntityViewInfo(evi);
	// row.getCell("pmtProfC").setEditor(new
	// KDTDefaultCellEditor(settNumPromptBox));
	// }
	// }
	// }

	// 分录指标工种根据指标项目过滤 ywj 2017-11-13 原方法可能因为svn版本控制有问题，所以先改为旧版本
	private void filterProf() {
		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("pmtProj").getValue() != null) {
				AdminOrgUnitInfo admin = (AdminOrgUnitInfo) row.getCell("pmtProj").getValue();
				KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
				settNumPromptBox.setEditable(true);
				settNumPromptBox.setDisplayFormat("$name$");
				settNumPromptBox.setEditFormat("$number$");
				settNumPromptBox.setCommitFormat("$number$");
				settNumPromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjectWorkQuery");
				EntityViewInfo evi = new EntityViewInfo();
				FilterInfo filterInfo = new FilterInfo();
				filterInfo.getFilterItems().add(new FilterItemInfo("proCom.id", admin.getId().toString()));
				filterInfo.getFilterItems().add(new FilterItemInfo("leftAmount", 0, CompareType.GREATER));
				evi.setFilter(filterInfo);
				settNumPromptBox.setEntityViewInfo(evi);
				row.getCell("pmtProfC").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
			}
		}
	}

	/**
	 * 校验指标项目是否停止证件的办理
	 * 
	 * @throws EASBizException
	 * @throws BOSException
	 * @throws ParseException
	 */
	private void checkOrgEndTiem() throws EASBizException, BOSException, ParseException {
		int rowCount = this.kdtEntrys.getRowCount();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		now = sdf.parse(sdf.format(now));
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			AdminOrgUnitInfo pmtProj = (AdminOrgUnitInfo) row.getCell("pmtProj").getValue();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("proCom.id", pmtProj.getId().toString()));
			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(filter);
			ProjectOrgCollection poCol = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view);
			if (poCol != null && poCol.size() > 0) {
				for (int j = 0; j < poCol.size(); j++) {
					ProjectOrgInfo poInfo = poCol.get(j);
					if (poInfo.getPermitEndDate() != null) {
						Date permitEndDate = poInfo.getPermitEndDate();
						permitEndDate = sdf.parse(sdf.format(permitEndDate));
						if (permitEndDate.before(now)) {
							MsgBox.showInfo("人员【" + row.getCell("name").getValue() + "】指标项目已停止证件办理！");
							abort();
						}
					}
				}
			} else {
				MsgBox.showInfo("所选指标项目未维护基本信息，不允许提交！");
				abort();
			}
		}
	}

	/**
	 * 获取反签办理次数
	 * 
	 * @throws BOSException
	 */
	private void getAntiTimes() throws BOSException {
		AntiSignedEntryCollection antiCol = new AntiSignedEntryCollection();
		int count = kdtEntrys.getRowCount();
		String idNum = "";
		String passpNum = "";
		for (int i = 0; i < count; i++) {
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			IRow row = kdtEntrys.getRow(i);
			idNum = (String) row.getCell("IdNum").getValue();
			passpNum = (String) row.getCell("passportNo").getValue();
			filter.getFilterItems().add(new FilterItemInfo("idNum", idNum));
			filter.getFilterItems().add(new FilterItemInfo("passpNo", passpNum));
			// filter.setMaskString("#0 OR #1");
			view.setFilter(filter);
			antiCol = AntiSignedEntryFactory.getRemoteInstance().getAntiSignedEntryCollection(view);
			row.getCell("signNum").setValue(String.valueOf(antiCol.size() + 1));
		}
	}

	protected void setButtonStatus() {
		FiIncomeInfo bill;
		if ("VIEW".equals(getOprtState())) {
			// this.actionAudit.setVisible(true);
			// this.actionUnAudit.setVisible(true);
			// this.actionAudit.setEnabled(true);
			// this.actionUnAudit.setEnabled(true);

			bill = (FiIncomeInfo) this.editData;
			if (this.editData != null) {
				if ((BillStateEnum.CHECKED.equals(bill.getBillSate()))) {// || (
					// BillStateEnum
					// .
					// SIGNED
					// .
					// equals
					// (
					// bill
					// .
					// getBillSate
					// (
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
			bill = (FiIncomeInfo) this.editData;
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
			bill = (FiIncomeInfo) this.editData;
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
			FiIncomeInfo fiInfo = FiIncomeFactory.getRemoteInstance().getFiIncomeInfo(new ObjectUuidPK(this.editData.getId()), sic);
			if (fiInfo.getBillSate() != null && !BillStateEnum.DRAFT.equals(fiInfo.getBillSate())) {
				MsgBox.showInfo("当前单据状态为【" + fiInfo.getBillSate().getAlias() + "】不允许重复保存！");
				abort();
			}
		}
		super.actionSave_actionPerformed(e);
		filterProf();// 过滤分录指标工种
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
		filterProf();// 过滤分录指标工种
	}

	// 提交校验
	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		// 只有暂存或者已提交状态可以提交
		if (this.editData != null && this.editData.getId() != null) {
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			FiIncomeInfo fiInfo = FiIncomeFactory.getRemoteInstance().getFiIncomeInfo(new ObjectUuidPK(this.editData.getId()), sic);
			if (fiInfo.getBillSate() != null && !(BillStateEnum.DRAFT.equals(fiInfo.getBillSate()) || BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))) {
				MsgBox.showInfo("当前单据状态为【" + fiInfo.getBillSate().getAlias() + "】不允许重复提交！");
				abort();
			}
		}
		checkNull();
		checkOrgEndTiem();
		checkPmtProfC();
		CheckBlackList();
		super.doBeforeSubmit(e);

	}

	private void checkNull() {
		int rowCount = this.kdtEntrys.getRowCount();
		if (rowCount == 0) {
			MsgBox.showInfo("未添加人员信息，不允许提交！");
			abort();
		}
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("name").getValue() == null) {
				MsgBox.showInfo("姓名为空，不允许提交！");
				abort();
			}
			if (row.getCell("genDers").getValue() == null) {
				MsgBox.showInfo("性别为空，不允许提交！");
				abort();
			}
			if (row.getCell("country").getValue() == null) {
				MsgBox.showInfo("国籍为空，不允许提交！");
				abort();
			}
			CountryInfo coInfo = (CountryInfo) row.getCell("country").getValue();
			if ("C01".equals(coInfo.getNumber())) {
				if (row.getCell("IdNum").getValue() == null) {
					MsgBox.showInfo("中国籍员工身份证号为空，不允许提交！");
					abort();
				}
			} else {
				if (row.getCell("IdNum").getValue() != null) {
					MsgBox.showInfo("非中国籍员工不允许录入身份证号！");
					abort();
				}

			}
			if (row.getCell("passportNo").getValue() == null) {
				MsgBox.showInfo("护照号为空，不允许提交！");
				abort();
			}
			if (row.getCell("partner").getValue() == null) {
				MsgBox.showInfo("合作单位为空，不允许提交！");
				abort();
			}
			if (row.getCell("actprofF").getValue() == null) {
				MsgBox.showInfo("实际工种或专业为空，不允许提交！");
				abort();
			}
			if (row.getCell("pmtProfC").getValue() == null) {
				MsgBox.showInfo("指标工种为空，不允许提交！");
				abort();
			}
			if (row.getCell("taskProj").getValue() == null) {
				MsgBox.showInfo("工作项目为空，不允许提交！");
				abort();
			}
			if (row.getCell("pmtProj").getValue() == null) {
				MsgBox.showInfo("指标项目为空，不允许提交！");
				abort();
			}
			if (row.getCell("authType").getValue() == null) {
				MsgBox.showInfo("公证认证类型为空，不允许提交！");
				abort();
			}
			// //2017-3-10 zxh 不为空校验 技能或学历份数
			// if (row.getCell("skillShare").getValue() == null) {
			// MsgBox.showInfo("技能或学历份数为空，不允许提交！");
			// abort();
			// }
			// 2017-3-10 zxh 不为空校验 是否办理工作经验证明字段勾选 ，工作经验份数必填
			if (row.getCell("wkPmtGet").getValue().equals(true)) {
				if (row.getCell("wpCopies").getValue() == null) {
					MsgBox.showInfo("工作经验份数为空，不允许提交！");
					abort();
				}
			}
			if (row.getCell("copies").getValue() == null) {
				MsgBox.showInfo("份数为空，不允许提交！");
				abort();
			}
			if (row.getCell("signNum").getValue() == null) {
				MsgBox.showInfo("第几次报签为空，不允许提交！");
				abort();
			}

		}

	}

	// 不合格人员名单校验
	public void CheckBlackList() throws BOSException {
		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			CountryInfo coInfo = (CountryInfo) row.getCell("country").getValue();
			if ("C01".equals(coInfo.getNumber())) {
				filter.getFilterItems().add(new FilterItemInfo("IdNum", row.getCell("IdNum").getValue(), CompareType.EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("simpleName", row.getCell("passportNo").getValue(), CompareType.EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("isEffect", true, CompareType.EQUALS));
				filter.setMaskString("(#0 or #1) and #2");
			} else {
				filter.getFilterItems().add(new FilterItemInfo("simpleName", row.getCell("passportNo").getValue(), CompareType.EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("isEffect", true, CompareType.EQUALS));
			}
			view.setFilter(filter);
			BlackListCollection col = BlackListFactory.getRemoteInstance().getBlackListCollection(view);
			if (col != null && col.size() > 0) {
				MsgBox.showInfo("人员【" + row.getCell("name").getValue() + "】已在外工不合格人员名单中，不允许提交！ ");
				this.abort();
			}
		}
	}

	// 指标工种校验
	public void checkPmtProfC() throws BOSException, EASBizException {
		Map map = new HashMap();
		int rowCount = this.kdtEntrys.getRowCount();
		int count = 0;
		int oldCount = 0;
		int leftAmount = 0;
		int value = 0;
		ProjectWorkInfo pw = new ProjectWorkInfo();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("pmtProfC").getValue() != null) {
				pw = (ProjectWorkInfo) row.getCell("pmtProfC").getValue();
				if (map != null && map.containsKey(pw.getId().toString())) {
					oldCount = (Integer) map.get(pw.getId().toString());
					map.remove(pw.getId().toString());
					map.put(pw.getId().toString(), ++oldCount);
				} else {
					count = 0;
					map.put(pw.getId().toString(), ++count);
				}
			}
		}
		Set set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String id = it.next();
			ProjectWorkInfo pwInfo = ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(id));
			value = (Integer) map.get(id);
			leftAmount = pwInfo.getLeftAmount();
			if (value > leftAmount) {
				MsgBox.showInfo(this, "指标工种【" + pwInfo.getName() + "】额度不足，不允许提交！");
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
		getAntiTimes();
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
		return com.kingdee.eas.zjlw.certificates.FiIncomeFactory.getRemoteInstance();
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
		com.kingdee.eas.zjlw.certificates.FiIncomeInfo objectValue = new com.kingdee.eas.zjlw.certificates.FiIncomeInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		return objectValue;
	}

}