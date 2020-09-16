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

public class LeaveManage extends CoreBillBase implements ILeaveManage
{
    public LeaveManage()
    {
        super();
        registerInterface(ILeaveManage.class, this);
    }
    public LeaveManage(Context ctx)
    {
        super(ctx);
        registerInterface(ILeaveManage.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A447400B");
    }
    private LeaveManageController getController() throws BOSException
    {
        return (LeaveManageController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public LeaveManageCollection getLeaveManageCollection() throws BOSException
    {
        try {
            return getController().getLeaveManageCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public LeaveManageCollection getLeaveManageCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLeaveManageCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public LeaveManageCollection getLeaveManageCollection(String oql) throws BOSException
    {
        try {
            return getController().getLeaveManageCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public LeaveManageInfo getLeaveManageInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLeaveManageInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public LeaveManageInfo getLeaveManageInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLeaveManageInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public LeaveManageInfo getLeaveManageInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLeaveManageInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}