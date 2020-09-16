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

public class AttenceData extends DataBase implements IAttenceData
{
    public AttenceData()
    {
        super();
        registerInterface(IAttenceData.class, this);
    }
    public AttenceData(Context ctx)
    {
        super(ctx);
        registerInterface(IAttenceData.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3853FA72");
    }
    private AttenceDataController getController() throws BOSException
    {
        return (AttenceDataController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AttenceDataInfo getAttenceDataInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAttenceDataInfo(getContext(), pk);
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
    public AttenceDataInfo getAttenceDataInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAttenceDataInfo(getContext(), pk, selector);
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
    public AttenceDataInfo getAttenceDataInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAttenceDataInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AttenceDataCollection getAttenceDataCollection() throws BOSException
    {
        try {
            return getController().getAttenceDataCollection(getContext());
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
    public AttenceDataCollection getAttenceDataCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAttenceDataCollection(getContext(), view);
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
    public AttenceDataCollection getAttenceDataCollection(String oql) throws BOSException
    {
        try {
            return getController().getAttenceDataCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}