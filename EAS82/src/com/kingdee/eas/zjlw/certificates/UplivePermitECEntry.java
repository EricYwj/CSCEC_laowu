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

public class UplivePermitECEntry extends CoreBillEntryBase implements IUplivePermitECEntry
{
    public UplivePermitECEntry()
    {
        super();
        registerInterface(IUplivePermitECEntry.class, this);
    }
    public UplivePermitECEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IUplivePermitECEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("58EE8141");
    }
    private UplivePermitECEntryController getController() throws BOSException
    {
        return (UplivePermitECEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public UplivePermitECEntryInfo getUplivePermitECEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getUplivePermitECEntryInfo(getContext(), pk);
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
    public UplivePermitECEntryInfo getUplivePermitECEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getUplivePermitECEntryInfo(getContext(), pk, selector);
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
    public UplivePermitECEntryInfo getUplivePermitECEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getUplivePermitECEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public UplivePermitECEntryCollection getUplivePermitECEntryCollection() throws BOSException
    {
        try {
            return getController().getUplivePermitECEntryCollection(getContext());
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
    public UplivePermitECEntryCollection getUplivePermitECEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getUplivePermitECEntryCollection(getContext(), view);
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
    public UplivePermitECEntryCollection getUplivePermitECEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getUplivePermitECEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}