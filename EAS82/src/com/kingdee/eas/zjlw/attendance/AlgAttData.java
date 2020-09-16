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

public class AlgAttData extends CoreBillBase implements IAlgAttData
{
    public AlgAttData()
    {
        super();
        registerInterface(IAlgAttData.class, this);
    }
    public AlgAttData(Context ctx)
    {
        super(ctx);
        registerInterface(IAlgAttData.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1F56FD73");
    }
    private AlgAttDataController getController() throws BOSException
    {
        return (AlgAttDataController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AlgAttDataCollection getAlgAttDataCollection() throws BOSException
    {
        try {
            return getController().getAlgAttDataCollection(getContext());
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
    public AlgAttDataCollection getAlgAttDataCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAlgAttDataCollection(getContext(), view);
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
    public AlgAttDataCollection getAlgAttDataCollection(String oql) throws BOSException
    {
        try {
            return getController().getAlgAttDataCollection(getContext(), oql);
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
    public AlgAttDataInfo getAlgAttDataInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAttDataInfo(getContext(), pk);
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
    public AlgAttDataInfo getAlgAttDataInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAttDataInfo(getContext(), pk, selector);
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
    public AlgAttDataInfo getAlgAttDataInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAttDataInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}