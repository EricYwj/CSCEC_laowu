/**
 * output package name
 */
package com.kingdee.eas.zjlw.social.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
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
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrg;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.social.ForiPayrollCollection;
import com.kingdee.eas.zjlw.social.ForiPayrollFactory;
import com.kingdee.eas.zjlw.social.PayrollCollection;
import com.kingdee.eas.zjlw.social.PayrollFactory;
import com.kingdee.eas.zjlw.social.SecuPayCountFactory;
import com.kingdee.eas.zjlw.social.SecuPayCountInfo;
import com.kingdee.eas.zjlw.social.SecuSplitCollection;
import com.kingdee.eas.zjlw.social.SecuSplitEntryCollection;
import com.kingdee.eas.zjlw.social.SecuSplitEntryFactory;
import com.kingdee.eas.zjlw.social.SecuSplitEntryInfo;
import com.kingdee.eas.zjlw.social.SecuSplitFactory;
import com.kingdee.eas.zjlw.social.SecuSplitInfo;
import com.kingdee.eas.zjlw.social.app.SecuPayControllerBean;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class SecuPayCountEditUI extends AbstractSecuPayCountEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(SecuPayCountEditUI.class);
    
    
    public void onLoad() throws Exception {
    	super.onLoad();
    	
    	//修改简体中文和法文编辑界面的单据名称与列表界面名称一致  modified by wangth on 20170628 start
		String strLanguage = com.kingdee.eas.common.client.SysContext.getSysContext().getLocale().getLanguage();
		if("L1".equals(strLanguage) || "l1".equals(strLanguage)){
			setUITitle("");
		}
		else if("L2".equals(strLanguage) || "l2".equals(strLanguage)){
			setUITitle("公司社保和休假工资缴纳台账");
		}
		else{
//			setUITitle("");
		}
		//修改简体中文和法文编辑界面的单据名称与列表界面名称一致  modified by wangth on 20170628 end
		
    	setButtonStatus();
//    	this.kdtEntrys.removeRows();
    	if (getOprtState().equals("EDIT")) {
    		initAll();
		}
    	this.kdtEntrys.getColumn("secuPay").getStyleAttributes().setNumberFormat("###,###,##0.00");//社保缴纳总金额
    	this.kdtEntrys.getColumn("vcPayMoney").getStyleAttributes().setNumberFormat("###,###,##0.00");//休假工资缴纳总金额
    	this.kdtEntrys.getColumn("scvcPay").getStyleAttributes().setNumberFormat("###,###,##0.00");//社保和休假缴纳总金额
    }
    protected void setButtonStatus() {
		SecuPayCountInfo bill;
		if ("VIEW".equals(getOprtState())) {
//			this.actionAudit.setVisible(true);
//			this.actionUnAudit.setVisible(true);
//			this.actionAudit.setEnabled(true);
//			this.actionUnAudit.setEnabled(true);
			bill = (SecuPayCountInfo) this.editData;
			if (this.editData != null) {
				if (BillStateEnum.CHECKED.equals(bill.getBillSate())) {// (BillStateEnum.SIGNE.equals(bill.getBillSate()))
//					this.actionUnAudit.setEnabled(true);
//					this.actionAudit.setVisible(false);
//					this.actionAudit.setEnabled(false);
					this.actionEdit.setEnabled(false);
					this.actionRemove.setEnabled(false);
				} else {
//					this.actionUnAudit.setVisible(false);
//					this.actionUnAudit.setEnabled(false);
//					this.actionAudit.setVisible(true);
//					this.actionAudit.setEnabled(true);
					this.actionRemove.setEnabled(true);
					this.actionEdit.setEnabled(true);
				}
			}
			this.actionAddLine.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionInsertLine.setEnabled(false);
		} else {
			bill = (SecuPayCountInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null)&& (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(false);
			}
//			this.actionAudit.setVisible(false);
//			this.actionUnAudit.setVisible(false);
//			this.actionAudit.setEnabled(false);
//			this.actionUnAudit.setEnabled(false);
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
	        bill = (SecuPayCountInfo) this.editData;
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
//    /**
//     * 年月值改变事件
//     */
//    protected void prmtmonthYear_dataChanged(DataChangeEvent e)throws Exception {
//    	super.prmtmonthYear_dataChanged(e);
//    	this.kdtEntrys.removeRows();
//    	//初始化单据
//    	initAll();
//    	
//    }
    
    /**
     * 初始化单据
     * @throws BOSException 
     * @throws EASBizException 
     */
    private void initAll() throws BOSException, EASBizException {
    	//获取分录中项目名称的集合
    	Set projIds = new HashSet();
    	int count = this.kdtEntrys.getRowCount3();
    	for (int i = 0; i < count; i++) {
    		IRow row = this.kdtEntrys.getRow(i);
    		AdminOrgUnitInfo proj = (AdminOrgUnitInfo) row.getCell("projName").getValue();
    		if(proj!=null){
    			projIds.add(proj.getId());
    		}
		}
    	SecuSplitEntryCollection ssCol = getSecuSplit();	
    	for (int i = 0; i < ssCol.size(); i++) {
    		SecuSplitEntryInfo ssInfo = ssCol.get(i);
			IRow row = this.kdtEntrys.addRow();
			AdminOrgUnitInfo proj = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(ssInfo.getParent().getProjName().getId()));
//			AdminOrgUnitInfo projInfo1 = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(proj.getId()));
			if (!projIds.contains(proj.getId())) {
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("proCom.id",proj.getId()));
				EntityViewInfo view = new EntityViewInfo();
				view.setFilter(filter);
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("*");
				sic.add("province.name");
				sic.add("proCom.name");
				sic.add("insuranceAcc");
				view.setSelector(sic);
				ProjectOrgInfo projInfo = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view).get(0);
				row.getCell("projPrev").setValue(projInfo.getProvince()==null?null:projInfo.getProvince().getName());//项目所在省份
				row.getCell("projName").setValue(proj);//项目名称
				row.getCell("projSCNum").setValue(projInfo.getInsuranceAcc());//项目社保号
				row.getCell("secuCount").setValue(ssInfo.getCoopScPers());//社保缴纳人数
				row.getCell("secuPay").setValue(ssInfo.getCoopScMoney());//社保缴纳金额
				row.getCell("vcPayMoney").setValue(ssInfo.getVcCount());//休假工资金额
				row.getCell("scvcPay").setValue(ssInfo.getCoopScMoney().add(ssInfo.getVcCount()));//社保休假缴纳总金额
			}
		}
	}
    
    /**
     * 获取社保分摊表的数据
     * @return
     * @throws BOSException 
     */
	private SecuSplitEntryCollection getSecuSplit() throws BOSException {
		Set projIds = new HashSet();
		projIds = getProjIdsByArea();
		PeriodInfo myInfo = (PeriodInfo) this.prmtmonthYear.getValue();
		FilterInfo filter = new FilterInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		EntityViewInfo view  = new EntityViewInfo();
		filter.getFilterItems().add(new FilterItemInfo("parent.monthYearr.id",myInfo.getId()));
		filter.getFilterItems().add(new FilterItemInfo("parent.projName.id",projIds,CompareType.INCLUDE));
		filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));  
		filter.getFilterItems().add(new FilterItemInfo("coopCode",null,CompareType.EQUALS)); 
		sic.add("parent.projName.name");
		sic.add("coopScPers");
		sic.add("coopScMoney");
		sic.add("vcCount");
		sic.add("scVcCount");
		view.setFilter(filter);
		view.setSelector(sic);
		SecuSplitEntryCollection sscCol = SecuSplitEntryFactory.getRemoteInstance().getSecuSplitEntryCollection(view);
		if (sscCol.size()==0) {
			MsgBox.showWarning(this.aera.getSelectedItem().toString() + "尚未有所选月份审核通过的项目社保分摊数据！");
//			abort();
		}
		return sscCol;
	}
	
	/**
	 * 根据区域获取属于该区域的所有项目的id集合
	 * @author yingwj
	 * @date 2016-10-7
	 * @return
	 * @throws BOSException 
	 */
	private Set getProjIdsByArea() throws BOSException {
		Set projIds = new HashSet();
		BelongAreaEnum area = (BelongAreaEnum) this.aera.getSelectedItem();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("area",area));
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		ProjectOrgCollection projCol = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view);
		for (int i = 0; i < projCol.size(); i++) {
			ProjectOrgInfo proj = projCol.get(i);
			projIds.add(proj.getProCom().getId().toString());
		}
		return projIds;
	}
	private void getPayroll() throws BOSException {
		PeriodInfo myInfo = (PeriodInfo) this.prmtmonthYear.getValue();
		FilterInfo filter = new FilterInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		EntityViewInfo view  = new EntityViewInfo();
		filter.getFilterItems().add(new FilterItemInfo("monthYearr.id",myInfo.getId()));
		sic.add("*");
		view.setFilter(filter);
		view.setSelector(sic);
		PayrollCollection payCol = PayrollFactory.getRemoteInstance().getPayrollCollection(view);
		ForiPayrollCollection foriPayCol = ForiPayrollFactory.getRemoteInstance().getForiPayrollCollection(view);
		Set paySet = new HashSet<Object>();
		for (int i = 0; i < payCol.size(); i++) {
			paySet.add(payCol.get(i));
		}
		for (int i = 0; i < foriPayCol.size(); i++) {
			paySet.add(foriPayCol.get(i));
		}
	}
	
	
	
	/**
     * output class constructor
     */
    public SecuPayCountEditUI() throws Exception
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
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }
    protected void doBeforeSubmit(ActionEvent e) throws Exception {
    	super.doBeforeSubmit(e);
    	checkEmpty();
    }
    private void checkEmpty() {
    	int rowCount=this.kdtEntrys.getRowCount();
    	for(int i=0;i<rowCount;i++){
    		IRow row=this.kdtEntrys.getRow(i);
    		String seceAcc=(String) row.getCell("seceAcc").getValue();//社保支票账户
    		String secuSinger=(String) row.getCell("secuSinger").getValue();//社保支票会签人
    		String secuChNum=(String) row.getCell("secuChNum").getValue();//社保支票号
    		String vcAcc=(String) row.getCell("vcAcc").getValue();//休假工资支票账户
    		String vcSinger=(String) row.getCell("vcSinger").getValue();//休假工资支票会签人
    		String vcPayChNum=(String) row.getCell("vcPayChNum").getValue();//休假工资支票号
    		if(seceAcc==null){
    			MsgBox.showInfo("所属项目社保支票账户为空，无法提交请填入！");
    			this.abort();
    		}
    		if(secuSinger==null){
    			MsgBox.showInfo("所属项目社保支票会签人为空，无法提交请填入！");
    			this.abort();
    		}
    		if(secuChNum==null){
    			MsgBox.showInfo("所属项目社保支票号为空，无法提交请填入！");
    			this.abort();
    		}
    		if(vcAcc==null){
    			MsgBox.showInfo("所属项目休假工资支票账户为空，无法提交请填入！");
    			this.abort();
    		}
    		if(vcSinger==null){
    			MsgBox.showInfo("所属项目休假工资支票会签人为空，无法提交请填入！");
    			this.abort();
    		}
    		if(vcPayChNum==null){
    			MsgBox.showInfo("所属项目休假工资支票号为空，无法提交请填入！");
    			this.abort();
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
        initAll();
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.social.SecuPayCountFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.social.SecuPayCountInfo objectValue = new com.kingdee.eas.zjlw.social.SecuPayCountInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}