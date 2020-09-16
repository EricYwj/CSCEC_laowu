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

public class WorkVisacancel extends CoreBillBase implements IWorkVisacancel
{
    public WorkVisacancel()
    {
        super();
        registerInterface(IWorkVisacancel.class, this);
    }
    public WorkVisacancel(Context ctx)
    {
        super(ctx);
        registerInterface(IWorkVisacancel.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EA815C7D");
    }
    private WorkVisacancelController getController() throws BOSException
    {
        return (WorkVisacancelController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WorkVisacancelCollection getWorkVisacancelCollection() throws BOSException
    {
        try {
            return getController().getWorkVisacancelCollection(getContext());
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
    public WorkVisacancelCollection getWorkVisacancelCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWorkVisacancelCollection(getContext(), view);
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
    public WorkVisacancelCollection getWorkVisacancelCollection(String oql) throws BOSException
    {
        try {
            return getController().getWorkVisacancelCollection(getContext(), oql);
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
    public WorkVisacancelInfo getWorkVisacancelInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkVisacancelInfo(getContext(), pk);
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
    public WorkVisacancelInfo getWorkVisacancelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkVisacancelInfo(getContext(), pk, selector);
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
    public WorkVisacancelInfo getWorkVisacancelInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkVisacancelInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}