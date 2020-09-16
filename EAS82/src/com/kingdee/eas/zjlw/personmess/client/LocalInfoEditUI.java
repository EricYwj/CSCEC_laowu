/**
 * output package name
 */
package com.kingdee.eas.zjlw.personmess.client;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.ibm.db2.jcc.a.f;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.assistant.Province;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.BlackListCollection;
import com.kingdee.eas.zjlw.baseinfo.BlackListFactory;
import com.kingdee.eas.zjlw.baseinfo.Coopration;
import com.kingdee.eas.zjlw.baseinfo.CooprationInfo;
import com.kingdee.eas.zjlw.baseinfo.LocalBlackListCollection;
import com.kingdee.eas.zjlw.baseinfo.LocalBlackListFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProf;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryCollection;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryFactory;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoFactory;
import com.kingdee.eas.zjlw.personmess.LocalInfoInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryFactory;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class LocalInfoEditUI extends AbstractLocalInfoEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(LocalInfoEditUI.class);
    
    /**
     * output class constructor
     */
    public LocalInfoEditUI() throws Exception
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
    
    public void onLoad() throws Exception {
    	super.onLoad();
    	if (!BillStateEnum.CHECKED.equals(this.editData.getBillSate())) {
    		setButtonStatus();
//        	setUITitle("���ػ�Ա����Ϣ¼��");
        	addKdtEntryDetailPanelListener();
//        	checkProf();
//    		checkCountry();
//    		filterProf();
    		checkAndFilterAll();
        	//����ָ����Ŀ��������Ŀ���ݹ���
    		KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
    		settNumPromptBox.setEditable(true);
    		settNumPromptBox.setDisplayFormat("$name$");
    		settNumPromptBox.setEditFormat("$number$");
    		settNumPromptBox.setCommitFormat("$number$");
    		settNumPromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
    		EntityViewInfo evi = new EntityViewInfo();
    		FilterInfo filterInfo = new FilterInfo();
    		filterInfo.getFilterItems().add(new FilterItemInfo("number","H%",CompareType.NOTLIKE));
//    		filterInfo.getFilterItems().add(new FilterItemInfo("number","fb001",CompareType.NOTEQUALS));
//    		filterInfo.getFilterItems().add(new FilterItemInfo("number","CSCEC",CompareType.NOTEQUALS));
    		evi.setFilter(filterInfo);
    		settNumPromptBox.setEntityViewInfo(evi);
    		//kdtEntrys.getColumn("permitProgram").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
    		kdtEntrys.getColumn("workProgram").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
    		//������λ
    		KDBizPromptBox cooperationBox = new KDBizPromptBox();
    		cooperationBox.setEditable(true);
    		cooperationBox.setDisplayFormat("$name$");
    		cooperationBox.setEditFormat("$number$");
    		cooperationBox.setCommitFormat("$number$");
    		cooperationBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
    		evi = new EntityViewInfo();
    		filterInfo = new FilterInfo();
    		filterInfo.getFilterItems().add(new FilterItemInfo("number","H%",CompareType.LIKE));
    		//filterInfo.getFilterItems().add(new FilterItemInfo("number","CSCEC",CompareType.NOTEQUALS));
    		evi.setFilter(filterInfo);
    		cooperationBox.setEntityViewInfo(evi);
    		kdtEntrys.getColumn("cooperation").setEditor(new KDTDefaultCellEditor(cooperationBox));
		}
    }
    
    /**
     * ���ˡ���ֵ����
     * @throws EASBizException
     * @throws BOSException
     */
    private void checkAndFilterAll() throws EASBizException, BOSException {
    	int rowCount=kdtEntrys.getRowCount();
    	for(int i=0;i<rowCount;i++){
    		IRow row=kdtEntrys.getRow(i);
    		AdminOrgUnitInfo  cooperation= (AdminOrgUnitInfo) row.getCell("cooperation").getValue();
    		AdminOrgUnitInfo  proCom= (AdminOrgUnitInfo) prmtproCom.getValue();
    		if(proCom!=null){
        		AdminOrgUnitInfo  secuProj= AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(proCom.getId()));
        		if(secuProj!=null){
    				row.getCell("secuProj").setValue(secuProj);
    			}else{
    				row.getCell("secuProj").setValue(null);
    			}
    		}
    		ProjSecuProfInfo secuNum =(ProjSecuProfInfo) row.getCell("secuNumber").getValue();
			if(cooperation!=null){
				row.getCell("cooperationId").setValue(cooperation.getNumber());
			}else{
				row.getCell("cooperationId").setValue(null);
				}
			if(secuNum!=null){
				ProjSecuProfInfo secuNumber = ProjSecuProfFactory.getRemoteInstance().getProjSecuProfInfo(new ObjectUuidPK(secuNum.getId()));
				row.getCell("secuProf").setValue(secuNumber);
				row.getCell("nBasePay").setValue(secuNumber.getBasePay());
			}else{
				row.getCell("secuProf").setValue(null);
				row.getCell("nBasePay").setValue(null);
			}
			
			FilterInfo filter = new FilterInfo();
    		filter.getFilterItems().add(new FilterItemInfo("number","C24"));
    		SelectorItemCollection sic = new SelectorItemCollection();
    		sic.add("*");
    		EntityViewInfo view = new EntityViewInfo();
    		view.setFilter(filter);
    		view.setSelector(sic);
    		CountryInfo country = CountryFactory.getRemoteInstance().getCountryCollection(view).get(0);
    		if(country!=null){
        		row.getCell("country").setValue(country);
    		}
    		
    		AdminOrgUnitInfo admin = (AdminOrgUnitInfo) row.getCell("secuProj").getValue();
			if(admin!=null){
				KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
				settNumPromptBox.setEditable(true);
				settNumPromptBox.setDisplayFormat("$name$");
				settNumPromptBox.setEditFormat("$number$");
				settNumPromptBox.setCommitFormat("$number$");
				settNumPromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjSecuProfQuery");
				EntityViewInfo evi = new EntityViewInfo();
				FilterInfo filterInfo = new FilterInfo();
				filterInfo.getFilterItems().add(new FilterItemInfo("proCom.id",admin.getId().toString()));
				evi.setFilter(filterInfo);
				settNumPromptBox.setEntityViewInfo(evi);
				row.getCell("secuProf").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
			}
    	}
	}
	//��д������λ�Զ�����������λ���룬��д�籣���֣��Զ������������ݡ�
    private void checkProf() throws EASBizException, BOSException {
    	int rowCount=kdtEntrys.getRowCount();
    	for(int i=0;i<rowCount;i++){
    		IRow row=kdtEntrys.getRow(i);
    		AdminOrgUnitInfo  cooperation= (AdminOrgUnitInfo) row.getCell("cooperation").getValue();
    		AdminOrgUnitInfo  proCom= (AdminOrgUnitInfo) prmtproCom.getValue();
    		if(proCom!=null){
        		AdminOrgUnitInfo  secuProj= AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(proCom.getId()));
        		if(secuProj!=null){
    				row.getCell("secuProj").setValue(secuProj);
    			}else{
    				row.getCell("secuProj").setValue(null);
    			}
    		}
    		ProjSecuProfInfo secuNumber=(ProjSecuProfInfo) row.getCell("secuNumber").getValue();
			if(cooperation!=null){
				row.getCell("cooperationId").setValue(cooperation.getNumber());
			}else{
				row.getCell("cooperationId").setValue(null);
				}
			if(secuNumber!=null){
				row.getCell("secuProf").setValue(secuNumber);
				row.getCell("nBasePay").setValue(secuNumber.getBasePay());
			}else{
				row.getCell("secuProf").setValue(null);
				row.getCell("nBasePay").setValue(null);
			}
    	}
	}
    //���ؽ����Զ����ɹ���
    private void checkCountry() throws BOSException {
    	int rowCount=kdtEntrys.getRowCount();
    	for(int i=0;i<rowCount;i++){
    		IRow row=kdtEntrys.getRow(i);
    		FilterInfo filter = new FilterInfo();
    		filter.getFilterItems().add(new FilterItemInfo("number","C24"));
    		SelectorItemCollection sic = new SelectorItemCollection();
    		sic.add("*");
    		EntityViewInfo view = new EntityViewInfo();
    		view.setFilter(filter);
    		view.setSelector(sic);
    		CountryInfo country = CountryFactory.getRemoteInstance().getCountryCollection(view).get(0);
    		if(country!=null){
        		row.getCell("country").setValue(country);
    		}
    	}

	}
    //���
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
    	
    	super.actionAudit_actionPerformed(e);
    }
    //�����
    
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
    	
    	super.actionUnAudit_actionPerformed(e);
    }
  
    private void filterProf(){
    	int rowCount = this.kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			AdminOrgUnitInfo admin = (AdminOrgUnitInfo) row.getCell("secuProj").getValue();
			if(admin!=null){
				KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
				settNumPromptBox.setEditable(true);
				settNumPromptBox.setDisplayFormat("$name$");
				settNumPromptBox.setEditFormat("$number$");
				settNumPromptBox.setCommitFormat("$number$");
				settNumPromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjSecuProfQuery");
				EntityViewInfo evi = new EntityViewInfo();
				FilterInfo filterInfo = new FilterInfo();
				filterInfo.getFilterItems().add(new FilterItemInfo("proCom.id",admin.getId().toString()));
				evi.setFilter(filterInfo);
				settNumPromptBox.setEntityViewInfo(evi);
				row.getCell("secuProf").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
			}
		}
    }
    
    
    /**
     * ��ӷ�¼�����¼���ʵ�ַ�¼���Ĭ��ֵ
     */
    private void addKdtEntryDetailPanelListener() {
    	IDetailPanelListener listener = new DetailPanelAdapter() {
    		public void beforeEvent(DetailPanelEvent e) throws Exception {
    			setLineValue(e); //���÷�¼����Ĭ��ֵ
    		}
    	};
    	kdtEntrys_detailPanel.addAddListener(listener);//ģ�����Ӽ���
    }
    
    /**
     * ʵ��IDetailPanelListener�ӿ�
     */
    private static class DetailPanelAdapter implements IDetailPanelListener {
	  public DetailPanelAdapter() {}
	  public void beforeEvent(DetailPanelEvent e) throws Exception {}
	  public void afterEvent(DetailPanelEvent e) throws Exception {}
    }
    /**
     * ����һ�е�ʱ������Ĭ��ֵ
     */
    private void setLineValue(DetailPanelEvent e) {
    	LocalInfoEntryInfo localEntryInfo = (LocalInfoEntryInfo) e.getObjectValue(); //��ȡ��¼����
    	try {
    		FilterInfo filter = new FilterInfo();
    		filter.getFilterItems().add(new FilterItemInfo("number","C24"));
    		SelectorItemCollection sic = new SelectorItemCollection();
    		sic.add("*");
    		EntityViewInfo view = new EntityViewInfo();
    		view.setFilter(filter);
    		view.setSelector(sic);
    		CountryInfo country;
    			country = CountryFactory.getRemoteInstance().getCountryCollection(view).get(0);
    			localEntryInfo.setCountry(country);
    	} catch (BOSException e1) {
    		e1.printStackTrace();
    	}
    }
    
    protected void setButtonStatus() {
    	LocalInfoInfo bill;
		if ("VIEW".equals(getOprtState())) {
			this.actionAudit.setVisible(true);
			this.actionUnAudit.setVisible(true);
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);

			bill = (LocalInfoInfo) this.editData;
			if (this.editData != null) {
				if (BillStateEnum.CHECKED.equals(bill.getBillSate())) {// (BillStateEnum.SIGNE.equals(bill.getBillSate()))
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
			bill = (LocalInfoInfo) this.editData;
			if (("EDIT".equals(getOprtState())) && (this.editData != null)&& (BillStateEnum.SUBMIT.equals(bill.getBillSate()))) {
				this.actionSave.setEnabled(true);
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
			bill = (LocalInfoInfo) this.editData;
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
		
		//��д������λ��������λ����Զ�����
		if("cooperation".equals(key)){
			AdminOrgUnitInfo  cooperation= (AdminOrgUnitInfo) row.getCell("cooperation").getValue();
			if(cooperation!=null){
				row.getCell("cooperationId").setValue(cooperation.getNumber());
			}else{
				row.getCell("cooperationId").setValue(null);
				}
		}
		if("secuProj".equals(key)){
			int rowCount = this.kdtEntrys.getRowCount();
			for(int i=0;i<rowCount;i++){
				AdminOrgUnitInfo admin = (AdminOrgUnitInfo) row.getCell("secuProj").getValue();
				if(admin!=null){
					KDBizPromptBox settNumPromptBox = new KDBizPromptBox();
					settNumPromptBox.setEditable(true);
					settNumPromptBox.setDisplayFormat("$name$");
					settNumPromptBox.setEditFormat("$number$");
					settNumPromptBox.setCommitFormat("$number$");
					settNumPromptBox.setQueryInfo("com.kingdee.eas.zjlw.baseinfo.app.ProjSecuProfQuery");
					EntityViewInfo evi = new EntityViewInfo();
					FilterInfo filterInfo = new FilterInfo();
					filterInfo.getFilterItems().add(new FilterItemInfo("proCom.id",admin.getId().toString()));
					evi.setFilter(filterInfo);
					settNumPromptBox.setEntityViewInfo(evi);
					row.getCell("secuProf").setEditor(new KDTDefaultCellEditor(settNumPromptBox));
				}
			}
		}
		//����ѡ��ͬһ�籣��
		if ("securityNo".equals(key)){
			int rowCount = kdtEntrys.getRowCount();
			for(int i=0;i<rowCount;i++){
				IRow row1 = kdtEntrys.getRow(i);
				if(i!=rowIndex ){
					if(row1.getCell("securityNo").getValue()!=null){
						String securityNo = row1.getCell("securityNo").getValue().toString();
						if(row.getCell("securityNo").getValue()!=null){
							String securityNo1 = row.getCell("securityNo").getValue().toString();
							if(securityNo.equals(securityNo1)){
								MsgBox.showInfo("�Ѵ��ڴ��籣�����ݣ����������룡");
								row.getCell("securityNo").setValue(null);
								this.abort();
							}
						}
					}
				}
			}
		}
		//����ѡ��ͬһCCP�˺�
		if ("CCPNo".equals(key)){
			int rowCount = kdtEntrys.getRowCount();
			for(int i=0;i<rowCount;i++){
				IRow row1 = kdtEntrys.getRow(i);
				if(i!=rowIndex ){
					if(row1.getCell("CCPNo").getValue()!=null){
						String securityNo = row1.getCell("CCPNo").getValue().toString();
						if(row.getCell("CCPNo").getValue()!=null){
							String securityNo1 = row.getCell("CCPNo").getValue().toString();
							if(securityNo.equals(securityNo1)){
								MsgBox.showInfo("�Ѵ��ڴ�CCP�˺����ݣ����������룡");
								row.getCell("securityNo").setValue(null);
								this.abort();
							}
						}
					}
				}
			}
		}
	
	}
    
    
    

    /**
     * output btnAddLine_actionPerformed method
     */
    protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnAddLine_actionPerformed(e);
//        LocalInfoEntryInfo localEntryInfo = (LocalInfoEntryInfo) e.get; //��ȡ��¼����
//    	try {
//    		FilterInfo filter = new FilterInfo();
//    		filter.getFilterItems().add(new FilterItemInfo("number","C24"));
//    		SelectorItemCollection sic = new SelectorItemCollection();
//    		sic.add("*");
//    		EntityViewInfo view = new EntityViewInfo();
//    		view.setFilter(filter);
//    		view.setSelector(sic);
//    		CountryInfo country;
//    			country = CountryFactory.getRemoteInstance().getCountryCollection(view).get(0);
//    			localEntryInfo.setCountry(country);
//    	} catch (BOSException e1) {
//    		e1.printStackTrace();
//    	}
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
//		if(this.editData!=null && this.editData.getId()!=null){
//			SelectorItemCollection sic = new SelectorItemCollection();
//			sic.add("id");
//			sic.add("billSate");
//			LocalInfoInfo fiInfo = LocalInfoFactory.getRemoteInstance().getLocalInfoInfo(new ObjectUuidPK(this.editData.getId()),sic);
//			if(fiInfo.getBillSate()!=null&&!BillStateEnum.DRAFT.equals(fiInfo.getBillSate())){
//				MsgBox.showInfo("��ǰ����״̬Ϊ��"+fiInfo.getBillSate().getAlias()+"���������ظ����棡");
//				abort();
//			}
//		}
	
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
    	//ֻ���ݴ�������ύ״̬�����ύ
		if(this.editData!=null && this.editData.getId()!=null){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("id");
			sic.add("billSate");
			LocalInfoInfo fiInfo = LocalInfoFactory.getRemoteInstance().getLocalInfoInfo(new ObjectUuidPK(this.editData.getId()),sic);
			if(fiInfo.getBillSate()!=null&&!(BillStateEnum.DRAFT.equals(fiInfo.getBillSate())||BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))){
				MsgBox.showInfo("��ǰ����״̬Ϊ��"+fiInfo.getBillSate().getAlias()+"���������ظ��ύ��");
				abort();
			}
		}
		//ֻ���ݴ�������ύ״̬�����ύ
//		if(this.editData!=null && this.editData.getId()!=null){
//			SelectorItemCollection sic = new SelectorItemCollection();
//			sic.add("id");
//			sic.add("billSate");
//			LocalInfoInfo fiInfo = LocalInfoFactory.getRemoteInstance().getLocalInfoInfo(new ObjectUuidPK(this.editData.getId()),sic);
//			if(fiInfo.getBillSate()==null){
//				MsgBox.showInfo("ֻ�е���״̬Ϊ�ݴ������ύ״̬�������ύ��");
//				abort();
//			}
//			if(fiInfo.getBillSate()==null||!(BillStateEnum.DRAFT.equals(fiInfo.getBillSate())||BillStateEnum.SUBMIT.equals(fiInfo.getBillSate()))){
//				MsgBox.showInfo("��ǰ����״̬Ϊ��"+fiInfo.getBillSate().getAlias()+"���������ύ��");
//				abort();
//			}
//		}
		checkEmpty();//��Ϊ��У��
    	checkIdNumAndPassp(); //�ύͬһ�����ظ�У��
       	super.doBeforeSubmit(e);
    }
  //�ύͬһ�����ظ�У��
    public void checkIdNumAndPassp(){
		int rowCount=kdtEntrys.getRowCount();
		Set set=new HashSet();
		Set ccpSet=new HashSet();
		Set lastNameC=new HashSet();
		Set firstNameC=new HashSet();
		Set birthdateC=new HashSet();
		//Set pass=new HashSet();
		for(int i=0;i<rowCount;i++){
			IRow row= kdtEntrys.getRow(i);
			String securityNo=(String) row.getCell("securityNo").getValue();
			String ccpNo=(String) row.getCell("CCPNo").getValue();
			String lastName=(String) row.getCell("lastName").getValue();
		    String firstName=(String) row.getCell("firstName").getValue();
		    Date birthdate=(Date) row.getCell("birthdate").getValue();
//			set.add(securityNo);
//			ccpSet.add(ccpNo);
//			String passportNo=(String) row.getCell("passportNo").getValue();
//			String name=(String) row.getCell("name").getValue();
			//У���Ƿ���ڼ�����
		   
			if(securityNo!=null){
				if (set.remove(securityNo)) {
					MsgBox.showInfo("�籣�š�"+securityNo+"���Ѵ��ڴ��籣�����ݣ����������룡");
					abort();
				}	
		    }
			if(ccpNo!=null){
				if(ccpSet.remove(ccpNo)){
					MsgBox.showInfo("CCP�˺š�"+ccpNo+"���Ѵ��ڴ�CCP�˺����ݣ����������룡");
					abort();
				}
			}
			 if(lastName!=null&&firstName!=null&&birthdate!=null){
		    	 if(lastNameC.remove(lastName)&&firstNameC.remove(firstName)&&birthdateC.remove(birthdate)){
		    		MsgBox.showInfo("������"+lastName+firstName+"���ظ����ҳ���������ͬ���Ƿ�ȷ���ύ��");
//		    		MsgBox.showConfirm2("������"+lastName+firstName+"���ظ����ҳ���������ͬ���Ƿ�ȷ���ύ��");
		    		abort();
		    	 }
			}			
			set.add(securityNo);
			ccpSet.add(ccpNo);
			lastNameC.add(lastName);
			firstNameC.add(firstName);
		    birthdateC.add(birthdate);
			//pass.add(passportNo);
		}
	}
    //��Ϊ��У��
    protected void checkEmpty() throws BOSException,Exception{
    	int rowCount=kdtEntrys.getRowCount();
    	if (rowCount == 0) {
			MsgBox.showInfo("δ�����Ա��Ϣ���������ύ��");
			abort();
		}
    	for(int i=0;i<rowCount;i++){
    		IRow row=kdtEntrys.getRow(i);
    		
    		String firstName=(String) row.getCell("firstName").getValue();
    		String lastName=(String) row.getCell("lastName").getValue();
    		if(row.getCell("lastName").getValue()==null){
				MsgBox.showInfo("��ѡ����Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("firstName").getValue()==null){
				MsgBox.showInfo("��ѡ����Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("sex").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"���Ա�Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("birthdate").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"����������Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("birthPlaceF").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"��������Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("MaritalStatus").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"������״��Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("fatherName").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"����������Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("motherName").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"��ĸ������Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("address").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"����ͥסַΪ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("secuProf").getValue()==null){
    			MsgBox.showInfo("��"+lastName+firstName+"���籣����Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
    		}
    		if(row.getCell("approachTime").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"������ʱ��Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("contractNo").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"����ͬ���Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("secuProj").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"���籣��ĿΪ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("workProgram").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"��������ĿΪ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("cooperation").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"��������λΪ�գ��޷��ύ�����������룡");
    			this.abort();
			}
    		if(row.getCell("cooperationId").getValue()==null){
				MsgBox.showInfo("��"+lastName+firstName+"��������λ����Ϊ�գ��޷��ύ�����������룡");
    			this.abort();
			}
        	checkDate(row);//����У��
        	if (row.getCell("securityNo").getValue()!=null || row.getCell("CCPNo").getValue()!=null) {
        		checkPersion(row);//�ύ�ظ�¼��У��
			}
        	checkPerson(row);//���ϸ���Ա����У��
        	checkPersionHistory(row);//��Ա��ʷ��ϢУ��
    	}
    }
    //����У��
    protected void checkDate(IRow row) throws ParseException{
    	long time=0;
//    	int rowCount = this.kdtEntrys.getRowCount();
//    	for(int i=0;i<rowCount;i++){
//    		IRow row = this.kdtEntrys.getRow(i);
    	Date day=new Date();
    	Date birthDate=(Date) row.getCell("birthdate").getValue();//��������
		Date contrachSigDate=(Date) row.getCell("contrachSigDate").getValue();//��ͬǩ������
		Date contractTime=(Date) row.getCell("contractTime").getValue();//��ͬ��������
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date  cbirthDate=sdf.parse(sdf.format(birthDate));
		Date cday=sdf.parse(sdf.format(day));
		if(birthDate!=null){
			time=(cday.getTime()-cbirthDate.getTime())/86400000/365;
			if(time<18){
				MsgBox.showInfo("������"+row.getCell("lastName").getValue()+row.getCell("firstName").getValue()+"�������䲻��ʮ���꣬�޷��ύ");
				this.abort();
			}
		}
		if(contrachSigDate==null){
			MsgBox.showInfo("��"+row.getCell("lastName").getValue()+row.getCell("firstName").getValue()+"����ͬǩ������Ϊ�գ�������");
			this.abort();
		}
		if(contractTime==null){
			MsgBox.showInfo("��"+row.getCell("lastName").getValue()+row.getCell("firstName").getValue()+"����ͬ��������Ϊ�գ�������");
			this.abort();
		}
		Date csdate=sdf.parse(sdf.format(contrachSigDate)); 
		Date cdate=sdf.parse(sdf.format(contractTime)); 
		if(csdate!=null&&cdate!=null){
			//time=(cdate.getTime()-csdate.getTime())/86400000;
			if(cdate.compareTo(csdate)<=0){
				MsgBox.showInfo("������"+row.getCell("lastName").getValue()+row.getCell("firstName").getValue()+"���ĺ�ͬ��������Ӧ���ں�ͬǩ�����ڣ����������룡");
				this.abort();
			}
		}
    }
    //�ύУ�鱾�������Ƿ������ͬ��Ա�ҵ���״̬��Ϊ���ͨ��������
	public void checkPersion(IRow row) throws BOSException{
		String securityNo=(String) row.getCell("securityNo").getValue();
		String CCPNo=(String) row.getCell("CCPNo").getValue();
			EntityViewInfo view1 = new EntityViewInfo();
			FilterInfo filter1 = new FilterInfo();
			if(securityNo!=null&&CCPNo==null){
				filter1.getFilterItems().add(new FilterItemInfo("securityNo", row.getCell("securityNo").getValue()));
				filter1.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
				filter1.getFilterItems().add(new FilterItemInfo("endDate",null));
				view1.setFilter(filter1);
				LocalInfoEntryInfo  liInfo=LocalInfoEntryFactory.getRemoteInstance().getLocalInfoEntryCollection(view1).get(0);
				if (liInfo!=null) {
					MsgBox.showInfo("������Ա��" +row.getCell("lastName").getValue()+row.getCell("firstName").getValue()+"�����籣���Ѵ��ڲα��У������ظ�¼�룡 ");
					this.abort();
				}
			}
			if(securityNo==null&&CCPNo!=null){
				filter1.getFilterItems().add(new FilterItemInfo("CCPNo", row.getCell("CCPNo").getValue()));
				filter1.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
				filter1.getFilterItems().add(new FilterItemInfo("endDate",null));
				view1.setFilter(filter1);
				LocalInfoEntryInfo  liInfo=LocalInfoEntryFactory.getRemoteInstance().getLocalInfoEntryCollection(view1).get(0);
				if (liInfo!=null) {
					MsgBox.showInfo("������Ա��" +row.getCell("lastName").getValue()+row.getCell("firstName").getValue()+"����CCP�˺��Ѵ��ڲα��У������ظ�¼�룡 ");
					this.abort();
				}
			}
			if(securityNo!=null&&CCPNo!=null){
				filter1.getFilterItems().add(new FilterItemInfo("securityNo", row.getCell("securityNo").getValue()));
				filter1.getFilterItems().add(new FilterItemInfo("CCPNo", row.getCell("CCPNo").getValue()));
				filter1.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
				filter1.getFilterItems().add(new FilterItemInfo("endDate",null));
				filter1.setMaskString("(#0 or #1) and #2 and #3");
				view1.setFilter(filter1);
				LocalInfoEntryInfo  liInfo=LocalInfoEntryFactory.getRemoteInstance().getLocalInfoEntryCollection(view1).get(0);
				if (liInfo!=null) {
					MsgBox.showInfo("������Ա��" +row.getCell("lastName").getValue()+row.getCell("firstName").getValue()+"�����籣�Ż�CCP�˺��Ѵ��ڲα��У������ظ�¼�룡 ");
					this.abort();
				}
			}
//			filter1.getFilterItems().add(new FilterItemInfo("securityNo", row.getCell("securityNo").getValue()));
//			filter1.getFilterItems().add(new FilterItemInfo("CCPNo", row.getCell("CCPNo").getValue()));
//			filter1.getFilterItems().add(new FilterItemInfo("endDate",null));
//			filter1.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
//			LocalInfoEntryInfo  liInfo=LocalInfoEntryFactory.getRemoteInstance().getLocalInfoEntryCollection(view1).get(0);
//			if (liInfo!=null) {
//				MsgBox.showInfo("������Ա��" +row.getCell("lastName").getValue()+row.getCell("firstName").getValue()+"�����ڲα��У������ظ�¼�룡 ");
//				this.abort();
//			}
		
		
		
//		EntityViewInfo view = new EntityViewInfo();
//		FilterInfo filter = new FilterInfo();
//		filter.getFilterItems().add(new FilterItemInfo("securityNo", row.getCell("securityNo").getValue()));
//		filter.getFilterItems().add(new FilterItemInfo("CCPNo", row.getCell("CCPNo").getValue()));
//		filter.getFilterItems().add(new FilterItemInfo("endDate",null,CompareType.NOTEQUALS));
//		//filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
//		if(this.editData.getId()!=null){
//			filter.getFilterItems().add(new FilterItemInfo("parent.id",this.editData.getId().toString() ,CompareType.NOTEQUALS));
//			filter.setMaskString("(#0 OR #1) AND #2 AND #3 AND #4");
//		}else {
//			filter.setMaskString("(#0 OR #1) AND #2 AND #3");
//		}
//		view.setFilter(filter);
//		LocalInfoEntryCollection  col=LocalInfoEntryFactory.getRemoteInstance().getLocalInfoEntryCollection(view);
//		if (col != null && col.size() > 0) {
//			MsgBox.showInfo("������Ա��" +row.getCell("lastName").getValue()+row.getCell("firstName").getValue()+"����Ա�������ͨ���ĵ��ݣ������ظ�¼�� ");
//			this.abort();
//		}
		
		
	}
    //���ϸ���Ա����У��
    protected void checkPerson(IRow row) throws BOSException{
		EntityViewInfo view = new EntityViewInfo();
    	FilterInfo filter = new FilterInfo();
    	filter.getFilterItems().add(new FilterItemInfo("socialNo",row.getCell("securityNo").getValue(),CompareType.EQUALS));
    	filter.getFilterItems().add(new FilterItemInfo("isDisable",false,CompareType.EQUALS));
    	view.setFilter(filter);
    	LocalBlackListCollection col = LocalBlackListFactory.getRemoteInstance().getLocalBlackListCollection(view);
    	if(col!=null && col.size()>0){
    		MsgBox.showInfo("������Ա��" +row.getCell("lastName").getValue()+row.getCell("firstName").getValue()+"�����ڲ��ϸ���Ա�����У������ظ�¼�� ");
			this.abort();
    	}
    }
    //�ύʱУ����Ա��ʷ��Ϣ���Ƿ��и���Ա��״̬��Ϊ�뾳������ʾ�����ظ�¼���Ҳ������ύ
    public void checkPersionHistory(IRow row) throws BOSException{
//    	Set set = new HashSet();
//    	Set personName = new HashSet();
//    	int rowCount = this.kdtEntrys.getRowCount();
//    	for(int i=0;i<rowCount;i++){
//    		IRow row = this.kdtEntrys.getRow(i);
//		EntityViewInfo view = new EntityViewInfo();
//    	FilterInfo filter = new FilterInfo();
//		//set.add(row.getCell("securityNo").getValue());
//    	//filter.setMaskString("#0 and #1 and #2 and #3 and #4 and #5");
//    	filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.DEPARTURE,CompareType.NOTEQUALS));// �뾳
//		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.ANTISTOP,CompareType.NOTEQUALS));// ��ǩͣ�첢ע��
//		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.VISASTOP,CompareType.NOTEQUALS));// ǩ֤ͣ�첢ע��
//		filter.getFilterItems().add(new FilterItemInfo("bsnisState", perBizStateEnum.CERTISTOP,CompareType.NOTEQUALS));// ˫��֤ͣ��
//		filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.IMMIGRATIONSTOP,CompareType.NOTEQUALS));// �뾳ͣ��
//		filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.ANTIDSTRY,CompareType.NOTEQUALS));//��ǩ���ڻ���
//		filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.PASSPORTISSUEDSTOP,CompareType.NOTEQUALS));//���շ���ͣ��
//		filter.getFilterItems().add(new FilterItemInfo("bsnisState",perBizStateEnum.VISADSTRY,CompareType.NOTEQUALS));//ǩ֤���ڻ���
//    	view.setFilter(filter);
//    	PersonHistoryCollection col = PersonHistoryFactory.getRemoteInstance().getPersonHistoryCollection(view);
//    	if(col!=null && col.size()>0){
////        		for(int i=0;i<col.size();i++){
////        			PersonHistoryInfo perInfo = col.get(i);
////        			personName.add(perInfo.getNameCN());
////        		}
//    		MsgBox.showInfo("������Ա��"+row.getCell("lastName").getValue()+row.getCell("firstName").getValue()+"�����ڰ���ҵ�񣬲����ظ�¼�� ");
//    		this.abort();
//    	}
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
        return com.kingdee.eas.zjlw.personmess.LocalInfoFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		LocalInfoEntryInfo localEntryInfo = new LocalInfoEntryInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("number","C24"));
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("*");
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		view.setSelector(sic);
		CountryInfo country;
		try {
			country = CountryFactory.getRemoteInstance().getCountryCollection(view).get(0);
			localEntryInfo.setCountry(country);
		} catch (BOSException e) {
			e.printStackTrace();
		}
        return localEntryInfo;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.zjlw.personmess.LocalInfoInfo objectValue = new com.kingdee.eas.zjlw.personmess.LocalInfoInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        this.billSate.setEnabled(false);
        
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