/**
 * output package name
 */
package com.kingdee.eas.zjlw.personinfo.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.zjlw.certificates.AntiLogoutEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiLogoutEntryFactory;
import com.kingdee.eas.zjlw.certificates.AntiLogoutEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryFactory;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.EmbassyRegEntryCollection;
import com.kingdee.eas.zjlw.certificates.EmbassyRegEntryFactory;
import com.kingdee.eas.zjlw.certificates.EmbassyRegEntryInfo;
import com.kingdee.eas.zjlw.certificates.ExLivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.ExLivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.ExLivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.ExilivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.ExilivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.ExilivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.FiIncomeEntryCollection;
import com.kingdee.eas.zjlw.certificates.FiIncomeEntryFactory;
import com.kingdee.eas.zjlw.certificates.FiIncomeEntryInfo;
import com.kingdee.eas.zjlw.certificates.IfilentryEntryCollection;
import com.kingdee.eas.zjlw.certificates.IfilentryEntryFactory;
import com.kingdee.eas.zjlw.certificates.IfilentryEntryInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryCollection;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryFactory;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryCollection;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryFactory;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.PassportapplyEntryCollection;
import com.kingdee.eas.zjlw.certificates.PassportapplyEntryFactory;
import com.kingdee.eas.zjlw.certificates.PassportapplyEntryInfo;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryCollection;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryFactory;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.certificates.app.visaTypeEnum;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryFactory;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryFactory;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryInfo;

/**
 * output class name
 */
public class PersonHistoryEditUI extends AbstractPersonHistoryEditUI {
	private static final Logger logger = CoreUIObject
			.getLogger(PersonHistoryEditUI.class);

	public void onLoad() throws Exception {
		super.onLoad();
		intiKDTableVal();
		this.btnEdit.setVisible(true);
	}

