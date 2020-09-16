package com.kingdee.eas.zjlw.certificates.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;

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

import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.zjlw.certificates.LeaveManageEntryInfo;
import com.kingdee.eas.zjlw.certificates.LeaveManageFactory;
import com.kingdee.eas.zjlw.certificates.LeaveManageInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryCollection;
import com.kingdee.eas.zjlw.certificates.LivepermitEntryInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitFactory;
import com.kingdee.eas.zjlw.certificates.LivepermitInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.LivepermitCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryCollection;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryFactory;
import com.kingdee.eas.zjlw.personinfo.PersonHistoryInfo;
import com.kingdee.eas.zjlw.personmess.WorkVisaInfo;
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

public class LivepermitControllerBean extends AbstractLivepermitControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.LivepermitControllerBean");

    // ����
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		LivepermitInfo accInfo = (LivepermitInfo) model;
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
    protected IObjectPK _submit(Context ctx, IObjectValue model)throws BOSException, EASBizException {
    	LivepermitInfo accInfo = (LivepermitInfo) model;
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
    protected void _passAudit(Context ctx, IObjectPK pk, IObjectValue model)throws EASBizException, BOSException {
    	LivepermitInfo info = (LivepermitInfo) getValue(ctx, pk, getSelector());

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
		writeHistory(ctx,info,true);
		writeLeaveManage(ctx,info);
		
    }
    // ��˲�ͨ��
	protected void _unpassAudit(Context ctx, IObjectPK pk, IObjectValue model)
			throws EASBizException, BOSException {
		LivepermitInfo info = (LivepermitInfo) getValue(ctx, pk,getSelector());
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
		writeHistory(ctx,info,false);
		deleteLeaveManage(ctx,info);
	}
	//��д��Ա��ʷ��Ϣ
	private void writeHistory(Context ctx, LivepermitInfo info,boolean isAudit) throws BOSException, EASBizException{
		LivepermitEntryCollection entryCol=info.getEntrys();
    	EntityViewInfo view = new EntityViewInfo();
    	FilterInfo filter = new FilterInfo();
    	SelectorItemCollection sic = new SelectorItemCollection();
    	sic.add("bsnisState");
    	sic.add("hBsnisState");
		for(int i=0;i<entryCol.size();i++){
			LivepermitEntryInfo wpInfo=entryCol.get(i);
			String idNum=wpInfo.getIdNum();
			String passpNum=wpInfo.getPasspNum();
			String number=info.getNumber();
//			filter.getFilterItems().add(new FilterItemInfo("idNum",idNum));
//			filter.getFilterItems().add(new FilterItemInfo("passportNo",passpNum));
			filter.getFilterItems().add(new FilterItemInfo("sourceBillId",wpInfo.getPersonID()));
//			filter.setMaskString("#0 OR #1");
			view.setFilter(filter);
		    Boolean departure=wpInfo.isDeparture();
			Boolean isStop=wpInfo.isIsStop();
			PersonHistoryCollection col = PersonHistoryFactory.getLocalInstance(ctx).getPersonHistoryCollection(view);
			if(col!=null&&col.size()>0){
				PersonHistoryInfo phInfo=col.get(0);
				if(isAudit){
					//phInfo.setHBsnisState(phInfo.getBsnisState());
					phInfo.setBsnisState(perBizStateEnum.RESIDENCE);
				}else{
					phInfo.setBsnisState(perBizStateEnum.WORKPERMIT);
				}
				PersonHistoryFactory.getLocalInstance(ctx).updatePartial(phInfo, sic);
			}
			
		}
	}
	//�Ƿ��뾳���ֶ���ѡ�����ͨ����д���뾳���ݡ�
	private void writeLeaveManage(Context ctx, LivepermitInfo info) throws EASBizException, BOSException{
		//LeaveManageInfo lmInfo = new LeaveManageInfo();
		LivepermitEntryCollection  entryCol = info.getEntrys();
		for(int i=0;i<entryCol.size();i++){
			LeaveManageInfo lmInfo = new LeaveManageInfo();
		    LivepermitEntryInfo entryInfo = entryCol.get(i);
		    Boolean departure=entryInfo.isDeparture();
		    Boolean isStop=entryInfo.isIsStop();
		    if(departure||isStop){
			    //��ͷ
				lmInfo.setId(BOSUuid.create(lmInfo.getBOSType()));
				lmInfo.setSourceBillId(info.getId().toString());
				lmInfo.setNumber(info.getNumber());
				lmInfo.setBNum(info.getBNum());
				lmInfo.setBizDate(new Date());
				lmInfo.setBillSate(BillStateEnum.DRAFT);
				// ����
				// ��ӷ�¼
				LeaveManageEntryInfo lmEntryInfo=new LeaveManageEntryInfo();
				lmEntryInfo.setId(BOSUuid.create(lmEntryInfo.getBOSType()));	
				lmEntryInfo.setName(entryInfo.getName());//����
				lmEntryInfo.setSex(entryInfo.getSex());//�Ա�
				lmEntryInfo.setLastName(entryInfo.getLastName());//��ƴ��
				lmEntryInfo.setFirstName(entryInfo.getFirstName());//��ƴ��
				lmEntryInfo.setNatioNal(entryInfo.getNation());//����
				lmEntryInfo.setBirthday(entryInfo.getBirth());//����
				lmEntryInfo.setIdNum(entryInfo.getIdNum());//���֤��
				lmEntryInfo.setPasspNum(entryInfo.getPasspNum());//���պ�
				lmEntryInfo.setBirthPlaceCn(entryInfo.getBirthPlace());//����������
				lmEntryInfo.setBirthPlaceFr(entryInfo.getBirthPlaceFr());//�����ط���
				lmEntryInfo.setPasspIsDate(entryInfo.getPassportIssueDate());//����ǩ������
				lmEntryInfo.setPasspExDate(entryInfo.getPasspExDate());//���յ�������
				lmEntryInfo.setFatherName(entryInfo.getFatherName());//��������
				lmEntryInfo.setFatherNameAl(entryInfo.getFatherNameAlphabet());//��������ƴ��
				lmEntryInfo.setMotherName(entryInfo.getMotherName());//ĸ������
				lmEntryInfo.setMotherNameAl(entryInfo.getMotherNameAlphabet());//ĸ������ƴ��
				lmEntryInfo.setMaritalStatus(entryInfo.getMaritalStatus());//����״��
				lmEntryInfo.setWPmtNum(entryInfo.getWPmtNum());//�Ͷ�֤��
				lmEntryInfo.setImmiTime(entryInfo.getImmiTime());//�밢ʱ��
				lmEntryInfo.setWPmtSTime(entryInfo.getWPmtSTime());//�Ͷ�֤����ʱ��
				lmEntryInfo.setQuProf(entryInfo.getQuProf());//ָ�깤��
				lmEntryInfo.setQuproff(entryInfo.getPrmtProf());//ָ�깤�֣����ģ�
				lmEntryInfo.setActProff(entryInfo.getActProf());//ʵ�ʹ���
				lmEntryInfo.setPmtProj(entryInfo.getPmtProj());//ָ����Ŀ
				lmEntryInfo.setTaskProj(entryInfo.getWorkOrg());//������Ŀ
				lmEntryInfo.setCooperation(entryInfo.getCooperation());//������λ
				lmEntryInfo.setDocType(entryInfo.getDocType());//��ס֤����
				lmEntryInfo.setRePmtNum(null==entryInfo.getRePmtNum()?null:entryInfo.getRePmtNum());//��ʱ��ס֤����
				lmEntryInfo.setRePmtETime(null==entryInfo.getRePmtETime()?null:entryInfo.getRePmtETime());//��ʱ��ס֤��֤����
				lmEntryInfo.setPmtNum(null==entryInfo.getPmtNum()?null:entryInfo.getPmtNum());//��ʽ��ס֤��
				lmEntryInfo.setPmteffDate(null==entryInfo.getPmteffDate()?null:entryInfo.getPmteffDate());//��ʽ��ס֤��Ч����
				lmEntryInfo.setPmtETime(null==entryInfo.getPmtETime()?null:entryInfo.getPmtETime());//��ʽ��ס֤��ס֤��������
				lmEntryInfo.setPersonID(entryInfo.getPersonID());//��Ա����
				lmEntryInfo.setSourceEntryID(entryInfo.getId().toString());//��Դ��¼
				//lmEntryInfo.setRemark(entryInfo.getRemark());//��ע
				if(departure){
					lmEntryInfo.setLeaveType(leaveTypeEnum.LEAVENO);//�Ƿ��뾳��״̬Ϊ��ס֤δ�죡
				}
				if(isStop){
					lmEntryInfo.setLeaveType(leaveTypeEnum.LEAVESTOP);//�Ƿ�ͣ�죬״̬Ϊ��ס֤ͣ�죡
					//lmEntryInfo.setDptrGTime(entryInfo.getEndTime());//ͣ��ʱ��
				}
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
					for(int j=0;j<boaCol.size();j++){
						BoAttchAssoInfo boaInfo = boaCol.get(j);
						//��Ӹ���
						BoAttchAssoInfo newBoaInfo = new BoAttchAssoInfo();
						newBoaInfo.setId(BOSUuid.create(newBoaInfo.getBOSType()));
						newBoaInfo.setBoID(lmEntryInfo.getId().toString());//ҵ��ID���뾳��¼ID
						newBoaInfo.setAssoType("ϵͳ���и���");//����
						newBoaInfo.setAttachment(boaInfo.getAttachment());//����
						newBoaInfo.setAssoBusObjType("3D062727");//����ҵ���������ͣ��뾳��¼BOSTYPE
						boaFac.addnew(newBoaInfo);
					}
				}
				lmInfo.getEntrys().add(lmEntryInfo);
				LeaveManageFactory.getLocalInstance(ctx).addnew(lmInfo);
		    }
	   }		
	}
	//����ˣ�ɾ���뾳�е�����
	protected void deleteLeaveManage(Context ctx, LivepermitInfo info) throws EASBizException, BOSException{
		LivepermitEntryCollection  entryCol = info.getEntrys();
		for(int i=0;i<entryCol.size();i++){
			LivepermitEntryInfo entryInfo = entryCol.get(i);
		    EntityViewInfo view = new EntityViewInfo();
	    	FilterInfo filter = new FilterInfo();
		    Boolean departure=entryInfo.isDeparture();
		    Boolean isStop=entryInfo.isIsStop();
		    String id=info.getId().toString();
		    filter.getFilterItems().add(new FilterItemInfo("sourceBillId",id,CompareType.EQUALS));
		    view.setFilter(filter);
			LeaveManageInfo phInfo = LeaveManageFactory.getLocalInstance(ctx).getLeaveManageCollection(view).get(0);
		    if(phInfo!=null&&(departure||isStop)){
		    	LeaveManageFactory.getLocalInstance(ctx).delete(filter);
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