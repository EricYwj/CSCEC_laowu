/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

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
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.person.Genders;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.AntiECEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiECEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiECFactory;
import com.kingdee.eas.zjlw.certificates.AntiECInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryFactory;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.DoubEcEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubEcEntryInfo;
import com.kingdee.eas.zjlw.certificates.DoubEcFactory;
import com.kingdee.eas.zjlw.certificates.DoubEcInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyFactory;
import com.kingdee.eas.zjlw.certificates.DoubQualifyInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.authType;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.lowagie.text.pdf.PRAcroForm;

/**
 * output class name
 */
public class DoubEcEditUI extends AbstractDoubEcEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DoubEcEditUI.class);
    
    public void onLoad() throws Exception {
    	super.onLoad();
    	//--------------��ȡԭ��������-------------------------------------------
    	if (getOprtState().equals("ADDNEW")) {
			//��ȡ���ܵ��Ĳ���
    		Map uictxMap = this.getUIContext();
    		Set etys = new HashSet();
    		etys = (Set) uictxMap.get("etys");
    		//������ǩ�����¼����
    		for (Object object : etys) {
    			DoubQualifyEntryInfo etyInfo = (DoubQualifyEntryInfo) object;
    			DoubQualifyInfo initInfo = DoubQualifyFactory.getRemoteInstance().getDoubQualifyInfo(new ObjectUuidPK(etyInfo.getParent().getId()));
    			//������¼��ֵ��ֵ��һ��
    			if (initInfo.isIfNeed()) {
    				chkifNeed.setSelected(true);
    				if (initInfo.getNeedReson() != null && !"".equals(initInfo.getNeedReson())) { 
    					txtneedReson.setText(initInfo.getNeedReson().toString());
					}
				}else{
					chkifNeed.setSelected(false);
				}
    			IRow row = this.kdtEntrys.addRow();
    			row.getCell("oldEtyId").setValue(etyInfo.getId());
    			row.getCell("name").setValue(etyInfo.getName());//��������
    			row.getCell("namePY").setValue(etyInfo.getNamePY());//����ƴ��
    			row.getCell("genDers").setValue(etyInfo.getGenDers());	//�Ա� 
    			row.getCell("birthdate").setValue(etyInfo.getBirthdate());//��������
    			if (etyInfo.getNatioNal() != null) {
    				CountryInfo countryInfo = etyInfo.getNatioNal();
        			CountryInfo cInfo = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(countryInfo.getId()));
        			row.getCell("natioNal").setValue(cInfo);//����
				}
    			row.getCell("passpNo").setValue(etyInfo.getPasspNo());//���պ���
    			row.getCell("workSuffer").setValue(etyInfo.getWorkSuffer());//��������
    			row.getCell("actProf").setValue(etyInfo.getActProf());//ʵ��רҵ����
    			if (etyInfo.getPmtProf() != null) {
    				ProjectWorkInfo projectInfo = etyInfo.getPmtProf();
    				ProjectWorkInfo cInfo = ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(projectInfo.getId()));
        			row.getCell("pmtProf").setValue(cInfo);//ָ�깤������
				}
    			row.getCell("pmtProfFr").setValue(etyInfo.getPmtProfFr());//ָ�깤�ַ���
    			row.getCell("type").setValue(etyInfo.getType());//��֤��֤����
    			row.getCell("copies").setValue(etyInfo.getCopies());//����
    			if (etyInfo.getPmtProj() != null) {
    				AdminOrgUnitInfo countryInfo = etyInfo.getPmtProj();
    				AdminOrgUnitInfo cInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
        			row.getCell("pmtProj").setValue(cInfo);//ָ����Ŀ
				}
    			if (etyInfo.getTaskProj() != null) {
    				AdminOrgUnitInfo countryInfo = etyInfo.getTaskProj();
    				AdminOrgUnitInfo cInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
        			row.getCell("taskProj").setValue(cInfo);//������Ŀ
				}
    			if (etyInfo.getPartner() != null) {
    				AdminOrgUnitInfo countryInfo = etyInfo.getPartner();
    				AdminOrgUnitInfo cInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
        			row.getCell("partner").setValue(cInfo);//������λ
				}
    			row.getCell("IdNum").setValue(etyInfo.getIdNum());//���֤��
    			row.getCell("birthPlaceCn").setValue(etyInfo.getBirthPlaceCn());//�����أ����ģ�
    			row.getCell("birthPlaceFr").setValue(etyInfo.getBirthPlaceFr());//�����أ�ƴ����
    			row.getCell("assignDate").setValue(etyInfo.getAssignDate());//���乤�����ʱ��
    			row.getCell("qualbaNum").setValue(etyInfo.getQualbaNum());//��֤��֤���κ�
    			row.getCell("notiDate").setValue(etyInfo.getNotiDate());//��֤��ʼ����ʱ��
    			row.getCell("notaDate").setValue(etyInfo.getNotaDate());//��֤�������ʱ��
    			row.getCell("qualSendDate").setValue(etyInfo.getQualSendDate());//��֤��ʼ����ʱ��
    			row.getCell("qualDate").setValue(etyInfo.getQualDate());//��֤�������ʱ��
    			row.getCell("ifstop").setValue(etyInfo.isIfstop());//�Ƿ�ͣ��
    			row.getCell("stopTime").setValue(etyInfo.getStopTime());//ͣ��ʱ��
    			row.getCell("stopRes").setValue(etyInfo.getStopRes());//ͣ������
    			row.getCell("desCription").setValue(etyInfo.getDesCription());//��ע
    			row.getCell("wkPmtGet").setValue(etyInfo.isWkPmtGet());//�Ƿ����������֤��
    			row.getCell("wpCopies").setValue(etyInfo.getWpCopies());//    �������������飩
    			row.getCell("pmtFiDate").setValue(etyInfo.getPmtFiDate());//��֤���ʱ��
    			row.getCell("dbFiDate").setValue(etyInfo.getDbFiDate());//˫��֤���ʱ��
			}
		}
    	
    	if(chkifNeed.isSelected()){
    		txtneedReson.setEnabled(true);
			kdtEntrys.getColumn("passpNo").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("IdNum").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("workSuffer").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("type").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("copies").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("assignDate").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("pmtProf").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("pmtProj").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("taskProj").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("ifstop").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("stopTime").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("stopRes").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("isIfilentry").getStyleAttributes().setHided(true);
    	}else{
    		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
    		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
    		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
    	}
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

    	//������������༭
    	kdtEntrys.getColumn("workSuffer").getStyleAttributes().setLocked(false);
    }
    
    /**
     * output class constructor
     */
    public DoubEcEditUI() throws Exception
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
		Date date= new Date();
		//�ݽ���������
