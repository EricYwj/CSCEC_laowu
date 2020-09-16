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

public class WorkVisacancelEntry extends CoreBillEntryBase implements IWorkVisacancelEntry
{
    public WorkVisacancelEntry()
    {
        super();
        registerInterface(IWorkVisacancelEntry.class, this);
    }
    public WorkVisacancelEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IWorkVisacancelEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("554601F5");
    }
    private WorkVisacancelEntryController getController() throws BOSException
    {
        return (WorkVisacancelEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WorkVisacancelEntryInfo getWorkVisacancelEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkVisacancelEntryInfo(getContext(), pk);
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
    public WorkVisacancelEntryInfo getWorkVisacancelEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkVisacancelEntryInfo(getContext(), pk, selector);
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
    public WorkVisacancelEntryInfo getWorkVisacancelEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkVisacancelEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WorkVisacancelEntryCollection getWorkVisacancelEntryCollection() throws BOSException
    {
        try {
            return getController().getWorkVisacancelEntryCollection(getContext());
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
    public WorkVisacancelEntryCollection getWorkVisacancelEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWorkVisacancelEntryCollection(getContext(), view);
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
    public WorkVisacancelEntryCollection getWorkVisacancelEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWorkVisacancelEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}