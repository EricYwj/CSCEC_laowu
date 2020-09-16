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

public class AlgCheckRules extends CoreBillBase implements IAlgCheckRules
{
    public AlgCheckRules()
    {
        super();
        registerInterface(IAlgCheckRules.class, this);
    }
    public AlgCheckRules(Context ctx)
    {
        super(ctx);
        registerInterface(IAlgCheckRules.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("62697447");
    }
    private AlgCheckRulesController getController() throws BOSException
    {
        return (AlgCheckRulesController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AlgCheckRulesCollection getAlgCheckRulesCollection() throws BOSException
    {
        try {
            return getController().getAlgCheckRulesCollection(getContext());
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
    public AlgCheckRulesCollection getAlgCheckRulesCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAlgCheckRulesCollection(getContext(), view);
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
    public AlgCheckRulesCollection getAlgCheckRulesCollection(String oql) throws BOSException
    {
        try {
            return getController().getAlgCheckRulesCollection(getContext(), oql);
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
    public AlgCheckRulesInfo getAlgCheckRulesInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgCheckRulesInfo(getContext(), pk);
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
    public AlgCheckRulesInfo getAlgCheckRulesInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgCheckRulesInfo(getContext(), pk, selector);
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
    public AlgCheckRulesInfo getAlgCheckRulesInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgCheckRulesInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}