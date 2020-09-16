package com.kingdee.eas.zjlw.certificates.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ibm.db2.jcc.sqlj.EntryInfo;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelEntryInfo;
import com.kingdee.eas.zjlw.certificates.ASCancelFactory;
import com.kingdee.eas.zjlw.certificates.ASCancelInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection;
import com.kingdee.eas.zjlw.certificates.DoubQualifyEntryInfo;
import com.kingdee.eas.zjlw.certificates.DoubQualifyFactory;
import com.kingdee.eas.zjlw.certificates.DoubQualifyInfo;
import com.kingdee.eas.zjlw.certificates.IfilentryEntryInfo;
import com.kingdee.eas.zjlw.certificates.IfilentryFactory;
import com.kingdee.eas.zjlw.certificates.IfilentryInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryCollection;
import com.kingdee.eas.zjlw.certificates.ImmigrationEntryInfo;
import com.kingdee.eas.zjlw.certificates.ImmigrationInfo;
import com.kingdee.eas.zjlw.certificates.PassportEntryInfo;
import com.kingdee.eas.zjlw.certificates.PassportFactory;
import com.kingdee.eas.zjlw.certificates.PassportInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.zjlw.certificates.ImmigrationCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoInfo;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ImmigrationControllerBean extends AbstractImmigrationControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.ImmigrationControllerBean");
 // ����
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		ImmigrationInfo accInfo = (ImmigrationInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		//���ñ���
//    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
//    	CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
//    	String orgId = currentCompany.getId().toString();
//    	ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
//	    	if(codFactory.isExist(accInfo, orgId)){
//	    		//������Ϻ�
//	    		if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
//	    			accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//	    		}else{
//	    			if(codFactory.isAddView(accInfo, orgId)){//������ʾ
//	    				
//	    			}else{//ʲô��û��ѡ
//	    				accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//	    			}
//	    		}
//	    	}
//    	}
		return super._save(ctx, accInfo);
	}
	//�ύ 
    protected IObjectPK _submit(Context ctx, IObjectValue model)
    throws BOSException, EASBizException {
    	ImmigrationInfo accInfo = (ImmigrationInfo) model;
    	accInfo.setBillSate(BillStateEnum.CHECKING);
    	//���ñ���
//    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
//    		CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
//    		String orgId = currentCompany.getId().toString();
//    		ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
//    		if(codFactory.isExist(accInfo, orgId)){
//    			//������Ϻ�
//    			if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
//    				accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//    			}else{
//    				if(codFactory.isAddView(accInfo, orgId)){//������ʾ
//
//    				}else{//ʲô��û��ѡ
//    					accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//    				}
//    			}
//    		}
//    	}
    	return super._submit(ctx, accInfo);
    }
    
    /**
     * ҵ����Ա���ͨ��
     */
    protected void _internalAudit(Context ctx, IObjectPK PK)throws BOSException, EASBizException {
    	ImmigrationInfo info = (ImmigrationInfo) getValue(ctx, PK, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),PK, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("inteAuditor");
		sic.add("inteADate");
		info.setBillSate(BillStateEnum.CHECKING);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
    }
    
    /**
     * ��Ŀ�������ͨ��
     */
    protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
    	ImmigrationInfo info = (ImmigrationInfo) getValue(ctx, pk, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeBack(ctx, info, true);		//������Ա״̬����д���ݵ�
		
    }
    
//	private void writePassp(Context ctx, ImmigrationInfo info) throws EASBizException, BOSException {
//			ImmigrationEntryInfo entryInfo = info.getEntrys().get(0);
//			// ��ͷ
//			PassportInfo ascInfo = new PassportInfo();
//			ascInfo.setId(BOSUuid.create(ascInfo.getBOSType()));
//			ascInfo.setSourceBillId(info.getId().toString());
//			ascInfo.setNumber(info.getNumber());
//			// ����
//			// ��ӷ�¼
//			PassportEntryInfo cancelEntryInfo = new PassportEntryInfo();
//			cancelEntryInfo.setId(BOSUuid.create(cancelEntryInfo.getBOSType()));
//			cancelEntryInfo.setName(entryInfo.getName());// ����
//			cancelEntryInfo.setIdNum(entryInfo.getIdNum());//���֤����
//			cancelEntryInfo.setPasspNum(entryInfo.getPasspNum());//���պ���
//			ascInfo.getEntrys().add(cancelEntryInfo);
//			PassportFactory.getLocalInstance(ctx).addnew(ascInfo);
//
//		}
	
