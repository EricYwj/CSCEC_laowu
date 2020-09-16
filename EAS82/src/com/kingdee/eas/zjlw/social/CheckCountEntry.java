package com.kingdee.eas.zjlw.social;

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
import com.kingdee.eas.zjlw.social.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CheckCountEntry extends CoreBillEntryBase implements ICheckCountEntry
{
    public CheckCountEntry()
    {
        super();
        registerInterface(ICheckCountEntry.class, this);
    }
    public CheckCountEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICheckCountEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BE2B1B0B");
    }
    private CheckCountEntryController getController() throws BOSException
    {
        return (CheckCountEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CheckCountEntryInfo getCheckCountEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckCountEntryInfo(getContext(), pk);
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
    public CheckCountEntryInfo getCheckCountEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckCountEntryInfo(getContext(), pk, selector);
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
    public CheckCountEntryInfo getCheckCountEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckCountEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CheckCountEntryCollection getCheckCountEntryCollection() throws BOSException
    {
        try {
            return getController().getCheckCountEntryCollection(getContext());
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
    public CheckCountEntryCollection getCheckCountEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCheckCountEntryCollection(getContext(), view);
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
    public CheckCountEntryCollection getCheckCountEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCheckCountEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}