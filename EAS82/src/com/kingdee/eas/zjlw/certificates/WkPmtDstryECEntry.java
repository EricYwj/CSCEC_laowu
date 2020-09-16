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

public class WkPmtDstryECEntry extends CoreBillEntryBase implements IWkPmtDstryECEntry
{
    public WkPmtDstryECEntry()
    {
        super();
        registerInterface(IWkPmtDstryECEntry.class, this);
    }
    public WkPmtDstryECEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IWkPmtDstryECEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A63F163A");
    }
    private WkPmtDstryECEntryController getController() throws BOSException
    {
        return (WkPmtDstryECEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WkPmtDstryECEntryInfo getWkPmtDstryECEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtDstryECEntryInfo(getContext(), pk);
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
    public WkPmtDstryECEntryInfo getWkPmtDstryECEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtDstryECEntryInfo(getContext(), pk, selector);
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
    public WkPmtDstryECEntryInfo getWkPmtDstryECEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtDstryECEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WkPmtDstryECEntryCollection getWkPmtDstryECEntryCollection() throws BOSException
    {
        try {
            return getController().getWkPmtDstryECEntryCollection(getContext());
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
    public WkPmtDstryECEntryCollection getWkPmtDstryECEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWkPmtDstryECEntryCollection(getContext(), view);
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
    public WkPmtDstryECEntryCollection getWkPmtDstryECEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWkPmtDstryECEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}