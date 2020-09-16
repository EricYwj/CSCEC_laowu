/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.client;

import java.awt.event.*;
import java.text.SimpleDateFormat;
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
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitECEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitECEntryInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitECFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitECInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryEntryFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtECEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtECEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtECFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtECInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryInfo;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.DOCTYPE;
import com.kingdee.eas.zjlw.common.EcClientHelper;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class LivepermitECEditUI extends AbstractLivepermitECEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(LivepermitECEditUI.class);
    
    /**
     * output class constructor
     */
    public LivepermitECEditUI() throws Exception
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
    	setButtonStatus();
    	//��ȡ��ǰ�û���Ϣ
    	UserInfo user = SysContext.getSysContext().getCurrentUserInfo();
    	String userNum = "";
    	if (user!=null) {
    		userNum = user.getNumber();
		}
    	Set userSet = new HashSet();
    	userSet.add("ying_wujie");
    	userSet.add("wang_kai");
    	if (userSet.contains(userNum)) {
    		btnAddNew.setVisible(true);
        	btnWorkFlowG.setVisible(true);
        	btnAuditResult.setVisible(true);
        	btnCopy.setVisible(true);
        	btnCreateFrom.setVisible(true);
        	btnCreateTo.setVisible(true);
        	btnMultiapprove.setVisible(true);
        	btnNextPerson.setVisible(true);
        	btnFirst.setVisible(true);
        	btnPre.setVisible(true);
        	btnNext.setVisible(true);
        	btnLast.setVisible(true);
        	btnAudit.setVisible(true);
        	btnUnAudit.setVisible(true);
        	kdtEntrys_detailPanel.getAddNewLineButton().setVisible(true);
    		kdtEntrys_detailPanel.getInsertLineButton().setVisible(true);
    		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(true);
        	this.billSate.setEditable(true);
        	this.pkauditDate.setEnabled(true);
    	}else{
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
        	this.pkauditDate.setEnabled(false);
    	}
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
    	//--------------��ȡԭ��������------------------------------------------- 2016-11-08  zxh
    	if (getOprtState().equals("ADDNEW")) {
			//��ȡ���ܵ��Ĳ���
    		Map uictxMap = this.getUIContext();
    		Set etys = new HashSet();
    		etys = (Set) uictxMap.get("etys");
    		//������ǩ�����¼����
    		for (Object object : etys) {
    			LivepermitEntryInfo etyInfo = (LivepermitEntryInfo) object;
    			//������¼��ֵ��ֵ��һ��
    			IRow row = this.kdtEntrys.addRow();
    			row.getCell("oldEtyId").setValue(etyInfo.getId());
    			row.getCell("name").setValue(etyInfo.getName());//��������
    			row.getCell("lastName").setValue(etyInfo.getLastName());//��ƴ��
    			row.getCell("firstName").setValue(etyInfo.getFirstName());//��ƴ��
    			row.getCell("sex").setValue(etyInfo.getSex());//�Ա� 
    			row.getCell("birth").setValue(etyInfo.getBirth());//��������
    			row.getCell("birthPlace").setValue(etyInfo.getBirthPlace());//�����أ����ģ�
    			row.getCell("birthPlaceFr").setValue(etyInfo.getBirthPlaceFr());//�����أ�ƴ����
    			row.getCell("passpNum").setValue(etyInfo.getPasspNum());//���պ���
    			row.getCell("passportIssueDate").setValue(etyInfo.getPassportIssueDate());//����ǩ������
    			row.getCell("passpExDate").setValue(etyInfo.getPasspExDate());//���յ�������
    			row.getCell("passportAgence").setValue(etyInfo.getPassportAgence());//���հ䷢����
    			row.getCell("passportCityF").setValue(etyInfo.getPassportCityF());//����ǩ���أ�ƴ����
    			row.getCell("actProf").setValue(etyInfo.getActProf());//ʵ��רҵ����
    			row.getCell("prmtProf").setValue(etyInfo.getPrmtProf());//ָ�깤�ַ���
    			row.getCell("fatherName").setValue(etyInfo.getFatherName());//��������
    			row.getCell("fatherNameAlphabet").setValue(etyInfo.getFatherNameAlphabet());//��������ƴ��
    			row.getCell("motherName").setValue(etyInfo.getMotherName());//ĸ������
    			row.getCell("motherNameAlphabet").setValue(etyInfo.getMotherNameAlphabet());//ĸ������ƴ��
    			row.getCell("MaritalStatus").setValue(etyInfo.getMaritalStatus());//����״̬
    			row.getCell("coupleName").setValue(etyInfo.getCoupleName());//��ż����
    			row.getCell("coupleNameAlphabet").setValue(etyInfo.getCoupleNameAlphabet());//��ż����ƴ��
    			row.getCell("coupleBirthDate").setValue(etyInfo.getCoupleBirthDate());//��ż��������
    			row.getCell("couplebirthPlace").setValue(etyInfo.getCouplebirthPlace());//��ż������
    			row.getCell("coupleWorkPlace").setValue(etyInfo.getCoupleWorkPlace());//��ż������λ����Ŀ
    			row.getCell("isHand").setValue(etyInfo.isIsHand());//�Ƿ������ʽ���֤���챾��
    			row.getCell("VisaNum").setValue(etyInfo.getVisaNum());//ǩ֤����
    			row.getCell("vsTima").setValue(etyInfo.getVsTima());//ǩ֤ǩ������
    			row.getCell("veTime").setValue(etyInfo.getVeTime());//ǩ֤��������
    			row.getCell("immiTime").setValue(etyInfo.getImmiTime());//�밢ʱ��
    			row.getCell("wPmtNum").setValue(etyInfo.getWPmtNum());//�Ͷ�֤��
    			row.getCell("wPmtGTime").setValue(etyInfo.getWPmtGTime());//�Ͷ�֤��֤����
    			row.getCell("laboreffDate").setValue(etyInfo.getLaboreffDate());//�Ͷ�֤��Ч����
    			row.getCell("wPmtSTime").setValue(etyInfo.getWPmtSTime());//�Ͷ�֤��������
    			row.getCell("reWorkPmtDate").setValue(etyInfo.getReWorkPmtDate());//�յ��Ͷ�֤ʱ��
    			row.getCell("papSTime").setValue(etyInfo.getPapSTime());//��ס֤���ϵݽ�ʱ��
    			row.getCell("docType").setValue(etyInfo.getDocType());//��ס֤����
    			row.getCell("rePmtNum").setValue(etyInfo.getRePmtNum());//��ʱ��ס֤����
    			row.getCell("sRePmtSTime").setValue(etyInfo.getSRePmtSTime());//��ʱ��ס֤��֤����
    			row.getCell("rePmtETime").setValue(etyInfo.getRePmtETime());//��ʱ��ס֤��������
    			row.getCell("pmtNum").setValue(etyInfo.getPmtNum());//��ʽ��ס֤����
    			row.getCell("pmtSTime").setValue(etyInfo.getPmtSTime());//��ʽ��ס֤��ȡ����
    			row.getCell("pmteffDate").setValue(etyInfo.getPmteffDate());//��ʽ��ס֤��Ч����
    			row.getCell("pmtETime").setValue(etyInfo.getPmtETime());//��ʽ��ס֤��������
    			row.getCell("departure").setValue(etyInfo.isDeparture());//�Ƿ�δ�������뾳
    			row.getCell("isStop").setValue(etyInfo.isIsStop());//�Ƿ�ͣ��
    			row.getCell("endTime").setValue(etyInfo.getEndTime());//ͣ��ʱ��
    			row.getCell("cancelReson").setValue(etyInfo.getCancelReson());//ͣ������
    			row.getCell("isEmbassyReg").setValue(etyInfo.isIsEmbassyReg());//�Ƿ����ʹ��ע��
    			row.getCell("oldPassport").setValue(etyInfo.getOldPassport());//�ɻ��պ���
    			row.getCell("IdNum").setValue(etyInfo.getIdNum());//���֤��
    			row.getCell("remark").setValue(etyInfo.getRemark());//��ע
    			row.getCell("personID").setValue(etyInfo.getPersonID());//��Ա��¼id
    			if(etyInfo.getNation()!=null){
    				CountryInfo contryInfo=etyInfo.getNation();
    				CountryInfo nation=CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("nation").setValue(nation);//����
    			}
    			if(etyInfo.getCoupleNational()!=null){
    				CountryInfo contryInfo=etyInfo.getNation();
    				CountryInfo coupleNational=CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("coupleNational").setValue(coupleNational);//��ż����
    			}
    			if(etyInfo.getPassportCityC()!=null){
    				ProvinceInfo contryInfo=etyInfo.getPassportCityC();
    				ProvinceInfo passportCityC=ProvinceFactory.getRemoteInstance().getProvinceInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("passportCityC").setValue(passportCityC);//����ǩ���أ����ģ�
    			}
    			if(etyInfo.getQuProf()!=null){
    				ProjectWorkInfo contryInfo=etyInfo.getQuProf();
    				ProjectWorkInfo quProf=ProjectWorkFactory.getRemoteInstance().getProjectWorkInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("quProf").setValue(quProf);//ָ�깤������
    			}
    			if(etyInfo.getPmtProj()!=null){
    				AdminOrgUnitInfo contryInfo=etyInfo.getPmtProj();
    				AdminOrgUnitInfo pmtProj=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("pmtProj").setValue(pmtProj);//ָ����Ŀ
    			}
    			if(etyInfo.getWorkOrg()!=null){
    				AdminOrgUnitInfo contryInfo=etyInfo.getPmtProj();
    				AdminOrgUnitInfo workOrg=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("workOrg").setValue(workOrg);//������Ŀ
    			}
    			if(etyInfo.getCooperation()!=null){
    				AdminOrgUnitInfo contryInfo=etyInfo.getCooperation();
    				AdminOrgUnitInfo cooperation=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(contryInfo.getId()));
        			row.getCell("cooperation").setValue(cooperation);//������λ
    			}
    		}
    		setEntryLocked();
    	}
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
    	LivepermitECInfo bill;
    	//��ȡ��ǰ�û���Ϣ
    	UserInfo user = SysContext.getSysContext().getCurrentUserInfo();
    	String userNum = user.getNumber();
    	Set userSet = new HashSet();
    	userSet.add("ying_wujie");
    	userSet.add("wang_kai");
    	if (userSet.contains(userNum)) {
    		this.actionUnAudit.setVisible(true);
			this.actionUnAudit.setEnabled(true);
			this.actionAudit.setVisible(true);
			this.actionAudit.setEnabled(true);
			this.actionEdit.setEnabled(true);
			this.actionRemove.setEnabled(true);
			this.actionSave.setEnabled(true);
			this.actionAddLine.setEnabled(true);
			this.actionRemoveLine.setEnabled(true);
			this.actionInsertLine.setEnabled(true);
			this.actionPrint.setEnabled(true);
			this.actionPrintPreview.setEnabled(true);
			this.actionAttachment.setEnabled(true);
		} else {
			if ("VIEW".equals(getOprtState())) {
				this.actionAudit.setVisible(true);
				this.actionUnAudit.setVisible(true);
				this.actionAudit.setEnabled(true);
				this.actionUnAudit.setEnabled(true);
				bill = (LivepermitECInfo) this.editData;
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
				bill = (LivepermitECInfo) this.editData;
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
				bill = (LivepermitECInfo) this.editData;
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
      //==================================���ݷ�¼id��дԭ��¼============================== 2016-11-08 zxh
        //--------------------��д��¼����----------------------------------------------------
        String id = this.editData.getId().toString();
    	LivepermitECInfo info =LivepermitECFactory.getRemoteInstance().getLivepermitECInfo(new ObjectUuidPK(id));
    	LivepermitECEntryCollection col = info.getEntrys();
    	for (int i = 0; i < col.size(); i++) {
    		LivepermitECEntryInfo etyInfo = col.get(i);
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
					newBoaInfo.setAssoBusObjType("BDDF1E3A");//����ҵ���������ͣ�ԭ�Ͷ�֤��¼BOSTYPE
					boaFac.addnew(newBoaInfo);
				}
			}
			//ɾ��ԭ�и���
			boaFac.delete(filter);
    	}
    	//--------------------��д��¼�ֶ�----------------------------------------------------  2016-11-11 zxh
    	int count = this.kdtEntrys.getRowCount3();
    	for (int i = 0; i < count; i++) {
			IRow row = this.kdtEntrys.getRow(i);
			if (row.getCell("oldEtyId").getValue() != null) {
				LivepermitEntryInfo etyInfo = LivepermitEntryFactory.getRemoteInstance().getLivepermitEntryInfo(new ObjectUuidPK(row.getCell("oldEtyId").getValue().toString()));
				SelectorItemCollection sic = new SelectorItemCollection();
				//��ע                      remark
				if(row.getCell("remark").getValue() != null){
					etyInfo.setRemark( (String) row.getCell("remark").getValue());
				}else{
					etyInfo.setRemark(null);
				}
				//��ס֤���ϵݽ�ʱ��  papSTime
				if(row.getCell("papSTime").getValue() != null){
					etyInfo.setPapSTime((Date) row.getCell("papSTime").getValue());
				}else{
					etyInfo.setPapSTime(null);
				}
				//��ס֤����  docType
				if(row.getCell("docType").getValue() != null){
					etyInfo.setDocType((DOCTYPE) row.getCell("docType").getValue());
				}else{
					etyInfo.setDocType(null);
				}
				//��ʱ��ס֤����   rePmtNum
				if(row.getCell("rePmtNum").getValue() != null){
					etyInfo.setRePmtNum((String) row.getCell("rePmtNum").getValue());
				}else{
					etyInfo.setRePmtNum(null);
				}
				//��ʱ��ס֤��֤����   sRePmtSTime
				if(row.getCell("sRePmtSTime").getValue() != null){
					etyInfo.setSRePmtSTime((Date) row.getCell("sRePmtSTime").getValue());
				}else{
					etyInfo.setSRePmtSTime(null);
				}
				//��ʱ��ס֤��������   rePmtETime
				if(row.getCell("rePmtETime").getValue() != null){
					etyInfo.setRePmtETime((Date) row.getCell("rePmtETime").getValue());
				}else{
					etyInfo.setRePmtETime(null);
				}
				//��ʽ��ס֤����   pmtNum
				if(row.getCell("pmtNum").getValue() != null){
					etyInfo.setPmtNum((String) row.getCell("pmtNum").getValue());
				}else{
					etyInfo.setPmtNum(null);
				}
				//��ʽ��ס֤��ȡ����  pmtSTime
				if(row.getCell("pmtSTime").getValue() != null){
					etyInfo.setPmtSTime((Date) row.getCell("pmtSTime").getValue());
				}else{
					etyInfo.setPmtSTime(null);
				}
				//��ʽ��ס֤��Ч����    pmteffDate
				if(row.getCell("pmteffDate").getValue() != null){
					etyInfo.setPmteffDate((Date) row.getCell("pmteffDate").getValue());
				}else{
					etyInfo.setPmteffDate(null);
				}
				//��ʽ��ס֤��������   pmtETime
				if(row.getCell("pmtETime").getValue() != null){
					etyInfo.setPmtETime((Date) row.getCell("pmtETime").getValue());
				}else{
					etyInfo.setPmtETime(null);
				}
				//�Ƿ�δ�������뾳   departure
				if(row.getCell("departure").getValue().equals(true)){
					etyInfo.setDeparture(true);
				}else{
					etyInfo.setDeparture(false);
				}
				//�Ƿ�ͣ��  isStop
				if(row.getCell("isStop").getValue().equals(true)){
					etyInfo.setIsStop(true);
				}else{
					etyInfo.setDeparture(false);
				}
				//ͣ��ʱ��  endTime
				if(row.getCell("endTime").getValue() != null){
					etyInfo.setEndTime((Date) row.getCell("endTime").getValue());
				}else{
					etyInfo.setEndTime(null);
				}
				//ͣ������ cancelReson
				if(row.getCell("cancelReson").getValue() != null){
					etyInfo.setCancelReson((String) row.getCell("cancelReson").getValue());
				}else{
					etyInfo.setCancelReson(null);
				}
				sic.add("papSTime");//��ס֤���ϵݽ�ʱ��
				sic.add("docType");//��ס֤����
				sic.add("rePmtNum");//��ʱ��ס֤����
				sic.add("sRePmtSTime");//��ʱ��ס֤��֤����
				sic.add("rePmtETime");//��ʱ��ס֤��������
				sic.add("pmtNum");//��ʽ��ס֤����
				sic.add("pmtSTime");//��ʽ��ס֤��ȡ����
				sic.add("pmteffDate");//��ʽ��ס֤��Ч����
				sic.add("pmtETime");//��ʽ��ס֤��������
				sic.add("departure");//�Ƿ�δ�������뾳    boolean
				sic.add("isStop");//�Ƿ�ͣ��  boolean
				sic.add("endTime");//ͣ��ʱ��
				sic.add("cancelReson");//ͣ������
				sic.add("remark");//��ע
				LivepermitEntryFactory.getRemoteInstance().updatePartial(etyInfo, sic);
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
    	//----------------------��дԭ���ݣ����õ���״̬Ϊ���ύ------------------------------------
    	int rowCount=kdtEntrys.getRowCount();
		for(int i=0;i<rowCount;i++){
			IRow row = this.kdtEntrys.getRow(i);
			String id = row.getCell("oldEtyId").getValue().toString();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",id));
			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(filter);
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("billSate");
			LivepermitEntryCollection antiCol = LivepermitEntryFactory.getRemoteInstance().getLivepermitEntryCollection(view);
			for (int j = 0; j < antiCol.size(); j++) {
				LivepermitInfo antiInfo = antiCol.get(j).getParent();
				antiInfo.setBillSate(BillStateEnum.SUBMIT);
				LivepermitFactory.getRemoteInstance().updatePartial(antiInfo, sic);
			}
		}
    	checkDstry();
    	super.doBeforeSubmit(e);
    }
    //zxh 2016-11-11
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
        return com.kingdee.eas.zjlw.certificates.LivepermitECFactory.getRemoteInstance();
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
        com.kingdee.eas.zjlw.certificates.LivepermitECInfo objectValue = new com.kingdee.eas.zjlw.certificates.LivepermitECInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}