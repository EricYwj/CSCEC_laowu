/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.DOCTYPE;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class WkPmtTrnEditUI extends AbstractWkPmtTrnEditUI {
	private static final Logger logger = CoreUIObject.getLogger(WkPmtTrnEditUI.class);

	/**
	 * output class constructor
	 */
	public WkPmtTrnEditUI() throws Exception {
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

	// ���༭�¼�
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
		// ����ǩ��������
		if ("passportCityC".equals(key)) {
			ProvinceInfo pInfo = (ProvinceInfo) row.getCell("passportCityC").getValue();
			if (pInfo != null) {
				row.getCell("passportCityF").setValue(pInfo.getDescription());
			}
		}
		// ָ�깤��
		if ("quProf".equals(key)) {
			ProjectWorkInfo pwInfo = (ProjectWorkInfo) row.getCell("quProf").getValue();
			if (pwInfo != null) {
				row.getCell("quProff").setValue(pwInfo.getNameFR());
			}
		}
		// //�ݽ���������
		// if ("papSTime".equals(key)){
		// Date papSTime=(Date) row.getCell("papSTime").getValue();
		// if(papSTime!=null){
		// long time=(papSTime.getTime()-date.getTime())/86400000;
		// if(time<0){
		// MsgBox.showInfo("�ݽ��������ڲ���С�ڵ�ǰʱ�䣬������ѡ��");
		// row.getCell("papSTime").setValue(null);
		// }
		// }
		// }
		// //�Ͷ�֤��֤����
		// if ("wPmtGTime".equals(key)){
		// Date wPmtGTime=(Date) row.getCell("wPmtGTime").getValue();
		// if(wPmtGTime!=null){
		// long time1=(wPmtGTime.getTime()-date.getTime())/86400000;
		// if(time1<0){
		// MsgBox.showInfo("�Ͷ�֤��֤���ڲ���С�ڵ�ǰʱ�䣬������ѡ��");
		// row.getCell("wPmtGTime").setValue(null);
		// }
		// }
		// }
		// //�Ͷ�֤��������
		// if ("wPmtSTime".equals(key)){
		// Date wPmtSTime=(Date) row.getCell("wPmtSTime").getValue();//�Ͷ�֤��������
		// if(wPmtSTime!=null){
		// long time2=(wPmtSTime.getTime()-date.getTime())/86400000;
		// if(time2<0){
		// MsgBox.showInfo("�Ͷ�֤�������ڲ���С�ڵ�ǰʱ�䣬������ѡ��");
		// row.getCell("wPmtSTime").setValue(null);
		// }
		// }
		// }
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
		this.billSate.setEnabled(false);
		this.pkauditDate.setEnabled(false);
		super.onLoad();
		setButtonStatus();
		setUITitle("�Ͷ�֤����");
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
		btnUnAudit.setVisible(false);
		btnAudit.setVisible(false);
		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
		this.billSate.setEditable(false);
		if (getUIContext().get("BOTPViewStatus") != null) {
			this.btnSubmit.setVisible(false);
			kdtEntrys.getColumn("birthPlace").getStyleAttributes().setHided(true);// ������
																					// ��
																					// ����
																					// ��
			kdtEntrys.getColumn("birthPlaceFr").getStyleAttributes().setHided(true);// ������
																					// ��
																					// ƴ��
																					// ��
			kdtEntrys.getColumn("passportIssueDate").getStyleAttributes().setHided(true);// ����ǩ������
			kdtEntrys.getColumn("passpExDate").getStyleAttributes().setHided(true);// ���յ�������
			kdtEntrys.getColumn("passportAgence").getStyleAttributes().setHided(true);// ���հ䷢����
			kdtEntrys.getColumn("passportCityC").getStyleAttributes().setHided(true);// ����ǩ����
																						// ��
																						// ����
																						// ��
			kdtEntrys.getColumn("passportCityF").getStyleAttributes().setHided(true);// ����ǩ����
																						// ��
																						// ƴ��
																						// ��
			kdtEntrys.getColumn("quProf").getStyleAttributes().setHided(true);// ָ�깤������
			kdtEntrys.getColumn("quProff").getStyleAttributes().setHided(true);// �б깤�ַ���
			kdtEntrys.getColumn("workSuffer").getStyleAttributes().setHided(true);// ��������
			kdtEntrys.getColumn("fatherName").getStyleAttributes().setHided(true);// ��������
			kdtEntrys.getColumn("fatherNameAlphabet").getStyleAttributes().setHided(true);// ��������ƴ��
			kdtEntrys.getColumn("motherName").getStyleAttributes().setHided(true);// ĸ������
			kdtEntrys.getColumn("motherNameAlphabet").getStyleAttributes().setHided(true);// ĸ������ƴ��
			kdtEntrys.getColumn("MaritalStatus").getStyleAttributes().setHided(true);// ����״̬
			kdtEntrys.getColumn("laborVisaNo").getStyleAttributes().setHided(true);// �Ͷ��ַ�ǩ��
			kdtEntrys.getColumn("docAffiliated").getStyleAttributes().setHided(true);// ��ǩ�����ҿ���
			kdtEntrys.getColumn("qualDate").getStyleAttributes().setHided(true);// ˫��֤���ʱ��
			kdtEntrys.getColumn("authType").getStyleAttributes().setHided(true);// ��֤��֤����
			kdtEntrys.getColumn("wPmtNum").getStyleAttributes().setHided(true);// ԭ�Ͷ�֤��
			kdtEntrys.getColumn("wPmtSTime").getStyleAttributes().setHided(true);// ԭ�Ͷ�֤������
			//kdtEntrys.getColumn("HwPmtNum").getStyleAttributes().setHided(true
			// );//ԭ�Ͷ�֤��
			// kdtEntrys.getColumn("HwPmtSTime").getStyleAttributes().setHided(
			// true);//ԭ�Ͷ�֤������
			kdtEntrys.getColumn("laborTrnDate").getStyleAttributes().setHided(true);// �յ��Ͷ�֤��ת��ʱ��
			kdtEntrys.getColumn("papSTime").getStyleAttributes().setHided(true);// �Ͷ�֤���ϵݽ�ʱ��
			kdtEntrys.getColumn("pType").getStyleAttributes().setHided(true);// �Ͷ�֤����
			kdtEntrys.getColumn("wPmtGTime").getStyleAttributes().setHided(true);// �Ͷ�֤��֤����
			kdtEntrys.getColumn("laboreffDate").getStyleAttributes().setHided(true);// �Ͷ�֤��Ч����
			kdtEntrys.getColumn("sPAffPerson").getStyleAttributes().setHided(true);// �Ͷ�֤����ǩ�ռ��ҿ���
			kdtEntrys.getColumn("dlyChkFrc").getStyleAttributes().setHided(true);// �ڼ��α�ǩ

			kdtEntrys.getColumn("passpNum").getStyleAttributes().setLocked(true);// ���պ�
			kdtEntrys.getColumn("quProf").getStyleAttributes().setLocked(true);// ָ�깤������
			kdtEntrys.getColumn("quProff").getStyleAttributes().setLocked(true);// ָ�깤�ַ���
			kdtEntrys.getColumn("wPmtNum").getStyleAttributes().setLocked(true);// �Ͷ�֤��
			kdtEntrys.getColumn("wPmtSTime").getStyleAttributes().setLocked(true);// �Ͷ�֤��֤����
			kdtEntrys.getColumn("actProf").getStyleAttributes().setLocked(true);// ʵ�ʹ���
			kdtEntrys.getColumn("pmtProj").getStyleAttributes().setLocked(false);// ��ָ����Ŀ
			kdtEntrys.getColumn("workOrg").getStyleAttributes().setLocked(true);// ������Ŀ
			kdtEntrys.getColumn("oldPassport").getStyleAttributes().setLocked(true);// �ɻ��պ���
		}
		// kdtEntrys.getColumn("name").getStyleAttributes().setLocked(true);//����
		// kdtEntrys.getColumn("sex").getStyleAttributes().setLocked(true);//�Ա�
		//kdtEntrys.getColumn("birthday").getStyleAttributes().setLocked(true);/
		// /��������
		// kdtEntrys.getColumn("IdNum").getStyleAttributes().setLocked(true);//
		// ���֤��
		//kdtEntrys.getColumn("passpNum").getStyleAttributes().setLocked(true);/
		// /���պ�
		//kdtEntrys.getColumn("passpExDate").getStyleAttributes().setLocked(true
		// );//����ʧЧ����
		//kdtEntrys.getColumn("immiTime").getStyleAttributes().setLocked(true);/
		// /�뾳����
		//kdtEntrys.getColumn("dlyChkFrc").getStyleAttributes().setLocked(true);
		// //��ǩ����
		// kdtEntrys.getColumn("pType").getStyleAttributes().setLocked(true);//
		// ֤������
		//kdtEntrys.getColumn("actProf").getStyleAttributes().setLocked(true);//
		// ʵ�ʹ���
		//kdtEntrys.getColumn("HquProff").getStyleAttributes().setLocked(true);/
		// /ԭָ�깤�ַ���
		//kdtEntrys.getColumn("HpapSTime").getStyleAttributes().setLocked(true);
		// //ԭ�Ͷ�֤�ݽ���������
		//kdtEntrys.getColumn("HwPmtGTime").getStyleAttributes().setLocked(true)
		// ;//ԭ�Ͷ�֤��֤����
		//kdtEntrys.getColumn("HwPmtNum").getStyleAttributes().setLocked(true);/
		// /ԭ�Ͷ�֤��
		//kdtEntrys.getColumn("HwPmtSTime").getStyleAttributes().setLocked(true)
		// ;//ԭ�Ͷ�֤��֤����
		//kdtEntrys.getColumn("HpmtProj").getStyleAttributes().setLocked(true);/
		// /ԭָ����Ŀ
		//kdtEntrys.getColumn("HworkOrj").getStyleAttributes().setLocked(true);/
		// /ԭ������Ŀ
		//kdtEntrys.getColumn("hQuProf").getStyleAttributes().setLocked(true);//
		// ԭָ�깤��
		//kdtEntrys.getColumn("cooperation").getStyleAttributes().setLocked(true
		// );//������λ
		filterProf();// ���˷�¼ָ�깤��
	}

	// ��¼ָ�깤�ָ���ָ����Ŀ����
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
				row.getCell("quProf").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
			}
		}
	}

	protected void setButtonStatus() {
		WkPmtTrnInfo bill;
		if ("VIEW".equals(getOprtState())) {
			this.actionAudit.setVisible(true);
			this.actionUnAudit.setVisible(true);
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
			bill = (WkPmtTrnInfo) this.editData;
			if (this.editData != null) {
				if (BillStateEnum.CHECKED.equals(bill.getBillSate())) {// (
																		// BillStateEnum
																		// .
																		// SIGNE
																		// .
																		// equals
																		// (
																		// bill.
																		// getBillSate
																		// ()))
					this.actionUnAudit.setVisible(true);
					this.actionUnAudit.setEnabled(true);
					this.actionAudit.setVisible(false);
					this.actionAudit.setEnabled(false);
					this.actionEdit.setEnabled(false);
					this.actionRemove.setEnabled(false);
				} else {
					this.actionUnAudit.setVisible(false);
					this.actionUnAudit.setEnabled(false);
					this.actionAudit.setVisible(true);
					this.actionAudit.setEnabled(true);
					this.actionRemove.setEnabled(true);
					this.actionEdit.setEnabled(true);
				}
			}

			this.actionAddLine.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionInsertLine.setEnabled(false);
		} else {
			bill = (WkPmtTrnInfo) this.editData;
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
			bill = (WkPmtTrnInfo) this.editData;
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
		// ֻ���ݴ�״̬���Ա���
		if (this.editData != null && this.editData.getId() != null) {
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			WkPmtTrnInfo fiInfo = WkPmtTrnFactory.getRemoteInstance().getWkPmtTrnInfo(new ObjectUuidPK(this.editData.getId()), sic);
			if (fiInfo.getBillSate() != null && !BillStateEnum.DRAFT.equals(fiInfo.getBillSate())) {
				MsgBox.showInfo("��ǰ����״̬Ϊ��" + fiInfo.getBillSate().getAlias() + "���������ظ����棡");
				abort();
			}
		}
		super.actionSave_actionPerformed(e);
		filterProf();// ���˷�¼ָ�깤��
	}

	protected void doBeforeSave(ActionEvent e) throws Exception {
		// checkEmpty();//����У��ָ����Ŀ��Ϊ��
		super.doBeforeSave(e);
	}

	// ����У��ָ����Ŀ��Ϊ��
	protected void checkEmpty() {
		int rowCount = kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			if (row.getCell("pmtProj").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("name").getValue() + "����ָ����ĿΪ�գ��޷����棬���������룡");
				this.abort();
			}
		}
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
		filterProf();// ���˷�¼ָ�깤��

	}

	// �ύУ��
	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		// ֻ���ݴ�������ύ״̬�����ύ
		if (this.editData != null && this.editData.getId() != null) {
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			WkPmtTrnInfo fiInfo = WkPmtTrnFactory.getRemoteInstance().getWkPmtTrnInfo(new ObjectUuidPK(this.editData.getId()), sic);
			if (fiInfo.getBillSate() != null && !(BillStateEnum.DRAFT.equals(fiInfo.getBillSate()) || BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))) {
				MsgBox.showInfo("��ǰ����״̬Ϊ��" + fiInfo.getBillSate().getAlias() + "���������ظ��ύ��");
				abort();
			}
		}
		checkEmpte();
		checkDate();
		checkPmtProfC();
		super.doBeforeSubmit(e);
	}

	// �ύ��Ϊ��У��
	public void checkEmpte() {
		int rowCount = kdtEntrys.getRowCount();
		int sPAfPersonCount = 0;
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			Boolean sPAfPerson = (Boolean) row.getCell("sPAffPerson").getValue();
			if (row.getCell("passpNum").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("passpNum").getValue() + "���Ļ��պ���Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("passportIssueDate").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("passportIssueDate").getValue() + "���Ļ���ǩ������Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("passpExDate").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("passpExDate").getValue() + "���Ļ��յ�������Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("passportAgence").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("passportAgence").getValue() + "���Ļ��հ䷢����Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("passportCityC").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("passportCityC").getValue() + "���Ļ���ǩ���أ����ģ�Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("passportCityF").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("passportCityF").getValue() + "���Ļ���ǩ���أ�ƴ����Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("quProf").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("quProf").getValue() + "����ָ�깤��Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("qualDate").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("qualDate").getValue() + "����˫��֤���ʱ��Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("laborTrnDate").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("laborTrnDate").getValue() + "�����յ��Ͷ�֤��ת��ʱ��Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("papSTime").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("papSTime").getValue() + "�����Ͷ�֤���ϵݽ�ʱ��Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (DOCTYPE.EMPTY.equals(row.getCell("pType").getValue())) {
				MsgBox.showInfo("������" + row.getCell("pType").getValue() + "�����Ͷ�֤����Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("wPmtNum").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("wPmtNum").getValue() + "�����Ͷ�֤��Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("wPmtGTime").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("wPmtGTime").getValue() + "�����Ͷ�֤��֤����Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("laboreffDate").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("laboreffDate").getValue() + "�����Ͷ�֤��Ч����Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("wPmtSTime").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("wPmtSTime").getValue() + "�����Ͷ�֤��������Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("pmtProj").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("pmtProj").getValue() + "����ָ����ĿΪ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("workOrg").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("workOrg").getValue() + "���Ĺ�����ĿΪ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (sPAfPerson) {
				sPAfPersonCount++;
			}
		}
		if (sPAfPersonCount != 1) {
			MsgBox.showInfo("�Ͷ�֤����ǩ�ռ��ҿ��˱����ҽ��ɹ�ѡһ�ˣ�");
			this.abort();
		}
	}

	// ʱ��У��
	public void checkDate() throws Exception {
		int rowCount = kdtEntrys.getRowCount();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			Date passportIssueDate = (Date) row.getCell("passportIssueDate").getValue();// ����ǩ������
			passportIssueDate = sdf.parse(sdf.format(passportIssueDate));
			Date passpExDate = (Date) row.getCell("passpExDate").getValue();// ���յ�������
			passpExDate = sdf.parse(sdf.format(passpExDate));
			Date papSTime = (Date) row.getCell("papSTime").getValue();// �ݽ���������
			papSTime = sdf.parse(sdf.format(papSTime));
			Date wPmtGTime = (Date) row.getCell("wPmtGTime").getValue();// �Ͷ�֤��֤����
			wPmtGTime = sdf.parse(sdf.format(wPmtGTime));
			Date wPmtSTime = (Date) row.getCell("wPmtSTime").getValue();// �Ͷ�֤��֤����
			wPmtSTime = sdf.parse(sdf.format(wPmtSTime));
			Date laborTrnDate = (Date) row.getCell("laborTrnDate").getValue();// �յ��Ͷ�֤��ת��ʱ��
			laborTrnDate = sdf.parse(sdf.format(laborTrnDate));
			// ���յ�����>����ǩ����
			if (passportIssueDate != null && passpExDate != null) {
				if (passpExDate.compareTo(passportIssueDate) <= 0) {
					MsgBox.showInfo("��ѡ�л���ʧЧ��С�ڵ��ڻ���ǩ�����ڣ��޷��ύ�����������룡");
					this.abort();
				}
			}
			// �Ͷ�֤���ϵݽ�ʱ��>=�յ��Ͷ�֤��ת��ʱ��
			if (papSTime != null) {
				if (laborTrnDate != null) {
					if (papSTime.before(laborTrnDate)) {
						MsgBox.showInfo("��ѡ���Ͷ�֤���ϵݽ�ʱ��С���յ��Ͷ�֤��ת��ʱ�䣬�޷��ύ�����������룡");
						this.abort();
					}
				}
				// �Ͷ�֤��֤����>=�Ͷ�֤���ϵݽ�ʱ��
				if (wPmtGTime != null) {
					if (wPmtGTime.before(papSTime)) {
						MsgBox.showInfo("��ѡ���Ͷ�֤��֤����С���Ͷ�֤���ϵݽ�ʱ�䣬�޷��ύ�����������룡");
						this.abort();
					}
				}
			}
			// �Ͷ�֤��������>�Ͷ�֤��Чʱ��
			Date laboreffDate = (Date) row.getCell("laboreffDate").getValue();
			laboreffDate = sdf.parse(sdf.format(laboreffDate));
			if (wPmtSTime != null) {
				if (wPmtSTime.compareTo(laboreffDate) <= 0) {
					MsgBox.showInfo("��ѡ���Ͷ�֤��������С�ڵ����Ͷ�֤��Чʱ�䣬�޷��ύ�����������룡");
					this.abort();
				}
				// �Ͷ�֤��������>�Ͷ�֤��֤ʱ��
				if (wPmtGTime != null) {
					if (wPmtSTime.compareTo(wPmtGTime) <= 0) {
						MsgBox.showInfo("��ѡ���Ͷ�֤��������С�ڵ����Ͷ�֤��֤ʱ�䣬�޷��ύ�����������룡");
						this.abort();
					}
				}
			}
		}
	}

	// ָ�깤��У��
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
			pw = (ProjectWorkInfo) row.getCell("quProf").getValue();
			if (pw != null) {
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
				MsgBox.showInfo(this, "ָ�깤��[" + pwInfo.getName() + "]��Ȳ��㣬�������ύ��");
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
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		super.actionAudit_actionPerformed(e);
	}

	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		super.actionUnAudit_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception {
		return com.kingdee.eas.zjlw.certificates.WkPmtTrnFactory.getRemoteInstance();
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
		com.kingdee.eas.zjlw.certificates.WkPmtTrnInfo objectValue = new com.kingdee.eas.zjlw.certificates.WkPmtTrnInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		return objectValue;
	}

}