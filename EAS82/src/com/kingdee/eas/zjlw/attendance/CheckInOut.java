package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.zjlw.attendance.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
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

public class CheckInOut extends DataBase implements ICheckInOut
{
    public CheckInOut()
    {
        super();
        registerInterface(ICheckInOut.class, this);
    }
    public CheckInOut(Context ctx)
    {
        super(ctx);
        registerInterface(ICheckInOut.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DC02EC85");
    }
    private CheckInOutController getController() throws BOSException
    {
        return (CheckInOutController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CheckInOutInfo getCheckInOutInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckInOutInfo(getContext(), pk);
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
    public CheckInOutInfo getCheckInOutInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckInOutInfo(getContext(), pk, selector);
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
    public CheckInOutInfo getCheckInOutInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckInOutInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CheckInOutCollection getCheckInOutCollection() throws BOSException
    {
        try {
            return getController().getCheckInOutCollection(getContext());
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
    public CheckInOutCollection getCheckInOutCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCheckInOutCollection(getContext(), view);
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
    public CheckInOutCollection getCheckInOutCollection(String oql) throws BOSException
    {
        try {
            return getController().getCheckInOutCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *数据库查询-User defined method
     *@param sql 查询语句
     *@return
     */
    public boolean dbQuery(String sql) throws BOSException
    {
        try {
            return getController().dbQuery(getContext(), sql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *init-User defined method
     */
    public void init() throws BOSException
    {
        try {
            getController().init(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}