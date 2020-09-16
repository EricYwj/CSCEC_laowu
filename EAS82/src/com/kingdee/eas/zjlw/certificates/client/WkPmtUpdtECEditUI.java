/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoInfo;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectWork;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtECEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtECEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtECFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtECInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtECEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtECEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtECFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtECInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.DOCTYPE;
import com.kingdee.eas.zjlw.certificates.app.PassportOrganEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class WkPmtUpdtECEditUI extends AbstractWkPmtUpdtECEditUI {
	private static final Logger logger = CoreUIObject.getLogger(WkPmtUpdtECEditUI.class);

	/**
	 * output class constructor
	 */
	public WkPmtUpdtECEditUI() throws Exception {
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

	// 2016-11-09 zxh
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
		btnUnAudit.setVisible(false);
		btnAudit.setVisible(false);
		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
		this.billSate.setEditable(false);
		if (getUIContext().get("BOTPViewStatus") != null) {
			this.pkBizDate.setValue(new Date());
		}
		kdtEntrys.getColumn("name").getStyleAttributes().setLocked(true);// ����
		kdtEntrys.getColumn("sex").getStyleAttributes().setLocked(true);// �Ա�
		kdtEntrys.getColumn("birthday").getStyleAttributes().setLocked(true);// ��������
		kdtEntrys.getColumn("IdNum").getStyleAttributes().setLocked(true);// ���֤��
		kdtEntrys.getColumn("passpNum").getStyleAttributes().setLocked(true);// ���պ�
		kdtEntrys.getColumn("passpExDate").getStyleAttributes().setLocked(true);// ����ʧЧ����
		kdtEntrys.getColumn("immiTime").getStyleAttributes().setLocked(true);// �뾳����
		kdtEntrys.getColumn("dlyChkFrc").getStyleAttributes().setLocked(true);// ��ǩ����
		kdtEntrys.getColumn("pType").getStyleAttributes().setLocked(true);// ֤������
		kdtEntrys.getColumn("actProf").getStyleAttributes().setLocked(true);// ʵ�ʹ���
		kdtEntrys.getColumn("HpapSTime").getStyleAttributes().setLocked(true);// ԭ�Ͷ�֤�ݽ���������
		kdtEntrys.getColumn("HwPmtGTime").getStyleAttributes().setLocked(true);// ԭ�Ͷ�֤��֤����
		kdtEntrys.getColumn("HwPmtNum").getStyleAttributes().setLocked(true);// ԭ�Ͷ�֤��
		//kdtEntrys.getColumn("wPmtNum").getStyleAttributes().setLocked(true);//
		// �Ͷ�֤��
		kdtEntrys.getColumn("hWPmtSTime").getStyleAttributes().setLocked(true);// ԭ�Ͷ�֤��֤����
		kdtEntrys.getColumn("pmtProj").getStyleAttributes().setLocked(true);// ָ����Ŀ
		kdtEntrys.getColumn("workOrg").getStyleAttributes().setLocked(true);// ������Ŀ
		kdtEntrys.getColumn("quProf").getStyleAttributes().setLocked(true);// ָ�깤��
		kdtEntrys.getColumn("quproff").getStyleAttributes().setLocked(true);// ָ�깤��
		// ��
		// ����
		// ��
		kdtEntrys.getColumn("cooperation").getStyleAttributes().setLocked(true);// ������λ
		// --------------��ȡԭ��������-------------------------------------------
		// 2016-11-08 zxh
		if (getOprtState().equals("ADDNEW")) {
			// ��ȡ���ܵ��Ĳ���
			Map uictxMap = this.getUIContext();
			Set etys = new HashSet();
			etys = (Set) uictxMap.get("etys");
			// ������ǩ�����¼����
			for (Object object : etys) {
				WkPmtUpdtEntryInfo etyInfo = (WkPmtUpdtEntryInfo) object;
				// ������¼��ֵ��ֵ��һ��
				IRow row = this.kdtEntrys.addRow();
				row.getCell("oldEtyId").setValue(etyInfo.getId());
				row.getCell("name").setValue(etyInfo.getName());// ��������
				row.getCell("lastName").setValue(etyInfo.getLastName());// ��ƴ��
				row.getCell("firstName").setValue(etyInfo.getFirstName());// ��ƴ��
				row.getCell("sex").setValue(etyInfo.getSex());// �Ա�
				row.getCell("birthday").setValue(etyInfo.getBirthday());// ��������
				row.getCell("birthPlace").setValue(etyInfo.getBirthPlace());// ������
				// ��
				// ����
				// ��
				row.getCell("birthPlaceFr").setValue(etyInfo.getBirthPlaceFr());// ������
				// ��
				// ƴ��
				// ��
				row.getCell("passpNum").setValue(etyInfo.getPasspNum());// ���պ���
				row.getCell("passportIssueDate").setValue(etyInfo.getPassportIssueDate());// ����ǩ������
				row.getCell("passpExDate").setValue(etyInfo.getPasspExDate());// ���յ�������
				row.getCell("passportAgence").setValue(etyInfo.getPassportAgence());// ���հ䷢����
				row.getCell("passportCityF").setValue(etyInfo.getPassportCityF());// ����ǩ����
				// ��
				// ƴ��
				// ��
				row.getCell("actProf").setValue(etyInfo.getActProf());// ʵ��רҵ����
				row.getCell("quproff").setValue(etyInfo.getQuproff());// ָ�깤�ַ���
				row.getCell("workEXP").setValue(etyInfo.getWorkEXP());// ��������
				row.getCell("authType").setValue(etyInfo.getAuthType());// ��֤��֤����
				row.getCell("fatherName").setValue(etyInfo.getFatherName());// ��������
				row.getCell("fatherNameAlphabet").setValue(etyInfo.getFatherNameAlphabet());// ��������ƴ��
				row.getCell("motherName").setValue(etyInfo.getMotherName());// ĸ������
				row.getCell("motherNameAlphabet").setValue(etyInfo.getMotherNameAlphabet());// ĸ������ƴ��
				row.getCell("MaritalStatus").setValue(etyInfo.getMaritalStatus());// ����״̬
				row.getCell("immiTime").setValue(etyInfo.getImmiTime());// �밢ʱ��
				row.getCell("HwPmtNum").setValue(etyInfo.getHwPmtNum());// ԭ�Ͷ�֤����
				row.getCell("hWPmtSTime").setValue(etyInfo.getHWPmtSTime());// ԭ�Ͷ�֤��������
				row.getCell("papSTime").setValue(etyInfo.getPapSTime());// �Ͷ�֤���ϵݽ�ʱ��
				row.getCell("pType").setValue(etyInfo.getPType());// �Ͷ�֤����
				row.getCell("wPmtNum").setValue(etyInfo.getWPmtNum());// �Ͷ�֤��
				row.getCell("wPmtGTime").setValue(etyInfo.getWPmtGTime());// �Ͷ�֤��֤����
				row.getCell("laboreffDate").setValue(etyInfo.getLaboreffDate());// �Ͷ�֤��Ч����
				row.getCell("wPmtSTime").setValue(etyInfo.getWPmtSTime());// �Ͷ�֤��������
				row.getCell("sPAfPerson").setValue(etyInfo.isSPAfPerson());// �Ͷ�֤����ǩ�ռ��ҿ���
				row.getCell("oldPassport").setValue(etyInfo.getOldPassport());// �ɻ��պ���
				row.getCell("IdNum").setValue(etyInfo.getIdNum());// ���֤��
				row.getCell("remark").setValue(etyInfo.getRemark());// ��ע
				row.getCell("personID").setValue(etyInfo.getPersonID());// ��Ա��¼id
				if (etyInfo.getNation() != null) {
					CountryInfo contryInfo = etyInfo.getNation();
					CountryInfo nation = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(contryInfo.getId()));
					row.getCell("nation").setValue(nation);// ����
				}
				if (etyInfo.getPassportCityC() != null) {
					ProvinceInfo contryInfo = etyInfo.getPassportCityC();
					ProvinceInfo passportCityC = ProvinceFactory.getRemoteInstance().getProvinceInfo(new ObjectUuidPK(contryInfo.getId()));
					row.getCell("passportCityC").setValue(passportCityC);//����ǩ���أ�
					// ����
					// ��
				}
				if (etyInfo.getQuProf() != null) {
					ProjectWorkInfo contryInfo = etyInfo.getQuProf();
					ProjectWorkInfo quProf = ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(contryInfo.getId()));
					row.getCell("quProf").setValue(quProf);// ָ�깤������
				}
				if (etyInfo.getPmtProj() != null) {
					AdminOrgUnitInfo contryInfo = etyInfo.getPmtProj();
					AdminOrgUnitInfo pmtProj = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
					row.getCell("pmtProj").setValue(pmtProj);// ָ����Ŀ
				}
				if (etyInfo.getWorkOrg() != null) {
					AdminOrgUnitInfo contryInfo = etyInfo.getWorkOrg();
					AdminOrgUnitInfo workOrg = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
					row.getCell("workOrg").setValue(workOrg);// ������Ŀ
				}
				if (etyInfo.getCooperation() != null) {
					AdminOrgUnitInfo contryInfo = etyInfo.getCooperation();
					AdminOrgUnitInfo cooperation = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
					row.getCell("cooperation").setValue(cooperation);// ������λ
				}
			}
		}
	}

	protected void setButtonStatus() {
		WkPmtUpdtECInfo bill;
		if ("VIEW".equals(getOprtState())) {
			this.actionAudit.setVisible(true);
			this.actionUnAudit.setVisible(true);
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
			bill = (WkPmtUpdtECInfo) this.editData;
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
			bill = (WkPmtUpdtECInfo) this.editData;
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
			bill = (WkPmtUpdtECInfo) this.editData;
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
			if (row.getCell("passportCityC").getValue() != null) {
				ProvinceInfo pInfo = (ProvinceInfo) row.getCell("passportCityC").getValue();
				row.getCell("passportCityF").setValue(pInfo.getDescription());
			} else {
				row.getCell("passportCityF").setValue(null);
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
		String id = this.editData.getId().toString();
		WkPmtUpdtECInfo info = WkPmtUpdtECFactory.getRemoteInstance().getWkPmtUpdtECInfo(new ObjectUuidPK(id));
		WkPmtUpdtECEntryCollection col = info.getEntrys();
		for (int i = 0; i < col.size(); i++) {
			WkPmtUpdtECEntryInfo etyInfo = col.get(i);
			String etyId = etyInfo.getId().toString();// �ȷ�¼id
			String oldId = etyInfo.getOldEtyId().toString();// ԭ��¼id
			// Я������
			IBoAttchAsso boaFac = BoAttchAssoFactory.getRemoteInstance();
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("attachment.id");
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("boID", etyId));
			view.setFilter(filter);
			view.setSelector(sic);
			// �����ַ�¼ID��ѯ����
			BoAttchAssoCollection boaCol = boaFac.getBoAttchAssoCollection(view);
			if (boaCol != null && boaCol.size() > 0) {
				for (int j = 0; j < boaCol.size(); j++) {
					BoAttchAssoInfo boaInfo = boaCol.get(j);
					// ��Ӹ���
					BoAttchAssoInfo newBoaInfo = new BoAttchAssoInfo();
					newBoaInfo.setId(BOSUuid.create(newBoaInfo.getBOSType()));
					newBoaInfo.setBoID(oldId);// ԭ��¼id
					newBoaInfo.setAssoType("ϵͳ���и���");// ����
					newBoaInfo.setAttachment(boaInfo.getAttachment());// ����
					newBoaInfo.setAssoBusObjType("E27083F5");// ����ҵ���������ͣ�
					// ԭ�Ͷ�֤��¼BOSTYPE
					boaFac.addnew(newBoaInfo);
					// �Ͷ�֤�����¼��Ӹ���
					String liveId = getLivepermitId(etyInfo);
					if (liveId == null || liveId == "") {
						MsgBox.showInfo("��¼�����޷���д���Ͷ�֤�����ݣ�");
					} else {
						BoAttchAssoInfo newBoaInfo1 = new BoAttchAssoInfo();
						newBoaInfo1.setId(BOSUuid.create(newBoaInfo1.getBOSType()));
						newBoaInfo1.setBoID(liveId);// ԭ��¼id
						newBoaInfo1.setAssoType("ϵͳ���и���");// ����
						newBoaInfo1.setAttachment(boaInfo.getAttachment());// ����
						newBoaInfo1.setAssoBusObjType("19A0BB9D");// ����ҵ���������ͣ�
						// �Ͷ�֤�����¼BOSTYPE
						boaFac.addnew(newBoaInfo1);
					}
				}
			}
			// ɾ��ԭ�и���
			boaFac.delete(filter);
		}
		//--------------------��д��¼�ֶ�--------------------------------------------
		int count = this.kdtEntrys.getRowCount3();
		for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("oldEtyId").getValue() != null) {
				WkPmtUpdtEntryInfo etyInfo = WkPmtUpdtEntryFactory.getRemoteInstance().getWkPmtUpdtEntryInfo(new ObjectUuidPK(row.getCell("oldEtyId").getValue().toString()));
				SelectorItemCollection sic = new SelectorItemCollection();
				// ��ע remark
				if (row.getCell("remark").getValue() != null) {
					etyInfo.setRemark((String) row.getCell("remark").getValue());
				} else {
					etyInfo.setRemark(null);
				}
				// ���պ���
				if (row.getCell("passpNum").getValue() != null) {
					etyInfo.setPasspNum((String) row.getCell("passpNum").getValue());
				} else {
					etyInfo.setPasspNum(null);
				}
				// ����ǩ������
				if (row.getCell("passportIssueDate").getValue() != null) {
					etyInfo.setPassportIssueDate((Date) row.getCell("passportIssueDate").getValue());
				} else {
					etyInfo.setPassportIssueDate(null);
				}
				// ���յ�������
				if (row.getCell("passpExDate").getValue() != null) {
					etyInfo.setPasspExDate((Date) row.getCell("passpExDate").getValue());
				} else {
					etyInfo.setPasspExDate(null);
				}
				// ���հ䷢����
				if (row.getCell("passportAgence").getValue() != null) {
					etyInfo.setPassportAgence((PassportOrganEnum) row.getCell("passportAgence").getValue());
				} else {
					etyInfo.setPassportAgence(null);
				}
				// ����ǩ���أ����ģ�
				if (row.getCell("passportCityC").getValue() != null) {
					ProvinceInfo countryInfo = (ProvinceInfo) row.getCell("passportCityC").getValue();
					ProvinceInfo passportCityC = ProvinceFactory.getRemoteInstance().getProvinceInfo(new ObjectUuidPK(countryInfo.getId()));
					etyInfo.setPassportCityC(passportCityC);
				} else {
					etyInfo.setPassportCityC(null);
				}
				// ����ǩ���أ�ƴ����
				if (row.getCell("passportCityF").getValue() != null) {
					etyInfo.setPassportCityF((String) row.getCell("passportCityF").getValue());
				} else {
					etyInfo.setPassportCityF(null);
				}
				// �Ͷ�֤���ϵݽ�ʱ��
				if (row.getCell("papSTime").getValue() != null) {
					etyInfo.setPapSTime((Date) row.getCell("papSTime").getValue());
				} else {
					etyInfo.setPapSTime(null);
				}
				// �Ͷ�֤����
				if (row.getCell("pType").getValue() != null) {
					etyInfo.setPType((DOCTYPE) row.getCell("pType").getValue());
				} else {
					etyInfo.setPapSTime(null);
				}
				// �Ͷ�֤��
				if (row.getCell("wPmtNum").getValue() != null) {
					etyInfo.setWPmtNum((String) row.getCell("wPmtNum").getValue());
				} else {
					etyInfo.setWPmtNum(null);
				}
				// �Ͷ�֤��֤����
				if (row.getCell("wPmtGTime").getValue() != null) {
					etyInfo.setWPmtGTime((Date) row.getCell("wPmtGTime").getValue());
				} else {
					etyInfo.setWPmtGTime(null);
				}
				// �Ͷ�֤��Ч����
				if (row.getCell("laboreffDate").getValue() != null) {
					etyInfo.setLaboreffDate((Date) row.getCell("laboreffDate").getValue());
				} else {
					etyInfo.setLaboreffDate(null);
				}
				// �Ͷ�֤��������
				if (row.getCell("wPmtSTime").getValue() != null) {
					etyInfo.setWPmtSTime((Date) row.getCell("wPmtSTime").getValue());
				} else {
					etyInfo.setWPmtSTime(null);
				}
				// �Ͷ�֤����ǩ�ռ��ҿ���
				if (row.getCell("sPAfPerson").getValue().equals(true)) {
					etyInfo.setSPAfPerson(true);
				} else {
					etyInfo.setSPAfPerson(false);
				}
				// ������Ŀ
				if (row.getCell("workOrg").getValue() != null) {
					AdminOrgUnitInfo countryInfo = (AdminOrgUnitInfo) row.getCell("workOrg").getValue();
					AdminOrgUnitInfo pmtProj = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
					etyInfo.setWorkOrg(pmtProj);
				} else {
					etyInfo.setWorkOrg(null);
				}
				// //
				// if(row.getCell("cooperation").getValue()!=null){
				// AdminOrgUnitInfo countryInfo=(AdminOrgUnitInfo)
				// row.getCell("cooperation").getValue();
				// AdminOrgUnitInfo
				// cooperation=AdminOrgUnitFactory.getRemoteInstance
				// ().getAdminOrgUnitInfo(new
				// ObjectUuidPK(countryInfo.getId()));
				// etyInfo.setPmtProj(cooperation);
				// }else{
				// etyInfo.setPmtProj(null);
				// }
				// �ɻ��պ���
				if (row.getCell("oldPassport").getValue() != null) {
					etyInfo.setOldPassport((String) row.getCell("oldPassport").getValue());
				} else {
					etyInfo.setOldPassport(null);
				}

				sic.add("passpNum");// ���պ���
				sic.add("passportIssueDate");// ����ǩ������
				sic.add("passpExDate");// ���յ�������
				sic.add("passportAgence");// ���հ䷢����
				sic.add("passportCityC");// ����ǩ���أ����ģ� Province
				sic.add("passportCityF");// ����ǩ���أ�ƴ����
				sic.add("papSTime");// �Ͷ�֤���ϵݽ�ʱ��
				sic.add("pType");// �Ͷ�֤���� Enum
				sic.add("wPmtNum");// �Ͷ�֤��
				sic.add("wPmtGTime");// �Ͷ�֤��֤����
				sic.add("laboreffDate");// �Ͷ�֤��Ч����
				sic.add("wPmtSTime");// �Ͷ�֤��������
				sic.add("sPAfPerson");// �Ͷ�֤����ǩ�ռ��ҿ��� Boolean
				sic.add("workOrg");// ������Ŀ AdminOrgUnit
				// sic.add("cooperation");//������λ AdminOrgUnit
				sic.add("oldPassport");// �ɻ��պ���
				WkPmtUpdtEntryFactory.getRemoteInstance().updatePartial(etyInfo, sic);
			}
		}
	}

	private String getLivepermitId(WkPmtUpdtECEntryInfo etyInfo) throws BOSException, SQLException {
		String getAllSql = "SELECT fid FROM CT_CER_WorkPmtEntry where cfpersonid = (select cfpersonid from CT_CER_WkPmtUpdtECEntry where fid = '" + etyInfo.getId().toString() + "')";
		IRowSet result = SQLExecutorFactory.getRemoteInstance(getAllSql.toString()).executeSQL();
		while (result.next()) {
			return result.getString("fid");
		}
		return null;
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
	}

	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		//----------------------��дԭ���ݣ����õ���״̬Ϊ���ύ--------------------------------
		// ----
		int rowCount = kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			String id = row.getCell("oldEtyId").getValue().toString();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id", id));
			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(filter);
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("billSate");
			WkPmtUpdtEntryCollection antiCol = WkPmtUpdtEntryFactory.getRemoteInstance().getWkPmtUpdtEntryCollection(view);
			for (int j = 0; j < antiCol.size(); j++) {
				WkPmtUpdtInfo antiInfo = antiCol.get(j).getParent();
				antiInfo.setBillSate(BillStateEnum.SUBMIT);
				WkPmtUpdtFactory.getRemoteInstance().updatePartial(antiInfo, sic);
			}
		}
		super.doBeforeSubmit(e);
		checkEmpty();
		checkDate();
	}

	public void checkEmpty() {
		int rowCount = kdtEntrys.getRowCount();
		int sPAfPersonCount = 0;
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			Boolean sPAfPerson = (Boolean) row.getCell("sPAfPerson").getValue();
			if (row.getCell("passpNum").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("name").getValue() + "���Ļ��պ���Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("passportIssueDate").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("name").getValue() + "���Ļ���ǩ������Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("passpExDate").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("name").getValue() + "���Ļ��յ�������Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("passportAgence").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("name").getValue() + "���Ļ��հ䷢����Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("passportCityC").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("name").getValue() + "���Ļ���ǩ���أ����ģ�Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("passportCityF").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("name").getValue() + "���Ļ���ǩ���أ�ƴ����Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("papSTime").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("name").getValue() + "���ĵݽ���������Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("wPmtGTime").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("name").getValue() + "�����Ͷ�֤��֤����Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("wPmtNum").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("name").getValue() + "�����Ͷ�֤��Ϊ�գ��޷��ύ�����������룡");
				this.abort();
			}
			if (row.getCell("wPmtSTime").getValue() == null) {
				MsgBox.showInfo("������" + row.getCell("name").getValue() + "�����Ͷ�֤��֤����Ϊ�գ��޷��ύ�����������룡");
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
	public void checkDate() {
		int rowCount = kdtEntrys.getRowCount();
		// long time=0;
		// long time1=0;
		// long time2=0;
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			Date hpapSTime = (Date) row.getCell("HpapSTime").getValue();// ԭ�ݽ���������
			Date papSTime = (Date) row.getCell("papSTime").getValue();// �Ͷ�֤�ݽ���������
			Date hwpmtGTime = (Date) row.getCell("HwPmtGTime").getValue();// ԭ�Ͷ�֤��֤����
			Date wpmtGTime = (Date) row.getCell("wPmtGTime").getValue();// �Ͷ�֤��֤����
			Date laboreffDate = (Date) row.getCell("laboreffDate").getValue();// �Ͷ�֤��Ч����
			Date hwpmtSTime = (Date) row.getCell("hWPmtSTime").getValue();// ԭ�Ͷ�֤��֤����
			Date wpmtSTime = (Date) row.getCell("wPmtSTime").getValue();// �Ͷ�֤��֤����
			String hwpmtNum = (String) row.getCell("HwPmtNum").getValue();// ԭ�Ͷ�֤��
			String wpmtNum = (String) row.getCell("wPmtNum").getValue();// �Ͷ�֤��
			if (papSTime != null) {
				// if(hpapSTime!=null){
				// //�Ͷ�֤���ϵݽ�ʱ��<ԭ�Ͷ���������
				// if(papSTime.before(hpapSTime)){
				// MsgBox.showInfo("��ѡ�еݽ�����ʱ��С��ԭ�ݽ�����ʱ�䣬�޷��ύ�����������룡");
				// this.abort();
				// }
				// }
				if (hwpmtSTime != null) {
					// �Ͷ�֤���ϵݽ�ʱ��<ԭ�Ͷ���������
					if (papSTime.compareTo(hwpmtSTime) >= 0) {
						MsgBox.showInfo("��ѡ���Ͷ�֤���ϵݽ�ʱ����ڵ���ԭ�Ͷ��������ڣ��޷��ύ�����������룡");
						this.abort();
					}
				}
			}
			if (wpmtGTime != null) {
				if (papSTime != null) {
					if (wpmtGTime.before(papSTime)) {
						MsgBox.showInfo("��ѡ���Ͷ�֤��֤����С���Ͷ�֤���ϵݽ�ʱ�䣬�޷��ύ�����������룡");
						this.abort();
					}
				}
			}
			if (wpmtSTime != null) {
				if (wpmtGTime != null) {
					if (wpmtSTime.compareTo(laboreffDate) <= 0) {
						MsgBox.showInfo("��ѡ���Ͷ�֤��������С�ڵ����Ͷ�֤��Чʱ�䣬�޷��ύ�����������룡");
						this.abort();
					}
				}
				if (wpmtGTime != null) {
					if (wpmtSTime.compareTo(wpmtGTime) <= 0) {
						MsgBox.showInfo("��ѡ���Ͷ�֤��������С�ڵ����Ͷ�֤��֤ʱ�䣬�޷��ύ�����������룡");
						this.abort();
					}
				}
			}
			if (wpmtNum != null && hwpmtNum != null && hwpmtNum.equals(wpmtNum)) {
				MsgBox.showInfo("��ѡ���Ͷ�֤�����ԭ�Ͷ�֤����һ�����޷��ύ�����������룡");
				this.abort();
			}
			if (hwpmtGTime != null && wpmtGTime != null) {
				if (wpmtGTime.before(hwpmtGTime)) {
					MsgBox.showInfo("��ѡ���Ͷ�֤��֤ʱ��С��ԭ�Ͷ�֤��֤ʱ�䣬�޷��ύ�����������룡");
					this.abort();
				}
			}
		}

		// if(hwpmtSTime!=null&&wpmtSTime!=null){
		// time2=(wpmtSTime.getTime()-hwpmtSTime.getTime())/86400000;
		// if(time1<0){
		// MsgBox.showInfo("��ѡ���Ͷ�֤��֤����С��ԭ�Ͷ�֤��֤���ڣ��޷��ύ�����������룡");
		// this.abort();
		// }
		// }

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
		return com.kingdee.eas.zjlw.certificates.WkPmtUpdtECFactory.getRemoteInstance();
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
		com.kingdee.eas.zjlw.certificates.WkPmtUpdtECInfo objectValue = new com.kingdee.eas.zjlw.certificates.WkPmtUpdtECInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		return objectValue;
	}

}