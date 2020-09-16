package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.zjlw.attendance.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ForiAttRule extends CoreBillBase implements IForiAttRule
{
    public ForiAttRule()
    {
        super();
        registerInterface(IForiAttRule.class, this);
    }
    public ForiAttRule(Context ctx)
    {
        super(ctx);
        registerInterface(IForiAttRule.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A3BC1819");
    }
    private ForiAttRuleController getController() throws BOSException
    {
        return (ForiAttRuleController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ForiAttRuleCollection getForiAttRuleCollection() throws BOSException
    {
        try {
            return getController().getForiAttRuleCollection(getContext());
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
    public ForiAttRuleCollection getForiAttRuleCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getForiAttRuleCollection(getContext(), view);
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
    public ForiAttRuleCollection getForiAttRuleCollection(String oql) throws BOSException
    {
        try {
            return getController().getForiAttRuleCollection(getContext(), oql);
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
    public ForiAttRuleInfo getForiAttRuleInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getForiAttRuleInfo(getContext(), pk);
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
    public ForiAttRuleInfo getForiAttRuleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getForiAttRuleInfo(getContext(), pk, selector);
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
    public ForiAttRuleInfo getForiAttRuleInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getForiAttRuleInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}