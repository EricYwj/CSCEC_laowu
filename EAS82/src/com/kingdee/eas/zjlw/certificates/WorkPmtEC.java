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

public class WorkPmtEC extends CoreBillBase implements IWorkPmtEC
{
    public WorkPmtEC()
    {
        super();
        registerInterface(IWorkPmtEC.class, this);
    }
    public WorkPmtEC(Context ctx)
    {
        super(ctx);
        registerInterface(IWorkPmtEC.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2A0C2133");
    }
    private WorkPmtECController getController() throws BOSException
    {
        return (WorkPmtECController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WorkPmtECCollection getWorkPmtECCollection() throws BOSException
    {
        try {
            return getController().getWorkPmtECCollection(getContext());
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
    public WorkPmtECCollection getWorkPmtECCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWorkPmtECCollection(getContext(), view);
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
    public WorkPmtECCollection getWorkPmtECCollection(String oql) throws BOSException
    {
        try {
            return getController().getWorkPmtECCollection(getContext(), oql);
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
    public WorkPmtECInfo getWorkPmtECInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkPmtECInfo(getContext(), pk);
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
    public WorkPmtECInfo getWorkPmtECInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkPmtECInfo(getContext(), pk, selector);
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
    public WorkPmtECInfo getWorkPmtECInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkPmtECInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *注销-User defined method
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