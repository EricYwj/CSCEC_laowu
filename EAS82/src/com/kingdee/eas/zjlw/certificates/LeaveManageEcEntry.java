package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.zjlw.certificates.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LeaveManageEcEntry extends CoreBillEntryBase implements ILeaveManageEcEntry
{
    public LeaveManageEcEntry()
    {
        super();
        registerInterface(ILeaveManageEcEntry.class, this);
    }
    public LeaveManageEcEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ILeaveManageEcEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FEBB83E9");
    }
    private LeaveManageEcEntryController getController() throws BOSException
    {
        return (LeaveManageEcEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public LeaveManageEcEntryInfo getLeaveManageEcEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLeaveManageEcEntryInfo(getContext(), pk);
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
    public LeaveManageEcEntryInfo getLeaveManageEcEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLeaveManageEcEntryInfo(getContext(), pk, selector);
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
    public LeaveManageEcEntryInfo getLeaveManageEcEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLeaveManageEcEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public LeaveManageEcEntryCollection getLeaveManageEcEntryCollection() throws BOSException
    {
        try {
            return getController().getLeaveManageEcEntryCollection(getContext());
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
    public LeaveManageEcEntryCollection getLeaveManageEcEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLeaveManageEcEntryCollection(getContext(), view);
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
    public LeaveManageEcEntryCollection getLeaveManageEcEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getLeaveManageEcEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}