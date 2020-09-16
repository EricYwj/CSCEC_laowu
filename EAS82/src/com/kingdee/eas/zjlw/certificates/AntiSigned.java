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

public class AntiSigned extends CoreBillBase implements IAntiSigned
{
    public AntiSigned()
    {
        super();
        registerInterface(IAntiSigned.class, this);
    }
    public AntiSigned(Context ctx)
    {
        super(ctx);
        registerInterface(IAntiSigned.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EFBAA22F");
    }
    private AntiSignedController getController() throws BOSException
    {
        return (AntiSignedController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AntiSignedCollection getAntiSignedCollection() throws BOSException
    {
        try {
            return getController().getAntiSignedCollection(getContext());
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
    public AntiSignedCollection getAntiSignedCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAntiSignedCollection(getContext(), view);
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
    public AntiSignedCollection getAntiSignedCollection(String oql) throws BOSException
    {
        try {
            return getController().getAntiSignedCollection(getContext(), oql);
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
    public AntiSignedInfo getAntiSignedInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiSignedInfo(getContext(), pk);
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
    public AntiSignedInfo getAntiSignedInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiSignedInfo(getContext(), pk, selector);
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
    public AntiSignedInfo getAntiSignedInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiSignedInfo(getContext(), oql);
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