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

import chrriis.common.Filter;

import com.kingdee.bos.BOSException;
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
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.certificates.ExLivepermitInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryEntryFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.DOCTYPE;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class LivepermitEditUI extends AbstractLivepermitEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(LivepermitEditUI.class);
    
    /**
     * output class constructor
     */
    public LivepermitEditUI() throws Exception
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
    //���༭�¼�
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
		DOCTYPE temporary=DOCTYPE.TEMPORARY;//��ʱ֤��
		DOCTYPE formal=DOCTYPE.FORMAL;//��ʽ֤��
		//֤������
		if ("docType".equals(key)){
    		if(temporary.equals(row.getCell("docType").getValue())){
    			row.getCell("pmtNum").getStyleAttributes().setLocked(true);//���Ӻ���
    			row.getCell("pmtSTime").getStyleAttributes().setLocked(true);//���ӳ�֤����
    			row.getCell("pmteffDate").getStyleAttributes().setLocked(true);//������Ч����
    			row.getCell("pmtETime").getStyleAttributes().setLocked(true);//���ӵ�֤����
    			row.getCell("rePmtNum").getStyleAttributes().setLocked(false);//�پӺ���
    			row.getCell("sRePmtSTime").getStyleAttributes().setLocked(false);//�پӳ�֤����
    			row.getCell("rePmtETime").getStyleAttributes().setLocked(false);//�پӵ�֤����
    			row.getCell("pmtNum").setValue(null);//���Ӻ���
    			row.getCell("pmtSTime").setValue(null);//���ӳ�֤����
    			row.getCell("pmteffDate").setValue(null);//������Ч����
    			row.getCell("pmtETime").setValue(null);//���ӵ�֤����
    		}else if(formal.equals(row.getCell("docType").getValue())){
    			row.getCell("rePmtNum").getStyleAttributes().setLocked(true);//�پӺ���
    			row.getCell("sRePmtSTime").getStyleAttributes().setLocked(true);//�پӳ�֤����
    			row.getCell("rePmtETime").getStyleAttributes().setLocked(true);//�پӵ�֤����
    			row.getCell("pmtNum").getStyleAttributes().setLocked(false);//���Ӻ���
    			row.getCell("pmtSTime").getStyleAttributes().setLocked(false);//���ӳ�֤����
    			row.getCell("pmteffDate").getStyleAttributes().setLocked(false);//������Ч����
    			row.getCell("pmtETime").getStyleAttributes().setLocked(false);//���ӵ�֤����
    			row.getCell("rePmtNum").setValue(null);//�پӺ���
    			row.getCell("sRePmtSTime").setValue(null);//�پӳ�֤����
    			row.getCell("rePmtETime").setValue(null);//�پӵ�֤����
    		}else{
    			row.getCell("pmtNum").getStyleAttributes().setLocked(true);//���Ӻ���
    			row.getCell("pmtSTime").getStyleAttributes().setLocked(true);//���ӳ�֤����
    			row.getCell("pmteffDate").getStyleAttributes().setLocked(true);//������Ч����
    			row.getCell("pmtETime").getStyleAttributes().setLocked(true);//���ӵ�֤����
    			row.getCell("rePmtNum").getStyleAttributes().setLocked(true);//�پӺ���
    			row.getCell("sRePmtSTime").getStyleAttributes().setLocked(true);//�پӳ�֤����
    			row.getCell("rePmtETime").getStyleAttributes().setLocked(true);//�پӵ�֤����
    			
    			row.getCell("rePmtNum").setValue(null);//�پӺ���
    			row.getCell("sRePmtSTime").setValue(null);//�پӳ�֤����
    			row.getCell("rePmtETime").setValue(null);//�پӵ�֤����
    			row.getCell("pmtNum").setValue(null);//���Ӻ���
    			row.getCell("pmtSTime").setValue(null);//���ӳ�֤����
    			row.getCell("pmteffDate").setValue(null);//������Ч����
    			row.getCell("pmtETime").setValue(null);//���ӵ�֤����
    		}
		}
