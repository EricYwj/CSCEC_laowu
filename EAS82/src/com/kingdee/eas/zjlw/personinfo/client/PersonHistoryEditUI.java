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
	 * 初始化页签表格
	 * 
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void intiKDTableVal() throws BOSException, EASBizException {
		PersonHistoryInfo phInfo = this.editData;
		if(visaTypeEnum.work.equals(phInfo.getVisaType())){
			intiFIncKDTableVal(phInfo);// 工种分配
			intiAntiSignedKDTableVal(phInfo);// 反签页签
			intiDoubQualifyKDTableVal(phInfo);// 双认证
			intiVisaHandleKDTableVal(phInfo);// 签证
			intiImmigrationKDTableVal(phInfo);// 入境管理
			intiEmbassyRegKDTableVal(phInfo);// 使馆注册
			intiWorkPmtKDTableVal(phInfo);// 劳动证办理
			intiLivepermitKDTableVal(phInfo);// 居住证办理
			intiLeaveManageKDTableVal(phInfo);// 离境
			intiWorkPmtUpdateKDTableVal(phInfo);// 劳动证更新
			intiWorkPmtChangeKDTableVal(phInfo);// 劳动证调转
			intiLivepermitUpdateKDTableVal(phInfo);// 居住证更新
			intiLivepermitChangeKDTableVal(phInfo);// 居住证调转
			intiWorkVisaKDTableVal(phInfo);//工作签信息录入
		}else if(visaTypeEnum.buss.equals(phInfo.getVisaType())){
			intiBusVisaKDTableVal(phInfo);//商务签
		}
		intiAttachmentTableVal(phInfo);//附件信息
		
		
	}
	/**
	 * 附件信息页签获取数据
	 */
	private void intiAttachmentTableVal(PersonHistoryInfo phInfo)
	throws BOSException, EASBizException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add(new SelectorItemInfo("name"));
		sic.add(new SelectorItemInfo("idNum"));
		sic.add(new SelectorItemInfo("id"));
		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		//根据人员业务状态查询不同单据数据
		perBizStateEnum perState = phInfo.getBsnisState();
		CountryInfo coInfo=phInfo.getNation();
		if(perBizStateEnum.MESSINPUT.equals(perState)){//信息录入
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
		}else if(perBizStateEnum.INDEXALLOT.equals(perState)){//指标分配
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
			//反签办理、反签停办并注销、反签未办
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
		}else if(perBizStateEnum.VISA.equals(perState)){//签证办理
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
		}else if(perBizStateEnum.IMMIGRATION.equals(perState)){//申请入境
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
		}else if(perBizStateEnum.IMMIGRATIONOUT.equals(perState)){//违规入境
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
		}else if(perBizStateEnum.PASSPORTISSUED.equals(perState)){//发放护照
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
		}else if(perBizStateEnum.WORKPERMIT.equals(perState)){//劳动证
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
		}else if(perBizStateEnum.RESIDENCE.equals(perState)){//居住证
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
		}else if(perBizStateEnum.APPLEAVE.equals(perState)){//申请离境
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
		}else if(perBizStateEnum.DEPARTURE.equals(perState)){//已离境
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
			//反签过期、签证过期、签证停办并注销、入境停办、护照发放停办状态查反签注销单据数据
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
	 * 工种分配页签获取单据字段值
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
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// 单据编码
			row.getCell("permitOrg").setValue(PWInfo == null ? null : PWInfo.getName());// 证件项目
			row.getCell("workOrg").setValue(entryInfo.getTaskProj() == null ? null : entryInfo.getTaskProj().getName());// 工作项目
			row.getCell("belongOrg").setValue(entryInfo.getPartner() == null ? null : entryInfo.getPartner().getName());// 所属项目
			row.getCell("effectDate").setValue(entryInfo.getParent().getAuditDate());// 分配日期
			row.getCell("remark").setValue(entryInfo.getRemark());// 备注
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}

	/**
	 * 反签页签获取单据字段值
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
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// 单据编码
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// 证件项目
			row.getCell("workOrg").setValue(entryInfo.getTaskProj() == null ? null : entryInfo.getTaskProj().getName());// 工作项目
			row.getCell("belongOrg").setValue(entryInfo.getPartner() == null ? null : entryInfo.getPartner().getName());// 所属项目
			row.getCell("effectDate").setValue(entryInfo.getAntiSgTime() == null ? null : entryInfo.getAntiSgTime());// 生效日期
			row.getCell("endDate").setValue(entryInfo.getAntiEndTime());// 到期日期
			row.getCell("remark").setValue(entryInfo.getRemark());// 备注
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}

	/**
	 * 双认证页签获取单据字段值
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
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// 单据编码
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getBNum());// 批次号
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// 证件项目
			row.getCell("workOrg").setValue(entryInfo.getTaskProj() == null ? null : entryInfo.getTaskProj().getName());// 工作项目
			row.getCell("belongOrg").setValue(entryInfo.getPartner() == null ? null : entryInfo.getPartner().getName());// 所属项目
			row.getCell("notaryDate").setValue(entryInfo.getNotaDate());// 公证完成日期
			row.getCell("qualifystartDate").setValue(entryInfo.getQualSendDate());// 认证递送日期
			row.getCell("qualifDoneDate").setValue(entryInfo.getQualDate());// 认证完成日期
			row.getCell("Type").setValue(entryInfo.getType());// 双认证类型
			row.getCell("ceaseReeason").setValue(entryInfo.getStopRes());// 停办理由
			row.getCell("ceaseTime").setValue(entryInfo.getStopTime());// 停办时间
			row.getCell("applier").setValue(null);// 提交人
			row.getCell("applyTime").setValue(null);// 提交时间
			row.getCell("remark").setValue(entryInfo.getDesCription());// 备注
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}

	/**
	 * 签证页签获取单据字段值
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
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// 单据编码
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getBNum());// 批次号
			row.getCell("permitOrg").setValue(entryInfo.getPrmtPro()==null?null:entryInfo.getPrmtPro().getName());// 证件项目
			row.getCell("workOrg").setValue(entryInfo.getWorkPro()==null?null:entryInfo.getWorkPro().getName());// 工作项目
			row.getCell("belongOrg").setValue(entryInfo.getPartner() == null ? null : entryInfo.getPartner().getName());// 所属项目
			row.getCell("effectDate").setValue(entryInfo.getVsTime());// 生效日期
			row.getCell("endDate").setValue(entryInfo.getVeTime());// 到期日期
			row.getCell("remark").setValue(entryInfo.getDesCription());// 备注
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}

	/**
	 * 入境管理页签获取单据字段值
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
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// 单据编码
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getContbNum());// 批次号
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// 证件项目
			row.getCell("workOrg").setValue(entryInfo.getTaskProj() == null ? null : entryInfo.getTaskProj().getName());// 工作项目
			row.getCell("belongOrg").setValue(entryInfo.getPartner() == null ? null : entryInfo.getPartner().getName());// 所属项目
			row.getCell("effectDate").setValue(entryInfo.getApAlgTime());// 入境日期
			row.getCell("remark").setValue(entryInfo.getDescription());// 备注
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}

	/**
	 * 使馆注册页签获取单据字段值
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
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// 单据编码
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getBNum());// 批次号
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj()==null?null:entryInfo.getPmtProj().getName());// 证件项目
			row.getCell("workOrg").setValue(entryInfo.getTaskProj() == null ? null : entryInfo.getTaskProj().getName());// 工作项目
			row.getCell("belongOrg").setValue(entryInfo.getPartner() == null ? null : entryInfo.getPartner().getName());// 所属项目
			row.getCell("effectDate").setValue(entryInfo.getFAlgTime());// 入境日期
			row.getCell("remark").setValue(entryInfo.getDesCription());// 备注
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}

	/**
	 * 劳动证办理页签获取单据字段值
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
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// 单据编码
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getBNum());// 批次号
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// 证件项目
			row.getCell("workOrg").setValue(entryInfo.getWorkOrg()==null?null:entryInfo.getWorkOrg().getName());// 工作项目
			row.getCell("belongOrg").setValue(entryInfo.getCooperation()==null?null:entryInfo.getCooperation().getName());// 所属项目
			row.getCell("permitnumber").setValue(entryInfo.getWPmtNum());// 证件编号
			row.getCell("effectDate").setValue(entryInfo.getWPmtGTime());// 生效日期
			row.getCell("expireDate").setValue(entryInfo.getWPmtSTime());// 到期日期
			row.getCell("remark").setValue(entryInfo.getRemark());// 备注
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}

	/**
	 * 居住证办理页签获取单据字段值
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
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// 单据编码
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getBNum());// 批次号
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// 证件项目
			row.getCell("workOrg").setValue(entryInfo.getWorkOrg()==null?null:entryInfo.getWorkOrg().getName());// 工作项目
			row.getCell("belongOrg").setValue(entryInfo.getCooperation()==null?null:entryInfo.getCooperation().getName());// 所属项目
			row.getCell("permitnumber").setValue(entryInfo.getRePmtNum());// 证件编号
			row.getCell("effectDate").setValue(entryInfo.getSRePmtSTime());// 生效日期
			row.getCell("expireDate").setValue(entryInfo.getRePmtETime());// 到期日期
			row.getCell("remark").setValue(entryInfo.getRemark());// 备注
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}

	/**
	 * 离境页签获取单据字段值
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
			row.getCell("number").setValue(entryInfo.getParent().getNumber());// 单据编码
//			row.getCell("batchNumber").setValue(entryInfo.getParent().getBNum());// 批次号
			row.getCell("permitOrg").setValue(entryInfo.getPmtProj()==null?null:entryInfo.getPmtProj().getName());// 证件项目
			row.getCell("workOrg").setValue(entryInfo.getTaskProj() == null ? null : entryInfo.getTaskProj().getName());// 工作项目
			row.getCell("belongOrg").setValue(entryInfo.getCooperation()==null?null:entryInfo.getCooperation().getName());// 所属项目
			row.getCell("effectDate").setValue(entryInfo.getDptrTime());// 离境时间
			row.getCell("remark").setValue(entryInfo.getRemark());// 备注
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}

	/**
	 * 劳动证更新页签获取单据字段值
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
			row.getCell("papSTime").setValue(entryInfo.getPapSTime());// 递交资料日期
			row.getCell("HpapSTime").setValue(entryInfo.getHpapSTime());// 原递交资料日期
			row.getCell("wPmtGTime").setValue(entryInfo.getWPmtGTime());// 劳动证出证日期
			row.getCell("HwPmtGTime").setValue(entryInfo.getHwPmtGTime());// 原劳动证出证日期
			row.getCell("wPmtNum").setValue(entryInfo.getWPmtNum());// 劳动证号码
			row.getCell("HwPmtNum").setValue(entryInfo.getHwPmtNum());// 原劳动证号码
			row.getCell("wPmtSTime").setValue(entryInfo.getWPmtSTime());// 劳动证到期日
			row.getCell("hWPmtSTime").setValue(entryInfo.getHWPmtSTime());// 原劳动证到期日
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}
	
	/**
	 * 劳动证调转页签获取单据字段值
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
			row.getCell("pmtProj").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// 指标项目
			row.getCell("HpmtProj").setValue(entryInfo.getHpmtProj() == null ? null : entryInfo.getHpmtProj().getName());// 原指标项目
			row.getCell("workOrg").setValue(entryInfo.getWorkOrg() == null ? null : entryInfo.getWorkOrg().getName());// 工作项目
			row.getCell("HworkOrg").setValue(entryInfo.getHworkOrj() == null ? null : entryInfo.getHworkOrj().getName());// 原工作项目
			row.getCell("quProf").setValue(entryInfo.getQuProf() == null ? null : entryInfo.getQuProf().getName());// 指标工种
			row.getCell("HquProf").setValue(entryInfo.getHQuProf() == null ? null : entryInfo.getHQuProf().getName());// 原指标工种
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}
	
	/**
	 * 居住证更新页签获取单据字段值
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
			row.getCell("rePmtETime").setValue(entryInfo.getRePmtETime());// 递交资料日期
			row.getCell("HrePmtETime").setValue(entryInfo.getHrePmtETime());// 原递交资料日期
			row.getCell("sRePmtSTime").setValue(entryInfo.getSRePmtSTime());// 劳动证出证日期
			row.getCell("HsRePmtSTime").setValue(entryInfo.getHsRePmtSTime());// 原劳动证出证日期
			row.getCell("pmtETime").setValue(entryInfo.getPmtETime());// 劳动证号码
			row.getCell("HpmtETime").setValue(entryInfo.getHpmtETime());// 原劳动证号码
			row.getCell("papSTime").setValue(entryInfo.getPapSTime());// 劳动证到期日
			row.getCell("HpapSTime").setValue(entryInfo.getHpapSTime());// 原劳动证到期日
			row.getCell("pmtNum").setValue(entryInfo.getPmtNum());// 正式居住证号码
			row.getCell("HpmtNum").setValue(entryInfo.getHpmtNum());// 原正式居住证号码
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}
	
	/**
	 * 居住证调转页签获取单据字段值
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
			row.getCell("pmtProj").setValue(entryInfo.getPmtProj() == null ? null : entryInfo.getPmtProj().getName());// 指标项目
			row.getCell("HpmtProj").setValue(entryInfo.getHpmtProj() == null ? null : entryInfo.getHpmtProj().getName());// 原指标项目
			row.getCell("workOrg").setValue(entryInfo.getWorkOrg() == null ? null : entryInfo.getWorkOrg().getName());// 工作项目
			row.getCell("HworkOrg").setValue(entryInfo.getHworkOrg() == null ? null : entryInfo.getHworkOrg().getName());// 原工作项目
			row.getCell("quProf").setValue(entryInfo.getQuProf() == null ? null : entryInfo.getQuProf().getName());// 指标工种
			row.getCell("HquProf").setValue(entryInfo.getHquProf() == null ? null : entryInfo.getHquProf().getName());// 原指标工种
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}
	
	/**
	 * 工作签信息录入页签获取单据字段值
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
			row.getCell("name").setValue(entryInfo.getName());// 指标项目
			row.getCell("sex").setValue(entryInfo.getSex());// 原指标项目
			row.getCell("birthdate").setValue(entryInfo.getBirthdate());// 工作项目
			row.getCell("nation").setValue(entryInfo.getNational()==null?null:entryInfo.getNational().getName().toString());// 原工作项目
			row.getCell("idNum").setValue(entryInfo.getIdNum());// 指标工种
			row.getCell("acProf").setValue(entryInfo.getAcProf());// 原指标工种
			row.getCell("pmtProfC").setValue(entryInfo.getPmtProfC() == null ? null : entryInfo.getPmtProfC().getName());// 分录ID
			row.getCell("workProgram").setValue(entryInfo.getWorkProgram() == null ? null : entryInfo.getWorkProgram().getName());// 指标项目
			row.getCell("permitProgram").setValue(entryInfo.getPermitProgram() == null ? null : entryInfo.getPermitProgram().getName());// 原指标项目
			row.getCell("cooperation").setValue(entryInfo.getCooperation() == null ? null : entryInfo.getCooperation().getName());// 工作项目
			row.getCell("passportNo").setValue(entryInfo.getPassportNo());// 原工作项目
			row.getCell("passportAgency").setValue(entryInfo.getPassportAgency());// 指标工种
			row.getCell("score").setValue(entryInfo.getScore());// 原指标工种
			row.getCell("oldPassport").setValue(entryInfo.getOldPassport());// 分录ID
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
		}
	}
	
	
	/**
	 * 商务签信息录入页签获取单据字段值
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
			row.getCell("name").setValue(entryInfo.getName());// 指标项目
			row.getCell("sex").setValue(entryInfo.getSex());// 原指标项目
			row.getCell("idNum").setValue(entryInfo.getBirthdate());// 工作项目
			row.getCell("nation").setValue(entryInfo.getNational());// 原工作项目
			row.getCell("passportNo").setValue(entryInfo.getPassportNo());// 指标工种
			row.getCell("passportIssueDate").setValue(entryInfo.getPassportIssueDate());// 原指标工种
			row.getCell("passportExpireDate").setValue(entryInfo.getPassportExpireDate());// 分录ID
			row.getCell("cooperation").setValue(entryInfo.getCooperation() == null ? null : entryInfo.getCooperation().getName());// 工作项目
			row.getCell("handleProject").setValue(entryInfo.getHandleProject() == null ? null : entryInfo.getHandleProject().getName());// 原工作项目
			row.getCell("workProgram").setValue(entryInfo.getWorkProgram() == null ? null : entryInfo.getWorkProgram().getName());// 指标工种
			row.getCell("id").setValue(entryInfo.getId());// 分录ID
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