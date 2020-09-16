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

import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelEntryCollection;
import com.kingdee.eas.zjlw.certificates.ASCancelEntryInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelFactory;
import com.kingdee.eas.zjlw.certificates.ASCancelInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryCollection;
import com.kingdee.eas.zjlw.certificates.VisaHandleInfo;
import com.kingdee.eas.fm.nt.client.NTWarnLedgerUIHandler.EntryInfo;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnit;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.person.PersonStates;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AntiSignedControllerBean extends AbstractAntiSignedControllerBean {
	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.zjlw.certificates.app.AntiSignedControllerBean");

	// ����
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		AntiSignedInfo accInfo = (AntiSignedInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		// ���ñ���
//		if (accInfo.getNumber() == null || "".equals(accInfo.getNumber())) {
//			CompanyOrgUnitInfo currentCompany = ContextHelperFactory
//					.getLocalInstance(ctx).getCurrentCompany();
//			String orgId = currentCompany.getId().toString();
//			ICodingRuleManager codFactory = CodingRuleManagerFactory
//					.getLocalInstance(ctx);
//			if (codFactory.isExist(accInfo, orgId)) {
//				// ������Ϻ�
//				if (codFactory.isUseIntermitNumber(accInfo, orgId)
//						&& (!codFactory.isUserSelect(accInfo, orgId))) {
//					accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//				} else {
//					if (codFactory.isAddView(accInfo, orgId)) {// ������ʾ
//
//					} else {// ʲô��û��ѡ
//						accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//					}
//				}
//			}
//		}
		return super._save(ctx, accInfo);
	}

	// �ύ
	protected IObjectPK _submit(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		AntiSignedInfo accInfo = (AntiSignedInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
//		// ���ñ���
//		if (accInfo.getNumber() == null || "".equals(accInfo.getNumber())) {
//			CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
//			String orgId = currentCompany.getId().toString();
//			ICodingRuleManager codFactory = CodingRuleManagerFactory
//					.getLocalInstance(ctx);
//			if (codFactory.isExist(accInfo, orgId)) {
//				// ������Ϻ�
//				if (codFactory.isUseIntermitNumber(accInfo, orgId)
//						&& (!codFactory.isUserSelect(accInfo, orgId))) {
//					accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//				} else {
//					if (codFactory.isAddView(accInfo, orgId)) {// ������ʾ
//
//					} else {// ʲô��û��ѡ
//						accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//					}
//				}
//			}
//		}
		return super._submit(ctx, accInfo);
	}

	// ���ͨ��
	protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
		AntiSignedInfo info = (AntiSignedInfo) getValue(ctx, pk, getSelector());
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
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),
				pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeBack(ctx, info, true,false);

	}

	// ��˲�ͨ��
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
		AntiSignedInfo info = (AntiSignedInfo) getValue(ctx, pk, getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(
				new FilterItemInfo("billSate", "30", CompareType.NOTEQUALS));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("��ѡ������˲�ͨ����");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(),
				pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);

		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeBack(ctx, info, false,false);
	}
