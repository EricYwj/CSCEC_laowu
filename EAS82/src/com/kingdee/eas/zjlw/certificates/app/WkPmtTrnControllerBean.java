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
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.baseinfo.BlackListCollection;
import com.kingdee.eas.zjlw.baseinfo.BlackListFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WkPmtTrnControllerBean extends AbstractWkPmtTrnControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.WkPmtTrnControllerBean");
    // ����
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		WkPmtTrnInfo accInfo = (WkPmtTrnInfo) model;
		accInfo.setBillSate(BillStateEnum.DRAFT);
		//���ñ���
//    	if(accInfo.getNumber()==null ||"".equals(accInfo.getNumber())){
//    	CompanyOrgUnitInfo currentCompany = ContextHelperFactory.getLocalInstance(ctx).getCurrentCompany();
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
//    	}
//    	}
		return super._save(ctx, accInfo);
	}
	//�ύ 
    protected IObjectPK _submit(Context ctx, IObjectValue model)
    throws BOSException, EASBizException {
    	WkPmtTrnInfo accInfo = (WkPmtTrnInfo) model;
    	accInfo.setBillSate(BillStateEnum.SUBMIT);
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
    //���ͨ��
    protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)
    		throws EASBizException, BOSException {
    	WkPmtTrnInfo info = (WkPmtTrnInfo) getValue(ctx, pk, getSelector());

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
		writeWorkPmt(ctx,info);
		writePersonHis(ctx,info);
		writeLivePermit(ctx,info);
    }
    // ��˲�ͨ��
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		WkPmtTrnInfo info = (WkPmtTrnInfo) getValue(ctx, pk,getSelector());
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
	}
	//��д��Ա��ʷ��Ϣ
	protected void writePersonHis(Context ctx,WkPmtTrnInfo info) throws BOSException, EASBizException {
		WkPmtTrnEntryCollection entryCol=info.getEntrys();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("permitOrg");//ָ����Ŀ
		sic.add("workOrg");//������Ŀ
		sic.add("permitProfession");//ָ�깤��
		for(int i=0;i<entryCol.size();i++){
			WkPmtTrnEntryInfo wpInfo=entryCol.get(i);
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
//			String idNum=wpInfo.getIdNum();
//			String passpNum=wpInfo.getPasspNum();
			//String number=info.getNumber();
//			filter.getFilterItems().add(new FilterItemInfo("idNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passportNo",passpNum));
			filter.getFilterItems().add(new FilterItemInfo("sourceBillId",wpInfo.getPersonID()));
//			filter.setMaskString("#0 OR #1");
			view.setFilter(filter);
			PersonHistoryCollection col = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
			if(col!=null&&col.size()>0){
				PersonHistoryInfo phInfo=col.get(0);
				if(wpInfo.getQuProf()!=null&&!"".equals(wpInfo.getQuProf())){
					//���ԭָ�깤�ֺ���ָ�깤��һ�����򲻷�д��Ա��ʱ��Ϣ
				    if(wpInfo.getQuProf().equals(wpInfo.getHQuProf())){
				    }
					//���ԭָ�깤�ֺ���ָ�깤�ֲ�һ������д��Ա��ʷ��Ϣ�����ͷ�ָ�ꡣ
					if(!wpInfo.getQuProf().equals(wpInfo.getHQuProf())){
						if(wpInfo.getHQuProf()!=null){
							String id=wpInfo.getHQuProf().getId().toString();
							checkProjectWork(ctx,id);//�ͷ�ԭָ������-1
							phInfo.setPermitOrg(wpInfo.getPmtProj());//ָ����Ŀ
							phInfo.setWorkOrg(wpInfo.getPmtProj());//������Ŀ
							phInfo.setPermitProfession(wpInfo.getQuProf());//ָ�깤��
							PersonHistoryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);
							String id1=wpInfo.getQuProf().getId().toString();
							checkProjectWork1(ctx,id1);//��ָ������+1
						}
					}
			    }
			}
		}		
	}
	//���ͨ�����ͷ�ָ�깤��ָ��
	private void checkProjectWork(Context ctx, String id)throws EASBizException, BOSException {
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("useAmount");
			sic.add("leftAmount");
			sic.add("totalAmount");
			if (id != null && !"".equals(id)) {
				ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx).getProjectWorkInfo(new ObjectUuidPK(id), sic);
				pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
				pwInfo.setLeftAmount(pwInfo.getTotalAmount()-pwInfo.getUseAmount());
				ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
			}
     }
	//���ͨ�����ͷ�ָ�깤��ָ��
	private void checkProjectWork1(Context ctx, String id)throws EASBizException, BOSException {
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("useAmount");
			sic.add("leftAmount");
			sic.add("totalAmount");
			if (id != null && !"".equals(id)) {
				ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx).getProjectWorkInfo(new ObjectUuidPK(id), sic);
					pwInfo.setUseAmount(pwInfo.getUseAmount() +1);
					pwInfo.setLeftAmount(pwInfo.getTotalAmount()-pwInfo.getUseAmount());
					ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
			}
     }
	//���ͨ�����Ͷ�֤��ת��д���Ͷ�֤����
	protected void writeWorkPmt(Context ctx,WkPmtTrnInfo info) throws BOSException, EASBizException{
		WkPmtTrnEntryCollection entryCol=info.getEntrys();
    	SelectorItemCollection sic = new SelectorItemCollection();
    	sic.add("passpNum");//���պ���
    	sic.add("passportIssueDate");//����ǩ������
    	sic.add("passpExDate");//���յ�������
    	sic.add("passportAgence");//���հ䷢����
    	sic.add("passportCityCC");//����ǩ���أ����ģ�
    	sic.add("passportCityF");//����ǩ���أ�ƴ����
    	sic.add("quProf");//ָ�깤��
		sic.add("quprofF");//ָ�깤��(����)
    	sic.add("qualDate");//˫��֤���ʱ��
    	sic.add("authType");//��֤��֤����
		sic.add("papSTime");//�ݽ���������
		sic.add("wPmtNum");//�Ͷ�֤��
		sic.add("pType");//�Ͷ�֤����
		sic.add("wPmtGTime");//�Ͷ�֤��֤����
		sic.add("laboreffDate");//�Ͷ�֤��Ч����
		sic.add("wPmtSTime");//�Ͷ�֤��֤����
		sic.add("sPAfPerson");//�Ͷ�֤����ǩ�ռ��ҿ���
		sic.add("pmtProj");//ָ����Ŀ
		sic.add("workOrg");//������Ŀ
		sic.add("oldPassport");//�ɻ��պ���
		for(int i=0;i<entryCol.size();i++){
			WkPmtTrnEntryInfo wteInfo=entryCol.get(i);
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
//			String idNum=wteInfo.getIdNum();
//			String passpNum=wteInfo.getPasspNum();
//			String number=info.getNumber();
//			filter.getFilterItems().add(new FilterItemInfo("IdNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passpNum",passpNum));
//			filter.getFilterItems().add(new FilterItemInfo("parent.number",number));
	    	//filter.getFilterItems().add(new FilterItemInfo("parent.sourceBillId",id));
			filter.getFilterItems().add(new FilterItemInfo("id",wteInfo.getSourceEntryID()));
			filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
			view.setFilter(filter);
			WorkPmtEntryCollection col = WorkPmtEntryFactory.getLocalInstance(ctx).getWorkPmtEntryCollection(view);
			if(col!=null&&col.size()>0){
				WorkPmtEntryInfo phInfo=col.get(0);
				phInfo.setPasspNum(wteInfo.getPasspNum());//���պ���
				phInfo.setPassportIssueDate(wteInfo.getPassportIssueDate());//����ǩ������
				phInfo.setPasspExDate(wteInfo.getPasspExDate());//���յ�������
				phInfo.setPassportAgence(wteInfo.getPassportAgence());//���հ䷢����
				phInfo.setPassportCityCC(wteInfo.getPassportCityC());//����ǩ���أ����ģ�
				phInfo.setPassportCityF(wteInfo.getPassportCityF());//����ǩ���أ�ƴ����
				phInfo.setQuProf(wteInfo.getQuProf());//ָ�깤��(����)
				phInfo.setQuprofF(wteInfo.getQuProff());//ָ�깤��(����)
				phInfo.setQualDate(wteInfo.getQualDate());//˫��֤���ʱ��
				phInfo.setAuthType(wteInfo.getAuthType());//��֤��֤����
				phInfo.setPapSTime(wteInfo.getPapSTime());//�ݽ���������
				phInfo.setPType(wteInfo.getPType());//�Ͷ�֤����
				phInfo.setWPmtNum(wteInfo.getWPmtNum());//�Ͷ�֤��
				phInfo.setWPmtGTime(wteInfo.getWPmtGTime());//�Ͷ�֤��֤����
				phInfo.setLaboreffDate(wteInfo.getLaboreffDate());//�Ͷ�֤��Ч����
				phInfo.setWPmtSTime(wteInfo.getWPmtSTime());//�Ͷ�֤��֤����
				phInfo.setSPAfPerson(wteInfo.isSPAffPerson());//�Ͷ�֤����ǩ�ռ��ҿ���
				phInfo.setPmtProj(wteInfo.getPmtProj());//ָ����Ŀ
				phInfo.setWorkOrg(wteInfo.getWorkOrg());//������Ŀ
				phInfo.setOldPassport(wteInfo.getOldPassport());//�ɻ��պ���
				WorkPmtEntryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);
			}
		}
	}
	//���ͨ�����Ͷ�֤��ת��д����ס֤����
	protected void writeLivePermit(Context ctx, WkPmtTrnInfo info) throws BOSException, EASBizException{
		WkPmtTrnEntryCollection entryCol=info.getEntrys();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("wPmtNum");//�Ͷ�֤��
		sic.add("wPmtGTime");//�Ͷ�֤��֤����
		sic.add("laboreffDate");//�Ͷ�֤��Ч����
		sic.add("wPmtSTime");//�Ͷ�֤��֤����
		//sic.add("pmtProj");//ָ����Ŀ
		sic.add("workOrg");//������Ŀ
		sic.add("quProf");//ָ�깤��
		sic.add("prmtProf");//ָ�깤�ַ���
		sic.add("passpNum");//���պ���
		sic.add("passportIssueDate");//����ǩ������
		sic.add("passpExDate");//���յ�������
		sic.add("passportAgence");//���հ䷢����
		sic.add("passportCityC");//����ǩ���أ����ģ�
		sic.add("passportCityF");//����ǩ���أ�ƴ����
		sic.add("oldPassport");//�ɻ��պ���
		for(int i=0;i<entryCol.size();i++){
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
	    	WkPmtTrnEntryInfo wueInfo=entryCol.get(i);
	    	String id=info.getSourceBillId();
	    	String sourceEntryID=wueInfo.getSourceEntryID();
	    	//filter.getFilterItems().add(new FilterItemInfo("parent.sourceBillId",id));
			filter.getFilterItems().add(new FilterItemInfo("sourceEntryID",sourceEntryID));
			view.setFilter(filter);
			LivepermitEntryCollection col=LivepermitEntryFactory.getLocalInstance(ctx).getLivepermitEntryCollection(view);
			if(col!=null&& col.size()>0){
				LivepermitEntryInfo lpInfo=col.get(0);
				lpInfo.setPasspNum(wueInfo.getPasspNum());//���պ���
				lpInfo.setPassportIssueDate(wueInfo.getPassportIssueDate());//����ǩ������
				lpInfo.setPassportAgence(wueInfo.getPassportAgence());//���հ䷢����
				lpInfo.setPasspExDate(wueInfo.getPasspExDate());//���յ�������
				lpInfo.setPassportCityC(wueInfo.getPassportCityC());//����ǩ���أ����ģ�
				lpInfo.setPassportCityF(wueInfo.getPassportCityF());//����ǩ���أ�ƴ����
				lpInfo.setQuProf(wueInfo.getQuProf());//ָ�깤��
				lpInfo.setPrmtProf(wueInfo.getQuProff());//ָ�깤�ַ���
				lpInfo.setWPmtNum(wueInfo.getWPmtNum());//�Ͷ�֤��
				lpInfo.setWPmtGTime(wueInfo.getWPmtGTime());//�Ͷ�֤��֤ʱ��
				lpInfo.setLaboreffDate(wueInfo.getLaboreffDate());//�Ͷ�֤��Ч����
				lpInfo.setWPmtSTime(wueInfo.getWPmtSTime());//�Ͷ�֤��֤ʱ��
				//lpInfo.setPmtProj(wueInfo.getPmtProj());//ָ����Ŀ
				lpInfo.setWorkOrg(wueInfo.getWorkOrg());//������Ŀ
				lpInfo.setOldPassport(wueInfo.getOldPassport());//�ɻ��պ���
				LivepermitEntryFactory.getLocalInstance(ctx).updatePartial(lpInfo, sic);
			}
		}
	}
//	//��˲�ͨ�����ͷ�ָ��
//	protected void writeProjectWork(Context ctx,WkPmtTrnInfo info) throws EASBizException, BOSException {
//		WkPmtTrnEntryCollection entryCol=info.getEntrys();
//		for(int i=0;i<entryCol.size();i++){
//			WkPmtTrnEntryInfo wpInfo=entryCol.get(i);
//			String id=wpInfo.getHQuProf().getId().toString();
//			String id1=wpInfo.getQuProf().getId().toString();
//			checkProjectWork1(ctx,id);
//			checkProjectWork(ctx,id1);
//		}
//	}
	protected SelectorItemCollection getSelector(){
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("billSate");
			sic.add("number");
			sic.add("company.id");
			sic.add("entrys.*");
			sic.add("sourceBillId");
			return sic;
	}
}