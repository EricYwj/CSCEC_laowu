/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.client;

import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
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
import com.kingdee.eas.base.ssc.app.WeekEnum;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitCollection;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.attendance.AlgCheckRulesCollection;
import com.kingdee.eas.zjlw.attendance.AlgCheckRulesFactory;
import com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo;
import com.kingdee.eas.zjlw.baseinfo.CooprationCollection;
import com.kingdee.eas.zjlw.baseinfo.CooprationFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.certificates.ImmigrationInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class AlgCheckRulesEditUI extends AbstractAlgCheckRulesEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AlgCheckRulesEditUI.class);
    
    public void onLoad() throws Exception {
    	super.onLoad();
    	//新增单据时
    	if (getOprtState().equals("ADDNEW")) {
    		this.pkBizDate.setValue(new Date());	
		}
    	
    	//表头项目和合作单位f7过滤
    	filterCoop();
    	filterOrg();
    	
    	//界面按钮显示或隐藏
    	kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
    	setButtonStatus();
    	btnWorkFlowG.setVisible(false);
    	btnAuditResult.setVisible(false);
    	btnCreateFrom.setVisible(false);
    	btnCreateTo.setVisible(false);
    	btnMultiapprove.setVisible(false);
    	btnNextPerson.setVisible(false);
    	btnFirst.setVisible(false);
    	btnPre.setVisible(false);
    	btnNext.setVisible(false);
    	btnLast.setVisible(false);
    }
    
    /**
     * 年月值改变事件
     */
    protected void prmtmonthYear_dataChanged(DataChangeEvent e) throws Exception {
    	super.prmtmonthYear_dataChanged(e);
    	if (this.prmtmonthYear.getValue() != null) {
    		this.kdtEntrys.removeRows();
        	addEntryByMonthYear();
		}
    }
    
    /**
     * 上下班前后值改变事件
     */
    protected void amOne_dataChanged(DataChangeEvent e) throws Exception {
    	super.amOne_dataChanged(e);
    	Date date = (Date) this.amOne.getValue();
    	String name = "amOnDuty";
    	setEntryOneColumValue(date,name);
    }
	protected void amTwo_dataChanged(DataChangeEvent e) throws Exception {
    	super.amTwo_dataChanged(e);
    	Date date = (Date) this.amTwo.getValue();
    	String name = "amOutDuty";
    	setEntryOneColumValue(date,name);
    }
    protected void pmOne_dataChanged(DataChangeEvent e) throws Exception {
    	super.pmOne_dataChanged(e);
    	Date date = (Date) this.pmOne.getValue();
    	String name = "pmOnDuty";
    	setEntryOneColumValue(date,name);
    }
    protected void pmTwo_dataChanged(DataChangeEvent e) throws Exception {
    	super.pmTwo_dataChanged(e);
    	Date date = (Date) this.pmTwo.getValue();
    	String name = "pmOutDuty";
    	setEntryOneColumValue(date,name);
    }
    
    /**
     * 分录中时间列赋值
     * @param date
     * @param name
     */
    private void setEntryOneColumValue(Date date, String name) {
		int count = this.kdtEntrys.getRowCount();
		for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			row.getCell(name).setValue(date);
		}
	}
    
    /**
     * 根据年月创建分录
     */
    private void addEntryByMonthYear() {
    	PeriodInfo monthInfo = (PeriodInfo) this.prmtmonthYear.getValue();
    	int month = monthInfo.getPeriodNumber() - 1;
    	int year = monthInfo.getPeriodYear();
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR,year);
    	cal.set(Calendar.MONTH,month);
    	int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    	for (int i = 0; i <daysInMonth; i++) {
			IRow row = this.kdtEntrys.addRow();
			row.getCell("day").setValue(i+1);//天
			cal.set(Calendar.DAY_OF_MONTH, i+1);
			row.getCell("week").setValue(getWeek(cal));
			row.getCell("holiday").setValue((getWeek(cal).equals(com.kingdee.eas.cp.wfs.WeekEnum.FRIDAY) || getWeek(cal).equals(com.kingdee.eas.cp.wfs.WeekEnum.SATURDAY)) ? true : false);
		}
	}
    
	private Object getWeek(Calendar cal) {
    	int week =  cal.get(Calendar.DAY_OF_WEEK) - 1;
    	if (week == 0) {
    		return com.kingdee.eas.cp.wfs.WeekEnum.SUNDAY;
		}
    	if (week == 1) {
    		return com.kingdee.eas.cp.wfs.WeekEnum.MOMDAY;
		}
    	if (week == 2) {
    		return com.kingdee.eas.cp.wfs.WeekEnum.TUESDAY;
		}
    	if (week == 3) {
    		return com.kingdee.eas.cp.wfs.WeekEnum.WEDNESDAY;
		}
    	if (week == 4) {
    		return com.kingdee.eas.cp.wfs.WeekEnum.THURSDAY;
		}
    	if (week == 5) {
    		return com.kingdee.eas.cp.wfs.WeekEnum.FRIDAY;
		}
    	if (week == 6) {
    		return com.kingdee.eas.cp.wfs.WeekEnum.SATURDAY;
		}
		return null;
	}
	
	/**
	 * 提交前校验
	 * 
	 */
	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		super.doBeforeSubmit(e);
		//不为空校验
		checkNull();
		//校验表头四个打卡时间是否符合顺序
		checkAttTimes();
		//校验本项目或本项目下的合作单位是否有默认考勤规则
		checkIfHaveDefaultRule();
		//校验规则是否符合逻辑
		checkRuleAccordLogic();
	}
	
	/**
	 * 校验规则是否符合逻辑
	 */
	private void checkRuleAccordLogic() {
		int count = this.kdtEntrys.getRowCount();
    	for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			Date one = (Date) row.getCell("amOnDuty").getValue();
			Date two = (Date) row.getCell("amOutDuty").getValue();
			Date three = (Date) row.getCell("pmOnDuty").getValue();
			Date four = (Date) row.getCell("pmOutDuty").getValue();
			Object off = row.getCell("offWork").getValue();
			Object go = row.getCell("goWork").getValue();
			if (one == null && two == null && three == null && four == null) {//四个时间点都为空则不校验
				
			}else if((off != null && off.equals(true)) && (go == null || go.equals(false))){//夜班下班
				if (one != null && two != null && three == null && four == null) {
					MsgBox.showInfo("第" + (i + 1) + "天，规则配置错误，请重新配置！");
					abort();
				}else if(one != null && two != null && three != null && four != null){
					MsgBox.showInfo("第" + (i + 1) + "天，规则配置错误，请重新配置！");
					abort();
				}
			}else if((go != null && go.equals(true)) && (off == null || off.equals(false))){//夜班上班
				if (one != null && two != null && three == null && four == null) {
					MsgBox.showInfo("第" + (i + 1) + "天，规则配置错误，请重新配置！");
					abort();
				}else if(one != null && two != null && three != null && four != null){
					MsgBox.showInfo("第" + (i + 1) + "天，规则配置错误，请重新配置！");
					abort();
				}
			}else if(off != null && go != null && go.equals(true) && off.equals(true)){//夜班下班夜班上班
				if (one != null && two == null && three == null && four == null) {
					MsgBox.showInfo("第" + (i + 1) + "天，规则配置错误，请重新配置！");
					abort();
				}else if(one != null && two != null && three != null && four == null){
					MsgBox.showInfo("第" + (i + 1) + "天，规则配置错误，请重新配置！");
					abort();
				}
			}else if((off == null && go == null) || (off != null && go != null && go.equals(false) && off.equals(false))){//正常
				if (one != null && two == null && three == null && four == null) {
					MsgBox.showInfo("第" + (i + 1) + "天，规则配置错误，请重新配置！");
					abort();
				}else if(one != null && two != null && three != null && four == null){
					MsgBox.showInfo("第" + (i + 1) + "天，规则配置错误，请重新配置！");
					abort();
				}
			}
		}
	}

	/**
	 * 校验本项目或本项目下的合作单位是否有默认考勤规则
	 * @throws BOSException
	 */
	private void checkIfHaveDefaultRule() throws BOSException {
		if (this.chkdefaultRule.isSelected()) {
			PeriodInfo monthInfo = (PeriodInfo) this.prmtmonthYear.getValue();//年月
	    	AdminOrgUnitInfo proj = (AdminOrgUnitInfo) this.prmtproCom.getValue();//项目
	    	AdminOrgUnitInfo coop = (AdminOrgUnitInfo) this.prmtcooperation.getValue();//合作单位
	    	FilterInfo filter = new FilterInfo();
	    	EntityViewInfo view = new EntityViewInfo();
	    	filter.getFilterItems().add(new FilterItemInfo("proCom.id",proj.getId()));
	    	filter.getFilterItems().add(new FilterItemInfo("monthYear.id",monthInfo.getId()));
	    	if (coop != null) {
	    		filter.getFilterItems().add(new FilterItemInfo("cooperation.id",coop.getId()));
			}
	    	view.setFilter(filter);
	    	AlgCheckRulesCollection col = AlgCheckRulesFactory.getRemoteInstance().getAlgCheckRulesCollection(view);
	    	if (col.size() > 1) {
				MsgBox.showInfo("所选项目" + (coop == null ? "" : "及合作单位") + "已有默认考勤规则，请勿重复创建");
				abort();
			}
		}
	}

	/**
	 * 校验表头四个打卡时间是否符合顺序
	 */
	private void checkAttTimes() {
		if (this.amOne.getValue() != null||this.amTwo.getValue() != null||this.pmOne.getValue() != null||this.pmTwo.getValue() != null ) {
			long t1 = ((Date)this.amOne.getValue()).getTime();
			long t2 = ((Date)this.amTwo.getValue()).getTime();
			long t3 = ((Date)this.pmOne.getValue()).getTime();
			long t4 = ((Date)this.pmTwo.getValue()).getTime();
			long max4 = Math.max(t4, Math.max(t3, Math.max(t1, t2)));
			long max3 = Math.max(t3, Math.max(t1, t2));
			long max2 =  Math.max(t1, t2);
			if (t4 != max4) {
				MsgBox.showInfo("第四次打卡时间应为最后打卡时间，请重新填写！");
				this.pmTwo.setValue(null);
				abort();
			}
			if (t3 != max3) {
				MsgBox.showInfo("第三次打卡时间应早于第四次打卡时间，迟于第三次打卡时间，请重新填写！");
				this.pmOne.setValue(null);
				abort();
			}
			if (t2 != max2) {
				MsgBox.showInfo("第二次打卡时间应迟于第一次打卡时间，请重新填写！");
				this.amTwo.setValue(null);
				abort();
			}
	    }
	}

	/**
	 * 不为空校验
	 * @param row
	 */
	private void checkNull() {
		if (this.txtname.getText() == null) {
			MsgBox.showInfo("规则名称不可为空！");
			abort();
		}
		if (this.prmtmonthYear.getValue() == null) {
			MsgBox.showInfo("年月不可为空！");
			abort();
		}
		if (this.pkBizDate.getValue() == null) {
			MsgBox.showInfo("业务日期不可为空！");
			abort();
		}
		if (this.prmtproCom.getValue() == null) {
			MsgBox.showInfo("所属项目不可为空！");
			abort();
		}
		if (this.txtaftBefmins.getText() == null) {
			MsgBox.showInfo("迟到早退事假不可为空，若无则填0！");
			abort();
		}
	}

	//表头项目F7过滤
	private void filterOrg() throws BOSException{
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("number","H%",CompareType.NOTLIKE));
		filterInfo.getFilterItems().add(new FilterItemInfo("number","fb001",CompareType.NOTEQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("number","CSCEC",CompareType.NOTEQUALS));
		evi.setFilter(filterInfo);
		prmtproCom.setEntityViewInfo(evi);
	}

	//表头合作单位F7过滤
	private void filterCoop() throws BOSException{
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("number","H%",CompareType.LIKE));
		filterInfo.getFilterItems().add(new FilterItemInfo("number","fb001",CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("number","CSCEC",CompareType.EQUALS));
		filterInfo.setMaskString("#0 OR #1 OR #2");
		evi.setFilter(filterInfo);
		prmtcooperation.setEntityViewInfo(evi);
	}
	
	protected void setButtonStatus() {
    	AlgCheckRulesInfo bill;
		if ("VIEW".equals(getOprtState())) {
			bill = (AlgCheckRulesInfo) this.editData;
			if (this.editData != null) {
				if ((BillStateEnum.CHECKED.equals(bill.getBillSatee()))|| (BillStateEnum.CHECKING.equals(bill.getBillSatee()))|| (BillStateEnum.DSTRY.equals(bill.getBillSatee()))) {//|| (BillStateEnum.SIGNED.equals(bill.getBillSate())
					this.actionEdit.setEnabled(false);
					this.actionRemove.setEnabled(false);
				} else {
					this.actionRemove.setEnabled(true);
					this.actionEdit.setEnabled(true);
				}
			}
			this.actionAddLine.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionInsertLine.setEnabled(false);
		} else {
			bill = (AlgCheckRulesInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null)
					&& (BillStateEnum.SUBMIT.equals(bill.getBillSatee()))) {
				this.actionSave.setEnabled(false);
			}
		}
		if (((this.editData != null) && (BillStateEnum.CHECKED.equals(bill.getBillSatee())))|| ("ADDNEW".equalsIgnoreCase(getOprtState()))) {
			this.actionPrint.setEnabled(false);
			this.actionPrintPreview.setEnabled(false);
			this.actionAttachment.setEnabled(false);
		} else {
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(true);
		}
		if (this.editData != null) {
			bill = (AlgCheckRulesInfo) this.editData;
			if (!(BillStateEnum.DRAFT.equals(bill.getBillSatee()))) {
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
     * output class constructor
     */
    public AlgCheckRulesEditUI() throws Exception
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
      //表头项目和合作单位f7过滤
    	filterCoop();
    	filterOrg();
    }

    /**
     * 保存前校验
     */
    protected void doBeforeSave(ActionEvent e) throws Exception {
    	super.doBeforeSave(e);
	}
    
    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
      //表头项目和合作单位f7过滤
    	filterCoop();
    	filterOrg();
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.attendance.AlgCheckRulesFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo objectValue = new com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}