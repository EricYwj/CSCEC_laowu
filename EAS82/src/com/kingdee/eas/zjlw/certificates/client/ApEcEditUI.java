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
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.certificates.ApEcEntryCollection;
import com.kingdee.eas.zjlw.certificates.ApEcEntryInfo;
import com.kingdee.eas.zjlw.certificates.ApEcFactory;
import com.kingdee.eas.zjlw.certificates.ApEcInfo;
import com.kingdee.eas.zjlw.certificates.PassportapplyEntryCollection;
import com.kingdee.eas.zjlw.certificates.PassportapplyEntryFactory;
import com.kingdee.eas.zjlw.certificates.PassportapplyEntryInfo;
import com.kingdee.eas.zjlw.certificates.PassportapplyFactory;
import com.kingdee.eas.zjlw.certificates.PassportapplyInfo;
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
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class ApEcEditUI extends AbstractApEcEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ApEcEditUI.class);
    
    /**
     * output class constructor
     */
    public ApEcEditUI() throws Exception
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
    	super.onLoad();
    	setUITitle("申请护照发放-编辑界面");
    	this.contbillSate.setEnabled(false);
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
    	
    	//--------------获取原单据数据------------------------------------------- 2016-12-26  zxh
    	if (getOprtState().equals("ADDNEW")) {
			//获取接受到的参数
    		Map uictxMap = this.getUIContext();
    		Set etys = new HashSet();
    		etys = (Set) uictxMap.get("etys");
    		//遍历反签办理分录集合
    		for (Object object : etys) {
    			PassportapplyEntryInfo etyInfo = (PassportapplyEntryInfo) object;
    			//单条分录的值赋值给一行
    			IRow row = this.kdtEntrys.addRow();
    			row.getCell("oldEtyId").setValue(etyInfo.getId());
    			row.getCell("personID").setValue(etyInfo.getPersonID());
    			row.getCell("name").setValue(etyInfo.getName());//中文姓名   name
    			row.getCell("lastName").setValue(etyInfo.getLastName());//姓拼音 lastName
    			row.getCell("firstName").setValue(etyInfo.getFirstName());//名拼音 firstName
    			row.getCell("sex").setValue(etyInfo.getSex());//性别   sex
    			row.getCell("birthDate").setValue(etyInfo.getBirthDate());//出生日期  birthDate
    			row.getCell("passpNum").setValue(etyInfo.getPasspNum());//护照号码   passpNum
    			row.getCell("passpExDate").setValue(etyInfo.getPasspExDate());//护照到期日期    passpExDate
    			row.getCell("veTime").setValue(etyInfo.getVeTime());//签证到期日期  veTime
    			row.getCell("dbCmpTime").setValue(etyInfo.getDbCmpTime());//双认证完成时间  dbCmpTime
    			row.getCell("apAlgTime").setValue(etyInfo.getApAlgTime());//申请入阿时间  apAlgTime
    			row.getCell("sTime").setValue(etyInfo.getSTime());//机票时间     可修改   sTime
    			row.getCell("AffpersonTicket").setValue(etyInfo.isAffpersonTicket());//机票附件挂靠人  可修改  AffpersonTicket
    			row.getCell("isCancel").setValue(etyInfo.isIsCancel());//是否停办  可修改  isCancel
    			row.getCell("cancelDate").setValue(etyInfo.getCancelDate());//停办时间  可修改  cancelDate
    			row.getCell("stopRsn").setValue(etyInfo.getStopRsn());//停办理由  可修改  stopRsn
    			if(etyInfo.getPmtProj()!=null){
    				AdminOrgUnitInfo countryInfo = etyInfo.getPmtProj();
    				AdminOrgUnitInfo pmtProj = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
        			row.getCell("pmtProj").setValue(pmtProj);//指标项目    pmtProj  AdminOrgUnit 
    			}
    			//自动勾选是否使馆注册
    			if (row.getCell("pmtProj").getValue() != null) {
    				FilterInfo filter = new FilterInfo();
    				AdminOrgUnitInfo adminInfo = (AdminOrgUnitInfo) row.getCell("pmtProj").getValue();
    				filter.getFilterItems().add(new FilterItemInfo("proCom.id",adminInfo.getId()));
    				EntityViewInfo view = new EntityViewInfo();
    				view.setFilter(filter);
    				SelectorItemCollection sic = new SelectorItemCollection();
    				sic.add("isLogin");
    				view.setSelector(sic);
    				ProjectOrgCollection pOrgCol = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view);
    				ProjectOrgInfo pOrgInfo = pOrgCol.get(0);
					if(pOrgInfo!=null){
	    				row.getCell("ifImmige").setValue(pOrgInfo.isIsLogin());
					    				}
    			//row.getCell("ifImmige").setValue(etyInfo.isIfImmige());//是否使馆注册  可修改  ifImmige
    			row.getCell("contactway").setValue(etyInfo.getContactway());//国内联系方式（手机号） contactway
    			row.getCell("residence").setValue(etyInfo.getResidence());//国内联系详细地址（省市县） residence
    			row.getCell("IdNum").setValue(etyInfo.getIdNum());//身份证号   IdNum
    			row.getCell("description").setValue(etyInfo.getDescription());//备注  description
    			if(etyInfo.getNation()!=null){
    				CountryInfo countryInfo=etyInfo.getNation();
    				CountryInfo nation=CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(countryInfo.getId()));
        			row.getCell("nation").setValue(nation);//国籍 nation  Country  
    			}
    			
    			if (etyInfo.getTaskProj() != null) {
    				AdminOrgUnitInfo countryInfo = etyInfo.getTaskProj();
    				AdminOrgUnitInfo workOrg = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
        			row.getCell("taskProj").setValue(workOrg);//工作项目  taskProj  AdminOrgUnit
				}
    			if(etyInfo.getPartner()!=null){
    				AdminOrgUnitInfo countryInfo=etyInfo.getPartner();
    				AdminOrgUnitInfo cooperation=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
    				row.getCell("partner").setValue(cooperation);//合作单位  partner   AdminOrgUnit 
    			}
    			
    		}
    	}
