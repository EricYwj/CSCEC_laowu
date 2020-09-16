package com.kingdee.eas.zjlw.personmess;

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
import com.kingdee.eas.zjlw.personmess.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BusinessVisa extends CoreBillBase implements IBusinessVisa
{
    public BusinessVisa()
    {
        super();
        registerInterface(IBusinessVisa.class, this);
    }
    public BusinessVisa(Context ctx)
    {
        super(ctx);
        registerInterface(IBusinessVisa.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E80B1881");
    }
    private BusinessVisaController getController() throws BOSException
    {
        return (BusinessVisaController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BusinessVisaCollection getBusinessVisaCollection() throws BOSException
    {
        try {
            return getController().getBusinessVisaCollection(getContext());
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
    public BusinessVisaCollection getBusinessVisaCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBusinessVisaCollection(getContext(), view);
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
    public BusinessVisaCollection getBusinessVisaCollection(String oql) throws BOSException
    {
        try {
            return getController().getBusinessVisaCollection(getContext(), oql);
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
    public BusinessVisaInfo getBusinessVisaInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBusinessVisaInfo(getContext(), pk);
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
    public BusinessVisaInfo getBusinessVisaInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBusinessVisaInfo(getContext(), pk, selector);
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
    public BusinessVisaInfo getBusinessVisaInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBusinessVisaInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *增加-User defined method
     *@param id id
     */
    public void addName(String id) throws BOSException
    {
        try {
            getController().addName(getContext(), id);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}