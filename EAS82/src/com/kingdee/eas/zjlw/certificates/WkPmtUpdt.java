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

public class WkPmtUpdt extends CoreBillBase implements IWkPmtUpdt
{
    public WkPmtUpdt()
    {
        super();
        registerInterface(IWkPmtUpdt.class, this);
    }
    public WkPmtUpdt(Context ctx)
    {
        super(ctx);
        registerInterface(IWkPmtUpdt.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("894D9A7D");
    }
    private WkPmtUpdtController getController() throws BOSException
    {
        return (WkPmtUpdtController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WkPmtUpdtCollection getWkPmtUpdtCollection() throws BOSException
    {
        try {
            return getController().getWkPmtUpdtCollection(getContext());
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
    public WkPmtUpdtCollection getWkPmtUpdtCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWkPmtUpdtCollection(getContext(), view);
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
    public WkPmtUpdtCollection getWkPmtUpdtCollection(String oql) throws BOSException
    {
        try {
            return getController().getWkPmtUpdtCollection(getContext(), oql);
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
    public WkPmtUpdtInfo getWkPmtUpdtInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtInfo(getContext(), pk);
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
    public WkPmtUpdtInfo getWkPmtUpdtInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtInfo(getContext(), pk, selector);
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
    public WkPmtUpdtInfo getWkPmtUpdtInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}