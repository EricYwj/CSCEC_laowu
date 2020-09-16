package com.kingdee.eas.zjlw.social;

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
import com.kingdee.eas.zjlw.social.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class VabaweatherEntry extends CoreBillEntryBase implements IVabaweatherEntry
{
    public VabaweatherEntry()
    {
        super();
        registerInterface(IVabaweatherEntry.class, this);
    }
    public VabaweatherEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IVabaweatherEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C19862C8");
    }
    private VabaweatherEntryController getController() throws BOSException
    {
        return (VabaweatherEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public VabaweatherEntryInfo getVabaweatherEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getVabaweatherEntryInfo(getContext(), pk);
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
    public VabaweatherEntryInfo getVabaweatherEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getVabaweatherEntryInfo(getContext(), pk, selector);
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
    public VabaweatherEntryInfo getVabaweatherEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getVabaweatherEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public VabaweatherEntryCollection getVabaweatherEntryCollection() throws BOSException
    {
        try {
            return getController().getVabaweatherEntryCollection(getContext());
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
    public VabaweatherEntryCollection getVabaweatherEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getVabaweatherEntryCollection(getContext(), view);
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
    public VabaweatherEntryCollection getVabaweatherEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getVabaweatherEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}