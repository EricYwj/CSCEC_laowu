package com.kingdee.eas.zjlw.social;

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
import com.kingdee.eas.zjlw.social.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PayPrint extends CoreBillBase implements IPayPrint
{
    public PayPrint()
    {
        super();
        registerInterface(IPayPrint.class, this);
    }
    public PayPrint(Context ctx)
    {
        super(ctx);
        registerInterface(IPayPrint.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("67AF77A5");
    }
    private PayPrintController getController() throws BOSException
    {
        return (PayPrintController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PayPrintCollection getPayPrintCollection() throws BOSException
    {
        try {
            return getController().getPayPrintCollection(getContext());
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
    public PayPrintCollection getPayPrintCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPayPrintCollection(getContext(), view);
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
    public PayPrintCollection getPayPrintCollection(String oql) throws BOSException
    {
        try {
            return getController().getPayPrintCollection(getContext(), oql);
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
    public PayPrintInfo getPayPrintInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPayPrintInfo(getContext(), pk);
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
    public PayPrintInfo getPayPrintInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPayPrintInfo(getContext(), pk, selector);
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
    public PayPrintInfo getPayPrintInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPayPrintInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *initBill-User defined method
     *@param sql sql
     */
    public void initBill(String sql) throws BOSException, EASBizException
    {
        try {
            getController().initBill(getContext(), sql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}