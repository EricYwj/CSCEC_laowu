/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.AntiECCollection;
import com.kingdee.eas.zjlw.certificates.AntiECFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryFactory;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.EmbassyRegEntryCollection;
import com.kingdee.eas.zjlw.certificates.EmbassyRegEntryFactory;
import com.kingdee.eas.zjlw.certificates.EmbassyRegFactory;
import com.kingdee.eas.zjlw.certificates.EmbassyRegInfo;
import com.kingdee.eas.zjlw.certificates.ImmiEcEntryCollection;
import com.kingdee.eas.zjlw.certificates.ImmiEcEntryInfo;
import com.kingdee.eas.zjlw.certificates.ImmiEcFactory;
import com.kingdee.eas.zjlw.certificates.ImmiEcInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryCollection;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryFactory;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationFactory;
import com.kingdee.eas.zjlw.certificates.ImmigrationInfo;
import com.kingdee.eas.zjlw.certificates.VisaEcEntryCollection;
import com.kingdee.eas.zjlw.certificates.VisaEcEntryInfo;
import com.kingdee.eas.zjlw.certificates.VisaEcFactory;
import com.kingdee.eas.zjlw.certificates.VisaEcInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryFactory;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class ImmiEcEditUI extends AbstractImmiEcEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ImmiEcEditUI.class);
    
    public void onLoad() throws Exception {
    	super.onLoad();
    	//------------------ԭ���ݱ༭����onload��ʵ�ֹ���---------------
    	this.txtNumber.setEnabled(false);
    	//setUITitle("�����뾳");
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

    	//setEntryLocked();//���ñ�����Ƿ�ɱ༭
    	
    	//------------------��ȡԭ��¼���ݽ��и�ֵ---------------
    	if (getOprtState().equals("ADDNEW")) {
			//��ȡ���ܵ��Ĳ���
    		Map uictxMap = this.getUIContext();
    		Set etys = new HashSet();
    		etys = (Set) uictxMap.get("etys");
    		//������ǩ�����¼����
    		for (Object object : etys) {
    			ImmigrationEntryInfo etyInfo = (ImmigrationEntryInfo) object;
    			//������¼��ֵ��ֵ��һ��
    			IRow row = this.kdtEntrys.addRow();
    			row.getCell("oldEtyId").setValue(etyInfo.getId());
    			row.getCell("name").setValue(etyInfo.getName());//��������
    			row.getCell("lastName").setValue(etyInfo.getLastName());//��ƴ��
    			row.getCell("firstName").setValue(etyInfo.getFirstName());//��ƴ��
    			row.getCell("sex").setValue(etyInfo.getSex());//�Ա� 
    			row.getCell("birthdate").setValue(etyInfo.getBirthdate());//��������//��������
    			CountryInfo countryInfo  = new CountryInfo();
    			if (etyInfo.getNatioNal() != null) {
    				countryInfo  = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(etyInfo.getNatioNal().getId()));
				}
    			row.getCell("natioNal").setValue(countryInfo);//����
    			row.getCell("actproff").setValue(etyInfo.getActproff());//ʵ��רҵ����
    			row.getCell("passpNum").setValue(etyInfo.getPasspNum());//���պ���
    			row.getCell("passpExDate").setValue(etyInfo.getPasspExDate());//���յ�������
    			row.getCell("veTime").setValue(etyInfo.getVeTime());//ǩ֤��������
				//ǩ֤��������
    			row.getCell("contDepart").setValue(etyInfo.getContDepart());//ǩ����ͬ��λ
    			row.getCell("dbCmpTime").setValue(etyInfo.getDbCmpTime());//˫��֤���ʱ��
    			row.getCell("contSTime").setValue(etyInfo.getContSTime());//��ͬǩ��ʱ��
    			row.getCell("contOtime").setValue(etyInfo.getContOtime());//��ͬ��Чʱ��
    			row.getCell("ifbuyInsure").setValue(etyInfo.isIfbuyInsure());//�Ƿ�����
    			row.getCell("isHand").setValue(etyInfo.isIsHand());//�Ƿ������ʽ���֤���챾��
    			row.getCell("apAlgTime").setValue(etyInfo.getApAlgTime());//�����밢ʱ��
    			row.getCell("ifUnexpect").setValue(etyInfo.isIfUnexpect());//Υ���뾳
    			row.getCell("isCancel").setValue(etyInfo.isIsCancel());//�Ƿ�ͣ��
    			row.getCell("cancelDate").setValue(etyInfo.getCancelDate());//ͣ��ʱ��
    			row.getCell("stopRsn").setValue(etyInfo.getStopRsn());//ͣ������
    			AdminOrgUnitInfo adminOrgUnitInfo  = new AdminOrgUnitInfo();
    			if (etyInfo.getPartner() != null) {
    				adminOrgUnitInfo  = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(etyInfo.getPartner().getId()));
    				row.getCell("partner").setValue(adminOrgUnitInfo);//������λ
    			}else{
    				row.getCell("partner").setValue(null);
				}
    			if (etyInfo.getTaskProj() != null) {
    				adminOrgUnitInfo  = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(etyInfo.getTaskProj().getId()));
    				row.getCell("taskProj").setValue(adminOrgUnitInfo);//������Ŀ
				}else{
    				row.getCell("taskProj").setValue(null);
				}
    			if (etyInfo.getPmtProj() != null) {
    				adminOrgUnitInfo  = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(etyInfo.getPmtProj().getId()));
    				row.getCell("pmtProj").setValue(adminOrgUnitInfo);//ָ����Ŀ
				}else{
    				row.getCell("pmtProj").setValue(null);
				}
    			row.getCell("reportAffiliated").setValue(etyInfo.isReportAffiliated());//�뾳���뱨��ҿ���
    			row.getCell("contactway").setValue(etyInfo.getContactway());//������ϵ��ʽ���ֻ��ţ�
    			row.getCell("residence").setValue(etyInfo.getResidence());//������ϵ��ϸ��ַ��ʡ���أ�
    			row.getCell("IdNum").setValue(etyInfo.getIdNum());//���֤��
    			row.getCell("description").setValue(etyInfo.getDescription());//��ע
    			row.getCell("personID").setValue(etyInfo.getPersonID());
			}
		}
    	if (getOprtState().equals("ADDNEW")) {
		int rowCount = this.kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			//�Զ���ѡ�Ƿ�ʹ��ע��
//			if (row.getCell("pmtProj").getValue() != null) {
//				FilterInfo filter = new FilterInfo();
//				filter.getFilterItems().add(new FilterItemInfo("proCom.name",row.getCell("pmtProj").getValue().toString()));
//				EntityViewInfo view = new EntityViewInfo();
//		    	view.setFilter(filter);
//		    	SelectorItemCollection sic = new SelectorItemCollection();
//		    	sic.add("isLogin");
//		    	view.setSelector(sic);
//		    	ProjectOrgCollection pOrgCol = ProjectOrgFactory.getRemoteInstance().getProjectOrgCollection(view);
//		    	ProjectOrgInfo pOrgInfo = pOrgCol.get(0);
//	        	row.getCell("ifImmige").setValue(pOrgInfo.isIsLogin());
//			}
			//��ѯ˫��֤���ʱ��
			if (row.getCell("personID").getValue() != null) {
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("personID",row.getCell("personID").getValue()));
				//filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
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
		setEntryLocked();
	   }
    }
    
  //��ѡͣ�죺���ñ�����Ƿ�ɱ༭
    protected void setEntryLocked(){
    	int rowCount = this.kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			//�Ƿ�Υ���뾳
			if(row.getCell("ifUnexpect").getValue().equals(true)){
				row.getCell("isCancel").getStyleAttributes().setLocked(true);
				row.getCell("isCancel").setValue(false);
				row.getCell("cancelDate").setValue(null);
				row.getCell("stopRsn").setValue(null);
			}
			//�Ƿ�ͣ�����ñ�����Ƿ�ɱ༭
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
     * �ж��Ƿ�Υ���뾳
     * ������1.ǩ֤��Ч��<30�죻2.˫��֤δ���
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
//     * ˫��֤�Ƿ����ͨ��
//     * true��ͨ����false��δͨ��
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
//			MsgBox.showInfo("�޷���ѯ������Ա��˫��֤��Ϣ��");
//			abort();
//		}
////		Date d = dqInfo.getAuditDate();
//    	if (dqInfo.getBillSate()!=null && "40".equalsIgnoreCase(dqInfo.getBillSate().getValue())) {//���ͨ��
////    		row.getCell("dbCmpTime").setValue(d);
//			return true;
//		} else {//δͨ��
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
    public ImmiEcEditUI() throws Exception
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
		//ǩ����ͬ����
//		if ("contSTime".equals(key)){
//			Date papSTime=(Date) row.getCell("contSTime").getValue();
//			if(papSTime!=null){
//    			long time=(papSTime.getTime()-date.getTime())/86400000;
//    			if(time>0){
//    				MsgBox.showInfo("ǩ����ͬ���ڲ��ɳ��ڵ�ǰʱ�䣬��������д��");
//    				row.getCell("contSTime").setValue(null);
//    			}
//    		}
//		}
//		//��ͬ��Ч����
//		if ("contOtime".equals(key)){
//			Date wPmtGTime=(Date) row.getCell("contOtime").getValue();
//			if(wPmtGTime!=null){
//    			long time=(wPmtGTime.getTime()-date.getTime())/86400000;
//    			if(time>0){
//    				MsgBox.showInfo("��ͬ��Ч���ڲ��ɳ��ڵ�ǰʱ�䣬��������д��");
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
     * output pkinteADate_dataChanged method
     */
    protected void pkinteADate_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        super.pkinteADate_dataChanged(e);
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
        //---------------��дԭ���ݷ�¼--------------
        String id = this.editData.getId().toString();
    	ImmiEcInfo info = ImmiEcFactory.getRemoteInstance().getImmiEcInfo(new ObjectUuidPK(id));
    	ImmiEcEntryCollection col = info.getEntrys();
    	for (int i = 0; i < col.size(); i++) {
    		ImmiEcEntryInfo etyInfo = col.get(i);
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
					newBoaInfo.setAssoBusObjType("E48C97B9");//����ҵ���������ͣ������뾳��¼BOSTYPE
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
				ImmigrationEntryInfo etyInfo = ImmigrationEntryFactory.getRemoteInstance().getImmigrationEntryInfo(new ObjectUuidPK(row.getCell("oldEtyId").getValue().toString()));
				SelectorItemCollection sic = new SelectorItemCollection();
				//ǩ����ͬ��λ
				if(row.getCell("contDepart").getValue() != null){
					etyInfo.setContDepart(row.getCell("contDepart").getValue().toString());
				}else{
					etyInfo.setContDepart(null);
				}
				sic.add("contDepart");
				//��ͬǩ��ʱ��
				if(row.getCell("contSTime").getValue() != null){
					etyInfo.setContSTime((Date) row.getCell("contSTime").getValue());
				}else{
					etyInfo.setContSTime(null);
				}
				//˫��֤���ʱ�� dbCmpTime
				if(row.getCell("dbCmpTime").getValue() != null){
					etyInfo.setDbCmpTime((Date) row.getCell("dbCmpTime").getValue());
				}else{
					etyInfo.setDbCmpTime(null);
				}
				sic.add("dbCmpTime");
				sic.add("contSTime");
				//��ͬ��Чʱ��
				if(row.getCell("contOtime").getValue() != null){
					etyInfo.setContOtime((Date) row.getCell("contOtime").getValue());
				}else{
					etyInfo.setContOtime(null);
				}
				sic.add("contOtime");
				//�Ƿ�����
				if(row.getCell("ifbuyInsure").getValue().equals(true)){
					etyInfo.setIfbuyInsure(true);
				}else{
					etyInfo.setIfbuyInsure(false);
				}
				sic.add("ifbuyInsure");
				//�Ƿ������ʽ���֤���챾��
				if(row.getCell("isHand").getValue().equals(true)){
					etyInfo.setIsHand(true);
				}else{
					etyInfo.setIsHand(false);
				}
				sic.add("isHand");
				//�����밢ʱ��
				if(row.getCell("apAlgTime").getValue() != null){
					etyInfo.setApAlgTime((Date) row.getCell("apAlgTime").getValue());
				}else{
					etyInfo.setApAlgTime(null);
				}
				sic.add("apAlgTime");
				//�뾳���뱨��ҿ���
				if(row.getCell("reportAffiliated").getValue().equals(true)){
					etyInfo.setReportAffiliated(true);
				}else{
					etyInfo.setReportAffiliated(false);
				}
				sic.add("reportAffiliated");
				//�Ƿ�ͣ��
				if(row.getCell("isCancel").getValue().equals(true)){
					etyInfo.setIsCancel(true);
				}else{
					etyInfo.setIsCancel(false);
				}
				sic.add("isCancel");
				//ͣ��ʱ��
				if(row.getCell("cancelDate").getValue() != null){
					etyInfo.setCancelDate((Date) row.getCell("cancelDate").getValue());
				}else{
					etyInfo.setCancelDate(null);
				}
				sic.add("cancelDate");
				//ͣ������
				if(row.getCell("stopRsn").getValue() != null){
					etyInfo.setStopRsn(row.getCell("stopRsn").getValue().toString());
				}else{
					etyInfo.setStopRsn(null);
				}
				sic.add("stopRsn");
				//��ע
				if(row.getCell("description").getValue() != null){
					etyInfo.setDescription(row.getCell("description").getValue().toString());
				}else{
					etyInfo.setDescription(null);
				}
				sic.add("description");
				ImmigrationEntryFactory.getRemoteInstance().updatePartial(etyInfo, sic);
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
	 * �����Ƿ����δǩ����ͬ����Ա
	 * @param ctx
	 * @param info
	 * @return
	 */
	protected void doBeforeSubmit(ActionEvent e) throws Exception {
		checkNull();
		super.doBeforeSubmit(e);
	}
	
	private void checkNull() throws ParseException, BOSException, EASBizException {
		int result =0;
		Date now = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		now=sdf.parse(sdf.format(now)); 
		int rowCount = this.kdtEntrys.getRowCount();
		if (rowCount == 0) {
			MsgBox.showInfo("δ�����Ա��Ϣ���������ύ��");
			abort();
		}
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			//�Ƿ�ͣ��
			if (row.getCell("isCancel").getValue().equals(false)){
				//���յ���ʱ��-today<=6���£��޷��ύ��
				if (row.getCell("passpExDate").getValue() == null){
					MsgBox.showInfo("���յ���ʱ��Ϊ�գ��������ύ��");
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
    		     result=month1-month;//�������������£����·ݲ�
    		    }
    		    else
    		    {
    		     result=12*(year1-year)+month1-month;//�������������£����·ݲ�
    		    }
    		  //2016-12-23  ��ʽ��ʱ�޸Ļ���
//    			if(result<=6){
//    				MsgBox.showInfo("���յ���ʱ��С�ڵ���6���£��������ύ��");
//					abort();
//    			}
//				//ǩ֤������-today<=0�����޷��ύ��
//    			if (row.getCell("veTime").getValue() == null){
//					MsgBox.showInfo("ǩ֤������Ϊ�գ��������ύ��");
//					abort();
//				}
				Date veTime = (Date) row.getCell("veTime").getValue();
				veTime=sdf.parse(sdf.format(veTime)); 
				long  veday=(veTime.getTime()-now.getTime())/86400000;
				//2016-12-23  ��ʽ��ʱ�޸Ļ���
//				if(veday<=0){
//					MsgBox.showInfo("ǩ֤������С�ڵ��ڵ�ǰ���ڣ��������ύ��");
//					abort();
//				}
				//Υ���뾳У��˫��֤���ʱ��   2016-12-23  ��ʽ��ʱ�޸Ļ���
//				if (row.getCell("ifUnexpect").getValue().equals(false)) {
//					if (row.getCell("dbCmpTime").getValue() == null) {
//						if (MsgBox.showConfirm2(this, "˫��֤δ������ɣ��Ƿ����Υ���뾳��") != 0){
//			    			abort();
//						}else{
//							row.getCell("ifUnexpect").setValue(true);
//						}
//					}else{
//						if (veday<30) {
//				    		if (MsgBox.showConfirm2(this, "ǩ֤��������С����ʮ�죬�Ƿ����Υ���뾳��") != 0){
//				    			abort();
//							}else{
//								row.getCell("ifUnexpect").setValue(true);
//							}
//				    	}
//					}
//				}
				if (row.getCell("contDepart").getValue() == null){
					MsgBox.showInfo("ǩ����ͬ��λΪ�գ��������ύ��");
					abort();
				}
				if (row.getCell("contSTime").getValue() == null){
					MsgBox.showInfo("��ͬǩ��ʱ��Ϊ�գ��������ύ��");
					abort();
				}
				if (row.getCell("contOtime").getValue() == null){
					MsgBox.showInfo("��ͬ��Чʱ��Ϊ�գ��������ύ��");
					abort();
				}
				if (row.getCell("ifbuyInsure").getValue().equals(false)){
					MsgBox.showInfo("�Ƿ�����δ��ѡ���������ύ��");
					abort();
				}
				if (row.getCell("isHand").getValue().equals(false)){
					MsgBox.showInfo("�Ƿ������ʽ���֤���챾��δ��ѡ���������ύ��");
					abort();
				}
				if (row.getCell("apAlgTime").getValue() == null){
					MsgBox.showInfo("�����밢ʱ��Ϊ�գ��������ύ��");
					abort();
				}
				//��ͬ��Чʱ����ڵ��ں�ͬǩ��ʱ�䡣
				Date contSTime = (Date)row.getCell("contSTime").getValue();
				contSTime=sdf.parse(sdf.format(contSTime)); 
				Date contOtime = (Date)row.getCell("contOtime").getValue();
				contOtime=sdf.parse(sdf.format(contOtime)); 
				if (contOtime.before(contSTime)) {
					MsgBox.showInfo("��ͬ��Чʱ��С�ں�ͬǩ��ʱ�䣬�������ύ��");
					abort();
				}
				//1.����ʱ��-today>=0��2.�����밢ʱ�������ڵ��ں�ͬǩ��ʱ�䡣
				Date apAlgTime = (Date)row.getCell("apAlgTime").getValue();
				apAlgTime=sdf.parse(sdf.format(apAlgTime)); 
				long  apday=(apAlgTime.getTime()-now.getTime())/86400000;
				//2016-12-23  ��ʽ��ʱ�޸Ļ���
//				if(apday<0){ 
//					MsgBox.showInfo("�����밢ʱ��С�ڵ�ǰ���ڣ��������ύ��");
//					abort();
//				}
				if (apAlgTime.before(contSTime)) {
					MsgBox.showInfo("�����밢ʱ��С�ں�ͬǩ��ʱ�䣬�������ύ��");
					abort();
				}
			}else{
				if (row.getCell("cancelDate").getValue() == null){
					MsgBox.showInfo("��ѡͣ���ͣ��ʱ��Ϊ�գ��������ύ��");
					abort();
				}
				if (row.getCell("stopRsn").getValue() == null){
					MsgBox.showInfo("��ѡͣ���ͣ������Ϊ�գ��������ύ��");
					abort();
				}
			}
			//---------------------�ύ��дԭ����----------------------------
			String id = row.getCell("oldEtyId").getValue().toString();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",id));
			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(filter);
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("billSate");
			ImmigrationEntryCollection antiCol = ImmigrationEntryFactory.getRemoteInstance().getImmigrationEntryCollection(view);
			for (int j = 0; j < antiCol.size(); j++) {
				ImmigrationInfo antiInfo = antiCol.get(j).getParent();
				antiInfo.setBillSate(BillStateEnum.SUBMIT);
				ImmigrationFactory.getRemoteInstance().updatePartial(antiInfo, sic);
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
        return com.kingdee.eas.zjlw.certificates.ImmiEcFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.certificates.ImmiEcInfo objectValue = new com.kingdee.eas.zjlw.certificates.ImmiEcInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
    protected void setButtonStatus() {
    	ImmiEcInfo bill;
		if ("VIEW".equals(getOprtState())) {
//			this.actionAudit.setVisible(true);
//			this.actionUnAudit.setVisible(true);
//			this.actionAudit.setEnabled(true);
//			this.actionUnAudit.setEnabled(true);

			bill = (ImmiEcInfo) this.editData;
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
			bill = (ImmiEcInfo) this.editData;
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
			bill = (ImmiEcInfo) this.editData;
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