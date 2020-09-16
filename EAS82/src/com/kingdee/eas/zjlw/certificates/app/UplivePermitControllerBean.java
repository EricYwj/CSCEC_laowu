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
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitFactory;
import com.kingdee.eas.zjlw.certificates.UplivePermitCollection;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.UplivePermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.UplivePermitInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtUpdtInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
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
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class UplivePermitControllerBean extends AbstractUplivePermitControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.UplivePermitControllerBean");
 // ����
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		UplivePermitInfo accInfo = (UplivePermitInfo) model;
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
    	UplivePermitInfo accInfo = (UplivePermitInfo) model;
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
    	UplivePermitInfo info = (UplivePermitInfo) getValue(ctx, pk, getSelector());

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
		writeLivepermit(ctx,info);
    }
 // ��˲�ͨ��
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		UplivePermitInfo info = (UplivePermitInfo) getValue(ctx, pk,getSelector());
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
	//���ͨ������ס֤���·�д����ס֤����
	protected void writeLivepermit(Context ctx,UplivePermitInfo info) throws BOSException, EASBizException{
		UplivePermitEntryCollection entryCol=info.getEntrys();
    	SelectorItemCollection sic = new SelectorItemCollection();
    	sic.add("passpNum");//���պ���
    	sic.add("passportIssueDate");//����ǩ������
    	sic.add("passpExDate");//���յ�������
    	sic.add("passportAgence");//���հ䷢����
    	sic.add("passportCityC");//����ǩ���أ����ģ�
    	sic.add("passportCityF");//����ǩ���أ�ƴ����
		sic.add("papSTime");//��ס֤�ݽ���������
		sic.add("docType");//֤������
		sic.add("rePmtNum");//�پӺ���
		sic.add("sRePmtSTime");//��ʱ��ס֤��������
		sic.add("rePmtETime");//��ʱ��ס֤��֤����
		sic.add("pmtSTime");//��ʽ��ס֤��֤����
		sic.add("pmtNum");//��ʽ��ס֤����
		sic.add("pmtETime");//��ʽ��ס֤��������
		sic.add("pmteffDate");//��ʽ��ס֤��Ч����
		sic.add("workOrg");//������Ŀ
		for(int i=0;i<entryCol.size();i++){
			UplivePermitEntryInfo upInfo=entryCol.get(i);
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
//			String idNum=upInfo.getIdNum();
//			String passpNum=upInfo.getPasspNum();
//			String number=info.getNumber();
//			filter.getFilterItems().add(new FilterItemInfo("IdNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passpNum",passpNum));
//			filter.getFilterItems().add(new FilterItemInfo("parent.number",number));
			filter.getFilterItems().add(new FilterItemInfo("id",upInfo.getSourceEntryID()));
			view.setFilter(filter);
			LivepermitEntryCollection col = LivepermitEntryFactory.getLocalInstance(ctx).getLivepermitEntryCollection(view);
			if(col!=null&&col.size()>0){
				LivepermitEntryInfo phInfo=col.get(0);
	    		phInfo.setDocType(upInfo.getDocType());//֤������
	    		phInfo.setPasspNum(upInfo.getPasspNum());//���պ���
	    		phInfo.setPassportIssueDate(upInfo.getPassportIssueDate());//����ǩ������
	    		phInfo.setPasspExDate(upInfo.getPasspExDate());//���յ�������
	    		phInfo.setPassportAgence(upInfo.getPassportAgence());//���հ䷢����
	    		phInfo.setPassportCityC(upInfo.getPassportCityC());//����ǩ���أ����ģ�
	    		phInfo.setPassportCityF(upInfo.getPassportCityF());//����ǩ���أ�ƴ����
	    		phInfo.setWorkOrg(upInfo.getWorkOrg());//������Ŀ
	    		phInfo.setPapSTime(upInfo.getPapSTime());//��ס֤�ݽ���������
	    		phInfo.setRePmtNum(upInfo.getRePmtNum());//�پӺ���
    			phInfo.setSRePmtSTime(upInfo.getSRePmtSTime());//��ʱ��ס֤��������
				phInfo.setRePmtETime(upInfo.getRePmtETime());//��ʱ��ס֤��֤����
				phInfo.setPmtNum(upInfo.getPmtNum());//��ʽ��ס֤����
				phInfo.setPmtSTime(upInfo.getPmtSTime());//���ӵ�������
				phInfo.setPmteffDate(upInfo.getPmteffDate());//��ʽ��ס֤��Ч����
				phInfo.setPmtETime(upInfo.getPmtETime());//���ӵ�������
				LivepermitEntryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);	
			}
		}
	}
	protected SelectorItemCollection getSelector(){
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("company.id");
		sic.add("entrys.*");
		return sic;
	
    }
	
}