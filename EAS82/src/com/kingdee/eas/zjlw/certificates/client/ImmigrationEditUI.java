/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.net.IDN;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrg;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryFactory;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyFactory;
import com.kingdee.eas.zjlw.certificates.DoubQualifyInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.IfilentryFactory;
import com.kingdee.eas.zjlw.certificates.IfilentryInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryCollection;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationFactory;
import com.kingdee.eas.zjlw.certificates.ImmigrationInfo;
import com.kingdee.eas.zjlw.certificates.WorkVisacancelInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class ImmigrationEditUI extends AbstractImmigrationEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ImmigrationEditUI.class);
    
    public void onLoad() throws Exception {
    	this.txtNumber.setEnabled(false);
//		kdtEntrys.getColumn("veTime").getStyleAttributes().setLocked(false);
    	super.onLoad();
//    	setUITitle("申请入境");
    	kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
    	setButtonStatus();
    	btnAudit.setVisible(false);
    	btnUnAudit.setVisible(false);
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
    	if (getOprtState().equals("EDIT")) {
    		int rowCount = this.kdtEntrys.getRowCount();
    		for(int i=0;i<rowCount;i++){
    			IRow row = this.kdtEntrys.getRow(i);
    			//自动勾选是否使馆注册
//    			if (row.getCell("pmtProj").getValue() != null) {
//    				FilterInfo filter = new FilterInfo();
//    				filter.getFilterItems().add(new FilterItemInfo("proCom.name",row.getCell("pmtProj").getValue().toString()));
//    				EntityViewInfo view = new EntityViewInfo();
//    		    	view.setFilter(filter);
//    		    	SelectorItemCollection sic = new SelectorItemCollection();
//    		    	sic.add("isLogin");
//    		    	view.setSelector(sic);
//    		    	ProjectOrgCollection pOrgCol = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view);
//    		    	ProjectOrgInfo pOrgInfo = pOrgCol.get(0);
//    	        	row.getCell("ifImmige").setValue(pOrgInfo.isIsLogin());
//    			}
    			//查询双认证完成时间
    			if (row.getCell("personID").getValue() != null) {
    				FilterInfo filter = new FilterInfo();
    				filter.getFilterItems().add(new FilterItemInfo("personID",row.getCell("personID").getValue()));
    				filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
    				EntityViewInfo view = new EntityViewInfo();
    		    	view.setFilter(filter);
    		    	SelectorItemCollection sic = new SelectorItemCollection();
    		    	sic.add("qualDate");
    		    	sic.add("isIfilentry");
    		    	view.setSelector(sic);
    		    	DoubQualifyEntryCollection doubCol = DoubQualifyEntryFactory.getRemoteInstance().getDoubQualifyEntryCollection(view);
    		    	for (int j = 0; j < doubCol.size(); j++) {
    		    		DoubQualifyEntryInfo doubEntryInfo = doubCol.get(j);
    		    		row.getCell("dbCmpTime").setValue(doubEntryInfo.getQualDate());
    		    		//row.getCell("ifUnexpect").setValue(doubEntryInfo.isIsIfilentry());
					}
				}
    		}
		}
    	setEntryLocked();//设置表格列是否可编辑
    }
    //勾选停办：设置表格列是否可编辑
    protected void setEntryLocked(){
    	int rowCount = this.kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			//是否违规入境
			if(row.getCell("ifUnexpect").getValue().equals(true)){
				row.getCell("isCancel").getStyleAttributes().setLocked(true);
				row.getCell("isCancel").setValue(false);
				row.getCell("cancelDate").setValue(null);
				row.getCell("stopRsn").setValue(null);
			}
			//是否停办设置表格列是否可编辑
			if(row.getCell("isCancel").getValue().equals(true)){
				row.getCell("contDepart").getStyleAttributes().setLocked(true);
				row.getCell("contSTime").getStyleAttributes().setLocked(true);
				row.getCell("contOtime").getStyleAttributes().setLocked(true);
				row.getCell("ifbuyInsure").getStyleAttributes().setLocked(true);
				row.getCell("apAlgTime").getStyleAttributes().setLocked(true);
				row.getCell("isHand").getStyleAttributes().setLocked(true);
				row.getCell("ifbuyInsure").setValue(false);
				row.getCell("isHand").setValue(false);
				row.getCell("cancelDate").getStyleAttributes().setLocked(false);
				row.getCell("stopRsn").getStyleAttributes().setLocked(false);
			}
		}
    }
    /**
     * 判断是否违规入境
     * 条件：1.签证有效期<30天；2.双认证未审核
     * @param row
     * @throws EASBizException
     * @throws BOSException
     */
    protected void selectUne(IRow row) throws EASBizException, BOSException{
    	Date veDate = (Date) row.getCell("veTime").getValue();
    	Date dbCmpTime = (Date) row.getCell("dbCmpTime").getValue();
    	Date now= new Date();
    	long  day=(veDate.getTime()-now.getTime())/86400000;
    	if (dbCmpTime == null || day<30) {
    		row.getCell("ifUnexpect").setValue(true);
		}
    }
