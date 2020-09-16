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

public class TurnoverCount extends CoreBillBase implements ITurnoverCount
{
    public TurnoverCount()
    {
        super();
        registerInterface(ITurnoverCount.class, this);
    }
    public TurnoverCount(Context ctx)
    {
        super(ctx);
        registerInterface(ITurnoverCount.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C83E7FFE");
    }
    private TurnoverCountController getController() throws BOSException
    {
        return (TurnoverCountController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TurnoverCountCollection getTurnoverCountCollection() throws BOSException
    {
        try {
            return getController().getTurnoverCountCollection(getContext());
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
    public TurnoverCountCollection getTurnoverCountCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTurnoverCountCollection(getContext(), view);
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
    public TurnoverCountCollection getTurnoverCountCollection(String oql) throws BOSException
    {
        try {
            return getController().getTurnoverCountCollection(getContext(), oql);
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
    public TurnoverCountInfo getTurnoverCountInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTurnoverCountInfo(getContext(), pk);
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
    public TurnoverCountInfo getTurnoverCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTurnoverCountInfo(getContext(), pk, selector);
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
    public TurnoverCountInfo getTurnoverCountInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTurnoverCountInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}