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

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.certificates.AntiLogoutEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiLogoutEntryFactory;
import com.kingdee.eas.zjlw.certificates.AntiLogoutEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiLogoutFactory;
import com.kingdee.eas.zjlw.certificates.AntiLogoutInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.app.AntiLogoutEntryController;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class AntiLogoutEditUI extends AbstractAntiLogoutEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AntiLogoutEditUI.class);
    
    public void onLoad() throws Exception {
    	kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
		this.billState.setEnabled(false);
		this.txtNumber.setEnabled(false);
    	super.onLoad();
    	
    	//�޸ļ������ĺͷ��ı༭����ĵ����������б��������һ��  modified by wangth on 20170628 start
		String strLanguage = com.kingdee.eas.common.client.SysContext.getSysContext().getLocale().getLanguage();
		if("L1".equals(strLanguage) || "l1".equals(strLanguage)){
			setUITitle("");
		}
		else if("L2".equals(strLanguage) || "l2".equals(strLanguage)){
			setUITitle("��ǩע��");
		}
		else{
//			setUITitle("");
		}
		//�޸ļ������ĺͷ��ı༭����ĵ����������б��������һ��  modified by wangth on 20170628 end
		
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		date=sdf.parse(sdf.format(date));  
		//�ݽ���ǩע������ʱ��
		if ("subDate".equals(key)){ 
			if(row.getCell("subDate").getValue()!=null){
				//1.��3��<=����ʱ��-today<=3�졣
				Date subDate=(Date) row.getCell("subDate").getValue();
				long time=(subDate.getTime()-date.getTime())/86400000;
				int dayCou = Integer.parseInt(String.valueOf(time));
//				if(dayCou>3||dayCou<-3){
//					MsgBox.showInfo("��ѡ���ڱ����ڵ�ǰ����ǰ������֮�ڣ�������ѡ��");
//    				row.getCell("subDate").setValue(null);
//    				this.abort();
//				}
				//�ݽ���ǩע������ʱ�������ڵ��ڷ�ǩ��Чʱ��
				if(row.getCell("antiSgTime").getValue()!=null){
					Date antiSgTime=(Date) row.getCell("antiSgTime").getValue();
					if(subDate.before(antiSgTime)){
						MsgBox.showInfo("��ѡ���ڱ�����ڵ��ڷ�ǩ��Чʱ�䣬������ѡ��");
	    				row.getCell("sendLaBuDate").setValue(null);
	    				this.abort();
					}
				}
			}
		}
		//��ǩע�����ʱ��
		if("logoutDate".equals(key)){
			if(row.getCell("logoutDate").getValue()!=null){
				//1.��3��<=����ʱ��-today<=3�졣
				Date logoutDate=(Date) row.getCell("logoutDate").getValue();
				long time=(logoutDate.getTime()-date.getTime())/86400000;
				int dayCou = Integer.parseInt(String.valueOf(time)); 
//				if(dayCou<-3 || dayCou>3){ywj1006
//					MsgBox.showInfo("��ѡ���ڱ����ڵ�ǰ����ǰ������֮�ڣ�������ѡ��");
//    				row.getCell("logoutDate").setValue(null);
//    				this.abort();
//				}
				//2.��ǩע�����ʱ�������ڵ��ڵݽ���ǩע������ʱ��
				if(row.getCell("subDate").getValue()!=null){
					Date subDate=(Date) row.getCell("subDate").getValue();
					if(logoutDate.before(subDate)){
						MsgBox.showInfo("��ѡ���ڱ�����ڵ��ڵݽ���ǩע������ʱ�䣬������ѡ��");
	    				row.getCell("antiSgTime").setValue(null);
	    				this.abort();
					}
				}
			}
		}
    }
    /**
     * output class constructor
     */
    public AntiLogoutEditUI() throws Exception
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
		//ֻ���ݴ�״̬���Ա���
		if(this.editData!=null && this.editData.getId()!=null){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billState");
			AntiLogoutInfo fiInfo = AntiLogoutFactory.getRemoteInstance().getAntiLogoutInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillState()!=null&&!BillStateEnum.DRAFT.equals(fiInfo.getBillState())){
				MsgBox.showInfo("��ǰ����״̬Ϊ��"+fiInfo.getBillState().getAlias()+"���������ظ����棡");
				abort();
			}
		}
        super.actionSave_actionPerformed(e);
    }

    protected void doBeforeSubmit(ActionEvent e) throws Exception {
    	//ֻ���ݴ�������ύ״̬�����ύ
		if(this.editData!=null && this.editData.getId()!=null){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billState");
			AntiLogoutInfo fiInfo = AntiLogoutFactory.getRemoteInstance().getAntiLogoutInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillState()!=null&&!(BillStateEnum.DRAFT.equals(fiInfo.getBillState())||BillStateEnum.SUBMIT.equals(fiInfo.getBillState()))){
				MsgBox.showInfo("��ǰ����״̬Ϊ��"+fiInfo.getBillState().getAlias()+"���������ظ��ύ��");
				abort();
			}
		}
		checkEmpty();
    	super.doBeforeSubmit(e);
    }
    public void checkEmpty() throws ParseException, BOSException{
    	int rowCount =kdtEntrys.getRowCount();
    	for(int i=0;i<rowCount;i++){
    		IRow row=kdtEntrys.getRow(i);
    		//ͬһ���κ�ͬһ�˲��������ύע��
    		if(row.getCell("personID").getValue()!=null){
    			EntityViewInfo view = new EntityViewInfo();
    			FilterInfo filter = new FilterInfo();
    			filter.getFilterItems().add(new FilterItemInfo("personID",row.getCell("personID").getValue().toString()));
    			if(this.editData != null&&this.editData.getId() != null){
    				filter.getFilterItems().add(new FilterItemInfo("parent.id",this.editData.getId().toString(),CompareType.NOTEQUALS));
    			}
    			view.setFilter(filter);
    			AntiLogoutEntryCollection col = AntiLogoutEntryFactory.getRemoteInstance().getAntiLogoutEntryCollection(view);
    			if(col.size()>0){
    				MsgBox.showInfo("��Ա�Ѵ��ڷ�ǩע�����ݣ��������ظ��ύ��");
    				this.abort();
    			}
    		}
			
    		if(row.getCell("subDate").getValue()==null){
    			MsgBox.showInfo("�ݽ���ǩע������ʱ��Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
    		}
    		if(row.getCell("logoutDate").getValue()==null){
    			MsgBox.showInfo("��ǩע�����ʱ��Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
    		}
    		if(row.getCell("docAffiliatedD").getValue().equals(false)){
    			MsgBox.showInfo("��ǩע�����ҿ���δ��ѡ���޷��ύ�����������룡");
    			this.abort();
    		}
    		Date subDate=(Date) row.getCell("subDate").getValue();
    		Date logoutDate=(Date) row.getCell("logoutDate").getValue();
    		//.�ݽ���ǩע������ʱ�������ڵ��ڷ�ǩ��Чʱ��
    		if(row.getCell("antiSgTime").getValue()!=null){
    			Date antiSgTime=(Date) row.getCell("antiSgTime").getValue();
    			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
    			antiSgTime=sdf.parse(sdf.format(antiSgTime));
    			if(subDate.before(antiSgTime)){
    				MsgBox.showInfo("�ݽ���ǩע������ʱ��С�ڷ�ǩ��Чʱ�䣬�޷��ύ������������");
    				this.abort();
    			}
    		}
    		//.��ǩע�����ʱ�������ڵ��ڵݽ���ǩע������ʱ��
    		if(logoutDate.before(subDate)){
    			MsgBox.showInfo("��ǩע�����ʱ��С�ڵݽ���ǩע������ʱ�䣬�޷��ύ������������");
    			this.abort();
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
        return com.kingdee.eas.zjlw.certificates.AntiLogoutFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.certificates.AntiLogoutInfo objectValue = new com.kingdee.eas.zjlw.certificates.AntiLogoutInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
    
    protected void setButtonStatus() {
    	AntiLogoutInfo bill;
		if ("VIEW".equals(getOprtState())) {
//			this.actionAudit.setVisible(true);
//			this.actionUnAudit.setVisible(true);
//			this.actionAudit.setEnabled(true);
//			this.actionUnAudit.setEnabled(true);

			bill = (AntiLogoutInfo) this.editData;
			if (this.editData != null) {
				if ((BillStateEnum.CHECKED.equals(bill.getBillState()))) {//|| (BillStateEnum.SIGNED.equals(bill.getBillSate())
//					this.actionUnAudit.setVisible(true);
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
			bill = (AntiLogoutInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null)
					&& (BillStateEnum.SUBMIT.equals(bill.getBillState()))) {
				this.actionSave.setEnabled(false);
			}

//			this.actionAudit.setVisible(false);
//			this.actionUnAudit.setVisible(false);
//			this.actionAudit.setEnabled(false);
//			this.actionUnAudit.setEnabled(false);
		}
		if (((this.editData != null) && (BillStateEnum.CHECKED.equals(bill
				.getBillState())))
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
			bill = (AntiLogoutInfo) this.editData;
			if (!(BillStateEnum.DRAFT.equals(bill.getBillState()))) {
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

}