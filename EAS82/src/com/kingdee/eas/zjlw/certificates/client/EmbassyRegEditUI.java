/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

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
import com.kingdee.eas.zjlw.certificates.BusinesscheckInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyFactory;
import com.kingdee.eas.zjlw.certificates.DoubQualifyInfo;
import com.kingdee.eas.zjlw.certificates.EmbassyRegFactory;
import com.kingdee.eas.zjlw.certificates.EmbassyRegInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class EmbassyRegEditUI extends AbstractEmbassyRegEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(EmbassyRegEditUI.class);

	/**
	 * output class constructor
	 */
	public EmbassyRegEditUI() throws Exception
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
	//onload
	public void onLoad() throws Exception {
		this.contbillSate.setEnabled(false);
		this.txtNumber.setEnabled(false);
		this.pkauditDate.setEnabled(false);
		super.onLoad();
		if(chkifNeed.isSelected()){
    		txtneedReson.setEnabled(true);
			kdtEntrys.getColumn("passpNum").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("IdNum").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("passportCityC").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("passportCityF").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("veTime").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("pmtProj").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("taskProj").getStyleAttributes().setLocked(false);
    	}else{
    		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
    		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
    		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
    	}
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
    	filterProf();//过滤指标工种
	}
	protected void setButtonStatus() {
		EmbassyRegInfo bill;
		if ("VIEW".equals(getOprtState())) {
			//	    			this.actionAudit.setVisible(true);
			//	    			this.actionUnAudit.setVisible(true);
			//	    			this.actionAudit.setEnabled(true);
			//	    			this.actionUnAudit.setEnabled(true);

			bill = (EmbassyRegInfo) this.editData;
			if (this.editData != null) {
				if ((BillStateEnum.CHECKED.equals(bill.getBillSate()))) {//|| (BillStateEnum.SIGNED.equals(bill.getBillSate())
					//	    					this.actionUnAudit.setVisible(true);
					//	    					this.actionUnAudit.setEnabled(true);
					//	    					this.actionAudit.setVisible(false);
					//	    					this.actionAudit.setEnabled(false);
					this.actionEdit.setEnabled(false);
					this.actionRemove.setEnabled(false);
				} else {
					//	    					this.actionUnAudit.setVisible(false);
					//	    					this.actionUnAudit.setEnabled(false);
					//	    					this.actionAudit.setVisible(true);
					//	    					this.actionAudit.setEnabled(true);
					this.actionRemove.setEnabled(true);
					this.actionEdit.setEnabled(true);
				}
			}

			this.actionAddLine.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionInsertLine.setEnabled(false);
		} else {
			bill = (EmbassyRegInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null)
					&& (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(false);
			}

			//	    			this.actionAudit.setVisible(false);
			//	    			this.actionUnAudit.setVisible(false);
			//	    			this.actionAudit.setEnabled(false);
			//	    			this.actionUnAudit.setEnabled(false);
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
			bill = (EmbassyRegInfo) this.editData;
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
		//身份证号、护照号携带人员基本信息
		if("IdNum".equals(key)||"passpNum".equals(key)){
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			if(row.getCell("IdNum").getValue()!=null){
				filter.getFilterItems().add(new FilterItemInfo("idNum",row.getCell("IdNum").getValue()));
			}
			if(row.getCell("passpNum").getValue()!=null){
				filter.getFilterItems().add(new FilterItemInfo("passportNo",row.getCell("passpNum").getValue()));
			}
			if(row.getCell("IdNum").getValue()==null&&row.getCell("passpNum").getValue()==null){
				row.getCell("nameCn").setValue(null);
				row.getCell("lastName").setValue(null);
				row.getCell("firstName").setValue(null);
				row.getCell("sex").setValue(null);
				row.getCell("birthday").setValue(null);
				row.getCell("birAddr").setValue(null);
				row.getCell("birAdFr").setValue(null);
				row.getCell("quProf").setValue(null);
				row.getCell("natioNal").setValue(null);
				row.getCell("passpNum").setValue(null);
				row.getCell("passpIssDate").setValue(null);
				row.getCell("passpExDate").setValue(null);
				row.getCell("passportAgence").setValue(null);
				row.getCell("passportCityC").setValue(null);
				row.getCell("passportCityF").setValue(null);
				row.getCell("veTime").setValue(null);
				row.getCell("pmtProj").setValue(null);
				row.getCell("taskProj").setValue(null);
				row.getCell("partner").setValue(null);
				row.getCell("contactway").setValue(null);
				row.getCell("residence").setValue(null);
				row.getCell("IdNum").setValue(null);
			}
			if(filter.getFilterItems().size()>0){
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.MESSINPUT,CompareType.NOTEQUALS));// 信息录入
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.ANTINOT,CompareType.NOTEQUALS));//反签未办
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.ANTIDSTRY,CompareType.NOTEQUALS));//反签过期或不来
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.ANTISTOP,CompareType.NOTEQUALS));// 反签停办并注销
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.VISADSTRY,CompareType.NOTEQUALS));//签证过期或不来
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.VISASTOP,CompareType.NOTEQUALS));// 签证停办并注销
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.IMMIGRATIONSTOP,CompareType.NOTEQUALS));// 入境停办
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.PASSPORTISSUEDSTOP,CompareType.NOTEQUALS));//护照发放停办
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.DEPARTURE,CompareType.NOTEQUALS));// 离境
				view.setFilter(filter);
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("nameCN");
				sic.add("firstNameAlp");
				sic.add("lastNameApl");
				sic.add("sex");
				sic.add("birthDate");
				sic.add("birthPlaceCn");
				sic.add("birthPlaceFr");
				sic.add("permitProfession.id");
				sic.add("permitProfession.name");
				sic.add("permitProfession.number");
				sic.add("permitProfession.nameFR");
				sic.add("nation.id");
				sic.add("nation.name");
				sic.add("nation.number");
				sic.add("passportNo");
				sic.add("passportIssueDate");
				sic.add("passportExpireDate");
				sic.add("passportInst");
				sic.add("passportCity.id");
				sic.add("passportCity.name");
				sic.add("passportCity.number");
				sic.add("passportCityF");
				sic.add("permitOrg.id");
				sic.add("permitOrg.name");
				sic.add("permitOrg.number");
				sic.add("workOrg.id");
				sic.add("workOrg.name");
				sic.add("workOrg.number");
				sic.add("cooperation.id");
				sic.add("cooperation.name");
				sic.add("cooperation.number");
				sic.add("contactway");
				sic.add("innerAddress");
				sic.add("idNum");
				view.setSelector(sic);
				PersonHistoryCollection personCol = PersonHistoryFactory.getRemoteInstance().getPersonHistoryCollection(view);
				if(personCol!=null && personCol.size()>0){
					PersonHistoryInfo perInfo =personCol.get(0);
					row.getCell("nameCn").setValue(perInfo.getNameCN());
					row.getCell("lastName").setValue(perInfo.getFirstNameAlp());
					row.getCell("firstName").setValue(perInfo.getLastNameApl());
					row.getCell("sex").setValue(perInfo.getSex());
					row.getCell("birthday").setValue(perInfo.getBirthDate());
					row.getCell("birAddr").setValue(perInfo.getBirthPlaceCn());
					row.getCell("birAdFr").setValue(perInfo.getBirthPlaceFr());
					row.getCell("quProf").setValue(perInfo.getPermitProfession());
					row.getCell("natioNal").setValue(perInfo.getNation());
					row.getCell("passpNum").setValue(perInfo.getPassportNo());
					row.getCell("passpIssDate").setValue(perInfo.getPassportIssueDate());
					row.getCell("passpExDate").setValue(perInfo.getPassportExpireDate());
					row.getCell("passportAgence").setValue(perInfo.getPassportInst());
					row.getCell("passportCityC").setValue(perInfo.getPassportCity());
					row.getCell("passportCityF").setValue(perInfo.getPassportCityF());
					row.getCell("veTime").setValue(null);
					row.getCell("pmtProj").setValue(perInfo.getPermitOrg());
					row.getCell("taskProj").setValue(perInfo.getWorkOrg());
					row.getCell("partner").setValue(perInfo.getCooperation());
					row.getCell("contactway").setValue(perInfo.getContactway());
					row.getCell("residence").setValue(perInfo.getInnerAddress());
					row.getCell("IdNum").setValue(perInfo.getIdNum());
				}else{
					MsgBox.showInfo("系统不存在此人员或人员未在办理业务，请检查输入的身份证号或护照号是否正确！");
					row.getCell("nameCn").setValue(null);
					row.getCell("lastName").setValue(null);
					row.getCell("firstName").setValue(null);
					row.getCell("sex").setValue(null);
					row.getCell("birthday").setValue(null);
					row.getCell("birAddr").setValue(null);
					row.getCell("birAdFr").setValue(null);
					row.getCell("quProf").setValue(null);
					row.getCell("natioNal").setValue(null);
					row.getCell("passpNum").setValue(null);
					row.getCell("passpIssDate").setValue(null);
					row.getCell("passpExDate").setValue(null);
					row.getCell("passportAgence").setValue(null);
					row.getCell("passportCityC").setValue(null);
					row.getCell("passportCityF").setValue(null);
					row.getCell("veTime").setValue(null);
					row.getCell("pmtProj").setValue(null);
					row.getCell("taskProj").setValue(null);
					row.getCell("partner").setValue(null);
					row.getCell("contactway").setValue(null);
					row.getCell("residence").setValue(null);
					row.getCell("IdNum").setValue(null);
    				abort();
				}
			}
			filterProf();
		}

	}
	//分录指标工种根据指标项目过滤
	private void filterProf(){
		int rowCount = this.kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			if(row.getCell("pmtProj").getValue()!=null){
				AdminOrgUnitInfo admin = (AdminOrgUnitInfo) row.getCell("pmtProj").getValue();
				KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
				settNumPromptBox.setEditable(true);
				settNumPromptBox.setDisplayFormat("$name$");
				settNumPromptBox.setEditFormat("$number$");
				settNumPromptBox.setCommitFormat("$number$");
				settNumPromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjectWorkQuery");
				EntityViewInfo evi = new EntityViewInfo();
				FilterInfo filterInfo = new FilterInfo();
				filterInfo.getFilterItems().add(new FilterItemInfo("proCom.id",admin.getId().toString()));
				filterInfo.getFilterItems().add(new FilterItemInfo("leftAmount",0,CompareType.GREATER));
				evi.setFilter(filterInfo);
				settNumPromptBox.setEntityViewInfo(evi);
				row.getCell("quProf").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
			}
		}
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
			EmbassyRegInfo fiInfo = EmbassyRegFactory.getRemoteInstance().getEmbassyRegInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!BillStateEnum.DRAFT.equals(fiInfo.getBillSate())){
				MsgBox.showInfo("当前单据状态为【"+fiInfo.getBillSate().getAlias()+"】不允许重复保存！");
				abort();
			}
		}
		super.actionSave_actionPerformed(e);
		filterProf();
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionSubmit_actionPerformed(e);
		filterProf();
	}
	
	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		//只有暂存或者已提交状态可以提交
		if(this.editData!=null && this.editData.getId()!=null){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			EmbassyRegInfo fiInfo = EmbassyRegFactory.getRemoteInstance().getEmbassyRegInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!(BillStateEnum.DRAFT.equals(fiInfo.getBillSate())||BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))){
				MsgBox.showInfo("当前单据状态为【"+fiInfo.getBillSate().getAlias()+"】不允许重复提交！");
				abort();
			}
		}
		checkNull();
		super.doBeforeSubmit(e);
	}
	 private void checkNull() {
	    	Date now = new Date();
			int rowCount = this.kdtEntrys.getRowCount();
			if (rowCount == 0) {
				MsgBox.showInfo("未添加人员信息，不允许提交！");
				abort();
			}
			if(chkifNeed.isSelected()){
				if(txtneedReson.getText()==null||txtneedReson.getText().equals("")){
					MsgBox.showInfo("勾选补办，补办理由不能为空！");
					abort();
				}
			}
			for(int i=0;i<rowCount;i++){
				IRow row = this.kdtEntrys.getRow(i);
				if (row.getCell("fAlgTime").getValue() == null) {
					MsgBox.showInfo("入阿时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("sbmEmbTime").getValue() == null) {
					MsgBox.showInfo("递送使馆注册资料时间为空，不允许提交！");
					abort();
				}
				if (row.getCell("backTime").getValue() == null) {
					MsgBox.showInfo("取回使馆注册时间为空，不允许提交！");
					abort();
				}
				//递送资料时间>=入阿时间
				Date fAlgTime = (Date) row.getCell("fAlgTime").getValue();
				Date sbmEmbTime = (Date) row.getCell("sbmEmbTime").getValue();
				if(sbmEmbTime.before(fAlgTime)){
					MsgBox.showInfo("递送资料时间小于入阿时间，不允许提交！");
					abort();
				}
				//取回使馆注册时间>=递送资料时间
				Date backTime = (Date) row.getCell("backTime").getValue();
				if(backTime.before(sbmEmbTime)){
					MsgBox.showInfo("取回使馆注册时间小于递送资料时间，不允许提交！");
					abort();
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
		return com.kingdee.eas.zjlw.certificates.EmbassyRegFactory.getRemoteInstance();
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
		com.kingdee.eas.zjlw.certificates.EmbassyRegInfo objectValue = new com.kingdee.eas.zjlw.certificates.EmbassyRegInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setIfNeed(true);
		return objectValue;
	}

}