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

public class UplivePermitEC extends CoreBillBase implements IUplivePermitEC
{
    public UplivePermitEC()
    {
        super();
        registerInterface(IUplivePermitEC.class, this);
    }
    public UplivePermitEC(Context ctx)
    {
        super(ctx);
        registerInterface(IUplivePermitEC.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AF817DB1");
    }
    private UplivePermitECController getController() throws BOSException
    {
        return (UplivePermitECController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public UplivePermitECCollection getUplivePermitECCollection() throws BOSException
    {
        try {
            return getController().getUplivePermitECCollection(getContext());
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
    public UplivePermitECCollection getUplivePermitECCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getUplivePermitECCollection(getContext(), view);
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
    public UplivePermitECCollection getUplivePermitECCollection(String oql) throws BOSException
    {
        try {
            return getController().getUplivePermitECCollection(getContext(), oql);
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
    public UplivePermitECInfo getUplivePermitECInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getUplivePermitECInfo(getContext(), pk);
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
    public UplivePermitECInfo getUplivePermitECInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getUplivePermitECInfo(getContext(), pk, selector);
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
    public UplivePermitECInfo getUplivePermitECInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getUplivePermitECInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}