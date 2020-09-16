package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.eas.zjlw.baseinfo.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Coopration extends CoreBillBase implements ICoopration
{
    public Coopration()
    {
        super();
        registerInterface(ICoopration.class, this);
    }
    public Coopration(Context ctx)
    {
        super(ctx);
        registerInterface(ICoopration.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("738569BE");
    }
    private CooprationController getController() throws BOSException
    {
        return (CooprationController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CooprationCollection getCooprationCollection() throws BOSException
    {
        try {
            return getController().getCooprationCollection(getContext());
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
    public CooprationCollection getCooprationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCooprationCollection(getContext(), view);
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
    public CooprationCollection getCooprationCollection(String oql) throws BOSException
    {
        try {
            return getController().getCooprationCollection(getContext(), oql);
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
    public CooprationInfo getCooprationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCooprationInfo(getContext(), pk);
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
    public CooprationInfo getCooprationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCooprationInfo(getContext(), pk, selector);
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
    public CooprationInfo getCooprationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCooprationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}