//	// �����ɾ�����շ����е�����
//	public void deletePersonHis(Context ctx,ImmigrationInfo info)throws BOSException, EASBizException {
//		FilterInfo filter = new FilterInfo();
//		filter.getFilterItems().add(new FilterItemInfo("sourceBillId", info.getId().toString()));
//		PassportFactory.getLocalInstance(ctx).delete(filter);
//
//	}
//    /**
//     * �������
//     */
//    protected void _LWAudit(Context ctx, IObjectPK PK) throws BOSException,EASBizException {
//    	ImmigrationInfo info = (ImmigrationInfo) getValue(ctx, PK, getSelector());
//		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),PK, info.getNumber());
//		SelectorItemCollection sic = new SelectorItemCollection();
//		sic.add("billSate");
//		sic.add("LWAuditor");
//		sic.add("LWAudDate");
//		info.setBillSate(BillStateEnum.CHECKED);
//		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
//		info.setAuditDate(new Date());
//		updatePartial(ctx, info, sic);
//		LogUtil.afterLog(ctx, logPK);
//		writeBack(ctx, info, true);		//������Ա״̬����д���ݵ�
//    }
//    
	/**
	 * ��˲�ͨ��
	 */
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
		ImmigrationInfo info = (ImmigrationInfo) getValue(ctx, pk,getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		sic.add("inteAuditor");
		sic.add("inteADate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setInteAuditor(null);
		info.setInteADate(null);
		info.setAuditor(null);
		info.setAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		writeBack(ctx, info, false);
	}
	
	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		return sic;
	}

	/**
	 * ��ȡ˫��֤δ�����Ա
	 * @param dqEntryInfo
	 * @return
	 */
	private String checkDQTime(DoubQualifyEntryInfo dqEntryInfo) {
		Date dqFTime = null;
		String tip = "";
		dqFTime = dqEntryInfo.getQualDate();
		Date now = new Date();
		long  day=(dqFTime.getTime()-now.getTime())/86400000;
    	if (day<30) {
    		tip = tip + "������" + dqEntryInfo.getName() + "���֤�Ż��պţ�" + (dqEntryInfo.getIdNum()==null?dqEntryInfo.getPasspNo():dqEntryInfo.getIdNum()) + ";" + "\r\n";
		}
    	return tip;
	}
	

	
	/**
	 * ��д����
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeBack(Context ctx, ImmigrationInfo info, boolean audMark)throws BOSException, EASBizException {
		ImmigrationEntryCollection entryCol = info.getEntrys();
		ImmigrationEntryInfo entryInfo = new ImmigrationEntryInfo();
		boolean cancelSta = true;
		boolean violSta = true;
		for (int i = 0; i < entryCol.size(); i++) {
			entryInfo = entryCol.get(i);
			cancelSta = entryInfo.isIsCancel();
			violSta = entryInfo.isIfUnexpect();
			updatePerHis(ctx, entryInfo,false,audMark);//������Ա״̬
			if (!cancelSta) {
				if (violSta) {//Υ���뾳
					if (audMark) {
						writeViolation(ctx, info, entryInfo);//���ͨ����дΥ���뾳����
					} else {
						deleteViol(ctx, info.getId().toString());// �����ɾ��Υ���뾳�е�����
					}
				} else {// ����״̬
					//					if (audMark) {
					//						writePassp(ctx, info);
					//					} else {
					//						deletePersonHis(ctx,info);
					//					}
				}
			}else {//ͣ��
				//writeProjectWork(ctx, entryInfo.getQuProf().getId().toString(),audMark);// ����ָ��ʹ������
				//updatePerHis(ctx, entryInfo.getIdNum(), entryInfo.getPasspNum(),true,audMark);//������Ա״̬
			}
		}
	}
	
	/**
	 * ��дΥ���뾳��Ա��
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void writeViolation(Context ctx, ImmigrationInfo info,ImmigrationEntryInfo entryInfo) throws EASBizException, BOSException {
		// ��ͷ
		IfilentryInfo ascInfo = new IfilentryInfo();
		ascInfo.setId(BOSUuid.create(ascInfo.getBOSType()));
		ascInfo.setSourceBillId(info.getId().toString());
//		ascInfo.setContbNum(info.getContbNum());//��ǩ���κ�
		ascInfo.setNumber(info.getNumber());//���ݱ��
		ascInfo.setBillSate(BillStateEnum.DRAFT);//����״̬
		ascInfo.setBizDate(new Date());//ҵ������
		// ����
		// ��ӷ�¼
		IfilentryEntryInfo IfilentryEntryInfo = new IfilentryEntryInfo();
		IfilentryEntryInfo.setId(BOSUuid.create(IfilentryEntryInfo.getBOSType()));
		IfilentryEntryInfo.setName(entryInfo.getName());// ����
		IfilentryEntryInfo.setLastName(entryInfo.getLastName());//��ƴ��
		IfilentryEntryInfo.setFirstName(entryInfo.getFirstName());//��ƴ��
		IfilentryEntryInfo.setSex(entryInfo.getSex());// �Ա�
		IfilentryEntryInfo.setBirthdate(entryInfo.getBirthdate());//��������
		IfilentryEntryInfo.setNatioNal(entryInfo.getNatioNal());//����
		IfilentryEntryInfo.setPasspNum(entryInfo.getPasspNum());//���պ�
		IfilentryEntryInfo.setPasspExDate(entryInfo.getPasspExDate());//����ʧЧ����
		IfilentryEntryInfo.setVeTime(entryInfo.getVeTime());//ǩ֤ʧЧ����
		IfilentryEntryInfo.setDbCmpTime(entryInfo.getDbCmpTime());//˫��֤�������ʱ��
		IfilentryEntryInfo.setContDepart(entryInfo.getContDepart());//ǩ����ͬ��λ
		IfilentryEntryInfo.setContSTime(entryInfo.getContSTime());//ǩ����ͬ����
		IfilentryEntryInfo.setContOtime(entryInfo.getContOtime());//��ͬ��Ч����
		IfilentryEntryInfo.setContItime(entryInfo.getContItime());//��ͬʧЧ����
		IfilentryEntryInfo.setIfbuyInsure(entryInfo.isIfbuyInsure());//�Ƿ�����
		IfilentryEntryInfo.setIsHand(entryInfo.isIsHand());//�Ƿ������ʽ���֤���챾��
		IfilentryEntryInfo.setApAlgTime(entryInfo.getApAlgTime());//�����밢ʱ��
		IfilentryEntryInfo.setPmtProj(entryInfo.getPmtProj());// ָ����Ŀ
		IfilentryEntryInfo.setTaskProj(entryInfo.getTaskProj());// ������Ŀ
		IfilentryEntryInfo.setPartner(entryInfo.getPartner());// ������λ
		IfilentryEntryInfo.setReportAffiliated(entryInfo.isReportAffiliated());//�뾳���뱨��ҿ���
		IfilentryEntryInfo.setIdNum(entryInfo.getIdNum());//���֤����
		IfilentryEntryInfo.setDescription(entryInfo.getDescription());//��ע
		IfilentryEntryInfo.setOldPassport(entryInfo.getOldPassport());//�ɻ��պ���	oldPassport
		IfilentryEntryInfo.setBirthPlaceCn(entryInfo.getBirthPlaceCn());//�����أ����ģ�	birthPlaceCn
		IfilentryEntryInfo.setBirthPlaceFr(entryInfo.getBirthPlaceFr());//�����أ�ƴ����	birthPlaceFr
		IfilentryEntryInfo.setPassportIssueDate(entryInfo.getPassportIssueDate());//����ǩ������	passportIssueDate
		IfilentryEntryInfo.setPassportAgence(entryInfo.getPassportAgence());//���հ䷢����	passportAgence
		IfilentryEntryInfo.setPassportCityC(entryInfo.getPassportCityC());//����ǩ���أ����ģ�	passportCityC
		IfilentryEntryInfo.setPassportCityF(entryInfo.getPassportCityF());//����ǩ���أ�ƴ����	passportCityF
		IfilentryEntryInfo.setWorkSuffer(entryInfo.getWorkSuffer());//��������	workSuffer
		IfilentryEntryInfo.setQuProf(entryInfo.getQuProf());// ָ�깤��
		IfilentryEntryInfo.setPmtProfFr(entryInfo.getPmtProfFr());//ָ�깤�ַ���	pmtProfFr
		IfilentryEntryInfo.setFatherName(entryInfo.getFatherName());//��������	fatherName
		IfilentryEntryInfo.setFatherNameAlphabet(entryInfo.getFatherNameAlphabet());//��������ƴ��	fatherNameAlphabet
		IfilentryEntryInfo.setMotherName(entryInfo.getMotherName());//ĸ������	motherName
		IfilentryEntryInfo.setMotherNameAlphabet(entryInfo.getMotherNameAlphabet());//ĸ������ƴ��	motherNameAlphabet
		IfilentryEntryInfo.setMaritalStatus(entryInfo.getMaritalStatus());//����״̬	MaritalStatus
		IfilentryEntryInfo.setLaborSignNo(entryInfo.getLaborSignNo());//�Ͷ��ַ�ǩ��	laborSignNo
		IfilentryEntryInfo.setAntiSgTime(entryInfo.getAntiSgTime());//��ǩ��Чʱ��	antiSgTime
		IfilentryEntryInfo.setDocUpDate(entryInfo.getDocUpDate());//��ǩ�����ϴ�ʱ��	docUpDate
		IfilentryEntryInfo.setDocAffiliated(entryInfo.isDocAffiliated());//��ǩ�����ҿ���	docAffiliated
		IfilentryEntryInfo.setVgetTime(entryInfo.getVgetTime());//ǩ֤�����յ�ʱ��	vgetTime
		IfilentryEntryInfo.setVSentTime(entryInfo.getVSentTime());//ǩ֤��ǩʱ��	vSentTime
		IfilentryEntryInfo.setVcompTime(entryInfo.getVcompTime());//ǩ֤�������ʱ��
		IfilentryEntryInfo.setVisaNum(entryInfo.getVisaNum());//ǩ֤����	visaNum
		IfilentryEntryInfo.setVsTime(entryInfo.getVsTime());//ǩ֤ǩ������	vsTime
		IfilentryEntryInfo.setSignNum(entryInfo.getSignNum());//�ڼ��α�ǩ	signNum
		IfilentryEntryInfo.setAuthType(entryInfo.getAuthType());//��֤��֤����	authType
		IfilentryEntryInfo.setCopies(entryInfo.getCopies());//����	copies
		IfilentryEntryInfo.setCoupleName(entryInfo.getCoupleName());//��ż����	coupleName
		IfilentryEntryInfo.setCoupleNameAlphabet(entryInfo.getCoupleNameAlphabet());//��ż����ƴ��	coupleNameAlphabet
		IfilentryEntryInfo.setCoupleBirthDate(entryInfo.getCoupleBirthDate());//��ż��������	coupleBirthDate
		IfilentryEntryInfo.setCoupleBirthPlace(entryInfo.getCoupleBirthPlace());//��ż������	coupleBirthPlace
		IfilentryEntryInfo.setCoupleNational(entryInfo.getCoupleNational());//��ż����	coupleNational
		IfilentryEntryInfo.setCoupleWorkPlace(entryInfo.getCoupleWorkPlace());//��ż������λ����Ŀ	coupleWorkPlace
		IfilentryEntryInfo.setContactway(entryInfo.getContactway());//������ϵ��ʽ���ֻ��ţ�	contactway
		IfilentryEntryInfo.setResidence(entryInfo.getResidence());//������ϵ��ϸ��ַ��ʡ���أ�	residence
		IfilentryEntryInfo.setActproff(entryInfo.getActproff());//ʵ��רҵ����	actproff
		IfilentryEntryInfo.setSourceEntryID(entryInfo.getId().toString());//��Դ��¼
		IfilentryEntryInfo.setPersonID(entryInfo.getPersonID());//��Աid
		//Я������
		IBoAttchAsso boaFac = BoAttchAssoFactory.getLocalInstance(ctx);
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("id");
		sic.add("attachment.id");
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("boID", entryInfo.getId().toString()));
		view.setFilter(filter);
		view.setSelector(sic);
		//�����뾳��¼ID��ѯ����
		BoAttchAssoCollection boaCol =boaFac.getBoAttchAssoCollection(view);
		if(boaCol!=null && boaCol.size()>0){
			for(int i=0;i<boaCol.size();i++){
				BoAttchAssoInfo boaInfo = boaCol.get(i);
				//��Ӹ���
				BoAttchAssoInfo newBoaInfo = new BoAttchAssoInfo();
				newBoaInfo.setId(BOSUuid.create(newBoaInfo.getBOSType()));
				newBoaInfo.setBoID(IfilentryEntryInfo.getId().toString());//ҵ��ID��Υ���뾳��¼ID
				newBoaInfo.setAssoType("ϵͳ���и���");//����
				newBoaInfo.setAttachment(boaInfo.getAttachment());//����
				newBoaInfo.setAssoBusObjType("C23A32B1");//����ҵ���������ͣ�Υ���뾳��¼BOSTYPE
				boaFac.addnew(newBoaInfo);
			}
		}
		ascInfo.getEntrys().add(IfilentryEntryInfo);
		IfilentryFactory.getLocalInstance(ctx).addnew(ascInfo);
	}
	// �����ɾ��Υ���뾳�е�����
	public void deleteViol(Context ctx, String ids)throws BOSException, EASBizException {
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId", ids));
		IfilentryFactory.getLocalInstance(ctx).delete(filter);

	}
	/**
	 * ������Ա��Ϣ�����Ա״̬
	 * 
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	private void updatePerHis(Context ctx,ImmigrationEntryInfo entryInfo,boolean isStop, boolean audMark) throws BOSException, EASBizException {
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		//filter.getFilterItems().add(new FilterItemInfo("idNum", idNum));
		//filter.getFilterItems().add(new FilterItemInfo("passportNo", passportNo));
		filter.getFilterItems().add(new FilterItemInfo("sourceBillId",entryInfo.getPersonID()));
		view.setFilter(filter);
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("bsnisState");
		sic.add("hBsnisState");
		PersonHistoryCollection personCol = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
		for(int i=0;i<personCol.size();i++){//����״̬
			PersonHistoryInfo newper =personCol.get(i);
			perBizStateEnum hState = newper.getHBsnisState();
			newper.setHBsnisState(newper.getBsnisState());
//			if (isStop) {
//				newper.setBsnisState(audMark ? perBizStateEnum.IMMIGRATIONSTOP : hState);
//			}
			newper.setBsnisState(audMark ? perBizStateEnum.IMMIGRATION : perBizStateEnum.VISA);
			PersonHistoryFactory.getLocalInstance(ctx).updatePartial(newper, sic);
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
			if (audMark) {//������״̬�����ͨ�����ͷ�ָ�꣬����ʹ��������һ
				pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
			} else {//������״̬�������ͨ�����ͷ�ָ�꣬����ʹ��������һ
				pwInfo.setUseAmount(pwInfo.getUseAmount() + 1);
			}
			pwInfo.setLeftAmount(pwInfo.getTotalAmount()- pwInfo.getUseAmount());
			ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
		}
		
	}
}