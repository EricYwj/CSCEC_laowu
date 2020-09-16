/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
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
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoInfo;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageEcEntryCollection;
import com.kingdee.eas.zjlw.certificates.LeaveManageEcEntryInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageEcFactory;
import com.kingdee.eas.zjlw.certificates.LeaveManageEcInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryCollection;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryFactory;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageFactory;
import com.kingdee.eas.zjlw.certificates.LeaveManageInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryECEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryECEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryECFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryECInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryEntryFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.leaveTypeEnum;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class LeaveManageEcEditUI extends AbstractLeaveManageEcEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(LeaveManageEcEditUI.class);
    
    /**
     * output class constructor
     */
    public LeaveManageEcEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
  //2016-11-30  zxh
    public void onLoad() throws Exception {
    	this.contbillSate.setEnabled(false);
		this.txtNumber.setEnabled(false);
		this.pkauditDate.setEnabled(false);
		super.onLoad();
		setUITitle("离境管理-批量编辑");
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
    	btnAudit.setVisible(false);
    	btnUnAudit.setVisible(false);
		//--------------获取原单据数据------------------------------------------- 2016-11-08  zxh
    	if (getOprtState().equals("ADDNEW")) {
			//获取接受到的参数
    		Map uictxMap = this.getUIContext();
    		Set etys = new HashSet();
    		etys = (Set) uictxMap.get("etys");
    		//遍历离境管理分录集合
    		for (Object object : etys) {
    			LeaveManageEntryInfo etyInfo = (LeaveManageEntryInfo) object;
    			//单条分录的值赋值给一行
    			IRow row = this.kdtEntrys.addRow();
    			row.getCell("oldEtyId").setValue(etyInfo.getId());
    			row.getCell("name").setValue(etyInfo.getName());//中文姓名  name
    			row.getCell("lastName").setValue(etyInfo.getLastName());//姓拼音 lastName
    			row.getCell("firstName").setValue(etyInfo.getFirstName());//名拼音 firstName
    			row.getCell("sex").setValue(etyInfo.getSex());//性别   sex
    			row.getCell("birthday").setValue(etyInfo.getBirthday());//出生日期  birthday
    			row.getCell("birthPlaceCn").setValue(etyInfo.getBirthPlaceCn());//出生地（中文）  birthPlaceCn
    			row.getCell("birthPlaceFr").setValue(etyInfo.getBirthPlaceFr());//出生地（拼音） birthPlaceFr
    			row.getCell("passpNum").setValue(etyInfo.getPasspNum());//护照号码  passpNum
    			row.getCell("passpIsDate").setValue(etyInfo.getPasspIsDate());//护照签发日期 passpIsDate
    			row.getCell("passpExDate").setValue(etyInfo.getPasspExDate());//护照到期日期 passpExDate
    			row.getCell("actProff").setValue(etyInfo.getActProff());//实际专业或工种 actProff
    			row.getCell("quproff").setValue(etyInfo.getQuproff());//指标工种法文 quproff 
    			row.getCell("fatherName").setValue(etyInfo.getFatherName());//父亲姓名 fatherName
    			row.getCell("fatherNameAl").setValue(etyInfo.getFatherNameAl());//父亲姓名拼音 fatherNameAl
    			row.getCell("motherName").setValue(etyInfo.getMotherName());//母亲姓名  motherName
    			row.getCell("motherNameAl").setValue(etyInfo.getMotherNameAl());//母亲姓名拼音 motherNameAl
    			row.getCell("MaritalStatus").setValue(etyInfo.getMaritalStatus());//婚姻状态 MaritalStatus
    			row.getCell("immiTime").setValue(etyInfo.getImmiTime());//入阿时间  immiTime
    			row.getCell("wPmtNum").setValue(etyInfo.getWPmtNum());//劳动证号  wPmtNum
    			row.getCell("wPmtSTime").setValue(etyInfo.getWPmtSTime());//劳动证到期日期  wPmtSTime
    			row.getCell("docType").setValue(etyInfo.getDocType());//居住证类型  docType
    			row.getCell("rePmtNum").setValue(etyInfo.getRePmtNum());//临时居住证号码 rePmtNum
    			row.getCell("sRePmtSTime").setValue(etyInfo.getSRePmtSTime());//临时居住证出证日期 sRePmtSTime
    			row.getCell("rePmtETime").setValue(etyInfo.getRePmtETime());//临时居住证到期日期 rePmtETime
    			row.getCell("pmtNum").setValue(etyInfo.getPmtNum());//正式居住证号码  pmtNum
    			row.getCell("pmteffDate").setValue(etyInfo.getPmteffDate());//正式居住证生效日期 pmteffDate
    			row.getCell("pmtETime").setValue(etyInfo.getPmtETime());//正式居住证到期日期  pmtETime
    			row.getCell("leaveApply").setValue(etyInfo.getLeaveApply());//申请离境日期   leaveApply
    			row.getCell("exitTime").setValue(etyInfo.getExitTime());//劳动证注销日期  exitTime
    			row.getCell("dptrGTime").setValue(etyInfo.getDptrGTime());//一次性离境办理完毕时间   dptrGTime
    			row.getCell("dptrETime").setValue(etyInfo.getDptrETime());//一次性离境到期时间 dptrETime
    			row.getCell("backTime").setValue(etyInfo.getBackTime());//居住证归还警局时间  backTime
    			row.getCell("dptrTime").setValue(etyInfo.getDptrTime());//离境时间  dptrTime
    			row.getCell("leaveType").setValue(etyInfo.getLeaveType());//离境类型  leaveType
    			row.getCell("carryCertify").setValue(etyInfo.isCarryCertify());//是否携带居住证离境 carryCertify  Boolean 
    			row.getCell("idNum").setValue(etyInfo.getIdNum());//身份证号  idNum
    			row.getCell("remark").setValue(etyInfo.getRemark());//备注  remark
    			row.getCell("personID").setValue(etyInfo.getPersonID());//人员分录id
    			if(etyInfo.getNatioNal()!=null){
    				CountryInfo contryInfo=etyInfo.getNatioNal();
    				CountryInfo nation=CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("natioNal").setValue(nation);//国籍  natioNal  Country 
    			}
    			if(etyInfo.getQuProf()!=null){
    				ProjectWorkInfo contryInfo=etyInfo.getQuProf();
    				ProjectWorkInfo quProf=ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("quProf").setValue(quProf);//指标工种中文  quProf  ProjectWork 
    			}
    			if(etyInfo.getPmtProj()!=null){
    				AdminOrgUnitInfo contryInfo=etyInfo.getPmtProj();
    				AdminOrgUnitInfo pmtProj=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("pmtProj").setValue(pmtProj);//指标项目  pmtProj  AdminOrgUnit 
    			}
    			if(etyInfo.getTaskProj()!=null){
    				AdminOrgUnitInfo contryInfo=etyInfo.getTaskProj();
    				AdminOrgUnitInfo workOrg=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("taskProj").setValue(workOrg);//工作项目  taskProj  AdminOrgUnit
    			} 
    			if(etyInfo.getCooperation()!=null){
    				AdminOrgUnitInfo contryInfo=etyInfo.getCooperation();
    				AdminOrgUnitInfo cooperation=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("cooperation").setValue(cooperation);//合作单位 cooperation
    			}
    		}
    		queryAtEdit();
    	}
    }
  //2016-11-30  zxh
    private void queryAtEdit() throws BOSException {
		String number = txtNumber.getText();
		int rowCount = this.kdtEntrys.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			//查询劳动证注销时间
			String idNum = row.getCell("idNum").getValue() == null ? null : row.getCell("idNum").getValue().toString();
			String passpNum = row.getCell("passpNum").getValue() ==null ? null : row.getCell("passpNum").getValue().toString();
			FilterInfo filter = new FilterInfo();
			//filter.getFilterItems().add(new FilterItemInfo("IdNum",idNum));
			//filter.getFilterItems().add(new FilterItemInfo("passpNum",passpNum));
			filter.getFilterItems().add(new FilterItemInfo("personID",row.getCell("personID").getValue().toString()));
			filter.getFilterItems().add(new FilterItemInfo("parent.billSate","40"));
//				filter.setMaskString("(#0 OR #1) AND #2 AND #3");
			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(filter);
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("dstryTime");
			view.setSelector(sic);
			WkPmtDstryEntryCollection wpdCol =  WkPmtDstryEntryFactory.getRemoteInstance().getWkPmtDstryEntryCollection(view);
			if (wpdCol != null && wpdCol.size() > 0) {
				row.getCell("exitTime").setValue(wpdCol.get(0).getDstryTime());
			}
			//根据离境类型，判断字段锁定与否
			leaveTypeEnum leaveType = (leaveTypeEnum) row.getCell("leaveType").getValue();
			//正常离境、"居住证停办"
			if (leaveTypeEnum.NORMAL.equals(leaveType)||leaveTypeEnum.LEAVESTOP.equals(leaveType)) {
				row.getCell("dptrGTime").getStyleAttributes().setLocked(false);//一次性离境办理完毕时间
				row.getCell("dptrETime").getStyleAttributes().setLocked(false);//一次性离境到期时间
			}
			//"携带居住证回国"
			if (leaveTypeEnum.TAKEBACK.equals(leaveType)) {
				row.getCell("backTime").getStyleAttributes().setLocked(false);//归还警局时间
			}
		}
	}
    //2016-11-30  zxh
	protected void setButtonStatus() {
		LeaveManageEcInfo bill;
		if ("VIEW".equals(getOprtState())) {
			//    			this.actionAudit.setVisible(true);
			//    			this.actionUnAudit.setVisible(true);
			//    			this.actionAudit.setEnabled(true);
			//    			this.actionUnAudit.setEnabled(true);

			bill = (LeaveManageEcInfo) this.editData;
			if (this.editData != null) {
				if ((BillStateEnum.CHECKED.equals(bill.getBillSate()))) {//|| (BillStateEnum.SIGNED.equals(bill.getBillSate())
					//    					this.actionUnAudit.setVisible(true);
					//    					this.actionUnAudit.setEnabled(true);
					//    					this.actionAudit.setVisible(false);
					//    					this.actionAudit.setEnabled(false);
					    					this.actionEdit.setEnabled(false);
					this.actionRemove.setEnabled(false);
				} else {
					//    					this.actionUnAudit.setVisible(false);
					//    					this.actionUnAudit.setEnabled(false);
					//    					this.actionAudit.setVisible(true);
					//    					this.actionAudit.setEnabled(true);
					this.actionRemove.setEnabled(true);
					this.actionEdit.setEnabled(true);
				}
			}

			this.actionAddLine.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionInsertLine.setEnabled(false);
		} else {
			bill = (LeaveManageEcInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null)
					&& (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(false);
			}

			//    			this.actionAudit.setVisible(false);
			//    			this.actionUnAudit.setVisible(false);
			//    			this.actionAudit.setEnabled(false);
			//    			this.actionUnAudit.setEnabled(false);
		}
		if (((this.editData != null) && (BillStateEnum.CHECKED.equals(bill.getBillSate())))|| ("ADDNEW".equalsIgnoreCase(getOprtState()))) {
			this.actionPrint.setEnabled(false);
			this.actionPrintPreview.setEnabled(false);
			this.actionAttachment.setEnabled(false);
		} else {
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(true);
		}

		if (this.editData != null) {
			bill = (LeaveManageEcInfo) this.editData;
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
    protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnAddLine_actionPerformed(e);
    }

    /**
     * output menuItemEnterToNextRow_itemStateChanged method
     */
    protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
        super.menuItemEnterToNextRow_itemStateChanged(e);
    }

    /**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionToolBarCustom_actionPerformed
     */
    public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToolBarCustom_actionPerformed(e);
    }

    /**
     * output actionCloudFeed_actionPerformed
     */
    public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudFeed_actionPerformed(e);
    }

    /**
     * output actionCloudShare_actionPerformed
     */
    public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudShare_actionPerformed(e);
    }

    /**
     * output actionCloudScreen_actionPerformed
     */
    public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudScreen_actionPerformed(e);
    }

    /**
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }

    /**
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
    	super.actionSave_actionPerformed(e);
    	//2016-11-30  zxh
        //==================================根据分录id反写原分录============================== 2016-11-08 zxh
        //--------------------反写分录附件----------------------------------------------------
        String id = this.editData.getId().toString();
        LeaveManageEcInfo info = LeaveManageEcFactory.getRemoteInstance().getLeaveManageEcInfo(new ObjectUuidPK(id));
        LeaveManageEcEntryCollection col = info.getEntrys();
    	for (int i = 0; i < col.size(); i++) {
    		LeaveManageEcEntryInfo etyInfo = col.get(i);
    		String etyId = etyInfo.getId().toString();//先分录id
    		String oldId = etyInfo.getOldEtyId().toString();//原分录id
    		//携带附件
			IBoAttchAsso boaFac = BoAttchAssoFactory.getRemoteInstance();
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("attachment.id");
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("boID",etyId));
			view.setFilter(filter);
			view.setSelector(sic);
			//根据现分录ID查询附件
			BoAttchAssoCollection boaCol =boaFac.getBoAttchAssoCollection(view);
			if(boaCol!=null && boaCol.size()>0){
				for(int j=0;j<boaCol.size();j++){
					BoAttchAssoInfo boaInfo = boaCol.get(j);
					//添加附件
					BoAttchAssoInfo newBoaInfo = new BoAttchAssoInfo();
					newBoaInfo.setId(BOSUuid.create(newBoaInfo.getBOSType()));
					newBoaInfo.setBoID(oldId);//原分录id
					newBoaInfo.setAssoType("系统已有附件");//类型
					newBoaInfo.setAttachment(boaInfo.getAttachment());//附件
					newBoaInfo.setAssoBusObjType("3D062727");//关联业务对象的类型：原离境分录BOSTYPE
					boaFac.addnew(newBoaInfo);
				}
			}
			//删除原有附件
			boaFac.delete(filter);
    	}  
    	int count = this.kdtEntrys.getRowCount3();
    	for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("oldEtyId").getValue() != null) {
				LeaveManageEntryInfo etyInfo = LeaveManageEntryFactory.getRemoteInstance().getLeaveManageEntryInfo(new ObjectUuidPK(row.getCell("oldEtyId").getValue().toString()));
				SelectorItemCollection sic = new SelectorItemCollection();
				// 一次性离境办理完毕时间 dptrGTime
				if(row.getCell("dptrGTime").getValue() != null){
					etyInfo.setDptrGTime( (Date) row.getCell("dptrGTime").getValue());
				}else{
					etyInfo.setDptrGTime(null);
				}
				//一次性离境到期时间 dptrETime
				if(row.getCell("dptrETime").getValue() != null){
					etyInfo.setDptrETime( (Date) row.getCell("dptrETime").getValue());
				}else{
					etyInfo.setDptrETime(null);
				}
				//离境时间  dptrTime
				if(row.getCell("dptrTime").getValue() != null){
					etyInfo.setDptrTime( (Date) row.getCell("dptrTime").getValue());
				}else{
					etyInfo.setDptrTime(null);
				}
				//备注 remark
				if(row.getCell("remark").getValue() != null){
					etyInfo.setRemark( (String) row.getCell("remark").getValue());
				}else{
					etyInfo.setRemark(null);
				}
				//归还警局时间 backTime
				if(row.getCell("backTime").getValue() != null){
					etyInfo.setBackTime( (Date) row.getCell("backTime").getValue());
				}else{
					etyInfo.setBackTime(null);
				}	
				sic.add("dptrGTime");// 一次性离境办理完毕时间 dptrGTime
				sic.add("dptrETime");//一次性离境到期时间 dptrETime
				sic.add("dptrTime");//离境时间  dptrTime
				sic.add("remark");//备注 remark
				sic.add("backTime");//归还警局时间 backTime
				LeaveManageEntryFactory.getRemoteInstance().updatePartial(etyInfo, sic);
			}
    	}
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }
    //2016-11-30  ZXH
    protected void doBeforeSubmit(ActionEvent e) throws Exception {
    	//----------------------反写原单据，设置单据状态为已提交------------------------------------
    	int rowCount=kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			if (rowCount == 0) {
				MsgBox.showInfo("未添加人员信息，不允许提交！");
				abort();
			}
			IRow row = this.kdtEntrys.getRow(i);
			String id = row.getCell("oldEtyId").getValue().toString();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",id));
			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(filter);
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("billSate");
			LeaveManageEntryCollection antiCol = LeaveManageEntryFactory.getRemoteInstance().getLeaveManageEntryCollection(view);
			for (int j = 0; j < antiCol.size(); j++) {
				LeaveManageInfo antiInfo = antiCol.get(j).getParent();
				antiInfo.setBillSate(BillStateEnum.SUBMIT);
				LeaveManageFactory.getRemoteInstance().updatePartial(antiInfo, sic);
			}
		}
		
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			leaveTypeEnum leaveType = (leaveTypeEnum) row.getCell("leaveType").getValue();
			//正常离境、"居住证停办"
			if (leaveTypeEnum.NORMAL.equals(leaveType)||leaveTypeEnum.LEAVESTOP.equals(leaveType)) {
				if (row.getCell("exitTime").getValue() == null) {
					MsgBox.showInfo("劳动证注销时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("dptrGTime").getValue() == null) {
					MsgBox.showInfo("一次性离境办理完毕时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("dptrETime").getValue() == null) {
					MsgBox.showInfo("一次性离境到期时间为空，不允许提交！");
					abort();
				}
				//一次性离境到期时间>=一次性离境办理完毕时间
				Date dptrGTime = (Date) row.getCell("dptrGTime").getValue();
				Date dptrETime = (Date) row.getCell("dptrETime").getValue();
				if(dptrETime.before(dptrGTime)){
					MsgBox.showInfo("一次性离境到期时间小于一次性离境办理完毕时间，不允许提交！");
					abort();
				}
			}
			if (leaveTypeEnum.LEAVENO.equals(leaveType)) {//"居住证未办"
				if (row.getCell("exitTime").getValue() == null) {
					MsgBox.showInfo("劳动证注销时间为空，不允许提交！");
					abort();
				}
			}
			if (leaveTypeEnum.TAKEBACK.equals(leaveType)) {//"携带居住证回国"
				if (row.getCell("exitTime").getValue() == null) {
					MsgBox.showInfo("劳动证注销时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("backTime").getValue() == null) {
					MsgBox.showInfo("该人员携带居住证回国，且尚未填写居住证归还警局时间，不允许提交！");
					abort();
				}
			}
			if (leaveTypeEnum.WORKSTOP.equals(leaveType)) {//"劳动证停办"
				if (row.getCell("exitTime").getValue() == null) {
					MsgBox.showInfo("劳动证注销时间为空，不允许提交！");
					abort();
				}
			}
			if (row.getCell("dptrTime").getValue() == null) {
				MsgBox.showInfo("离境时间为空，不允许提交！");
				abort();
			}
		}
    	super.doBeforeSubmit(e);
    }

    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }

    /**
     * output actionFirst_actionPerformed
     */
    public void actionFirst_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionFirst_actionPerformed(e);
    }

    /**
     * output actionPre_actionPerformed
     */
    public void actionPre_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPre_actionPerformed(e);
    }

    /**
     * output actionNext_actionPerformed
     */
    public void actionNext_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNext_actionPerformed(e);
    }

    /**
     * output actionLast_actionPerformed
     */
    public void actionLast_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLast_actionPerformed(e);
    }

    /**
     * output actionPrint_actionPerformed
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrint_actionPerformed(e);
    }

    /**
     * output actionPrintPreview_actionPerformed
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrintPreview_actionPerformed(e);
    }

    /**
     * output actionCopy_actionPerformed
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }

    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

    /**
     * output actionSubmitOption_actionPerformed
     */
    public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmitOption_actionPerformed(e);
    }

    /**
     * output actionReset_actionPerformed
     */
    public void actionReset_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionReset_actionPerformed(e);
    }

    /**
     * output actionMsgFormat_actionPerformed
     */
    public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMsgFormat_actionPerformed(e);
    }

    /**
     * output actionAddLine_actionPerformed
     */
    public void actionAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddLine_actionPerformed(e);
    }

    /**
     * output actionCopyLine_actionPerformed
     */
    public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyLine_actionPerformed(e);
    }

    /**
     * output actionInsertLine_actionPerformed
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInsertLine_actionPerformed(e);
    }

    /**
     * output actionRemoveLine_actionPerformed
     */
    public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoveLine_actionPerformed(e);
    }

    /**
     * output actionCreateFrom_actionPerformed
     */
    public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateFrom_actionPerformed(e);
    }

    /**
     * output actionCopyFrom_actionPerformed
     */
    public void actionCopyFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyFrom_actionPerformed(e);
    }

    /**
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
    }

    /**
     * output actionTraceUp_actionPerformed
     */
    public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceUp_actionPerformed(e);
    }

    /**
     * output actionTraceDown_actionPerformed
     */
    public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceDown_actionPerformed(e);
    }

    /**
     * output actionViewSubmitProccess_actionPerformed
     */
    public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSubmitProccess_actionPerformed(e);
    }

    /**
     * output actionViewDoProccess_actionPerformed
     */
    public void actionViewDoProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewDoProccess_actionPerformed(e);
    }

    /**
     * output actionMultiapprove_actionPerformed
     */
    public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMultiapprove_actionPerformed(e);
    }

    /**
     * output actionNextPerson_actionPerformed
     */
    public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNextPerson_actionPerformed(e);
    }

    /**
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
    }

    /**
     * output actionVoucher_actionPerformed
     */
    public void actionVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionVoucher_actionPerformed(e);
    }

    /**
     * output actionDelVoucher_actionPerformed
     */
    public void actionDelVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDelVoucher_actionPerformed(e);
    }

    /**
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateTo_actionPerformed(e);
    }

    /**
     * output actionSendingMessage_actionPerformed
     */
    public void actionSendingMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendingMessage_actionPerformed(e);
    }

    /**
     * output actionSignature_actionPerformed
     */
    public void actionSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSignature_actionPerformed(e);
    }

    /**
     * output actionWorkflowList_actionPerformed
     */
    public void actionWorkflowList_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkflowList_actionPerformed(e);
    }

    /**
     * output actionViewSignature_actionPerformed
     */
    public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSignature_actionPerformed(e);
    }

    /**
     * output actionSendMail_actionPerformed
     */
    public void actionSendMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMail_actionPerformed(e);
    }

    /**
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }

    /**
     * output actionNumberSign_actionPerformed
     */
    public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNumberSign_actionPerformed(e);
    }

    /**
     * output acitonAudit_actionPerformed
     */
    public void acitonAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.acitonAudit_actionPerformed(e);
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionUnAudit_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.certificates.LeaveManageEcFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.certificates.LeaveManageEcInfo objectValue = new com.kingdee.eas.zjlw.certificates.LeaveManageEcInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}