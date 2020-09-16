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

public class AlgAtt extends CoreBillBase implements IAlgAtt
{
    public AlgAtt()
    {
        super();
        registerInterface(IAlgAtt.class, this);
    }
    public AlgAtt(Context ctx)
    {
        super(ctx);
        registerInterface(IAlgAtt.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("54CFD629");
    }
    private AlgAttController getController() throws BOSException
    {
        return (AlgAttController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AlgAttCollection getAlgAttCollection() throws BOSException
    {
        try {
            return getController().getAlgAttCollection(getContext());
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
    public AlgAttCollection getAlgAttCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAlgAttCollection(getContext(), view);
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
    public AlgAttCollection getAlgAttCollection(String oql) throws BOSException
    {
        try {
            return getController().getAlgAttCollection(getContext(), oql);
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
    public AlgAttInfo getAlgAttInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAttInfo(getContext(), pk);
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
    public AlgAttInfo getAlgAttInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAttInfo(getContext(), pk, selector);
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
    public AlgAttInfo getAlgAttInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAttInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}