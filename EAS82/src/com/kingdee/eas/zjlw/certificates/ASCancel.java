package com.kingdee.eas.zjlw.certificates;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ASCancel extends CoreBillBase implements IASCancel
{
    public ASCancel()
    {
        super();
        registerInterface(IASCancel.class, this);
    }
    public ASCancel(Context ctx)
    {
        super(ctx);
        registerInterface(IASCancel.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5D38767D");
    }
    private ASCancelController getController() throws BOSException
    {
        return (ASCancelController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ASCancelCollection getASCancelCollection() throws BOSException
    {
        try {
            return getController().getASCancelCollection(getContext());
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
    public ASCancelCollection getASCancelCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getASCancelCollection(getContext(), view);
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
    public ASCancelCollection getASCancelCollection(String oql) throws BOSException
    {
        try {
            return getController().getASCancelCollection(getContext(), oql);
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
    public ASCancelInfo getASCancelInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getASCancelInfo(getContext(), pk);
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
    public ASCancelInfo getASCancelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getASCancelInfo(getContext(), pk, selector);
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
    public ASCancelInfo getASCancelInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getASCancelInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}