package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.zjlw.social.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ProjFERAssd extends CoreBillBase implements IProjFERAssd
{
    public ProjFERAssd()
    {
        super();
        registerInterface(IProjFERAssd.class, this);
    }
    public ProjFERAssd(Context ctx)
    {
        super(ctx);
        registerInterface(IProjFERAssd.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A0C63D59");
    }
    private ProjFERAssdController getController() throws BOSException
    {
        return (ProjFERAssdController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProjFERAssdCollection getProjFERAssdCollection() throws BOSException
    {
        try {
            return getController().getProjFERAssdCollection(getContext());
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
    public ProjFERAssdCollection getProjFERAssdCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjFERAssdCollection(getContext(), view);
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
    public ProjFERAssdCollection getProjFERAssdCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjFERAssdCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProjFERAssdInfo getProjFERAssdInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjFERAssdInfo(getContext(), pk);
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
    public ProjFERAssdInfo getProjFERAssdInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjFERAssdInfo(getContext(), pk, selector);
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
    public ProjFERAssdInfo getProjFERAssdInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjFERAssdInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}