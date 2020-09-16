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

public class LeaveManageEc extends CoreBillBase implements ILeaveManageEc
{
    public LeaveManageEc()
    {
        super();
        registerInterface(ILeaveManageEc.class, this);
    }
    public LeaveManageEc(Context ctx)
    {
        super(ctx);
        registerInterface(ILeaveManageEc.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AF777209");
    }
    private LeaveManageEcController getController() throws BOSException
    {
        return (LeaveManageEcController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LeaveManageEcCollection getLeaveManageEcCollection() throws BOSException
    {
        try {
            return getController().getLeaveManageEcCollection(getContext());
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
    public LeaveManageEcCollection getLeaveManageEcCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLeaveManageEcCollection(getContext(), view);
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
    public LeaveManageEcCollection getLeaveManageEcCollection(String oql) throws BOSException
    {
        try {
            return getController().getLeaveManageEcCollection(getContext(), oql);
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
    public LeaveManageEcInfo getLeaveManageEcInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLeaveManageEcInfo(getContext(), pk);
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
    public LeaveManageEcInfo getLeaveManageEcInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLeaveManageEcInfo(getContext(), pk, selector);
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
    public LeaveManageEcInfo getLeaveManageEcInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLeaveManageEcInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}