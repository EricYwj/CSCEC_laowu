/**
 * output package name
 */
package com.kingdee.eas.zjlw.social.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.redeliveryEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryCollection;
import com.kingdee.eas.zjlw.social.ForiPayrollEntryInfo;
import com.kingdee.eas.zjlw.social.ForiPayrollInfo;
import com.kingdee.eas.zjlw.social.PayrollEntryCollection;
import com.kingdee.eas.zjlw.social.PayrollEntryInfo;
import com.kingdee.eas.zjlw.social.PayrollFactory;
import com.kingdee.eas.zjlw.social.PayrollInfo;
import com.kingdee.eas.zjlw.social.ProjBWRAssdFactory;
import com.kingdee.eas.zjlw.social.ProjBWRAssdInfo;
import com.kingdee.eas.zjlw.social.ProjBWREtyEntryCollection;
import com.kingdee.eas.zjlw.social.ProjBWREtyEntryFactory;
import com.kingdee.eas.zjlw.social.ProjBWREtyEntryInfo;
import com.kingdee.eas.zjlw.social.ProjBWREtyFactory;
import com.kingdee.eas.zjlw.social.ProjBWREtyInfo;

/**
 * output class name
 */
public class ProjBWRAssdEditUI extends AbstractProjBWRAssdEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ProjBWRAssdEditUI.class);
    
    /**
     * output class constructor
     */
    public ProjBWRAssdEditUI() throws Exception
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
    public void onLoad() throws Exception {
    	super.onLoad();
    	setButtonStatus();
    	//初始化单据
    	if (getOprtState().equals("EDIT")) {
    		//this.kdtEntrys.removeRows();
    		initAll();
		}
    	this.kdtEntrys.getColumn("wthReturnCount").getStyleAttributes().setNumberFormat("###,###,##0.00");
    }
    protected void setButtonStatus() {
		ProjBWRAssdInfo bill;
		if ("VIEW".equals(getOprtState())) {
//			this.actionAudit.setVisible(true);
//			this.actionUnAudit.setVisible(true);
//			this.actionAudit.setEnabled(true);
//			this.actionUnAudit.setEnabled(true);
			bill = (ProjBWRAssdInfo) this.editData;
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
			bill = (ProjBWRAssdInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null)&& (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(true);
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
	        bill = (ProjBWRAssdInfo) this.editData;
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
    private void initAll() throws BOSException, EASBizException {
    	ProjBWREtyInfo pwInfo = getAlgPayrollData();//查询恶劣天气返还录入
//    	if (pwInfo == null ) {
//			MsgBox.showInfo("所选项目未创建恶劣天气返还录入，无法生成项目恶劣分摊表！");
//			abort();
//		}
    	inniEntry(pwInfo);
    	inniHead(pwInfo);
//    	countEntry();
	}
	private ProjBWREtyInfo getAlgPayrollData() throws BOSException, EASBizException {
		AdminOrgUnitInfo projInfo = (AdminOrgUnitInfo) this.prmtprojName.getValue();//prmtprojName
		ProjBWRAssdInfo info = ProjBWRAssdFactory.getRemoteInstance().getProjBWRAssdInfo(new ObjectUuidPK(this.editData.getId()));
		FilterInfo  filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		filter.getFilterItems().add(new FilterItemInfo("projName.name",projInfo==null?null:projInfo.getName()));
		filter.getFilterItems().add(new FilterItemInfo("id",info.getSourceBillId()));
		filter.getFilterItems().add(new FilterItemInfo("billSate",BillStateEnum.CHECKED));
		sic.add("*");
		sic.add("entrys.*");
		view.setFilter(filter);
		view.setSelector(sic);
		ProjBWREtyInfo pwInfo = ProjBWREtyFactory.getRemoteInstance().getProjBWREtyCollection(view).get(0);
		return pwInfo;
	}
	 private void inniEntry(ProjBWREtyInfo pwInfo) throws EASBizException, BOSException {
	    	//获取工资数据的泛型集合
	    	Set pwEntrySet = getPayObjectSet(pwInfo);
	    	//根据工资数据获取合作单位的集合
			Set coopSet = getCoopSet(pwEntrySet);
			//循环集合赋值表体
	    	if (coopSet.size() > 0) {
	    		for (Object coopObj : coopSet) {
	    			AdminOrgUnitInfo coopInfo = (AdminOrgUnitInfo) coopObj;
	    			if (coopInfo != null) {
	    				//String coopCode = "";//合作单位代码
	        			int coopAlgSc = 0;//合作单位属地化缴纳社保人数
	        			BigDecimal wthReturnCount=BigDecimal.ZERO;
	        			//循环工资数据分录集合
	        			for (Object obj: pwEntrySet){
	        				//阿工
	        				
	        					ProjBWREtyEntryInfo pwEntryInfo = (ProjBWREtyEntryInfo) obj;
	        					
			    					AdminOrgUnitInfo cooperCode = pwEntryInfo.getCooperCode();
			    					AdminOrgUnitInfo coopNow = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(cooperCode.getId()));
			        				if (coopNow != null && coopInfo.getNumber().equals(coopNow.getNumber())) {
			        					coopAlgSc++;//
			        					wthReturnCount=wthReturnCount.add(pwEntryInfo.getPersonCredits()==null?BigDecimal.ZERO:pwEntryInfo.getPersonCredits());
			        				}
	        					}
	        			IRow row = this.kdtEntrys.addRow();
	    				AdminOrgUnitInfo coop = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(coopInfo.getId()));
	    		    	row.getCell("apportion").setValue(coop);
	    		    	row.getCell("sharOrgnation").setValue(coop.getNumber());
	    		    	row.getCell("wthReturnNum").setValue(coopAlgSc);
	    		    	row.getCell("wthReturnCount").setValue(wthReturnCount);
	        				}
	        			}
					}
		}
	 private void inniHead(ProjBWREtyInfo pwInfo) throws EASBizException, BOSException {
		 int algScCount = 0;
		 BigDecimal wthReturnCount=BigDecimal.ZERO;
	    	if (pwInfo != null) {
	    		ProjBWREtyEntryCollection pwEntryCol = pwInfo.getEntrys();
	    		for (int i = 0; i < pwEntryCol.size(); i++) {
	    			ProjBWREtyEntryInfo pwEntryInfo = pwEntryCol.get(i);
	        		if(pwEntryInfo.getPersonCredits()!=null){
	        			algScCount++;//分摊人数
    					wthReturnCount=wthReturnCount.add(pwEntryInfo.getPersonCredits()==null?BigDecimal.ZERO:pwEntryInfo.getPersonCredits());
	        			}
	        		}
			}
	    	IRow row = this.kdtEntrys.addRow(0);
	    	FilterInfo coopFilter = new FilterInfo();
	    	coopFilter.getFilterItems().add(new FilterItemInfo("number" , "HCount"));
	    	EntityViewInfo view = new EntityViewInfo();
	    	view.setFilter(coopFilter);
	    	AdminOrgUnitInfo coop = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitCollection(view).get(0);
	    	row.getCell("apportion").setValue(coop);
	    	row.getCell("sharOrgnation").setValue(null);
	    	row.getCell("wthReturnNum").setValue(algScCount);
	    	row.getCell("wthReturnCount").setValue(wthReturnCount);
		}
		private Set getPayObjectSet(ProjBWREtyInfo pwInfo) {
			Set<Object> set = new HashSet<Object>();
			ProjBWREtyEntryCollection pwEntryCol = new ProjBWREtyEntryCollection();
	    	if (pwInfo != null) {
	    		pwEntryCol = pwInfo.getEntrys();
	    		for (int i = 0; i < pwEntryCol.size(); i++) {
	    			set.add(pwEntryCol.get(i));
				}
			}
			return set;
		}
		private Set getCoopSet(Set paySet) throws EASBizException, BOSException {
			Set coopSet = new HashSet<AdminOrgUnitInfo>();
			SelectorItemCollection  sic = new SelectorItemCollection();
			sic.add("*");
			for (Object obj: paySet) {
					ProjBWREtyEntryInfo pay = (ProjBWREtyEntryInfo)obj;
					AdminOrgUnitInfo coop = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(pay.getCooperCode().getId()), sic);
						coopSet.add(coop);	
					}
			return coopSet;
		}
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
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
//		String key = table.getColumn(colIndex).getKey();
//		IRow row = table.getRow(rowIndex);
//		if("sharOrgnation".equals(key)){
//			int num=0;
//			BigDecimal count=BigDecimal.ZERO;
//			AdminOrgUnitInfo apportion=(AdminOrgUnitInfo) row.getCell("sharOrgnation").getValue();
//			row.getCell("apportion").setValue(apportion.getName());
//			if(apportion!=null){
//				FilterInfo filter = new FilterInfo();
//				EntityViewInfo view = new EntityViewInfo();
//				row.getCell("apportion").setValue(apportion.getName());
//				filter.getFilterItems().add(new FilterItemInfo("cooperation",row.getCell("apportion").getValue(),CompareType.INCLUDE));
//				filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
//				view.setFilter(filter);
//				ProjBWREtyEntryCollection col=ProjBWREtyEntryFactory.getRemoteInstance().getProjBWREtyEntryCollection(view);
//				if(col!=null&&col.size()>0){
//					for(int i=0;i<col.size();){
//					ProjBWREtyEntryInfo pjInfo=col.get(i);
//					if(pjInfo!=null){
//						count=(pjInfo.getPersonCredits()).add(count);
//					}
//					num=++i;
//					}
//					row.getCell("wthReturnNum").setValue(num);
//					row.getCell("wthReturnCount").setValue(count);
//				}else{
//					//row.getCell("apportion").setValue(null);
//					//row.getCell("sharOrgnation").setValue(null);
//					row.getCell("wthReturnNum").setValue(null);
//					row.getCell("wthReturnCount").setValue(null);
//				}
//				
//			}
//			
//		}
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
    	redeliveryEnum redelivery= (redeliveryEnum) this.redelivery.getSelectedItem();//返还方式
    	String txtprojRtBank=this.txtprojRtBank.getText();//项目返还银行账号
    	Date pkretToWorkDate=(Date) this.pkretToWorkDate.getValue();//复工日期
    	Date pkrptRbatDate=(Date) this.pkrptRbatDate.getValue();//返还款收到日期
    	String txtnoRbeCheck=this.txtnoRbeCheck.getText();//返还支票
    	if(redelivery==null){
    		MsgBox.showInfo("该项目返还方式为空，无法提交，请重新输入！");
    		this.abort();
    	}
    	if(pkrptRbatDate.compareTo(pkretToWorkDate)<=0){
    		MsgBox.showInfo("返还款收到日期应大于复工日期，无法提交，请重新输入！");
    		this.abort();
    	}
    	if(redelivery!=null){
    		if(redelivery.equals(redeliveryEnum.CHECK)){
    			if(txtnoRbeCheck==null||"".equals(txtnoRbeCheck)){
    				MsgBox.showInfo("该项目返还支票为空，无法提交，请填入！");
            		this.abort();
    			}
    			
    		}
    	}
    	if("".equals(txtprojRtBank)||txtprojRtBank==null){
    		MsgBox.showInfo("该项目返还银行账号为空，无法提交，请填入！");
    		this.abort();
    	}
    	if(pkrptRbatDate==null){
    		MsgBox.showInfo("该项目返还款收到日期为空，无法提交，请填入！");
    		this.abort();
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
        return com.kingdee.eas.zjlw.social.ProjBWRAssdFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.social.ProjBWRAssdInfo objectValue = new com.kingdee.eas.zjlw.social.ProjBWRAssdInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}