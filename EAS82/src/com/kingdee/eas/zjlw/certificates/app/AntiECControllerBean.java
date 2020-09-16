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
    
    // 保存
	protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		AntiECInfo accInfo = (AntiECInfo) model;
		/*AntiECEntryCollection col = accInfo.getEntrys();
		for (int i = 0; i < col.size(); i++) {
			//获取原分录
			/*AntiECEntryInfo etyInfo = col.get(i);
			String oldEtyId = etyInfo.getOldEtyId();
			if (oldEtyId != null && !"".equals(oldEtyId)) {
				AntiSignedEntryInfo asEtyInfo = AntiSignedEntryFactory.getLocalInstance(ctx).getAntiSignedEntryInfo(new ObjectUuidPK(oldEtyId));
				//原分录赋值
				asEtyInfo.setSendLaBuDate(etyInfo.getSendLaBuDate());//递交劳动局时间
				asEtyInfo.setLaborSignNo(etyInfo.getLaborSignNo());//劳动局返签号
				asEtyInfo.setAntiSgTime(etyInfo.getAntiSgTime());//返签生效时间
				asEtyInfo.setAntiEndTime(etyInfo.getAntiEndTime());//返签到期时间
				asEtyInfo.setOwnerSignDate(etyInfo.getOwnerSignDate());//业主签字完成时间
				asEtyInfo.setDocUpDate(etyInfo.getDocUpDate());//返签批件上传时间
				asEtyInfo.setAppAffiliated(etyInfo.isAppAffiliated());//返签申请签收件挂靠人
				asEtyInfo.setDocAffiliated(etyInfo.isDocAffiliated());//返签批件挂靠人
				asEtyInfo.setIsLogout(etyInfo.isIsLogout());//是否未交资料释放指标
				asEtyInfo.setLogoutReson(etyInfo.getLogoutReson());//未交资料理由
				asEtyInfo.setIsCancel(etyInfo.isIsCancel());//是否停办
				asEtyInfo.setCancelDate(etyInfo.getCancelDate());//停办时间
				asEtyInfo.setCancelReson(etyInfo.getCancelReson());//停办理由
				asEtyInfo.setRemark(etyInfo.getRemark());//备注*/
				//携带附件
				/**IBoAttchAsso boaFac = BoAttchAssoFactory.getLocalInstance(ctx);
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add("id");
				sic.add("attachment.id");
				EntityViewInfo view = new EntityViewInfo();
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("boID", etyInfo.getId().toString()));
				view.setFilter(filter);
				view.setSelector(sic);
				//根据现分录ID查询附件
				BoAttchAssoCollection boaCol =boaFac.getBoAttchAssoCollection(view);
				if(boaCol!=null && boaCol.size()>0){
					for(int j=0;j<boaCol.size();j++){
						BoAttchAssoInfo boaInfo = boaCol.get(j);
						//添加附件
						BoAttchAssoInfo newBoaInfo = new BoAttchAssoInfo();
						newBoaInfo.setId(BOSUuid.create(newBoaInfo.getBOSType()));
						newBoaInfo.setBoID(oldEtyId);//原分录id
						newBoaInfo.setAssoType("系统已有附件");//类型
						newBoaInfo.setAttachment(boaInfo.getAttachment());//附件
						newBoaInfo.setAssoBusObjType("99CE7B83");//关联业务对象的类型：离境分录BOSTYPE
						boaFac.addnew(newBoaInfo);
					}
				}
			}
		}*/
		return super._save(ctx, accInfo);
	}
}