//		if ("qualSendDate".equals(key)){
//			Date papSTime=(Date) row.getCell("qualSendDate").getValue();
//			if(papSTime!=null){
//    			long time=(papSTime.getTime()-date.getTime())/86400000;
//    			if(time<0){
//    				MsgBox.showInfo("��֤�������ڲ������ڵ�ǰʱ�䣬��������д��");
//    				row.getCell("qualSendDate").setValue(null);
//    			}
//    		}
//		}
//		//�Ͷ�֤��֤����
//		if ("qualDate".equals(key)){
//			Date wPmtGTime=(Date) row.getCell("qualDate").getValue();
//			if(wPmtGTime!=null){
//    			long time=(wPmtGTime.getTime()-date.getTime())/86400000;
//    			if(time<0){
//    				MsgBox.showInfo("��֤������ڲ������ڵ�ǰʱ�䣬��������д��");
//    				row.getCell("qualDate").setValue(null);
//    			}
//    			if (row.getCell("ifstop").getValue().equals(true)) {
//    				MsgBox.showInfo("ǩ֤���������Ա������ͣ�죡");
//    				abort();
//    		 	}
//    		}
//		}
		//���֤�š����պ�Я����Ա������Ϣ
		if("IdNum".equals(key)||"passpNo".equals(key)){
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			if(row.getCell("IdNum").getValue()!=null){
				filter.getFilterItems().add(new FilterItemInfo("idNum",row.getCell("IdNum").getValue()));
			}
			if(row.getCell("passpNo").getValue()!=null){
				filter.getFilterItems().add(new FilterItemInfo("passportNo",row.getCell("passpNo").getValue()));
			}
			if(row.getCell("IdNum").getValue()==null&&row.getCell("passpNo").getValue()==null){
				row.getCell("name").setValue(null);
				row.getCell("namePY").setValue(null);
				row.getCell("genDers").setValue(null);
				row.getCell("birthdate").setValue(null);
				row.getCell("birthPlaceCn").setValue(null);
				row.getCell("birthPlaceFr").setValue(null);
				row.getCell("actProf").setValue(null);
				row.getCell("pmtProf").setValue(null);
				row.getCell("pmtProfFr").setValue(null);
				row.getCell("natioNal").setValue(null);
				row.getCell("passpNo").setValue(null);
				row.getCell("IdNum").setValue(null);
				row.getCell("pmtProj").setValue(null);
				row.getCell("taskProj").setValue(null);
				row.getCell("partner").setValue(null);
				row.getCell("lastName").setValue(null);
				row.getCell("firstName").setValue(null);
			}
			if(filter.getFilterItems().size()>0){
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.MESSINPUT,CompareType.NOTEQUALS));// ��Ϣ¼��
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.ANTINOT,CompareType.NOTEQUALS));//��ǩδ��
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.ANTIDSTRY,CompareType.NOTEQUALS));//��ǩ���ڻ���
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.ANTISTOP,CompareType.NOTEQUALS));// ��ǩͣ�첢ע��
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.VISADSTRY,CompareType.NOTEQUALS));//ǩ֤���ڻ���
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.VISASTOP,CompareType.NOTEQUALS));// ǩ֤ͣ�첢ע��
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.IMMIGRATIONSTOP,CompareType.NOTEQUALS));// �뾳ͣ��
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.PASSPORTISSUEDSTOP,CompareType.NOTEQUALS));//���շ���ͣ��
				filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.DEPARTURE,CompareType.NOTEQUALS));// �뾳
				view.setFilter(filter);
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("nameCN");
				sic.add("firstNameAlp");
				sic.add("lastNameApl");
				sic.add("sex");
				sic.add("birthDate");
				sic.add("birthPlaceCn");
				sic.add("birthPlaceFr");
				sic.add("realProf");
				sic.add("permitProfession.id");
				sic.add("permitProfession.name");
				sic.add("permitProfession.number");
				sic.add("permitProfession.nameFR");
				sic.add("nation.id");
				sic.add("nation.name");
				sic.add("nation.number");
				sic.add("passportNo");
				sic.add("idNum");
				sic.add("permitOrg.id");
				sic.add("permitOrg.name");
				sic.add("permitOrg.number");
				sic.add("workOrg.id");
				sic.add("workOrg.name");
				sic.add("workOrg.number");
				sic.add("cooperation.id");
				sic.add("cooperation.name");
				sic.add("cooperation.number");
				view.setSelector(sic);
				PersonHistoryCollection personCol = PersonHistoryFactory.getRemoteInstance().getPersonHistoryCollection(view);
				if(personCol!=null && personCol.size()>0){
					PersonHistoryInfo perInfo =personCol.get(0);
					row.getCell("name").setValue(perInfo.getNameCN());
					row.getCell("namePY").setValue(perInfo.getFirstNameAlp()+perInfo.getLastNameApl());
					row.getCell("genDers").setValue(perInfo.getSex());
					row.getCell("birthdate").setValue(perInfo.getBirthDate());
					row.getCell("birthPlaceCn").setValue(perInfo.getBirthPlaceCn());
					row.getCell("birthPlaceFr").setValue(perInfo.getBirthPlaceFr());
					row.getCell("actProf").setValue(perInfo.getRealProf());
					row.getCell("pmtProf").setValue(perInfo.getPermitProfession());
					row.getCell("pmtProfFr").setValue(perInfo.getPermitProfession()==null?null:perInfo.getPermitProfession().getNameFR());
					row.getCell("natioNal").setValue(perInfo.getNation());
					row.getCell("passpNo").setValue(perInfo.getPassportNo());
					row.getCell("IdNum").setValue(perInfo.getIdNum());
					row.getCell("pmtProj").setValue(perInfo.getPermitOrg());
					row.getCell("taskProj").setValue(perInfo.getWorkOrg());
					row.getCell("partner").setValue(perInfo.getCooperation());
					row.getCell("lastName").setValue(perInfo.getFirstNameAlp());
					row.getCell("firstName").setValue(perInfo.getLastNameApl());
				}else{
					MsgBox.showInfo("ϵͳ�����ڴ���Ա����Աδ�ڰ���ҵ��������������֤�Ż��պ��Ƿ���ȷ��");
					row.getCell("name").setValue(null);
					row.getCell("namePY").setValue(null);
					row.getCell("genDers").setValue(null);
					row.getCell("birthdate").setValue(null);
					row.getCell("birthPlaceCn").setValue(null);
					row.getCell("birthPlaceFr").setValue(null);
					row.getCell("actProf").setValue(null);
					row.getCell("pmtProf").setValue(null);
					row.getCell("pmtProfFr").setValue(null);
					row.getCell("natioNal").setValue(null);
					row.getCell("passpNo").setValue(null);
					row.getCell("IdNum").setValue(null);
					row.getCell("pmtProj").setValue(null);
					row.getCell("taskProj").setValue(null);
					row.getCell("partner").setValue(null);
					row.getCell("lastName").setValue(null);
					row.getCell("firstName").setValue(null);
    				abort();
				}
			}
			filterProf();
		}
		if ("pmtProj".equals(key)){
			row.getCell("pmtProf").setValue(null);
			row.getCell("pmtProfFr").setValue(null);
			filterProf();
		}
		//ָ�깤��
		if ("pmtProf".equals(key)){
			if(row.getCell("pmtProf").getValue()!=null){
				ProjectWorkInfo pw = (ProjectWorkInfo) row.getCell("pmtProf").getValue();
				row.getCell("pmtProfFr").setValue(pw.getNameFR());
			}else{
				row.getCell("pmtProfFr").setValue(null);
			}
		}
		//�Ƿ�ͣ��
		if ("ifstop".equals(key)){
			if(row.getCell("ifstop").getValue().equals(true)){
				row.getCell("isIfilentry").getStyleAttributes().setLocked(true);
				row.getCell("notiDate").getStyleAttributes().setLocked(true);
				row.getCell("notaDate").getStyleAttributes().setLocked(true);
				row.getCell("qualSendDate").getStyleAttributes().setLocked(true);
				row.getCell("qualDate").getStyleAttributes().setLocked(true);
				row.getCell("notiDate").setValue(null);
				row.getCell("notaDate").setValue(null);
				row.getCell("qualSendDate").setValue(null);
				row.getCell("qualDate").setValue(null);
				row.getCell("stopTime").getStyleAttributes().setLocked(false);
				row.getCell("stopRes").getStyleAttributes().setLocked(false);
			}else{
				row.getCell("isIfilentry").getStyleAttributes().setLocked(false);
				row.getCell("notiDate").getStyleAttributes().setLocked(false);
				row.getCell("notaDate").getStyleAttributes().setLocked(false);
				row.getCell("qualSendDate").getStyleAttributes().setLocked(false);
				row.getCell("qualDate").getStyleAttributes().setLocked(false);
				row.getCell("stopTime").getStyleAttributes().setLocked(true);
				row.getCell("stopRes").getStyleAttributes().setLocked(true);
				row.getCell("stopTime").setValue(null);
				row.getCell("stopRes").setValue(null);
				
			}
		}
    }
    //��¼ָ�깤�ָ���ָ����Ŀ����
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
				row.getCell("pmtProf").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
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
        String id = this.editData.getId().toString();
    	DoubEcInfo info = DoubEcFactory.getRemoteInstance().getDoubEcInfo(new ObjectUuidPK(id));
    	DoubEcEntryCollection col = info.getEntrys();
    	for (int i = 0; i < col.size(); i++) {
    		DoubEcEntryInfo etyInfo = col.get(i);
    		String etyId = etyInfo.getId().toString();//�ȷ�¼id
    		String oldId = etyInfo.getOldEtyId().toString();//ԭ��¼id
    		//Я������
			IBoAttchAsso boaFac = BoAttchAssoFactory.getRemoteInstance();
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("attachment.id");
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("boID",etyId));
			view.setFilter(filter);
			view.setSelector(sic);
			//�����ַ�¼ID��ѯ����
			BoAttchAssoCollection boaCol =boaFac.getBoAttchAssoCollection(view);
			if(boaCol!=null && boaCol.size()>0){
				for(int j=0;j<boaCol.size();j++){
					BoAttchAssoInfo boaInfo = boaCol.get(j);
					//��Ӹ���
					BoAttchAssoInfo newBoaInfo = new BoAttchAssoInfo();
					newBoaInfo.setId(BOSUuid.create(newBoaInfo.getBOSType()));
					newBoaInfo.setBoID(oldId);//ԭ��¼id
					newBoaInfo.setAssoType("ϵͳ���и���");//����
					newBoaInfo.setAttachment(boaInfo.getAttachment());//����
					newBoaInfo.setAssoBusObjType("63B6D9EE");//����ҵ���������ͣ�˫��֤��¼BOSTYPE
					boaFac.addnew(newBoaInfo);
				}
			}
			//ɾ��ԭ�и���
			boaFac.delete(filter);
		}
    	int count = this.kdtEntrys.getRowCount3();
    	for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("oldEtyId").getValue() != null) {
				DoubQualifyEntryInfo etyInfo = DoubQualifyEntryFactory.getRemoteInstance().getDoubQualifyEntryInfo(new ObjectUuidPK(row.getCell("oldEtyId").getValue().toString()));
				SelectorItemCollection sic = new SelectorItemCollection();
				//��������
				if(row.getCell("name").getValue() != null){
					etyInfo.setName(row.getCell("name").getValue().toString());
				}else{
					etyInfo.setName(null);
				}
				sic.add("name");
				//����ƴ��
				if(row.getCell("namePY").getValue() != null){
					etyInfo.setNamePY(row.getCell("namePY").getValue().toString());
				}else{
					etyInfo.setNamePY(null);
				}
				sic.add("namePY");
				//�Ա� 
				if(row.getCell("genDers").getValue() != null){
					etyInfo.setGenDers((Genders)row.getCell("genDers").getValue());
				}else{
					etyInfo.setGenDers(null);
				}
				sic.add("genDers");
				//��������
				if(row.getCell("birthdate").getValue() != null){
					etyInfo.setBirthdate((Date) row.getCell("birthdate").getValue());
				}else{
					etyInfo.setBirthdate(null);
				}
				sic.add("birthdate");
				//�����أ����ģ�
					if(row.getCell("birthPlaceCn").getValue() != null){
						etyInfo.setBirthPlaceCn(row.getCell("birthPlaceCn").getValue().toString());
					}else{
						etyInfo.setBirthPlaceCn(null);
					}
					sic.add("birthPlaceCn");
				//�����أ�ƴ����
					if(row.getCell("birthPlaceFr").getValue() != null){
						etyInfo.setBirthPlaceFr(row.getCell("birthPlaceFr").getValue().toString());
					}else{
						etyInfo.setBirthPlaceFr(null);
					}
					sic.add("birthPlaceFr");
				//���֤��
					if(row.getCell("IdNum").getValue() != null){
						etyInfo.setIdNum(row.getCell("IdNum").getValue().toString());
					}else{
						etyInfo.setIdNum(null);
					}
					sic.add("IdNum");
				//ʵ��רҵ����
					if(row.getCell("actProf").getValue() != null){
						etyInfo.setActProf(row.getCell("actProf").getValue().toString());
					}else{
						etyInfo.setActProf(null);
					}
					sic.add("actProf");
				//ָ�깤������
					if(row.getCell("pmtProf").getValue() != null){
						ProjectWorkInfo projectInfo = (ProjectWorkInfo) row.getCell("pmtProf").getValue();
	    				ProjectWorkInfo cInfo = ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(projectInfo.getId()));
						etyInfo.setPmtProf(cInfo);
					}else{
						etyInfo.setPmtProf(null);
					}
					sic.add("pmtProf");
				//ָ�깤�ַ���
					if(row.getCell("pmtProfFr").getValue() != null){
						etyInfo.setPmtProfFr(row.getCell("pmtProfFr").getValue().toString());
					}else{
						etyInfo.setPmtProfFr(null);
					}
					sic.add("pmtProfFr");
				//����
					if(row.getCell("natioNal").getValue() != null){
						CountryInfo countryInfo = (CountryInfo) row.getCell("natioNal").getValue();
	        			CountryInfo cInfo = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(countryInfo.getId()));
						etyInfo.setNatioNal(cInfo);
					}else{
						etyInfo.setNatioNal(null);
					}
					sic.add("laborSignNo");
				//���պ���
					if(row.getCell("passpNo").getValue() != null){
						etyInfo.setPasspNo(row.getCell("passpNo").getValue().toString());
					}else{
						etyInfo.setPasspNo(null);
					}
					sic.add("passpNo");
				//��������
					if(row.getCell("workSuffer").getValue() != null){
						etyInfo.setWorkSuffer(Integer.parseInt(row.getCell("workSuffer").getValue().toString()));
					}else{
						etyInfo.setWorkSuffer(0);
					}
					sic.add("workSuffer");
				//��֤��֤����
					if(row.getCell("type").getValue() != null){
						etyInfo.setType((authType) row.getCell("type").getValue());
					}else{
						etyInfo.setType(null);
					}
					sic.add("type");
				//��֤��֤����
					if(row.getCell("copies").getValue() != null){
						etyInfo.setCopies(Integer.parseInt(row.getCell("copies").getValue().toString()));
					}else{
						etyInfo.setCopies(0);
					}
					sic.add("copies");
				//���乤�����ʱ��
					if(row.getCell("assignDate").getValue() != null){
						etyInfo.setAssignDate((Date) row.getCell("assignDate").getValue());
					}else{
						etyInfo.setAssignDate(null);
					}
					sic.add("assignDate");	
				//��֤��֤���κ�
					if(row.getCell("qualbaNum").getValue() != null){
						etyInfo.setQualbaNum(row.getCell("qualbaNum").getValue().toString());
					}else{
						etyInfo.setQualbaNum(null);
					}
					sic.add("qualbaNum");
				//��֤��ʼ����ʱ��
					if(row.getCell("notiDate").getValue() != null){
						etyInfo.setNotiDate((Date) row.getCell("notiDate").getValue());
					}else{
						etyInfo.setNotiDate(null);
					}
					sic.add("notiDate");
				//��֤�������ʱ��
					if(row.getCell("notaDate").getValue() != null){
						etyInfo.setNotaDate((Date) row.getCell("notaDate").getValue());
					}else{
						etyInfo.setNotaDate(null);
					}
					sic.add("notaDate");
				//��֤��ʼ����ʱ��
					if(row.getCell("qualSendDate").getValue() != null){
						etyInfo.setQualSendDate((Date) row.getCell("qualSendDate").getValue());
					}else{
						etyInfo.setQualSendDate(null);
					}
					sic.add("qualSendDate");
				//��֤�������ʱ��
					if(row.getCell("qualDate").getValue() != null){
						etyInfo.setQualDate((Date) row.getCell("qualDate").getValue());
					}else{
						etyInfo.setQualDate(null);
					}
					sic.add("qualDate");
				//ָ����Ŀ
					if(row.getCell("pmtProj").getValue() != null){
						AdminOrgUnitInfo countryInfo = (AdminOrgUnitInfo) row.getCell("pmtProj").getValue();
	    				AdminOrgUnitInfo cInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
						etyInfo.setPmtProj(cInfo);
					}else{
						etyInfo.setPmtProj(null);
					}
					sic.add("pmtProj");
				//������ĿtaskProj
					if(row.getCell("taskProj").getValue() != null){
						AdminOrgUnitInfo countryInfo = (AdminOrgUnitInfo) row.getCell("taskProj").getValue();
	    				AdminOrgUnitInfo cInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
						etyInfo.setTaskProj(cInfo);
					}else{
						etyInfo.setTaskProj(null);
					}
					sic.add("taskProj");
				//������λpartner
					if(row.getCell("partner").getValue() != null){
						AdminOrgUnitInfo countryInfo = (AdminOrgUnitInfo) row.getCell("partner").getValue();
	    				AdminOrgUnitInfo cInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(countryInfo.getId()));
						etyInfo.setPartner(cInfo);
					}else{
						etyInfo.setPartner(null);
					}
					sic.add("partner");
				//�Ƿ�ͣ��
					if(row.getCell("ifstop").getValue().equals(true)){
						etyInfo.setIfstop(true);
					}else{
						etyInfo.setIfstop(false);
					}
					sic.add("ifstop");
				//ͣ��ʱ��
					if(row.getCell("stopTime").getValue() != null){
						etyInfo.setStopTime((Date) row.getCell("stopTime").getValue());
					}else{
						etyInfo.setStopTime(null);
					}
					sic.add("stopTime");
				//ͣ������
					if(row.getCell("stopRes").getValue() != null){
						etyInfo.setStopRes(row.getCell("stopRes").getValue().toString());
					}else{
						etyInfo.setStopRes(null);
					}
					sic.add("stopRes");
				//��ע
					if(row.getCell("desCription").getValue() != null){
						etyInfo.setDesCription(row.getCell("desCription").getValue().toString());
					}else{
						etyInfo.setDesCription(null);
					}
					sic.add("desCription");
					
					
				//�Ƿ����������֤��
					if(row.getCell("wkPmtGet").getValue().equals(true)){
						etyInfo.setWkPmtGet(true);
					}else{
						etyInfo.setWkPmtGet(false);
					}
					sic.add("wkPmtGet");
				//    ����
					if(row.getCell("wpCopies").getValue() != null){
						etyInfo.setWpCopies(Integer.parseInt(row.getCell("wpCopies").getValue().toString()));
					}else{
						etyInfo.setWpCopies(0);
					}
					sic.add("wpCopies");
				//��֤���ʱ��
					if(row.getCell("pmtFiDate").getValue() != null){
						etyInfo.setPmtFiDate((Date) row.getCell("pmtFiDate").getValue());
					}else{
						etyInfo.setPmtFiDate(null);
					}
					sic.add("pmtFiDate");
				//˫��֤���ʱ��
					if(row.getCell("dbFiDate").getValue() != null){
						etyInfo.setDbFiDate((Date) row.getCell("dbFiDate").getValue());
					}else{
						etyInfo.setDbFiDate(null);
					}
					sic.add("dbFiDate");
				DoubQualifyEntryFactory.getRemoteInstance().updatePartial(etyInfo, sic);
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
     	Date now = new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		int rowCount = this.kdtEntrys.getRowCount();
		if (rowCount == 0) {
			MsgBox.showInfo("δ�����Ա��Ϣ���������ύ��");
			abort();
		}
		if(chkifNeed.isSelected()){
			if(txtneedReson.getText()==null||txtneedReson.getText().equals("")){
				MsgBox.showInfo("��ѡ���죬�������ɲ���Ϊ�գ�");
				abort();
			}
		}
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			if(row.getCell("ifstop").getValue().equals(false)) {
				if(row.getCell("wkPmtGet").getValue().equals(true)){
					if(row.getCell("pmtFiDate").getValue() == null){
						MsgBox.showInfo("��֤���ʱ��(��������)Ϊ�գ��������ύ��");
						abort();
					}
					if(row.getCell("dbFiDate").getValue() == null){
						MsgBox.showInfo("˫��֤���ʱ��(��������)Ϊ�գ��������ύ��");
						abort();
					}
					//��֤���ʱ�䣨�������飩>=���乤�����ʱ��
					Date pmtFiDate = (Date)row.getCell("pmtFiDate").getValue();//��֤���ʱ��
					Date assignDate = (Date)row.getCell("assignDate").getValue();//���乤�����ʱ��
					Date dbFiDate = (Date)row.getCell("dbFiDate").getValue();//˫��֤���ʱ��
					assignDate=sdf.parse(sdf.format(assignDate));
					if(pmtFiDate.before(assignDate)){   
						MsgBox.showInfo("��֤���ʱ�䣨�������飩С�ڷ��乤�����ʱ�䣬�������ύ��");
						abort();
					}
					//˫��֤���ʱ�䣨�������飩>=��֤���ʱ�䣨�������飩
					if(dbFiDate.before(pmtFiDate)){  
						MsgBox.showInfo("��֤�������ʱ�䣨�������飩С�ڹ�֤��ʼ����ʱ�䣬�������ύ��");
						abort();
					}
				}
				if (row.getCell("IdNum").getValue() == null&&row.getCell("passpNo").getValue() == null) {
					MsgBox.showInfo("���֤���뻤�պŲ���ͬʱΪ�գ�");
					abort();
				}
				if (row.getCell("pmtProf").getValue() == null) {
					MsgBox.showInfo("ָ�깤������Ϊ�գ��������ύ��");
					abort();
				}
				if (row.getCell("assignDate").getValue() == null) {
					MsgBox.showInfo("���乤�����ʱ��Ϊ�գ��������ύ��");
					abort();
				}
				if (row.getCell("qualbaNum").getValue() == null) {
					MsgBox.showInfo("��֤��֤���κ�Ϊ�գ��������ύ��");
					abort();
				}
//				if (row.getCell("type").getValue().equals(authType.NONE)) {
//				}else{
				if (row.getCell("notiDate").getValue() == null) {
					MsgBox.showInfo("��֤��ʼ����ʱ��Ϊ�գ��������ύ��");
					abort();
				}
				if (row.getCell("notaDate").getValue() == null) {
					MsgBox.showInfo("��֤�������ʱ��գ��������ύ��");
					abort();
				}
				if (row.getCell("qualSendDate").getValue() == null) {
					MsgBox.showInfo("��֤��ʼ����ʱ��Ϊ�գ��������ύ��");
					abort();
				}
				if (row.getCell("qualDate").getValue() == null) {
					MsgBox.showInfo("��֤�������ʱ��Ϊ�գ��������ύ��");
					abort();
				}
				//��֤��ʼ����ʱ��>=���乤�����ʱ��
				Date notiDate = (Date)row.getCell("notiDate").getValue();
				Date assignDate = (Date)row.getCell("assignDate").getValue();
				assignDate=sdf.parse(sdf.format(assignDate));
				if(notiDate.before(assignDate)){   
					MsgBox.showInfo("��֤��ʼ����ʱ��С�ڷ��乤�����ʱ�䣬�������ύ��");
					abort();
				}
				//��֤�������ʱ��>=��֤��ʼ����ʱ��
				Date notaDate = (Date)row.getCell("notaDate").getValue();
				if(notaDate.before(notiDate)){  
					MsgBox.showInfo("��֤�������ʱ��С�ڹ�֤��ʼ����ʱ�䣬�������ύ��");
					abort();
				}
				//��֤��ʼ����ʱ��>=��֤�������ʱ��
				Date qualSendDate = (Date)row.getCell("qualSendDate").getValue();
				if(qualSendDate.before(notaDate)){   
					MsgBox.showInfo("��֤��ʼ����ʱ��С�ڹ�֤�������ʱ�䣬�������ύ��");
					abort();
				}
				//��֤�������ʱ��>=��֤��ʼ����ʱ��
				Date qualDate = (Date)row.getCell("qualDate").getValue();
				if(qualDate.before(qualSendDate)){
					MsgBox.showInfo("��֤�������ʱ��С����֤��ʼ����ʱ�䣬�������ύ��");
					abort();
				}
//				}
				if (row.getCell("pmtProj").getValue() == null) {
					MsgBox.showInfo("ָ����ĿΪ�գ��������ύ��");
					abort();
				}
				if (row.getCell("taskProj").getValue() == null) {
					MsgBox.showInfo("������ĿΪ�գ��������ύ��");
					abort();
				}
				
			}else if(row.getCell("ifstop").getValue().equals(true)){
				if (row.getCell("stopTime").getValue() == null) {
					MsgBox.showInfo("��ѡͣ���ͣ��ʱ��Ϊ�գ��������ύ��");
					abort();
				}
				if (row.getCell("stopRes").getValue() == null) {
					MsgBox.showInfo("��ѡͣ���ͣ������Ϊ�գ��������ύ��");
					abort();
				}
			}
			String id = row.getCell("oldEtyId").getValue().toString();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",id));
			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(filter);
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("billSate");
			DoubQualifyEntryCollection antiCol = DoubQualifyEntryFactory.getRemoteInstance().getDoubQualifyEntryCollection(view);
			for (int j = 0; j < antiCol.size(); j++) {
				DoubQualifyInfo antiInfo = antiCol.get(j).getParent();
				antiInfo.setBillSate(BillStateEnum.SUBMIT);
				DoubQualifyFactory.getRemoteInstance().updatePartial(antiInfo, sic);
			}
		}
    	super.doBeforeSubmit(e);
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
        return com.kingdee.eas.zjlw.certificates.DoubEcFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.certificates.DoubEcInfo objectValue = new com.kingdee.eas.zjlw.certificates.DoubEcInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
    protected void setButtonStatus() {
    	DoubEcInfo bill;
    		if ("VIEW".equals(getOprtState())) {
//    			this.actionAudit.setVisible(true);
//    			this.actionUnAudit.setVisible(true);
//    			this.actionAudit.setEnabled(true);
//    			this.actionUnAudit.setEnabled(true);

    			bill = (DoubEcInfo) this.editData;
    			if (this.editData != null) {
    				if ((BillStateEnum.CHECKED.equals(bill.getBillSate()))) {//|| (BillStateEnum.SIGNED.equals(bill.getBillSate())
//    					this.actionUnAudit.setVisible(true);
//    					this.actionUnAudit.setEnabled(true);
//    					this.actionAudit.setVisible(false);
//    					this.actionAudit.setEnabled(false);
    					this.actionEdit.setEnabled(false);
    					this.actionRemove.setEnabled(false);
    				} else {
//    					this.actionUnAudit.setVisible(false);
//    					this.actionUnAudit.setEnabled(false);
//    					this.actionAudit.setVisible(true);
//    					this.actionAudit.setEnabled(true);
    					this.actionRemove.setEnabled(true);
    					this.actionEdit.setEnabled(true);
    				}
    			}

    			this.actionAddLine.setEnabled(false);
    			this.actionRemoveLine.setEnabled(false);
    			this.actionInsertLine.setEnabled(false);
    		} else {
    			bill = (DoubEcInfo) this.editData;
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
    			bill = (DoubEcInfo) this.editData;
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