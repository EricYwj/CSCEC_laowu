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

public class PayPrintEntry extends CoreBillEntryBase implements IPayPrintEntry
{
    public PayPrintEntry()
    {
        super();
        registerInterface(IPayPrintEntry.class, this);
    }
    public PayPrintEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IPayPrintEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3BF29FCD");
    }
    private PayPrintEntryController getController() throws BOSException
    {
        return (PayPrintEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PayPrintEntryInfo getPayPrintEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPayPrintEntryInfo(getContext(), pk);
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
    public PayPrintEntryInfo getPayPrintEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPayPrintEntryInfo(getContext(), pk, selector);
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
    public PayPrintEntryInfo getPayPrintEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPayPrintEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PayPrintEntryCollection getPayPrintEntryCollection() throws BOSException
    {
        try {
            return getController().getPayPrintEntryCollection(getContext());
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
    public PayPrintEntryCollection getPayPrintEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPayPrintEntryCollection(getContext(), view);
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
    public PayPrintEntryCollection getPayPrintEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPayPrintEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}