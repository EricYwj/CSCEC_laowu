package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.zjlw.attendance.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AlgAccPers extends DataBase implements IAlgAccPers
{
    public AlgAccPers()
    {
        super();
        registerInterface(IAlgAccPers.class, this);
    }
    public AlgAccPers(Context ctx)
    {
        super(ctx);
        registerInterface(IAlgAccPers.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("016A8E9F");
    }
    private AlgAccPersController getController() throws BOSException
    {
        return (AlgAccPersController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AlgAccPersInfo getAlgAccPersInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAccPersInfo(getContext(), pk);
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
    public AlgAccPersInfo getAlgAccPersInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAccPersInfo(getContext(), pk, selector);
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
    public AlgAccPersInfo getAlgAccPersInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAccPersInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AlgAccPersCollection getAlgAccPersCollection() throws BOSException
    {
        try {
            return getController().getAlgAccPersCollection(getContext());
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
    public AlgAccPersCollection getAlgAccPersCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAlgAccPersCollection(getContext(), view);
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
    public AlgAccPersCollection getAlgAccPersCollection(String oql) throws BOSException
    {
        try {
            return getController().getAlgAccPersCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}