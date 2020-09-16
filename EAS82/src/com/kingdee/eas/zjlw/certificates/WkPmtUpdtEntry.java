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

public class WkPmtUpdtEntry extends CoreBillEntryBase implements IWkPmtUpdtEntry
{
    public WkPmtUpdtEntry()
    {
        super();
        registerInterface(IWkPmtUpdtEntry.class, this);
    }
    public WkPmtUpdtEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IWkPmtUpdtEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E27083F5");
    }
    private WkPmtUpdtEntryController getController() throws BOSException
    {
        return (WkPmtUpdtEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WkPmtUpdtEntryInfo getWkPmtUpdtEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtEntryInfo(getContext(), pk);
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
    public WkPmtUpdtEntryInfo getWkPmtUpdtEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtEntryInfo(getContext(), pk, selector);
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
    public WkPmtUpdtEntryInfo getWkPmtUpdtEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WkPmtUpdtEntryCollection getWkPmtUpdtEntryCollection() throws BOSException
    {
        try {
            return getController().getWkPmtUpdtEntryCollection(getContext());
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
    public WkPmtUpdtEntryCollection getWkPmtUpdtEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWkPmtUpdtEntryCollection(getContext(), view);
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
    public WkPmtUpdtEntryCollection getWkPmtUpdtEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWkPmtUpdtEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}