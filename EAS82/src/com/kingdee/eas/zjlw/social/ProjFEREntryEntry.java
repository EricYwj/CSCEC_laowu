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

public class ProjFEREntryEntry extends CoreBillEntryBase implements IProjFEREntryEntry
{
    public ProjFEREntryEntry()
    {
        super();
        registerInterface(IProjFEREntryEntry.class, this);
    }
    public ProjFEREntryEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IProjFEREntryEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BF3195F6");
    }
    private ProjFEREntryEntryController getController() throws BOSException
    {
        return (ProjFEREntryEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProjFEREntryEntryInfo getProjFEREntryEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjFEREntryEntryInfo(getContext(), pk);
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
    public ProjFEREntryEntryInfo getProjFEREntryEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjFEREntryEntryInfo(getContext(), pk, selector);
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
    public ProjFEREntryEntryInfo getProjFEREntryEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjFEREntryEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProjFEREntryEntryCollection getProjFEREntryEntryCollection() throws BOSException
    {
        try {
            return getController().getProjFEREntryEntryCollection(getContext());
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
    public ProjFEREntryEntryCollection getProjFEREntryEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjFEREntryEntryCollection(getContext(), view);
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
    public ProjFEREntryEntryCollection getProjFEREntryEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjFEREntryEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}