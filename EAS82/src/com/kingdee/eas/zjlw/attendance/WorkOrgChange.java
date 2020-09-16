package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.zjlw.attendance.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WorkOrgChange extends CoreBillBase implements IWorkOrgChange
{
    public WorkOrgChange()
    {
        super();
        registerInterface(IWorkOrgChange.class, this);
    }
    public WorkOrgChange(Context ctx)
    {
        super(ctx);
        registerInterface(IWorkOrgChange.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E652C85F");
    }
    private WorkOrgChangeController getController() throws BOSException
    {
        return (WorkOrgChangeController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WorkOrgChangeCollection getWorkOrgChangeCollection() throws BOSException
    {
        try {
            return getController().getWorkOrgChangeCollection(getContext());
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
    public WorkOrgChangeCollection getWorkOrgChangeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWorkOrgChangeCollection(getContext(), view);
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
    public WorkOrgChangeCollection getWorkOrgChangeCollection(String oql) throws BOSException
    {
        try {
            return getController().getWorkOrgChangeCollection(getContext(), oql);
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
    public WorkOrgChangeInfo getWorkOrgChangeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkOrgChangeInfo(getContext(), pk);
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
    public WorkOrgChangeInfo getWorkOrgChangeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkOrgChangeInfo(getContext(), pk, selector);
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
    public WorkOrgChangeInfo getWorkOrgChangeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkOrgChangeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}