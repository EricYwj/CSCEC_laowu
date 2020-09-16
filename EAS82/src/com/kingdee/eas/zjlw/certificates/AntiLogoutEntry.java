package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.zjlw.certificates.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AntiLogoutEntry extends CoreBillEntryBase implements IAntiLogoutEntry
{
    public AntiLogoutEntry()
    {
        super();
        registerInterface(IAntiLogoutEntry.class, this);
    }
    public AntiLogoutEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IAntiLogoutEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("12D8A9D5");
    }
    private AntiLogoutEntryController getController() throws BOSException
    {
        return (AntiLogoutEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AntiLogoutEntryInfo getAntiLogoutEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiLogoutEntryInfo(getContext(), pk);
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
    public AntiLogoutEntryInfo getAntiLogoutEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiLogoutEntryInfo(getContext(), pk, selector);
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
    public AntiLogoutEntryInfo getAntiLogoutEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiLogoutEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AntiLogoutEntryCollection getAntiLogoutEntryCollection() throws BOSException
    {
        try {
            return getController().getAntiLogoutEntryCollection(getContext());
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
    public AntiLogoutEntryCollection getAntiLogoutEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAntiLogoutEntryCollection(getContext(), view);
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
    public AntiLogoutEntryCollection getAntiLogoutEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getAntiLogoutEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}