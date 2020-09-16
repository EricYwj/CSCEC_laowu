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

public class LocalInfo extends CoreBillBase implements ILocalInfo
{
    public LocalInfo()
    {
        super();
        registerInterface(ILocalInfo.class, this);
    }
    public LocalInfo(Context ctx)
    {
        super(ctx);
        registerInterface(ILocalInfo.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("02055E59");
    }
    private LocalInfoController getController() throws BOSException
    {
        return (LocalInfoController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LocalInfoCollection getLocalInfoCollection() throws BOSException
    {
        try {
            return getController().getLocalInfoCollection(getContext());
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
    public LocalInfoCollection getLocalInfoCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLocalInfoCollection(getContext(), view);
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
    public LocalInfoCollection getLocalInfoCollection(String oql) throws BOSException
    {
        try {
            return getController().getLocalInfoCollection(getContext(), oql);
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
    public LocalInfoInfo getLocalInfoInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalInfoInfo(getContext(), pk);
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
    public LocalInfoInfo getLocalInfoInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalInfoInfo(getContext(), pk, selector);
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
    public LocalInfoInfo getLocalInfoInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalInfoInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}