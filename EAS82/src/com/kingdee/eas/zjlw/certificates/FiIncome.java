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

public class FiIncome extends CoreBillBase implements IFiIncome
{
    public FiIncome()
    {
        super();
        registerInterface(IFiIncome.class, this);
    }
    public FiIncome(Context ctx)
    {
        super(ctx);
        registerInterface(IFiIncome.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FB56E19D");
    }
    private FiIncomeController getController() throws BOSException
    {
        return (FiIncomeController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public FiIncomeCollection getFiIncomeCollection() throws BOSException
    {
        try {
            return getController().getFiIncomeCollection(getContext());
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
    public FiIncomeCollection getFiIncomeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFiIncomeCollection(getContext(), view);
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
    public FiIncomeCollection getFiIncomeCollection(String oql) throws BOSException
    {
        try {
            return getController().getFiIncomeCollection(getContext(), oql);
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
    public FiIncomeInfo getFiIncomeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFiIncomeInfo(getContext(), pk);
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
    public FiIncomeInfo getFiIncomeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFiIncomeInfo(getContext(), pk, selector);
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
    public FiIncomeInfo getFiIncomeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFiIncomeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}