//	
//	protected void _logOut(Context ctx, IObjectPK pk) throws BOSException,EASBizException {
//		AntiSignedInfo info = (AntiSignedInfo) getValue(ctx, pk, getSelector());
//		//У���Ƿ�Ϊ���ͨ��״̬
//		FilterInfo filter = new FilterInfo();
//		filter.getFilterItems().add(new FilterItemInfo("billSate", "40", CompareType.NOTEQUALS));
//		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
//		if (super._exists(ctx, filter)) {
//			try {
//				throw new Exception("�����ͨ��״̬��������ע����");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		//���µ���״̬Ϊע��
//		SelectorItemCollection sic = new SelectorItemCollection();
//		sic.add("billSate");
//		info.setBillSate(BillStateEnum.DSTRY);
//		updatePartial(ctx, info, sic);
//		//������Ա״̬Ϊע��,�ͷ�ָ��
//		writeBack(ctx, info, true,true);
//	}
//	/**
//	 * ע��
//	 *	1.���ĵ���״̬Ϊע�� 	
//	 * 	2.������Ա״̬Ϊע��
//	 * 	3.�ͷ�ָ��
//	 * @throws EASBizException 
//	 */
////	public void logOut(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
////		AntiSignedInfo info = (AntiSignedInfo) getValue(ctx, pk, getSelector());
////		//У���Ƿ�Ϊ���ͨ��״̬
////		FilterInfo filter = new FilterInfo();
////		filter.getFilterItems().add(new FilterItemInfo("billSate", "40", CompareType.NOTEQUALS));
////		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
////		if (super._exists(ctx, filter)) {
////			try {
////				throw new Exception("�����ͨ��״̬��������ע����");
////			} catch (Exception e) {
////				e.printStackTrace();
////			}
////		}
////		//���µ���״̬Ϊע��
////		SelectorItemCollection sic = new SelectorItemCollection();
////		sic.add("billSate");
////		info.setBillSate(BillStateEnum.DSTRY);
////		updatePartial(ctx, info, sic);
////		//������Ա״̬Ϊע��,�ͷ�ָ��
////		writeBack(ctx, info, true,true);
////	}
//	
//	
	/**
	 * ��д����
	 * 
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeBack(Context ctx, AntiSignedInfo info, boolean audMark,boolean logoutMark)throws BOSException, EASBizException {
		AntiSignedEntryCollection entryCol = info.getEntrys();
		AntiSignedEntryInfo entryInfo = new AntiSignedEntryInfo();
		boolean cancelSta = true;
		boolean isLogout = true;
		for (int i = 0; i < entryCol.size(); i++) {
			entryInfo = entryCol.get(i);
			cancelSta = entryInfo.isIsCancel();
			isLogout = entryInfo.isIsLogout();
			if(!cancelSta && !isLogout) {// ����״̬
				updatePerHis(ctx,entryInfo,true,true,audMark);//������Ա״̬
			}else {
				//ͣ��
				if(cancelSta){
					if (audMark) {// ���ͨ������д��ǩͣ����Ա��
						writeAntipers(ctx, info, entryInfo);
					}else{//�����
						deletePersonHis(ctx, info.getId().toString());// ɾ��ͣ����Ա��Ϣ���е�����
					}
				}
				writeProjectWork(ctx, entryInfo.getQuProf().getId().toString(),audMark);//�ͷ�ָ��
				updatePerHis(ctx,entryInfo,false,cancelSta, audMark);//������Ա״̬
			}
		}
	}

	/**
	 * ����ָ������
	 * 
	 * @param ctx
	 * @param id
	 * @param isAudit
	 * @throws EASBizException
	 * @throws BOSException
	 */
	private void writeProjectWork(Context ctx, String id, boolean audMark)
			throws EASBizException, BOSException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("useAmount");
		sic.add("leftAmount");
		sic.add("totalAmount");
		if (id != null && !"".equals(id)) {
			ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx)
					.getProjectWorkInfo(new ObjectUuidPK(id), sic);
			if (audMark) {//������״̬�����ͨ������ע�����ͷ�ָ�꣬����ʹ��������һ
				pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
			} else {//������״̬�������ͨ�����ͷ�ָ�꣬����ʹ��������һ
				pwInfo.setUseAmount(pwInfo.getUseAmount() + 1);
			}
			pwInfo.setLeftAmount(pwInfo.getTotalAmount()- pwInfo.getUseAmount());
			ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
		}
		
	}

	/**
	 * ��д��ǩͣ����Ա��
	 * 
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeAntipers(Context ctx, AntiSignedInfo info,AntiSignedEntryInfo entryInfo) throws EASBizException, BOSException {
		// ��ͷ
		ASCancelInfo ascInfo = new ASCancelInfo();
		ascInfo.setId(BOSUuid.create(ascInfo.getBOSType()));
		ascInfo.setSourceBillId(info.getId().toString());
		ascInfo.setNumber(info.getNumber());
		ascInfo.setLSubtime(info.getAuditDate());
		ascInfo.setISubmitor(info.getAuditor());
		// ����
		// ��ӷ�¼
		ASCancelEntryInfo cancelEntryInfo = new ASCancelEntryInfo();
		cancelEntryInfo.setId(BOSUuid.create(cancelEntryInfo.getBOSType()));
		cancelEntryInfo.setName(entryInfo.getName());// ����
		cancelEntryInfo.setLastName(entryInfo.getLastName());//��ƴ��
		cancelEntryInfo.setFirstName(entryInfo.getFirstName());//��ƴ��
		cancelEntryInfo.setSex(entryInfo.getSex());// �Ա�
		cancelEntryInfo.setBirDate(entryInfo.getBirDate());// ��������
		cancelEntryInfo.setNatioNal(entryInfo.getNatioNal());// ����
		cancelEntryInfo.setPasspNo(entryInfo.getPasspNo());// ���պ���
		cancelEntryInfo.setQuProf(entryInfo.getQuProf());// ָ�깤������
		cancelEntryInfo.setPmtProfFr(entryInfo.getPmtProfFr());//ָ�깤�ַ���
		cancelEntryInfo.setSendLaBuDate(entryInfo.getSendLaBuDate());// �ݽ��Ͷ���ʱ��
		cancelEntryInfo.setIsCancel(entryInfo.isIsCancel());//�Ƿ�ͣ��
		cancelEntryInfo.setCancelDate(entryInfo.getCancelDate());//ͣ��ʱ��
		cancelEntryInfo.setCancelReson(entryInfo.getCancelReson());//ͣ������
		cancelEntryInfo.setPmtProj(entryInfo.getPmtProj());// ָ����Ŀ
		cancelEntryInfo.setTaskProj(entryInfo.getTaskProj());// ������Ŀ
		cancelEntryInfo.setPartner(entryInfo.getPartner());// ������λ
		cancelEntryInfo.setSignNum(entryInfo.getSignNum());//�ڼ��α�ǩ
		cancelEntryInfo.setIdNum(entryInfo.getIdNum());//���֤����
		cancelEntryInfo.setRemark(entryInfo.getRemark());// ��ע
		cancelEntryInfo.setPersonID(entryInfo.getPersonID());//��Ա����
		cancelEntryInfo.setSourceEntryID(entryInfo.getId().toString());//��Դ��¼
		cancelEntryInfo.setPasspIssDate(entryInfo.getPasspIssDate());// ����ǩ������
		cancelEntryInfo.setPasspExDate(entryInfo.getPasspExDate());// ����ʧЧ����
		cancelEntryInfo.setBirAddrCn(entryInfo.getBirAddrCn());// ������
		cancelEntryInfo.setFName(entryInfo.getFName());// ��������
		cancelEntryInfo.setAlphFName(entryInfo.getAlphFName());// ����ƴ��
		cancelEntryInfo.setMName(entryInfo.getMName());// ĸ������
		cancelEntryInfo.setAlphMName(entryInfo.getAlphMName());// ĸ������ƴ��
		cancelEntryInfo.setMayrStat(entryInfo.getMayrStat());// ����״��
		cancelEntryInfo.setActproff(entryInfo.getActproff());// ʵ��רҵ����
		cancelEntryInfo.setAntiSgTime(entryInfo.getAntiSgTime());// ��ǩ�������ʱ��
		cancelEntryInfo.setWorkExp(entryInfo.getWorkExp());// ��������
		ascInfo.getEntrys().add(cancelEntryInfo);
		ASCancelFactory.getLocalInstance(ctx).addnew(ascInfo);
	}

	/**
	 * ������Ա��Ϣ�����Ա״̬
	 * 
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	private void updatePerHis(Context ctx,AntiSignedEntryInfo entryInfo,boolean isNormal,boolean isStop, boolean audMark) throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		//filter.getFilterItems().add(new FilterItemInfo("idNum", idNum));
		//filter.getFilterItems().add(new FilterItemInfo("passportNo", passportNo));
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId",entryInfo.getPersonID()));
		sic.add("bsnisState");
		sic.add("hBsnisState");
		view.setFilter(filter);
		view.setSelector(sic);
		PersonHistoryCollection personCol = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
		for(int i=0;i<personCol.size();i++){
			PersonHistoryInfo newper =personCol.get(i);
			perBizStateEnum hState = newper.getHBsnisState();
			if(audMark){//���ͨ��
				newper.setHBsnisState(newper.getBsnisState());
				if(isNormal){//��������
					newper.setBsnisState(perBizStateEnum.ANTISIGNED);
				}else{//����������
					newper.setBsnisState(isStop?perBizStateEnum.ANTISTOP:perBizStateEnum.ANTINOT);
				}
			}else{//�����
				newper.setBsnisState( perBizStateEnum.INDEXALLOT);
			}
			PersonHistoryFactory.getLocalInstance(ctx).updatePartial(newper, sic);
		}
	}

	// �����ɾ����ǩͣ���е�����
	public void deletePersonHis(Context ctx, String ids)throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId", ids));
		ASCancelFactory.getLocalInstance(ctx).delete(filter);

	}

	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		return sic;
	}
}