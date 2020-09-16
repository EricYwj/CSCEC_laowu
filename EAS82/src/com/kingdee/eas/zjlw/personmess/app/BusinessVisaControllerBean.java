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
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.certificates.app.perBizStateEnum;
import com.kingdee.eas.zjlw.certificates.app.visaTypeEnum;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntry;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.BusinessVisaEntryInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaFactory;
import com.kingdee.eas.zjlw.personmess.BusinessVisaInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.personmess.BusinessVisaCollection;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BusinessVisaControllerBean extends AbstractBusinessVisaControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.personmess.app.BusinessVisaControllerBean");
   // ����
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		BusinessVisaInfo accInfo = (BusinessVisaInfo) model;
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
    	BusinessVisaInfo accInfo = (BusinessVisaInfo) model;
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
    	BusinessVisaInfo info = (BusinessVisaInfo) getValue(ctx, pk, getSelector());

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
		writePersonHis(ctx,info);
    }
    // ��˲�ͨ��
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		BusinessVisaInfo info = (BusinessVisaInfo) getValue(ctx, pk,
				getSelector());
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
		deletePersonHis(ctx,info);
	}
	//���ͨ�����ж���Ա��ʷ��Ϣ���Ƿ���ڣ�������ڣ�ɾ����Ա��ʷ��Ϣ����������ڣ���д��Ա��ʷ��Ϣ
	protected void writePersonHis(Context ctx,BusinessVisaInfo info) throws EASBizException, BOSException{
		BusinessVisaEntryCollection  entryCol = info.getEntrys();
		for(int i=0;i<entryCol.size();i++){
			BusinessVisaEntryInfo entryInfo = entryCol.get(i);
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
			String idNum=entryInfo.getIdNum();
			String passportNo=entryInfo.getPassportNo();
			filter.getFilterItems().add(new FilterItemInfo("idNum",idNum));
			filter.getFilterItems().add(new FilterItemInfo("passportNo",passportNo));
			//filter.setMaskString("#0 or #1");
			//view.setFilter(filter);
			PersonHistoryFactory.getLocalInstance(ctx).delete(filter);
			PersonHistoryInfo hisInfo = new PersonHistoryInfo();
			hisInfo.setId(BOSUuid.create(hisInfo.getBOSType()));
			hisInfo.setSourceBillId(entryInfo.getId().toString());
			hisInfo.setNumber(info.getNumber());//���ݱ��
			hisInfo.setAuditor(info.getAuditor());//�����
			hisInfo.setNameCN(entryInfo.getName());//����
			hisInfo.setFirstNameAlp(entryInfo.getFirstName());//��ƴ��
			hisInfo.setLastNameApl(entryInfo.getLastName());//��ƴ��
			hisInfo.setSex(entryInfo.getSex());//�Ա�
			hisInfo.setIdNum(entryInfo.getIdNum());//���֤��
			hisInfo.setNation(entryInfo.getNational());//����
			hisInfo.setBirthDate(entryInfo.getBirthdate());//��������
			hisInfo.setBirthPlaceCn(entryInfo.getBirthPlaceCn());//������
			hisInfo.setPassportNo(entryInfo.getPassportNo());//���պ���
			hisInfo.setPassportIssueDate(entryInfo.getPassportIssueDate());//����ǩ������
			hisInfo.setPassportExpireDate(entryInfo.getPassportExpireDate());//����ʧЧ����
			hisInfo.setFatherName(entryInfo.getFatherName());//��������
			hisInfo.setMotherName(entryInfo.getMotherName());//ĸ������
			hisInfo.setCoupleName(entryInfo.getCoupleName());//��ż����
			hisInfo.setCooperation(entryInfo.getCooperation());//������λ
			hisInfo.setWorkOrg(entryInfo.getWorkProgram());//������Ŀ
			hisInfo.setBsnisState(perBizStateEnum.MESSINPUT);//��Աҵ��״̬
			hisInfo.setVisaType(visaTypeEnum.buss);//ǩ֤����
			PersonHistoryFactory.getLocalInstance(ctx).addnew(hisInfo);
		}
	}
	 //�����ɾ����Ա��ʷ��Ϣ�е�����
    public void deletePersonHis(Context ctx,BusinessVisaInfo info) throws BOSException, EASBizException{
    	Set set=new HashSet();
    	EntityViewInfo view=new EntityViewInfo();
    	FilterInfo filter=new FilterInfo();
    	BusinessVisaEntryCollection entryCol=info.getEntrys();
    	for(int i=0;i<entryCol.size();i++){
    		BusinessVisaEntryInfo entryInfo=entryCol.get(i);
    		String id=entryInfo.getId().toString();
    		set.add(id);
    	}
    	filter.getFilterItems().add(new FilterItemInfo("sourceBillId",set,CompareType.INCLUDE));
    	PersonHistoryFactory.getLocalInstance(ctx).delete(filter);
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