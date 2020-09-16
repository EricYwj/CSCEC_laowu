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
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.certificates.app.visaTypeEnum;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryCollection;
import com.kingdee.eas.zjlw.personmess.LocalInfoEntryInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.eas.zjlw.social.InsurePersonCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryCollection;
import com.kingdee.eas.zjlw.social.InsurePersonEntryFactory;
import com.kingdee.eas.zjlw.social.InsurePersonEntryInfo;
import com.kingdee.eas.zjlw.social.InsurePersonFactory;
import com.kingdee.eas.zjlw.social.InsurePersonInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LocalInfoControllerBean extends AbstractLocalInfoControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.personmess.app.LocalInfoControllerBean");
    // ����
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		LocalInfoInfo accInfo = (LocalInfoInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		//���ñ���
//    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
//    	AdminOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentAdmin();
//    	String orgId = currentCompany.getId().toString();
//    	ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
//    	if(codFactory.isExist(accInfo, orgId)){
//    		//������Ϻ�
//    		if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
//    			accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//    		}else{
//    			if(codFactory.isAddView(accInfo, orgId)){//������ʾ
//    				
//    			}else{//ʲô��û��ѡ
//    				accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
//    			}
//    		}
//    	  }
//    	}
		return super._save(ctx, accInfo);
	}
	//�ύ 
    protected IObjectPK _submit(Context ctx, IObjectValue model)
    throws BOSException, EASBizException {
    	LocalInfoInfo accInfo = (LocalInfoInfo) model;
    	accInfo.setBillSate(BillStateEnum.SUBMIT);
	   	//���ñ���
    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
    		AdminOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentAdmin();
    		String orgId = currentCompany.getId().toString();
    		ICodingRuleManager codFactory = CodingRuleManagerFactory.getLocalInstance(ctx);
    		if(codFactory.isExist(accInfo, orgId)){
    			//������Ϻ�
    			if(codFactory.isUseIntermitNumber(accInfo, orgId)&&(!codFactory.isUserSelect(accInfo, orgId))){
    				accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
    			}else{
    				if(codFactory.isAddView(accInfo, orgId)){//������ʾ

    				}else{//ʲô��û��ѡ
    					accInfo.setNumber(codFactory.getNumber(accInfo, orgId));
    				}
    			}
    		}
    	}
    	return super._submit(ctx, accInfo);
    }
    //���ͨ��
    protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)
    		throws EASBizException, BOSException {
    	LocalInfoInfo info = (LocalInfoInfo) getValue(ctx, pk, getSelector());

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
		//writePersonHis(ctx,info);
		//InsurePerson(ctx,info);
    }
 // ��˲�ͨ��
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		LocalInfoInfo info = (LocalInfoInfo) getValue(ctx, pk,getSelector());
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
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("auditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		//deletePersonHis(ctx,info);
	}
	//���ͨ�����ж���Ա��ʷ��Ϣ���Ƿ���ڣ�������ڣ�ɾ����Ա��ʷ��Ϣ����������ڣ���д��Ա��ʷ��Ϣ
