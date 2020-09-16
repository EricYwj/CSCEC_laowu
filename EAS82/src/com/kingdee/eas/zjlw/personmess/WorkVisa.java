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

public class WorkVisa extends CoreBillBase implements IWorkVisa
{
    public WorkVisa()
    {
        super();
        registerInterface(IWorkVisa.class, this);
    }
    public WorkVisa(Context ctx)
    {
        super(ctx);
        registerInterface(IWorkVisa.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("570B3F52");
    }
    private WorkVisaController getController() throws BOSException
    {
        return (WorkVisaController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WorkVisaCollection getWorkVisaCollection() throws BOSException
    {
        try {
            return getController().getWorkVisaCollection(getContext());
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
    public WorkVisaCollection getWorkVisaCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWorkVisaCollection(getContext(), view);
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
    public WorkVisaCollection getWorkVisaCollection(String oql) throws BOSException
    {
        try {
            return getController().getWorkVisaCollection(getContext(), oql);
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
    public WorkVisaInfo getWorkVisaInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkVisaInfo(getContext(), pk);
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
    public WorkVisaInfo getWorkVisaInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkVisaInfo(getContext(), pk, selector);
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
    public WorkVisaInfo getWorkVisaInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkVisaInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *指标项目业务人员-User defined method
     *@param pk 主键
     */
    public void bizPersonAudit(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            getController().bizPersonAudit(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *指标项目经理-User defined method
     *@param pk 主键
     */
    public void projectMessAudit(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            getController().projectMessAudit(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}