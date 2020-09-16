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

public class Businesscheck extends CoreBillBase implements IBusinesscheck
{
    public Businesscheck()
    {
        super();
        registerInterface(IBusinesscheck.class, this);
    }
    public Businesscheck(Context ctx)
    {
        super(ctx);
        registerInterface(IBusinesscheck.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9E268297");
    }
    private BusinesscheckController getController() throws BOSException
    {
        return (BusinesscheckController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public BusinesscheckCollection getBusinesscheckCollection() throws BOSException
    {
        try {
            return getController().getBusinesscheckCollection(getContext());
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
    public BusinesscheckCollection getBusinesscheckCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBusinesscheckCollection(getContext(), view);
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
    public BusinesscheckCollection getBusinesscheckCollection(String oql) throws BOSException
    {
        try {
            return getController().getBusinesscheckCollection(getContext(), oql);
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
    public BusinesscheckInfo getBusinesscheckInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBusinesscheckInfo(getContext(), pk);
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
    public BusinesscheckInfo getBusinesscheckInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBusinesscheckInfo(getContext(), pk, selector);
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
    public BusinesscheckInfo getBusinesscheckInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBusinesscheckInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}