//    /**
//     * 双认证是否审核通过
//     * true：通过；false：未通过
//     * @return
//     * @throws BOSException
//     * @throws EASBizException 
//     */
//    private boolean doubQualAud(IRow row) throws BOSException, EASBizException {
//    	String id = row.getCell("IdNum").getValue().toString();
//    	String passpNum = row.getCell("passpNum").getValue().toString();
//    	FilterInfo filter = new FilterInfo();
//    	filter.getFilterItems().add(new FilterItemInfo("IdNum",id));
//    	filter.getFilterItems().add(new FilterItemInfo("passpNo",passpNum));
//    	filter.setMaskString("#0 OR #1");
//    	EntityViewInfo ev = new EntityViewInfo();
//    	ev.setFilter(filter);
//    	DoubQualifyEntryCollection dqEntryCol = DoubQualifyEntryFactory.getRemoteInstance().getDoubQualifyEntryCollection(ev);
//		DoubQualifyEntryInfo dqEntryInfo = dqEntryCol.get(0);
//		String dqInfoId = dqEntryInfo.getParent().getId().toString();
//		SelectorItemCollection sic1= new SelectorItemCollection();
//		sic1.add("billSate");
////		sic1.add("auditDate");
//		DoubQualifyInfo dqInfo = DoubQualifyFactory.getRemoteInstance().getDoubQualifyInfo(new ObjectUuidPK(dqInfoId), sic1);
//		if (dqInfo == null) {
//			MsgBox.showInfo("无法查询到该人员的双认证信息！");
//			abort();
//		}
////		Date d = dqInfo.getAuditDate();
//    	if (dqInfo.getBillSate()!=null && "40".equalsIgnoreCase(dqInfo.getBillSate().getValue())) {//审核通过
////    		row.getCell("dbCmpTime").setValue(d);
//			return true;
//		} else {//未通过
//			return false;
//		}
//	}
    
    public static boolean isEqual(Object objA, Object objB) {
		if (objA == objB) {
			return true;
		}

		if ((objA instanceof String) && (objB == null))
			objB = "";
		else if ((objB instanceof String) && (objA == null))
			objA = "";
		else if (((objA == null) && (objB != null))
				|| ((objA != null) && (objB == null))) {
			return false;
		}

		if ((objA instanceof CoreBaseInfo) && (objB instanceof CoreBaseInfo)) {
			CoreBaseInfo obj1 = (CoreBaseInfo) objA;
			CoreBaseInfo obj2 = (CoreBaseInfo) objB;
			return obj1.getId().equals(obj2.getId());
		}
		if ((objA instanceof BigDecimal) && (objB instanceof BigDecimal)) {
			BigDecimal big1 = (BigDecimal) objA;
			BigDecimal big2 = (BigDecimal) objB;
			return (big1.compareTo(big2) == 0);
		}
		return objA.equals(objB);
	}
    public static BigDecimal toBigDecimal(Object obj) {
		BigDecimal bigDecimal = new BigDecimal(0.0);

		if (null != obj) {
			if (obj instanceof BigDecimal) {
				bigDecimal = (BigDecimal) obj;
			} else {
				NumberFormat numberFormat = NumberFormat.getInstance();

				String str = obj.toString().trim();
				Number number = null;
				try {
					number = numberFormat.parse(str);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				if (null != number)
					try {
						str = number.toString();
						bigDecimal = new BigDecimal(str);
					} catch (Exception e) {
					}
			}
		}
		return bigDecimal;
	}
    /**
     * output class constructor
     */
    public ImmigrationEditUI() throws Exception
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
		//签订合同日期
//		if ("contSTime".equals(key)){
//			Date papSTime=(Date) row.getCell("contSTime").getValue();
//			if(papSTime!=null){
//    			long time=(papSTime.getTime()-date.getTime())/86400000;
//    			if(time>0){
//    				MsgBox.showInfo("签订合同日期不可迟于当前时间，请重新填写！");
//    				row.getCell("contSTime").setValue(null);
//    			}
//    		}
//		}
//		//合同生效日期
//		if ("contOtime".equals(key)){
//			Date wPmtGTime=(Date) row.getCell("contOtime").getValue();
//			if(wPmtGTime!=null){
//    			long time=(wPmtGTime.getTime()-date.getTime())/86400000;
//    			if(time>0){
//    				MsgBox.showInfo("合同生效日期不可迟于当前时间，请重新填写！");
//    				row.getCell("contOtime").setValue(null);
//    			}
//    		}
//		}
		if ("isCancel".equals(key)){
			if(row.getCell("isCancel").getValue().equals(true)){
				row.getCell("contDepart").getStyleAttributes().setLocked(true);
				row.getCell("contSTime").getStyleAttributes().setLocked(true);
				row.getCell("contOtime").getStyleAttributes().setLocked(true);
				row.getCell("ifbuyInsure").getStyleAttributes().setLocked(true);
				row.getCell("apAlgTime").getStyleAttributes().setLocked(true);
				row.getCell("isHand").getStyleAttributes().setLocked(true);
				row.getCell("contDepart").setValue(null);
				row.getCell("contSTime").setValue(null);
				row.getCell("contOtime").setValue(null);
				row.getCell("ifbuyInsure").setValue(false);
				row.getCell("apAlgTime").setValue(null);
				row.getCell("isHand").setValue(false);
				row.getCell("cancelDate").getStyleAttributes().setLocked(false);
				row.getCell("stopRsn").getStyleAttributes().setLocked(false);
			}else{
				row.getCell("contDepart").getStyleAttributes().setLocked(false);
				row.getCell("contSTime").getStyleAttributes().setLocked(false);
				row.getCell("contOtime").getStyleAttributes().setLocked(false);
				row.getCell("ifbuyInsure").getStyleAttributes().setLocked(false);
				row.getCell("apAlgTime").getStyleAttributes().setLocked(false);
				row.getCell("isHand").getStyleAttributes().setLocked(false);
				row.getCell("cancelDate").getStyleAttributes().setLocked(true);
				row.getCell("stopRsn").getStyleAttributes().setLocked(true);
				row.getCell("cancelDate").setValue(null);
				row.getCell("stopRsn").setValue(null);
			}
		}
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
			ImmigrationInfo fiInfo = ImmigrationFactory.getRemoteInstance().getImmigrationInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!BillStateEnum.DRAFT.equals(fiInfo.getBillSate())){
				MsgBox.showInfo("当前单据状态为【"+fiInfo.getBillSate().getAlias()+"】不允许重复保存！");
				abort();
			}
		}
        super.actionSave_actionPerformed(e);
        setEntryLocked();//设置表格列是否可编辑
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
        setEntryLocked();//设置表格列是否可编辑
    }
	/**
	 * 检验是否存在未签订合同的人员
	 * @param ctx
	 * @param info
	 * @return
	 */
	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		//只有暂存或者已提交状态可以提交
		if(this.editData!=null && this.editData.getId()!=null){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			ImmigrationInfo fiInfo = ImmigrationFactory.getRemoteInstance().getImmigrationInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!(BillStateEnum.DRAFT.equals(fiInfo.getBillSate())||BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))){
				MsgBox.showInfo("当前单据状态为【"+fiInfo.getBillSate().getAlias()+"】不允许重复提交！");
				abort();
			}
		}
		
		checkNull();
