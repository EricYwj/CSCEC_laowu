/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
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
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoInfo;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.ExLivepermitECEntryCollection;
import com.kingdee.eas.zjlw.certificates.ExLivepermitECEntryInfo;
import com.kingdee.eas.zjlw.certificates.ExLivepermitECFactory;
import com.kingdee.eas.zjlw.certificates.ExLivepermitECInfo;
import com.kingdee.eas.zjlw.certificates.ExLivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.ExLivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.ExLivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.ExLivepermitFactory;
import com.kingdee.eas.zjlw.certificates.ExLivepermitInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitECEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitECEntryInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitECFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitECInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.UplivePermitFactory;
import com.kingdee.eas.zjlw.certificates.UplivePermitInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class ExLivepermitECEditUI extends AbstractExLivepermitECEditUI {
	private static final Logger logger = CoreUIObject.getLogger(ExLivepermitECEditUI.class);

	/**
	 * output class constructor
	 */
	public ExLivepermitECEditUI() throws Exception {
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

	// 2016-11-24 zxh
	public void onLoad() throws Exception {
		this.billSate.setEnabled(false);
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
		btnAudit.setVisible(false);
		btnUnAudit.setVisible(false);
		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
		this.billSate.setEditable(false);
		if (getUIContext().get("BOTPViewStatus") != null) {
			this.btnSubmit.setVisible(false);
			// 显示
			kdtEntrys.getColumn("lastName").getStyleAttributes().setHided(true);// 姓拼音
			kdtEntrys.getColumn("firstName").getStyleAttributes().setHided(true);// 名拼音
			kdtEntrys.getColumn("birthPlace").getStyleAttributes().setHided(true);// 出生地（中文）
			kdtEntrys.getColumn("birthPlaceFr").getStyleAttributes().setHided(true);// 出生地（拼音）
			kdtEntrys.getColumn("laboreffDate").getStyleAttributes().setHided(true);// 劳动证生效日期
			kdtEntrys.getColumn("rePmtTrnDate").getStyleAttributes().setHided(true);// 收到居住证调出令时间
			kdtEntrys.getColumn("pmtTrnDate").getStyleAttributes().setHided(true);// 居住证调入完成时间
			// 锁定
			kdtEntrys.getColumn("pmtProj").getStyleAttributes().setLocked(false);// 新指标项目
			kdtEntrys.getColumn("HworkOrg").getStyleAttributes().setLocked(true);// 新指标项目
		}
		kdtEntrys.getColumn("name").getStyleAttributes().setLocked(true);// 姓名
		kdtEntrys.getColumn("sex").getStyleAttributes().setLocked(true);// 性别
		kdtEntrys.getColumn("birth").getStyleAttributes().setLocked(true);// 出生日期
		kdtEntrys.getColumn("IdNum").getStyleAttributes().setLocked(true);// 身份证号
		kdtEntrys.getColumn("passpNum").getStyleAttributes().setLocked(true);// 护照号
		kdtEntrys.getColumn("passpExDate").getStyleAttributes().setLocked(true);// 护照失效日期
		kdtEntrys.getColumn("immiTime").getStyleAttributes().setLocked(true);// 入境时间
		kdtEntrys.getColumn("wPmtGTime").getStyleAttributes().setLocked(true);// 劳动证出证日期
		kdtEntrys.getColumn("wPmtNum").getStyleAttributes().setLocked(true);// 劳动证号
		kdtEntrys.getColumn("wPmtSTime").getStyleAttributes().setLocked(true);// 劳动证到证日期
		kdtEntrys.getColumn("dlyChkFrc").getStyleAttributes().setLocked(true);// 报签次数
		kdtEntrys.getColumn("HpmtProj").getStyleAttributes().setLocked(true);// 原指标项目
		kdtEntrys.getColumn("HworkOrg").getStyleAttributes().setLocked(false);// 工作项目
		kdtEntrys.getColumn("HquProf").getStyleAttributes().setLocked(true);// 指标工种
		kdtEntrys.getColumn("HprmtProf").getStyleAttributes().setLocked(true);// 指标工种法文
		kdtEntrys.getColumn("cooperation").getStyleAttributes().setLocked(true);// 合作项目
		// --------------获取原单据数据------------------------------------------- 2016-11-24 zxh
		if (getOprtState().equals("ADDNEW")) {
			// 获取接受到的参数
			Map uictxMap = this.getUIContext();
			Set etys = new HashSet();
			etys = (Set) uictxMap.get("etys");
			// 遍历反签办理分录集合
			for (Object object : etys) {
				ExLivepermitEntryInfo etyInfo = (ExLivepermitEntryInfo) object;
				// 单条分录的值赋值给一行
				IRow row = this.kdtEntrys.addRow();
				row.getCell("oldEtyId").setValue(etyInfo.getId());
				row.getCell("name").setValue(etyInfo.getName());// 中文姓名
				row.getCell("lastName").setValue(etyInfo.getLastName());// 姓拼音
				row.getCell("firstName").setValue(etyInfo.getFirstName());// 名拼音
				row.getCell("sex").setValue(etyInfo.getSex());// 性别
				row.getCell("birth").setValue(etyInfo.getBirth());// 出生日期
				row.getCell("birthPlace").setValue(etyInfo.getBirthPlace());// 出生地（中文）
				row.getCell("birthPlaceFr").setValue(etyInfo.getBirthPlaceFr());// 出生地（拼音）
				row.getCell("passpNum").setValue(etyInfo.getPasspNum());// 护照号码 passpNum
				row.getCell("prmtProf").setValue(etyInfo.getPrmtProf());// 指标工种法文 prmtProf
				row.getCell("wPmtNum").setValue(etyInfo.getWPmtNum());// 劳动证号 wPmtNum
				row.getCell("laboreffDate").setValue(etyInfo.getLaboreffDate());// 劳动证生效日期 laboreffDate
				row.getCell("wPmtSTime").setValue(etyInfo.getWPmtSTime());// 劳动证到期日期 wPmtSTime
				row.getCell("docType").setValue(etyInfo.getDocType());// 居住证类型 docType
				row.getCell("rePmtNum").setValue(etyInfo.getRePmtNum());// 临时居住证号码 rePmtNum
				row.getCell("rePmtETime").setValue(etyInfo.getRePmtETime());// 临时居住证到期日期 rePmtETime
				row.getCell("pmtNum").setValue(etyInfo.getPmtNum());// 正式居住证号码 pmtNum
				row.getCell("pmtETime").setValue(etyInfo.getPmtETime());// 正式居住证到期日期 pmtETime
				row.getCell("rePmtTrnDate").setValue(etyInfo.getRePmtTrnDate());// 收到居住证调出令时间 rePmtTrnDate
				row.getCell("pmtTrnDate").setValue(etyInfo.getPmtTrnDate());// 居住证调入完成时间 pmtTrnDate
				row.getCell("isEmbassyReg").setValue(etyInfo.isIsEmbassyReg());// 是否办理使馆注册 isEmbassyReg
				row.getCell("IdNum").setValue(etyInfo.getIdNum());// 身份证号 IdNum
				row.getCell("remark").setValue(etyInfo.getRemark());// 备注 remark
				row.getCell("personID").setValue(etyInfo.getPersonID());// 人员分录id
				// 国籍 nation Country
				if (etyInfo.getNation() != null) {
					CountryInfo contryInfo = etyInfo.getNation();
					CountryInfo nation = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(contryInfo.getId()));
					row.getCell("nation").setValue(nation);
				}
				// 指标工种中文 quProf ProjectWork
				if (etyInfo.getQuProf() != null) {
					ProjectWorkInfo contryInfo = etyInfo.getQuProf();
					ProjectWorkInfo quProf = ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(contryInfo.getId()));
					row.getCell("quProf").setValue(quProf);
				}
				// 原指标项目 HpmtProj AdminOrgUnit
				if (etyInfo.getHpmtProj() != null) {
					AdminOrgUnitInfo contryInfo = etyInfo.getPmtProj();
					AdminOrgUnitInfo pmtProj = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
					row.getCell("HpmtProj").setValue(pmtProj);// 指标项目
				}
				// 指标项目 pmtProj AdminOrgUnit
				if (etyInfo.getPmtProj() != null) {
					AdminOrgUnitInfo contryInfo = etyInfo.getPmtProj();
					AdminOrgUnitInfo pmtProj = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
					row.getCell("pmtProj").setValue(pmtProj);
				}
				// 工作项目 workOrg AdminOrgUnit
				if (etyInfo.getWorkOrg() != null) {
					AdminOrgUnitInfo contryInfo = etyInfo.getWorkOrg();
					AdminOrgUnitInfo workOrg = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
					row.getCell("workOrg").setValue(workOrg);// 工作项目
				}
				// 合作单位 cooperation AdminOrgUnit
				if (etyInfo.getCooperation() != null) {
					AdminOrgUnitInfo contryInfo = etyInfo.getCooperation();
					AdminOrgUnitInfo cooperation = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
					row.getCell("cooperation").setValue(cooperation);// 合作单位
				}
			}
		}
	}

	protected void setButtonStatus() {
		ExLivepermitECInfo bill;
		if ("VIEW".equals(getOprtState())) {
			this.actionAudit.setVisible(true);
			this.actionUnAudit.setVisible(true);
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);

			bill = (ExLivepermitECInfo) this.editData;
			if (this.editData != null) {
				if (BillStateEnum.CHECKED.equals(bill.getBillSate())) {// (BillStateEnum.SIGNE.equals(bill.getBillSate()))
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
			bill = (ExLivepermitECInfo) this.editData;
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
			bill = (ExLivepermitECInfo) this.editData;
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
		// ==================================根据分录id反写原分录============================== 2016-11-08 zxh
		// --------------------反写分录附件----------------------------------------------------
		String id = this.editData.getId().toString();
		ExLivepermitECInfo info = ExLivepermitECFactory.getRemoteInstance().getExLivepermitECInfo(new ObjectUuidPK(id));
		ExLivepermitECEntryCollection col = info.getEntrys();
		for (int i = 0; i < col.size(); i++) {
			ExLivepermitECEntryInfo etyInfo = col.get(i);
			String etyId = etyInfo.getId().toString();// 先分录id
			String oldId = etyInfo.getOldEtyId().toString();// 原分录id
			// 携带附件
			IBoAttchAsso boaFac = BoAttchAssoFactory.getRemoteInstance();
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("attachment.id");
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("boID", etyId));
			view.setFilter(filter);
			view.setSelector(sic);
			// 根据现分录ID查询附件
			BoAttchAssoCollection boaCol = boaFac.getBoAttchAssoCollection(view);
			if (boaCol != null && boaCol.size() > 0) {
				for (int j = 0; j < boaCol.size(); j++) {
					BoAttchAssoInfo boaInfo = boaCol.get(j);
					// 添加附件
					BoAttchAssoInfo newBoaInfo = new BoAttchAssoInfo();
					newBoaInfo.setId(BOSUuid.create(newBoaInfo.getBOSType()));
					newBoaInfo.setBoID(oldId);// 原分录id
					newBoaInfo.setAssoType("系统已有附件");// 类型
					newBoaInfo.setAttachment(boaInfo.getAttachment());// 附件
					newBoaInfo.setAssoBusObjType("31314547");// 关联业务对象的类型：原居住证调转分录BOSTYPE
					boaFac.addnew(newBoaInfo);
				}
			}
			// 删除原有附件
			boaFac.delete(filter);
		}
		// --------------------反写分录字段----------------------------------------------------
		int count = this.kdtEntrys.getRowCount3();
		for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("oldEtyId").getValue() != null) {
				ExLivepermitEntryInfo etyInfo = ExLivepermitEntryFactory.getRemoteInstance().getExLivepermitEntryInfo(new ObjectUuidPK(row.getCell("oldEtyId").getValue().toString()));
				SelectorItemCollection sic = new SelectorItemCollection();
				// 备注 remark
				if (row.getCell("remark").getValue() != null) {
					etyInfo.setRemark((String) row.getCell("remark").getValue());
				} else {
					etyInfo.setRemark(null);
				}
				// 收到居住证调出令时间 rePmtTrnDate
				if (row.getCell("rePmtTrnDate").getValue() != null) {
					etyInfo.setRePmtTrnDate((Date) row.getCell("rePmtTrnDate").getValue());
				} else {
					etyInfo.setRePmtTrnDate(null);
				}
				// 居住证调入完成时间 pmtTrnDate
				if (row.getCell("pmtTrnDate").getValue() != null) {
					etyInfo.setPmtTrnDate((Date) row.getCell("pmtTrnDate").getValue());
				} else {
					etyInfo.setPmtTrnDate(null);
				}
				// 工作项目 workOrg AdminOrgUnit
				if (row.getCell("workOrg").getValue() != null) {
					AdminOrgUnitInfo countryInfo = (AdminOrgUnitInfo) row.getCell("workOrg").getValue();
					AdminOrgUnitInfo workOrg = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
					etyInfo.setWorkOrg(workOrg);
				} else {
					etyInfo.setWorkOrg(null);
				}
				sic.add("rePmtTrnDate");// 收到居住证调出令时间
				sic.add("pmtTrnDate");// 居住证调入完成时间
				sic.add("workOrg");// 工作项目
				sic.add("remark");// 备注
				ExLivepermitEntryFactory.getRemoteInstance().updatePartial(etyInfo, sic);
			}
		}
	}

	protected void doBeforeSave(ActionEvent e) throws Exception {
		checkEmpty();
		super.doBeforeSave(e);
	}

	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		// ----------------------反写原单据，设置单据状态为已提交------------------------------------
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
			ExLivepermitEntryCollection antiCol = ExLivepermitEntryFactory.getRemoteInstance().getExLivepermitEntryCollection(view);
			for (int j = 0; j < antiCol.size(); j++) {
				ExLivepermitInfo antiInfo = antiCol.get(j).getParent();
				antiInfo.setBillSate(BillStateEnum.SUBMIT);
				ExLivepermitFactory.getRemoteInstance().updatePartial(antiInfo, sic);
			}
		}
		super.doBeforeSubmit(e);
		checkEmpty();
		// checkPmtProfC();
		checkDate();
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
	}

	// 指标项目校验
	public void checkEmpty() throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("id");
		sic.add("sourceEntryID");
		sic.add("pmtProj.id");
		sic.add("pmtProj.name");
		sic.add("pmtProj.number");

		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("pmtProj").getValue() == null) {
				MsgBox.showInfo("姓名【" + row.getCell("name").getValue() + "】的指标项目为空，请重新填入！");
				this.abort();
			}
			if (row.getCell("sourceEntryID").getValue() != null) {
				AdminOrgUnitInfo admin = (AdminOrgUnitInfo) row.getCell("pmtProj").getValue();
				String livePerEntryID = row.getCell("sourceEntryID").getValue().toString();
				LivepermitEntryInfo lpInfo = LivepermitEntryFactory.getRemoteInstance().getLivepermitEntryInfo(new ObjectUuidPK(livePerEntryID), sic);
				String wkpmtEntryID = lpInfo.getSourceEntryID();
				WorkPmtEntryInfo wpInfo = WorkPmtEntryFactory.getRemoteInstance().getWorkPmtEntryInfo(new ObjectUuidPK(wkpmtEntryID), sic);
				if (wpInfo.getPmtProj() != null && !admin.getId().equals(wpInfo.getPmtProj().getId())) {
					MsgBox.showInfo("姓名【" + row.getCell("name").getValue() + "】的指标项目选择错误，劳动证调转后项目为【" + wpInfo.getPmtProj().getName() + "】请选择同一项目！");
					this.abort();
				}
			}
		}
	}

	// 时间日期校验
	public void checkDate() {
		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			Date rePmtTrnDate = (Date) row.getCell("rePmtTrnDate").getValue();// 收到居住证调出令时间
			Date pmtTrnDate = (Date) row.getCell("pmtTrnDate").getValue();// 居住证调入完成时间
			if (rePmtTrnDate != null && pmtTrnDate != null) {
				// 居住证调入完成时间>=收到居住证调出令时间
				if (pmtTrnDate.before(rePmtTrnDate)) {
					MsgBox.showInfo("姓名【" + row.getCell("name").getValue() + "】的居住证调入完成时间小于收到居住证调出令时间，请重新填入！");
					this.abort();
				}
			}
		}
	}

	//
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
				MsgBox.showInfo(this, "指标工种[" + pwInfo.getName() + "]额度不足，不允许提交！");
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
	 * 单据拆分
	 * 
	 * @author ywj 2018-10-25 
	 * <li>原为审核方法，现改为单据拆分
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		//保证拆分前‘指标项目’字段录入完毕
		checkEmpty();
		//调用保存方法
		actionSave_actionPerformed(e);
		//TODO  
		
		
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
		return com.kingdee.eas.zjlw.certificates.ExLivepermitECFactory.getRemoteInstance();
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
		com.kingdee.eas.zjlw.certificates.ExLivepermitECInfo objectValue = new com.kingdee.eas.zjlw.certificates.ExLivepermitECInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

}