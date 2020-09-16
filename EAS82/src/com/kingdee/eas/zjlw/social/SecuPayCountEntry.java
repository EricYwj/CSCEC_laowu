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

public class SecuPayCountEntry extends CoreBillEntryBase implements ISecuPayCountEntry
{
    public SecuPayCountEntry()
    {
        super();
        registerInterface(ISecuPayCountEntry.class, this);
    }
    public SecuPayCountEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISecuPayCountEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C9DABEC7");
    }
    private SecuPayCountEntryController getController() throws BOSException
    {
        return (SecuPayCountEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SecuPayCountEntryInfo getSecuPayCountEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuPayCountEntryInfo(getContext(), pk);
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
    public SecuPayCountEntryInfo getSecuPayCountEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuPayCountEntryInfo(getContext(), pk, selector);
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
    public SecuPayCountEntryInfo getSecuPayCountEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuPayCountEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SecuPayCountEntryCollection getSecuPayCountEntryCollection() throws BOSException
    {
        try {
            return getController().getSecuPayCountEntryCollection(getContext());
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
    public SecuPayCountEntryCollection getSecuPayCountEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSecuPayCountEntryCollection(getContext(), view);
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
    public SecuPayCountEntryCollection getSecuPayCountEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSecuPayCountEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}