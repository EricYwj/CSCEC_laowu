/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.omg.CORBA.OBJ_ADAPTER;

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
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryFactory;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeEntryCollection;
import com.kingdee.eas.zjlw.certificates.FiIncomeEntryFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeEntryInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.FiiEcEntryCollection;
import com.kingdee.eas.zjlw.certificates.FiiEcEntryInfo;
import com.kingdee.eas.zjlw.certificates.FiiEcFactory;
import com.kingdee.eas.zjlw.certificates.FiiEcInfo;
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
import com.kingdee.eas.zjlw.certificates.app.authType;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class WorkPmtECEditUI extends AbstractWorkPmtECEditUI {
	private static final Logger logger = CoreUIObject.getLogger(WorkPmtECEditUI.class);

	/**
	 * output class constructor
	 */
	public WorkPmtECEditUI() throws Exception {
		super();
	}

	public void onLoad() throws Exception {
		super.onLoad();
		setButtonStatus();
		// ��ȡ��ǰ�û���Ϣ
		UserInfo user = SysContext.getSysContext().getCurrentUserInfo();
		String userNum = "";
		if (user != null) {
			userNum = user.getNumber();
		}
		Set userSet = new HashSet();
		userSet.add("ying_wujie");
		userSet.add("wang_kai");
		if (userSet.contains(userNum)) {
			btnAddNew.setVisible(true);
			btnWorkFlowG.setVisible(true);
			btnAuditResult.setVisible(true);
			btnCopy.setVisible(true);
			btnCreateFrom.setVisible(true);
			btnCreateTo.setVisible(true);
			btnMultiapprove.setVisible(true);
			btnNextPerson.setVisible(true);
			btnFirst.setVisible(true);
			btnPre.setVisible(true);
			btnNext.setVisible(true);
			btnLast.setVisible(true);
			kdtEntrys_detailPanel.getAddNewLineButton().setVisible(true);
			kdtEntrys_detailPanel.getInsertLineButton().setVisible(true);
			kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(true);
			this.billSate.setEditable(true);
			this.pkauditDate.setEnabled(true);
		} else {
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
			this.pkauditDate.setEnabled(false);
		}
		if (getUIContext().get("BOTPViewStatus") != null) {
			// this.pkBizDate.setValue(new Date());
		}
		if (getOprtState().equals("EDIT")) {
			int rowCount = this.kdtEntrys.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				IRow row = this.kdtEntrys.getRow(i);
				// ��ѯ˫��֤���ʱ��
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
		// --------------��ȡԭ��������-------------------------------------------
		// 2016-11-08 zxh
		if (getOprtState().equals("ADDNEW")) {
			// ��ȡ���ܵ��Ĳ���
			Map uictxMap = this.getUIContext();
			Set etys = new HashSet();
			etys = (Set) uictxMap.get("etys");
			// ������ǩ�����¼����
			for (Object object : etys) {
				WorkPmtEntryInfo etyInfo = (WorkPmtEntryInfo) object;
				// ������¼��ֵ��ֵ��һ��
				IRow row = this.kdtEntrys.addRow();
				row.getCell("oldEtyId").setValue(etyInfo.getId());
				row.getCell("name").setValue(etyInfo.getName());// ��������
				row.getCell("firstName").setValue(etyInfo.getFirstName());// ��
				row.getCell("lastName").setValue(etyInfo.getLastName());// ��
				row.getCell("sex").setValue(etyInfo.getSex());// �Ա�
				row.getCell("IdNum").setValue(etyInfo.getIdNum());// ���֤��
				row.getCell("passpNum").setValue(etyInfo.getPasspNum());// ���պ���
				row.getCell("remark").setValue(etyInfo.getRemark());// ��ע
				row.getCell("immiTime").setValue(etyInfo.getImmiTime());// �밢ʱ��
				row.getCell("papSTime").setValue(etyInfo.getPapSTime());// �Ͷ�֤���ϵݽ�ʱ��
				row.getCell("pType").setValue(etyInfo.getPType());// �Ͷ�֤����
				row.getCell("wPmtNum").setValue(etyInfo.getWPmtNum());// �Ͷ�֤��
				row.getCell("wPmtGTime").setValue(etyInfo.getWPmtGTime());// �Ͷ�֤��֤����
				row.getCell("laboreffDate").setValue(etyInfo.getLaboreffDate());// �Ͷ�֤��Ч����
				row.getCell("wPmtSTime").setValue(etyInfo.getWPmtSTime());// �Ͷ�֤��������
				row.getCell("sPAfPerson").setValue(etyInfo.isSPAfPerson());// �Ͷ�֤����ǩ�ռ��ҿ���
				row.getCell("departure").setValue(etyInfo.isDeparture());// �Ƿ�δ�������뾳
				row.getCell("isStop").setValue(etyInfo.isIsStop());// �Ƿ�ͣ��
				row.getCell("endTime").setValue(etyInfo.getEndTime());// ͣ��ʱ��
				row.getCell("cancelReson").setValue(etyInfo.getCancelReson());// ͣ������
				row.getCell("birthday").setValue(etyInfo.getBirthday());// ��������
				row.getCell("birthPlace").setValue(etyInfo.getBirthPlace());// ����������
				row.getCell("birthPlaceFr").setValue(etyInfo.getBirthPlaceFr());// �����ط���
				row.getCell("passportIssueDate").setValue(etyInfo.getPassportIssueDate());// ����ǩ������
				row.getCell("passpExDate").setValue(etyInfo.getPasspExDate());// ���յ�������
				row.getCell("passportAgence").setValue(etyInfo.getPassportAgence());// ���հ䷢����
				row.getCell("passportCityF").setValue(etyInfo.getPassportCityF());// ����ǩ����
																					// ��
																					// ƴ��
																					// ��
				row.getCell("actProf").setValue(etyInfo.getActProf());// ʵ��רҵ����
				row.getCell("quprofF").setValue(etyInfo.getQuprofF());// ָ�깤�ַ���
				row.getCell("workEXP").setValue(etyInfo.getWorkEXP());// ��������
				row.getCell("fatherName").setValue(etyInfo.getFatherName());// ��������
				row.getCell("fatherNameAlphabet").setValue(etyInfo.getFatherNameAlphabet());// ��������ƴ��
				row.getCell("motherName").setValue(etyInfo.getMotherName());// ĸ������
				row.getCell("motherNameAlphabet").setValue(etyInfo.getMotherNameAlphabet());// ĸ������ƴ��
				row.getCell("MaritalStatus").setValue(etyInfo.getMaritalStatus());// ����״̬
				row.getCell("laborSignNo").setValue(etyInfo.getLaborSignNo());// �Ͷ��ַ�ǩ��
				row.getCell("docAffiliate").setValue(etyInfo.isDocAffiliate());// ��ǩ�����ҿ���
				row.getCell("VisaNum").setValue(etyInfo.getVisaNum());// ǩ֤����
				row.getCell("vsTima").setValue(etyInfo.getVsTima());// ǩ֤ǩ������
				row.getCell("veTime").setValue(etyInfo.getVeTime());// ǩ֤��������
				row.getCell("qualDate").setValue(etyInfo.getQualDate());// ˫��֤���ʱ��
				row.getCell("authType").setValue(etyInfo.getAuthType());// ��֤��֤����
				row.getCell("oldPassport").setValue(etyInfo.getOldPassport());// �ɻ��պ���
				row.getCell("dlyChkFrc").setValue(etyInfo.getDlyChkFrc());// �ڼ��α�ǩ
				row.getCell("personID").setValue(etyInfo.getPersonID());// ��Ա��¼id
				if (etyInfo.getNation() != null) {
					CountryInfo countryInfo = etyInfo.getNation();
					CountryInfo nation = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(countryInfo.getId()));
					row.getCell("nation").setValue(nation);// ����
				}
				if (etyInfo.getPassportCityCC() != null) {
					ProvinceInfo countryInfo = etyInfo.getPassportCityCC();
					ProvinceInfo passportCityCC = ProvinceFactory.getRemoteInstance().getProvinceInfo(new ObjectUuidPK(countryInfo.getId()));
					row.getCell("passportCityCC").setValue(passportCityCC);// ����ǩ����
																			// ��
																			// ����
																			// ��
				}
				if (etyInfo.getQuProf() != null) {
					ProjectWorkInfo countryInfo = etyInfo.getQuProf();
					ProjectWorkInfo quProf = ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(countryInfo.getId()));
					row.getCell("quProf").setValue(quProf);// ָ�깤������
				}
				if (etyInfo.getWorkOrg() != null) {
					AdminOrgUnitInfo countryInfo = etyInfo.getWorkOrg();
					AdminOrgUnitInfo workOrg = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
					row.getCell("workOrg").setValue(workOrg);// ������Ŀ
				}
				if (etyInfo.getPmtProj() != null) {
					AdminOrgUnitInfo countryInfo = etyInfo.getWorkOrg();
					AdminOrgUnitInfo pmtProj = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
					row.getCell("pmtProj").setValue(pmtProj);// ָ����Ŀ
				}
				if (etyInfo.getCooperation() != null) {
					AdminOrgUnitInfo countryInfo = etyInfo.getCooperation();
					AdminOrgUnitInfo cooperation = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
					row.getCell("cooperation").setValue(cooperation);// ������λ
				}

			}
		}
	}

	// 2016-11-08 zxh
	protected void setEntryLocked() {
		// ���ñ�����Ƿ�ɱ༭
		int rowCount = kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			// �Ƿ�ͣ��
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
			// departure �Ƿ��뾳
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
			//2018-11-5  ywj ������λ����༭
			row.getCell("cooperation").getStyleAttributes().setLocked(false);
		}
	}

	// 2016-11-08 zxh
	protected void setButtonStatus() {
		WorkPmtECInfo bill;
		// ��ȡ��ǰ�û���Ϣ
		UserInfo user = SysContext.getSysContext().getCurrentUserInfo();
		String userNum = user.getNumber();
		Set userSet = new HashSet();
		userSet.add("ying_wujie");
		userSet.add("wang_kai");
		if (userSet.contains(userNum)) {
			this.actionEdit.setEnabled(true);
			this.actionRemove.setEnabled(true);
			this.actionSave.setEnabled(true);
			this.actionAddLine.setEnabled(true);
			this.actionRemoveLine.setEnabled(true);
			this.actionInsertLine.setEnabled(true);
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(true);
		} else {
			if ("VIEW".equals(getOprtState())) {
				// this.actionAudit.setVisible(true);
				// this.actionUnAudit.setVisible(true);
				// this.actionAudit.setEnabled(true);
				// this.actionUnAudit.setEnabled(true);

				bill = (WorkPmtECInfo) this.editData;
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
				bill = (WorkPmtECInfo) this.editData;
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
				bill = (WorkPmtECInfo) this.editData;
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
		// �Ƿ�δ�������뾳
		// �����ѡ��
		// 1.�Ͷ�֤�ݽ�����ʱ��Ϊ�� papSTime
		// 2.�Ͷ�֤����Ϊ�� pType
		// 3.�Ͷ�֤��Ϊ�� wPmtNum
		// 4.�Ͷ�֤��Ч����Ϊ�� laboreffDate
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
		// �Ƿ�ͣ��
		// �����ѡ��
		// 1.�Ͷ�֤���ϵݽ�ʱ�䲻Ϊ�� papSTime
		// 2.�Ͷ�֤����Ϊ�� pType
		// 3.�Ͷ�֤��Ϊ�� wPmtNum
		// 4.�Ͷ�֤��֤����Ϊ�� wPmtGTime
		// 5.�Ͷ�֤��Ч����Ϊ�� laboreffDate
		// 6.�Ͷ�֤��������Ϊ�� wPmtSTime
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
		//==================================���ݷ�¼id��дԭ��¼==========================
		// ==== 2016-11-08 zxh
		//--------------------��д��¼����--------------------------------------------
		// --------
		String id = this.editData.getId().toString();
		WorkPmtECInfo info = WorkPmtECFactory.getRemoteInstance().getWorkPmtECInfo(new ObjectUuidPK(id));
		WorkPmtECEntryCollection col = info.getEntrys();
		for (int i = 0; i < col.size(); i++) {
			WorkPmtECEntryInfo etyInfo = col.get(i);
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
					newBoaInfo.setAssoBusObjType("19A0BB9D");// ����ҵ���������ͣ�
																// ԭ�Ͷ�֤��¼BOSTYPE
					boaFac.addnew(newBoaInfo);
				}
			}
			// ɾ��ԭ�и���
			boaFac.delete(filter);
		}
		//--------------------��д��¼�ֶ�--------------------------------------------
		// --------
		int count = this.kdtEntrys.getRowCount3();
		for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("oldEtyId").getValue() != null) {
				WorkPmtEntryInfo etyInfo = WorkPmtEntryFactory.getRemoteInstance().getWorkPmtEntryInfo(new ObjectUuidPK(row.getCell("oldEtyId").getValue().toString()));
				SelectorItemCollection sic = new SelectorItemCollection();
				// ��ע remark
				if (row.getCell("remark").getValue() != null) {
					etyInfo.setRemark((String) row.getCell("remark").getValue());
				} else {
					etyInfo.setRemark(null);
				}
				// �밢ʱ�� immiTime
				if (row.getCell("immiTime").getValue() != null) {
					etyInfo.setImmiTime((Date) row.getCell("immiTime").getValue());
				} else {
					etyInfo.setImmiTime(null);
				}
				// �Ͷ�֤���ϵݽ�ʱ�� papSTime
				if (row.getCell("papSTime").getValue() != null) {
					etyInfo.setPapSTime((Date) row.getCell("papSTime").getValue());
				} else {
					etyInfo.setPapSTime(null);
				}
				// �Ͷ�֤���� pType
				if (row.getCell("pType").getValue() != null) {
					etyInfo.setPType((DOCTYPE) row.getCell("pType").getValue());
				} else {
					etyInfo.setPType(null);
				}
				// �Ͷ�֤�� wPmtNum
				if (row.getCell("wPmtNum").getValue() != null) {
					etyInfo.setWPmtNum((String) row.getCell("wPmtNum").getValue());
				} else {
					etyInfo.setWPmtNum(null);
				}
				// �Ͷ�֤��֤���� wPmtGTime
				if (row.getCell("wPmtGTime").getValue() != null) {
					etyInfo.setWPmtGTime((Date) row.getCell("wPmtGTime").getValue());
				} else {
					etyInfo.setWPmtGTime(null);
				}
				// �Ͷ�֤��Ч���� laboreffDate
				if (row.getCell("laboreffDate").getValue() != null) {
					etyInfo.setLaboreffDate((Date) row.getCell("laboreffDate").getValue());
				} else {
					etyInfo.setLaboreffDate(null);
				}
				// �Ͷ�֤�������� wPmtSTime
				if (row.getCell("wPmtSTime").getValue() != null) {
					etyInfo.setWPmtSTime((Date) row.getCell("wPmtSTime").getValue());
				} else {
					etyInfo.setWPmtSTime(null);
				}
				// �Ͷ�֤����ǩ�ռ��ҿ��� sPAfPerson
				if (row.getCell("sPAfPerson").getValue().equals(true)) {
					etyInfo.setSPAfPerson(true);
				} else {
					etyInfo.setSPAfPerson(false);
				}
				// �Ƿ�δ�������뾳 departure
				if (row.getCell("departure").getValue().equals(true)) {
					etyInfo.setDeparture(true);
				} else {
					etyInfo.setDeparture(false);
				}
				// �Ƿ�ͣ�� isStop
				if (row.getCell("isStop").getValue().equals(true)) {
					etyInfo.setIsStop(true);
				} else {
					etyInfo.setIsStop(false);
				}
				// ͣ��ʱ�� endTime
				if (row.getCell("endTime").getValue() != null) {
					etyInfo.setEndTime((Date) row.getCell("endTime").getValue());
				} else {
					etyInfo.setEndTime(null);
				}
				// ͣ������ cancelReson
				if (row.getCell("cancelReson").getValue() != null) {
					etyInfo.setCancelReson((String) row.getCell("cancelReson").getValue());
				} else {
					etyInfo.setCancelReson(null);
				}
				// ������Ŀ workOrg
				if (row.getCell("workOrg").getValue() != null) {
					AdminOrgUnitInfo workOrg = (AdminOrgUnitInfo) row.getCell("workOrg").getValue();
					AdminOrgUnitInfo workOrgInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(workOrg.getId()));
					etyInfo.setWorkOrg(workOrgInfo);
				} else {
					etyInfo.setWorkOrg(null);
				}
				sic.add("remark");
				sic.add("immiTime");
				sic.add("papSTime");
				sic.add("pType");
				sic.add("wPmtNum");
				sic.add("wPmtGTime");
				sic.add("laboreffDate");
				sic.add("wPmtSTime");
				sic.add("sPAfPerson");
				sic.add("departure");
				sic.add("isStop");
				sic.add("endTime");
				sic.add("cancelReson");
				sic.add("workOrg");
				WorkPmtEntryFactory.getRemoteInstance().updatePartial(etyInfo, sic);
			}
		}
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
			WorkPmtEntryCollection antiCol = WorkPmtEntryFactory.getRemoteInstance().getWorkPmtEntryCollection(view);
			for (int j = 0; j < antiCol.size(); j++) {
				WorkPmtInfo antiInfo = antiCol.get(j).getParent();
				antiInfo.setBillSate(BillStateEnum.SUBMIT);
				WorkPmtFactory.getRemoteInstance().updatePartial(antiInfo, sic);
			}
		}
		checkDstry();
		super.doBeforeSubmit(e);
	}

	// 2016-11-08 zxh
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
					MsgBox.showInfo("������" + row.getCell("immiTime").getValue() + "�����밢ʱ��Ϊ�գ��޷��ύ�����������룡");
					this.abort();
				}
				if (row.getCell("papSTime").getValue() == null) {
					MsgBox.showInfo("������" + row.getCell("papSTime").getValue() + "�����Ͷ�֤���ϵݽ�ʱ��Ϊ�գ��޷��ύ�����������룡");
					this.abort();
				}
				if (row.getCell("pType").getValue() == null) {
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
				if (sPAfPerson) {
					sPAfPersonCount++;
				}
				if (row.getCell("papSTime").getValue() != null && row.getCell("immiTime").getValue() != null) {
					Date papSTime = (Date) row.getCell("papSTime").getValue();
					Date immiTime = (Date) row.getCell("immiTime").getValue();
					if (papSTime.compareTo(immiTime) < 0) {
						MsgBox.showInfo("��ѡ���Ͷ�֤���ϵݽ�ʱ��С���밢ʱ�䣬�޷��ύ���������������ڣ�");
						this.abort();
					}
				}
				// �Ͷ�֤��֤����>=�Ͷ�֤���ϵݽ�ʱ��
				if (row.getCell("wPmtGTime").getValue() != null && row.getCell("papSTime").getValue() != null) {
					Date wPmtGTime = (Date) row.getCell("wPmtGTime").getValue();
					Date papSTime = (Date) row.getCell("papSTime").getValue();
					if (wPmtGTime.before(papSTime)) {
						MsgBox.showInfo("��ѡ���Ͷ�֤��֤����С���Ͷ�֤���ϵݽ�ʱ�䣬�޷��ύ���������������ڣ�");
						this.abort();
					}
				}
				// �Ͷ�֤��Ч����>�밢ʱ��
				if (row.getCell("laboreffDate").getValue() != null && row.getCell("immiTime").getValue() != null) {
					Date laboreffDate = (Date) row.getCell("laboreffDate").getValue();
					Date immiTime = (Date) row.getCell("immiTime").getValue();
					// long
					// time=(laboreffDate.getTime()-immiTime.getTime())/86400000
					// ;
					if (laboreffDate.compareTo(immiTime) < 0) {
						MsgBox.showInfo("��ѡ���Ͷ�֤��Ч����С���밢ʱ�䣬�޷��ύ���������������ڣ�");
						this.abort();
					}
				}
				// �Ͷ�֤��������>�Ͷ�֤��Чʱ��
				if (row.getCell("wPmtSTime").getValue() != null && row.getCell("laboreffDate").getValue() != null) {
					Date wPmtSTime = (Date) row.getCell("wPmtSTime").getValue();
					Date laboreffDate = (Date) row.getCell("laboreffDate").getValue();
					// long
					// time=(wPmtSTime.getTime()-laboreffDate.getTime())/86400000
					// ;
					if (wPmtSTime.compareTo(laboreffDate) <= 0) {
						MsgBox.showInfo("��ѡ���Ͷ�֤��������С�ڵ����Ͷ�֤��Чʱ�䣬�޷��ύ���������������ڣ�");
						this.abort();
					}
				}
				// �Ͷ�֤��������>�Ͷ�֤��֤ʱ��
				if (row.getCell("wPmtSTime").getValue() != null && row.getCell("wPmtGTime").getValue() != null) {
					Date wPmtSTime = (Date) row.getCell("wPmtSTime").getValue();
					Date wPmtGTime = (Date) row.getCell("wPmtGTime").getValue();
					// long
					// time=(wPmtSTime.getTime()-wPmtGTime.getTime())/86400000;
					if (wPmtSTime.compareTo(wPmtGTime) <= 0) {
						MsgBox.showInfo("��ѡ���Ͷ�֤��������С�ڵ����Ͷ�֤��֤ʱ�� ���޷��ύ���������������ڣ�");
						this.abort();
					}
				}
			}

			if (departure && isStop) {
				MsgBox.showInfo("�Ƿ��뾳���Ƿ�ͣ�첻��ͬʱ��ѡ�����������룡");
				this.abort();
			}
			if (isStop) {
				if (row.getCell("immiTime").getValue() == null) {
					MsgBox.showInfo("������" + row.getCell("name").getValue() + "�����밢ʱ��Ϊ�գ��޷��ύ�����������룡");
					this.abort();
				}
				if (row.getCell("papSTime").getValue() == null) {
					MsgBox.showInfo("��ѡͣ�죬�Ͷ�֤���ϵݽ�ʱ�䲻��Ϊ�գ�");
					this.abort();
				}
				if (row.getCell("endTime").getValue() == null) {
					MsgBox.showInfo("��ѡ�Ƿ�ͣ�죬������ͣ��ע��ʱ�䣡");
					this.abort();
				}
				if (row.getCell("cancelReson").getValue() == null) {
					MsgBox.showInfo("��ѡ�Ƿ�ͣ�죬������ͣ�����ɣ�");
					this.abort();
				}
				// ͣ��ע��ʱ��>�Ͷ�֤���ϵݽ�ʱ��
				Date papSTime = (Date) row.getCell("papSTime").getValue();
				papSTime = sdf.parse(sdf.format(papSTime));
				Date endTime = (Date) row.getCell("endTime").getValue();
				endTime = sdf.parse(sdf.format(endTime));
				if (endTime.compareTo(papSTime) <= 0) {
					MsgBox.showInfo("ͣ��ע��ʱ��С�ڵ����Ͷ�֤���ϵݽ�ʱ�䣬�޷��ύ���������������ڣ�");
					this.abort();
				}
				if (sPAfPerson) {
					MsgBox.showInfo("������" + row.getCell("name").getValue() + "����ͣ�죬��Ӧ��ѡ�Ͷ�֤����ǩ�ռ��ҿ��ˣ�");
					this.abort();
				}
				departureCount++;
			}
			if (departure) {
				if (row.getCell("immiTime").getValue() == null) {
					MsgBox.showInfo("������" + row.getCell("name").getValue() + "�����밢ʱ��Ϊ�գ��޷��ύ�����������룡");
					this.abort();
				}
				if (sPAfPerson) {
					MsgBox.showInfo("������" + row.getCell("name").getValue() + "�����뾳����Ӧ��ѡ�Ͷ�֤����ǩ�ռ��ҿ��ˣ�");
					this.abort();
				}
				departureCount++;
			}
		}
		// ��ȫͣ���ȫ�뾳����Ӧ�����˹�ѡ������Ӧֻ��һ���˹�ѡ
		if (rowCount != departureCount) {
			if (sPAfPersonCount != 1) {
				MsgBox.showInfo("�Ͷ�֤����ǩ�ռ��ҿ��˱����ҽ��ɹ�ѡһ�ˣ�");
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
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception {
		return com.kingdee.eas.zjlw.certificates.WorkPmtECFactory.getRemoteInstance();
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
		com.kingdee.eas.zjlw.certificates.WorkPmtECInfo objectValue = new com.kingdee.eas.zjlw.certificates.WorkPmtECInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

}