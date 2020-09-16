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

public class DoubEcEntry extends CoreBillEntryBase implements IDoubEcEntry
{
    public DoubEcEntry()
    {
        super();
        registerInterface(IDoubEcEntry.class, this);
    }
    public DoubEcEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDoubEcEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("86FA2C0B");
    }
    private DoubEcEntryController getController() throws BOSException
    {
        return (DoubEcEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DoubEcEntryInfo getDoubEcEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDoubEcEntryInfo(getContext(), pk);
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
    public DoubEcEntryInfo getDoubEcEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDoubEcEntryInfo(getContext(), pk, selector);
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
    public DoubEcEntryInfo getDoubEcEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDoubEcEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DoubEcEntryCollection getDoubEcEntryCollection() throws BOSException
    {
        try {
            return getController().getDoubEcEntryCollection(getContext());
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
    public DoubEcEntryCollection getDoubEcEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDoubEcEntryCollection(getContext(), view);
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
    public DoubEcEntryCollection getDoubEcEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDoubEcEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}