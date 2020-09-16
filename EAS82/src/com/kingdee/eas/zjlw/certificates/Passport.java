package com.kingdee.eas.zjlw.certificates;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Passport extends CoreBillBase implements IPassport
{
    public Passport()
    {
        super();
        registerInterface(IPassport.class, this);
    }
    public Passport(Context ctx)
    {
        super(ctx);
        registerInterface(IPassport.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AAE8B163");
    }
    private PassportController getController() throws BOSException
    {
        return (PassportController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PassportCollection getPassportCollection() throws BOSException
    {
        try {
            return getController().getPassportCollection(getContext());
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
    public PassportCollection getPassportCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPassportCollection(getContext(), view);
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
    public PassportCollection getPassportCollection(String oql) throws BOSException
    {
        try {
            return getController().getPassportCollection(getContext(), oql);
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
    public PassportInfo getPassportInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPassportInfo(getContext(), pk);
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
    public PassportInfo getPassportInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPassportInfo(getContext(), pk, selector);
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
    public PassportInfo getPassportInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPassportInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}