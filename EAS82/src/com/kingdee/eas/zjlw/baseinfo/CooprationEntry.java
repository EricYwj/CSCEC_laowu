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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CooprationEntry extends CoreBillEntryBase implements ICooprationEntry
{
    public CooprationEntry()
    {
        super();
        registerInterface(ICooprationEntry.class, this);
    }
    public CooprationEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICooprationEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6CAD1554");
    }
    private CooprationEntryController getController() throws BOSException
    {
        return (CooprationEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CooprationEntryInfo getCooprationEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCooprationEntryInfo(getContext(), pk);
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
    public CooprationEntryInfo getCooprationEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCooprationEntryInfo(getContext(), pk, selector);
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
    public CooprationEntryInfo getCooprationEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCooprationEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CooprationEntryCollection getCooprationEntryCollection() throws BOSException
    {
        try {
            return getController().getCooprationEntryCollection(getContext());
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
    public CooprationEntryCollection getCooprationEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCooprationEntryCollection(getContext(), view);
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
    public CooprationEntryCollection getCooprationEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCooprationEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}