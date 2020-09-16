package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.zjlw.social.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CheckCount extends CoreBillBase implements ICheckCount
{
    public CheckCount()
    {
        super();
        registerInterface(ICheckCount.class, this);
    }
    public CheckCount(Context ctx)
    {
        super(ctx);
        registerInterface(ICheckCount.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A14A6DA7");
    }
    private CheckCountController getController() throws BOSException
    {
        return (CheckCountController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CheckCountCollection getCheckCountCollection() throws BOSException
    {
        try {
            return getController().getCheckCountCollection(getContext());
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
    public CheckCountCollection getCheckCountCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCheckCountCollection(getContext(), view);
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
    public CheckCountCollection getCheckCountCollection(String oql) throws BOSException
    {
        try {
            return getController().getCheckCountCollection(getContext(), oql);
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
    public CheckCountInfo getCheckCountInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckCountInfo(getContext(), pk);
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
    public CheckCountInfo getCheckCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckCountInfo(getContext(), pk, selector);
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
    public CheckCountInfo getCheckCountInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckCountInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ͳ�����ݺ�ʵ��������-User defined method
     *@param info ����
     *@return
     */
    public IObjectValue initBill(IObjectValue info) throws BOSException, EASBizException
    {
        try {
            return getController().initBill(getContext(), info);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}