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

public class AlgattenceResult extends DataBase implements IAlgattenceResult
{
    public AlgattenceResult()
    {
        super();
        registerInterface(IAlgattenceResult.class, this);
    }
    public AlgattenceResult(Context ctx)
    {
        super(ctx);
        registerInterface(IAlgattenceResult.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("677B89D1");
    }
    private AlgattenceResultController getController() throws BOSException
    {
        return (AlgattenceResultController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AlgattenceResultInfo getAlgattenceResultInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgattenceResultInfo(getContext(), pk);
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
    public AlgattenceResultInfo getAlgattenceResultInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgattenceResultInfo(getContext(), pk, selector);
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
    public AlgattenceResultInfo getAlgattenceResultInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgattenceResultInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AlgattenceResultCollection getAlgattenceResultCollection() throws BOSException
    {
        try {
            return getController().getAlgattenceResultCollection(getContext());
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
    public AlgattenceResultCollection getAlgattenceResultCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAlgattenceResultCollection(getContext(), view);
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
    public AlgattenceResultCollection getAlgattenceResultCollection(String oql) throws BOSException
    {
        try {
            return getController().getAlgattenceResultCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}