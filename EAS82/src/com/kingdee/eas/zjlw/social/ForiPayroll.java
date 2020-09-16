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

public class ForiPayroll extends CoreBillBase implements IForiPayroll
{
    public ForiPayroll()
    {
        super();
        registerInterface(IForiPayroll.class, this);
    }
    public ForiPayroll(Context ctx)
    {
        super(ctx);
        registerInterface(IForiPayroll.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8AE8DB85");
    }
    private ForiPayrollController getController() throws BOSException
    {
        return (ForiPayrollController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ForiPayrollCollection getForiPayrollCollection() throws BOSException
    {
        try {
            return getController().getForiPayrollCollection(getContext());
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
    public ForiPayrollCollection getForiPayrollCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getForiPayrollCollection(getContext(), view);
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
    public ForiPayrollCollection getForiPayrollCollection(String oql) throws BOSException
    {
        try {
            return getController().getForiPayrollCollection(getContext(), oql);
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
    public ForiPayrollInfo getForiPayrollInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getForiPayrollInfo(getContext(), pk);
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
    public ForiPayrollInfo getForiPayrollInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getForiPayrollInfo(getContext(), pk, selector);
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
    public ForiPayrollInfo getForiPayrollInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getForiPayrollInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����޸�-User defined method
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