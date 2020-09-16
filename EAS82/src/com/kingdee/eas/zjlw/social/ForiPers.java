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

public class ForiPers extends CoreBillBase implements IForiPers
{
    public ForiPers()
    {
        super();
        registerInterface(IForiPers.class, this);
    }
    public ForiPers(Context ctx)
    {
        super(ctx);
        registerInterface(IForiPers.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("32D9D096");
    }
    private ForiPersController getController() throws BOSException
    {
        return (ForiPersController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ForiPersCollection getForiPersCollection() throws BOSException
    {
        try {
            return getController().getForiPersCollection(getContext());
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
    public ForiPersCollection getForiPersCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getForiPersCollection(getContext(), view);
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
    public ForiPersCollection getForiPersCollection(String oql) throws BOSException
    {
        try {
            return getController().getForiPersCollection(getContext(), oql);
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
    public ForiPersInfo getForiPersInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getForiPersInfo(getContext(), pk);
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
    public ForiPersInfo getForiPersInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getForiPersInfo(getContext(), pk, selector);
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
    public ForiPersInfo getForiPersInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getForiPersInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}