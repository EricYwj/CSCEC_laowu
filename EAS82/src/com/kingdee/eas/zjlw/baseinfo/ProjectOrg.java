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

public class ProjectOrg extends CoreBillBase implements IProjectOrg
{
    public ProjectOrg()
    {
        super();
        registerInterface(IProjectOrg.class, this);
    }
    public ProjectOrg(Context ctx)
    {
        super(ctx);
        registerInterface(IProjectOrg.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4494DF79");
    }
    private ProjectOrgController getController() throws BOSException
    {
        return (ProjectOrgController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProjectOrgCollection getProjectOrgCollection() throws BOSException
    {
        try {
            return getController().getProjectOrgCollection(getContext());
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
    public ProjectOrgCollection getProjectOrgCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjectOrgCollection(getContext(), view);
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
    public ProjectOrgCollection getProjectOrgCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjectOrgCollection(getContext(), oql);
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
    public ProjectOrgInfo getProjectOrgInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjectOrgInfo(getContext(), pk);
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
    public ProjectOrgInfo getProjectOrgInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjectOrgInfo(getContext(), pk, selector);
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
    public ProjectOrgInfo getProjectOrgInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjectOrgInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}