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

public class InsurePersonEntry extends CoreBillEntryBase implements IInsurePersonEntry
{
    public InsurePersonEntry()
    {
        super();
        registerInterface(IInsurePersonEntry.class, this);
    }
    public InsurePersonEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IInsurePersonEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AC117643");
    }
    private InsurePersonEntryController getController() throws BOSException
    {
        return (InsurePersonEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public InsurePersonEntryInfo getInsurePersonEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInsurePersonEntryInfo(getContext(), pk);
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
    public InsurePersonEntryInfo getInsurePersonEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInsurePersonEntryInfo(getContext(), pk, selector);
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
    public InsurePersonEntryInfo getInsurePersonEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInsurePersonEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InsurePersonEntryCollection getInsurePersonEntryCollection() throws BOSException
    {
        try {
            return getController().getInsurePersonEntryCollection(getContext());
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
    public InsurePersonEntryCollection getInsurePersonEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInsurePersonEntryCollection(getContext(), view);
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
    public InsurePersonEntryCollection getInsurePersonEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getInsurePersonEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}