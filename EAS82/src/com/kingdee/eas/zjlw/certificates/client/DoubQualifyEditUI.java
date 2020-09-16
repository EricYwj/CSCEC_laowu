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
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyFactory;
import com.kingdee.eas.zjlw.certificates.DoubQualifyInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class DoubQualifyEditUI extends AbstractDoubQualifyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DoubQualifyEditUI.class);
    
    
    /**
     * output class constructor
     */
    public DoubQualifyEditUI() throws Exception
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
    public void onLoad() throws Exception {
    	this.contbillSate.setEnabled(false);
    	this.txtNumber.setEnabled(false);
    	this.prmtlsubmitor.setEnabled(false);
    	this.pklastaudTime.setEnabled(false);
    	super.onLoad();
    	if(chkifNeed.isSelected()){
    		txtneedReson.setEnabled(true);
			kdtEntrys.getColumn("passpNo").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("IdNum").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("workSuffer").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("type").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("copies").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("assignDate").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("pmtProf").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("pmtProj").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("taskProj").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("ifstop").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("stopTime").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("stopRes").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("isIfilentry").getStyleAttributes().setHided(true);
    	}else{
    		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
    		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
    		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
    	}
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
    	int rowCount = kdtEntrys.getRowCount();
//    	for(int i=0;i<rowCount;i++){
//    		IRow row = kdtEntrys.getRow(i);
//    		if(row.getCell("ifstop").getValue().equals(true)){
//    			row.getCell("isIfilentry").getStyleAttributes().setLocked(true);
//    			row.getCell("notiDate").getStyleAttributes().setLocked(true);
//    			row.getCell("notaDate").getStyleAttributes().setLocked(true);
//    			row.getCell("qualSendDate").getStyleAttributes().setLocked(true);
//    			row.getCell("qualDate").getStyleAttributes().setLocked(true);
//    			row.getCell("stopTime").getStyleAttributes().setLocked(false);
//    			row.getCell("stopRes").getStyleAttributes().setLocked(false);
//    		}
//    	}
    	filterProf();//过滤指标工种
    	
    	//工作经验允许编辑
    	kdtEntrys.getColumn("workSuffer").getStyleAttributes().setLocked(false);
    }

    protected void setButtonStatus() {
    	DoubQualifyInfo bill;
    		if ("VIEW".equals(getOprtState())) {
//    			this.actionAudit.setVisible(true);
//    			this.actionUnAudit.setVisible(true);
//    			this.actionAudit.setEnabled(true);
//    			this.actionUnAudit.setEnabled(true);

    			bill = (DoubQualifyInfo) this.editData;
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
    			bill = (DoubQualifyInfo) this.editData;
    			if (("EDIT".equals(getOprtState())) && (this.editData != null)
    					&& (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
    				this.actionSave.setEnabled(false);
    			}

    			this.actionAudit.setVisible(false);
    			this.actionUnAudit.setVisible(false);
    			this.actionAudit.setEnabled(false);
    			this.actionUnAudit.setEnabled(false);
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
    			bill = (DoubQualifyInfo) this.editData;
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
		//只有暂存状态可以保存
		if(this.editData!=null && this.editData.getId()!=null){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			DoubQualifyInfo fiInfo = DoubQualifyFactory.getRemoteInstance().getDoubQualifyInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!BillStateEnum.DRAFT.equals(fiInfo.getBillSate())){
				MsgBox.showInfo("当前单据状态为【"+fiInfo.getBillSate().getAlias()+"】不允许重复保存！");
				abort();
			}
		}
        super.actionSave_actionPerformed(e);
        filterProf();
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
        filterProf();
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
			if ((columnNameSet.contains(key))&& (((oldValue==newValue ||0==EcClientHelper.compareValue(oldValue,newValue))))) {
				return;
			}
		}
		afterEditStopped(tblDetail, oldValue, newValue, colIndex, rowIndex);
    }
    protected void afterEditStopped(KDTable table, Object oldValue,Object newValue, int colIndex, int rowIndex) throws Exception {
		String key = table.getColumn(colIndex).getKey();
		IRow row = table.getRow(rowIndex);
		Date date= new Date();
		//递交资料日期
//		if ("qualSendDate".equals(key)){
//			Date papSTime=(Date) row.getCell("qualSendDate").getValue();
//			if(papSTime!=null){
//    			long time=(papSTime.getTime()-date.getTime())/86400000;
//    			if(time<0){
//    				MsgBox.showInfo("认证递送日期不可早于当前时间，请重新填写！");
//    				row.getCell("qualSendDate").setValue(null);
//    			}
//    		}
//		}
//		//劳动证出证日期
//		if ("qualDate".equals(key)){
//			Date wPmtGTime=(Date) row.getCell("qualDate").getValue();
//			if(wPmtGTime!=null){
//    			long time=(wPmtGTime.getTime()-date.getTime())/86400000;
//    			if(time<0){
//    				MsgBox.showInfo("认证完成日期不可早于当前时间，请重新填写！");
//    				row.getCell("qualDate").setValue(null);
//    			}
//    			if (row.getCell("ifstop").getValue().equals(true)) {
//    				MsgBox.showInfo("签证办理完成人员不允许停办！");
//    				abort();
//    		 	}
//    		}
//		}
		//身份证号、护照号携带人员基本信息
		if("IdNum".equals(key)||"passpNo".equals(key)){
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			if(row.getCell("IdNum").getValue()!=null){
				filter.getFilterItems().add(new FilterItemInfo("idNum",row.getCell("IdNum").getValue()));
			}
			if(row.getCell("passpNo").getValue()!=null){
				filter.getFilterItems().add(new FilterItemInfo("passportNo",row.getCell("passpNo").getValue()));
			}
			if(row.getCell("IdNum").getValue()==null&&row.getCell("passpNo").getValue()==null){
				row.getCell("name").setValue(null);
				row.getCell("namePY").setValue(null);
				row.getCell("genDers").setValue(null);
				row.getCell("birthdate").setValue(null);
				row.getCell("birthPlaceCn").setValue(null);
				row.getCell("birthPlaceFr").setValue(null);
				row.getCell("actProf").setValue(null);
				row.getCell("pmtProf").setValue(null);
				row.getCell("pmtProfFr").setValue(null);
				row.getCell("natioNal").setValue(null);
				row.getCell("passpNo").setValue(null);
				row.getCell("IdNum").setValue(null);
				row.getCell("pmtProj").setValue(null);
				row.getCell("taskProj").setValue(null);
				row.getCell("partner").setValue(null);
				row.getCell("lastName").setValue(null);
				row.getCell("firstName").setValue(null);
			}
			if(filter.getFilterItems().size()>0){
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.MESSINPUT,CompareType.NOTEQUALS));// 信息录入
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.ANTINOT,CompareType.NOTEQUALS));//反签未办
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.ANTIDSTRY,CompareType.NOTEQUALS));//反签过期或不来
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.ANTISTOP,CompareType.NOTEQUALS));// 反签停办并注销
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.VISADSTRY,CompareType.NOTEQUALS));//签证过期或不来
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.VISASTOP,CompareType.NOTEQUALS));// 签证停办并注销
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.IMMIGRATIONSTOP,CompareType.NOTEQUALS));// 入境停办
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.PASSPORTISSUEDSTOP,CompareType.NOTEQUALS));//护照发放停办
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.DEPARTURE,CompareType.NOTEQUALS));// 离境
				view.setFilter(filter);
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("nameCN");
				sic.add("firstNameAlp");
				sic.add("lastNameApl");
				sic.add("sex");
				sic.add("birthDate");
				sic.add("birthPlaceCn");
				sic.add("birthPlaceFr");
				sic.add("realProf");
				sic.add("permitProfession.id");
				sic.add("permitProfession.name");
				sic.add("permitProfession.number");
				sic.add("permitProfession.nameFR");
				sic.add("nation.id");
				sic.add("nation.name");
				sic.add("nation.number");
				sic.add("passportNo");
				sic.add("idNum");
				sic.add("permitOrg.id");
				sic.add("permitOrg.name");
				sic.add("permitOrg.number");
				sic.add("workOrg.id");
				sic.add("workOrg.name");
				sic.add("workOrg.number");
				sic.add("cooperation.id");
				sic.add("cooperation.name");
				sic.add("cooperation.number");
				view.setSelector(sic);
				PersonHistoryCollection personCol = PersonHistoryFactory.getRemoteInstance().getPersonHistoryCollection(view);
				if(personCol!=null && personCol.size()>0){
					PersonHistoryInfo perInfo =personCol.get(0);
					row.getCell("name").setValue(perInfo.getNameCN());
					row.getCell("namePY").setValue(perInfo.getFirstNameAlp()+perInfo.getLastNameApl());
					row.getCell("genDers").setValue(perInfo.getSex());
					row.getCell("birthdate").setValue(perInfo.getBirthDate());
					row.getCell("birthPlaceCn").setValue(perInfo.getBirthPlaceCn());
					row.getCell("birthPlaceFr").setValue(perInfo.getBirthPlaceFr());
					row.getCell("actProf").setValue(perInfo.getRealProf());
					row.getCell("pmtProf").setValue(perInfo.getPermitProfession());
					row.getCell("pmtProfFr").setValue(perInfo.getPermitProfession()==null?null:perInfo.getPermitProfession().getNameFR());
					row.getCell("natioNal").setValue(perInfo.getNation());
					row.getCell("passpNo").setValue(perInfo.getPassportNo());
					row.getCell("IdNum").setValue(perInfo.getIdNum());
					row.getCell("pmtProj").setValue(perInfo.getPermitOrg());
					row.getCell("taskProj").setValue(perInfo.getWorkOrg());
					row.getCell("partner").setValue(perInfo.getCooperation());
					row.getCell("lastName").setValue(perInfo.getFirstNameAlp());
					row.getCell("firstName").setValue(perInfo.getLastNameApl());
				}else{
					MsgBox.showInfo("系统不存在此人员或人员未在办理业务，请检查输入的身份证号或护照号是否正确！");
					row.getCell("name").setValue(null);
					row.getCell("namePY").setValue(null);
					row.getCell("genDers").setValue(null);
					row.getCell("birthdate").setValue(null);
					row.getCell("birthPlaceCn").setValue(null);
					row.getCell("birthPlaceFr").setValue(null);
					row.getCell("actProf").setValue(null);
					row.getCell("pmtProf").setValue(null);
					row.getCell("pmtProfFr").setValue(null);
					row.getCell("natioNal").setValue(null);
					row.getCell("passpNo").setValue(null);
					row.getCell("IdNum").setValue(null);
					row.getCell("pmtProj").setValue(null);
					row.getCell("taskProj").setValue(null);
					row.getCell("partner").setValue(null);
					row.getCell("lastName").setValue(null);
					row.getCell("firstName").setValue(null);
    				abort();
				}
			}
			filterProf();
		}
		if ("pmtProj".equals(key)){
			row.getCell("pmtProf").setValue(null);
			row.getCell("pmtProfFr").setValue(null);
			filterProf();
		}
		//指标工种
		if ("pmtProf".equals(key)){
			if(row.getCell("pmtProf").getValue()!=null){
				ProjectWorkInfo pw = (ProjectWorkInfo) row.getCell("pmtProf").getValue();
				row.getCell("pmtProfFr").setValue(pw.getNameFR());
			}else{
				row.getCell("pmtProfFr").setValue(null);
			}
		}
		//是否停办
		if ("ifstop".equals(key)){
			if(row.getCell("ifstop").getValue().equals(true)){
				row.getCell("isIfilentry").getStyleAttributes().setLocked(true);
				row.getCell("notiDate").getStyleAttributes().setLocked(true);
				row.getCell("notaDate").getStyleAttributes().setLocked(true);
				row.getCell("qualSendDate").getStyleAttributes().setLocked(true);
				row.getCell("qualDate").getStyleAttributes().setLocked(true);
				row.getCell("notiDate").setValue(null);
				row.getCell("notaDate").setValue(null);
				row.getCell("qualSendDate").setValue(null);
				row.getCell("qualDate").setValue(null);
				row.getCell("stopTime").getStyleAttributes().setLocked(false);
				row.getCell("stopRes").getStyleAttributes().setLocked(false);
			}else{
				row.getCell("isIfilentry").getStyleAttributes().setLocked(false);
				row.getCell("notiDate").getStyleAttributes().setLocked(false);
				row.getCell("notaDate").getStyleAttributes().setLocked(false);
				row.getCell("qualSendDate").getStyleAttributes().setLocked(false);
				row.getCell("qualDate").getStyleAttributes().setLocked(false);
				row.getCell("stopTime").getStyleAttributes().setLocked(true);
				row.getCell("stopRes").getStyleAttributes().setLocked(true);
				row.getCell("stopTime").setValue(null);
				row.getCell("stopRes").setValue(null);
				
			}
		}
    }
    //分录指标工种根据指标项目过滤
	private void filterProf(){
		int rowCount = this.kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			if(row.getCell("pmtProj").getValue()!=null){
				AdminOrgUnitInfo admin = (AdminOrgUnitInfo) row.getCell("pmtProj").getValue();
				KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
				settNumPromptBox.setEditable(true);
				settNumPromptBox.setDisplayFormat("$name$");
				settNumPromptBox.setEditFormat("$number$");
				settNumPromptBox.setCommitFormat("$number$");
				settNumPromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjectWorkQuery");
				EntityViewInfo evi = new EntityViewInfo();
				FilterInfo filterInfo = new FilterInfo();
				filterInfo.getFilterItems().add(new FilterItemInfo("proCom.id",admin.getId().toString()));
				filterInfo.getFilterItems().add(new FilterItemInfo("leftAmount",0,CompareType.GREATER));
				evi.setFilter(filterInfo);
				settNumPromptBox.setEntityViewInfo(evi);
				row.getCell("pmtProf").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
			}
		}
	}
    protected void doBeforeSubmit(ActionEvent e) throws Exception {
    	//只有暂存或者已提交状态可以提交
		if(this.editData!=null && this.editData.getId()!=null){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			DoubQualifyInfo fiInfo = DoubQualifyFactory.getRemoteInstance().getDoubQualifyInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!(BillStateEnum.DRAFT.equals(fiInfo.getBillSate())||BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))){
				MsgBox.showInfo("当前单据状态为【"+fiInfo.getBillSate().getAlias()+"】不允许重复提交！");
				abort();
			}
		}
    	checkNull();
    	super.doBeforeSubmit(e);
    }
    private void checkNull() throws ParseException {
    	Date now = new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		int rowCount = this.kdtEntrys.getRowCount();
		if (rowCount == 0) {
			MsgBox.showInfo("未添加人员信息，不允许提交！");
			abort();
		}
		if(chkifNeed.isSelected()){
			if(txtneedReson.getText()==null||txtneedReson.getText().equals("")){
				MsgBox.showInfo("勾选补办，补办理由不能为空！");
				abort();
			}
		}
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			if(row.getCell("ifstop").getValue().equals(false)&&row.getCell("isIfilentry").getValue().equals(false)) {
				if (row.getCell("IdNum").getValue() == null&&row.getCell("passpNo").getValue() == null) {
					MsgBox.showInfo("身份证号与护照号不能同时为空！");
					abort();
				}
				if (row.getCell("pmtProf").getValue() == null) {
					MsgBox.showInfo("指标工种中文为空，不允许提交！");
					abort();
				}
				if (row.getCell("assignDate").getValue() == null) {
					MsgBox.showInfo("分配工种完成时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("qualbaNum").getValue() == null) {
					MsgBox.showInfo("公证认证批次号为空，不允许提交！");
					abort();
				}
				if (row.getCell("notiDate").getValue() == null) {
					MsgBox.showInfo("公证开始办理时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("notaDate").getValue() == null) {
					MsgBox.showInfo("公证办理完毕时间空，不允许提交！");
					abort();
				}
				if (row.getCell("qualSendDate").getValue() == null) {
					MsgBox.showInfo("认证开始办理时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("qualDate").getValue() == null) {
					MsgBox.showInfo("认证办理完毕时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("pmtProj").getValue() == null) {
					MsgBox.showInfo("指标项目为空，不允许提交！");
					abort();
				}
				if (row.getCell("taskProj").getValue() == null) {
					MsgBox.showInfo("工作项目为空，不允许提交！");
					abort();
				}
				//公证开始办理时间>=分配工种完成时间
				Date notiDate = (Date)row.getCell("notiDate").getValue();
				Date assignDate = (Date)row.getCell("assignDate").getValue();
				assignDate=sdf.parse(sdf.format(assignDate));
//				if(notiDate.before(assignDate)){   ywj 1009
//					MsgBox.showInfo("公证开始办理时间小于分配工种完成时间，不允许提交！");
//					abort();
//				}
				//公证办理完毕时间>=公证开始办理时间
				Date notaDate = (Date)row.getCell("notaDate").getValue();
//				if(notaDate.before(notiDate)){   ywj 1009
//					MsgBox.showInfo("公证办理完毕时间小于公证开始办理时间，不允许提交！");
//					abort();
//				}
				//认证开始办理时间>=公证办理完毕时间
				Date qualSendDate = (Date)row.getCell("qualSendDate").getValue();
//				if(qualSendDate.before(notaDate)){    ywj 1009
//					MsgBox.showInfo("认证开始办理时间小于公证办理完毕时间，不允许提交！");
//					abort();
//				}
				//认证办理完毕时间>=认证开始办理时间
				Date qualDate = (Date)row.getCell("qualDate").getValue();
				if(qualDate.before(qualSendDate)){
					MsgBox.showInfo("认证办理完毕时间小于认证开始办理时间，不允许提交！");
					abort();
				}
				
			}else if(row.getCell("ifstop").getValue().equals(true)){
				if (row.getCell("stopTime").getValue() == null) {
					MsgBox.showInfo("勾选停办后：停办时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("stopRes").getValue() == null) {
					MsgBox.showInfo("勾选停办后：停办理由为空，不允许提交！");
					abort();
				}
			}
		}
	}
    
    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
//    	DoubQualifyInfo info = this.editData;
//    	Date qualSendDate = info.getEntrys().get(0).getQualSendDate();//认证递送日期
//    	Date qualDate = info.getEntrys().get(0).getQualDate();//认证完成日期
//    	Date now = new Date();
//    	if (qualSendDate != null && qualSendDate.before(now)) {
//    		MsgBox.showInfo("认证递送日期不可早于当前时间，请重新填写！");
//    		abort();
//		}
//		if (qualDate != null && qualDate.before(now)) {
//			MsgBox.showInfo("认证完成日期不可早于当前时间，请重新填写！");	
//			abort();
//		}
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
    	//不允许增加多行
    	int count = this.kdtEntrys.getRowCount3();
    	if (count>0) {
			MsgBox.showInfo("不允许增加多行！");
			abort();
		}
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
    	//不允许增加多行
    	int count = this.kdtEntrys.getRowCount3();
    	if (count>0) {
			MsgBox.showInfo("不允许增加多行！");
			abort();
		}
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.certificates.DoubQualifyFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.certificates.DoubQualifyInfo objectValue = new com.kingdee.eas.zjlw.certificates.DoubQualifyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        //业务日期
        objectValue.setBizDate(new Date());
        objectValue.setIfNeed(true);
        return objectValue;
    }

}