//	protected void writePersonHis(Context ctx,LocalInfoInfo info) throws EASBizException, BOSException{
//		LocalInfoEntryCollection  entryCol = info.getEntrys();
//		for(int i=0;i<entryCol.size();i++){
//			LocalInfoEntryInfo entryInfo = entryCol.get(i);
//			EntityViewInfo view = new EntityViewInfo();
//	    	FilterInfo filter = new FilterInfo();
//			String securityNo=entryInfo.getSecurityNo();
//			filter.getFilterItems().add(new FilterItemInfo("securityNo",securityNo));
//			//view.setFilter(filter);
//			PersonHistoryFactory.getLocalInstance(ctx).delete(filter);
//			PersonHistoryInfo hisInfo = new PersonHistoryInfo();
//			hisInfo.setId(BOSUuid.create(hisInfo.getBOSType()));
//			hisInfo.setSourceBillId(entryInfo.getId().toString());
//			hisInfo.setNumber(info.getNumber());//���ݱ��
//			hisInfo.setAuditor(info.getAuditor());//�����
//			hisInfo.setNameCN(entryInfo.getFirstName()+entryInfo.getLastName());//����
//			hisInfo.setSex(entryInfo.getSex());//�Ա�
//			hisInfo.setBirthDate(entryInfo.getBirthdate());//��������
//			ProvinceInfo provInfo = ProvinceFactory.getLocalInstance(ctx).getProvinceInfo(new ObjectUuidPK(entryInfo.getBirthPlace().getId()));
//			hisInfo.setBirthPlaceCn(provInfo.getDescription());//������
//			hisInfo.setMerState(entryInfo.getMaritalStatus());//����״̬
//			hisInfo.setFatherName(entryInfo.getFatherName());//��������
//			hisInfo.setMotherName(entryInfo.getMotherName());//ĸ������
//			hisInfo.setSecurityNo(entryInfo.getSecurityNo());// �籣����
//			hisInfo.setWorkOrg(entryInfo.getWorkProgram());//������Ŀ
//			hisInfo.setCooperation(entryInfo.getCooperation());//������λ
//			hisInfo.setBsnisState(perBizStateEnum.MESSINPUT);//��Աҵ��״̬
//			hisInfo.setVisaType(visaTypeEnum.local);//ǩ֤����
//			PersonHistoryFactory.getLocalInstance(ctx).addnew(hisInfo);
//		}
//	}
	 //�����ɾ����Ա��ʷ��Ϣ�е�����
//    public void deletePersonHis(Context ctx,LocalInfoInfo info) throws BOSException, EASBizException{
//    	Set set=new HashSet();
//    	EntityViewInfo view=new EntityViewInfo();
//    	FilterInfo filter=new FilterInfo();
//    	LocalInfoEntryCollection entryCol=info.getEntrys();
//    	for(int i=0;i<entryCol.size();i++){
//    		LocalInfoEntryInfo entryInfo=entryCol.get(i);
//    		String id=entryInfo.getId().toString();
//    		set.add(id);
//    	}
//    	filter.getFilterItems().add(new FilterItemInfo("sourceBillId",set,CompareType.INCLUDE));
//    	PersonHistoryFactory.getLocalInstance(ctx).delete(filter);
//    }
    //���ͨ����д�����α���Ա����
//    protected void InsurePerson(Context ctx,LocalInfoInfo info) throws EASBizException, BOSException{
//    	LocalInfoEntryCollection  entryCol = info.getEntrys();
//    	EntityViewInfo view = new EntityViewInfo();
//    	FilterInfo filter = new FilterInfo();
//    	for(int i=0;i<entryCol.size();i++){
//			LocalInfoEntryInfo loEntryInfo = entryCol.get(i);
//			String securityNo=loEntryInfo.getSecurityNo();
//			AdminOrgUnitInfo adInfo=(AdminOrgUnitInfo)loEntryInfo.getWorkProgram();
//			BOSUuid id=adInfo.getId();
//			filter.getFilterItems().add(new FilterItemInfo("workProgram.id",id,CompareType.INCLUDE));
//			//filter.getFilterItems().add(new FilterItemInfo("entrys.securityNo",securityNo,CompareType.NOTINCLUDE));
//			view.setFilter(filter);
//			InsurePersonCollection col=InsurePersonFactory.getLocalInstance(ctx).getInsurePersonCollection();
//			if(col!=null&&col.size()>0){
//				InsurePersonInfo ipInfo=col.get(i);
//				InsurePersonEntryInfo ipEntryInfo=new InsurePersonEntryInfo();
//				ipEntryInfo.setLastName(loEntryInfo.getLastName());//��
//				ipEntryInfo.setFirstName(loEntryInfo.getFirstName());//��
//				ipEntryInfo.setSex(loEntryInfo.getSex());//�Ա�
//				ipEntryInfo.setBirthdate(loEntryInfo.getBirthdate());//��������
//				//ipEntryInfo.setProvince(loEntryInfo.getProvinces());//ʡ��
//				ipEntryInfo.setBirthPlaceCn(loEntryInfo.getBirthPlaceCn());//������
//				ipEntryInfo.setMaritalStatus(loEntryInfo.getMaritalStatus());//����״��
//				ipEntryInfo.setFatherName(loEntryInfo.getFatherName());//��������
//				ipEntryInfo.setMotherName(loEntryInfo.getMotherName());//ĸ������
//				ipEntryInfo.setTelephone(loEntryInfo.getTelephone());//��ϵ��ʽ
//				ipEntryInfo.setSecurityNo(loEntryInfo.getSecurityNo());//�籣��
//				ipEntryInfo.setCCPNo(loEntryInfo.getCCPNo());//CCPN�˺�
//				ipEntryInfo.setAddress(loEntryInfo.getAddress());//��ͥסַ
//				ipEntryInfo.setWorkProgram(loEntryInfo.getWorkProgram());//������Ŀ
//				ipEntryInfo.setCooperation(loEntryInfo.getCooperation());//������λ
//				ipEntryInfo.setCooperationId(loEntryInfo.getCooperationId());//������λ����
//				ipEntryInfo.setProfession(loEntryInfo.getProf());//����
//				ipEntryInfo.setContractNo(loEntryInfo.getContractNo());//��ͬ���
//				ipEntryInfo.setApproachTime(loEntryInfo.getApproachTime());//��������
//				ipEntryInfo.setContrachSigDate(loEntryInfo.getContrachSigDate());//��ͬǩ������
//				ipEntryInfo.setContractTime(loEntryInfo.getContractTime());//��ͬ��������
//				ipInfo.getEntrys().add(ipEntryInfo);
//				InsurePersonEntryFactory.getLocalInstance(ctx).addnew(ipEntryInfo);
//			}else{
//				InsurePersonInfo ipInfo=new InsurePersonInfo();
//				ipInfo.setId(BOSUuid.create(ipInfo.getBOSType()));
//				ipInfo.setSourceBillId(info.getId().toString());
//				ipInfo.setNumber(info.getNumber());
//				ipInfo.setBizDate(info.getBizDate());
//				ipInfo.setBillSate(BillStateEnum.DRAFT);
//				InsurePersonEntryInfo ipEntryInfo=new InsurePersonEntryInfo();
//				//��¼
//				ipEntryInfo.setLastName(loEntryInfo.getLastName());//��
//				ipEntryInfo.setFirstName(loEntryInfo.getFirstName());//��
//				ipEntryInfo.setSex(loEntryInfo.getSex());//�Ա�
//				ipEntryInfo.setBirthdate(loEntryInfo.getBirthdate());//��������
//				//ipEntryInfo.setProvince(loEntryInfo.getProvinces());//ʡ��
//				ipEntryInfo.setBirthPlaceCn(loEntryInfo.getBirthPlaceCn());//������
//				ipEntryInfo.setMaritalStatus(loEntryInfo.getMaritalStatus());//����״��
//				ipEntryInfo.setFatherName(loEntryInfo.getFatherName());//��������
//				ipEntryInfo.setMotherName(loEntryInfo.getMotherName());//ĸ������
//				ipEntryInfo.setTelephone(loEntryInfo.getTelephone());//��ϵ��ʽ
//				ipEntryInfo.setSecurityNo(loEntryInfo.getSecurityNo());//�籣��
//				ipEntryInfo.setCCPNo(loEntryInfo.getCCPNo());//CCPN�˺�
//				ipEntryInfo.setAddress(loEntryInfo.getAddress());//��ͥסַ
//				ipEntryInfo.setWorkProgram(loEntryInfo.getWorkProgram());//������Ŀ
//				ipEntryInfo.setCooperation(loEntryInfo.getCooperation());//������λ
//				ipEntryInfo.setCooperationId(loEntryInfo.getCooperationId());//������λ����
//				ipEntryInfo.setProfession(loEntryInfo.getProf());//����
//				ipEntryInfo.setContractNo(loEntryInfo.getContractNo());//��ͬ���
//				ipEntryInfo.setApproachTime(loEntryInfo.getApproachTime());//��������
//				ipEntryInfo.setContrachSigDate(loEntryInfo.getContrachSigDate());//��ͬǩ������
//				ipEntryInfo.setContractTime(loEntryInfo.getContractTime());//��ͬ��������
//				ipInfo.getEntrys().add(ipEntryInfo);
//				InsurePersonFactory.getLocalInstance(ctx).addnew(ipInfo);
//			}
//    	}
//    	
//    	
//    }
	protected SelectorItemCollection getSelector(){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("billSate");
			sic.add("number");
			sic.add("company.id");
			sic.add("entrys.*");
			return sic;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}