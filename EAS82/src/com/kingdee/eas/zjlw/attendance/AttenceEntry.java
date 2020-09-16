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

public class AttenceEntry extends CoreBillEntryBase implements IAttenceEntry
{
    public AttenceEntry()
    {
        super();
        registerInterface(IAttenceEntry.class, this);
    }
    public AttenceEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IAttenceEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D23F56AA");
    }
    private AttenceEntryController getController() throws BOSException
    {
        return (AttenceEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AttenceEntryInfo getAttenceEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAttenceEntryInfo(getContext(), pk);
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
    public AttenceEntryInfo getAttenceEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAttenceEntryInfo(getContext(), pk, selector);
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
    public AttenceEntryInfo getAttenceEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAttenceEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AttenceEntryCollection getAttenceEntryCollection() throws BOSException
    {
        try {
            return getController().getAttenceEntryCollection(getContext());
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
    public AttenceEntryCollection getAttenceEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAttenceEntryCollection(getContext(), view);
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
    public AttenceEntryCollection getAttenceEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getAttenceEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}