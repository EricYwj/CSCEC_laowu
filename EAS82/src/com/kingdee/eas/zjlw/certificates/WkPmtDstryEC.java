package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WkPmtDstryEC extends CoreBillBase implements IWkPmtDstryEC
{
    public WkPmtDstryEC()
    {
        super();
        registerInterface(IWkPmtDstryEC.class, this);
    }
    public WkPmtDstryEC(Context ctx)
    {
        super(ctx);
        registerInterface(IWkPmtDstryEC.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A083F118");
    }
    private WkPmtDstryECController getController() throws BOSException
    {
        return (WkPmtDstryECController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WkPmtDstryECCollection getWkPmtDstryECCollection() throws BOSException
    {
        try {
            return getController().getWkPmtDstryECCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public WkPmtDstryECCollection getWkPmtDstryECCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWkPmtDstryECCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public WkPmtDstryECCollection getWkPmtDstryECCollection(String oql) throws BOSException
    {
        try {
            return getController().getWkPmtDstryECCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WkPmtDstryECInfo getWkPmtDstryECInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtDstryECInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public WkPmtDstryECInfo getWkPmtDstryECInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtDstryECInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public WkPmtDstryECInfo getWkPmtDstryECInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtDstryECInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}