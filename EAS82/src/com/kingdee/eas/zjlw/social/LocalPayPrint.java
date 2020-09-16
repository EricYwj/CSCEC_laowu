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

public class LocalPayPrint extends CoreBillBase implements ILocalPayPrint
{
    public LocalPayPrint()
    {
        super();
        registerInterface(ILocalPayPrint.class, this);
    }
    public LocalPayPrint(Context ctx)
    {
        super(ctx);
        registerInterface(ILocalPayPrint.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("15B29EB0");
    }
    private LocalPayPrintController getController() throws BOSException
    {
        return (LocalPayPrintController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LocalPayPrintCollection getLocalPayPrintCollection() throws BOSException
    {
        try {
            return getController().getLocalPayPrintCollection(getContext());
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
    public LocalPayPrintCollection getLocalPayPrintCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLocalPayPrintCollection(getContext(), view);
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
    public LocalPayPrintCollection getLocalPayPrintCollection(String oql) throws BOSException
    {
        try {
            return getController().getLocalPayPrintCollection(getContext(), oql);
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
    public LocalPayPrintInfo getLocalPayPrintInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalPayPrintInfo(getContext(), pk);
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
    public LocalPayPrintInfo getLocalPayPrintInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalPayPrintInfo(getContext(), pk, selector);
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
    public LocalPayPrintInfo getLocalPayPrintInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLocalPayPrintInfo(getContext(), oql);
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