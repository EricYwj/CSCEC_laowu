package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.zjlw.baseinfo.app.*;
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

public class PoliceOff extends DataBase implements IPoliceOff
{
    public PoliceOff()
    {
        super();
        registerInterface(IPoliceOff.class, this);
    }
    public PoliceOff(Context ctx)
    {
        super(ctx);
        registerInterface(IPoliceOff.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F8831743");
    }
    private PoliceOffController getController() throws BOSException
    {
        return (PoliceOffController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PoliceOffInfo getPoliceOffInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPoliceOffInfo(getContext(), pk);
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
    public PoliceOffInfo getPoliceOffInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPoliceOffInfo(getContext(), pk, selector);
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
    public PoliceOffInfo getPoliceOffInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPoliceOffInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PoliceOffCollection getPoliceOffCollection() throws BOSException
    {
        try {
            return getController().getPoliceOffCollection(getContext());
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
    public PoliceOffCollection getPoliceOffCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPoliceOffCollection(getContext(), view);
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
    public PoliceOffCollection getPoliceOffCollection(String oql) throws BOSException
    {
        try {
            return getController().getPoliceOffCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}