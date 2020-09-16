package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.zjlw.attendance.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AlgAttEntry extends CoreBillEntryBase implements IAlgAttEntry
{
    public AlgAttEntry()
    {
        super();
        registerInterface(IAlgAttEntry.class, this);
    }
    public AlgAttEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IAlgAttEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CB9CB3C9");
    }
    private AlgAttEntryController getController() throws BOSException
    {
        return (AlgAttEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public AlgAttEntryInfo getAlgAttEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAttEntryInfo(getContext(), pk);
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
    public AlgAttEntryInfo getAlgAttEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAttEntryInfo(getContext(), pk, selector);
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
    public AlgAttEntryInfo getAlgAttEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAttEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public AlgAttEntryCollection getAlgAttEntryCollection() throws BOSException
    {
        try {
            return getController().getAlgAttEntryCollection(getContext());
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
    public AlgAttEntryCollection getAlgAttEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAlgAttEntryCollection(getContext(), view);
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
    public AlgAttEntryCollection getAlgAttEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getAlgAttEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}