//    	if (getOprtState().equals("EDIT")) {
//    		int rowCount = this.kdtEntrys.getRowCount();
//    		for(int i=0;i<rowCount;i++){
//    			IRow row = this.kdtEntrys.getRow(i);
//    			
//    			}
//    		}
		}
    	setEntryLocked();//设置表格列是否可编辑
    }
    //勾选停办：设置表格列是否可编辑
    protected void setEntryLocked(){
    	int rowCount = this.kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			//是否停办：设置列是否可编辑
			if(row.getCell("isCancel").getValue().equals(true)){
				row.getCell("sTime").getStyleAttributes().setLocked(true);
				row.getCell("cancelDate").getStyleAttributes().setLocked(false);
				row.getCell("stopRsn").getStyleAttributes().setLocked(false);
			}
		}
    }
    protected void setButtonStatus() {
    	ApEcInfo bill;
    		if ("VIEW".equals(getOprtState())) {
//    			this.actionAudit.setVisible(true);
//    			this.actionUnAudit.setVisible(true);
//    			this.actionAudit.setEnabled(true);
//    			this.actionUnAudit.setEnabled(true);

    			bill = (ApEcInfo) this.editData;
    			if (this.editData != null) {
    				if ((BillStateEnum.CHECKED.equals(bill.getBillSate()))|| (BillStateEnum.DSTRY.equals(bill.getBillSate()))) {//
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
    			bill = (ApEcInfo) this.editData;
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
    			bill = (ApEcInfo) this.editData;
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
     * output kdtEntrys_editStopped method
     */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
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
			if ((columnNameSet.contains(key))&& (((oldValue==newValue ||0==EcClientHelper.compareValue(oldValue,newValue))))) {
				return;
			}
		}
		afterEditStopped(tblDetail, oldValue, newValue, colIndex, rowIndex);
    }
    protected void afterEditStopped(KDTable table, Object oldValue,Object newValue, int colIndex, int rowIndex) throws Exception {
		String key = table.getColumn(colIndex).getKey();
		IRow row = table.getRow(rowIndex);
		//是否停办
		if ("isCancel".equals(key)){
			if(row.getCell("isCancel").getValue().equals(true)){
				 row.getCell("sTime").getStyleAttributes().setLocked(true);
				 row.getCell("sTime").setValue(null);
				 row.getCell("cancelDate").getStyleAttributes().setLocked(false);
				 row.getCell("stopRsn").getStyleAttributes().setLocked(false);
			}else{
				row.getCell("sTime").getStyleAttributes().setLocked(false);
				row.getCell("cancelDate").getStyleAttributes().setLocked(true);
				row.getCell("stopRsn").getStyleAttributes().setLocked(true);
				row.getCell("cancelDate").setValue(null);
				row.getCell("stopRsn").setValue(null);
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
    	  setEntryLocked();
          //==================================根据分录id反写原分录============================== 2016-11-08 zxh
          //--------------------反写分录附件----------------------------------------------------
          String id = this.editData.getId().toString();
      	ApEcInfo info = ApEcFactory.getRemoteInstance().getApEcInfo(new ObjectUuidPK(id));
      	ApEcEntryCollection col = info.getEntrys();
      	for (int i = 0; i < col.size(); i++) {
      		ApEcEntryInfo etyInfo = col.get(i);
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
  					newBoaInfo.setAssoBusObjType("E0D41B47");//关联业务对象的类型：原申请护照发放 BOSTYPE
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
				PassportapplyEntryInfo etyInfo = PassportapplyEntryFactory.getRemoteInstance().getPassportapplyEntryInfo(new ObjectUuidPK(row.getCell("oldEtyId").getValue().toString()));
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("sTime");
				sic.add("AffpersonTicket");
				sic.add("isCancel");
				sic.add("cancelDate");
				sic.add("stopRsn");
				sic.add("description"); // ifImmige
				sic.add("ifImmige");
				//机票时间     可修改    sTime
				if(row.getCell("sTime").getValue() != null){
					etyInfo.setSTime((Date) row.getCell("sTime").getValue());
				}else{
					etyInfo.setSTime(null);
				}
    			//机票附件挂靠人  可修改  AffpersonTicket
				if(row.getCell("AffpersonTicket").getValue().equals(true)){
					etyInfo.setAffpersonTicket(true);
				}else{
					etyInfo.setAffpersonTicket(false);
				}
    			//是否停办  可修改  isCancel
				if(row.getCell("isCancel").getValue().equals(true)){
					etyInfo.setIsCancel(true);
				}else{
					etyInfo.setIsCancel(false);
				}
				//是否使馆注册     可修改  isCancel  ifImmige
				if(row.getCell("ifImmige").getValue().equals(true)){
					etyInfo.setIfImmige(true);
				}else{
					etyInfo.setIfImmige(false);
				}
    			//停办时间  可修改  cancelDate
				if(row.getCell("cancelDate").getValue() != null){
					etyInfo.setCancelDate((Date) row.getCell("cancelDate").getValue());
				}else{
					etyInfo.setCancelDate(null);
				}
    			//停办理由  可修改  stopRsn
				if(row.getCell("stopRsn").getValue() != null){
					etyInfo.setStopRsn( (String) row.getCell("stopRsn").getValue());
				}else{
					etyInfo.setStopRsn(null);
				}
    			//备注   可修改  description
				
				if(row.getCell("description").getValue() != null){
					etyInfo.setDescription( (String) row.getCell("description").getValue());
				}else{
					etyInfo.setDescription(null);
				}
				PassportapplyEntryFactory.getRemoteInstance().updatePartial(etyInfo, sic);
			}
    	}
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
        setEntryLocked();//设置表格列是否可编辑
		int rowCount = this.kdtEntrys.getRowCount();
//		if (rowCount == 0) {
//			MsgBox.showInfo("未添加人员信息，不允许提交！");
//			abort();
//		}
    }
    protected void doBeforeSubmit(ActionEvent e) throws Exception {
    	//----------------------反写原单据，设置单据状态为已提交------------------------------------
    	int rowCount=kdtEntrys.getRowCount();
     	for(int i=0;i<rowCount;i++){ 
    		IRow row = kdtEntrys.getRow(i);
    		if(row.getCell("isCancel").getValue().equals(true)){
    			if(row.getCell("cancelDate").getValue()==null){
    				MsgBox.showInfo("勾选停办后：停办时间为空，不允许提交！");
    				abort();
    			}
    			if(row.getCell("stopRsn").getValue()==null){
    				MsgBox.showInfo("勾选停办后：停办理由为空，不允许提交！");
    				abort();
    			}
    		}else{
    			if(row.getCell("sTime").getValue()==null){
    				MsgBox.showInfo("机票时间为空，不允许提交！");
    				abort();
    			}
    			if(row.getCell("apAlgTime").getValue()!=null){
    				long time = 0;
    				Date sTime = (Date)row.getCell("sTime").getValue();
    				Date apAlgTime = (Date)row.getCell("apAlgTime").getValue();
    				time = (sTime.getTime()-apAlgTime.getTime())/86400000;
//      				if(time>3 || time < -3){ywj1006
//    					MsgBox.showInfo("机票时间与申请入阿时间前后不得有3天以上的时间出入，不允许提交！");
//    					abort();
//    				}
    			}else{
    				MsgBox.showInfo("申请入阿时间为空，不能提交！");
    				abort();
    			}
    		}
    	}
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			String id = row.getCell("oldEtyId").getValue().toString();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",id));
			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(filter);
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("billSate");
			PassportapplyEntryCollection antiCol = PassportapplyEntryFactory.getRemoteInstance().getPassportapplyEntryCollection(view);
			for (int j = 0; j < antiCol.size(); j++) {
				PassportapplyInfo antiInfo = antiCol.get(j).getParent();
				antiInfo.setBillSate(BillStateEnum.SUBMIT);
				PassportapplyFactory.getRemoteInstance().updatePartial(antiInfo, sic);
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
        return com.kingdee.eas.zjlw.certificates.ApEcFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.certificates.ApEcInfo objectValue = new com.kingdee.eas.zjlw.certificates.ApEcInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}