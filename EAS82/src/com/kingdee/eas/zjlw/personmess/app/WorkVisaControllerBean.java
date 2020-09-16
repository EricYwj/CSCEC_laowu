package com.kingdee.eas.zjlw.personmess.app;

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
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.certificates.app.visaTypeEnum;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryCollection;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryFactory;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WorkVisaControllerBean extends AbstractWorkVisaControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.zjlw.personmess.app.WorkVisaControllerBean");

	// ����
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		WorkVisaInfo accInfo = (WorkVisaInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		// ���ñ���
		// if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
		// AdminOrgUnitInfo currentCompany =
		// ContextHelperFactory.getLocalInstance(ctx).getCurrentAdmin();
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
		WorkVisaInfo accInfo = (WorkVisaInfo) model;
		accInfo.setBillSate(BillStateEnum.CHECKING);
		// ���ñ���
		if (accInfo.getNumber() == null || "".equals(accInfo.getNumber())) {
			AdminOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentAdmin();
			String orgId = currentCompany.getId().toString();
			ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
			if (codFactory.isExist(accInfo, orgId)) {
				// ������Ϻ�
				if (codFactory.isUseIntermitNumber(accInfo, orgId) && (!codFactory.isUserSelect(accInfo, orgId))) {
					accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
				} else {
					if (codFactory.isAddView(accInfo, orgId)) {// ������ʾ

					} else {// ʲô��û��ѡ
						accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
					}
				}
			}
		}
		return super._submit(ctx, accInfo);
	}

	// ���ڹ��������
	protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		int a = 0;
		WorkVisaInfo info = (WorkVisaInfo) getValue(ctx, pk, getSelector());
		// FilterInfo filter = new FilterInfo();
		// filter.getFilterItems().add(new FilterItemInfo("billSate", "40"));
		// filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		// if (super._exists(ctx, filter)) {
		// try {
		// throw new Exception("��ѡ���Ѵ������ͨ�������ݣ�������ˣ�");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),
		// pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.CHECKING);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		// LogUtil.afterLog(ctx, logPK);
	}

	// ָ��ҵ����Ŀ��Ա���
	protected void _bizPersonAudit(Context ctx, IObjectPK pk) throws EASBizException, BOSException {
		// super._bizPersonAudit(ctx, pk);
		WorkVisaInfo info = (WorkVisaInfo) getValue(ctx, pk, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("programAuditor");
		sic.add("programAuditDate");
		info.setBillSate(BillStateEnum.CHECKING);
		info.setProgramAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setProgramAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
	}

	// ָ����Ŀ�������
	protected void _projectMessAudit(Context ctx, IObjectPK pk) throws EASBizException, BOSException {
		// super._projectMessAudit(ctx, pk);
		WorkVisaInfo info = (WorkVisaInfo) getValue(ctx, pk, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("projectAuditor");
		sic.add("projectAuditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setProjectAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setProjectAuditDate(new Date());
//		updatePartial(ctx, info, sic);
//		LogUtil.afterLog(ctx, logPK);
		writePersonHis(ctx, info);
	}

	// ��˲�ͨ��
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model) throws EASBizException, BOSException {
		WorkVisaInfo info = (WorkVisaInfo) getValue(ctx, pk, getSelector());
		// FilterInfo filter = new FilterInfo();
		// filter.getFilterItems().add(new FilterItemInfo("billSate", "30",
		// CompareType.NOTEQUALS));
		// filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		// if (super._exists(ctx, filter)) {
		// try {
		// throw new Exception("��ѡ������˲�ͨ����");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(), pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		sic.add("programAuditor");
		sic.add("programAuditDate");
		sic.add("projectAuditor");
		sic.add("projectAuditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);
		info.setProgramAuditor(null);
		info.setProgramAuditDate(null);
		info.setProjectAuditor(null);
		info.setProjectAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		deletePersonHis(ctx, info);
	}

	// ���ͨ�����ж���Ա��ʷ��Ϣ���Ƿ���ڣ�������ڣ�ɾ����Ա��ʷ��Ϣ����������ڣ���д��Ա��ʷ��Ϣ
	protected void writePersonHis(Context ctx, WorkVisaInfo info) throws EASBizException, BOSException {
		WorkVisaEntryCollection entryCol = info.getEntrys();
		for (int i = 0; i < entryCol.size(); i++) {
			WorkVisaEntryInfo entryInfo = entryCol.get(i);
			FilterInfo filter = new FilterInfo();
			String idNum = entryInfo.getIdNum();
			String passportNo = entryInfo.getPassportNo();
			if ("C01".equals(entryInfo.getNational().getNumber())) {
				filter.getFilterItems().add(new FilterItemInfo("idNum", idNum));
			} else {
				filter.getFilterItems().add(new FilterItemInfo("passportNo", passportNo));
			}
			PersonHistoryFactory.getLocalInstance(ctx).delete(filter);
			PersonHistoryInfo hisInfo = new PersonHistoryInfo();
			hisInfo.setId(BOSUuid.create(hisInfo.getBOSType()));
			hisInfo.setSourceBillId(entryInfo.getId().toString());
			hisInfo.setNumber(info.getNumber());// ���ݱ��
			hisInfo.setAuditor(info.getAuditor());// �����
			hisInfo.setNameCN(entryInfo.getName());// ��������
			hisInfo.setFirstNameAlp(entryInfo.getLastName());// ��ƴ��
			hisInfo.setLastNameApl(entryInfo.getFirstName());// ��ƴ��
			hisInfo.setSex(entryInfo.getSex());// �Ա�
			hisInfo.setBirthDate(entryInfo.getBirthdate());// ��������
			hisInfo.setNation(entryInfo.getNational());// ����
			hisInfo.setIdNum(entryInfo.getIdNum());// ���֤��
			hisInfo.setRealProf(entryInfo.getAcProf());// ʵ�ʹ���
			hisInfo.setPermitProfession(entryInfo.getPmtProfC());// ָ�깤��
			hisInfo.setWorkOrg(entryInfo.getWorkProgram());// ������Ŀ
			hisInfo.setPermitOrg(entryInfo.getPermitProgram());// ָ����Ŀ
			hisInfo.setCooperation(entryInfo.getCooperation());// ������λ
			hisInfo.setPassportNo(entryInfo.getPassportNo());// ���պ���
			hisInfo.setPassportIssueDate(entryInfo.getPassportIssueDate());// ����ǩ������
			hisInfo.setPassportExpireDate(entryInfo.getPassportExpireDate());// ����ʧЧ����
			hisInfo.setPassportInst(entryInfo.getPassportAgence().getAlias());// ���հ䷢����
			hisInfo.setBirthPlaceCn(entryInfo.getBirthPlaceCn());// ����������
			hisInfo.setBirthPlaceFr(entryInfo.getBirthPlaceFr());// �����ط���
			hisInfo.setFatherName(entryInfo.getFatherName());// ��������
			hisInfo.setFatherNameAlphabet(entryInfo.getFatherNameAlphabet());// ��������ƴ��
			hisInfo.setMotherName(entryInfo.getMotherName());// ĸ������
			hisInfo.setMotherNameAlphabet(entryInfo.getMotherNameAlphabet());// ĸ������ƴ��
			hisInfo.setMerState(entryInfo.getMaritalStatus());// ����״̬
			hisInfo.setCoupleName(entryInfo.getCoupleName());// ��ż����
			hisInfo.setCoupleNameAlphabet(entryInfo.getCoupleNameAlphabet());// ��ż����ƴ��
			hisInfo.setCoupleBirthDate(entryInfo.getCoupleBirthDate());// ��ż��������
			hisInfo.setCoupleBirthPlace(entryInfo.getCoupleBirthPlace());// ��ż������
			hisInfo.setCoupleWorkPlace(entryInfo.getCoupleWorkPlace());// ��ż������λ
			hisInfo.setCoupleNation(entryInfo.getCoupleNational());// ��ż����
			hisInfo.setPassportCity(entryInfo.getPassportCity());// ����ǩ��������
			hisInfo.setPassportCityF(entryInfo.getPassportCityF());// ����ǩ����ƴ��
			hisInfo.setContactway(entryInfo.getContactway());// ������ϵ��ʽ
			hisInfo.setInnerAddress(entryInfo.getResidence());// ������ϵ��ַ
			hisInfo.setOldPassport(entryInfo.getOldPassport());// �ɻ��պ�
			hisInfo.setRemark(entryInfo.getRemark());// ��ע
			hisInfo.setBsnisState(perBizStateEnum.MESSINPUT);// ��Աҵ��״̬����Ϣ¼��
			hisInfo.setVisaType(visaTypeEnum.work);// ǩ֤����
			PersonHistoryFactory.getLocalInstance(ctx).addnew(hisInfo);
		}
	}

	// �����ɾ����Ա��ʷ��Ϣ�е�����
	public void deletePersonHis(Context ctx, WorkVisaInfo info) throws BOSException, EASBizException {
		Set set = new HashSet();
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		WorkVisaEntryCollection entryCol = info.getEntrys();
		for (int i = 0; i < entryCol.size(); i++) {
			WorkVisaEntryInfo entryInfo = entryCol.get(i);
			String id = entryInfo.getId().toString();
			set.add(id);
			// view = new EntityViewInfo();
			// filter = new FilterInfo();
			// filter.getFilterItems().add(new FilterItemInfo("sourceBillId",
			// id));
			// view.setFilter(filter);
			// PersonHistoryCollection entryCoy
			// =PersonHistoryFactory.getLocalInstance
			// (ctx).getPersonHistoryCollection(view);
			// if(entryCoy!=null && entryCoy.size()>0){
			// PersonHistoryInfo phInfo = entryCoy.get(0);
			// PersonHistoryFactory.getLocalInstance(ctx).delete(new
			// ObjectUuidPK(phInfo.getId()));
			// }
		}
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId", set, CompareType.INCLUDE));
		PersonHistoryFactory.getLocalInstance(ctx).delete(filter);
	}

	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		sic.add("entrys.national.number");
		return sic;
	}
}