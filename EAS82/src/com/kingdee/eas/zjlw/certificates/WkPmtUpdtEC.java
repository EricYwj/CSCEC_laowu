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

public class WkPmtUpdtEC extends CoreBillBase implements IWkPmtUpdtEC
{
    public WkPmtUpdtEC()
    {
        super();
        registerInterface(IWkPmtUpdtEC.class, this);
    }
    public WkPmtUpdtEC(Context ctx)
    {
        super(ctx);
        registerInterface(IWkPmtUpdtEC.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6C50F7DB");
    }
    private WkPmtUpdtECController getController() throws BOSException
    {
        return (WkPmtUpdtECController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WkPmtUpdtECCollection getWkPmtUpdtECCollection() throws BOSException
    {
        try {
            return getController().getWkPmtUpdtECCollection(getContext());
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
    public WkPmtUpdtECCollection getWkPmtUpdtECCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWkPmtUpdtECCollection(getContext(), view);
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
    public WkPmtUpdtECCollection getWkPmtUpdtECCollection(String oql) throws BOSException
    {
        try {
            return getController().getWkPmtUpdtECCollection(getContext(), oql);
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
    public WkPmtUpdtECInfo getWkPmtUpdtECInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtECInfo(getContext(), pk);
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
    public WkPmtUpdtECInfo getWkPmtUpdtECInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtECInfo(getContext(), pk, selector);
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
    public WkPmtUpdtECInfo getWkPmtUpdtECInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtECInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}