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

public class WkPmtTrnECEntry extends CoreBillEntryBase implements IWkPmtTrnECEntry
{
    public WkPmtTrnECEntry()
    {
        super();
        registerInterface(IWkPmtTrnECEntry.class, this);
    }
    public WkPmtTrnECEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IWkPmtTrnECEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F2B81F56");
    }
    private WkPmtTrnECEntryController getController() throws BOSException
    {
        return (WkPmtTrnECEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WkPmtTrnECEntryInfo getWkPmtTrnECEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtTrnECEntryInfo(getContext(), pk);
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
    public WkPmtTrnECEntryInfo getWkPmtTrnECEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtTrnECEntryInfo(getContext(), pk, selector);
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
    public WkPmtTrnECEntryInfo getWkPmtTrnECEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtTrnECEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WkPmtTrnECEntryCollection getWkPmtTrnECEntryCollection() throws BOSException
    {
        try {
            return getController().getWkPmtTrnECEntryCollection(getContext());
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
    public WkPmtTrnECEntryCollection getWkPmtTrnECEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWkPmtTrnECEntryCollection(getContext(), view);
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
    public WkPmtTrnECEntryCollection getWkPmtTrnECEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWkPmtTrnECEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}