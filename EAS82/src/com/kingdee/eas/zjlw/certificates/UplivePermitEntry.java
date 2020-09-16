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

public class UplivePermitEntry extends CoreBillEntryBase implements IUplivePermitEntry
{
    public UplivePermitEntry()
    {
        super();
        registerInterface(IUplivePermitEntry.class, this);
    }
    public UplivePermitEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IUplivePermitEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CE17265F");
    }
    private UplivePermitEntryController getController() throws BOSException
    {
        return (UplivePermitEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public UplivePermitEntryInfo getUplivePermitEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getUplivePermitEntryInfo(getContext(), pk);
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
    public UplivePermitEntryInfo getUplivePermitEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getUplivePermitEntryInfo(getContext(), pk, selector);
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
    public UplivePermitEntryInfo getUplivePermitEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getUplivePermitEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public UplivePermitEntryCollection getUplivePermitEntryCollection() throws BOSException
    {
        try {
            return getController().getUplivePermitEntryCollection(getContext());
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
    public UplivePermitEntryCollection getUplivePermitEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getUplivePermitEntryCollection(getContext(), view);
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
    public UplivePermitEntryCollection getUplivePermitEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getUplivePermitEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}