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

public class ProjSecuProf extends DataBase implements IProjSecuProf
{
    public ProjSecuProf()
    {
        super();
        registerInterface(IProjSecuProf.class, this);
    }
    public ProjSecuProf(Context ctx)
    {
        super(ctx);
        registerInterface(IProjSecuProf.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("73D81128");
    }
    private ProjSecuProfController getController() throws BOSException
    {
        return (ProjSecuProfController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProjSecuProfInfo getProjSecuProfInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjSecuProfInfo(getContext(), pk);
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
    public ProjSecuProfInfo getProjSecuProfInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjSecuProfInfo(getContext(), pk, selector);
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
    public ProjSecuProfInfo getProjSecuProfInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjSecuProfInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProjSecuProfCollection getProjSecuProfCollection() throws BOSException
    {
        try {
            return getController().getProjSecuProfCollection(getContext());
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
    public ProjSecuProfCollection getProjSecuProfCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjSecuProfCollection(getContext(), view);
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
    public ProjSecuProfCollection getProjSecuProfCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjSecuProfCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}