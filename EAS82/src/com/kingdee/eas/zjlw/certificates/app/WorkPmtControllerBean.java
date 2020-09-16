package com.kingdee.eas.zjlw.certificates.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK; //import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean; //import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageCollection;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryCollection;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryFactory;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageFactory;
import com.kingdee.eas.zjlw.certificates.LeaveManageInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryCollection;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryFactory;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtInfo;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryFactory;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoInfo;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WorkPmtControllerBean extends AbstractWorkPmtControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.WorkPmtControllerBean");

	// ����
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		WorkPmtInfo accInfo = (WorkPmtInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		// ���ñ���
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany =
		// ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory =
		// CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //������Ϻ�
		// if(codFactory.isUseIntermitNumber(accInfo,
		// orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }else{
		// if(codFactory.isAddView(accInfo, orgId)){//������ʾ
		//    				
		// }else{//ʲô��û��ѡ
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }
		// }
		// }
		// }

		return super._save(ctx, accInfo);
	}

	// �ύ
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		WorkPmtInfo accInfo = (WorkPmtInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
		// ���ñ���
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// CompanyOrgUnitInfo currentCompany =
		// ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
		// String orgId = currentCompany.getId().toString();
		// ICodingRuleManager codFactory =
		// CodingRuleManagerFactory.getLocalInstance(ctx);
		// if(codFactory.isExist(accInfo, orgId)){
		// //������Ϻ�
		// if(codFactory.isUseIntermitNumber(accInfo,
		// orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }else{
		// if(codFactory.isAddView(accInfo, orgId)){//������ʾ
		//
		// }else{//ʲô��û��ѡ
		// accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
		// }
		// }
		// }
		// }
		return super._submit(ctx, accInfo);
	}

	// ���ͨ��
	protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		WorkPmtInfo info = (WorkPmtInfo) getValue(ctx, pk, getSelector());

		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("billSate", "40"));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("��ѡ���Ѵ������ͨ�������ݣ�������ˣ�");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeHistory(ctx, info, true);
		writeLeaveManage(ctx, info);
	}

	// ��˲�ͨ��
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		WorkPmtInfo info = (WorkPmtInfo) getValue(ctx, pk, getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("billSate", "30", CompareType.NOTEQUALS));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("��ѡ������˲�ͨ����");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);

		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeHistory(ctx, info, false);
		deleteLeaveManage(ctx, info);
	}

	// ��д
	private void writeHistory(Context ctx, WorkPmtInfo info, boolean isAudit) throws BOSException, EASBizException {
		WorkPmtEntryCollection entryCol = info.getEntrys();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("bsnisState");
		sic.add("hBsnisState");
		sic.add("coopHis");
		sic.add("coopRecord");
		for (int i = 0; i < entryCol.size(); i++) {
			WorkPmtEntryInfo wpInfo = entryCol.get(i);
			AdminOrgUnitInfo coop = wpInfo.getCooperation();
			// ��д��Ա��ʷ��Ϣ
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("sourceBillId", wpInfo.getPersonID()));
			view.setFilter(filter);
			SelectorItemCollection sic1 = new SelectorItemCollection();
			sic1.add("cooperation.id");
			sic1.add("cooperation.name");
			sic1.add("cooperation.number");
			sic1.add("coopHis.id");
			sic1.add("coopHis.name");
			sic1.add("coopHis.number");
			view.setSelector(sic1);
			PersonHistoryCollection col = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
			if (col != null && col.size() > 0) {
				PersonHistoryInfo phInfo = col.get(0);
				if (isAudit) {
					phInfo.setBsnisState(perBizStateEnum.WORKPERMIT);
					//���º�����λ   ywj 2018-11-5
					String phCoopId = phInfo.getCooperation().getId().toString();
					String coopId = coop.getId().toString();
					if(phCoopId!=null&&coopId!=null){
						if(phCoopId.equals(coopId)){
							phInfo.setCoopHis(coop);
							phInfo.setCoopRecord((new Date()).toString() + "���Ϊ��' " + coop.getName() + " ';");
						}
					}
				} else {
					phInfo.setBsnisState(perBizStateEnum.PASSPORTISSUED);
				}
				PersonHistoryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);
			}
			//���¡��⼮Ա������ǩ��Ϣ¼�롿����ǩ֤����������ǩ�����еġ��밢ʱ�䡯==============================
			// ======================BEGIN
			EntityViewInfo antiView = new EntityViewInfo();
			FilterInfo antiFilter = new FilterInfo();
			SelectorItemCollection immiSic = new SelectorItemCollection();
			immiSic.add("immiTime");
			antiFilter.getFilterItems().add(new FilterItemInfo("personID", wpInfo.getPersonID()));
			antiView.setFilter(antiFilter);

			// ��д��ǩ���� ywj 2017-11-16
			AntiSignedEntryCollection antiCol = AntiSignedEntryFactory.getLocalInstance(ctx).getAntiSignedEntryCollection(antiView);
			if (antiCol != null && antiCol.size() > 0) {
				AntiSignedEntryInfo antiInfo = antiCol.get(0);
				if (isAudit) {
					antiInfo.setImmiTime(wpInfo.getImmiTime());
				} else {
					antiInfo.setImmiTime(null);
				}
				AntiSignedEntryFactory.getLocalInstance(ctx).updatePartial(antiInfo, immiSic);
			}

			// ��дǩ֤���� ywj 2017-11-27
			VisaHandleEntryCollection visaCol = VisaHandleEntryFactory.getLocalInstance(ctx).getVisaHandleEntryCollection(antiView);
			if (visaCol != null && visaCol.size() > 0) {
				VisaHandleEntryInfo visaInfo = visaCol.get(0);
				if (isAudit) {
					visaInfo.setImmiTime(wpInfo.getImmiTime());
				} else {
					visaInfo.setImmiTime(null);
				}
				VisaHandleEntryFactory.getLocalInstance(ctx).updatePartial(visaInfo, immiSic);
			}

			// ��д�⼮Ա������ǩ��Ϣ¼�� ywj 2017-11-27
			/*
			 * ywj 2018-6-8 ����ǩ¼�������ֶ�personid��ֱ��ͨ��personid���� EntityViewInfo
			 * workVisaView = new EntityViewInfo(); FilterInfo workVisaFilter =
			 * new FilterInfo(); workVisaFilter.getFilterItems().add(new
			 * FilterItemInfo("id", wpInfo.getPersonID()));
			 * workVisaView.setFilter(workVisaFilter);
			 */
			WorkVisaEntryCollection workVisaCol = WorkVisaEntryFactory.getLocalInstance(ctx).getWorkVisaEntryCollection(antiView);
			if (workVisaCol != null && workVisaCol.size() > 0) {
				WorkVisaEntryInfo workVisaInfo = workVisaCol.get(0);
				if (isAudit) {
					workVisaInfo.setImmiTime(wpInfo.getImmiTime());
				} else {
					workVisaInfo.setImmiTime(null);
				}
				WorkVisaEntryFactory.getLocalInstance(ctx).updatePartial(workVisaInfo, immiSic);
			}

			//���¡��⼮Ա������ǩ��Ϣ¼�롿����ǩ֤����������ǩ�����еġ��밢ʱ�䡯==============================
			// ======================END
		}
	}

	// �Ƿ��뾳���ֶ���ѡ�����ͨ����д���뾳���ݡ��뾳���ͷ�ָ��
	private void writeLeaveManage(Context ctx, WorkPmtInfo info) throws EASBizException, BOSException {

		WorkPmtEntryCollection entryCol = info.getEntrys();
		for (int i = 0; i < entryCol.size(); i++) {

			WorkPmtEntryInfo entryInfo = entryCol.get(i);
			Boolean departure = entryInfo.isDeparture();
			Boolean isStop = entryInfo.isIsStop();
			if (departure || isStop) {
				LeaveManageInfo lmInfo = new LeaveManageInfo();
				// ��ͷ
				lmInfo.setId(BOSUuid.create(lmInfo.getBOSType()));
				lmInfo.setSourceBillId(info.getId().toString());
				lmInfo.setNumber(info.getNumber());
				lmInfo.setBNum(info.getBNum());
				lmInfo.setBizDate(new Date());
				lmInfo.setBillSate(BillStateEnum.DRAFT);
				// ����
				// ��ӷ�¼
				LeaveManageEntryInfo lmEntryInfo = new LeaveManageEntryInfo();
				lmEntryInfo.setId(BOSUuid.create(lmEntryInfo.getBOSType()));
				lmEntryInfo.setName(entryInfo.getName());// ����
				lmEntryInfo.setSex(entryInfo.getSex());// �Ա�
				lmEntryInfo.setLastName(entryInfo.getLastName());// ��ƴ��
				lmEntryInfo.setFirstName(entryInfo.getFirstName());// ��ƴ��
				lmEntryInfo.setNatioNal(entryInfo.getNation());// ����
				lmEntryInfo.setBirthday(entryInfo.getBirthday());// ����
				lmEntryInfo.setBirthPlaceCn(entryInfo.getBirthPlace());// ����������
				lmEntryInfo.setBirthPlaceFr(entryInfo.getBirthPlaceFr());// �����ط���
				lmEntryInfo.setPasspNum(entryInfo.getPasspNum());// ���պ�
				lmEntryInfo.setPasspIsDate(entryInfo.getPassportIssueDate());// ����ǩ������
				lmEntryInfo.setPasspExDate(entryInfo.getPasspExDate());// ���յ�������
				lmEntryInfo.setQuProf(entryInfo.getQuProf());// ָ�깤��
				lmEntryInfo.setQuproff(entryInfo.getQuprofF());// ָ�깤�֣����ģ�
				lmEntryInfo.setActProff(entryInfo.getActProf());// ʵ�ʹ���
				lmEntryInfo.setFatherName(entryInfo.getFatherName());// ��������
				lmEntryInfo.setFatherNameAl(entryInfo.getFatherNameAlphabet());// ��������ƴ��
				lmEntryInfo.setMotherName(entryInfo.getMotherName());// ĸ������
				lmEntryInfo.setMotherNameAl(entryInfo.getMotherNameAlphabet());// ĸ������ƴ��
				lmEntryInfo.setMaritalStatus(entryInfo.getMaritalStatus());// ����״��
				lmEntryInfo.setImmiTime(entryInfo.getImmiTime());// �밢ʱ��
				lmEntryInfo.setWPmtNum(entryInfo.getWPmtNum());// �Ͷ�֤��
				lmEntryInfo.setWPmtSTime(entryInfo.getWPmtSTime());// �Ͷ�֤����ʱ��
				lmEntryInfo.setPmtProj(entryInfo.getPmtProj());// ָ����Ŀ
				lmEntryInfo.setTaskProj(entryInfo.getWorkOrg());// ������Ŀ
				lmEntryInfo.setCooperation(entryInfo.getCooperation());// ������λ
				lmEntryInfo.setIdNum(entryInfo.getIdNum());// ���֤��
				lmEntryInfo.setPersonID(entryInfo.getPersonID());// ��Ա����
				lmEntryInfo.setSourceEntryID(entryInfo.getId().toString());// ��Դ��¼
				// lmEntryInfo.setRemark(entryInfo.getRemark());//��ע
				if (departure) {
					lmEntryInfo.setLeaveType(leaveTypeEnum.WORKNO);// �Ƿ��뾳��
					// ״̬Ϊ�Ͷ�֤δ�죡
				}
				if (isStop) {
					lmEntryInfo.setLeaveType(leaveTypeEnum.WORKSTOP);// �Ƿ�ͣ�죬
					// ״̬Ϊ�Ͷ�֤ͣ��
					// ��
					lmEntryInfo.setExitTime(entryInfo.getEndTime());// ͣ��ʱ��
				}
				// Я������
				IBoAttchAsso boaFac = BoAttchAssoFactory.getLocalInstance(ctx);
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("id");
				sic.add("attachment.id");
				EntityViewInfo view = new EntityViewInfo();
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("boID", entryInfo.getId().toString()));
				view.setFilter(filter);
				view.setSelector(sic);
				// �����뾳��¼ID��ѯ����
				BoAttchAssoCollection boaCol = boaFac.getBoAttchAssoCollection(view);
				if (boaCol != null && boaCol.size() > 0) {
					for (int j = 0; j < boaCol.size(); j++) {
						BoAttchAssoInfo boaInfo = boaCol.get(j);
						// ��Ӹ���
						BoAttchAssoInfo newBoaInfo = new BoAttchAssoInfo();
						newBoaInfo.setId(BOSUuid.create(newBoaInfo.getBOSType()));
						newBoaInfo.setBoID(lmEntryInfo.getId().toString());// ҵ��ID
						// ��
						// �뾳��¼ID
						newBoaInfo.setAssoType("ϵͳ���и���");// ����
						newBoaInfo.setAttachment(boaInfo.getAttachment());// ����
						newBoaInfo.setAssoBusObjType("3D062727");// ����ҵ���������ͣ�
						// �뾳��¼BOSTYPE
						boaFac.addnew(newBoaInfo);
					}
				}
				lmInfo.getEntrys().add(lmEntryInfo);
				LeaveManageFactory.getLocalInstance(ctx).addnew(lmInfo);
			}
		}
	}

	// ����ˣ�ɾ���뾳�е�����
	protected void deleteLeaveManage(Context ctx, WorkPmtInfo info) throws EASBizException, BOSException {
		WorkPmtEntryCollection entryCol = info.getEntrys();
		for (int i = 0; i < entryCol.size(); i++) {
			WorkPmtEntryInfo entryInfo = entryCol.get(i);
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			Boolean departure = entryInfo.isDeparture();
			Boolean isStop = entryInfo.isIsStop();
			String id = info.getId().toString();
			filter.getFilterItems().add(new FilterItemInfo("sourceBillId", id, CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("billSate", BillStateEnum.CHECKED, CompareType.NOTEQUALS));
			view.setFilter(filter);
			LeaveManageInfo phInfo = LeaveManageFactory.getLocalInstance(ctx).getLeaveManageCollection(view).get(0);
			if (phInfo != null && (departure || isStop)) {
				LeaveManageFactory.getLocalInstance(ctx).delete(filter);
			}
			// LeaveManageInfo phInfo =
			// LeaveManageFactory.getLocalInstance(ctx).
			// getLeaveManageCollection(view).get(0);
			// if(phInfo!=null&&(departure||isStop)){
			// LeaveManageFactory.getLocalInstance(ctx).delete(filter);
			// }

		}
	}

	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		sic.add("entrys.cooperation.id");
		sic.add("entrys.cooperation.name");
		sic.add("entrys.cooperation.number");
		return sic;

	}
}