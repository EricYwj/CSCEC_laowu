package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.zjlw.attendance.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AlgPers extends CoreBillBase implements IAlgPers
{
    public AlgPers()
    {
        super();
        registerInterface(IAlgPers.class, this);
    }
    public AlgPers(Context ctx)
    {
        super(ctx);
        registerInterface(IAlgPers.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4531886E");
    }
    private AlgPersController getController() throws BOSException
    {
        return (AlgPersController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AlgPersCollection getAlgPersCollection() throws BOSException
    {
        try {
            return getController().getAlgPersCollection(getContext());
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
    public AlgPersCollection getAlgPersCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAlgPersCollection(getContext(), view);
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
    public AlgPersCollection getAlgPersCollection(String oql) throws BOSException
    {
        try {
            return getController().getAlgPersCollection(getContext(), oql);
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
    public AlgPersInfo getAlgPersInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgPersInfo(getContext(), pk);
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
    public AlgPersInfo getAlgPersInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgPersInfo(getContext(), pk, selector);
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
    public AlgPersInfo getAlgPersInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgPersInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}