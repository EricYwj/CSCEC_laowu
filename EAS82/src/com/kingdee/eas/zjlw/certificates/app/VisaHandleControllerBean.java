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
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkCollection;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelEntryInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelFactory;
import com.kingdee.eas.zjlw.certificates.ASCancelInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryCollection;
import com.kingdee.eas.zjlw.certificates.VisaHandleEntryInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleInfo;
import com.kingdee.eas.zjlw.certificates.WorkVisacancelEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkVisacancelFactory;
import com.kingdee.eas.zjlw.certificates.WorkVisacancelInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.VisaHandleCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class VisaHandleControllerBean extends AbstractVisaHandleControllerBean {
	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.zjlw.certificates.app.VisaHandleControllerBean");

	// ����
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		VisaHandleInfo accInfo = (VisaHandleInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
//		// ���ñ���
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
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		VisaHandleInfo accInfo = (VisaHandleInfo) model;
		accInfo.setBillSate(BillStateEnum.SUBMIT);
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
		return super._submit(ctx, accInfo);
	}

	// ���ͨ��
	protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		VisaHandleInfo info = (VisaHandleInfo) getValue(ctx, pk, getSelector());

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
		writeBack(ctx, info, true);

	}

	// ��˲�ͨ��
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		VisaHandleInfo info = (VisaHandleInfo) getValue(ctx, pk, getSelector());
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(
				new FilterItemInfo("billSate", "30", CompareType.NOTEQUALS));
		filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
		if (super._exists(ctx, filter)) {
			try {
				throw new Exception("��ѡ���Ѵ������ͨ�������ݣ�������ˣ�");
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
		writeBack(ctx, info, false);
	}

	/**
	 * ��д����
	 * 
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeBack(Context ctx, VisaHandleInfo info, boolean audMark)throws BOSException, EASBizException {
		VisaHandleEntryCollection entryCol = info.getEntrys();
		VisaHandleEntryInfo entryInfo = new VisaHandleEntryInfo();
		for (int i = 0; i < entryCol.size(); i++) {
			entryInfo = entryCol.get(i);
			boolean cancelSta = entryInfo.isIsCancel();
			if (cancelSta){//ͣ��
				if (audMark) {// ���ͨ������д��ǩͣ����Ա��
					writeAntipers(ctx, info, entryInfo);
				}else{//�����
					deletePersonHis(ctx, info.getId().toString());// ɾ��ͣ����Ա��Ϣ���е�����
				}
			}
			updatePerHis(ctx, entryInfo,cancelSta, audMark);//������Ա״̬
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
	private void writeProjectWork(Context ctx, String id, boolean audMark)throws EASBizException, BOSException {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("useAmount");
		sic.add("leftAmount");
		sic.add("totalAmount");
		if (id != null && !"".equals(id)) {
			ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx)
					.getProjectWorkInfo(new ObjectUuidPK(id), sic);
			if (audMark) {//������״̬�����ͨ�����ͷ�ָ�꣬����ʹ��������һ
				pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
			} else {//������״̬�������ͨ�����ͷ�ָ�꣬����ʹ��������һ
				pwInfo.setUseAmount(pwInfo.getUseAmount() + 1);
			}
			pwInfo.setLeftAmount(pwInfo.getTotalAmount()- pwInfo.getUseAmount());
			ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
		}
		
	}
	/**
	 * ��д����ǩͣ����Ա��
	 * 
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeAntipers(Context ctx, VisaHandleInfo info,VisaHandleEntryInfo entryInfo) throws EASBizException, BOSException {
		// ��ͷ
		WorkVisacancelInfo ascInfo = new WorkVisacancelInfo();
		ascInfo.setId(BOSUuid.create(ascInfo.getBOSType()));
		ascInfo.setSourceBillId(info.getId().toString());
		ascInfo.setNumber(info.getNumber());
		ascInfo.setBizDate(new Date());
		ascInfo.setISubtime(info.getAuditDate());
		ascInfo.setISubmitor(info.getAuditor());
		// ����
		WorkVisacancelEntryInfo cancelEntryInfo = new WorkVisacancelEntryInfo();
		cancelEntryInfo.setId(BOSUuid.create(cancelEntryInfo.getBOSType()));
		cancelEntryInfo.setName(entryInfo.getName());// ����
		cancelEntryInfo.setSex(entryInfo.getSex());// �Ա�
		cancelEntryInfo.setBornDate(entryInfo.getBornDate());// ��������
		cancelEntryInfo.setNatioNal(entryInfo.getNatioNal());//����
		cancelEntryInfo.setPasspNo(entryInfo.getPasspNo());// ���պ���
		cancelEntryInfo.setPrmtPro(entryInfo.getPrmtPro());// ָ����Ŀ
		cancelEntryInfo.setWorkPro(entryInfo.getWorkPro());// ������Ŀ
		cancelEntryInfo.setPartner(entryInfo.getPartner());// ������λ
		cancelEntryInfo.setLaborSignNo(entryInfo.getLaborSignNo());//�Ͷ��ַ�ǩ��
		cancelEntryInfo.setAntiEndTime(entryInfo.getAntiEndTime());//��ǩ����ʱ��
		cancelEntryInfo.setDocAffiliated(entryInfo.isDocAffiliated());//��ǩ�����ҿ���
		cancelEntryInfo.setIsCancel(entryInfo.isIsCancel());//�Ƿ�ͣ��
		cancelEntryInfo.setCancelDate(entryInfo.getCancelDate());//ͣ��ʱ��
		cancelEntryInfo.setStopRsn(entryInfo.getStopRsn());//ͣ������
		cancelEntryInfo.setIdNum(entryInfo.getIdNum());// ���֤��
		cancelEntryInfo.setDesCription(entryInfo.getDesCription());// ��ע
		
		cancelEntryInfo.setSourceEntryID(entryInfo.getId().toString());//��Դ��¼
		cancelEntryInfo.setPersonID(entryInfo.getPersonID());//��Աid
		cancelEntryInfo.setPassoTime(entryInfo.getPassoTime());// ����ǩ������
		cancelEntryInfo.setPasspDate(entryInfo.getPasspDate());// ����ʧЧ����
		cancelEntryInfo.setPmtProfc(entryInfo.getPmtProfc());// ָ�깤��
		cancelEntryInfo.setCuproff(entryInfo.getCuproff());// ָ�깤�ַ���
		cancelEntryInfo.setActProff(entryInfo.getActProff());// ʵ��רҵ����
		cancelEntryInfo.setAnSgetDate(entryInfo.getAnSgetDate());// ��ǩ�����յ�ʱ��
		cancelEntryInfo.setVgetTime(entryInfo.getVgetTime());// ǩ֤�����յ�ʱ��
		cancelEntryInfo.setVSentTime(entryInfo.getVSentTime());// ǩ֤��ǩʱ�䣨�ݽ�ʹ�����ڣ�
		cancelEntryInfo.setVcompTime(entryInfo.getVcompTime());// ǩ֤�������ʱ��
		cancelEntryInfo.setVsTime(entryInfo.getVsTime());// ǩ֤ǩ������
		cancelEntryInfo.setVeTime(entryInfo.getVeTime());// ǩ֤��������
		ascInfo.getEntrys().add(cancelEntryInfo);
		WorkVisacancelFactory.getLocalInstance(ctx).addnew(ascInfo);
	}
	// �����ɾ����ǩͣ���е�����
	public void deletePersonHis(Context ctx, String ids)throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId", ids));
		WorkVisacancelFactory.getLocalInstance(ctx).delete(filter);

	}


	/**
	 * ������Ա��Ϣ�����Ա״̬
	 * 
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	private void updatePerHis(Context ctx,VisaHandleEntryInfo entryInfo,boolean cancel, boolean audMark) throws BOSException, EASBizException {
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view = new EntityViewInfo();
		SelectorItemCollection sic = new SelectorItemCollection();
		//filter.getFilterItems().add(new FilterItemInfo("idNum", idNum));
		//filter.getFilterItems().add(new FilterItemInfo("passportNo", passportNo));
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId",entryInfo.getPersonID()));
		view.setFilter(filter);
		view.setSelector(sic);
		sic.add("bsnisState");
		sic.add("hBsnisState");
		PersonHistoryCollection personCol = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
		for(int i=0;i<personCol.size();i++){
			PersonHistoryInfo newper =personCol.get(i);
			perBizStateEnum hState = newper.getHBsnisState();
			newper.setHBsnisState(newper.getBsnisState());
//			if (cancel) {
//				newper.setBsnisState(audMark ? perBizStateEnum.VISASTOP : hState);
//			}
			newper.setBsnisState(audMark ? perBizStateEnum.VISA : perBizStateEnum.ANTISIGNED);
			PersonHistoryFactory.getLocalInstance(ctx).updatePartial(newper, sic);
		}
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