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

public class PassportapplyEntry extends CoreBillEntryBase implements IPassportapplyEntry
{
    public PassportapplyEntry()
    {
        super();
        registerInterface(IPassportapplyEntry.class, this);
    }
    public PassportapplyEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IPassportapplyEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E0D41B47");
    }
    private PassportapplyEntryController getController() throws BOSException
    {
        return (PassportapplyEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public PassportapplyEntryInfo getPassportapplyEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPassportapplyEntryInfo(getContext(), pk);
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
    public PassportapplyEntryInfo getPassportapplyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPassportapplyEntryInfo(getContext(), pk, selector);
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
    public PassportapplyEntryInfo getPassportapplyEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPassportapplyEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public PassportapplyEntryCollection getPassportapplyEntryCollection() throws BOSException
    {
        try {
            return getController().getPassportapplyEntryCollection(getContext());
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
    public PassportapplyEntryCollection getPassportapplyEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPassportapplyEntryCollection(getContext(), view);
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
    public PassportapplyEntryCollection getPassportapplyEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPassportapplyEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}