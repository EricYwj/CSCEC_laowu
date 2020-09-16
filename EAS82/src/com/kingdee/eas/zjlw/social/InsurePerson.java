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

public class InsurePerson extends CoreBillBase implements IInsurePerson
{
    public InsurePerson()
    {
        super();
        registerInterface(IInsurePerson.class, this);
    }
    public InsurePerson(Context ctx)
    {
        super(ctx);
        registerInterface(IInsurePerson.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("94B5EF6F");
    }
    private InsurePersonController getController() throws BOSException
    {
        return (InsurePersonController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InsurePersonCollection getInsurePersonCollection() throws BOSException
    {
        try {
            return getController().getInsurePersonCollection(getContext());
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
    public InsurePersonCollection getInsurePersonCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInsurePersonCollection(getContext(), view);
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
    public InsurePersonCollection getInsurePersonCollection(String oql) throws BOSException
    {
        try {
            return getController().getInsurePersonCollection(getContext(), oql);
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
    public InsurePersonInfo getInsurePersonInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInsurePersonInfo(getContext(), pk);
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
    public InsurePersonInfo getInsurePersonInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInsurePersonInfo(getContext(), pk, selector);
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
    public InsurePersonInfo getInsurePersonInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInsurePersonInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *修复错误数据-User defined method
     */
    public void updateErrData() throws BOSException
    {
        try {
            getController().updateErrData(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}