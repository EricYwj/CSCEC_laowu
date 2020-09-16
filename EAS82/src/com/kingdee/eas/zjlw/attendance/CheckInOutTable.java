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

public class CheckInOutTable extends DataBase implements ICheckInOutTable
{
    public CheckInOutTable()
    {
        super();
        registerInterface(ICheckInOutTable.class, this);
    }
    public CheckInOutTable(Context ctx)
    {
        super(ctx);
        registerInterface(ICheckInOutTable.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F4B26A49");
    }
    private CheckInOutTableController getController() throws BOSException
    {
        return (CheckInOutTableController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public CheckInOutTableInfo getCheckInOutTableInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckInOutTableInfo(getContext(), pk);
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
    public CheckInOutTableInfo getCheckInOutTableInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckInOutTableInfo(getContext(), pk, selector);
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
    public CheckInOutTableInfo getCheckInOutTableInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckInOutTableInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CheckInOutTableCollection getCheckInOutTableCollection() throws BOSException
    {
        try {
            return getController().getCheckInOutTableCollection(getContext());
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
    public CheckInOutTableCollection getCheckInOutTableCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCheckInOutTableCollection(getContext(), view);
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
    public CheckInOutTableCollection getCheckInOutTableCollection(String oql) throws BOSException
    {
        try {
            return getController().getCheckInOutTableCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *init-User defined method
     *@return
     */
    public String init() throws BOSException
    {
        try {
            return getController().init(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}