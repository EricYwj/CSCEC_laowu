/**
 * output package name
 */
package com.kingdee.eas.zjlw.social.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;

import com.kingdee.eas.util.client.MsgBox;

import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;

import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryFactory;
import com.kingdee.eas.zjlw.social.ForiPayrollInfo;
import com.kingdee.eas.zjlw.social.ForiPersEntryFactory;
import com.kingdee.eas.zjlw.social.ForiPersEntryInfo;
import com.kingdee.eas.zjlw.social.InsurePersonEntryCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryFactory;
import com.kingdee.eas.zjlw.social.InsurePersonEntryInfo;
import com.kingdee.eas.zjlw.social.ProjBWREtyFactory;
import com.kingdee.eas.zjlw.social.ProjBWREtyInfo;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class ProjBWREtyEditUI extends AbstractProjBWREtyEditUI {
	private static final Logger logger = CoreUIObject
			.getLogger(ProjBWREtyEditUI.class);

	/**
	 * output class constructor
	 */

	public ProjBWREtyEditUI() throws Exception {
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

	protected void prmtprojName_dataChanged(DataChangeEvent e) throws Exception {
		super.prmtprojName_dataChanged(e);
		AdminOrgUnitInfo proj = (AdminOrgUnitInfo) this.prmtprojName.getValue();
		if (proj != null) {
			FilterInfo filter = new FilterInfo();
			EntityViewInfo view = new EntityViewInfo();
			SelectorItemCollection sic = new SelectorItemCollection();
			filter.getFilterItems().add(new FilterItemInfo("proCom.id", proj == null ? null : proj.getId()));
			// sic.add("nameFR");
			sic.add("insuranceAcc");
			view.setFilter(filter);
			view.setSelector(sic);
			ProjectOrgInfo projInfo = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view).get(0);
			if (projInfo == null) {
				MsgBox.showInfo("��ѡ��Ŀδ����������Ϣ��������ѡ��");
				// this.prmtprojName.setValue(null);
				this.txtprojSoclNum.setText("");
				abort();
			}
			this.txtprojSoclNum.setText(projInfo.getInsuranceAcc());
		}

	}

	public void onLoad() throws Exception {
		super.onLoad();
		setButtonStatus();
		// ��ʼ������
		if (getOprtState().equals("ADDNEW")) {
			this.pkBizDate.setValue(new Date());
		}
		this.kdtEntrys.getColumn("hourWage").getStyleAttributes().setNumberFormat("###,###,##0.00");
		this.kdtEntrys.getColumn("personCredits").getStyleAttributes().setNumberFormat("###,###,##0.00");
	}
	 protected void setButtonStatus() {
			ProjBWREtyInfo bill;
			if ("VIEW".equals(getOprtState())) {
//				this.actionAudit.setVisible(true);
//				this.actionUnAudit.setVisible(true);
//				this.actionAudit.setEnabled(true);
//				this.actionUnAudit.setEnabled(true);
				bill = (ProjBWREtyInfo) this.editData;
				if (this.editData != null) {
					if (BillStateEnum.CHECKED.equals(bill.getBillSate())) {// (BillStateEnum.SIGNE.equals(bill.getBillSate()))
//						this.actionUnAudit.setEnabled(true);
//						this.actionAudit.setVisible(false);
//						this.actionAudit.setEnabled(false);
						this.actionEdit.setEnabled(false);
						this.actionRemove.setEnabled(false);
					} else {
//						this.actionUnAudit.setVisible(false);
//						this.actionUnAudit.setEnabled(false);
//						this.actionAudit.setVisible(true);
//						this.actionAudit.setEnabled(true);
						this.actionRemove.setEnabled(true);
						this.actionEdit.setEnabled(true);
					}
				}
				this.actionAddLine.setEnabled(false);
				this.actionRemoveLine.setEnabled(false);
				this.actionInsertLine.setEnabled(false);
			} else {
				bill = (ProjBWREtyInfo) this.editData;
				if (("EDIT".equals(getOprtState())) && (this.editData != null)&& (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
					this.actionSave.setEnabled(true);
				}
//				this.actionAudit.setVisible(false);
//				this.actionUnAudit.setVisible(false);
//				this.actionAudit.setEnabled(false);
//				this.actionUnAudit.setEnabled(false);
			}
			if (((BillStateEnum.CHECKED.equals(bill.getBillSate())))|| ("ADDNEW".equalsIgnoreCase(getOprtState()))) {//(this.editData != null)
				this.actionPrint.setEnabled(false);
				this.actionPrintPreview.setEnabled(false);
				this.actionAttachment.setEnabled(false);
			} else {
				this.actionPrint.setEnabled(true);
				this.actionPrintPreview.setEnabled(true);
				this.actionAttachment.setEnabled(true);
			}
			if (this.editData != null) {
		        bill = (ProjBWREtyInfo) this.editData;
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
			if ((columnNameSet.contains(key))
					&& (((oldValue == newValue || 0 == EcClientHelper
							.compareValue(oldValue, newValue))))) {
				return;
			}
		}
		afterEditStopped(tblDetail, oldValue, newValue, colIndex, rowIndex);

	}

	protected void afterEditStopped(KDTable table, Object oldValue,
			Object newValue, int colIndex, int rowIndex) throws Exception {
		String key = table.getColumn(colIndex).getKey();
		IRow row = table.getRow(rowIndex);
		if ("personSoclNum".equals(key)) {
			String personSoclNum = (String) row.getCell("personSoclNum")
					.getValue();
			BigDecimal base = new BigDecimal("173.00");
			if (personSoclNum != null) {
				FilterInfo filter = new FilterInfo();
				// FilterInfo filter = new FilterInfo();
				EntityViewInfo view = new EntityViewInfo();
				// EntityViewInfo view2 = new EntityViewInfo();
				Set soclId = new HashSet();
				filter.getFilterItems().add(new FilterItemInfo("securityNo", personSoclNum,CompareType.EQUALS));
				view.setFilter(filter);
				InsurePersonEntryInfo ipInfo = (InsurePersonEntryInfo) InsurePersonEntryFactory.getRemoteInstance().getInsurePersonEntryCollection(view).get(0);
				ForiPersEntryInfo fpInfo = (ForiPersEntryInfo) ForiPersEntryFactory.getRemoteInstance().getForiPersEntryCollection(view).get(0);
				if (ipInfo != null) {
					row.getCell("lastName").setValue(ipInfo.getLastName());// ��
					row.getCell("firstName").setValue(ipInfo.getFirstName());// ��
					row.getCell("birthDate").setValue(ipInfo.getBirthdate());// ��������
					ProjSecuProfInfo pspInfo = ipInfo.getSecuProf() == null ? null: ProjSecuProfFactory.getRemoteInstance().getProjSecuProfInfo(new ObjectUuidPK(ipInfo.getSecuProf().getId()));
					row.getCell("socialJobs").setValue(pspInfo);// �籣����
					row.getCell("arrivalDate").setValue(ipInfo.getApproachTime());// ��������
					row.getCell("hourWage").setValue(EcClientHelper.toBigDecimal(ipInfo.getNBasePay()).divide(base, 2, 4));
					AdminOrgUnitInfo cooperCode = ipInfo.getCooperationId() == null ? null: AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(ipInfo.getCooperation().getId()));
					row.getCell("cooperCode").setValue(cooperCode);// ������λ����
					AdminOrgUnitInfo cooperation = ipInfo.getCooperation() == null ? null: AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(ipInfo.getCooperation().getId()));
					row.getCell("cooperation").setValue(cooperation);// ������λ
				} else if (fpInfo != null) {
					row.getCell("lastName").setValue(fpInfo.getFirstNameApl());// ��getLastNameApl
					row.getCell("firstName").setValue(fpInfo.getLastNameApl());// ��getFirstNameApl
					row.getCell("birthDate").setValue(fpInfo.getBirthdate());// ��������
					ProjSecuProfInfo pspInfo = fpInfo.getSecuProf() == null ? null: ProjSecuProfFactory.getRemoteInstance().getProjSecuProfInfo(new ObjectUuidPK(fpInfo.getSecuProf().getId()));
					row.getCell("socialJobs").setValue(pspInfo);// �籣����
					row.getCell("arrivalDate").setValue(fpInfo.getApproachTime());// ��������
					row.getCell("hourWage").setValue(EcClientHelper.toBigDecimal(fpInfo.getNBasePay()).divide(base, 2, 4));
					AdminOrgUnitInfo cooperCode = fpInfo.getCooperationId() == null ? null: AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(fpInfo.getCooperation().getId()));
					row.getCell("cooperCode").setValue(cooperCode);// ������λ����
					AdminOrgUnitInfo cooperation = fpInfo.getCooperation() == null ? null: AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(fpInfo.getCooperation().getId()));
					row.getCell("cooperation").setValue(cooperation);// ������λ
				} else {
					row.getCell("lastName").setValue(null);// ��
					row.getCell("firstName").setValue(null);// ��
					row.getCell("birthDate").setValue(null);// ��������
					row.getCell("socialJobs").setValue(null);// �籣����
					row.getCell("arrivalDate").setValue(null);// ��������
					row.getCell("hourWage").setValue(BigDecimal.ZERO);
					row.getCell("cooperCode").setValue(null);
					row.getCell("cooperation").setValue(null);
				}
			} else {
				row.getCell("lastName").setValue(null);// ��
				row.getCell("firstName").setValue(null);// ��
				row.getCell("birthDate").setValue(null);// ��������
				// AdminOrgUnitInfo secuProf =
				// ipInfo.getSecuProf()==null?null:AdminOrgUnitFactory
				// .getRemoteInstance().getAdminOrgUnitInfo(new
				// ObjectUuidPK(ipInfo.getWorkProgram().getId()));;
				row.getCell("socialJobs").setValue(null);// �籣����
				row.getCell("arrivalDate").setValue(null);// ��������
				row.getCell("hourWage").setValue(BigDecimal.ZERO);
				row.getCell("cooperCode").setValue(null);
				row.getCell("cooperation").setValue(null);
			}
		}
		if("socialJobs".equals(key)){
			ProjSecuProfInfo socialJobs=(ProjSecuProfInfo) row.getCell("socialJobs").getValue();
			if(socialJobs!=null){
				BigDecimal pay=new BigDecimal(173);
				BigDecimal basePay= socialJobs.getBasePay();
				if(basePay!=null){
					row.getCell("hourWage").setValue(EcClientHelper.toBigDecimal(basePay.divide(pay, 2, 4)));
				}
				
			}
			
		}
	}

	/**
	 * output btnAddLine_actionPerformed method
	 */
	protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e)
			throws Exception {
		super.btnAddLine_actionPerformed(e);
	}

	/**
	 * output menuItemEnterToNextRow_itemStateChanged method
	 */
	protected void menuItemEnterToNextRow_itemStateChanged(
			java.awt.event.ItemEvent e) throws Exception {
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
	public void actionExitCurrent_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionSendMessage_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionSendMessage_actionPerformed(e);
	}

	/**
	 * output actionCalculator_actionPerformed
	 */
	public void actionCalculator_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionExportSelected_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExportSelected_actionPerformed(e);
	}

	/**
	 * output actionRegProduct_actionPerformed
	 */
	public void actionRegProduct_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionRegProduct_actionPerformed(e);
	}

	/**
	 * output actionPersonalSite_actionPerformed
	 */
	public void actionPersonalSite_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionPersonalSite_actionPerformed(e);
	}

	/**
	 * output actionProcductVal_actionPerformed
	 */
	public void actionProcductVal_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionProcductVal_actionPerformed(e);
	}

	/**
	 * output actionExportSave_actionPerformed
	 */
	public void actionExportSave_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExportSave_actionPerformed(e);
	}

	/**
	 * output actionExportSelectedSave_actionPerformed
	 */
	public void actionExportSelectedSave_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionRemoteAssist_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionHTMLForMail_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionHTMLForMail_actionPerformed(e);
	}

	/**
	 * output actionExcelForMail_actionPerformed
	 */
	public void actionExcelForMail_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExcelForMail_actionPerformed(e);
	}

	/**
	 * output actionHTMLForRpt_actionPerformed
	 */
	public void actionHTMLForRpt_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionHTMLForRpt_actionPerformed(e);
	}

	/**
	 * output actionExcelForRpt_actionPerformed
	 */
	public void actionExcelForRpt_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExcelForRpt_actionPerformed(e);
	}

	/**
	 * output actionLinkForRpt_actionPerformed
	 */
	public void actionLinkForRpt_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionLinkForRpt_actionPerformed(e);
	}

	/**
	 * output actionPopupPaste_actionPerformed
	 */
	public void actionPopupPaste_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionPopupPaste_actionPerformed(e);
	}

	/**
	 * output actionToolBarCustom_actionPerformed
	 */
	public void actionToolBarCustom_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionCloudShare_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionCloudShare_actionPerformed(e);
	}

	/**
	 * output actionCloudScreen_actionPerformed
	 */
	public void actionCloudScreen_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionCloudScreen_actionPerformed(e);
	}

	/**
	 * output actionXunTongFeed_actionPerformed
	 */
	public void actionXunTongFeed_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionXunTongFeed_actionPerformed(e);
	}
	/**
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		super.actionSave_actionPerformed(e);
		checkNum();
	}
	protected void checkNum() throws EASBizException, BOSException{
		int  rowCount=this.kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			IRow row=this.kdtEntrys.getRow(i);
			if (!row.getCell("personSoclNum").getValue().equals("")||row.getCell("personSoclNum").getValue()!=null) {
				String personSoclNum = (String) row.getCell("personSoclNum").getValue();
				BigDecimal base = new BigDecimal("173.00");
				if (personSoclNum != null) {
					FilterInfo filter = new FilterInfo();
					// FilterInfo filter = new FilterInfo();
					EntityViewInfo view = new EntityViewInfo();
					// EntityViewInfo view2 = new EntityViewInfo();
					Set soclId = new HashSet();
					filter.getFilterItems().add(new FilterItemInfo("securityNo", personSoclNum,CompareType.EQUALS));
					view.setFilter(filter);
					InsurePersonEntryInfo ipInfo = (InsurePersonEntryInfo) InsurePersonEntryFactory.getRemoteInstance().getInsurePersonEntryCollection(view).get(0);
					ForiPersEntryInfo fpInfo = (ForiPersEntryInfo) ForiPersEntryFactory.getRemoteInstance().getForiPersEntryCollection(view).get(0);
					if (ipInfo != null) {
						row.getCell("lastName").setValue(ipInfo.getLastName());// ��
						row.getCell("firstName").setValue(ipInfo.getFirstName());// ��
						row.getCell("birthDate").setValue(ipInfo.getBirthdate());// ��������
						ProjSecuProfInfo pspInfo = ipInfo.getSecuProf() == null ? null: ProjSecuProfFactory.getRemoteInstance().getProjSecuProfInfo(new ObjectUuidPK(ipInfo.getSecuProf().getId()));
						row.getCell("socialJobs").setValue(pspInfo);// �籣����
						row.getCell("arrivalDate").setValue(ipInfo.getApproachTime());// ��������
						row.getCell("hourWage").setValue(EcClientHelper.toBigDecimal(ipInfo.getNBasePay()).divide(base, 2, 4));
						AdminOrgUnitInfo cooperCode = ipInfo.getCooperationId() == null ? null: AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(ipInfo.getCooperation().getId()));
						row.getCell("cooperCode").setValue(cooperCode);// ������λ����
						AdminOrgUnitInfo cooperation = ipInfo.getCooperation() == null ? null: AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(ipInfo.getCooperation().getId()));
						row.getCell("cooperation").setValue(cooperation);// ������λ
					} else if (fpInfo != null) {
						row.getCell("lastName").setValue(fpInfo.getFirstNameApl());// ��getLastNameApl
						row.getCell("firstName").setValue(fpInfo.getLastNameApl());// ��getFirstNameApl
						row.getCell("birthDate").setValue(fpInfo.getBirthdate());// ��������
						ProjSecuProfInfo pspInfo = fpInfo.getSecuProf() == null ? null: ProjSecuProfFactory.getRemoteInstance().getProjSecuProfInfo(new ObjectUuidPK(fpInfo.getSecuProf().getId()));
						row.getCell("socialJobs").setValue(pspInfo);// �籣����
						row.getCell("arrivalDate").setValue(fpInfo.getApproachTime());// ��������
						row.getCell("hourWage").setValue(EcClientHelper.toBigDecimal(fpInfo.getNBasePay()).divide(base, 2, 4));
						AdminOrgUnitInfo cooperCode = fpInfo.getCooperationId() == null ? null: AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(fpInfo.getCooperation().getId()));
						row.getCell("cooperCode").setValue(cooperCode);// ������λ����
						AdminOrgUnitInfo cooperation = fpInfo.getCooperation() == null ? null: AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(fpInfo.getCooperation().getId()));
						row.getCell("cooperation").setValue(cooperation);// ������λ
					} else {
						row.getCell("lastName").setValue(null);// ��
						row.getCell("firstName").setValue(null);// ��
						row.getCell("birthDate").setValue(null);// ��������
						row.getCell("socialJobs").setValue(null);// �籣����
						row.getCell("arrivalDate").setValue(null);// ��������
						row.getCell("hourWage").setValue(BigDecimal.ZERO);
						row.getCell("cooperCode").setValue(null);
						row.getCell("cooperation").setValue(null);
					}
				} else {
					row.getCell("lastName").setValue(null);// ��
					row.getCell("firstName").setValue(null);// ��
					row.getCell("birthDate").setValue(null);// ��������
					// AdminOrgUnitInfo secuProf =
					// ipInfo.getSecuProf()==null?null:AdminOrgUnitFactory
					// .getRemoteInstance().getAdminOrgUnitInfo(new
					// ObjectUuidPK(ipInfo.getWorkProgram().getId()));;
					row.getCell("socialJobs").setValue(null);// �籣����
					row.getCell("arrivalDate").setValue(null);// ��������
					row.getCell("hourWage").setValue(BigDecimal.ZERO);
					row.getCell("cooperCode").setValue(null);
					row.getCell("cooperation").setValue(null);
				}
			}
			if(!row.getCell("socialJobs").getValue().equals("")||row.getCell("personSoclNum").getValue()!=null){
				ProjSecuProfInfo socialJobs=(ProjSecuProfInfo) row.getCell("socialJobs").getValue();
				if(socialJobs!=null){
					BigDecimal pay=new BigDecimal(173);
					BigDecimal basePay= socialJobs.getBasePay();
					if(basePay!=null){
						row.getCell("hourWage").setValue(EcClientHelper.toBigDecimal(basePay.divide(pay, 2, 4)));
					}
					
				}
				
			}
			
		}
	}

	protected void doBeforeSave(ActionEvent e) throws Exception {
		super.doBeforeSave(e);
		// checkIdNumAndPassp();//����ͬһ�����ظ�У��
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
	}

	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		super.doBeforeSubmit(e);
		checkIdNumAndPassp();// �ύͬһ�����ظ�У��
	}

	// �ύͬһ�����ظ�У��
	public void checkIdNumAndPassp() throws BOSException {
		AdminOrgUnitInfo proj = (AdminOrgUnitInfo) this.prmtprojName.getValue();// �籣��Ŀ
		Date retToWorkDate = (Date) this.pkretToWorkDate.getValue();// ��������
		Date stopDate = (Date) this.pkstopDate.getValue();// ͣ������
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		BigDecimal downTimeHours = this.txtdownTimeHours.getBigDecimalValue();// ͣ��Сʱ
		String stoppageBy = this.txtstoppageBy.getText();// ͣ������
		if (proj == null) {
			MsgBox.showInfo("�籣��ĿΪ���޷��ύ���޷��ύ�����������룡");
			abort();
		}
		if (retToWorkDate == null) {
			MsgBox.showInfo("��������Ϊ�գ��޷��ύ�����������룡");
			abort();
		}
		if (stopDate == null) {
			MsgBox.showInfo("ͣ������Ϊ�գ��޷��ύ�����������룡");
			abort();
		}
		if(retToWorkDate!=null&&stopDate!=null){
			if(retToWorkDate.compareTo(stopDate)<=0){
				MsgBox.showInfo("��������Ӧ����ͣ������Ϊ�գ��޷��ύ�����������룡");
				abort();
			}
		}
		if (downTimeHours==null||downTimeHours.compareTo(BigDecimal.ZERO)==0) {
			MsgBox.showInfo("ͣ��СʱΪ�գ��޷��ύ�����������룡");
			this.txtdownTimeHours.setValue(new BigDecimal("0"));
			abort();
		}
		if (stoppageBy == null || "".equals(this.txtstoppageBy.getText())) {
			MsgBox.showInfo("ͣ������Ϊ�գ��޷��ύ�����������룡");
			abort();
		}
		int rowCount = kdtEntrys.getRowCount();
		Set pass = new HashSet();
		for (int i = 0; i < rowCount; i++) {
			IRow row = kdtEntrys.getRow(i);
			String personSoclNum = (String) row.getCell("personSoclNum").getValue();
			BigDecimal personCredits = (BigDecimal) row.getCell("personCredits").getValue();
			if (personCredits == null) {
				MsgBox.showInfo("���˷������Ϊ�գ��޷��ύ�����������룡");
				abort();
			}
			if (personSoclNum == null) {
				MsgBox.showInfo("�籣��Ϊ�գ��޷��ύ�����������룡");
				abort();
			}
			if (personSoclNum != null) {
				// У���Ƿ���ڼ�����,������ڣ�ɾ�������е��������ݣ�����true
				if (pass.remove(personSoclNum)) {
					MsgBox.showInfo("�籣�š�" + personSoclNum+ "���Ѵ��ڴ��籣�����ݣ����������룡");
					abort();
				}
			}
			pass.add(personSoclNum);
		}
	}

	// public void checkPersion(IRow row) throws BOSException{
	//		     
	// EntityViewInfo view = new EntityViewInfo();
	// FilterInfo filter = new FilterInfo();
	// view.setFilter(filter);
	// filter.getFilterItems().add(new FilterItemInfo("personSoclNum",
	// row.getCell("personSoclNum").getValue(),CompareType.EQUALS));
	// WorkVisaEntryCollection
	// col=WorkVisaEntryFactory.getRemoteInstance().getWorkVisaEntryCollection
	// (view);
	// if (col != null && col.size() > 0) {
	// MsgBox.showInfo("������Ա��" + row.getCell("name").getValue() +
	// "���Ļ��պ��Ѵ��ڣ������ظ�¼�� ��");
	// this.abort();
	// }
	// }

	/**
	 * output actionCancel_actionPerformed
	 */
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		super.actionCancel_actionPerformed(e);
	}

	/**
	 * output actionCancelCancel_actionPerformed
	 */
	public void actionCancelCancel_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionPrintPreview_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionAttachment_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionAttachment_actionPerformed(e);
	}

	/**
	 * output actionSubmitOption_actionPerformed
	 */
	public void actionSubmitOption_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionInsertLine_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionInsertLine_actionPerformed(e);
	}

	/**
	 * output actionRemoveLine_actionPerformed
	 */
	public void actionRemoveLine_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionRemoveLine_actionPerformed(e);
	}

	/**
	 * output actionCreateFrom_actionPerformed
	 */
	public void actionCreateFrom_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionAuditResult_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionViewSubmitProccess_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionViewSubmitProccess_actionPerformed(e);
	}

	/**
	 * output actionViewDoProccess_actionPerformed
	 */
	public void actionViewDoProccess_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionViewDoProccess_actionPerformed(e);
	}

	/**
	 * output actionMultiapprove_actionPerformed
	 */
	public void actionMultiapprove_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionMultiapprove_actionPerformed(e);
	}

	/**
	 * output actionNextPerson_actionPerformed
	 */
	public void actionNextPerson_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionNextPerson_actionPerformed(e);
	}

	/**
	 * output actionStartWorkFlow_actionPerformed
	 */
	public void actionStartWorkFlow_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionDelVoucher_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionSendingMessage_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionWorkflowList_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionWorkflowList_actionPerformed(e);
	}

	/**
	 * output actionViewSignature_actionPerformed
	 */
	public void actionViewSignature_actionPerformed(ActionEvent e)
			throws Exception {
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
	public void actionNumberSign_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionNumberSign_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface()
			throws Exception {
		return com.kingdee.eas.zjlw.social.ProjBWREtyFactory
				.getRemoteInstance();
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
		com.kingdee.eas.zjlw.social.ProjBWREtyInfo objectValue = new com.kingdee.eas.zjlw.social.ProjBWREtyInfo();
		objectValue
				.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext
						.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		return objectValue;
	}

}