package com.kingdee.eas.zjlw.personinfo;

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
import com.kingdee.eas.zjlw.personinfo.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PersonHistory extends CoreBillBase implements IPersonHistory
{
    public PersonHistory()
    {
        super();
        registerInterface(IPersonHistory.class, this);
    }
    public PersonHistory(Context ctx)
    {
        super(ctx);
        registerInterface(IPersonHistory.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("45DA3855");
    }
    private PersonHistoryController getController() throws BOSException
    {
        return (PersonHistoryController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PersonHistoryCollection getPersonHistoryCollection() throws BOSException
    {
        try {
            return getController().getPersonHistoryCollection(getContext());
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
    public PersonHistoryCollection getPersonHistoryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPersonHistoryCollection(getContext(), view);
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
    public PersonHistoryCollection getPersonHistoryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPersonHistoryCollection(getContext(), oql);
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
    public PersonHistoryInfo getPersonHistoryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonHistoryInfo(getContext(), pk);
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
    public PersonHistoryInfo getPersonHistoryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonHistoryInfo(getContext(), pk, selector);
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
    public PersonHistoryInfo getPersonHistoryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonHistoryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}