////		int rowCount = kdtEntrys.getRowCount();
////		String number = txtNumber.getText();//反签批次号
////		String idNum = "";//身份证号
////		String passpNum = "";//护照号码
////		FilterInfo filter = new FilterInfo();
////		filter.getFilterItems().add(new FilterItemInfo("parent.number",number));
////		SelectorItemCollection sic = new SelectorItemCollection();
////		sic.add("ifstop");
////		EntityViewInfo ev = new EntityViewInfo();
////		for (int i = 0; i < rowCount; i++) {
////			IRow row = kdtEntrys.getRow(i);
////			idNum = row.getCell("IdNum").getValue().toString();
////			passpNum = row.getCell("passpNum").getValue().toString();
////			filter.getFilterItems().add(new FilterItemInfo("IdNum",idNum));
////			filter.getFilterItems().add(new FilterItemInfo("passpNo",passpNum));
////			filter.setMaskString("(#0 OR #1) AND #2");
////			ev.setFilter(filter);
////			ev.setSelector(sic);
////			DoubQualifyEntryCollection dqEntryCol = DoubQualifyEntryFactory.getRemoteInstance().getDoubQualifyEntryCollection(ev);
////			DoubQualifyEntryInfo dbEntryInfo = dqEntryCol.get(0);
////			if (dbEntryInfo.isIfstop()) {
////				MsgBox.showInfo("该人员的双认证已经停办，不允许提交！");
////				abort();
////			}
////		}
		super.doBeforeSubmit(e);
	}
	private void checkNull() throws ParseException {
		int result =0;
		Date now = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		now=sdf.parse(sdf.format(now)); 
		int rowCount = this.kdtEntrys.getRowCount();
		if (rowCount == 0) {
			MsgBox.showInfo("未添加人员信息，不允许提交！");
			abort();
		}
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			//是否停办
			if (row.getCell("isCancel").getValue().equals(false)){
				//护照到期时间-today<=6个月，无法提交。
				if (row.getCell("passpExDate").getValue() == null){
					MsgBox.showInfo("护照到期时间为空，不允许提交！");
					abort();
				}
				Date passpExDate = (Date) row.getCell("passpExDate").getValue();
				Calendar c1 = Calendar.getInstance();
    			Calendar c2 = Calendar.getInstance();
    			c2.setTime(now);
    			int year = c2.get(Calendar.YEAR);
    			int month = c2.get(Calendar.MONTH);
    			c1.setTime(passpExDate);
    			int year1 = c1.get(Calendar.YEAR);
    		    int month1 = c1.get(Calendar.MONTH);
    			//int result = c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
    		    if(year==year1)
    		    {
    		     result=month1-month;//两个日期相差几个月，即月份差
    		    }
    		    else
    		    {
    		     result=12*(year1-year)+month1-month;//两个日期相差几个月，即月份差
    		    }
//    			if(result<=6){
//    				MsgBox.showInfo("护照到期时间小于等于6个月，不允许提交！");
//					abort();
//    			}
				//签证到期日-today<=0，则无法提交。
//    			if (row.getCell("veTime").getValue() == null){
//					MsgBox.showInfo("签证到期日为空，不允许提交！");
//					abort();
//				}
				Date veTime = (Date) row.getCell("veTime").getValue();
				veTime=sdf.parse(sdf.format(veTime)); 
				long  veday=(veTime.getTime()-now.getTime())/86400000;
//				if(veday<=0){
//					MsgBox.showInfo("签证到期日小于等于当前日期，不允许提交！");
//					abort();
//				}
				//违规入境校验双认证完成时间
//				if (row.getCell("ifUnexpect").getValue().equals(false)) {
//					if (row.getCell("dbCmpTime").getValue() == null) {
//						if (MsgBox.showConfirm2(this, "双认证未办理完成，是否进行违规入境？") != 0){
//			    			abort();
//						}else{
//							row.getCell("ifUnexpect").setValue(true);
//						}
//					}else{
//						if (veday<30) {
//				    		if (MsgBox.showConfirm2(this, "签证到期日期小于三十天，是否进行违规入境？") != 0){
//				    			abort();
//							}else{
//								row.getCell("ifUnexpect").setValue(true);
//							}
//				    	}
//					}
//				}
				
				if (veday<30) {
		    		if (MsgBox.showConfirm2(this, "签证不足一个月，或无法入境！") != 0){
		    			abort();
					}else{
						row.getCell("ifUnexpect").setValue(true);
					}
		    	}
				if (row.getCell("contDepart").getValue() == null){
					MsgBox.showInfo("签订合同单位为空，不允许提交！");
					abort();
				}
				if (row.getCell("contSTime").getValue() == null){
					MsgBox.showInfo("合同签订时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("contOtime").getValue() == null){
					MsgBox.showInfo("合同生效时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("ifbuyInsure").getValue().equals(false)){
					MsgBox.showInfo("是否购买保险未勾选，不允许提交！");
					abort();
				}
				if (row.getCell("isHand").getValue().equals(false)){
					MsgBox.showInfo("是否办理国际健康证（红本）未勾选，不允许提交！");
					abort();
				}
				if (row.getCell("apAlgTime").getValue() == null){
					MsgBox.showInfo("申请入阿时间为空，不允许提交！");
					abort();
				}
				//合同生效时间大于等于合同签订时间。
				Date contSTime = (Date)row.getCell("contSTime").getValue();
				contSTime=sdf.parse(sdf.format(contSTime)); 
				Date contOtime = (Date)row.getCell("contOtime").getValue();
				contOtime=sdf.parse(sdf.format(contOtime)); 
				if (contOtime.before(contSTime)) {
					MsgBox.showInfo("合同生效时间小于合同签订时间，不允许提交！");
					abort();
				}
				//1.填入时间-today>=0；2.申请入阿时间必须大于等于合同签订时间。
				Date apAlgTime = (Date)row.getCell("apAlgTime").getValue();
				apAlgTime=sdf.parse(sdf.format(apAlgTime)); 
				long  apday=(apAlgTime.getTime()-now.getTime())/86400000;
//				if(apday<0){ ywj1006
//					MsgBox.showInfo("申请入阿时间小于当前日期，不允许提交！");
//					abort();
//				}
				if (apAlgTime.before(contSTime)) {
					MsgBox.showInfo("申请入阿时间小于合同签订时间，不允许提交！");
					abort();
				}
			}else{
				if (row.getCell("cancelDate").getValue() == null){
					MsgBox.showInfo("勾选停办后：停办时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("stopRsn").getValue() == null){
					MsgBox.showInfo("勾选停办后：停办理由为空，不允许提交！");
					abort();
				}
			}
		}
	}
	/**
	 * 校验双认证是否停办
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public boolean CheckCancel(ImmigrationInfo info) throws BOSException, EASBizException {
		ImmigrationEntryCollection entrys = info.getEntrys();
		ImmigrationEntryInfo entryInfo = entrys.get(0);
		String number = info.getNumber();//反签批次号
		String idNum = entryInfo.getIdNum();//身份证号
		String passpNum = entryInfo.getPasspNum();//护照号码
		Date dqFTime = null;
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("IdNum",idNum));
		filter.getFilterItems().add(new FilterItemInfo("passpNo",passpNum));
		filter.getFilterItems().add(new FilterItemInfo("parent.number",number));
//		filter.setMaskString("(#0 OR #1) AND #2");
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("ifstop");
		EntityViewInfo ev = new EntityViewInfo();
		ev.setFilter(filter);
		ev.setSelector(sic);
		DoubQualifyEntryCollection dqEntryCol = DoubQualifyEntryFactory.getRemoteInstance().getDoubQualifyEntryCollection(ev);
		DoubQualifyEntryInfo dbEntryInfo = dqEntryCol.get(0);
//		SelectorItemCollection sic1 = new SelectorItemCollection();
//		sic1.add("entry.dbCmpTime");
//		dqFTime = dqEntryInfo.getQualDate();
//		info.getEntrys().get(0).setDbCmpTime(dqFTime);
//		updatePartial(ctx, info, sic1);
//		String tip = checkDQTime(dqEntryInfo);//获取双认证未完成人员的信息
		if (dbEntryInfo == null) {
			MsgBox.showInfo("该人员暂无双认证信息，不允许提交！");
			abort();
		}
		return dbEntryInfo.isIfstop();
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
			//自动勾选是否使馆注册
//    			if (row.getCell("pmtProj").getValue() != null) {
//    				FilterInfo filter = new FilterInfo();
//    				filter.getFilterItems().add(new FilterItemInfo("proCom.name",row.getCell("pmtProj").getValue().toString()));
//    				EntityViewInfo view = new EntityViewInfo();
//    		    	view.setFilter(filter);
//    		    	SelectorItemCollection sic = new SelectorItemCollection();
//    		    	sic.add("isLogin");
//    		    	view.setSelector(sic);
//    		    	ProjectOrgCollection pOrgCol = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view);
//    		    	ProjectOrgInfo pOrgInfo = pOrgCol.get(0);
//    	        	row.getCell("ifImmige").setValue(pOrgInfo.isIsLogin());
//    			}
			//查询双认证完成时间
			if (row.getCell("personID").getValue() != null) {
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("personID",row.getCell("personID").getValue()));
				filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
				EntityViewInfo view = new EntityViewInfo();
		    	view.setFilter(filter);
		    	SelectorItemCollection sic = new SelectorItemCollection();
		    	sic.add("qualDate");
		    	sic.add("isIfilentry");
		    	view.setSelector(sic);
		    	DoubQualifyEntryCollection doubCol = DoubQualifyEntryFactory.getRemoteInstance().getDoubQualifyEntryCollection(view);
		    	for (int j = 0; j < doubCol.size(); j++) {
		    		DoubQualifyEntryInfo doubEntryInfo = doubCol.get(j);
		    		row.getCell("dbCmpTime").setValue(doubEntryInfo.getQualDate());
		    		row.getCell("ifUnexpect").setValue(doubEntryInfo.isIsIfilentry());
				}
			}
			//是否违规入境
			if(row.getCell("ifUnexpect").getValue().equals(true)){
				row.getCell("isCancel").getStyleAttributes().setLocked(true);
				row.getCell("isCancel").setValue(false);
				row.getCell("cancelDate").setValue(null);
				row.getCell("stopRsn").setValue(null);
			}
			//是否停办设置表格列是否可编辑
			if(row.getCell("isCancel").getValue().equals(true)){
				row.getCell("contDepart").getStyleAttributes().setLocked(true);
				row.getCell("contSTime").getStyleAttributes().setLocked(true);
				row.getCell("contOtime").getStyleAttributes().setLocked(true);
				row.getCell("ifbuyInsure").getStyleAttributes().setLocked(true);
				row.getCell("apAlgTime").getStyleAttributes().setLocked(true);
				row.getCell("isHand").getStyleAttributes().setLocked(true);
				row.getCell("ifbuyInsure").setValue(false);
				row.getCell("isHand").setValue(false);
				row.getCell("cancelDate").getStyleAttributes().setLocked(false);
				row.getCell("stopRsn").getStyleAttributes().setLocked(false);
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
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAudit_actionPerformed(e);
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionUnAudit_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.zjlw.certificates.ImmigrationFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.certificates.ImmigrationInfo objectValue = new com.kingdee.eas.zjlw.certificates.ImmigrationInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        return objectValue;
    }
    protected void setButtonStatus() {
    	ImmigrationInfo bill;
		if ("VIEW".equals(getOprtState())) {
//			this.actionAudit.setVisible(true);
//			this.actionUnAudit.setVisible(true);
//			this.actionAudit.setEnabled(true);
//			this.actionUnAudit.setEnabled(true);

			bill = (ImmigrationInfo) this.editData;
			if (this.editData != null) {
				if ((BillStateEnum.CHECKED.equals(bill.getBillSate()))|| (BillStateEnum.CHECKING.equals(bill.getBillSate()))|| (BillStateEnum.DSTRY.equals(bill.getBillSate()))) {//|| (BillStateEnum.SIGNED.equals(bill.getBillSate())
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
			bill = (ImmigrationInfo) this.editData;
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
			bill = (ImmigrationInfo) this.editData;
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