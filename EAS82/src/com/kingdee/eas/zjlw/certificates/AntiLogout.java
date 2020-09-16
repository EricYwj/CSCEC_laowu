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

public class AntiLogout extends CoreBillBase implements IAntiLogout
{
    public AntiLogout()
    {
        super();
        registerInterface(IAntiLogout.class, this);
    }
    public AntiLogout(Context ctx)
    {
        super(ctx);
        registerInterface(IAntiLogout.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E41D489D");
    }
    private AntiLogoutController getController() throws BOSException
    {
        return (AntiLogoutController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AntiLogoutCollection getAntiLogoutCollection() throws BOSException
    {
        try {
            return getController().getAntiLogoutCollection(getContext());
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
    public AntiLogoutCollection getAntiLogoutCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAntiLogoutCollection(getContext(), view);
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
    public AntiLogoutCollection getAntiLogoutCollection(String oql) throws BOSException
    {
        try {
            return getController().getAntiLogoutCollection(getContext(), oql);
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
    public AntiLogoutInfo getAntiLogoutInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiLogoutInfo(getContext(), pk);
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
    public AntiLogoutInfo getAntiLogoutInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiLogoutInfo(getContext(), pk, selector);
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
    public AntiLogoutInfo getAntiLogoutInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiLogoutInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}