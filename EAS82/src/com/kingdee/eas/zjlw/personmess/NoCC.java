package com.kingdee.eas.zjlw.personmess;

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
import com.kingdee.eas.zjlw.personmess.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class NoCC extends CoreBillBase implements INoCC
{
    public NoCC()
    {
        super();
        registerInterface(INoCC.class, this);
    }
    public NoCC(Context ctx)
    {
        super(ctx);
        registerInterface(INoCC.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E3159241");
    }
    private NoCCController getController() throws BOSException
    {
        return (NoCCController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public NoCCCollection getNoCCCollection() throws BOSException
    {
        try {
            return getController().getNoCCCollection(getContext());
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
    public NoCCCollection getNoCCCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getNoCCCollection(getContext(), view);
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
    public NoCCCollection getNoCCCollection(String oql) throws BOSException
    {
        try {
            return getController().getNoCCCollection(getContext(), oql);
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
    public NoCCInfo getNoCCInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getNoCCInfo(getContext(), pk);
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
    public NoCCInfo getNoCCInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getNoCCInfo(getContext(), pk, selector);
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
    public NoCCInfo getNoCCInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getNoCCInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}