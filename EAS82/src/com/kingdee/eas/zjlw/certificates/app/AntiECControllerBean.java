package com.kingdee.eas.zjlw.certificates.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.metadata.IMetaDataPK;
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
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.zjlw.certificates.AntiECEntryCollection;
import com.kingdee.eas.zjlw.certificates.AntiECEntryInfo;
import com.kingdee.eas.zjlw.certificates.AntiECInfo;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryFactory;
import com.kingdee.eas.zjlw.certificates.AntiSignedEntryInfo;
import com.kingdee.eas.zjlw.certificates.WorkPmtInfo;

import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.zjlw.certificates.AntiECCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoInfo;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AntiECControllerBean extends AbstractAntiECControllerBean
{
    private static Logger logger =  Logger.getLogger("com.kingdee.eas.zjlw.certificates.app.AntiECControllerBean");
    
    // ����
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		AntiECInfo accInfo = (AntiECInfo) model;
		/*AntiECEntryCollection col = accInfo.getEntrys();
		for (int i = 0; i < col.size(); i++) {
			//��ȡԭ��¼
			/*AntiECEntryInfo etyInfo = col.get(i);
			String oldEtyId = etyInfo.getOldEtyId();
			if (oldEtyId != null && !"".equals(oldEtyId)) {
				AntiSignedEntryInfo asEtyInfo = AntiSignedEntryFactory.getLocalInstance(ctx).getAntiSignedEntryInfo(new ObjectUuidPK(oldEtyId));
				//ԭ��¼��ֵ
				asEtyInfo.setSendLaBuDate(etyInfo.getSendLaBuDate());//�ݽ��Ͷ���ʱ��
				asEtyInfo.setLaborSignNo(etyInfo.getLaborSignNo());//�Ͷ��ַ�ǩ��
				asEtyInfo.setAntiSgTime(etyInfo.getAntiSgTime());//��ǩ��Чʱ��
				asEtyInfo.setAntiEndTime(etyInfo.getAntiEndTime());//��ǩ����ʱ��
				asEtyInfo.setOwnerSignDate(etyInfo.getOwnerSignDate());//ҵ��ǩ�����ʱ��
				asEtyInfo.setDocUpDate(etyInfo.getDocUpDate());//��ǩ�����ϴ�ʱ��
				asEtyInfo.setAppAffiliated(etyInfo.isAppAffiliated());//��ǩ����ǩ�ռ��ҿ���
				asEtyInfo.setDocAffiliated(etyInfo.isDocAffiliated());//��ǩ�����ҿ���
				asEtyInfo.setIsLogout(etyInfo.isIsLogout());//�Ƿ�δ�������ͷ�ָ��
				asEtyInfo.setLogoutReson(etyInfo.getLogoutReson());//δ����������
				asEtyInfo.setIsCancel(etyInfo.isIsCancel());//�Ƿ�ͣ��
				asEtyInfo.setCancelDate(etyInfo.getCancelDate());//ͣ��ʱ��
				asEtyInfo.setCancelReson(etyInfo.getCancelReson());//ͣ������
				asEtyInfo.setRemark(etyInfo.getRemark());//��ע*/
				//Я������
				/**IBoAttchAsso boaFac = BoAttchAssoFactory.getLocalInstance(ctx);
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("id");
				sic.add("attachment.id");
				EntityViewInfo view = new EntityViewInfo();
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("boID", etyInfo.getId().toString()));
				view.setFilter(filter);
				view.setSelector(sic);
				//�����ַ�¼ID��ѯ����
				BoAttchAssoCollection boaCol =boaFac.getBoAttchAssoCollection(view);
				if(boaCol!=null && boaCol.size()>0){
					for(int j=0;j<boaCol.size();j++){
						BoAttchAssoInfo boaInfo = boaCol.get(j);
						//��Ӹ���
						BoAttchAssoInfo newBoaInfo = new BoAttchAssoInfo();
						newBoaInfo.setId(BOSUuid.create(newBoaInfo.getBOSType()));
						newBoaInfo.setBoID(oldEtyId);//ԭ��¼id
						newBoaInfo.setAssoType("ϵͳ���и���");//����
						newBoaInfo.setAttachment(boaInfo.getAttachment());//����
						newBoaInfo.setAssoBusObjType("99CE7B83");//����ҵ���������ͣ��뾳��¼BOSTYPE
						boaFac.addnew(newBoaInfo);
					}
				}
			}
		}*/
		return super._save(ctx, accInfo);
	}
}