package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.eas.zjlw.social.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PayrollEntry extends CoreBillEntryBase implements IPayrollEntry
{
    public PayrollEntry()
    {
        super();
        registerInterface(IPayrollEntry.class, this);
    }
    public PayrollEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IPayrollEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A08AC70D");
    }
    private PayrollEntryController getController() throws BOSException
    {
        return (PayrollEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PayrollEntryInfo getPayrollEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPayrollEntryInfo(getContext(), pk);
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
    public PayrollEntryInfo getPayrollEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPayrollEntryInfo(getContext(), pk, selector);
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
    public PayrollEntryInfo getPayrollEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPayrollEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PayrollEntryCollection getPayrollEntryCollection() throws BOSException
    {
        try {
            return getController().getPayrollEntryCollection(getContext());
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
    public PayrollEntryCollection getPayrollEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPayrollEntryCollection(getContext(), view);
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
    public PayrollEntryCollection getPayrollEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPayrollEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}