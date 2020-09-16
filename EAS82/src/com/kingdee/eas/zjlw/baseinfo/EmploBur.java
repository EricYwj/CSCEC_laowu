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

public class EmploBur extends DataBase implements IEmploBur
{
    public EmploBur()
    {
        super();
        registerInterface(IEmploBur.class, this);
    }
    public EmploBur(Context ctx)
    {
        super(ctx);
        registerInterface(IEmploBur.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1E095422");
    }
    private EmploBurController getController() throws BOSException
    {
        return (EmploBurController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public EmploBurInfo getEmploBurInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEmploBurInfo(getContext(), pk);
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
    public EmploBurInfo getEmploBurInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEmploBurInfo(getContext(), pk, selector);
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
    public EmploBurInfo getEmploBurInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEmploBurInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EmploBurCollection getEmploBurCollection() throws BOSException
    {
        try {
            return getController().getEmploBurCollection(getContext());
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
    public EmploBurCollection getEmploBurCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEmploBurCollection(getContext(), view);
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
    public EmploBurCollection getEmploBurCollection(String oql) throws BOSException
    {
        try {
            return getController().getEmploBurCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}