/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.client;

import java.awt.event.*;
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
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.attendance.AlgCheckRulesCollection;
import com.kingdee.eas.zjlw.attendance.AlgCheckRulesFactory;
import com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo;
import com.kingdee.eas.zjlw.attendance.AlgPersEntryCollection;
import com.kingdee.eas.zjlw.attendance.AlgPersEntryFactory;
import com.kingdee.eas.zjlw.attendance.AlgPersEntryInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryCollection;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryFactory;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo;
import com.kingdee.eas.zjlw.social.InsurePersonEntryCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryFactory;
import com.kingdee.eas.zjlw.social.InsurePersonEntryInfo;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class AlgPersEditUI extends AbstractAlgPersEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AlgPersEditUI.class);
    public void onLoad() throws Exception {
    	super.onLoad();
    	if (getOprtState().equals("ADDNEW")) {
    		this.pkBizDate.setValue(new Date());
    		//初始化单据
    		initEntry();
//    		//获取合作单位代码
//    		getCoopCode();
    	}
    	
    	if (getOprtState().equals("EDIT")) {
    		this.pkBizDate.setValue(new Date());
    		//初始化单据
    		updateEntry();
//    		//获取合作单位代码
//    		getCoopCode();
    	}
    	addKdtEntryDetailPanelListener();
    	
    	//界面按钮隐藏或显示
    	kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
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
     * 初始化单据
     * @throws BOSException 
     * @throws EASBizException 
     */
    public void initEntry() throws EASBizException, BOSException {
    	LocalInfoEntryCollection localCol = getLocal();
    	for (int i = 0; i < localCol.size(); i++) {
    		LocalInfoEntryInfo localEInfo = localCol.get(i);
    		init(localEInfo);
		}
	}
    
    /**
     * 编辑时更新分录
     * @throws BOSException 
     * @throws EASBizException 
     */
    private void updateEntry() throws EASBizException, BOSException {
    	//用人员id和分录id比较是否重复
    	AdminOrgUnitInfo prmtInfo = (AdminOrgUnitInfo) this.prmtproCom.getValue();
    	FilterInfo filter = new FilterInfo();
    	filter.getFilterItems().add(new FilterItemInfo("parent.proCom.id",prmtInfo.getId()));
    	EntityViewInfo view = new EntityViewInfo();
    	view.setFilter(filter);
    	Set fpSCNumSet = new HashSet();
    	AlgPersEntryCollection foriPersCol = AlgPersEntryFactory.getRemoteInstance().getAlgPersEntryCollection(view);
		if (foriPersCol != null && foriPersCol.size() > 0) {
			for (int i = 0; i < foriPersCol.size(); i++) {
				AlgPersEntryInfo foriPersInfo = foriPersCol.get(i);
				fpSCNumSet.add(foriPersInfo.getPersonID());
			}
		}
		LocalInfoEntryCollection localCol = getLocal();
		if (localCol != null && localCol.size() > 0) {
			for (int i = 0; i < localCol.size(); i++) {
				LocalInfoEntryInfo localInfo = localCol.get(i);
				if (!fpSCNumSet.contains(localInfo.getId().toString())) {
					//向参保人员名单中添加该条数据
					init(localInfo);
				}
			}
		}
	}

    /**
     * 单条分录赋值
     * @param localEInfo
     * @throws EASBizException
     * @throws BOSException
     */
	private void init(LocalInfoEntryInfo localEInfo) throws EASBizException, BOSException {
		AdminOrgUnitInfo workOrg = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(localEInfo.getWorkProgram().getId()));
		AdminOrgUnitInfo cooperation = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(localEInfo.getCooperation().getId()));
		IRow row = this.kdtEntrys.addRow();
		row.getCell("personID").setValue(localEInfo.getId());//人员主键
		row.getCell("name").setValue(localEInfo.getFirstName() + "\b" + localEInfo.getLastName());//姓名	
		row.getCell("sex").setValue(localEInfo.getSex());//性别
		row.getCell("cooperation").setValue(cooperation);//合作单位
		row.getCell("cooperationId").setValue(cooperation.getNumber());//合作单位代码
		row.getCell("checkRuleId").setValue(getRule(workOrg,cooperation));//考勤规则
	}
	
	/**
	 * 获取考勤规则
	 * @param workOrg
	 * @param cooperation
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private Object getRule(AdminOrgUnitInfo workOrg,AdminOrgUnitInfo cooperation) throws BOSException, EASBizException {
		FilterInfo filter1 = new FilterInfo();
    	filter1.getFilterItems().add(new FilterItemInfo("defaultRule",true));
    	filter1.getFilterItems().add(new FilterItemInfo("proCom.id",workOrg.getId()));
    	filter1.getFilterItems().add(new FilterItemInfo("cooperation",null,CompareType.NOTEQUALS));
    	EntityViewInfo view1 = new EntityViewInfo();
    	view1.setFilter(filter1);
    	SelectorItemCollection sic1 = new SelectorItemCollection();
    	sic1.add("*");
    	view1.setSelector(sic1);
    	AlgCheckRulesCollection AlgCheckRulesCol1 = AlgCheckRulesFactory.getRemoteInstance().getAlgCheckRulesCollection(view1);
		for (int i = 0; i < AlgCheckRulesCol1.size(); i++) {
			if (AlgCheckRulesCol1.get(i).getCooperation() != null) {
				if (cooperation.getId().equals(AlgCheckRulesCol1.get(i).getCooperation().getId())) {
					return AlgCheckRulesFactory.getRemoteInstance().getAlgCheckRulesInfo(new ObjectUuidPK(AlgCheckRulesCol1.get(i).getId()));
				}
			}
			
		}
		FilterInfo filter = new FilterInfo();
    	filter.getFilterItems().add(new FilterItemInfo("defaultRule",true));
    	filter.getFilterItems().add(new FilterItemInfo("proCom.id",workOrg.getId()));
    	filter.getFilterItems().add(new FilterItemInfo("cooperation",null));
    	EntityViewInfo view = new EntityViewInfo();
    	view.setFilter(filter);
    	SelectorItemCollection sic = new SelectorItemCollection();
    	sic.add("*");
    	view.setSelector(sic);
    	AlgCheckRulesCollection AlgCheckRulesCol = AlgCheckRulesFactory.getRemoteInstance().getAlgCheckRulesCollection(view);
    	return AlgCheckRulesCol.size()>0?AlgCheckRulesFactory.getRemoteInstance().getAlgCheckRulesInfo(new ObjectUuidPK(AlgCheckRulesCol.get(0).getId())):null;
	}



	/**
     * 添加分录监听事件，实现分录表格默认值
     */
    private void addKdtEntryDetailPanelListener() {
    	IDetailPanelListener listener = new DetailPanelAdapter() {
    		public void beforeEvent(DetailPanelEvent e) throws Exception {
    			setLineValue(e); //设置分录表格的默认值
    		}
    	};
    	kdtEntrys_detailPanel.addAddListener(listener);//模板增加监听
    }
    
    /**
     * 实现IDetailPanelListener接口
     */
    private static class DetailPanelAdapter implements IDetailPanelListener {
	  public DetailPanelAdapter() {}
	  public void beforeEvent(DetailPanelEvent e) throws Exception {}
	  public void afterEvent(DetailPanelEvent e) throws Exception {}
    }
    /**
     * 新增一行的时候，设置默认值
     * @throws BOSException 
     */
    private void setLineValue(DetailPanelEvent e) throws BOSException {
    	AlgPersEntryInfo insEntryInfo = (AlgPersEntryInfo) e.getObjectValue(); //获取分录对象
    	FilterInfo filter = new FilterInfo();
    	filter.getFilterItems().add(new FilterItemInfo("defualtRule",true));
    	EntityViewInfo view = new EntityViewInfo();
    	view.setFilter(filter);
    	SelectorItemCollection sic = new SelectorItemCollection();
    	sic.add("*");
    	view.setSelector(sic);
    	AlgCheckRulesCollection AlgCheckRulesCol = AlgCheckRulesFactory.getRemoteInstance().getAlgCheckRulesCollection(view);
		if (AlgCheckRulesCol.size() != 0) {
	        insEntryInfo.setCheckRuleId(AlgCheckRulesCol.get(0));
		}
    }
	

    /**
     * 获取属地化数据
     * @return 
     * @throws BOSException 
     * @throws EASBizException 
     */
	private LocalInfoEntryCollection getLocal() throws EASBizException, BOSException {
		AdminOrgUnitInfo permitInfo = (AdminOrgUnitInfo) this.prmtproCom.getValue();
		AdminOrgUnitInfo pmtInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(permitInfo==null?null:permitInfo.getId()));
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
        SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("*");
		filter.getFilterItems().add(new FilterItemInfo("workProgram.id",pmtInfo.getId()));
		filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
		view.setFilter(filter);
		view.setSelector(sic);
		LocalInfoEntryCollection persHisCol = LocalInfoEntryFactory.getRemoteInstance().getLocalInfoEntryCollection(view);
		if (persHisCol.size() == 0) {
			MsgBox.showInfo("所选项目暂无属地化员工！");
			abort();
		}
		return persHisCol;
	}

    /**
     * output class constructor
     */
    public AlgPersEditUI() throws Exception
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
        return com.kingdee.eas.zjlw.attendance.AlgPersFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.attendance.AlgPersInfo objectValue = new com.kingdee.eas.zjlw.attendance.AlgPersInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        FullOrgUnitInfo fullInfo= (FullOrgUnitInfo) getUIContext().get("projectOrgInfo");
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