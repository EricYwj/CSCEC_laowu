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

public class WkPmtUpdtECEntry extends CoreBillEntryBase implements IWkPmtUpdtECEntry
{
    public WkPmtUpdtECEntry()
    {
        super();
        registerInterface(IWkPmtUpdtECEntry.class, this);
    }
    public WkPmtUpdtECEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IWkPmtUpdtECEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BC66D157");
    }
    private WkPmtUpdtECEntryController getController() throws BOSException
    {
        return (WkPmtUpdtECEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public WkPmtUpdtECEntryInfo getWkPmtUpdtECEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtECEntryInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public WkPmtUpdtECEntryInfo getWkPmtUpdtECEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtECEntryInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public WkPmtUpdtECEntryInfo getWkPmtUpdtECEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtECEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public WkPmtUpdtECEntryCollection getWkPmtUpdtECEntryCollection() throws BOSException
    {
        try {
            return getController().getWkPmtUpdtECEntryCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public WkPmtUpdtECEntryCollection getWkPmtUpdtECEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWkPmtUpdtECEntryCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public WkPmtUpdtECEntryCollection getWkPmtUpdtECEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWkPmtUpdtECEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}