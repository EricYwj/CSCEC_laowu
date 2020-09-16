package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.eas.zjlw.baseinfo.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ProjectWork extends CoreBillBase implements IProjectWork
{
    public ProjectWork()
    {
        super();
        registerInterface(IProjectWork.class, this);
    }
    public ProjectWork(Context ctx)
    {
        super(ctx);
        registerInterface(IProjectWork.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4E0AA91C");
    }
    private ProjectWorkController getController() throws BOSException
    {
        return (ProjectWorkController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProjectWorkCollection getProjectWorkCollection() throws BOSException
    {
        try {
            return getController().getProjectWorkCollection(getContext());
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
    public ProjectWorkCollection getProjectWorkCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjectWorkCollection(getContext(), view);
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
    public ProjectWorkCollection getProjectWorkCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjectWorkCollection(getContext(), oql);
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
    public ProjectWorkInfo getProjectWorkInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjectWorkInfo(getContext(), pk);
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
    public ProjectWorkInfo getProjectWorkInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjectWorkInfo(getContext(), pk, selector);
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
    public ProjectWorkInfo getProjectWorkInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjectWorkInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}