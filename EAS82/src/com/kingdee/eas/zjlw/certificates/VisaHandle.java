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

public class VisaHandle extends CoreBillBase implements IVisaHandle
{
    public VisaHandle()
    {
        super();
        registerInterface(IVisaHandle.class, this);
    }
    public VisaHandle(Context ctx)
    {
        super(ctx);
        registerInterface(IVisaHandle.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F224B6DA");
    }
    private VisaHandleController getController() throws BOSException
    {
        return (VisaHandleController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public VisaHandleCollection getVisaHandleCollection() throws BOSException
    {
        try {
            return getController().getVisaHandleCollection(getContext());
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
    public VisaHandleCollection getVisaHandleCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getVisaHandleCollection(getContext(), view);
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
    public VisaHandleCollection getVisaHandleCollection(String oql) throws BOSException
    {
        try {
            return getController().getVisaHandleCollection(getContext(), oql);
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
    public VisaHandleInfo getVisaHandleInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getVisaHandleInfo(getContext(), pk);
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
    public VisaHandleInfo getVisaHandleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getVisaHandleInfo(getContext(), pk, selector);
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
    public VisaHandleInfo getVisaHandleInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getVisaHandleInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}