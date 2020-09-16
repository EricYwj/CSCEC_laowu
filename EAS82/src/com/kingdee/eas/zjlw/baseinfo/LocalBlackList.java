package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.zjlw.baseinfo.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LocalBlackList extends DataBase implements ILocalBlackList
{
    public LocalBlackList()
    {
        super();
        registerInterface(ILocalBlackList.class, this);
    }
    public LocalBlackList(Context ctx)
    {
        super(ctx);
        registerInterface(ILocalBlackList.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2D729580");
    }
    private LocalBlackListController getController() throws BOSException
    {
        return (LocalBlackListController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public LocalBlackListInfo getLocalBlackListInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalBlackListInfo(getContext(), pk);
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
    public LocalBlackListInfo getLocalBlackListInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalBlackListInfo(getContext(), pk, selector);
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
    public LocalBlackListInfo getLocalBlackListInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalBlackListInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LocalBlackListCollection getLocalBlackListCollection() throws BOSException
    {
        try {
            return getController().getLocalBlackListCollection(getContext());
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
    public LocalBlackListCollection getLocalBlackListCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLocalBlackListCollection(getContext(), view);
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
    public LocalBlackListCollection getLocalBlackListCollection(String oql) throws BOSException
    {
        try {
            return getController().getLocalBlackListCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}