/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.Color;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.certificates.AntiSignedFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class AntiSignedEditUI extends AbstractAntiSignedEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AntiSignedEditUI.class);
    public void onLoad() throws Exception {
    	this.billSate.setEditable(false);
    	this.txtNumber.setEnabled(false);
    	super.onLoad();
    	setUITitle("返签办理");
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
    	this.btnAudit.setVisible(false);
    	this.btnUnaAudit.setVisible(false);
    	AntiSignedInfo bill;
		bill = (AntiSignedInfo) this.editData;
    	if ((BillStateEnum.NEW.equals(bill.getBillSate()))|| (BillStateEnum.DRAFT.equals(bill.getBillSate()))|| (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
    		setEntryLocked();//设置表格列是否可编辑
    	}
    	setButtonStatus();
    	
    }
    //勾选停办和未交资料：设置表格列是否可编辑
    protected void setEntryLocked(){
    	int rowCount = kdtEntrys.getRowCount(); 
    	for(int i=0;i<rowCount;i++){ 
    		IRow row = kdtEntrys.getRow(i);
    		row.getCell("immiTime").getStyleAttributes().setLocked(true);//入阿时间不允许编辑 ywj 2017-11-16
    		//是否未交资料释放指标
    		if(row.getCell("isLogout").getValue().equals(true)){
    			row.getCell("isCancel").getStyleAttributes().setLocked(true);
    			row.getCell("sendLaBuDate").getStyleAttributes().setLocked(true);
    			row.getCell("laborSignNo").getStyleAttributes().setLocked(true);
    			row.getCell("antiSgTime").getStyleAttributes().setLocked(true);
    			row.getCell("antiEndTime").getStyleAttributes().setLocked(true);
    			row.getCell("ownerSignDate").getStyleAttributes().setLocked(true);
    			row.getCell("docUpDate").getStyleAttributes().setLocked(true);
    			row.getCell("appAffiliated").getStyleAttributes().setLocked(true);
				row.getCell("docAffiliated").getStyleAttributes().setLocked(true);
    			row.getCell("logoutDate").getStyleAttributes().setLocked(false);
    			row.getCell("logoutReson").getStyleAttributes().setLocked(false);
    		}else{
    			//是否停办
        		if(row.getCell("isCancel").getValue().equals(true)){
        			row.getCell("isLogout").getStyleAttributes().setLocked(true);
        			row.getCell("laborSignNo").getStyleAttributes().setLocked(true);
        			row.getCell("antiSgTime").getStyleAttributes().setLocked(true);
        			row.getCell("antiEndTime").getStyleAttributes().setLocked(true);
        			row.getCell("ownerSignDate").getStyleAttributes().setLocked(true);
        			row.getCell("docUpDate").getStyleAttributes().setLocked(true);
    				row.getCell("docAffiliated").getStyleAttributes().setLocked(true);
        			row.getCell("cancelDate").getStyleAttributes().setLocked(false);
        			row.getCell("cancelReson").getStyleAttributes().setLocked(false);
        		}
    		}
    	}
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
		//递交劳动局时间
		if ("sendLaBuDate".equals(key)){
			if(row.getCell("sendLaBuDate").getValue()!=null){
				//1.负3天<=填入时间-today<=3天。
				Date sendLaBuDate=(Date) row.getCell("sendLaBuDate").getValue();
				long time=(sendLaBuDate.getTime()-date.getTime())/86400000;
				int dayCou = Integer.parseInt(String.valueOf(time)); 
//				if(dayCou<-3 || dayCou>3){
//					MsgBox.showInfo("所选日期必须在当前日期前后三天之内，请重新选择！");
//    				row.getCell("sendLaBuDate").setValue(null);
//    				this.abort();
//				}
				//2.递交劳动局时间>=分配工种完成时间。
				if(row.getCell("assignDate").getValue()!=null){
					Date assignDate=(Date) row.getCell("assignDate").getValue();
					assignDate=sdf.parse(sdf.format(assignDate));
//					if(sendLaBuDate.before(assignDate)){
//						MsgBox.showInfo("所选日期必须大于等于分配工种完成时间，请重新选择！");
//	    				row.getCell("sendLaBuDate").setValue(null);
//	    				this.abort();
//					}
				}
				//3.返签生效时间必须大于等于递交劳动局时间
				if(row.getCell("antiSgTime").getValue()!=null){
					Date antiSgTime=(Date) row.getCell("antiSgTime").getValue();
					if(antiSgTime.before(sendLaBuDate)){
						MsgBox.showInfo("所选日期必须小于等于返签生效时间，请重新选择！");
	    				row.getCell("sendLaBuDate").setValue(null);
	    				this.abort();
					}
				}
				//4.停办时间必须大于递交劳动局时间
				if(row.getCell("cancelDate").getValue()!=null){
					Date cancelDate=(Date) row.getCell("cancelDate").getValue();
					if(cancelDate.compareTo(sendLaBuDate)<=0){
						MsgBox.showInfo("所选日期必须小于停办时间，请重新选择！");
	    				row.getCell("cancelDate").setValue(null);
	    				this.abort();
					}
				}
			}
			
		}
		//返签生效时间
		if ("antiSgTime".equals(key)){
			if(row.getCell("antiSgTime").getValue()!=null){
				//1.负3天<=填入时间-today<=3天。
				Date antiSgTime=(Date) row.getCell("antiSgTime").getValue();
				long time=(antiSgTime.getTime()-date.getTime())/86400000;
				int dayCou = Integer.parseInt(String.valueOf(time)); 
//				if(dayCou<-3 || dayCou>3){
//					MsgBox.showInfo("所选日期必须在当前日期前后三天之内，请重新选择！");
//    				row.getCell("antiSgTime").setValue(null);
//    				this.abort();
//				}
				//2.返签生效时间必须大于等于递交劳动局时间
				if(row.getCell("sendLaBuDate").getValue()!=null){
					Date sendLaBuDate=(Date) row.getCell("sendLaBuDate").getValue();
					if(antiSgTime.before(sendLaBuDate)){
						MsgBox.showInfo("所选日期必须大于等于递交劳动局时间，请重新选择！");
	    				row.getCell("antiSgTime").setValue(null);
	    				this.abort();
					}
				}
				//3.返签批件上传时间必须大于等于返签生效时间
				if(row.getCell("docUpDate").getValue()!=null){
					Date docUpDate=(Date) row.getCell("docUpDate").getValue();
					if(docUpDate.before(antiSgTime)){
						MsgBox.showInfo("所选日期必须小于等于返签批件上传时间，请重新选择！");
	    				row.getCell("antiSgTime").setValue(null);
	    				this.abort();
					}
				}
				//4.返签到期时间 = 返签生效时间+11个月
				Date now = sdf.parse(sdf.format(antiSgTime));
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(now);
				calendar.add(Calendar.MONTH, 11);
				row.getCell("antiEndTime").setValue(calendar.getTime());
			}
		}
		//业主签字完成时间
		if ("ownerSignDate".equals(key)){
			if(row.getCell("ownerSignDate").getValue()!=null){
				//1.负3天<=填入时间-today<=3天。
				Date ownerSignDate=(Date) row.getCell("ownerSignDate").getValue();
				long time=(ownerSignDate.getTime()-date.getTime())/86400000;
				int dayCou = Integer.parseInt(String.valueOf(time)); 
//				if(dayCou<-3 || dayCou>3){
//					MsgBox.showInfo("所选日期必须在当前日期前后三天之内，请重新选择！");
//    				row.getCell("ownerSignDate").setValue(null);
//    				this.abort();
//				}
			}
		}
		//返签批件上传时间
		if ("docUpDate".equals(key)){
			if(row.getCell("docUpDate").getValue()!=null){
				//1.负3天<=填入时间-today<=3天。
				Date docUpDate=(Date) row.getCell("docUpDate").getValue();
				long time=(docUpDate.getTime()-date.getTime())/86400000;
				int dayCou = Integer.parseInt(String.valueOf(time)); 
//				if(dayCou<-3 || dayCou>3){
//					MsgBox.showInfo("所选日期必须在当前日期前后三天之内，请重新选择！");
//    				row.getCell("docUpDate").setValue(null);
//    				this.abort();
//				}
				//2.返签批件上传时间必须大于等于返签生效时间
				if(row.getCell("antiSgTime").getValue()!=null){
					Date antiSgTime=(Date) row.getCell("antiSgTime").getValue();
					if(docUpDate.before(antiSgTime)){
						MsgBox.showInfo("所选日期必须大于等于返签生效时间，请重新选择！");
	    				row.getCell("docUpDate").setValue(null);
	    				this.abort();
					}
				}
			}
		}
		//是否未交资料释放指标
		if ("isLogout".equals(key)){
			if(row.getCell("isLogout").getValue().equals(true)){
				row.getCell("isCancel").getStyleAttributes().setLocked(true);
				row.getCell("sendLaBuDate").getStyleAttributes().setLocked(true);
				row.getCell("laborSignNo").getStyleAttributes().setLocked(true);
				row.getCell("antiSgTime").getStyleAttributes().setLocked(true);
				row.getCell("antiEndTime").getStyleAttributes().setLocked(true);
				row.getCell("ownerSignDate").getStyleAttributes().setLocked(true);
				row.getCell("docUpDate").getStyleAttributes().setLocked(true);
				row.getCell("appAffiliated").getStyleAttributes().setLocked(true);
				row.getCell("docAffiliated").getStyleAttributes().setLocked(true);
				row.getCell("appAffiliated").setValue(false);
				row.getCell("docAffiliated").setValue(false);
				row.getCell("sendLaBuDate").setValue(null);
				row.getCell("laborSignNo").setValue(null);
				row.getCell("antiSgTime").setValue(null);
				row.getCell("antiEndTime").setValue(null);
				row.getCell("ownerSignDate").setValue(null);
				row.getCell("docUpDate").setValue(null);
				//row.getCell("logoutDate").getStyleAttributes().setLocked(false);
				row.getCell("logoutReson").getStyleAttributes().setLocked(false);
				row.getCell("logoutDate").setValue(new Date());
			}else{
				row.getCell("isCancel").getStyleAttributes().setLocked(false);
				row.getCell("sendLaBuDate").getStyleAttributes().setLocked(false);
				row.getCell("laborSignNo").getStyleAttributes().setLocked(false);
				row.getCell("antiSgTime").getStyleAttributes().setLocked(false);
				row.getCell("antiEndTime").getStyleAttributes().setLocked(false);
				row.getCell("ownerSignDate").getStyleAttributes().setLocked(false);
				row.getCell("docUpDate").getStyleAttributes().setLocked(false);
				row.getCell("appAffiliated").getStyleAttributes().setLocked(false);
				row.getCell("docAffiliated").getStyleAttributes().setLocked(false);
				row.getCell("logoutDate").getStyleAttributes().setLocked(true);
				row.getCell("logoutReson").getStyleAttributes().setLocked(true);
				row.getCell("logoutDate").setValue(null);
				row.getCell("logoutReson").setValue(null);
			}
		}
		//是否停办
		if ("isCancel".equals(key)){
			if(row.getCell("isCancel").getValue().equals(true)){
				row.getCell("isLogout").getStyleAttributes().setLocked(true);
				row.getCell("laborSignNo").getStyleAttributes().setLocked(true);
				row.getCell("antiSgTime").getStyleAttributes().setLocked(true);
				row.getCell("antiEndTime").getStyleAttributes().setLocked(true);
				row.getCell("ownerSignDate").getStyleAttributes().setLocked(true);
				row.getCell("docUpDate").getStyleAttributes().setLocked(true);
				row.getCell("docAffiliated").getStyleAttributes().setLocked(true);
				row.getCell("docAffiliated").setValue(false);
				row.getCell("laborSignNo").setValue(null);
				row.getCell("antiSgTime").setValue(null);
				row.getCell("antiEndTime").setValue(null);
				row.getCell("ownerSignDate").setValue(null);
				row.getCell("docUpDate").setValue(null);
				row.getCell("cancelDate").getStyleAttributes().setLocked(false);
				row.getCell("cancelReson").getStyleAttributes().setLocked(false);
			}else{
				row.getCell("isLogout").getStyleAttributes().setLocked(false);
				row.getCell("laborSignNo").getStyleAttributes().setLocked(false);
				row.getCell("antiSgTime").getStyleAttributes().setLocked(false);
				row.getCell("antiEndTime").getStyleAttributes().setLocked(false);
				row.getCell("ownerSignDate").getStyleAttributes().setLocked(false);
				row.getCell("docUpDate").getStyleAttributes().setLocked(false);
				row.getCell("docAffiliated").getStyleAttributes().setLocked(false);
				row.getCell("cancelDate").getStyleAttributes().setLocked(true);
				row.getCell("cancelReson").getStyleAttributes().setLocked(true);
				row.getCell("cancelDate").setValue(null);
				row.getCell("cancelReson").setValue(null);
			}
		}
		//停办时间
		if ("cancelDate".equals(key)){
			if(row.getCell("cancelDate").getValue()!=null){
				//1.负3天<=填入时间-today<=3天。
				Date cancelDate=(Date) row.getCell("cancelDate").getValue();
				long time=(cancelDate.getTime()-date.getTime())/86400000;
				int dayCou = Integer.parseInt(String.valueOf(time)); 
//				if(dayCou<-3 || dayCou>3){
//					MsgBox.showInfo("所选日期必须在当前日期前后三天之内，请重新选择！");
//    				row.getCell("cancelDate").setValue(null);
//    				this.abort();
//				}
				//2.停办时间必须大于递交劳动局时间
				if(row.getCell("sendLaBuDate").getValue()!=null){
					Date sendLaBuDate=(Date) row.getCell("sendLaBuDate").getValue();
					if(cancelDate.compareTo(sendLaBuDate)<=0){
						MsgBox.showInfo("所选日期必须大于递交劳动局时间，请重新选择！");
	    				row.getCell("cancelDate").setValue(null);
	    				this.abort();
					}
				}
			}
		}
    }
    
//    /**
//     * 注销
//     */
//    public void actionLogout_actionPerformed(ActionEvent e) throws Exception {
//    	// TODO Auto-generated method stub
//    	super.actionLogout_actionPerformed(e);
//    }
    
    /**
     * output class constructor
     */
    public AntiSignedEditUI() throws Exception
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
    	//只有暂存状态可以保存
		if(this.editData!=null && this.editData.getId()!=null){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			AntiSignedInfo fiInfo = AntiSignedFactory.getRemoteInstance().getAntiSignedInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!BillStateEnum.DRAFT.equals(fiInfo.getBillSate())){
				MsgBox.showInfo("当前单据状态为【"+fiInfo.getBillSate().getAlias()+"】不允许重复保存！");
				abort();
			}
		}
        super.actionSave_actionPerformed(e);
        setEntryLocked();//设置表格列是否可编辑
    }
    protected void doBeforeSubmit(ActionEvent e) throws Exception {
    	//只有暂存或者已提交状态可以提交
		if(this.editData!=null && this.editData.getId()!=null){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			AntiSignedInfo fiInfo = AntiSignedFactory.getRemoteInstance().getAntiSignedInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!(BillStateEnum.DRAFT.equals(fiInfo.getBillSate())||BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))){
				MsgBox.showInfo("当前单据状态为【"+fiInfo.getBillSate().getAlias()+"】不允许重复提交！");
				abort();
			}
		}
    	checkNull();//字段不可为空校验
    	super.doBeforeSubmit(e);
    }
    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
