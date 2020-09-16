package com.kingdee.eas.zjlw.social;

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
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.zjlw.social.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Vabaweather extends CoreBillBase implements IVabaweather
{
    public Vabaweather()
    {
        super();
        registerInterface(IVabaweather.class, this);
    }
    public Vabaweather(Context ctx)
    {
        super(ctx);
        registerInterface(IVabaweather.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0E7483CA");
    }
    private VabaweatherController getController() throws BOSException
    {
        return (VabaweatherController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public VabaweatherCollection getVabaweatherCollection() throws BOSException
    {
        try {
            return getController().getVabaweatherCollection(getContext());
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
    public VabaweatherCollection getVabaweatherCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getVabaweatherCollection(getContext(), view);
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
    public VabaweatherCollection getVabaweatherCollection(String oql) throws BOSException
    {
        try {
            return getController().getVabaweatherCollection(getContext(), oql);
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
    public VabaweatherInfo getVabaweatherInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getVabaweatherInfo(getContext(), pk);
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
    public VabaweatherInfo getVabaweatherInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getVabaweatherInfo(getContext(), pk, selector);
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
    public VabaweatherInfo getVabaweatherInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getVabaweatherInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}