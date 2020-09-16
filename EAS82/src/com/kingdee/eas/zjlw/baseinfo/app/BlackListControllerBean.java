package com.kingdee.eas.zjlw.baseinfo.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
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
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.zjlw.baseinfo.BlackListCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BlackListControllerBean extends AbstractBlackListControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.zjlw.baseinfo.app.BlackListControllerBean");
    
    //����
    protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
    		throws BOSException, EASBizException {
    	BlackListInfo info = (BlackListInfo) getValue(ctx, pk,getSelector());
		FilterInfo filter = new FilterInfo();
		//filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
//		if (super._exists(ctx, filter)) {
//			throw new blackListExceptio(EcBillException.HAS_AUDITED,
//					new Object[] { info.getNumber() });
//		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_cancel", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("isEffect");
		info.setIsEffect(false);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
    	//super._cancel(ctx, pk, model);
		
    }
    
    
    //����
    protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
    		throws BOSException, EASBizException {
    	BlackListInfo info = (BlackListInfo) getValue(ctx, pk,getSelector());
		FilterInfo filter = new FilterInfo();
		//filter.getFilterItems().add(new FilterItemInfo("id", pk.toString()));
//		if (super._exists(ctx, filter)) {
//			throw new blackListExceptio(EcBillException.HAS_AUDITED,
//					new Object[] { info.getNumber() });
//		}
		IObjectPK logPK = LogUtil.beginLog(ctx, "_cancel", info.getBOSType(),pk, info.getNumber());
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("isEffect");
		info.setIsEffect(true);
		updatePartial(ctx, info, sic);
		LogUtil.afterLog(ctx, logPK);
    	//super._cancelCancel(ctx, pk, model);
    }
    protected SelectorItemCollection getSelector() {
		SelectorItemCollection sic = new SelectorItemCollection();
		sic.add("isEffect");
		sic.add("number");
		sic.add("id");

		return sic;
	}
}