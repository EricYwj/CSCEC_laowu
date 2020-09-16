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

public class Ifilentry extends CoreBillBase implements IIfilentry
{
    public Ifilentry()
    {
        super();
        registerInterface(IIfilentry.class, this);
    }
    public Ifilentry(Context ctx)
    {
        super(ctx);
        registerInterface(IIfilentry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8E28A641");
    }
    private IfilentryController getController() throws BOSException
    {
        return (IfilentryController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public IfilentryCollection getIfilentryCollection() throws BOSException
    {
        try {
            return getController().getIfilentryCollection(getContext());
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
    public IfilentryCollection getIfilentryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getIfilentryCollection(getContext(), view);
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
    public IfilentryCollection getIfilentryCollection(String oql) throws BOSException
    {
        try {
            return getController().getIfilentryCollection(getContext(), oql);
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
    public IfilentryInfo getIfilentryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getIfilentryInfo(getContext(), pk);
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
    public IfilentryInfo getIfilentryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getIfilentryInfo(getContext(), pk, selector);
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
    public IfilentryInfo getIfilentryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getIfilentryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����������-User defined method
     *@param pk ����
     */
    public void leaAudit(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            getController().leaAudit(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}