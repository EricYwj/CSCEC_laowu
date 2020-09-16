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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ProjectOrgEntry extends CoreBillEntryBase implements IProjectOrgEntry
{
    public ProjectOrgEntry()
    {
        super();
        registerInterface(IProjectOrgEntry.class, this);
    }
    public ProjectOrgEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IProjectOrgEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D318FC79");
    }
    private ProjectOrgEntryController getController() throws BOSException
    {
        return (ProjectOrgEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProjectOrgEntryInfo getProjectOrgEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjectOrgEntryInfo(getContext(), pk);
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
    public ProjectOrgEntryInfo getProjectOrgEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjectOrgEntryInfo(getContext(), pk, selector);
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
    public ProjectOrgEntryInfo getProjectOrgEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjectOrgEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProjectOrgEntryCollection getProjectOrgEntryCollection() throws BOSException
    {
        try {
            return getController().getProjectOrgEntryCollection(getContext());
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
    public ProjectOrgEntryCollection getProjectOrgEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjectOrgEntryCollection(getContext(), view);
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
    public ProjectOrgEntryCollection getProjectOrgEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjectOrgEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}