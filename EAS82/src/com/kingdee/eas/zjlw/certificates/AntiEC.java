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

public class AntiEC extends CoreBillBase implements IAntiEC
{
    public AntiEC()
    {
        super();
        registerInterface(IAntiEC.class, this);
    }
    public AntiEC(Context ctx)
    {
        super(ctx);
        registerInterface(IAntiEC.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C067C111");
    }
    private AntiECController getController() throws BOSException
    {
        return (AntiECController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AntiECCollection getAntiECCollection() throws BOSException
    {
        try {
            return getController().getAntiECCollection(getContext());
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
    public AntiECCollection getAntiECCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAntiECCollection(getContext(), view);
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
    public AntiECCollection getAntiECCollection(String oql) throws BOSException
    {
        try {
            return getController().getAntiECCollection(getContext(), oql);
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
    public AntiECInfo getAntiECInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiECInfo(getContext(), pk);
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
    public AntiECInfo getAntiECInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiECInfo(getContext(), pk, selector);
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
    public AntiECInfo getAntiECInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiECInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *logOut-User defined method
     *@param pk 主键
     */
    public void logOut(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            getController().logOut(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}