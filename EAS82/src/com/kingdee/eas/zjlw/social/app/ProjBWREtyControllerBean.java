package com.kingdee.eas.zjlw.social.app;

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
import com.kingdee.eas.zjlw.certificates.app.BillStateEnum;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection;
import com.kingdee.eas.zjlw.personmess.WorkVisaEntryInfo;
import com.kingdee.eas.zjlw.social.ForiPayrollInfo;
import com.kingdee.eas.zjlw.social.ProjBWRAssdCollection;
import com.kingdee.eas.zjlw.social.ProjBWRAssdFactory;
import com.kingdee.eas.zjlw.social.ProjBWRAssdInfo;
import com.kingdee.eas.zjlw.social.ProjBWREtyCollection;
import com.kingdee.eas.zjlw.social.ProjBWREtyEntryCollection;
import com.kingdee.eas.zjlw.social.ProjBWREtyEntryInfo;
import com.kingdee.eas.zjlw.social.ProjBWREtyFactory;
import com.kingdee.eas.zjlw.social.SecuSplitCollection;
import com.kingdee.eas.zjlw.social.SecuSplitFactory;
import com.kingdee.eas.zjlw.social.SecuSplitInfo;
import com.kingdee.eas.zjlw.social.VabaweatherInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.zjlw.social.ProjBWREtyInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ProjBWREtyControllerBean extends AbstractProjBWREtyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.social.app.ProjBWREtyControllerBean");
  //�ύ 
    protected IObjectPK _submit(Context ctx, IObjectValue model)
    throws BOSException, EASBizException {
    	ProjBWREtyInfo accInfo = (ProjBWREtyInfo) model;
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
    
    /**
     * ���ͨ��
     */
    protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
    	ProjBWREtyInfo info = (ProjBWREtyInfo) getValue(ctx, pk, getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_audit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("*");
		sic.add("auditor");
		sic.add("AuditDate");
		info.setBillSate(BillStateEnum.CHECKED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditDate(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		dealAll(ctx,info,true);
    }
	/**
	 * ��˲�ͨ��
	 */
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
		ProjBWREtyInfo info = (ProjBWREtyInfo) getValue(ctx, pk,getSelector());
		IObjectPK logPK = LogUtil.beginLog(ctx, "_unAudit", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("auditor");
		sic.add("AuditDate");
		info.setBillSate(BillStateEnum.SUBMIT);
		info.setAuditor(null);
		info.setAuditDate(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
		dealAll(ctx,info,false);
	}
	public void dealAll(Context ctx, ProjBWREtyInfo info, boolean audit) throws BOSException, EASBizException {
		//���ɶ�������������̯��
		initBlankSecuSplit(ctx, info,audit);
//		dealSecuSplit(ctx, info,audit);
	}
	private void initBlankSecuSplit(Context ctx, ProjBWREtyInfo info, boolean audit) throws BOSException, EASBizException {
		//��˻����
   		if (audit) {
			//��ˣ����ɷ�̯��
//   			if (!isSecuSplit(ctx,info)) {//�޷�̯������
   				AdminOrgUnitInfo Proj = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(info.getProjName()==null?null:info.getProjName().getId()));
   				ProjBWRAssdInfo ssInfo = new ProjBWRAssdInfo();
   				ssInfo.setId(BOSUuid.create(ssInfo.getBOSType()));
   				ssInfo.setSourceBillId(info.getId().toString());
   				ssInfo.setNumber(info.getNumber());//���ݱ��
   				ssInfo.setBillSate(BillStateEnum.DRAFT);//����״̬
   				ssInfo.setBizDate(new Date());//ҵ������
   				ssInfo.setProjName(Proj);//��Ŀ
   				ssInfo.setProjSoclNum(info.getProjSoclNum());//��Ŀ�籣��
   				ssInfo.setStopDate(info.getStopDate());//ͣ������
   				ssInfo.setRetToWorkDate(info.getRetToWorkDate());//��������
   				ssInfo.setDownTimeHours(info.getDownTimeHours());//ͣ��Сʱ��
   				ssInfo.setStoppageBy(info.getStoppageBy());//ͣ������
   				ProjBWRAssdFactory.getLocalInstance(ctx).addnew(ssInfo);
//   			}
		}else{
			//����ˣ�ɾ��
//			Set set = new HashSet();
//			EntityViewInfo view = new EntityViewInfo();
//			FilterInfo filter = new FilterInfo();
//			ProjBWREtyEntryCollection entryCol = info.getEntrys();
//			for (int i = 0; i < entryCol.size(); i++) {
//				ProjBWREtyEntryInfo entryInfo = entryCol.get(i);
//				String id = entryInfo.getId().toString();
//				set.add(id);
//				filter.getFilterItems().add(new FilterItemInfo("sourceI", set, CompareType.INCLUDE));
//				ProjBWRAssdFactory.getLocalInstance(ctx).delete(filter);
//			}
			FilterInfo filter = new FilterInfo();
			AdminOrgUnitInfo Proj = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(info.getProjName()==null?null:info.getProjName().getId()));
			filter.getFilterItems().add(new FilterItemInfo("sourceBillId",info.getId().toString()));
			ProjBWRAssdFactory.getLocalInstance(ctx).delete(filter);
		}
		
	}
	private boolean isSecuSplit(Context ctx, ProjBWREtyInfo info) throws BOSException {
		AdminOrgUnitInfo  proj = info.getProjName();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("projName.name",proj==null?null:proj.getName()));
		EntityViewInfo view = new EntityViewInfo();
		view.setFilter(filter);
		ProjBWRAssdCollection  ssCol = ProjBWRAssdFactory.getLocalInstance(ctx).getProjBWRAssdCollection(view);
		if (ssCol.size()>0) {
			return true;
		}else{
			return false;
		}
	}
	protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("billSate");
		sic.add("number");
		sic.add("projName");
		//sic.add("sourceBillId");
		sic.add("*");
		sic.add("entrys.*");
		return sic;
	}
}