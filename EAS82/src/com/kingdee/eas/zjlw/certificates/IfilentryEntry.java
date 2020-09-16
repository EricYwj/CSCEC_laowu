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

public class IfilentryEntry extends CoreBillEntryBase implements IIfilentryEntry
{
    public IfilentryEntry()
    {
        super();
        registerInterface(IIfilentryEntry.class, this);
    }
    public IfilentryEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IIfilentryEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C23A32B1");
    }
    private IfilentryEntryController getController() throws BOSException
    {
        return (IfilentryEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public IfilentryEntryInfo getIfilentryEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getIfilentryEntryInfo(getContext(), pk);
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
    public IfilentryEntryInfo getIfilentryEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getIfilentryEntryInfo(getContext(), pk, selector);
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
    public IfilentryEntryInfo getIfilentryEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getIfilentryEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public IfilentryEntryCollection getIfilentryEntryCollection() throws BOSException
    {
        try {
            return getController().getIfilentryEntryCollection(getContext());
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
    public IfilentryEntryCollection getIfilentryEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getIfilentryEntryCollection(getContext(), view);
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
    public IfilentryEntryCollection getIfilentryEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getIfilentryEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}