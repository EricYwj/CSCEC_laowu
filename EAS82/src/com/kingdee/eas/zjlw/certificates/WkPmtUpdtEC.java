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

public class WkPmtUpdtEC extends CoreBillBase implements IWkPmtUpdtEC
{
    public WkPmtUpdtEC()
    {
        super();
        registerInterface(IWkPmtUpdtEC.class, this);
    }
    public WkPmtUpdtEC(Context ctx)
    {
        super(ctx);
        registerInterface(IWkPmtUpdtEC.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6C50F7DB");
    }
    private WkPmtUpdtECController getController() throws BOSException
    {
        return (WkPmtUpdtECController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public WkPmtUpdtECCollection getWkPmtUpdtECCollection() throws BOSException
    {
        try {
            return getController().getWkPmtUpdtECCollection(getContext());
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
    public WkPmtUpdtECCollection getWkPmtUpdtECCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWkPmtUpdtECCollection(getContext(), view);
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
    public WkPmtUpdtECCollection getWkPmtUpdtECCollection(String oql) throws BOSException
    {
        try {
            return getController().getWkPmtUpdtECCollection(getContext(), oql);
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
    public WkPmtUpdtECInfo getWkPmtUpdtECInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtECInfo(getContext(), pk);
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
    public WkPmtUpdtECInfo getWkPmtUpdtECInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtECInfo(getContext(), pk, selector);
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
    public WkPmtUpdtECInfo getWkPmtUpdtECInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtUpdtECInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}