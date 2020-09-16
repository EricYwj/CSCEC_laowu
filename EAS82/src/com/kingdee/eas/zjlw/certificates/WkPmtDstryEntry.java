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

public class WkPmtDstryEntry extends CoreBillEntryBase implements IWkPmtDstryEntry
{
    public WkPmtDstryEntry()
    {
        super();
        registerInterface(IWkPmtDstryEntry.class, this);
    }
    public WkPmtDstryEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IWkPmtDstryEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5A4AA598");
    }
    private WkPmtDstryEntryController getController() throws BOSException
    {
        return (WkPmtDstryEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WkPmtDstryEntryInfo getWkPmtDstryEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtDstryEntryInfo(getContext(), pk);
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
    public WkPmtDstryEntryInfo getWkPmtDstryEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtDstryEntryInfo(getContext(), pk, selector);
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
    public WkPmtDstryEntryInfo getWkPmtDstryEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtDstryEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WkPmtDstryEntryCollection getWkPmtDstryEntryCollection() throws BOSException
    {
        try {
            return getController().getWkPmtDstryEntryCollection(getContext());
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
    public WkPmtDstryEntryCollection getWkPmtDstryEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWkPmtDstryEntryCollection(getContext(), view);
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
    public WkPmtDstryEntryCollection getWkPmtDstryEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWkPmtDstryEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}