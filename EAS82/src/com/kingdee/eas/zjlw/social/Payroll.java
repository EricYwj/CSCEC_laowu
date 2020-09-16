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
     *ȡ����-System defined method
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
     *ȡ����-System defined method
     *@param view ȡ����
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
     *ȡ����-System defined method
     *@param oql ȡ����
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
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
     *ȡֵ-System defined method
     *@param oql ȡֵ
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
     *ѭ�����й������ݷ�¼��Ϣ��������and��and�籣��Ŀ����ѯ��Ӧ�Ĳα���Ա�������ϣ�ȡ��һ�������������personId����ȡ��һ��������ָ��������ֶγ�����ʾΪ�����ݵ������-User defined method
     *@param projId �籣��Ŀid
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