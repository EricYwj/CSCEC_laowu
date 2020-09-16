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

public class Passportapply extends CoreBillBase implements IPassportapply
{
    public Passportapply()
    {
        super();
        registerInterface(IPassportapply.class, this);
    }
    public Passportapply(Context ctx)
    {
        super(ctx);
        registerInterface(IPassportapply.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9E5937EB");
    }
    private PassportapplyController getController() throws BOSException
    {
        return (PassportapplyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PassportapplyCollection getPassportapplyCollection() throws BOSException
    {
        try {
            return getController().getPassportapplyCollection(getContext());
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
    public PassportapplyCollection getPassportapplyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPassportapplyCollection(getContext(), view);
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
    public PassportapplyCollection getPassportapplyCollection(String oql) throws BOSException
    {
        try {
            return getController().getPassportapplyCollection(getContext(), oql);
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
    public PassportapplyInfo getPassportapplyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPassportapplyInfo(getContext(), pk);
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
    public PassportapplyInfo getPassportapplyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPassportapplyInfo(getContext(), pk, selector);
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
    public PassportapplyInfo getPassportapplyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPassportapplyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *国内工作部审核-User defined method
     *@param PK 主键
     */
    public void internalAudit(IObjectPK PK) throws BOSException, EASBizException
    {
        try {
            getController().internalAudit(getContext(), PK);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *国内工作部审核不通过-User defined method
     *@param PK 主键
     */
    public void UNinternalAudit(IObjectPK PK) throws BOSException, EASBizException
    {
        try {
            getController().UNinternalAudit(getContext(), PK);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *劳务部审核-User defined method
     *@param PK 主键
     */
    public void LWAudit(IObjectPK PK) throws BOSException, EASBizException
    {
        try {
            getController().LWAudit(getContext(), PK);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}