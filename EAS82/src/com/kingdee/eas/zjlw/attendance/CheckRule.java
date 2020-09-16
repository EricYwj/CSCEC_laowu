package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.zjlw.attendance.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CheckRule extends DataBase implements ICheckRule
{
    public CheckRule()
    {
        super();
        registerInterface(ICheckRule.class, this);
    }
    public CheckRule(Context ctx)
    {
        super(ctx);
        registerInterface(ICheckRule.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FEDB02E0");
    }
    private CheckRuleController getController() throws BOSException
    {
        return (CheckRuleController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CheckRuleInfo getCheckRuleInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckRuleInfo(getContext(), pk);
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
    public CheckRuleInfo getCheckRuleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckRuleInfo(getContext(), pk, selector);
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
    public CheckRuleInfo getCheckRuleInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckRuleInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CheckRuleCollection getCheckRuleCollection() throws BOSException
    {
        try {
            return getController().getCheckRuleCollection(getContext());
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
    public CheckRuleCollection getCheckRuleCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCheckRuleCollection(getContext(), view);
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
    public CheckRuleCollection getCheckRuleCollection(String oql) throws BOSException
    {
        try {
            return getController().getCheckRuleCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}