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

public class PayBillEntry extends CoreBillEntryBase implements IPayBillEntry
{
    public PayBillEntry()
    {
        super();
        registerInterface(IPayBillEntry.class, this);
    }
    public PayBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IPayBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("646EE9A3");
    }
    private PayBillEntryController getController() throws BOSException
    {
        return (PayBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PayBillEntryInfo getPayBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPayBillEntryInfo(getContext(), pk);
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
    public PayBillEntryInfo getPayBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPayBillEntryInfo(getContext(), pk, selector);
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
    public PayBillEntryInfo getPayBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPayBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PayBillEntryCollection getPayBillEntryCollection() throws BOSException
    {
        try {
            return getController().getPayBillEntryCollection(getContext());
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
    public PayBillEntryCollection getPayBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPayBillEntryCollection(getContext(), view);
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
    public PayBillEntryCollection getPayBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPayBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}