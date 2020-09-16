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

public class Payroll extends CoreBillBase implements IPayroll
{
    public Payroll()
    {
        super();
        registerInterface(IPayroll.class, this);
    }
    public Payroll(Context ctx)
    {
        super(ctx);
        registerInterface(IPayroll.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("13EBC865");
    }
    private PayrollController getController() throws BOSException
    {
        return (PayrollController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PayrollCollection getPayrollCollection() throws BOSException
    {
        try {
            return getController().getPayrollCollection(getContext());
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
    public PayrollCollection getPayrollCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPayrollCollection(getContext(), view);
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
    public PayrollCollection getPayrollCollection(String oql) throws BOSException
    {
        try {
            return getController().getPayrollCollection(getContext(), oql);
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
    public PayrollInfo getPayrollInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPayrollInfo(getContext(), pk);
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
    public PayrollInfo getPayrollInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPayrollInfo(getContext(), pk, selector);
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
    public PayrollInfo getPayrollInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPayrollInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *循环所有工资数据分录信息，按照姓and名and社保项目，查询对应的参保人员名单集合，取任一条，更新自身的personId（因取任一条，或出现个人资料字段出现显示为老数据的情况）-User defined method
     *@param projId 社保项目id
     */
    public void updateErrData(String projId) throws BOSException
    {
        try {
            getController().updateErrData(getContext(), projId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}