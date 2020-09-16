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

public class LaborBureau extends DataBase implements ILaborBureau
{
    public LaborBureau()
    {
        super();
        registerInterface(ILaborBureau.class, this);
    }
    public LaborBureau(Context ctx)
    {
        super(ctx);
        registerInterface(ILaborBureau.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B8FEE41C");
    }
    private LaborBureauController getController() throws BOSException
    {
        return (LaborBureauController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public LaborBureauInfo getLaborBureauInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLaborBureauInfo(getContext(), pk);
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
    public LaborBureauInfo getLaborBureauInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLaborBureauInfo(getContext(), pk, selector);
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
    public LaborBureauInfo getLaborBureauInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLaborBureauInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LaborBureauCollection getLaborBureauCollection() throws BOSException
    {
        try {
            return getController().getLaborBureauCollection(getContext());
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
    public LaborBureauCollection getLaborBureauCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLaborBureauCollection(getContext(), view);
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
    public LaborBureauCollection getLaborBureauCollection(String oql) throws BOSException
    {
        try {
            return getController().getLaborBureauCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}