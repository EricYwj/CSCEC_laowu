/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
import java.util.Date;
import java.util.HashSet;
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
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoInfo;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.person.Genders;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.EmbassyRegEntryCollection;
import com.kingdee.eas.zjlw.certificates.EmbassyRegEntryFactory;
import com.kingdee.eas.zjlw.certificates.EmbassyRegEntryInfo;
import com.kingdee.eas.zjlw.certificates.EmbassyRegFactory;
import com.kingdee.eas.zjlw.certificates.EmbassyRegInfo;
import com.kingdee.eas.zjlw.certificates.EpEcEntryCollection;
import com.kingdee.eas.zjlw.certificates.EpEcEntryInfo;
import com.kingdee.eas.zjlw.certificates.EpEcFactory;
import com.kingdee.eas.zjlw.certificates.EpEcInfo;
import com.kingdee.eas.zjlw.certificates.ImmiEcEntryCollection;
import com.kingdee.eas.zjlw.certificates.ImmiEcEntryInfo;
import com.kingdee.eas.zjlw.certificates.ImmiEcFactory;
import com.kingdee.eas.zjlw.certificates.ImmiEcInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryFactory;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryInfo;
import com.kingdee.eas.zjlw.certificates.PassportapplyEntryInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.PassportOrganEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class EpEcEditUI extends AbstractEpEcEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(EpEcEditUI.class);
    
    public void onLoad() throws Exception {
    	super.onLoad();
    	//--------------------------------------新界面赋值-----------------------
    	if (getOprtState().equals("ADDNEW")) {
			//获取接受到的参数
    		Map uictxMap = this.getUIContext();
    		Set etys = new HashSet();
    		etys = (Set) uictxMap.get("etys");
    		//遍历反签办理分录集合
    		for (Object object : etys) {
    			EmbassyRegEntryInfo etyInfo = (EmbassyRegEntryInfo) object;
    			EmbassyRegInfo ety = EmbassyRegFactory.getRemoteInstance().getEmbassyRegInfo(new ObjectUuidPK(etyInfo.getParent().getId()));
    			if (ety.isIfNeed()) {
    				this.chkifNeed.setSelected(true);
    				if (ety.getNeedReson() != null && !"".equals(ety.getNeedReson())) {
    					txtneedReson.setText(ety.getNeedReson().toString());
					}
				}
    			//单条分录的值赋值给一行
    			IRow row = this.kdtEntrys.addRow();
    			row.getCell("oldEtyId").setValue(etyInfo.getId());
    			row.getCell("birAddr").setValue(etyInfo.getBirAddr());//出生地（中文）
    			row.getCell("birAdFr").setValue(etyInfo.getBirAdFr());//出生地（拼音）
    			if (etyInfo.getQuProf() != null) {
    				ProjectWorkInfo projectInfo = etyInfo.getQuProf();
    				ProjectWorkInfo cInfo = ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(projectInfo.getId()));
        			row.getCell("quProf").setValue(cInfo);//指标工种中文
				}
    			row.getCell("passpIssDate").setValue(etyInfo.getPasspIssDate());//护照签发日期
    			row.getCell("passportAgence").setValue(etyInfo.getPassportAgence());//护照颁发机构
    			if (etyInfo.getPassportCityC() != null) {
    				ProvinceInfo  projectInfo = etyInfo.getPassportCityC();
    				ProvinceInfo  cInfo = ProvinceFactory.getRemoteInstance().getProvinceInfo(new ObjectUuidPK(projectInfo.getId()));
        			row.getCell("passportCityC").setValue(cInfo);//护照签发地（中文）
				}
    			row.getCell("passportCityF").setValue(etyInfo.getPassportCityF());//护照签发地（拼音）
    			row.getCell("sbmEmbTime").setValue(etyInfo.getSbmEmbTime());//递送使馆注册资料时间
    			row.getCell("backTime").setValue(etyInfo.getBackTime());//取回使馆注册时间
				//是否使馆注册
    			row.getCell("nameCn").setValue(etyInfo.getNameCn());//中文姓名
    			row.getCell("lastName").setValue(etyInfo.getLastName());//姓拼音
    			row.getCell("firstName").setValue(etyInfo.getFirstName());//名拼音
    			row.getCell("sex").setValue(etyInfo.getSex());//性别 
    			row.getCell("birthday").setValue(etyInfo.getBirthday());//出生日期
    			CountryInfo countryInfo  = new CountryInfo();
    			if (etyInfo.getNatioNal() != null) {
    				countryInfo  = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(etyInfo.getNatioNal().getId()));
				}
    			row.getCell("natioNal").setValue(countryInfo);//国籍
    			row.getCell("passpNum").setValue(etyInfo.getPasspNum());//护照号码
    			row.getCell("passpExDate").setValue(etyInfo.getPasspExDate());//护照到期日期
    			row.getCell("veTime").setValue(etyInfo.getVeTime());//签证到期日期
    			row.getCell("fAlgTime").setValue(etyInfo.getFAlgTime());//申请入阿时间
    			AdminOrgUnitInfo adminOrgUnitInfo  = new AdminOrgUnitInfo();
    			if (etyInfo.getPartner() != null) {
    				adminOrgUnitInfo  = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(etyInfo.getPartner().getId()));
    				row.getCell("partner").setValue(adminOrgUnitInfo);//合作单位
    			}else{
    				row.getCell("partner").setValue(null);
				}
    			if (etyInfo.getTaskProj() != null) {
    				adminOrgUnitInfo  = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(etyInfo.getTaskProj().getId()));
    				row.getCell("taskProj").setValue(adminOrgUnitInfo);//工作项目
				}else{
    				row.getCell("taskProj").setValue(null);
				}
    			if (etyInfo.getPmtProj() != null) {
    				adminOrgUnitInfo  = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(etyInfo.getPmtProj().getId()));
    				row.getCell("pmtProj").setValue(adminOrgUnitInfo);//指标项目
				}else{
    				row.getCell("pmtProj").setValue(null);
				}
    			row.getCell("contactway").setValue(etyInfo.getContactway());//国内联系方式（手机号）
    			row.getCell("residence").setValue(etyInfo.getResidence());//国内联系详细地址（省市县）
    			row.getCell("IdNum").setValue(etyInfo.getIdNum());//身份证号
    			row.getCell("desCription").setValue(etyInfo.getDesCription());//备注
			}
		}
    	this.contbillSate.setEnabled(false);
		this.txtNumber.setEnabled(false);
		this.pkauditDate.setEnabled(false);
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
		EpEcInfo bill;
		if ("VIEW".equals(getOprtState())) {
			bill = (EpEcInfo) this.editData;
			if (this.editData != null) {
				if ((BillStateEnum.CHECKED.equals(bill.getBillSate()))) {//|| (BillStateEnum.SIGNED.equals(bill.getBillSate())
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
			bill = (EpEcInfo) this.editData;
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
			bill = (EpEcInfo) this.editData;
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
    public EpEcEditUI() throws Exception
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
     * output kdtEntrys_editStopped method
     */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
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
        //---------------反写原单据分录--------------
        String id = this.editData.getId().toString();
    	EpEcInfo info = EpEcFactory.getRemoteInstance().getEpEcInfo(new ObjectUuidPK(id));
    	EpEcEntryCollection col = info.getEntrys();
    	for (int i = 0; i < col.size(); i++) {
    		EpEcEntryInfo etyInfo = col.get(i);
    		String etyId = etyInfo.getId().toString();//先分录id
    		String oldId = etyInfo.getOldEtyId().toString();//原分录id
    		//携带附件
			IBoAttchAsso boaFac = BoAttchAssoFactory.getRemoteInstance();
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("attachment.id");
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("boID",etyId));
			view.setFilter(filter);
			view.setSelector(sic);
			//根据现分录ID查询附件
			BoAttchAssoCollection boaCol =boaFac.getBoAttchAssoCollection(view);
			if(boaCol!=null && boaCol.size()>0){
				for(int j=0;j<boaCol.size();j++){
					BoAttchAssoInfo boaInfo = boaCol.get(j);
					//添加附件
					BoAttchAssoInfo newBoaInfo = new BoAttchAssoInfo();
					newBoaInfo.setId(BOSUuid.create(newBoaInfo.getBOSType()));
					newBoaInfo.setBoID(oldId);//原分录id
					newBoaInfo.setAssoType("系统已有附件");//类型
					newBoaInfo.setAttachment(boaInfo.getAttachment());//附件
					newBoaInfo.setAssoBusObjType("595CEDBF");//关联业务对象的类型：使馆注册分录BOSTYPE
					boaFac.addnew(newBoaInfo);
				}
			}
			//删除原有附件
			boaFac.delete(filter);
		}
    	int count = this.kdtEntrys.getRowCount3();
    	for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("oldEtyId").getValue() != null) {
				EmbassyRegEntryInfo etyInfo = EmbassyRegEntryFactory.getRemoteInstance().getEmbassyRegEntryInfo(new ObjectUuidPK(row.getCell("oldEtyId").getValue().toString()));
				SelectorItemCollection sic = new SelectorItemCollection();
				//中文姓名nameCn
				if(row.getCell("nameCn").getValue() != null){
					etyInfo.setNameCn(row.getCell("nameCn").getValue().toString());
				}else{
					etyInfo.setNameCn(null);
				}
				sic.add("nameCn");
				//姓拼音lastName
				if(row.getCell("lastName").getValue() != null){
					etyInfo.setLastName(row.getCell("lastName").getValue().toString());
				}else{
					etyInfo.setLastName(null);
				}
				sic.add("lastName");
				//名拼音firstName
				if(row.getCell("firstName").getValue() != null){
					etyInfo.setFirstName(row.getCell("firstName").getValue().toString());
				}else{
					etyInfo.setFirstName(null);
				}
				sic.add("firstName");
				//性别sex
				if(row.getCell("sex").getValue() != null){
					etyInfo.setSex((Genders) row.getCell("sex").getValue());
				}else{
					etyInfo.setSex(null);
				}
				sic.add("sex");
				//出生日期birthday
				if(row.getCell("birthday").getValue() != null){
					etyInfo.setBirthday((Date) row.getCell("birthday").getValue());
				}else{
					etyInfo.setBirthday(null);
				}
				sic.add("birthday");
				//出生地（中文）birAddr
				if(row.getCell("birAddr").getValue() != null){
					etyInfo.setBirAddr(row.getCell("birAddr").getValue().toString());
				}else{
					etyInfo.setBirAddr(null);
				}
				sic.add("birAddr");
				//出生地（拼音）birAdFr
				if(row.getCell("birAdFr").getValue() != null){
					etyInfo.setBirAdFr(row.getCell("birAdFr").getValue().toString());
				}else{
					etyInfo.setBirAdFr(null);
				}
				sic.add("birAdFr");
				//指标工种中文quProf
				if(row.getCell("quProf").getValue() != null){
					ProjectWorkInfo pwInfo = (ProjectWorkInfo) row.getCell("quProf").getValue();
					ProjectWorkInfo pw = ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(pwInfo.getId()));
					etyInfo.setQuProf(pw);
				}else{
					etyInfo.setQuProf(null);
				}
				sic.add("quProf");
				//国籍natioNal
				if(row.getCell("natioNal").getValue() != null){
					CountryInfo pwInfo = (CountryInfo) row.getCell("natioNal").getValue();
					CountryInfo pw = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(pwInfo.getId()));
					etyInfo.setNatioNal(pw);
				}else{
					etyInfo.setNatioNal(null);
				}
				sic.add("natioNal");
				//护照号码passpNum
				if(row.getCell("passpNum").getValue() != null){
					etyInfo.setPasspNum(row.getCell("passpNum").getValue().toString());
				}else{
					etyInfo.setPasspNum(null);
				}
				sic.add("passpNum");
				//护照签发日期passpIssDate
				if(row.getCell("passpIssDate").getValue() != null){
					etyInfo.setPasspIssDate((Date) row.getCell("passpIssDate").getValue());
				}else{
					etyInfo.setPasspIssDate(null);
				}
				sic.add("passpIssDate");
				//护照到期日期passpExDate
				if(row.getCell("passpExDate").getValue() != null){
					etyInfo.setPasspExDate((Date) row.getCell("passpExDate").getValue());
				}else{
					etyInfo.setPasspExDate(null);
				}
				sic.add("passpExDate");
				//护照颁发机构passportAgence
				if(row.getCell("passportAgence").getValue() != null){
					etyInfo.setPassportAgence((PassportOrganEnum) row.getCell("passportAgence").getValue());
				}else{
					etyInfo.setPassportAgence(null);
				}
				sic.add("passportAgence");
				//护照签发地（中文）passportCityC
				if(row.getCell("passportCityC").getValue() != null){
					ProvinceInfo pwInfo = (ProvinceInfo) row.getCell("passportCityC").getValue();
					ProvinceInfo pw = ProvinceFactory.getRemoteInstance().getProvinceInfo(new ObjectUuidPK(pwInfo.getId()));
					etyInfo.setPassportCityC(pw);
				}else{
					etyInfo.setPassportCityC(null);
				}
				sic.add("passportCityC");
				//护照签发地（拼音）passportCityF
				if(row.getCell("passportCityF").getValue() != null){
					etyInfo.setPassportCityF(row.getCell("passportCityF").getValue().toString());
				}else{
					etyInfo.setPassportCityF(null);
				}
				sic.add("passportCityF");
				//签证到期日期veTime
				if(row.getCell("veTime").getValue() != null){
					etyInfo.setVeTime((Date) row.getCell("veTime").getValue());
				}else{
					etyInfo.setVeTime(null);
				}
				sic.add("veTime");
				//入阿时间fAlgTime
				if(row.getCell("fAlgTime").getValue() != null){
					etyInfo.setFAlgTime((Date) row.getCell("fAlgTime").getValue());
				}else{
					etyInfo.setFAlgTime(null);
				}
				sic.add("fAlgTime");
				//递送使馆注册资料时间sbmEmbTime
				if(row.getCell("sbmEmbTime").getValue() != null){
					etyInfo.setSbmEmbTime((Date) row.getCell("sbmEmbTime").getValue());
				}else{
					etyInfo.setSbmEmbTime(null);
				}
				sic.add("sbmEmbTime");
				//取回使馆注册时间backTime
				if(row.getCell("backTime").getValue() != null){
					etyInfo.setBackTime((Date) row.getCell("backTime").getValue());
				}else{
					etyInfo.setBackTime(null);
				}
				sic.add("backTime");
				//指标项目pmtProj
				if(row.getCell("pmtProj").getValue() != null){
					AdminOrgUnitInfo pwInfo = (AdminOrgUnitInfo) row.getCell("pmtProj").getValue();
					AdminOrgUnitInfo pw = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(pwInfo.getId()));
					etyInfo.setPmtProj(pw);
				}else{
					etyInfo.setPmtProj(null);
				}
				sic.add("pmtProj");
				//工作项目taskProj
				if(row.getCell("taskProj").getValue() != null){
					AdminOrgUnitInfo pwInfo = (AdminOrgUnitInfo) row.getCell("taskProj").getValue();
					AdminOrgUnitInfo pw = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(pwInfo.getId()));
					etyInfo.setTaskProj(pw);
				}else{
					etyInfo.setTaskProj(null);
				}
				sic.add("taskProj");
				//合作单位partner
				if(row.getCell("partner").getValue() != null){
					AdminOrgUnitInfo pwInfo = (AdminOrgUnitInfo) row.getCell("partner").getValue();
					AdminOrgUnitInfo pw = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(pwInfo.getId()));
					etyInfo.setPartner(pw);
				}else{
					etyInfo.setPartner(null);
				}
				sic.add("partner");
				//国内联系方式（手机号）contactway
				if(row.getCell("contactway").getValue() != null){
					etyInfo.setContactway(row.getCell("contactway").getValue().toString());
				}else{
					etyInfo.setContactway(null);
				}
				sic.add("contactway");
				//国内联系详细地址（省市县）residence
				if(row.getCell("residence").getValue() != null){
					etyInfo.setResidence(row.getCell("residence").getValue().toString());
				}else{
					etyInfo.setResidence(null);
				}
				sic.add("residence");
				//身份证号IdNum
				if(row.getCell("IdNum").getValue() != null){
					etyInfo.setIdNum(row.getCell("IdNum").getValue().toString());
				}else{
					etyInfo.setIdNum(null);
				}
				sic.add("IdNum");
				EmbassyRegEntryFactory.getRemoteInstance().updatePartial(etyInfo, sic);
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
    
    protected void doBeforeSubmit(ActionEvent e) throws Exception {
		checkNull();
		super.doBeforeSubmit(e);
	}
    
	 private void checkNull() throws EASBizException, BOSException {
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
				//---------------------提交反写原单据----------------------------
				String id = row.getCell("oldEtyId").getValue().toString();
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("id",id));
				EntityViewInfo view = new EntityViewInfo();
				view.setFilter(filter);
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("billSate");
				EmbassyRegEntryCollection antiCol = EmbassyRegEntryFactory.getRemoteInstance().getEmbassyRegEntryCollection(view);
				for (int j = 0; j < antiCol.size(); j++) {
					EmbassyRegInfo antiInfo = antiCol.get(j).getParent();
					antiInfo.setBillSate(BillStateEnum.SUBMIT);
					EmbassyRegFactory.getRemoteInstance().updatePartial(antiInfo, sic);
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
        return com.kingdee.eas.zjlw.certificates.EpEcFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.certificates.EpEcInfo objectValue = new com.kingdee.eas.zjlw.certificates.EpEcInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}