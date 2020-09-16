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

public class TurnoverCountEntry extends CoreBillEntryBase implements ITurnoverCountEntry
{
    public TurnoverCountEntry()
    {
        super();
        registerInterface(ITurnoverCountEntry.class, this);
    }
    public TurnoverCountEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ITurnoverCountEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1B67E714");
    }
    private TurnoverCountEntryController getController() throws BOSException
    {
        return (TurnoverCountEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TurnoverCountEntryInfo getTurnoverCountEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTurnoverCountEntryInfo(getContext(), pk);
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
    public TurnoverCountEntryInfo getTurnoverCountEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTurnoverCountEntryInfo(getContext(), pk, selector);
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
    public TurnoverCountEntryInfo getTurnoverCountEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTurnoverCountEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TurnoverCountEntryCollection getTurnoverCountEntryCollection() throws BOSException
    {
        try {
            return getController().getTurnoverCountEntryCollection(getContext());
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
    public TurnoverCountEntryCollection getTurnoverCountEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTurnoverCountEntryCollection(getContext(), view);
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
    public TurnoverCountEntryCollection getTurnoverCountEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getTurnoverCountEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}