//		//��ס֤�ݽ�����ʱ��
//		if ("papSTime".equals(key)){
//			Date papSTime=(Date) row.getCell("papSTime").getValue();
//			if(papSTime!=null){
//    			long time=(papSTime.getTime()-date.getTime())/86400000;
//    			if(time<0){
//    				MsgBox.showInfo("��ס֤�ݽ�����ʱ�䲻��С�ڵ�ǰʱ�䣬������ѡ��");
//    				row.getCell("papSTime").setValue(null);
//    			}
//    		}
//		}
//		//�پӳ�֤����
//		if ("sRePmtSTime".equals(key)){
//			Date sRePmtSTime=(Date) row.getCell("sRePmtSTime").getValue();
//			if(sRePmtSTime!=null){
//    			long time=(sRePmtSTime.getTime()-date.getTime())/86400000;
//    			if(time<0){
//    				MsgBox.showInfo("�پӳ�֤���ڲ���С�ڵ�ǰʱ�䣬������ѡ��");
//    				row.getCell("sRePmtSTime").setValue(null);
//    			}
//    		}
//		}
//		//�پӵ�������
//		if ("rePmtETime".equals(key)){
//			Date rePmtETime=(Date) row.getCell("rePmtETime").getValue();
//			if(rePmtETime!=null){
//    			long time=(rePmtETime.getTime()-date.getTime())/86400000;
//    			if(time<0){
//    				MsgBox.showInfo("�پӵ������ڲ���С�ڵ�ǰʱ�䣬������ѡ��");
//    				row.getCell("rePmtETime").setValue(null);
//    			}
//    		}
//		}
//		//��ʽ��ס֤��������
//		if ("pmtETime".equals(key)){
//			Date pmtETime=(Date) row.getCell("pmtETime").getValue();
//			if(pmtETime!=null){
//    			long time=(pmtETime.getTime()-date.getTime())/86400000;
//    			if(time<0){
//    				MsgBox.showInfo("��ʽ��ס֤�������ڲ���С�ڵ�ǰʱ�䣬������ѡ��");
//    				row.getCell("pmtETime").setValue(null);
//    			}
//    		}
//		}
		//�����ѡ�����д��о�ס֤�ֶεĵ�Ԫ��Ϊ�㡣
		if("departure".equals(key)){
			Boolean departure=(Boolean) row.getCell("departure").getValue();
			if(departure){
				row.getCell("isStop").getStyleAttributes().setLocked(true);
				row.getCell("papSTime").getStyleAttributes().setLocked(true);
				row.getCell("docType").getStyleAttributes().setLocked(true);
				row.getCell("rePmtNum").getStyleAttributes().setLocked(true);
				row.getCell("sRePmtSTime").getStyleAttributes().setLocked(true);
				row.getCell("rePmtETime").getStyleAttributes().setLocked(true);
				row.getCell("pmtNum").getStyleAttributes().setLocked(true);
				row.getCell("pmtSTime").getStyleAttributes().setLocked(true);
				row.getCell("pmteffDate").getStyleAttributes().setLocked(true);
				row.getCell("pmtETime").getStyleAttributes().setLocked(true);
				row.getCell("papSTime").setValue(null);//��ס֤�ݽ�����ʱ��
				row.getCell("docType").setValue(DOCTYPE.EMPTY);//��ס֤����
				row.getCell("rePmtNum").setValue(null);//��ʱ��ס֤����
				row.getCell("sRePmtSTime").setValue(null);//��ʱ��ס֤��֤����
				row.getCell("rePmtETime").setValue(null);//��ʱ��ס֤��֤����
				row.getCell("pmtNum").setValue(null);//��ʽ��ס֤����
				row.getCell("pmtSTime").setValue(null);//��ʽ��ס֤��֤����
				row.getCell("pmteffDate").setValue(null);//��ʽ��ס֤��Ч����
				row.getCell("pmtETime").setValue(null);//��ʽ��ס֤��֤����
			}else{
				row.getCell("isStop").getStyleAttributes().setLocked(false);
				row.getCell("papSTime").getStyleAttributes().setLocked(false);
				row.getCell("docType").getStyleAttributes().setLocked(false);
			}
		}
		//�����ѡ��1.��ס֤���ϵݽ�ʱ�䲻Ϊ��    2.�������о�ס֤�ֶεĵ�Ԫ��Ϊ�㡣
		if("isStop".equals(key)){
			Boolean isStop=(Boolean) row.getCell("isStop").getValue();
			if(isStop){
				row.getCell("departure").getStyleAttributes().setLocked(true);
				row.getCell("docType").getStyleAttributes().setLocked(true);
				row.getCell("rePmtNum").getStyleAttributes().setLocked(true);
				row.getCell("sRePmtSTime").getStyleAttributes().setLocked(true);
				row.getCell("rePmtETime").getStyleAttributes().setLocked(true);
				row.getCell("pmtNum").getStyleAttributes().setLocked(true);
				row.getCell("pmtSTime").getStyleAttributes().setLocked(true);
				row.getCell("pmteffDate").getStyleAttributes().setLocked(true);
				row.getCell("pmtETime").getStyleAttributes().setLocked(true);
				row.getCell("docType").setValue(DOCTYPE.EMPTY);//��ס֤����
				row.getCell("rePmtNum").setValue(null);//��ʱ��ס֤����
				row.getCell("sRePmtSTime").setValue(null);//��ʱ��ס֤��֤����
				row.getCell("rePmtETime").setValue(null);//��ʱ��ס֤��֤����
				row.getCell("pmtNum").setValue(null);//��ʽ��ס֤����
				row.getCell("pmtSTime").setValue(null);//��ʽ��ס֤��֤����
				row.getCell("pmteffDate").setValue(null);//��ʽ��ס֤��Ч����
				row.getCell("pmtETime").setValue(null);//��ʽ��ס֤��֤����
				row.getCell("endTime").getStyleAttributes().setLocked(false);
				row.getCell("cancelReson").getStyleAttributes().setLocked(false);
			}else{
				row.getCell("departure").getStyleAttributes().setLocked(false);
				row.getCell("docType").getStyleAttributes().setLocked(false);
				row.getCell("endTime").getStyleAttributes().setLocked(true);
				row.getCell("cancelReson").getStyleAttributes().setLocked(true);
				row.getCell("endTime").setValue(null);
				row.getCell("cancelReson").setValue(null);
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
    public void onLoad() throws Exception {
    	this.pkauditDate.setEnabled(false);
    	super.onLoad();
    	setButtonStatus();
    	setUITitle("��ס֤����");
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
			//this.pkBizDate.setValue(new Date());
		}
    	if (getOprtState().equals("EDIT")) {
    		int rowCount = this.kdtEntrys.getRowCount();
    		for(int i=0;i<rowCount;i++){
    			IRow row = this.kdtEntrys.getRow(i);
    			//�Զ���ѡ�Ƿ�ʹ��ע��
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
    				row.getCell("isEmbassyReg").setValue(pOrgInfo.isIsLogin());
    			}
    		}
		}
    	setEntryLocked();
    }
    protected void setEntryLocked(){
		//���ñ�����Ƿ�ɱ༭
		int rowCount = kdtEntrys.getRowCount();
    	for(int i=0;i<rowCount;i++){ 
    		IRow row = kdtEntrys.getRow(i);
    		//�Ƿ�ͣ��
    		if(row.getCell("isStop").getValue().equals(true)){
    			row.getCell("endTime").getStyleAttributes().setLocked(false);
    			row.getCell("cancelReson").getStyleAttributes().setLocked(false);
    			row.getCell("departure").getStyleAttributes().setLocked(true);
				row.getCell("docType").getStyleAttributes().setLocked(true);
				row.getCell("rePmtNum").getStyleAttributes().setLocked(true);
				row.getCell("sRePmtSTime").getStyleAttributes().setLocked(true);
				row.getCell("rePmtETime").getStyleAttributes().setLocked(true);
				row.getCell("pmtNum").getStyleAttributes().setLocked(true);
				row.getCell("pmtSTime").getStyleAttributes().setLocked(true);
				row.getCell("pmteffDate").getStyleAttributes().setLocked(true);
				row.getCell("pmtETime").getStyleAttributes().setLocked(true);
    		}
    		//�Ƿ��뾳
    		if(row.getCell("departure").getValue().equals(true)){
    			row.getCell("endTime").getStyleAttributes().setLocked(true);
    			row.getCell("cancelReson").getStyleAttributes().setLocked(true);
    			row.getCell("isStop").getStyleAttributes().setLocked(true);
				row.getCell("papSTime").getStyleAttributes().setLocked(true);
				row.getCell("docType").getStyleAttributes().setLocked(true);
				row.getCell("rePmtNum").getStyleAttributes().setLocked(true);
				row.getCell("sRePmtSTime").getStyleAttributes().setLocked(true);
				row.getCell("rePmtETime").getStyleAttributes().setLocked(true);
				row.getCell("pmtNum").getStyleAttributes().setLocked(true);
				row.getCell("pmtSTime").getStyleAttributes().setLocked(true);
				row.getCell("pmteffDate").getStyleAttributes().setLocked(true);
				row.getCell("pmtETime").getStyleAttributes().setLocked(true);
    		}
    		if(DOCTYPE.TEMPORARY.equals(row.getCell("docType").getValue())){
    			row.getCell("pmtNum").getStyleAttributes().setLocked(true);//���Ӻ���
    			row.getCell("pmtSTime").getStyleAttributes().setLocked(true);//���ӳ�֤����
    			row.getCell("pmteffDate").getStyleAttributes().setLocked(true);//������Ч����
    			row.getCell("pmtETime").getStyleAttributes().setLocked(true);//���ӵ�֤����
    			row.getCell("rePmtNum").getStyleAttributes().setLocked(false);//�پӺ���
    			row.getCell("sRePmtSTime").getStyleAttributes().setLocked(false);//�پӳ�֤����
    			row.getCell("rePmtETime").getStyleAttributes().setLocked(false);//�پӵ�֤����
    		}else if(DOCTYPE.FORMAL.equals(row.getCell("docType").getValue())){
    			row.getCell("rePmtNum").getStyleAttributes().setLocked(true);//�پӺ���
    			row.getCell("sRePmtSTime").getStyleAttributes().setLocked(true);//�پӳ�֤����
    			row.getCell("rePmtETime").getStyleAttributes().setLocked(true);//�پӵ�֤����
    			row.getCell("pmtNum").getStyleAttributes().setLocked(false);//���Ӻ���
    			row.getCell("pmtSTime").getStyleAttributes().setLocked(false);//���ӳ�֤����
    			row.getCell("pmteffDate").getStyleAttributes().setLocked(false);//������Ч����
    			row.getCell("pmtETime").getStyleAttributes().setLocked(false);//���ӵ�֤����
    		}
        }
    }
    protected void setButtonStatus() {
    	LivepermitInfo bill;
		if ("VIEW".equals(getOprtState())) {
			this.actionAudit.setVisible(true);
			this.actionUnAudit.setVisible(true);
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
			bill = (LivepermitInfo) this.editData;
			if (this.editData != null) {
				if (BillStateEnum.CHECKED.equals(bill.getBillSate())||BillStateEnum.DSTRY.equals(bill.getBillSate())) {// (BillStateEnum.SIGNE.equals(bill.getBillSate()))
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
			bill = (LivepermitInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null)
					&& (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(false);
			}

			this.actionAudit.setVisible(false);
			this.actionUnAudit.setVisible(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
		}
		if (((this.editData != null) && (BillStateEnum.CHECKED.equals(bill.getBillSate())||BillStateEnum.DSTRY.equals(bill.getBillSate())))
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
			bill = (LivepermitInfo) this.editData;
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
			sic.add("billSate");
			LivepermitInfo fiInfo = LivepermitFactory.getRemoteInstance().getLivepermitInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!BillStateEnum.DRAFT.equals(fiInfo.getBillSate())){
				MsgBox.showInfo("��ǰ����״̬Ϊ��"+fiInfo.getBillSate().getAlias()+"���������ظ����棡");
				abort();
			}
		}
        super.actionSave_actionPerformed(e);
        setEntryLocked();
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
        setEntryLocked();
    }
    protected void doBeforeSubmit(ActionEvent e) throws Exception {
    	//ֻ���ݴ�������ύ״̬�����ύ
		if(this.editData!=null && this.editData.getId()!=null){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			LivepermitInfo fiInfo = LivepermitFactory.getRemoteInstance().getLivepermitInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!(BillStateEnum.DRAFT.equals(fiInfo.getBillSate())||BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))){
				MsgBox.showInfo("��ǰ����״̬Ϊ��"+fiInfo.getBillSate().getAlias()+"���������ظ��ύ��");
				abort();
			}
		}
		checkDstry();
    	super.doBeforeSubmit(e);
    	//checkDate(); 
    	
    }
    protected void checkDstry() throws BOSException, Exception{
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
    	int rowCount=kdtEntrys.getRowCount();
    	for(int i=0;i<rowCount;i++){
    		IRow row=kdtEntrys.getRow(i);
    		Boolean departure =(Boolean) row.getCell("departure").getValue();
    		Boolean isStop=(Boolean) row.getCell("isStop").getValue();
    		if(!departure&&!isStop){
    			if(row.getCell("papSTime").getValue()==null){
        			MsgBox.showInfo("������"+row.getCell("name").getValue()+"���ľ�ס֤���ϵݽ�ʱ��Ϊ�գ��޷��ύ�����������ڣ�");
        			this.abort();
        		}
    			if(DOCTYPE.EMPTY.equals(row.getCell("docType").getValue())){
        			MsgBox.showInfo("������"+row.getCell("name").getValue()+"���ľ�ס֤����Ϊ�գ��޷��ύ�����������룡");
        			this.abort();
        		}
        		//��ס֤���ϵݽ�ʱ��>=�յ��Ͷ�֤ʱ��
    			Date papSTime=(Date) row.getCell("papSTime").getValue();//��ס֤�ݽ���������
    			papSTime=sdf.parse(sdf.format(papSTime));
        		if(row.getCell("reWorkPmtDate").getValue()!=null){
        			Date reWorkPmtDate=(Date) row.getCell("reWorkPmtDate").getValue();//�յ��Ͷ�֤ʱ��
        			reWorkPmtDate=sdf.parse(sdf.format(reWorkPmtDate));
        			if(papSTime.before(reWorkPmtDate)){
        				MsgBox.showInfo("������"+row.getCell("name").getValue()+"���ľ�ס֤���ϵݽ�ʱ��С���յ��Ͷ�֤ʱ�䣬�޷��ύ�����������룡");
            			this.abort();
        			}
        		}
        		//��ס֤����Ϊ��ʱ��ס֤
        		if(row.getCell("docType").getValue().equals(DOCTYPE.TEMPORARY)){
        			if(row.getCell("rePmtNum").getValue()==null){
        				MsgBox.showInfo("������"+row.getCell("name").getValue()+"������ʱ��ס֤����Ϊ�գ��޷��ύ����������ʱ��ס֤����");
        				this.abort();
        			}
        			if(row.getCell("sRePmtSTime").getValue()==null){
        				MsgBox.showInfo("������"+row.getCell("name").getValue()+"������ʱ��ס֤��֤����Ϊ�գ��޷��ύ�����������룡");
        				this.abort();
        			}
        			if(row.getCell("rePmtETime").getValue()==null){
        				MsgBox.showInfo("������"+row.getCell("name").getValue()+"������ʱ��ס֤��������Ϊ�գ��޷��ύ�����������룡");
        				this.abort();
        			}
        			//��ʱ��ס֤��֤����>=��ס֤���ϵݽ�ʱ�䡣
        			Date sRePmtSTime=(Date) row.getCell("sRePmtSTime").getValue();//��ʱ��ס֤��֤ʱ��
        			sRePmtSTime=sdf.parse(sdf.format(sRePmtSTime));
        			if(sRePmtSTime.compareTo(papSTime)<0){
        				MsgBox.showInfo("������"+row.getCell("name").getValue()+"������ʱ��ס֤��֤����С�ھ�ס֤���ϵݽ�ʱ�䣬�޷��ύ�����������룡");
        				this.abort();
        			}
        			//��ʱ��ס֤��������>��ʱ��ס֤��֤����
        			Date rePmtETime=(Date) row.getCell("rePmtETime").getValue();//��ʱ��ס֤��֤����
        			rePmtETime=sdf.parse(sdf.format(rePmtETime));
        			if(rePmtETime.compareTo(sRePmtSTime)<=0){
        				MsgBox.showInfo("������"+row.getCell("name").getValue()+"������ʱ��ס֤��������С�ڵ�����ʱ��ס֤��֤���ڣ��޷��ύ�����������룡");
        				this.abort();
        			}
        		}
        		//��ס֤����Ϊ��ʽ��ס֤
        		if(row.getCell("docType").getValue().equals(DOCTYPE.FORMAL)){
        			if(row.getCell("pmtNum").getValue()==null){
        				MsgBox.showInfo("������"+row.getCell("name").getValue()+"������ʽ��ס֤����Ϊ�գ��޷��ύ����������ʽ��ס֤����");
        				this.abort();
        			}
        			if(row.getCell("pmtSTime").getValue()==null){
        				MsgBox.showInfo("������"+row.getCell("name").getValue()+"������ʽ��ס֤��ȡ����Ϊ�գ��޷��ύ�����������룡");
        				this.abort();
        			}
        			if(row.getCell("pmteffDate").getValue()==null){
        				MsgBox.showInfo("������"+row.getCell("name").getValue()+"������ʽ��ס֤��Ч����Ϊ�գ��޷��ύ�����������룡");
        				this.abort();
        			}
        			if(row.getCell("pmtETime").getValue()==null){
        				MsgBox.showInfo("������"+row.getCell("name").getValue()+"������ʽ��ס֤��������Ϊ�գ��޷��ύ�����������룡");
        				this.abort();
        			}
        			//��ʽ��ס֤��������>��ʽ��ס֤��Ч����
        			Date pmtETime=(Date) row.getCell("pmtETime").getValue();
        			Date pmteffDate=(Date) row.getCell("pmteffDate").getValue();
        			pmtETime=sdf.parse(sdf.format(pmtETime));
        			pmteffDate=sdf.parse(sdf.format(pmteffDate));
        			if(pmtETime.compareTo(pmteffDate)<=0){
        				MsgBox.showInfo("������"+row.getCell("name").getValue()+"������ʽ��ס֤��������С�ڵ�����ʽ��ס֤��Ч���ڣ��޷��ύ�����������룡");
        				this.abort();
        			}
        		}
    		}
    		if(departure&&isStop){
    			MsgBox.showInfo("�Ƿ��뾳���Ƿ�ͣ�첻��ͬʱ��ѡ�����������룡");
    			this.abort();
    		}
    		if(isStop){
    			if(row.getCell("papSTime").getValue()==null){
    				MsgBox.showInfo("������"+row.getCell("name").getValue()+"���ľ�ס֤���ϵݽ�ʱ��Ϊ�գ��޷��ύ�����������ڣ�");
    				this.abort();
    			}
    			if(row.getCell("endTime").getValue()==null){
    				MsgBox.showInfo("��ѡ�Ƿ�ͣ�죬������ͣ�����ڣ�");
    				this.abort();
    			}
    			if(row.getCell("cancelReson").getValue()==null){
    				MsgBox.showInfo("��ѡ�Ƿ�ͣ�죬������ͣ�����ɣ�");
    				this.abort();
    			}
    			//ͣ��ʱ��>��ס֤���ϵݽ�ʱ��
    			Date papSTime=(Date) row.getCell("papSTime").getValue();//��ס֤�ݽ���������
    			Date endTime=(Date) row.getCell("endTime").getValue();//ͣ��ʱ��
    			papSTime=sdf.parse(sdf.format(papSTime));
    			endTime=sdf.parse(sdf.format(endTime));
    			if(endTime.compareTo(papSTime)<=0){
    				MsgBox.showInfo("������"+row.getCell("name").getValue()+"����ͣ��ʱ��С�ڵ��ھ�ס֤���ϵݽ�ʱ�䣬������ͣ�����ڣ�");
    				this.abort();
    			}
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
        int rowCount = this.kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			//�Զ���ѡ�Ƿ�ʹ��ע��
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
				row.getCell("isEmbassyReg").setValue(pOrgInfo.isIsLogin());
			}
		}
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
        return com.kingdee.eas.zjlw.certificates.LivepermitFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.certificates.LivepermitInfo objectValue = new com.kingdee.eas.zjlw.certificates.LivepermitInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        return objectValue;
    }

}