/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.attendance.AlgAttCollection;
import com.kingdee.eas.zjlw.attendance.AlgAttFactory;
import com.kingdee.eas.zjlw.attendance.AlgAttInfo;
import com.kingdee.eas.zjlw.attendance.AlgAttResCollection;
import com.kingdee.eas.zjlw.attendance.AlgAttResEntryCollection;
import com.kingdee.eas.zjlw.attendance.AlgAttResEntryFactory;
import com.kingdee.eas.zjlw.attendance.AlgAttResEntryInfo;
import com.kingdee.eas.zjlw.attendance.AlgAttResFactory;
import com.kingdee.eas.zjlw.attendance.AlgAttResInfo;
import com.kingdee.eas.zjlw.attendance.app.algResultEnum;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.certificates.ImmigrationInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class AlgAttEditUI extends AbstractAlgAttEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AlgAttEditUI.class);
    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
    
    public void onLoad() throws Exception {
    	super.onLoad();
    	//业务日期赋值当前时间
    	if (getOprtState().equals("ADDNEW")) {
			this.pkBizDate.setValue(new Date());
		}
    	
    	//系统值不可编辑
    	kdtEntrys.getColumn("name").getStyleAttributes().setLocked(true);//姓
    	kdtEntrys.getColumn("chcNormal").getStyleAttributes().setLocked(true);//考勤正常天数
    	kdtEntrys.getColumn("chkDis").getStyleAttributes().setLocked(true);//考勤缺勤天数
    	kdtEntrys.getColumn("noWorkTime").getStyleAttributes().setLocked(true);//迟到早退时间
    	kdtEntrys.getColumn("hoOverTime").getStyleAttributes().setLocked(true);//节假日加班时间
    	kdtEntrys.getColumn("traDays").getStyleAttributes().setLocked(true);//出差天数
    	kdtEntrys.getColumn("overTime").getStyleAttributes().setLocked(true);//加班时间
    	kdtEntrys.getColumn("workDay").getStyleAttributes().setLocked(true);//出勤天数
    	
    	//界面按钮不可见
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

    }
    
    /**
     * 考勤开始时间值改变事件
     */
    protected void pkbeginDate_dataChanged(DataChangeEvent e) throws Exception {
    	super.pkbeginDate_dataChanged(e);
    	
    	//初始化单据
    	init();
    }
    

	/**
     * 考勤结束时间值改变事件
     */
    protected void pkendDate_dataChanged(DataChangeEvent e) throws Exception {
    	super.pkendDate_dataChanged(e);
    	
    	//初始化单据
    	init();
    }
    
    /**
     * 根据考勤起止时间和项目名称生成考勤表；
     * @throws BOSException 
     * @throws EASBizException 
     */
    private void init() throws EASBizException, BOSException {
    	this.kdtEntrys.removeRows();
    	Date begin = (Date) this.pkbeginDate.getValue();
    	Date end = (Date) this.pkendDate.getValue();
    	if (begin != null && end != null) {
			//查询时间区间内所有考勤结果分录集合
    		AlgAttResEntryCollection aarCol = getAlgAttRes();
    		
    		//循环集合，获取所有的人员编号集合
    		Set perIdSet = new HashSet();
    		for (int i = 0; i < aarCol.size(); i++) {
    			AlgAttResEntryInfo aarEntryInfo = aarCol.get(i);
    			perIdSet.add(aarEntryInfo.getPersonId());
			}
    		
    		//循环人员编号集合和考勤开始、结束时间，通过人员编号查询人员考勤结果
    		for (Object personId : perIdSet) {
    			FilterInfo filter = new FilterInfo();
    			EntityViewInfo view = new EntityViewInfo();
    			filter.getFilterItems().add(new FilterItemInfo("personId",personId));
    			filter.getFilterItems().add(new FilterItemInfo("parent.endDate",end,CompareType.LESS_EQUALS));
    	    	filter.getFilterItems().add(new FilterItemInfo("parent.beginDate",begin,CompareType.GREATER_EQUALS));
    			view.setFilter(filter);
//    			view.setSelector(getAlgAttResSelector());
    			AlgAttResEntryCollection aarPersCol = AlgAttResEntryFactory.getRemoteInstance().getAlgAttResEntryCollection(view);
    			
    			//根据集合计算总数
    			int chkNormal = 0;//考勤正常
    			int chkDis = 0;//考勤缺勤
    			String name = "";//姓名
    			int noWorkTime = 0;//迟到早退时间
    			long hoOverTime = 0;//节假日加班
    			long overTime = 0;//加班时间
    			int workDay = 0;//出勤天数
    			for (int i = 0; i < aarPersCol.size(); i++) {
    				AlgAttResEntryInfo info = aarPersCol.get(i);
    				name = info.getName();
    				noWorkTime = noWorkTime + info.getNoWorkTime();
    				hoOverTime = hoOverTime + (info.getHoOverTime()==null?0:info.getHoOverTime().longValue());
    				overTime = overTime + (info.getOverTime()==null?0:info.getOverTime().longValue());
    				if (algResultEnum.NORMAL.equals(info.getAlgResult())) {
    					chkNormal++;
					}else{
						chkDis++;
					}
    				workDay++;
				}
    			
    			//赋值分录
    			IRow row = this.kdtEntrys.addRow();
    			//系统值
    			row.getCell("name").setValue(name);
    			row.getCell("noWorkTime").setValue(noWorkTime);
    			row.getCell("hoOverTime").setValue(hoOverTime);
    			row.getCell("overTime").setValue(overTime);
    			row.getCell("workDay").setValue(workDay);
    			row.getCell("chcNormal").setValue(chkNormal);
    			row.getCell("chkDis").setValue(chkDis);
    			//修订值
    			row.getCell("CnoWorkTime").setValue(noWorkTime);
    			row.getCell("ChoOverTime").setValue(hoOverTime);
    			row.getCell("CoverTime").setValue(overTime);
    			row.getCell("CworkDay").setValue(workDay);
    			row.getCell("CchkNormal").setValue(chkNormal);
    			row.getCell("CchkDis").setValue(chkDis);
    		}
		}
	}
    
	/**
     * 查询时间区间内所有考勤结果集合
     * @return
     * @throws BOSException 
     * @throws EASBizException 
     */
	private AlgAttResEntryCollection getAlgAttRes() throws EASBizException, BOSException {
		FilterInfo filter = new FilterInfo();
    	EntityViewInfo view = new EntityViewInfo();
    	Date begin = (Date) this.pkbeginDate.getValue();
    	Date end = (Date) this.pkendDate.getValue();
    	AdminOrgUnitInfo proCom = (AdminOrgUnitInfo) this.prmtproCom.getValue();
    	AdminOrgUnitInfo proComInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(proCom.getId()));
    	filter.getFilterItems().add(new FilterItemInfo("attDate",end,CompareType.LESS_EQUALS));
    	filter.getFilterItems().add(new FilterItemInfo("attDate",begin,CompareType.GREATER_EQUALS));
    	filter.getFilterItems().add(new FilterItemInfo("parent.proCom.id",proComInfo.getId()));
    	view.setFilter(filter);
    	view.setSelector(getAlgAttResSelector());
    	AlgAttResEntryCollection aarCol = AlgAttResEntryFactory.getRemoteInstance().getAlgAttResEntryCollection(view);
    	if (aarCol.size() == 0) {
			MsgBox.showInfo("无考勤记录，请检验查询条件！");
			abort();
		}
		return aarCol;
	}
	
	
	/**
	 * 返回阿工考勤结果分录的selector
	 * @return
	 */
	private SelectorItemCollection getAlgAttResSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("parent.proCom.id");
		sic.add("personId");//人员主键
		sic.add("name");//姓名
		sic.add("algResult");//考勤结果
		sic.add("noWorkTime");//迟到早退时间
		sic.add("hoOverTime");//节假日加班
		sic.add("overTime");//加班时间
		sic.add("attDate");//考勤日期
		return sic;
	}
	
	
	
	/**
	 * 提交前校验
	 */
	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		super.doBeforeSubmit(e);
		//校验：考勤开始时间不可大于考勤结束时间
    	long begin = ((Date) this.pkbeginDate.getValue()).getTime();
		long end = ((Date) this.pkendDate.getValue()).getTime();
    	if (begin > end) {
			MsgBox.showInfo("开始时间不允许大于结束时间，请重新填写！");
			abort();
		}
		
		
		//是否有存在与本单据考勤时间区间存在交集的审核通过单据
		//校验是否之前的数据存在重复的时间段或时间点
		String ownStart = format.format((Date)this.pkbeginDate.getValue());
		String ownEnd = format.format((Date)this.pkendDate.getValue()).toString();
		AlgAttCollection aarCol = getAaCol();
		for (int i = 0; i < aarCol.size(); i++) {
			AlgAttInfo info = aarCol.get(i);
			getOverlap(ownStart, ownEnd, format.format(info.getBeginDate()), format.format(info.getEndDate()));
		}
	}
	
	/**
	 * 获取审核通过的考勤结果
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private AlgAttCollection getAaCol() throws EASBizException, BOSException {
		AdminOrgUnitInfo proCom = (AdminOrgUnitInfo) this.prmtproCom.getValue();
		AdminOrgUnitInfo proComInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(proCom.getId()));
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		filter.getFilterItems().add(new FilterItemInfo("proCom.id",proCom.getId()));
		filter.getFilterItems().add(new FilterItemInfo("billSate",BillStateEnum.CHECKED));
		sic.add("beginDate");
		sic.add("endDate");
		view.setFilter(filter);
		view.setSelector(sic);
		AlgAttCollection col = AlgAttFactory.getRemoteInstance().getAlgAttCollection(view);
		return col;
	}
	
	/**
	 * 两个时间段是否存在交集
	 * @param startdate1
	 * @param enddate1
	 * @param startdate2
	 * @param enddate2
	 * 
	 */
    private void getOverlap(String ownStart, String ownEnd,String otherStart, String otherEnd) {  
        Date from1 = null;  
        Date to1 = null;  
        Date from2 = null;  
        Date to2 = null;  
        try {  
        	from1 = format.parse(ownStart);  
        	to1 = format.parse(ownEnd);  
        	from2 = format.parse(otherStart);  
        	to2 = format.parse(otherEnd);  
        } catch (ParseException e) {  
        }  
        long f1 = from1.getTime();
        long t1 = to1.getTime();
        long f2 = from2.getTime();
        long t2 = to2.getTime();
        
        if (f2 < f1) {
			if (f1 == t2) {
				MsgBox.showInfo("已有" + ownStart + "的考勤结果，请勿重复生成！");
				abort();
			}
			if (f1 < t2 && t2 < t1) {
				MsgBox.showInfo("已有" + ownStart + "到" + otherEnd + "的考勤结果，请勿重复生成！");
				abort();
			}
			if (t1 <= t2) {
				MsgBox.showInfo("已有" + ownStart + "到" + ownEnd + "的考勤结果，请勿重复生成！");
				abort();
			}
			
		}else if(f1 <= f2 && f2 <= t1){
			if (f1 <= f2 && t2 <= t1) {
				MsgBox.showInfo("已有" + otherStart + "到" + otherEnd + "的考勤结果，请勿重复生成！");
				abort();
			}
			if (f1 == f2 && t1 < t2) {
				MsgBox.showInfo("已有" + ownStart + "到" + ownEnd + "的考勤结果，请勿重复生成！");
				abort();
			}
			if (t1 < t2) {
				MsgBox.showInfo("已有" + otherStart + "到" + ownEnd + "的考勤结果，请勿重复生成！");
				abort();
			}
			if (t1 == t2) {
				MsgBox.showInfo("已有" + ownEnd + "的考勤结果，请勿重复生成！");
				abort();
			}
		}
    }
	
    //不同情况下按钮是否可见
    protected void setButtonStatus() {
    	AlgAttInfo bill;
		if ("VIEW".equals(getOprtState())) {
			bill = (AlgAttInfo) this.editData;
			if (this.editData != null) {
				if ((BillStateEnum.CHECKED.equals(bill.getBillSate()))|| (BillStateEnum.CHECKING.equals(bill.getBillSate()))|| (BillStateEnum.DSTRY.equals(bill.getBillSate()))) {//|| (BillStateEnum.SIGNED.equals(bill.getBillSate())
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
			bill = (AlgAttInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null)
					&& (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(false);
			}
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
			bill = (AlgAttInfo) this.editData;
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
     * output class constructor
     */
    public AlgAttEditUI() throws Exception
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
        return com.kingdee.eas.zjlw.attendance.AlgAttFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.attendance.AlgAttInfo objectValue = new com.kingdee.eas.zjlw.attendance.AlgAttInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        FullOrgUnitInfo fullInfo= (FullOrgUnitInfo) getUIContext().get("projectOrgInfo");
        
        if (fullInfo == null) {
			MsgBox.showInfo("请选择工作项目进行新增！");
			abort();
		}
        SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("number"));
		sic.add(new SelectorItemInfo("name"));
        try {
			AdminOrgUnitInfo adminInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(fullInfo.getId()), sic);
			objectValue.setProCom(adminInfo);
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}

        return objectValue;
    }

}