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

public class LeaveOff extends DataBase implements ILeaveOff
{
    public LeaveOff()
    {
        super();
        registerInterface(ILeaveOff.class, this);
    }
    public LeaveOff(Context ctx)
    {
        super(ctx);
        registerInterface(ILeaveOff.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("34EF9126");
    }
    private LeaveOffController getController() throws BOSException
    {
        return (LeaveOffController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public LeaveOffInfo getLeaveOffInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLeaveOffInfo(getContext(), pk);
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
    public LeaveOffInfo getLeaveOffInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLeaveOffInfo(getContext(), pk, selector);
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
    public LeaveOffInfo getLeaveOffInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLeaveOffInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LeaveOffCollection getLeaveOffCollection() throws BOSException
    {
        try {
            return getController().getLeaveOffCollection(getContext());
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
    public LeaveOffCollection getLeaveOffCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLeaveOffCollection(getContext(), view);
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
    public LeaveOffCollection getLeaveOffCollection(String oql) throws BOSException
    {
        try {
            return getController().getLeaveOffCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}