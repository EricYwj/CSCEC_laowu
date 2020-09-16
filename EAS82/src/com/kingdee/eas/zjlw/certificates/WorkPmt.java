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

public class WorkPmt extends CoreBillBase implements IWorkPmt
{
    public WorkPmt()
    {
        super();
        registerInterface(IWorkPmt.class, this);
    }
    public WorkPmt(Context ctx)
    {
        super(ctx);
        registerInterface(IWorkPmt.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D9F339D5");
    }
    private WorkPmtController getController() throws BOSException
    {
        return (WorkPmtController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public WorkPmtCollection getWorkPmtCollection() throws BOSException
    {
        try {
            return getController().getWorkPmtCollection(getContext());
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
    public WorkPmtCollection getWorkPmtCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWorkPmtCollection(getContext(), view);
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
    public WorkPmtCollection getWorkPmtCollection(String oql) throws BOSException
    {
        try {
            return getController().getWorkPmtCollection(getContext(), oql);
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
    public WorkPmtInfo getWorkPmtInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkPmtInfo(getContext(), pk);
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
    public WorkPmtInfo getWorkPmtInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkPmtInfo(getContext(), pk, selector);
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
    public WorkPmtInfo getWorkPmtInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkPmtInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ע��-User defined method
     */
    public void dstry() throws BOSException
    {
        try {
            getController().dstry(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}