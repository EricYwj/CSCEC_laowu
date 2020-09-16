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
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkFactory;
import com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo;
import com.kingdee.eas.zjlw.certificates.ExLivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.ExLivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.ExLivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.ExLivepermitInfo;
import com.kingdee.eas.zjlw.certificates.ExLivepermitCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.UplivePermitInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryCollection;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnEntryInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtTrnInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryFactory;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
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

public class ExLivepermitControllerBean extends AbstractExLivepermitControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.ExLivepermitControllerBean");
 // ����
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		ExLivepermitInfo accInfo = (ExLivepermitInfo) model;
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
    	ExLivepermitInfo accInfo = (ExLivepermitInfo) model;
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
    	ExLivepermitInfo info = (ExLivepermitInfo) getValue(ctx, pk, getSelector());

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
		//writePersonHis(ctx,info);
    }
 // ��˲�ͨ��
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		ExLivepermitInfo info = (ExLivepermitInfo) getValue(ctx, pk,getSelector());
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
	//��д��Ա��ʷ��Ϣ
//	protected void writePersonHis(Context ctx,ExLivepermitInfo info) throws BOSException, EASBizException {
//		ExLivepermitEntryCollection entryCol=info.getEntrys();
//		SelectorItemCollection sic = new SelectorItemCollection();
//		sic.add("permitOrg");//ָ����Ŀ
//		sic.add("workOrg");//������Ŀ
//		sic.add("permitProfession");//ָ�깤��
//    	EntityViewInfo view = new EntityViewInfo();
//    	FilterInfo filter = new FilterInfo();
//		for(int i=0;i<entryCol.size();i++){
//			ExLivepermitEntryInfo wpInfo=entryCol.get(i);
//			String idNum=wpInfo.getIdNum();
//			String passpNum=wpInfo.getPasspNum();
//			filter.getFilterItems().add(new FilterItemInfo("idNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passportNo",passpNum));
////			filter.setMaskString("#0 OR #1");
//			view.setFilter(filter);
//			PersonHistoryCollection col = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
//			if(col!=null&&col.size()>0 ){
//				PersonHistoryInfo phInfo=col.get(i);
//				if(wpInfo.getHquProf()!=null){
//					if(wpInfo.getQuProf().equals(wpInfo.getHquProf())){
//					}
//					if(!wpInfo.getQuProf().equals(wpInfo.getHquProf())){
//						if(wpInfo.getHquProf()!=null){
//							//String id=wpInfo.getHquProf().getId().toString();
//							//checkProjectWork(ctx,id);
//						}
//						phInfo.setPermitOrg(wpInfo.getPmtProj());//ָ����Ŀ
//						phInfo.setWorkOrg(wpInfo.getPmtProj());//������Ŀ
//						phInfo.setPermitProfession(wpInfo.getQuProf());//ָ�깤��
//						PersonHistoryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);
//						//String id1=wpInfo.getQuProf().getId().toString();
//						//checkProjectWork1(ctx,id1);
//					}
//				}
//			}
//		}		
//	}
//	//���ͨ�����ͷ�ָ�깤��ָ��
//	private void checkProjectWork(Context ctx, String id)throws EASBizException, BOSException {
//			SelectorItemCollection sic = new SelectorItemCollection();
//			sic.add("useAmount");
//			sic.add("leftAmount");
//			sic.add("totalAmount");
//			if (id != null && !"".equals(id)) {
//				ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx).getProjectWorkInfo(new ObjectUuidPK(id), sic);
//					pwInfo.setUseAmount(pwInfo.getUseAmount() - 1);
//					ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
//			}
//     }
//	//���ͨ�����ͷ�ָ�깤��ָ��
//	private void checkProjectWork1(Context ctx, String id)throws EASBizException, BOSException {
//			SelectorItemCollection sic = new SelectorItemCollection();
//			sic.add("useAmount");
//			sic.add("leftAmount");
//			sic.add("totalAmount");
//			if (id != null && !"".equals(id)) {
//				ProjectWorkInfo pwInfo = ProjectWorkFactory.getLocalInstance(ctx).getProjectWorkInfo(new ObjectUuidPK(id), sic);
//					pwInfo.setUseAmount(pwInfo.getUseAmount() +1);
//					ProjectWorkFactory.getLocalInstance(ctx).updatePartial(pwInfo, sic);
//			}
//     }
	//���ͨ������ס֤��ת��д����ס֤����
	protected void writeWorkPmt(Context ctx,ExLivepermitInfo info) throws BOSException, EASBizException{
		ExLivepermitEntryCollection entryCol=info.getEntrys();
		
    	SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("pmtProj");//ָ����Ŀ
		sic.add("workOrg");//������Ŀ
		sic.add("quProf");//ָ�깤��
		sic.add("prmtProf");//ָ�깤�ַ���
		for(int i=0;i<entryCol.size();i++){
			ExLivepermitEntryInfo elInfo=entryCol.get(i);
			EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
//			String idNum=elInfo.getIdNum();
//			String passpNum=elInfo.getPasspNum();
//			String number=info.getNumber();
//			filter.getFilterItems().add(new FilterItemInfo("IdNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passpNum",passpNum));
//			filter.getFilterItems().add(new FilterItemInfo("parent.number",number));
	    	filter.getFilterItems().add(new FilterItemInfo("id",elInfo.getSourceEntryID()));
			view.setFilter(filter);
			LivepermitEntryCollection col = LivepermitEntryFactory.getLocalInstance(ctx).getLivepermitEntryCollection(view);
			if(col!=null&&col.size()>0){
				LivepermitEntryInfo phInfo=col.get(0);
				phInfo.setPmtProj(elInfo.getPmtProj());//ָ����Ŀ
				phInfo.setWorkOrg(elInfo.getHworkOrg());//������Ŀ
				//phInfo.setQuProf(elInfo.getQuProf());//ָ�깤��
				//phInfo.setPrmtProf(elInfo.getPrmtProf());//ָ�깤��(����)
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