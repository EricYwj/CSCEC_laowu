/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.attendance.AlgAttDataEntryFactory;
import com.kingdee.eas.zjlw.attendance.AlgAttDataEntryInfo;
import com.kingdee.eas.zjlw.attendance.AlgCheckRulesEntryInfo;
import com.kingdee.eas.zjlw.attendance.AlgCheckRulesFactory;
import com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo;
import com.kingdee.eas.zjlw.attendance.AlgPersEntryCollection;
import com.kingdee.eas.zjlw.attendance.AlgPersEntryFactory;
import com.kingdee.eas.zjlw.attendance.AlgPersEntryInfo;
import com.kingdee.eas.zjlw.attendance.ForiAttDataEntryFactory;
import com.kingdee.eas.zjlw.attendance.ForiAttDataEntryInfo;
import com.kingdee.eas.zjlw.attendance.ForiAttRuleEntryInfo;
import com.kingdee.eas.zjlw.attendance.ForiAttRuleFactory;
import com.kingdee.eas.zjlw.attendance.ForiAttRuleInfo;
import com.kingdee.eas.zjlw.attendance.ForiPersEntryCollection;
import com.kingdee.eas.zjlw.attendance.ForiPersEntryFactory;
import com.kingdee.eas.zjlw.attendance.ForiPersEntryInfo;
import com.kingdee.eas.zjlw.attendance.app.algResultEnum;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class ForiAttResEditUI extends AbstractForiAttResEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ForiAttResEditUI.class);
    
    public void onLoad() throws Exception {
    	super.onLoad();
    	
    	//点击新增初始化单据
    	if(getOprtState().equals("ADDNEW")){
    		initBill();
    	}
    }
    
    /**
     * 初始化单据
     * @throws BOSException 
     * @throws EASBizException 
     */
    private void initBill() throws EASBizException, BOSException {
    	this.pkBizDate.setValue(new Date());
		//获取本项目人员，以map的key返回
    	Map<ForiPersEntryInfo, ForiAttDataEntryInfo> map = new HashMap<ForiPersEntryInfo, ForiAttDataEntryInfo>();
    	map = getPersByProCom();
    	//根据人员查询考勤数据
    	map = getAlgAttData(map);
    	//比照考勤数据和考勤规则得出结果，并实例化
    	if(map != null){
    		for (Map.Entry<ForiPersEntryInfo, ForiAttDataEntryInfo> entry : map.entrySet()) { 
    			IRow row = this.kdtEntrys.addRow();
    			ForiPersEntryInfo aap = entry.getKey();
    			ForiPersEntryInfo aapInfo = ForiPersEntryFactory.getRemoteInstance().getForiPersEntryInfo(new ObjectUuidPK(aap.getId()));
    			row.getCell("personId").setValue(aapInfo.getPersonID());
        		row.getCell("name").setValue(aapInfo.getName());
        		row.getCell("IDNum").setValue(aapInfo.getIdNum());
        		row.getCell("psspNum").setValue(aapInfo.getPasspNum());
        		row.getCell("sex").setValue(aapInfo.getSex());
        		AdminOrgUnitInfo coop = aapInfo.getCooperation();
        		AdminOrgUnitInfo coopInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(coop.getId()));
        		row.getCell("cooperation").setValue(coopInfo);
        		row.getCell("cooperationid").setValue(coopInfo.getNumber());
        		CountryInfo coun = aapInfo.getCountry();
        		CountryInfo country = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(coun.getId()));
        		row.getCell("nation").setValue(country);
        		ProjectWorkInfo pw = aapInfo.getProf();
        		ProjectWorkInfo pwInfo = ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(pw.getId()));
        		row.getCell("prof").setValue(pwInfo);
        		row.getCell("realProf").setValue(aapInfo.getRealProf());
    			ForiAttDataEntryInfo aad = entry.getValue();
    			if (aad == null) {
    				row.getCell("algResult").setValue(algResultEnum.DISAPP);//考勤结果
				}else{
	    			ForiAttDataEntryInfo aadInfo = ForiAttDataEntryFactory.getRemoteInstance().getForiAttDataEntryInfo(new ObjectUuidPK(aad.getId()));
	    			//获取考勤规则
	    			ForiAttRuleInfo crInfo = aapInfo.getCheckRuleId();
	    			ForiAttRuleInfo acrInfo = ForiAttRuleFactory.getRemoteInstance().getForiAttRuleInfo(new ObjectUuidPK(crInfo.getId()));
	    			Date bizDate = aadInfo.getAttDate();
	    			String dateString = bizDate.toString();
	    			int index = Integer.parseInt(dateString.substring(8, 10));
	    			ForiAttRuleEntryInfo ACREntryInfo = acrInfo.getEntrys().get(index-1);
	    			//规则
	    			BigDecimal tri = ACREntryInfo.getTimeInterval();
	    			//实际数据
	    			Date amOT = aadInfo.getAmOnDuty();//上午上班时间
	    			Date amTT = aadInfo.getAmOutDuty();//上午下班时间
	    			//计算考勤结果
	    			row.getCell("personId").setValue(aapInfo.getPersonID());//人员主键
	    			row.getCell("name").setValue(aapInfo.getName());//姓名
					if (amOT == null || amTT == null) {
						//缺勤
						row.getCell("algResult").setValue(algResultEnum.DISAPP);//考勤结果
					} else {
						//计算实际出勤时间
						float count1 = amTT.getTime() - amOT.getTime();
						float min = count1/(60*1000);
						float hour = min/60;
						if (Integer.parseInt(tri.toString()) < hour && hour < 24) {
							//正常
							row.getCell("algResult").setValue(algResultEnum.NORMAL);//考勤结果
						}else{
							//缺勤
							row.getCell("algResult").setValue(algResultEnum.DISAPP);//考勤结果
						}
					}
				}
			}
    	}
	}

    /**
     * 根据人员集合查询考勤数据集合
     * @param map
     * @return
     * @throws BOSException
     */
    private Map<ForiPersEntryInfo, ForiAttDataEntryInfo> getAlgAttData(Map<ForiPersEntryInfo, ForiAttDataEntryInfo> map) throws BOSException {
    	if (map != null) {
    		for (Map.Entry<ForiPersEntryInfo, ForiAttDataEntryInfo> entry : map.entrySet()) {  
    			ForiPersEntryInfo aapInfo = entry.getKey();
    			ForiAttDataEntryInfo aadEntryInfo = getAlgAttDataEntryInfoByAAP(aapInfo);
    			map.put(aapInfo, aadEntryInfo);
        	}
		}
		return map;
	}
    
    /**
     * 根据考勤人员获取考勤数据
     * @param aapInfo
     * @return
     * @throws BOSException 
     */
	private ForiAttDataEntryInfo getAlgAttDataEntryInfoByAAP(ForiPersEntryInfo aapInfo) throws BOSException {
		String personId = aapInfo.getPersonID();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("personId",personId));
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("parent.bizDate");
		sic.add("number");
		sic.add("name");
		sic.add("secuNum");
		sic.add("sex");
		sic.add("workOrgId");
		sic.add("checkRuleId");
		sic.add("CheckSysDepNo");
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		view.setSelector(sic);
		ForiAttDataEntryInfo info = ForiAttDataEntryFactory.getRemoteInstance().getForiAttDataEntryCollection(view).get(0);
		return info;
	}

	/**
     * 获取本项目的人员
     * @return
     * @throws BOSException 
     * @throws EASBizException 
     */
	private Map<ForiPersEntryInfo, ForiAttDataEntryInfo> getPersByProCom() throws EASBizException, BOSException {
		AdminOrgUnitInfo admin = (AdminOrgUnitInfo) this.prmtproCom.getValue();
		AdminOrgUnitInfo adminInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(admin.getId()));
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("parent.permitOrg.id",adminInfo.getId()));
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("*");
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		view.setSelector(sic);
		ForiPersEntryCollection aapCol = ForiPersEntryFactory.getRemoteInstance().getForiPersEntryCollection(view);
		Map<ForiPersEntryInfo, ForiAttDataEntryInfo> map = new HashMap<ForiPersEntryInfo, ForiAttDataEntryInfo>();
		for (int i = 0; i < aapCol.size(); i++) {
			map.put(aapCol.get(i), null);
		}
		return map;
	}
    /**
     * output class constructor
     */
    public ForiAttResEditUI() throws Exception
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
        return com.kingdee.eas.zjlw.attendance.ForiAttResFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.attendance.ForiAttResInfo objectValue = new com.kingdee.eas.zjlw.attendance.ForiAttResInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        FullOrgUnitInfo fullInfo= (FullOrgUnitInfo) getUIContext().get("projectOrgInfo");
    	if(fullInfo==null){
    		MsgBox.showInfo("请选择工作项目进行新增！");
    		this.abort();
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