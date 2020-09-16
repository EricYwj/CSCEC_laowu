package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.zjlw.baseinfo.app.*;
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

public class DistrGovernment extends DataBase implements IDistrGovernment
{
    public DistrGovernment()
    {
        super();
        registerInterface(IDistrGovernment.class, this);
    }
    public DistrGovernment(Context ctx)
    {
        super(ctx);
        registerInterface(IDistrGovernment.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DDE23CEF");
    }
    private DistrGovernmentController getController() throws BOSException
    {
        return (DistrGovernmentController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DistrGovernmentInfo getDistrGovernmentInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDistrGovernmentInfo(getContext(), pk);
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
    public DistrGovernmentInfo getDistrGovernmentInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDistrGovernmentInfo(getContext(), pk, selector);
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
    public DistrGovernmentInfo getDistrGovernmentInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDistrGovernmentInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DistrGovernmentCollection getDistrGovernmentCollection() throws BOSException
    {
        try {
            return getController().getDistrGovernmentCollection(getContext());
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
    public DistrGovernmentCollection getDistrGovernmentCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDistrGovernmentCollection(getContext(), view);
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
    public DistrGovernmentCollection getDistrGovernmentCollection(String oql) throws BOSException
    {
        try {
            return getController().getDistrGovernmentCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}