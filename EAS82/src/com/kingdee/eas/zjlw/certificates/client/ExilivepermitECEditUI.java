/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
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
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.ExilivepermitECEntryCollection;
import com.kingdee.eas.zjlw.certificates.ExilivepermitECEntryInfo;
import com.kingdee.eas.zjlw.certificates.ExilivepermitECFactory;
import com.kingdee.eas.zjlw.certificates.ExilivepermitECInfo;
import com.kingdee.eas.zjlw.certificates.ExilivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.ExilivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.ExilivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.ExilivepermitFactory;
import com.kingdee.eas.zjlw.certificates.ExilivepermitInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitECEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitECEntryInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitECFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitECInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.UplivePermitFactory;
import com.kingdee.eas.zjlw.certificates.UplivePermitInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.DOCTYPE;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class ExilivepermitECEditUI extends AbstractExilivepermitECEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ExilivepermitECEditUI.class);
    
    /**
     * output class constructor
     */
    public ExilivepermitECEditUI() throws Exception
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
    public void onLoad() throws Exception {
    	this.billSate.setEnabled(false);
    	this.pkauditDate.setEnabled(false);
    	super.onLoad();
    	setButtonStatus();
    	setUITitle("申请离境(两证齐全)-编辑界面");
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
    	if (getUIContext().get("BOTPViewStatus") != null){
			this.pkBizDate.setValue(new Date());
		}
    	kdtEntrys.getColumn("name").getStyleAttributes().setLocked(true);//姓名
    	kdtEntrys.getColumn("sex").getStyleAttributes().setLocked(true);//性别
    	kdtEntrys.getColumn("birth").getStyleAttributes().setLocked(true);//出生日期
    	kdtEntrys.getColumn("IdNum").getStyleAttributes().setLocked(true);//身份证号
    	kdtEntrys.getColumn("passpNum").getStyleAttributes().setLocked(true);//护照号
    	kdtEntrys.getColumn("passpExDate").getStyleAttributes().setLocked(true);//护照失效日期
    	kdtEntrys.getColumn("immiTime").getStyleAttributes().setLocked(true);//入境时间
    	kdtEntrys.getColumn("wPmtGTime").getStyleAttributes().setLocked(true);//劳动证出证日期
    	kdtEntrys.getColumn("wPmtNum").getStyleAttributes().setLocked(true);//劳动证号
    	kdtEntrys.getColumn("wPmtSTime").getStyleAttributes().setLocked(true);//劳动证到证日期
    	kdtEntrys.getColumn("dlyChkFrc").getStyleAttributes().setLocked(true);//报签次数
    	kdtEntrys.getColumn("pmtProj").getStyleAttributes().setLocked(true);//指标项目
    	kdtEntrys.getColumn("workOrg").getStyleAttributes().setLocked(true);//工作项目
    	kdtEntrys.getColumn("actProf").getStyleAttributes().setLocked(true);//实际工种
    	kdtEntrys.getColumn("quProf").getStyleAttributes().setLocked(true);//指标项目
    	kdtEntrys.getColumn("quproFf").getStyleAttributes().setLocked(true);//指标项目法文
    	kdtEntrys.getColumn("cooperation").getStyleAttributes().setLocked(true);//合作项目
    	kdtEntrys.getColumn("papSTime").getStyleAttributes().setLocked(true);//递交资料日期
    	kdtEntrys.getColumn("rePmtNum").getStyleAttributes().setLocked(true);//临居号码
    	kdtEntrys.getColumn("rePmtETime").getStyleAttributes().setLocked(true);//临居到证日期
    	kdtEntrys.getColumn("sRePmtSTime").getStyleAttributes().setLocked(true);//临居出证日期
    	kdtEntrys.getColumn("pmtETime").getStyleAttributes().setLocked(true);//正居出证日期
    	kdtEntrys.getColumn("pmtNum").getStyleAttributes().setLocked(true);//正居号码
    	kdtEntrys.getColumn("docType").getStyleAttributes().setLocked(true);//证件类型
    	//--------------获取原单据数据------------------------------------------- 2016-11-08  zxh
    	if (getOprtState().equals("ADDNEW")) {
			//获取接受到的参数
    		Map uictxMap = this.getUIContext();
    		Set etys = new HashSet();
    		etys = (Set) uictxMap.get("etys");
    		//遍历反签办理分录集合
    		for (Object object : etys) {
    			ExilivepermitEntryInfo etyInfo = (ExilivepermitEntryInfo) object;
    			//单条分录的值赋值给一行
    			IRow row = this.kdtEntrys.addRow();
    			row.getCell("oldEtyId").setValue(etyInfo.getId());
    			row.getCell("name").setValue(etyInfo.getName());//中文姓名
    			row.getCell("lastName").setValue(etyInfo.getLastName());//姓拼音
    			row.getCell("firstName").setValue(etyInfo.getFirstName());//名拼音
    			row.getCell("sex").setValue(etyInfo.getSex());//性别 
    			row.getCell("birth").setValue(etyInfo.getBirth());//出生日期
    			row.getCell("birthPlace").setValue(etyInfo.getBirthPlace());//出生地（中文）
    			row.getCell("birthPlaceFr").setValue(etyInfo.getBirthPlaceFr());//出生地（拼音）
    			row.getCell("passpNum").setValue(etyInfo.getPasspNum());//护照号码
    			row.getCell("immiTime").setValue(etyInfo.getImmiTime());//入阿时间
    			row.getCell("actProf").setValue(etyInfo.getActProf());//实际专业或工种
    			row.getCell("quproFf").setValue(etyInfo.getQuproFf());//指标工种法文
    			row.getCell("docType").setValue(etyInfo.getDocType());//居住证类型
    			row.getCell("rePmtNum").setValue(etyInfo.getRePmtNum());//临时居住证号码
    			row.getCell("sRePmtSTime").setValue(etyInfo.getSRePmtSTime());//临时居住证出证日期
    			row.getCell("rePmtETime").setValue(etyInfo.getRePmtETime());//临时居住证到期日期
    			row.getCell("pmtNum").setValue(etyInfo.getPmtNum());//正式居住证号码
    			row.getCell("pmteffDate").setValue(etyInfo.getPmteffDate());//正式居住证生效日期
    			row.getCell("pmtETime").setValue(etyInfo.getPmtETime());//正式居住证到期日期
    			row.getCell("leaveTime").setValue(etyInfo.getLeaveTime());//申请离境时间
    			row.getCell("carryCertify").setValue(etyInfo.isCarryCertify());//是否携带居住证离境
    			row.getCell("IdNum").setValue(etyInfo.getIdNum());//身份证号
    			row.getCell("remark").setValue(etyInfo.getRemark());//备注
    			row.getCell("personID").setValue(etyInfo.getPersonID());//人员分录id
    			if(etyInfo.getNation()!=null){
    				CountryInfo contryInfo=etyInfo.getNation();
    				CountryInfo nation=CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("nation").setValue(nation);//国籍
    			}
    			if(etyInfo.getQuProf()!=null){
    				ProjectWorkInfo contryInfo=etyInfo.getQuProf();
    				ProjectWorkInfo quProf=ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("quProf").setValue(quProf);//指标工种中文
    			}
    			if(etyInfo.getPmtProj()!=null){
    				AdminOrgUnitInfo contryInfo=etyInfo.getPmtProj();
    				AdminOrgUnitInfo pmtProj=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("pmtProj").setValue(pmtProj);//指标项目
    			}
    			if(etyInfo.getPmtProj()!=null){
    				AdminOrgUnitInfo contryInfo=etyInfo.getPmtProj();
    				AdminOrgUnitInfo workOrg=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("workOrg").setValue(workOrg);//工作项目
    			}
    			if(etyInfo.getPmtProj()!=null){
    				AdminOrgUnitInfo contryInfo=etyInfo.getPmtProj();
    				AdminOrgUnitInfo cooperation=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("cooperation").setValue(cooperation);//合作单位
    			}
    			
    		}
    	}
    }
    protected void setButtonStatus() {
    	ExilivepermitECInfo bill;
		if ("VIEW".equals(getOprtState())) {
			this.actionAudit.setVisible(true);
			this.actionUnAudit.setVisible(true);
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);

			bill = (ExilivepermitECInfo) this.editData;
			if (this.editData != null) {
				if (BillStateEnum.CHECKED.equals(bill.getBillSate())||(BillStateEnum.LEAVE.equals(bill.getBillSate()))) {// 
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
			bill = (ExilivepermitECInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null)
					&& (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(false);
			}

			this.actionAudit.setVisible(false);
			this.actionUnAudit.setVisible(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
		}
		if (((this.editData != null) && (BillStateEnum.CHECKED.equals(bill
				.getBillSate())))
				|| ("ADDNEW".equalsIgnoreCase(getOprtState()))) {
			this.actionPrint.setEnabled(false);
			this.actionPrintPreview.setEnabled(false);
			this.actionAttachment.setEnabled(false);
		} else {
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(true);
		}

		if (this.editData != null) {
			bill = (ExilivepermitECInfo) this.editData;
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
     * output kdtEntrys_editStopped method
     */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        super.kdtEntrys_editStopped(e);
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
        //==================================根据分录id反写原分录============================== 2016-11-08 zxh
        //--------------------反写分录附件----------------------------------------------------
        String id = this.editData.getId().toString();
    	ExilivepermitECInfo info =ExilivepermitECFactory.getRemoteInstance().getExilivepermitECInfo(new ObjectUuidPK(id));
    	ExilivepermitECEntryCollection col = info.getEntrys();
    	for (int i = 0; i < col.size(); i++) {
    		ExilivepermitECEntryInfo etyInfo = col.get(i);
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
					newBoaInfo.setAssoBusObjType("24DC6BE6");//关联业务对象的类型：原劳动证分录BOSTYPE
					boaFac.addnew(newBoaInfo);
				}
			}
			//删除原有附件
			boaFac.delete(filter);
    	}
     	//--------------------反写分录字段----------------------------------------------------
    	int count = this.kdtEntrys.getRowCount3();
    	for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("oldEtyId").getValue() != null) {
				ExilivepermitEntryInfo etyInfo = ExilivepermitEntryFactory.getRemoteInstance().getExilivepermitEntryInfo(new ObjectUuidPK(row.getCell("oldEtyId").getValue().toString()));
				SelectorItemCollection sic = new SelectorItemCollection();
				//备注                      remark
				if(row.getCell("remark").getValue() != null){
					etyInfo.setRemark( (String) row.getCell("remark").getValue());
				}else{
					etyInfo.setRemark(null);
				}
				//申请离境时间  leaveTime
				if(row.getCell("leaveTime").getValue() != null){
					etyInfo.setLeaveTime( (Date) row.getCell("leaveTime").getValue());
				}else{
					etyInfo.setLeaveTime(null);
				}
				//是否携带居住证离境   carryCertify
				if(row.getCell("carryCertify").getValue().equals(true)){
					etyInfo.setCarryCertify(true);
				}else{
					etyInfo.setCarryCertify(false);
				}
				sic.add("remark");//备注
				sic.add("leaveTime");//申请离境时间
				sic.add("carryCertify");//是否携带居住证离境
				ExilivepermitEntryFactory.getRemoteInstance().updatePartial(etyInfo, sic);
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
    protected void doBeforeSubmit(ActionEvent e) throws Exception {
    	//----------------------反写原单据，设置单据状态为已提交------------------------------------
    	int rowCount=kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			String id = row.getCell("oldEtyId").getValue().toString();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",id));
			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(filter);
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("billSate");
			ExilivepermitEntryCollection antiCol = ExilivepermitEntryFactory.getRemoteInstance().getExilivepermitEntryCollection(view);
			for (int j = 0; j < antiCol.size(); j++) {
				ExilivepermitInfo antiInfo = antiCol.get(j).getParent();
				antiInfo.setBillSate(BillStateEnum.SUBMIT);
				ExilivepermitFactory.getRemoteInstance().updatePartial(antiInfo, sic);
			}
		}
    	super.doBeforeSubmit(e);
    	checkDstory();
    }
    //提交校验，是否劳动证注销
    protected void  checkDstory() throws BOSException, Exception{
    	int rowCount=kdtEntrys.getRowCount();
    	Date date=new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		date=sdf.parse(sdf.format(date));
    	for(int i=0;i<rowCount;i++){
    		IRow row=kdtEntrys.getRow(i);
//    		String temporary=DOCTYPE.TEMPORARY.toString();//临时证件
//    		String formal=DOCTYPE.FORMAL.toString();//正式证件
    		//如果申请离境日期为空，则无法提交
//    		if(row.getCell("leaveTime").getValue()==null){
//    			MsgBox.showInfo("姓名【"+row.getCell("name").getValue()+"】的申请离境日期为空，请填入时间！");
//    			this.abort();
//        	}
    		//1.申请离境时间>=toady;
    		if(row.getCell("leaveTime").getValue()!=null){   
    			Date leaveTime =(Date) row.getCell("leaveTime").getValue();
//    			if(leaveTime.before(date)){
//    				MsgBox.showInfo("姓名【"+row.getCell("name").getValue()+"】的申请离境日期小于当前日期，请填入时间！");
//        			this.abort();
//    			}
    			//2.居住证类型为临居时： 申请离境时间<=临居到期时间+14天；  rePmtETime   docType
    			if(DOCTYPE.TEMPORARY.equals(row.getCell("docType").getValue())){
    				if(row.getCell("rePmtETime").getValue()!=null){
    					Date rePmtETime=(Date) row.getCell("rePmtETime").getValue();
    	    			long time=((leaveTime.getTime()-rePmtETime.getTime())/86400000);
    	    			if(time>14){
    	    				MsgBox.showInfo("姓名【"+row.getCell("name").getValue()+"】的 【申请离境时间-临居到期时间】>14天，无法提交！");
    	        			this.abort();
    	    			}
    				}
    			}
    			//3.居住证类型为正式时：申请离境时间<=正式居住证到期时间+14天。  pmtETime
    			if(DOCTYPE.FORMAL.equals(row.getCell("docType").getValue())){
    				if(row.getCell("pmtETime").getValue()!=null){
    					Date pmtETime=(Date) row.getCell("pmtETime").getValue();
    					long time=(leaveTime.getTime()-pmtETime.getTime())/86400000;
    					if(time>14){
    						MsgBox.showInfo("姓名【"+row.getCell("name").getValue()+"】的 【申请离境时间-正式居住证到期时间】>14天，无法提交！");
    	        			this.abort();
    					}
    				}
    			}
////            	FilterInfo filter = new FilterInfo();
////        		String name=(String) row.getCell("name").getValue();
////        		String idNum=(String) row.getCell("IdNum").getValue();
////        		String passpNum=(String) row.getCell("passpNum").getValue();
////        		String number=txtNumber.getText();
////        		filter.getFilterItems().add(new FilterItemInfo("IdNum",idNum));
////            	filter.getFilterItems().add(new FilterItemInfo("passpNum",passpNum));
////            	filter.getFilterItems().add(new FilterItemInfo("parent.number",number));
////            	filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED,CompareType.EQUALS));
////            	filter.setMaskString("#0 and #1 and #2 and #3");
////            	view.setFilter(filter);
////            	WkPmtDstryEntryCollection wpInfo = WkPmtDstryEntryFactory.getRemoteInstance().getWkPmtDstryEntryCollection(view);
////            	if(wpInfo==null||wpInfo.size()<=0){
////            		MsgBox.showInfo("所填人员【"+name+"】劳动证尚未注销，请先注销劳动证！ ");
////            		this.abort();
////            	}
    		}
    	}
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
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAudit_actionPerformed(e);
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
        return com.kingdee.eas.zjlw.certificates.ExilivepermitECFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.certificates.ExilivepermitECInfo objectValue = new com.kingdee.eas.zjlw.certificates.ExilivepermitECInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}