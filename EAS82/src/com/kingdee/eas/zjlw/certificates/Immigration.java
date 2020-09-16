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

public class Immigration extends CoreBillBase implements IImmigration
{
    public Immigration()
    {
        super();
        registerInterface(IImmigration.class, this);
    }
    public Immigration(Context ctx)
    {
        super(ctx);
        registerInterface(IImmigration.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DD9D3C39");
    }
    private ImmigrationController getController() throws BOSException
    {
        return (ImmigrationController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ImmigrationCollection getImmigrationCollection() throws BOSException
    {
        try {
            return getController().getImmigrationCollection(getContext());
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
    public ImmigrationCollection getImmigrationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getImmigrationCollection(getContext(), view);
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
    public ImmigrationCollection getImmigrationCollection(String oql) throws BOSException
    {
        try {
            return getController().getImmigrationCollection(getContext(), oql);
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
    public ImmigrationInfo getImmigrationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getImmigrationInfo(getContext(), pk);
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
    public ImmigrationInfo getImmigrationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getImmigrationInfo(getContext(), pk, selector);
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
    public ImmigrationInfo getImmigrationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getImmigrationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *业务人员审核通过-User defined method
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
     *项目经理审核通过-User defined method
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