//    	checkNull();
        super.actionSubmit_actionPerformed(e);
        setEntryLocked();//设置表格列是否可编辑
    }

 
	private void checkNull() {
    	Date now = new Date();
		int rowCount = this.kdtEntrys.getRowCount();
		if (rowCount == 0) {
			MsgBox.showInfo("未添加人员信息，不允许提交！");
			abort();
		}
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			//未勾选：是否未交资料释放指标、是否停办
			if (row.getCell("isLogout").getValue().equals(false)&&row.getCell("isCancel").getValue().equals(false)) {
				if (row.getCell("sendLaBuDate").getValue() == null) {
					MsgBox.showInfo("递交劳动局时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("laborSignNo").getValue() == null) {
					MsgBox.showInfo("劳动局返签号为空，不允许提交！");
					abort();
				}
				if (row.getCell("antiSgTime").getValue() == null) {
					MsgBox.showInfo("返签生效时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("antiEndTime").getValue() == null) {
					MsgBox.showInfo("返签到期时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("ownerSignDate").getValue() == null) {
					MsgBox.showInfo("业主签字完成时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("docUpDate").getValue() == null) {
					MsgBox.showInfo("返签批件上传时间为空，不允许提交！");
					abort();
				}
//				if (row.getCell("docAffiliated").getValue().equals(false)) {
//					MsgBox.showInfo("返签批件挂靠人未勾选，不允许提交！");
//					abort();
//				}
//				if (row.getCell("appAffiliated").getValue().equals(false)) {
//					MsgBox.showInfo("返签申请签收件挂靠人未勾选，不允许提交！");
//					abort();
//				}
			}
			//勾选：是否未交资料释放指标
			if (row.getCell("isLogout").getValue().equals(true)) {
				if (row.getCell("logoutDate").getValue() == null) {
					MsgBox.showInfo("勾选是否未交资料释放指标后，释放指标时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("logoutReson").getValue() == null) {
					MsgBox.showInfo("勾选是否未交资料释放指标后，未交资料理由为空，不允许提交！");
					abort();
				}
			}
			//勾选：是否停办
			if (row.getCell("isCancel").getValue().equals(true)) {
				if (row.getCell("sendLaBuDate").getValue() == null) {
					MsgBox.showInfo("勾选停办后，递交劳动局时间为空，不允许提交！");
					abort();
				}
//				if(row.getCell("appAffiliated").getValue().equals(false)){
//					MsgBox.showInfo("勾选停办后，返签申请签收件挂靠人未勾选，不允许提交！");
//					abort();
//				}
				if (row.getCell("cancelDate").getValue() == null) {
					MsgBox.showInfo("勾选停办后，停办时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("cancelReson").getValue() == null) {
					MsgBox.showInfo("勾选停办后，停办理由为空，不允许提交！");
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
        return com.kingdee.eas.zjlw.certificates.AntiSignedFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.certificates.AntiSignedInfo objectValue = new com.kingdee.eas.zjlw.certificates.AntiSignedInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        return objectValue;
    }
    protected void setButtonStatus() {
    	AntiSignedInfo bill;
		if ("VIEW".equals(getOprtState())) {
			this.actionAudit.setVisible(true);
			this.actionUnAudit.setVisible(true);
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);

			bill = (AntiSignedInfo) this.editData;
			if (this.editData != null) {
				if ((BillStateEnum.CHECKED.equals(bill.getBillSate()))|| (BillStateEnum.DSTRY.equals(bill.getBillSate()))) {//
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
			bill = (AntiSignedInfo) this.editData;
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
			bill = (AntiSignedInfo) this.editData;
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
}