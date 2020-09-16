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

public class PmtApp extends CoreBillBase implements IPmtApp
{
    public PmtApp()
    {
        super();
        registerInterface(IPmtApp.class, this);
    }
    public PmtApp(Context ctx)
    {
        super(ctx);
        registerInterface(IPmtApp.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("62FD61F8");
    }
    private PmtAppController getController() throws BOSException
    {
        return (PmtAppController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PmtAppCollection getPmtAppCollection() throws BOSException
    {
        try {
            return getController().getPmtAppCollection(getContext());
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
    public PmtAppCollection getPmtAppCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPmtAppCollection(getContext(), view);
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
    public PmtAppCollection getPmtAppCollection(String oql) throws BOSException
    {
        try {
            return getController().getPmtAppCollection(getContext(), oql);
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
    public PmtAppInfo getPmtAppInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPmtAppInfo(getContext(), pk);
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
    public PmtAppInfo getPmtAppInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPmtAppInfo(getContext(), pk, selector);
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
    public PmtAppInfo getPmtAppInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPmtAppInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}