package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.zjlw.personmess.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LocalInfoEntry extends CoreBillEntryBase implements ILocalInfoEntry
{
    public LocalInfoEntry()
    {
        super();
        registerInterface(ILocalInfoEntry.class, this);
    }
    public LocalInfoEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ILocalInfoEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7C84C999");
    }
    private LocalInfoEntryController getController() throws BOSException
    {
        return (LocalInfoEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public LocalInfoEntryInfo getLocalInfoEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalInfoEntryInfo(getContext(), pk);
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
    public LocalInfoEntryInfo getLocalInfoEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalInfoEntryInfo(getContext(), pk, selector);
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
    public LocalInfoEntryInfo getLocalInfoEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalInfoEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LocalInfoEntryCollection getLocalInfoEntryCollection() throws BOSException
    {
        try {
            return getController().getLocalInfoEntryCollection(getContext());
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
    public LocalInfoEntryCollection getLocalInfoEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLocalInfoEntryCollection(getContext(), view);
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
    public LocalInfoEntryCollection getLocalInfoEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getLocalInfoEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}