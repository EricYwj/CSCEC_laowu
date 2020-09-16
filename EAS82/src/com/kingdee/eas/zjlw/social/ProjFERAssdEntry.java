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

public class ProjFERAssdEntry extends CoreBillEntryBase implements IProjFERAssdEntry
{
    public ProjFERAssdEntry()
    {
        super();
        registerInterface(IProjFERAssdEntry.class, this);
    }
    public ProjFERAssdEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IProjFERAssdEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9E774A99");
    }
    private ProjFERAssdEntryController getController() throws BOSException
    {
        return (ProjFERAssdEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProjFERAssdEntryInfo getProjFERAssdEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjFERAssdEntryInfo(getContext(), pk);
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
    public ProjFERAssdEntryInfo getProjFERAssdEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjFERAssdEntryInfo(getContext(), pk, selector);
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
    public ProjFERAssdEntryInfo getProjFERAssdEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjFERAssdEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProjFERAssdEntryCollection getProjFERAssdEntryCollection() throws BOSException
    {
        try {
            return getController().getProjFERAssdEntryCollection(getContext());
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
    public ProjFERAssdEntryCollection getProjFERAssdEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjFERAssdEntryCollection(getContext(), view);
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
    public ProjFERAssdEntryCollection getProjFERAssdEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjFERAssdEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}