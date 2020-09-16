package com.kingdee.eas.zjlw.baseinfo.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
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

import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.zjlw.baseinfo.BlackListInfo;
import com.kingdee.eas.zjlw.baseinfo.LocalBlackListCollection;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;

import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.zjlw.baseinfo.LocalBlackListInfo;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LocalBlackListControllerBean extends AbstractLocalBlackListControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.baseinfo.app.LocalBlackListControllerBean");
  //Ω˚”√
    protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
    		throws BOSException, EASBizException {
    	LocalBlackListInfo info = (LocalBlackListInfo) getValue(ctx, pk,getSelector());
		FilterInfo filter = new FilterInfo();
		IObjectPK logPK = LogUtil.beginLog(ctx, "_cancel", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("isDisable");
		sic.add("disableTime");
		info.setIsDisable(true);
		info.setDisableTime(new Date());
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
    	//super._cancel(ctx, pk, model);
		
    }
    
    
    //∆Ù”√
    protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
    		throws BOSException, EASBizException {
    	LocalBlackListInfo info = (LocalBlackListInfo) getValue(ctx, pk,getSelector());
		FilterInfo filter = new FilterInfo();
		IObjectPK logPK = LogUtil.beginLog(ctx, "_cancel", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("isDisable");
		sic.add("disableTime");
		info.setIsDisable(false);
		info.setDisableTime(null);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
    	//super._cancelCancel(ctx, pk, model);
    }
    protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("isDisable");
		sic.add("disableTime");
		sic.add("number");
		sic.add("id");

		return sic;
	}
}