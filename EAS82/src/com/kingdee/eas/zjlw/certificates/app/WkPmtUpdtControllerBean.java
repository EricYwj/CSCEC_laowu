package com.kingdee.eas.zjlw.certificates.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
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
import com.kingdee.eas.zjlw.certificates.LivepermitCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtInfo;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WkPmtUpdtControllerBean extends AbstractWkPmtUpdtControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.WkPmtUpdtControllerBean");
    // ����
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		WkPmtUpdtInfo accInfo = (WkPmtUpdtInfo) model;
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
    	WkPmtUpdtInfo accInfo = (WkPmtUpdtInfo) model;
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
    	WkPmtUpdtInfo info = (WkPmtUpdtInfo) getValue(ctx, pk, getSelector());

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
		writeLivePermit(ctx,info);
		
    }
    // ��˲�ͨ��
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		WkPmtUpdtInfo info = (WkPmtUpdtInfo) getValue(ctx, pk,getSelector());
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
		//writeWorkPmt1(ctx,info);
		
	}
	//���ͨ�����Ͷ�֤���·�д���Ͷ�֤����
	protected void writeWorkPmt(Context ctx,WkPmtUpdtInfo info) throws BOSException, EASBizException{
		WkPmtUpdtEntryCollection entryCol=info.getEntrys();
    	SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("papSTime");//�ݽ���������
		sic.add("pType");//�Ͷ�֤����
		sic.add("wPmtNum");//�Ͷ�֤��
		sic.add("wPmtGTime");//�Ͷ�֤��֤����
		sic.add("laboreffDate");//�Ͷ�֤��Ч����
		sic.add("wPmtSTime");//�Ͷ�֤��֤����
		sic.add("sPAfPerson");//�Ͷ�֤����ǩ�ռ��ҿ���
		sic.add("workOrg");//������Ŀ
		sic.add("passpNum");//���պ���
		sic.add("passportIssueDate");//����ǩ������
		sic.add("passpExDate");//���յ�������
		sic.add("passportAgence");//���հ䷢����
		sic.add("passportCityCC");//����ǩ���أ����ģ�
		sic.add("passportCityF");//����ǩ���أ�ƴ����
		sic.add("oldPassport");//�ɻ��պ���
		for(int i=0;i<entryCol.size();i++){
			WkPmtUpdtEntryInfo wueInfo=entryCol.get(i);
	    	EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
	    	//filter.getFilterItems().add(new FilterItemInfo("parent.sourceBillId",info.getSourceBillId()));
			filter.getFilterItems().add(new FilterItemInfo("id",wueInfo.getSourceEntryID()));
			filter.getFilterItems().add(new FilterItemInfo("parent.billSate",BillStateEnum.CHECKED));
			view.setFilter(filter);
			WorkPmtEntryCollection col = WorkPmtEntryFactory.getLocalInstance(ctx).getWorkPmtEntryCollection(view);
			if(col!=null&&col.size()>0){
				WorkPmtEntryInfo phInfo=col.get(0);
				phInfo.setPasspNum(wueInfo.getPasspNum());//���պ���
				phInfo.setPassportIssueDate(wueInfo.getPassportIssueDate());//����ǩ������
				phInfo.setPasspExDate(wueInfo.getPasspExDate());//���յ�������
				phInfo.setPassportAgence(wueInfo.getPassportAgence());//���հ䷢����
				phInfo.setPassportCityCC(wueInfo.getPassportCityC());//����ǩ���أ����ģ�
				phInfo.setPassportCityF(wueInfo.getPassportCityF());//����ǩ���أ�ƴ����
				phInfo.setPapSTime(wueInfo.getPapSTime());//�Ͷ�֤�ݽ���������
				phInfo.setPType(wueInfo.getPType());//�Ͷ�֤����
				phInfo.setWPmtNum(wueInfo.getWPmtNum());//�Ͷ�֤��
				phInfo.setWPmtGTime(wueInfo.getWPmtGTime());//�Ͷ�֤��֤����
				phInfo.setLaboreffDate(wueInfo.getLaboreffDate());//�Ͷ�֤��Ч����
				phInfo.setWPmtSTime(wueInfo.getWPmtSTime());//�Ͷ�֤��֤����
				phInfo.setSPAfPerson(wueInfo.isSPAfPerson());//�Ͷ�֤����ǩ�ռ��ҿ���
				phInfo.setWorkOrg(wueInfo.getWorkOrg());//������Ŀ
				phInfo.setOldPassport(wueInfo.getOldPassport());//�ɻ��պ���
				WorkPmtEntryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);
			}
		}
	}
	//���ͨ�����Ͷ�֤���·�д�� ��ס֤֤����
	protected void writeLivePermit(Context ctx, WkPmtUpdtInfo info) throws BOSException, EASBizException{
		WkPmtUpdtEntryCollection entryCol=info.getEntrys();
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("passpNum");//���պ���
		sic.add("passportIssueDate");//����ǩ������
		sic.add("passpExDate");//���յ�������
		sic.add("passportAgence");//���հ䷢����
		sic.add("passportCityC");//����ǩ���أ����ģ�
		sic.add("passportCityF");//����ǩ���أ�ƴ����
		sic.add("wPmtNum");//�Ͷ�֤��
		sic.add("wPmtGTime");//�Ͷ�֤��֤����
		sic.add("laboreffDate");//�Ͷ�֤��Ч����
		sic.add("wPmtSTime");//�Ͷ�֤��֤����
		sic.add("workOrg");//������Ŀ
		sic.add("oldPassport");//�ɻ��պ���
		for(int i=0;i<entryCol.size();i++){
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
	    	WkPmtUpdtEntryInfo wueInfo=entryCol.get(i);
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
				lpInfo.setPasspExDate(wueInfo.getPasspExDate());//���յ�������
				lpInfo.setPassportAgence(wueInfo.getPassportAgence());//���հ䷢����
				lpInfo.setPassportCityC(wueInfo.getPassportCityC());//����ǩ���أ����ģ�
				lpInfo.setPassportCityF(wueInfo.getPassportCityF());//����ǩ���أ�ƴ����
				lpInfo.setWPmtNum(wueInfo.getWPmtNum());//�Ͷ�֤��
				lpInfo.setWPmtGTime(wueInfo.getWPmtGTime());//�Ͷ�֤��֤ʱ��
				lpInfo.setLaboreffDate(wueInfo.getLaboreffDate());//�Ͷ�֤��Ч����
				lpInfo.setWPmtSTime(wueInfo.getWPmtSTime());//�Ͷ�֤��֤ʱ��
				lpInfo.setWorkOrg(wueInfo.getWorkOrg());//������Ŀ
				lpInfo.setOldPassport(wueInfo.getOldPassport());//�ɻ��պ���
				LivepermitEntryFactory.getLocalInstance(ctx).updatePartial(lpInfo, sic);
			}
		}
	}
	//��˲�ͨ������д�Ͷ�֤����ԭ�Ͷ�֤�������� -�Ͷ�֤�������ڡ�
//	protected void writeWorkPmt1(Context ctx,WkPmtUpdtInfo info) throws BOSException{
//		WkPmtUpdtEntryCollection entryCol=info.getEntrys();
//		EntityViewInfo view = new EntityViewInfo();
//    	FilterInfo filter = new FilterInfo();
//		for(int i=0;i<entryCol.size();i++){
//			WkPmtUpdtEntryInfo wueInfo=entryCol.get(i);
//			String idNum=wueInfo.getIdNum();
//			String passpNum=wueInfo.getPasspNum();
//			filter.getFilterItems().add(new FilterItemInfo("idNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passportNo",passpNum));
//			filter.setMaskString("#0 OR #1");
//			view.setFilter(filter);
//			WorkPmtEntryInfo phInfo = WorkPmtEntryFactory.getLocalInstance(ctx).getWorkPmtEntryCollection(view).get(0);
//			phInfo.setWPmtSTime(wueInfo.getWPmtSTime());
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