	/**
	 * ��ʼ��ҳǩ���
	 * 
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void intiKDTableVal() throws BOSException, EASBizException {
		PersonHistoryInfo phInfo = this.editData;
		if(visaTypeEnum.work.equals(phInfo.getVisaType())){
			intiFIncKDTableVal(phInfo);// ���ַ���
			intiAntiSignedKDTableVal(phInfo);// ��ǩҳǩ
			intiDoubQualifyKDTableVal(phInfo);// ˫��֤
			intiVisaHandleKDTableVal(phInfo);// ǩ֤
			intiImmigrationKDTableVal(phInfo);// �뾳����
			intiEmbassyRegKDTableVal(phInfo);// ʹ��ע��
			intiWorkPmtKDTableVal(phInfo);// �Ͷ�֤����
			intiLivepermitKDTableVal(phInfo);// ��ס֤����
			intiLeaveManageKDTableVal(phInfo);// �뾳
			intiWorkPmtUpdateKDTableVal(phInfo);// �Ͷ�֤����
			intiWorkPmtChangeKDTableVal(phInfo);// �Ͷ�֤��ת
			intiLivepermitUpdateKDTableVal(phInfo);// ��ס֤����
			intiLivepermitChangeKDTableVal(phInfo);// ��ס֤��ת
			intiWorkVisaKDTableVal(phInfo);//����ǩ��Ϣ¼��
		}else if(visaTypeEnum.buss.equals(phInfo.getVisaType())){
			intiBusVisaKDTableVal(phInfo);//����ǩ
		}
		intiAttachmentTableVal(phInfo);//������Ϣ
		
		
	}
	/**
	 * ������Ϣҳǩ��ȡ����
	 */
	private void intiAttachmentTableVal(PersonHistoryInfo phInfo)
	throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("name"));
		sic.add(new SelectorItemInfo("idNum"));
		sic.add(new SelectorItemInfo("id"));
		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		//������Աҵ��״̬��ѯ��ͬ��������
		perBizStateEnum perState = phInfo.getBsnisState();
		CountryInfo coInfo=phInfo.getNation();
		if(perBizStateEnum.MESSINPUT.equals(perState)){//��Ϣ¼��
			if(visaTypeEnum.work.equals(phInfo.getVisaType())){
				if("C01".equals(coInfo.getNumber())){
					filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
				}else{
					filter.getFilterItems().add(new FilterItemInfo("passportNo", phInfo.getPassportNo()));
				}
				ev.setFilter(filter);
				ev.setSelector(sic);
				WorkVisaEntryCollection fIncEntryCol = WorkVisaEntryFactory.getRemoteInstance().getWorkVisaEntryCollection(ev);
				for (int j = 0; j < fIncEntryCol.size(); j++) {
					WorkVisaEntryInfo entryInfo = fIncEntryCol.get(j);
					IRow row = this.tblAttachment.addRow();
					row.getCell("name").setValue(entryInfo.getName());
					row.getCell("idNum").setValue(entryInfo.getIdNum());
					row.getCell("id").setValue(entryInfo.getId());
				}
			}else if(visaTypeEnum.buss.equals(phInfo.getVisaType())){
				
			}else if(visaTypeEnum.local.equals(phInfo.getVisaType())){
				
			}else if(visaTypeEnum.notCSCES.equals(phInfo.getVisaType())){
				
			}
		}else if(perBizStateEnum.INDEXALLOT.equals(perState)){//ָ�����
			if("C01".equals(coInfo.getNumber())){
				filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
			}else{
				filter.getFilterItems().add(new FilterItemInfo("passportNo", phInfo.getPassportNo()));
			}
			ev.setFilter(filter);
			ev.setSelector(sic);
			FiIncomeEntryCollection fIncEntryCol = FiIncomeEntryFactory.getRemoteInstance().getFiIncomeEntryCollection(ev);
			for (int j = 0; j < fIncEntryCol.size(); j++) {
				FiIncomeEntryInfo entryInfo = fIncEntryCol.get(j);
				IRow row = this.tblAttachment.addRow();
				row.getCell("name").setValue(entryInfo.getName());
				row.getCell("idNum").setValue(entryInfo.getIdNum());
				row.getCell("id").setValue(entryInfo.getId());
			}
		}else if(perBizStateEnum.ANTISIGNED.equals(perState)||perBizStateEnum.ANTISTOP.equals(perState)||perBizStateEnum.ANTINOT.equals(perState)){
			//��ǩ������ǩͣ�첢ע������ǩδ��
			if("C01".equals(coInfo.getNumber())){
				filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
			}else{
				filter.getFilterItems().add(new FilterItemInfo("passpNo", phInfo.getPassportNo()));
			}
			ev.setFilter(filter);
			ev.setSelector(sic);
			AntiSignedEntryCollection asEntryCol = AntiSignedEntryFactory.getRemoteInstance().getAntiSignedEntryCollection(ev);
			for (int i = 0; i < asEntryCol.size(); i++) {
				AntiSignedEntryInfo entryInfo = asEntryCol.get(i);
				IRow row = this.tblAttachment.addRow();
				row.getCell("name").setValue(entryInfo.getName());
				row.getCell("idNum").setValue(entryInfo.getIdNum());
				row.getCell("id").setValue(entryInfo.getId());
			}
		}else if(perBizStateEnum.VISA.equals(perState)){//ǩ֤����
			if("C01".equals(coInfo.getNumber())){
				filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
			}else{
				filter.getFilterItems().add(new FilterItemInfo("passpNo", phInfo.getPassportNo()));
			}
			ev.setFilter(filter);
			ev.setSelector(sic);
			VisaHandleEntryCollection fIncCol = VisaHandleEntryFactory.getRemoteInstance().getVisaHandleEntryCollection(ev);
			for (int i = 0; i < fIncCol.size(); i++) {
				VisaHandleEntryInfo entryInfo = fIncCol.get(i);
				IRow row = this.tblAttachment.addRow();
				row.getCell("name").setValue(entryInfo.getName());
				row.getCell("idNum").setValue(entryInfo.getIdNum());
				row.getCell("id").setValue(entryInfo.getId());
			}
		}else if(perBizStateEnum.IMMIGRATION.equals(perState)){//�����뾳
			if("C01".equals(coInfo.getNumber())){
				filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
			}else{
				filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
			}
			ev.setFilter(filter);
			ev.setSelector(sic);
			ImmigrationEntryCollection immgCol = ImmigrationEntryFactory.getRemoteInstance().getImmigrationEntryCollection(ev);
			for (int i = 0; i < immgCol.size(); i++) {
				ImmigrationEntryInfo entryInfo = immgCol.get(i);
				IRow row = this.tblAttachment.addRow();
				row.getCell("name").setValue(entryInfo.getName());
				row.getCell("idNum").setValue(entryInfo.getIdNum());
				row.getCell("id").setValue(entryInfo.getId());
			}
		}else if(perBizStateEnum.IMMIGRATIONOUT.equals(perState)){//Υ���뾳
			if("C01".equals(coInfo.getNumber())){
				filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
			}else{
				filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
			}
			ev.setFilter(filter);
			ev.setSelector(sic);
			IfilentryEntryCollection immgCol = IfilentryEntryFactory.getRemoteInstance().getIfilentryEntryCollection(ev);
			for (int i = 0; i < immgCol.size(); i++) {
				IfilentryEntryInfo entryInfo = immgCol.get(i);
				IRow row = this.tblAttachment.addRow();
				row.getCell("name").setValue(entryInfo.getName());
				row.getCell("idNum").setValue(entryInfo.getIdNum());
				row.getCell("id").setValue(entryInfo.getId());
			}
		}else if(perBizStateEnum.PASSPORTISSUED.equals(perState)){//���Ż���
			if("C01".equals(coInfo.getNumber())){
				filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
			}else{
				filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
			}
			ev.setFilter(filter);
			ev.setSelector(sic);
			PassportapplyEntryCollection passColl = PassportapplyEntryFactory.getRemoteInstance().getPassportapplyEntryCollection(ev);
			for (int i = 0; i < passColl.size(); i++) {
				PassportapplyEntryInfo entryInfo = passColl.get(i);
				IRow row = this.tblAttachment.addRow();
				row.getCell("name").setValue(entryInfo.getName());
				row.getCell("idNum").setValue(entryInfo.getIdNum());
				row.getCell("id").setValue(entryInfo.getId());
			}
		}else if(perBizStateEnum.WORKPERMIT.equals(perState)){//�Ͷ�֤
			if("C01".equals(coInfo.getNumber())){
				filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
			}else{
				filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
			}
			ev.setFilter(filter);
			ev.setSelector(sic);
			WorkPmtEntryCollection wpCol = WorkPmtEntryFactory.getRemoteInstance().getWorkPmtEntryCollection(ev);
			for (int i = 0; i < wpCol.size(); i++) {
				WorkPmtEntryInfo entryInfo = wpCol.get(i);
				IRow row = this.tblAttachment.addRow();
				row.getCell("name").setValue(entryInfo.getName());
				row.getCell("idNum").setValue(entryInfo.getIdNum());
				row.getCell("id").setValue(entryInfo.getId());
			}
		}else if(perBizStateEnum.RESIDENCE.equals(perState)){//��ס֤
			if("C01".equals(coInfo.getNumber())){
				filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
			}else{
				filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
			}
			ev.setFilter(filter);
			ev.setSelector(sic);
			LivepermitEntryCollection lpCol = LivepermitEntryFactory.getRemoteInstance().getLivepermitEntryCollection(ev);
			for (int i = 0; i < lpCol.size(); i++) {
				LivepermitEntryInfo entryInfo = lpCol.get(i);
				IRow row = this.tblAttachment.addRow();
				row.getCell("name").setValue(entryInfo.getName());
				row.getCell("idNum").setValue(entryInfo.getIdNum());
				row.getCell("id").setValue(entryInfo.getId());
			}
		}else if(perBizStateEnum.APPLEAVE.equals(perState)){//�����뾳
			if("C01".equals(coInfo.getNumber())){
				filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
			}else{
				filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
			}
			ev.setFilter(filter);
			ev.setSelector(sic);
			ExilivepermitEntryCollection lpCol =ExilivepermitEntryFactory.getRemoteInstance().getExilivepermitEntryCollection(ev);
			for (int i = 0; i < lpCol.size(); i++) {
				ExilivepermitEntryInfo entryInfo = lpCol.get(i);
				IRow row = this.tblAttachment.addRow();
				row.getCell("name").setValue(entryInfo.getName());
				row.getCell("idNum").setValue(entryInfo.getIdNum());
				row.getCell("id").setValue(entryInfo.getId());
			}
		}else if(perBizStateEnum.DEPARTURE.equals(perState)){//���뾳
			if("C01".equals(coInfo.getNumber())){
				filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
			}else{
				filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
			}
			ev.setFilter(filter);
			ev.setSelector(sic);
			LeaveManageEntryCollection fIncCol = LeaveManageEntryFactory.getRemoteInstance().getLeaveManageEntryCollection(ev);
			for (int i = 0; i < fIncCol.size(); i++) {
				LeaveManageEntryInfo entryInfo = fIncCol.get(i);
				IRow row = this.tblAttachment.addRow();
				row.getCell("name").setValue(entryInfo.getName());
				row.getCell("idNum").setValue(entryInfo.getIdNum());
				row.getCell("id").setValue(entryInfo.getId());
			}
		}else if(perBizStateEnum.ANTIDSTRY.equals(perState)||perBizStateEnum.VISADSTRY.equals(perState)
				||perBizStateEnum.VISASTOP.equals(perState)||perBizStateEnum.IMMIGRATIONSTOP.equals(perState)
				||perBizStateEnum.PASSPORTISSUEDSTOP.equals(perState)){
			//��ǩ���ڡ�ǩ֤���ڡ�ǩ֤ͣ�첢ע�����뾳ͣ�졢���շ���ͣ��״̬�鷴ǩע����������
			if("C01".equals(coInfo.getNumber())){
				filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
			}else{
				filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
			}
			ev.setFilter(filter);
			ev.setSelector(sic);
			AntiLogoutEntryCollection antiColl = AntiLogoutEntryFactory.getRemoteInstance().getAntiLogoutEntryCollection(ev);
			for (int i = 0; i < antiColl.size(); i++) {
				AntiLogoutEntryInfo entryInfo = antiColl.get(i);
				IRow row = this.tblAttachment.addRow();
				row.getCell("name").setValue(entryInfo.getName());
				row.getCell("idNum").setValue(entryInfo.getIdNum());
				row.getCell("id").setValue(entryInfo.getId());
			}
		}
		
	}
	/**
	 * ���ַ���ҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiFIncKDTableVal(PersonHistoryInfo phInfo)
	throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("parent.number"));
		sic.add(new SelectorItemInfo("pmtProj.name"));
		sic.add(new SelectorItemInfo("taskProj.name"));
		sic.add(new SelectorItemInfo("partner.name"));
		sic.add(new SelectorItemInfo("parent.auditDate"));
		sic.add(new SelectorItemInfo("remark"));
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passportNo", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
//		filter.setMaskString("#0 OR #1");
		ev.setFilter(filter);
		ev.setSelector(sic);
		FiIncomeEntryCollection fIncEntryCol = FiIncomeEntryFactory.getRemoteInstance().getFiIncomeEntryCollection(ev);
		for (int j = 0; j < fIncEntryCol.size(); j++) {
			FiIncomeEntryInfo entryInfo = fIncEntryCol.get(j);
			AdminOrgUnitInfo PWInfo = entryInfo.getPmtProj();
			IRow row = this.kDTable1.addRow();
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// ���ݱ���
			row.getCell("permitOrg").setValue(PWInfo == null ? null : PWInfo.getName());// ֤����Ŀ
			row.getCell("workOrg").setValue(entryInfo.getTaskProj() == null ? null : entryInfo.getTaskProj().getName());// ������Ŀ
			row.getCell("belongOrg").setValue(entryInfo.getPartner() == null ? null : entryInfo.getPartner().getName());// ������Ŀ
			row.getCell("effectDate").setValue(entryInfo.getParent().getAuditDate());// ��������
			row.getCell("remark").setValue(entryInfo.getRemark());// ��ע
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}

	/**
	 * ��ǩҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiAntiSignedKDTableVal(PersonHistoryInfo phInfo)
			throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("parent.number"));
		sic.add(new SelectorItemInfo("pmtProj.name"));
		sic.add(new SelectorItemInfo("taskProj.name"));
		sic.add(new SelectorItemInfo("partner.name"));
		sic.add(new SelectorItemInfo("antiSgTime"));
		sic.add(new SelectorItemInfo("antiEndTime"));
		sic.add(new SelectorItemInfo("remark"));
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passpNo", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
		ev.setFilter(filter);
		ev.setSelector(sic);
		AntiSignedEntryCollection asEntryCol = AntiSignedEntryFactory
				.getRemoteInstance().getAntiSignedEntryCollection(ev);
		for (int i = 0; i < asEntryCol.size(); i++) {
			AntiSignedEntryInfo entryInfo = asEntryCol.get(i);
			IRow row = this.kDTable2.addRow();
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// ���ݱ���
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// ֤����Ŀ
			row.getCell("workOrg").setValue(entryInfo.getTaskProj() == null ? null : entryInfo.getTaskProj().getName());// ������Ŀ
			row.getCell("belongOrg").setValue(entryInfo.getPartner() == null ? null : entryInfo.getPartner().getName());// ������Ŀ
			row.getCell("effectDate").setValue(entryInfo.getAntiSgTime() == null ? null : entryInfo.getAntiSgTime());// ��Ч����
			row.getCell("endDate").setValue(entryInfo.getAntiEndTime());// ��������
			row.getCell("remark").setValue(entryInfo.getRemark());// ��ע
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}

	/**
	 * ˫��֤ҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiDoubQualifyKDTableVal(PersonHistoryInfo phInfo)
			throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passpNo", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
//		filter.setMaskString("#0 OR #1");
		ev.setFilter(filter);
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("parent.number"));
//		sic.add(new SelectorItemInfo("parent.bNum"));
		sic.add(new SelectorItemInfo("pmtProj.name"));
		sic.add(new SelectorItemInfo("taskProj.name"));
		sic.add(new SelectorItemInfo("partner.name"));
		sic.add(new SelectorItemInfo("notaDate"));
		sic.add(new SelectorItemInfo("qualSendDate"));
		sic.add(new SelectorItemInfo("qualDate"));
		sic.add(new SelectorItemInfo("type"));
		sic.add(new SelectorItemInfo("stopRes"));
		sic.add(new SelectorItemInfo("stopTime"));
		sic.add(new SelectorItemInfo("desCription"));
		ev.setSelector(sic);
		DoubQualifyEntryCollection dqCol = DoubQualifyEntryFactory.getRemoteInstance().getDoubQualifyEntryCollection(ev);
		for (int i = 0; i < dqCol.size(); i++) {
			DoubQualifyEntryInfo entryInfo = dqCol.get(i);
			IRow row = this.kDTable3.addRow();
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// ���ݱ���
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getBNum());// ���κ�
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// ֤����Ŀ
			row.getCell("workOrg").setValue(entryInfo.getTaskProj() == null ? null : entryInfo.getTaskProj().getName());// ������Ŀ
			row.getCell("belongOrg").setValue(entryInfo.getPartner() == null ? null : entryInfo.getPartner().getName());// ������Ŀ
			row.getCell("notaryDate").setValue(entryInfo.getNotaDate());// ��֤�������
			row.getCell("qualifystartDate").setValue(entryInfo.getQualSendDate());// ��֤��������
			row.getCell("qualifDoneDate").setValue(entryInfo.getQualDate());// ��֤�������
			row.getCell("Type").setValue(entryInfo.getType());// ˫��֤����
			row.getCell("ceaseReeason").setValue(entryInfo.getStopRes());// ͣ������
			row.getCell("ceaseTime").setValue(entryInfo.getStopTime());// ͣ��ʱ��
			row.getCell("applier").setValue(null);// �ύ��
			row.getCell("applyTime").setValue(null);// �ύʱ��
			row.getCell("remark").setValue(entryInfo.getDesCription());// ��ע
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}

	/**
	 * ǩ֤ҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiVisaHandleKDTableVal(PersonHistoryInfo phInfo)
			throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passpNo", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
//		filter.setMaskString("#0 OR #1");
		ev.setFilter(filter);
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("parent.number"));
		sic.add(new SelectorItemInfo("prmtPro.name"));
		sic.add(new SelectorItemInfo("workPro.name"));
		sic.add(new SelectorItemInfo("partner.name"));
		sic.add(new SelectorItemInfo("vsTime"));
		sic.add(new SelectorItemInfo("veTime"));
		sic.add(new SelectorItemInfo("desCription"));
		ev.setSelector(sic);
		VisaHandleEntryCollection fIncCol = VisaHandleEntryFactory.getRemoteInstance().getVisaHandleEntryCollection(ev);
		for (int i = 0; i < fIncCol.size(); i++) {
			VisaHandleEntryInfo entryInfo = fIncCol.get(i);
			IRow row = this.kDTable4.addRow();
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// ���ݱ���
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getBNum());// ���κ�
			row.getCell("permitOrg").setValue(entryInfo.getPrmtPro()==null?null:entryInfo.getPrmtPro().getName());// ֤����Ŀ
			row.getCell("workOrg").setValue(entryInfo.getWorkPro()==null?null:entryInfo.getWorkPro().getName());// ������Ŀ
			row.getCell("belongOrg").setValue(entryInfo.getPartner() == null ? null : entryInfo.getPartner().getName());// ������Ŀ
			row.getCell("effectDate").setValue(entryInfo.getVsTime());// ��Ч����
			row.getCell("endDate").setValue(entryInfo.getVeTime());// ��������
			row.getCell("remark").setValue(entryInfo.getDesCription());// ��ע
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}

	/**
	 * �뾳����ҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiImmigrationKDTableVal(PersonHistoryInfo phInfo)
			throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
//		filter.setMaskString("#0 OR #1");
		ev.setFilter(filter);
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("parent.number"));
//		sic.add(new SelectorItemInfo("parent.contbNum"));
		sic.add(new SelectorItemInfo("pmtProj.name"));
		sic.add(new SelectorItemInfo("taskProj.name"));
		sic.add(new SelectorItemInfo("partner.name"));
		sic.add(new SelectorItemInfo("apAlgTime"));
		sic.add(new SelectorItemInfo("description"));
		ev.setSelector(sic);
		ImmigrationEntryCollection immgCol = ImmigrationEntryFactory.getRemoteInstance().getImmigrationEntryCollection(ev);
		for (int i = 0; i < immgCol.size(); i++) {
			ImmigrationEntryInfo entryInfo = immgCol.get(i);
			IRow row = this.kDTable5.addRow();
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// ���ݱ���
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getContbNum());// ���κ�
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// ֤����Ŀ
			row.getCell("workOrg").setValue(entryInfo.getTaskProj() == null ? null : entryInfo.getTaskProj().getName());// ������Ŀ
			row.getCell("belongOrg").setValue(entryInfo.getPartner() == null ? null : entryInfo.getPartner().getName());// ������Ŀ
			row.getCell("effectDate").setValue(entryInfo.getApAlgTime());// �뾳����
			row.getCell("remark").setValue(entryInfo.getDescription());// ��ע
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}

	/**
	 * ʹ��ע��ҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiEmbassyRegKDTableVal(PersonHistoryInfo phInfo)
			throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
		ev.setFilter(filter);
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("parent.number"));
//		sic.add(new SelectorItemInfo("parent.bNum"));
		sic.add(new SelectorItemInfo("PmtProj.name"));
		sic.add(new SelectorItemInfo("taskProj.name"));
		sic.add(new SelectorItemInfo("partner.name"));
		sic.add(new SelectorItemInfo("fAlgTime"));
		sic.add(new SelectorItemInfo("desCription"));
		ev.setSelector(sic);
		EmbassyRegEntryCollection fIncCol = EmbassyRegEntryFactory.getRemoteInstance().getEmbassyRegEntryCollection(ev);
		for (int i = 0; i < fIncCol.size(); i++) {
			EmbassyRegEntryInfo entryInfo = fIncCol.get(i);
			IRow row = this.kDTable6.addRow();
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// ���ݱ���
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getBNum());// ���κ�
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj()==null?null:entryInfo.getPmtProj().getName());// ֤����Ŀ
			row.getCell("workOrg").setValue(entryInfo.getTaskProj() == null ? null : entryInfo.getTaskProj().getName());// ������Ŀ
			row.getCell("belongOrg").setValue(entryInfo.getPartner() == null ? null : entryInfo.getPartner().getName());// ������Ŀ
			row.getCell("effectDate").setValue(entryInfo.getFAlgTime());// �뾳����
			row.getCell("remark").setValue(entryInfo.getDesCription());// ��ע
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}

	/**
	 * �Ͷ�֤����ҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiWorkPmtKDTableVal(PersonHistoryInfo phInfo)
			throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
//		filter.setMaskString("#0 OR #1");
		ev.setFilter(filter);
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("parent.number"));
//		sic.add(new SelectorItemInfo("parent.bNum"));
		sic.add(new SelectorItemInfo("pmtProj.name"));
		sic.add(new SelectorItemInfo("workOrg.name"));
		sic.add(new SelectorItemInfo("cooperation.name"));
		sic.add(new SelectorItemInfo("wPmtNum"));
		sic.add(new SelectorItemInfo("wPmtGTime"));
		sic.add(new SelectorItemInfo("wPmtSTime"));
		sic.add(new SelectorItemInfo("remark"));
		ev.setSelector(sic);
		WorkPmtEntryCollection wpCol = WorkPmtEntryFactory.getRemoteInstance().getWorkPmtEntryCollection(ev);
		for (int i = 0; i < wpCol.size(); i++) {
			WorkPmtEntryInfo entryInfo = wpCol.get(i);
			IRow row = this.kDTable7.addRow();
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// ���ݱ���
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getBNum());// ���κ�
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// ֤����Ŀ
			row.getCell("workOrg").setValue(entryInfo.getWorkOrg()==null?null:entryInfo.getWorkOrg().getName());// ������Ŀ
			row.getCell("belongOrg").setValue(entryInfo.getCooperation()==null?null:entryInfo.getCooperation().getName());// ������Ŀ
			row.getCell("permitnumber").setValue(entryInfo.getWPmtNum());// ֤�����
			row.getCell("effectDate").setValue(entryInfo.getWPmtGTime());// ��Ч����
			row.getCell("expireDate").setValue(entryInfo.getWPmtSTime());// ��������
			row.getCell("remark").setValue(entryInfo.getRemark());// ��ע
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}

	/**
	 * ��ס֤����ҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiLivepermitKDTableVal(PersonHistoryInfo phInfo)
			throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
//		filter.setMaskString("#0 OR #1");
		ev.setFilter(filter);
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("parent.number"));
//		sic.add(new SelectorItemInfo("parent.bNum"));
		sic.add(new SelectorItemInfo("pmtProj.name"));
		sic.add(new SelectorItemInfo("workOrg.name"));
		sic.add(new SelectorItemInfo("cooperation.name"));
		sic.add(new SelectorItemInfo("rePmtNum"));
		sic.add(new SelectorItemInfo("sRePmtSTime"));
		sic.add(new SelectorItemInfo("rePmtETime"));
		sic.add(new SelectorItemInfo("remark"));
		ev.setSelector(sic);
		LivepermitEntryCollection lpCol = LivepermitEntryFactory.getRemoteInstance().getLivepermitEntryCollection(ev);
		for (int i = 0; i < lpCol.size(); i++) {
			LivepermitEntryInfo entryInfo = lpCol.get(i);
			IRow row = this.kDTable8.addRow();
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// ���ݱ���
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getBNum());// ���κ�
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// ֤����Ŀ
			row.getCell("workOrg").setValue(entryInfo.getWorkOrg()==null?null:entryInfo.getWorkOrg().getName());// ������Ŀ
			row.getCell("belongOrg").setValue(entryInfo.getCooperation()==null?null:entryInfo.getCooperation().getName());// ������Ŀ
			row.getCell("permitnumber").setValue(entryInfo.getRePmtNum());// ֤�����
			row.getCell("effectDate").setValue(entryInfo.getSRePmtSTime());// ��Ч����
			row.getCell("expireDate").setValue(entryInfo.getRePmtETime());// ��������
			row.getCell("remark").setValue(entryInfo.getRemark());// ��ע
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}

	/**
	 * �뾳ҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiLeaveManageKDTableVal(PersonHistoryInfo phInfo)
			throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
		ev.setFilter(filter);
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("parent.number"));
//		sic.add(new SelectorItemInfo("parent.bNum"));
		sic.add(new SelectorItemInfo("pmtProj.name"));
		sic.add(new SelectorItemInfo("taskProj.name"));
		sic.add(new SelectorItemInfo("cooperation.name"));
		sic.add(new SelectorItemInfo("dptrTime"));
		sic.add(new SelectorItemInfo("remark"));
		ev.setSelector(sic);
		LeaveManageEntryCollection fIncCol = LeaveManageEntryFactory.getRemoteInstance().getLeaveManageEntryCollection(ev);
		for (int i = 0; i < fIncCol.size(); i++) {
			LeaveManageEntryInfo entryInfo = fIncCol.get(i);
			IRow row = this.kDTable9.addRow();
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// ���ݱ���
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getBNum());// ���κ�
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj()==null?null:entryInfo.getPmtProj().getName());// ֤����Ŀ
			row.getCell("workOrg").setValue(entryInfo.getTaskProj() == null ? null : entryInfo.getTaskProj().getName());// ������Ŀ
			row.getCell("belongOrg").setValue(entryInfo.getCooperation()==null?null:entryInfo.getCooperation().getName());// ������Ŀ
			row.getCell("effectDate").setValue(entryInfo.getDptrTime());// �뾳ʱ��
			row.getCell("remark").setValue(entryInfo.getRemark());// ��ע
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}

	/**
	 * �Ͷ�֤����ҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiWorkPmtUpdateKDTableVal(PersonHistoryInfo phInfo)throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("papSTime"));
		sic.add(new SelectorItemInfo("HpapSTime"));
		sic.add(new SelectorItemInfo("wPmtGTime"));
		sic.add(new SelectorItemInfo("HwPmtGTime"));
		sic.add(new SelectorItemInfo("wPmtNum"));
		sic.add(new SelectorItemInfo("HwPmtNum"));
		sic.add(new SelectorItemInfo("wPmtSTime"));
		sic.add(new SelectorItemInfo("HwPmtSTime"));
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
//		filter.setMaskString("#0 OR #1");
		ev.setFilter(filter);
		ev.setSelector(sic);
		WkPmtUpdtEntryCollection fIncEntryCol = WkPmtUpdtEntryFactory.getRemoteInstance().getWkPmtUpdtEntryCollection(ev);
		for (int j = 0; j < fIncEntryCol.size(); j++) {
			WkPmtUpdtEntryInfo entryInfo = fIncEntryCol.get(j);
			IRow row = this.kDTable11.addRow();
			row.getCell("papSTime").setValue(entryInfo.getPapSTime());// �ݽ���������
			row.getCell("HpapSTime").setValue(entryInfo.getHpapSTime());// ԭ�ݽ���������
			row.getCell("wPmtGTime").setValue(entryInfo.getWPmtGTime());// �Ͷ�֤��֤����
			row.getCell("HwPmtGTime").setValue(entryInfo.getHwPmtGTime());// ԭ�Ͷ�֤��֤����
			row.getCell("wPmtNum").setValue(entryInfo.getWPmtNum());// �Ͷ�֤����
			row.getCell("HwPmtNum").setValue(entryInfo.getHwPmtNum());// ԭ�Ͷ�֤����
			row.getCell("wPmtSTime").setValue(entryInfo.getWPmtSTime());// �Ͷ�֤������
			row.getCell("hWPmtSTime").setValue(entryInfo.getHWPmtSTime());// ԭ�Ͷ�֤������
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}
	
	/**
	 * �Ͷ�֤��תҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiWorkPmtChangeKDTableVal(PersonHistoryInfo phInfo)throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("pmtProj.name"));
		sic.add(new SelectorItemInfo("HpmtProj.name"));
		sic.add(new SelectorItemInfo("workOrg.name"));
		sic.add(new SelectorItemInfo("HworkOrg.name"));
		sic.add(new SelectorItemInfo("quProf.name"));
		sic.add(new SelectorItemInfo("HquProf.name"));
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
//		filter.setMaskString("#0 OR #1");
		ev.setFilter(filter);
		ev.setSelector(sic);
		WkPmtTrnEntryCollection fIncEntryCol = WkPmtTrnEntryFactory.getRemoteInstance().getWkPmtTrnEntryCollection(ev);
		for (int j = 0; j < fIncEntryCol.size(); j++) {
			WkPmtTrnEntryInfo entryInfo = fIncEntryCol.get(j);
			IRow row = this.kDTable10.addRow();
			row.getCell("pmtProj").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// ָ����Ŀ
			row.getCell("HpmtProj").setValue(entryInfo.getHpmtProj() == null ? null : entryInfo.getHpmtProj().getName());// ԭָ����Ŀ
			row.getCell("workOrg").setValue(entryInfo.getWorkOrg() == null ? null : entryInfo.getWorkOrg().getName());// ������Ŀ
			row.getCell("HworkOrg").setValue(entryInfo.getHworkOrj() == null ? null : entryInfo.getHworkOrj().getName());// ԭ������Ŀ
			row.getCell("quProf").setValue(entryInfo.getQuProf() == null ? null : entryInfo.getQuProf().getName());// ָ�깤��
			row.getCell("HquProf").setValue(entryInfo.getHQuProf() == null ? null : entryInfo.getHQuProf().getName());// ԭָ�깤��
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}
	
	/**
	 * ��ס֤����ҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiLivepermitUpdateKDTableVal(PersonHistoryInfo phInfo)throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("rePmtETime"));
		sic.add(new SelectorItemInfo("HrePmtETime"));
		sic.add(new SelectorItemInfo("sRePmtSTime"));
		sic.add(new SelectorItemInfo("HsRePmtSTime"));
		sic.add(new SelectorItemInfo("pmtETime"));
		sic.add(new SelectorItemInfo("HpmtETime"));
		sic.add(new SelectorItemInfo("papSTime"));
		sic.add(new SelectorItemInfo("HpapSTime"));
		sic.add(new SelectorItemInfo("pmtNum"));
		sic.add(new SelectorItemInfo("HpmtNum"));
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
//		filter.setMaskString("#0 OR #1");
		ev.setFilter(filter);
		ev.setSelector(sic);
		UplivePermitEntryCollection fIncEntryCol = UplivePermitEntryFactory.getRemoteInstance().getUplivePermitEntryCollection(ev);
		for (int j = 0; j < fIncEntryCol.size(); j++) {
			UplivePermitEntryInfo entryInfo = fIncEntryCol.get(j);
			IRow row = this.kDTable13.addRow();
			row.getCell("rePmtETime").setValue(entryInfo.getRePmtETime());// �ݽ���������
			row.getCell("HrePmtETime").setValue(entryInfo.getHrePmtETime());// ԭ�ݽ���������
			row.getCell("sRePmtSTime").setValue(entryInfo.getSRePmtSTime());// �Ͷ�֤��֤����
			row.getCell("HsRePmtSTime").setValue(entryInfo.getHsRePmtSTime());// ԭ�Ͷ�֤��֤����
			row.getCell("pmtETime").setValue(entryInfo.getPmtETime());// �Ͷ�֤����
			row.getCell("HpmtETime").setValue(entryInfo.getHpmtETime());// ԭ�Ͷ�֤����
			row.getCell("papSTime").setValue(entryInfo.getPapSTime());// �Ͷ�֤������
			row.getCell("HpapSTime").setValue(entryInfo.getHpapSTime());// ԭ�Ͷ�֤������
			row.getCell("pmtNum").setValue(entryInfo.getPmtNum());// ��ʽ��ס֤����
			row.getCell("HpmtNum").setValue(entryInfo.getHpmtNum());// ԭ��ʽ��ס֤����
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}
	
	/**
	 * ��ס֤��תҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiLivepermitChangeKDTableVal(PersonHistoryInfo phInfo)throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("id"));
		sic.add(new SelectorItemInfo("pmtProj.name"));
		sic.add(new SelectorItemInfo("HpmtProj.name"));
		sic.add(new SelectorItemInfo("workProj.name"));
		sic.add(new SelectorItemInfo("HworkProj.name"));
		sic.add(new SelectorItemInfo("quProf.name"));
		sic.add(new SelectorItemInfo("HquProf.name"));
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passpNum", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
//		filter.setMaskString("#0 OR #1");
		ev.setFilter(filter);
		ev.setSelector(sic);
		ExLivepermitEntryCollection fIncEntryCol = ExLivepermitEntryFactory.getRemoteInstance().getExLivepermitEntryCollection(ev);
		for (int j = 0; j < fIncEntryCol.size(); j++) {
			ExLivepermitEntryInfo entryInfo = fIncEntryCol.get(j);
			IRow row = this.kDTable14.addRow();
			row.getCell("pmtProj").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// ָ����Ŀ
			row.getCell("HpmtProj").setValue(entryInfo.getHpmtProj() == null ? null : entryInfo.getHpmtProj().getName());// ԭָ����Ŀ
			row.getCell("workOrg").setValue(entryInfo.getWorkOrg() == null ? null : entryInfo.getWorkOrg().getName());// ������Ŀ
			row.getCell("HworkOrg").setValue(entryInfo.getHworkOrg() == null ? null : entryInfo.getHworkOrg().getName());// ԭ������Ŀ
			row.getCell("quProf").setValue(entryInfo.getQuProf() == null ? null : entryInfo.getQuProf().getName());// ָ�깤��
			row.getCell("HquProf").setValue(entryInfo.getHquProf() == null ? null : entryInfo.getHquProf().getName());// ԭָ�깤��
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}
	
	/**
	 * ����ǩ��Ϣ¼��ҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiWorkVisaKDTableVal(PersonHistoryInfo phInfo)throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("name"));
		sic.add(new SelectorItemInfo("sex"));
		sic.add(new SelectorItemInfo("birthdate"));
		sic.add(new SelectorItemInfo("national.name"));
		sic.add(new SelectorItemInfo("idNum"));
		sic.add(new SelectorItemInfo("acProf"));
		sic.add(new SelectorItemInfo("pmtProfC"));
		sic.add(new SelectorItemInfo("workProgram.name"));
		sic.add(new SelectorItemInfo("permitProgram.name"));
		sic.add(new SelectorItemInfo("cooperation.name"));
		sic.add(new SelectorItemInfo("passportNo"));
		sic.add(new SelectorItemInfo("passportAgency"));
		sic.add(new SelectorItemInfo("score"));
		sic.add(new SelectorItemInfo("oldPassport"));
		sic.add(new SelectorItemInfo("id"));
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passportNo", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
//		filter.setMaskString("#0 OR #1");
		ev.setFilter(filter);
		ev.setSelector(sic);
		WorkVisaEntryCollection fIncEntryCol = WorkVisaEntryFactory.getRemoteInstance().getWorkVisaEntryCollection(ev);
		for (int j = 0; j < fIncEntryCol.size(); j++) {
			WorkVisaEntryInfo entryInfo = fIncEntryCol.get(j);
			IRow row = this.kDTable12.addRow();
			row.getCell("name").setValue(entryInfo.getName());// ָ����Ŀ
			row.getCell("sex").setValue(entryInfo.getSex());// ԭָ����Ŀ
			row.getCell("birthdate").setValue(entryInfo.getBirthdate());// ������Ŀ
			row.getCell("nation").setValue(entryInfo.getNational()==null?null:entryInfo.getNational().getName().toString());// ԭ������Ŀ
			row.getCell("idNum").setValue(entryInfo.getIdNum());// ָ�깤��
			row.getCell("acProf").setValue(entryInfo.getAcProf());// ԭָ�깤��
			row.getCell("pmtProfC").setValue(entryInfo.getPmtProfC() == null ? null : entryInfo.getPmtProfC().getName());// ��¼ID
			row.getCell("workProgram").setValue(entryInfo.getWorkProgram() == null ? null : entryInfo.getWorkProgram().getName());// ָ����Ŀ
			row.getCell("permitProgram").setValue(entryInfo.getPermitProgram() == null ? null : entryInfo.getPermitProgram().getName());// ԭָ����Ŀ
			row.getCell("cooperation").setValue(entryInfo.getCooperation() == null ? null : entryInfo.getCooperation().getName());// ������Ŀ
			row.getCell("passportNo").setValue(entryInfo.getPassportNo());// ԭ������Ŀ
			row.getCell("passportAgency").setValue(entryInfo.getPassportAgency());// ָ�깤��
			row.getCell("score").setValue(entryInfo.getScore());// ԭָ�깤��
			row.getCell("oldPassport").setValue(entryInfo.getOldPassport());// ��¼ID
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}
	
	
	/**
	 * ����ǩ��Ϣ¼��ҳǩ��ȡ�����ֶ�ֵ
	 */
	private void intiBusVisaKDTableVal(PersonHistoryInfo phInfo)throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("name"));
		sic.add(new SelectorItemInfo("sex"));
		sic.add(new SelectorItemInfo("idNum"));
		sic.add(new SelectorItemInfo("national"));
		sic.add(new SelectorItemInfo("passportNo"));
		sic.add(new SelectorItemInfo("passportIssueDate"));
		sic.add(new SelectorItemInfo("passportExpireDate"));
		sic.add(new SelectorItemInfo("cooperation.name"));
		sic.add(new SelectorItemInfo("handleProject.name"));
		sic.add(new SelectorItemInfo("workProgram.name"));
		sic.add(new SelectorItemInfo("id"));
		FilterInfo filter = new FilterInfo();
		CountryInfo coInfo=phInfo.getNation();
		if(coInfo!=null && "C01".equals(coInfo.getNumber())){
			filter.getFilterItems().add(new FilterItemInfo("idNum", phInfo.getIdNum()));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("passportNo", phInfo.getPassportNo()));
		}
		EntityViewInfo ev = new EntityViewInfo();
		ev.setFilter(filter);
		ev.setSelector(sic);
		BusinessVisaEntryCollection fIncEntryCol = BusinessVisaEntryFactory.getRemoteInstance().getBusinessVisaEntryCollection(ev);
		for (int j = 0; j < fIncEntryCol.size(); j++) {
			BusinessVisaEntryInfo entryInfo = fIncEntryCol.get(j);
			IRow row = this.kDTable15.addRow();
			row.getCell("name").setValue(entryInfo.getName());// ָ����Ŀ
			row.getCell("sex").setValue(entryInfo.getSex());// ԭָ����Ŀ
			row.getCell("idNum").setValue(entryInfo.getBirthdate());// ������Ŀ
			row.getCell("nation").setValue(entryInfo.getNational());// ԭ������Ŀ
			row.getCell("passportNo").setValue(entryInfo.getPassportNo());// ָ�깤��
			row.getCell("passportIssueDate").setValue(entryInfo.getPassportIssueDate());// ԭָ�깤��
			row.getCell("passportExpireDate").setValue(entryInfo.getPassportExpireDate());// ��¼ID
			row.getCell("cooperation").setValue(entryInfo.getCooperation() == null ? null : entryInfo.getCooperation().getName());// ������Ŀ
			row.getCell("handleProject").setValue(entryInfo.getHandleProject() == null ? null : entryInfo.getHandleProject().getName());// ԭ������Ŀ
			row.getCell("workProgram").setValue(entryInfo.getWorkProgram() == null ? null : entryInfo.getWorkProgram().getName());// ָ�깤��
			row.getCell("id").setValue(entryInfo.getId());// ��¼ID
		}
	}
	/**
	 * output class constructor
	 */
	public PersonHistoryEditUI() throws Exception {
		super();
	}

	/**
	 * output loadFields method
	 */
	public void loadFields() {
		super.loadFields();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();
	}

	// protected void prmtrealProf_dataChanged(DataChangeEvent e) throws
	// Exception {
	// super.prmtrealProf_dataChanged(e);
	// }
	/**
	 * output btnAddLine_actionPerformed method
	 */
	protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e)
			throws Exception {
		super.btnAddLine_actionPerformed(e);
	}

	/**
	 * output menuItemEnterToNextRow_itemStateChanged method
	 */
	protected void menuItemEnterToNextRow_itemStateChanged(
			java.awt.event.ItemEvent e) throws Exception {
		super.menuItemEnterToNextRow_itemStateChanged(e);
	}

	/**
	 * output actionPageSetup_actionPerformed
	 */
	public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception {
		super.actionPageSetup_actionPerformed(e);
	}

	/**
	 * output actionExitCurrent_actionPerformed
	 */
	public void actionExitCurrent_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExitCurrent_actionPerformed(e);
	}

	/**
	 * output actionHelp_actionPerformed
	 */
	public void actionHelp_actionPerformed(ActionEvent e) throws Exception {
		super.actionHelp_actionPerformed(e);
	}

	/**
	 * output actionAbout_actionPerformed
	 */
	public void actionAbout_actionPerformed(ActionEvent e) throws Exception {
		super.actionAbout_actionPerformed(e);
	}

	/**
	 * output actionOnLoad_actionPerformed
	 */
	public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception {
		super.actionOnLoad_actionPerformed(e);
	}

	/**
	 * output actionSendMessage_actionPerformed
	 */
	public void actionSendMessage_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionSendMessage_actionPerformed(e);
	}

	/**
	 * output actionCalculator_actionPerformed
	 */
	public void actionCalculator_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionCalculator_actionPerformed(e);
	}

	/**
	 * output actionExport_actionPerformed
	 */
	public void actionExport_actionPerformed(ActionEvent e) throws Exception {
		super.actionExport_actionPerformed(e);
	}

	/**
	 * output actionExportSelected_actionPerformed
	 */
	public void actionExportSelected_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExportSelected_actionPerformed(e);
	}

	/**
	 * output actionRegProduct_actionPerformed
	 */
	public void actionRegProduct_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionRegProduct_actionPerformed(e);
	}

	/**
	 * output actionPersonalSite_actionPerformed
	 */
	public void actionPersonalSite_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionPersonalSite_actionPerformed(e);
	}

	/**
	 * output actionProcductVal_actionPerformed
	 */
	public void actionProcductVal_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionProcductVal_actionPerformed(e);
	}

	/**
	 * output actionExportSave_actionPerformed
	 */
	public void actionExportSave_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExportSave_actionPerformed(e);
	}

	/**
	 * output actionExportSelectedSave_actionPerformed
	 */
	public void actionExportSelectedSave_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExportSelectedSave_actionPerformed(e);
	}

	/**
	 * output actionKnowStore_actionPerformed
	 */
	public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception {
		super.actionKnowStore_actionPerformed(e);
	}

	/**
	 * output actionAnswer_actionPerformed
	 */
	public void actionAnswer_actionPerformed(ActionEvent e) throws Exception {
		super.actionAnswer_actionPerformed(e);
	}

	/**
	 * output actionRemoteAssist_actionPerformed
	 */
	public void actionRemoteAssist_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionRemoteAssist_actionPerformed(e);
	}

	/**
	 * output actionPopupCopy_actionPerformed
	 */
	public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception {
		super.actionPopupCopy_actionPerformed(e);
	}

	/**
	 * output actionHTMLForMail_actionPerformed
	 */
	public void actionHTMLForMail_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionHTMLForMail_actionPerformed(e);
	}

	/**
	 * output actionExcelForMail_actionPerformed
	 */
	public void actionExcelForMail_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExcelForMail_actionPerformed(e);
	}

	/**
	 * output actionHTMLForRpt_actionPerformed
	 */
	public void actionHTMLForRpt_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionHTMLForRpt_actionPerformed(e);
	}

	/**
	 * output actionExcelForRpt_actionPerformed
	 */
	public void actionExcelForRpt_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExcelForRpt_actionPerformed(e);
	}

	/**
	 * output actionLinkForRpt_actionPerformed
	 */
	public void actionLinkForRpt_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionLinkForRpt_actionPerformed(e);
	}

	/**
	 * output actionPopupPaste_actionPerformed
	 */
	public void actionPopupPaste_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionPopupPaste_actionPerformed(e);
	}

	/**
	 * output actionToolBarCustom_actionPerformed
	 */
	public void actionToolBarCustom_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionToolBarCustom_actionPerformed(e);
	}

	/**
	 * output actionCloudFeed_actionPerformed
	 */
	public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception {
		super.actionCloudFeed_actionPerformed(e);
	}

	/**
	 * output actionCloudShare_actionPerformed
	 */
	public void actionCloudShare_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionCloudShare_actionPerformed(e);
	}

	/**
	 * output actionCloudScreen_actionPerformed
	 */
	public void actionCloudScreen_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionCloudScreen_actionPerformed(e);
	}

	/**
	 * output actionXunTongFeed_actionPerformed
	 */
	public void actionXunTongFeed_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionXunTongFeed_actionPerformed(e);
	}

	/**
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		super.actionSave_actionPerformed(e);
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
	}

	/**
	 * output actionCancel_actionPerformed
	 */
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		super.actionCancel_actionPerformed(e);
	}

	/**
	 * output actionCancelCancel_actionPerformed
	 */
	public void actionCancelCancel_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionCancelCancel_actionPerformed(e);
	}

	/**
	 * output actionFirst_actionPerformed
	 */
	public void actionFirst_actionPerformed(ActionEvent e) throws Exception {
		super.actionFirst_actionPerformed(e);
	}

	/**
	 * output actionPre_actionPerformed
	 */
	public void actionPre_actionPerformed(ActionEvent e) throws Exception {
		super.actionPre_actionPerformed(e);
	}

	/**
	 * output actionNext_actionPerformed
	 */
	public void actionNext_actionPerformed(ActionEvent e) throws Exception {
		super.actionNext_actionPerformed(e);
	}

	/**
	 * output actionLast_actionPerformed
	 */
	public void actionLast_actionPerformed(ActionEvent e) throws Exception {
		super.actionLast_actionPerformed(e);
	}

	/**
	 * output actionPrint_actionPerformed
	 */
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		super.actionPrint_actionPerformed(e);
	}

	/**
	 * output actionPrintPreview_actionPerformed
	 */
	public void actionPrintPreview_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionPrintPreview_actionPerformed(e);
	}

	/**
	 * output actionCopy_actionPerformed
	 */
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		super.actionCopy_actionPerformed(e);
	}

	/**
	 * output actionAddNew_actionPerformed
	 */
	public void actionAddNew_actionPerformed(ActionEvent e) throws Exception {
		super.actionAddNew_actionPerformed(e);
	}

	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		super.actionEdit_actionPerformed(e);
	}

	/**
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		super.actionRemove_actionPerformed(e);
	}

	/**
	 * output actionAttachment_actionPerformed
	 */
	public void actionAttachment_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionAttachment_actionPerformed(e);
	}

	/**
	 * output actionSubmitOption_actionPerformed
	 */
	public void actionSubmitOption_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionSubmitOption_actionPerformed(e);
	}

	/**
	 * output actionReset_actionPerformed
	 */
	public void actionReset_actionPerformed(ActionEvent e) throws Exception {
		super.actionReset_actionPerformed(e);
	}

	/**
	 * output actionMsgFormat_actionPerformed
	 */
	public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception {
		super.actionMsgFormat_actionPerformed(e);
	}

	/**
	 * output actionAddLine_actionPerformed
	 */
	public void actionAddLine_actionPerformed(ActionEvent e) throws Exception {
		super.actionAddLine_actionPerformed(e);
	}

	/**
	 * output actionCopyLine_actionPerformed
	 */
	public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception {
		super.actionCopyLine_actionPerformed(e);
	}

	/**
	 * output actionInsertLine_actionPerformed
	 */
	public void actionInsertLine_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionInsertLine_actionPerformed(e);
	}

	/**
	 * output actionRemoveLine_actionPerformed
	 */
	public void actionRemoveLine_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionRemoveLine_actionPerformed(e);
	}

	/**
	 * output actionCreateFrom_actionPerformed
	 */
	public void actionCreateFrom_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionCreateFrom_actionPerformed(e);
	}

	/**
	 * output actionCopyFrom_actionPerformed
	 */
	public void actionCopyFrom_actionPerformed(ActionEvent e) throws Exception {
		super.actionCopyFrom_actionPerformed(e);
	}

	/**
	 * output actionAuditResult_actionPerformed
	 */
	public void actionAuditResult_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionAuditResult_actionPerformed(e);
	}

	/**
	 * output actionTraceUp_actionPerformed
	 */
	public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception {
		super.actionTraceUp_actionPerformed(e);
	}

	/**
	 * output actionTraceDown_actionPerformed
	 */
	public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception {
		super.actionTraceDown_actionPerformed(e);
	}

	/**
	 * output actionViewSubmitProccess_actionPerformed
	 */
	public void actionViewSubmitProccess_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionViewSubmitProccess_actionPerformed(e);
	}

	/**
	 * output actionViewDoProccess_actionPerformed
	 */
	public void actionViewDoProccess_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionViewDoProccess_actionPerformed(e);
	}

	/**
	 * output actionMultiapprove_actionPerformed
	 */
	public void actionMultiapprove_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionMultiapprove_actionPerformed(e);
	}

	/**
	 * output actionNextPerson_actionPerformed
	 */
	public void actionNextPerson_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionNextPerson_actionPerformed(e);
	}

	/**
	 * output actionStartWorkFlow_actionPerformed
	 */
	public void actionStartWorkFlow_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionStartWorkFlow_actionPerformed(e);
	}

	/**
	 * output actionVoucher_actionPerformed
	 */
	public void actionVoucher_actionPerformed(ActionEvent e) throws Exception {
		super.actionVoucher_actionPerformed(e);
	}

	/**
	 * output actionDelVoucher_actionPerformed
	 */
	public void actionDelVoucher_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionDelVoucher_actionPerformed(e);
	}

	/**
	 * output actionWorkFlowG_actionPerformed
	 */
	public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception {
		super.actionWorkFlowG_actionPerformed(e);
	}

	/**
	 * output actionCreateTo_actionPerformed
	 */
	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
		super.actionCreateTo_actionPerformed(e);
	}

	/**
	 * output actionSendingMessage_actionPerformed
	 */
	public void actionSendingMessage_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionSendingMessage_actionPerformed(e);
	}

	/**
	 * output actionSignature_actionPerformed
	 */
	public void actionSignature_actionPerformed(ActionEvent e) throws Exception {
		super.actionSignature_actionPerformed(e);
	}

	/**
	 * output actionWorkflowList_actionPerformed
	 */
	public void actionWorkflowList_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionWorkflowList_actionPerformed(e);
	}

	/**
	 * output actionViewSignature_actionPerformed
	 */
	public void actionViewSignature_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionViewSignature_actionPerformed(e);
	}

	/**
	 * output actionSendMail_actionPerformed
	 */
	public void actionSendMail_actionPerformed(ActionEvent e) throws Exception {
		super.actionSendMail_actionPerformed(e);
	}

	/**
	 * output actionLocate_actionPerformed
	 */
	public void actionLocate_actionPerformed(ActionEvent e) throws Exception {
		super.actionLocate_actionPerformed(e);
	}

	/**
	 * output actionNumberSign_actionPerformed
	 */
	public void actionNumberSign_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionNumberSign_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface()
			throws Exception {
		return com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory
				.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table) {

		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData() {
		com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo objectValue = new com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo();
		objectValue
				.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext
						.getSysContext().getCurrentUser()));

		return objectValue;
	}

}