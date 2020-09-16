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

public class SecuPayEntry extends CoreBillEntryBase implements ISecuPayEntry
{
    public SecuPayEntry()
    {
        super();
        registerInterface(ISecuPayEntry.class, this);
    }
    public SecuPayEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISecuPayEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("05B61BCE");
    }
    private SecuPayEntryController getController() throws BOSException
    {
        return (SecuPayEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SecuPayEntryInfo getSecuPayEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuPayEntryInfo(getContext(), pk);
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
    public SecuPayEntryInfo getSecuPayEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuPayEntryInfo(getContext(), pk, selector);
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
    public SecuPayEntryInfo getSecuPayEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuPayEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SecuPayEntryCollection getSecuPayEntryCollection() throws BOSException
    {
        try {
            return getController().getSecuPayEntryCollection(getContext());
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
    public SecuPayEntryCollection getSecuPayEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSecuPayEntryCollection(getContext(), view);
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
    public SecuPayEntryCollection getSecuPayEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSecuPayEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}