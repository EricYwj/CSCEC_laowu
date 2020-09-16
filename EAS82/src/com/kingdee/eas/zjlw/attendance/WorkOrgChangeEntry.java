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

public class WorkOrgChangeEntry extends CoreBillEntryBase implements IWorkOrgChangeEntry
{
    public WorkOrgChangeEntry()
    {
        super();
        registerInterface(IWorkOrgChangeEntry.class, this);
    }
    public WorkOrgChangeEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IWorkOrgChangeEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2C46B353");
    }
    private WorkOrgChangeEntryController getController() throws BOSException
    {
        return (WorkOrgChangeEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WorkOrgChangeEntryInfo getWorkOrgChangeEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkOrgChangeEntryInfo(getContext(), pk);
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
    public WorkOrgChangeEntryInfo getWorkOrgChangeEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkOrgChangeEntryInfo(getContext(), pk, selector);
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
    public WorkOrgChangeEntryInfo getWorkOrgChangeEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkOrgChangeEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WorkOrgChangeEntryCollection getWorkOrgChangeEntryCollection() throws BOSException
    {
        try {
            return getController().getWorkOrgChangeEntryCollection(getContext());
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
    public WorkOrgChangeEntryCollection getWorkOrgChangeEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWorkOrgChangeEntryCollection(getContext(), view);
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
    public WorkOrgChangeEntryCollection getWorkOrgChangeEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWorkOrgChangeEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}