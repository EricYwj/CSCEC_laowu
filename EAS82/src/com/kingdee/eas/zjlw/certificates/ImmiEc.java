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

public class ImmiEc extends CoreBillBase implements IImmiEc
{
    public ImmiEc()
    {
        super();
        registerInterface(IImmiEc.class, this);
    }
    public ImmiEc(Context ctx)
    {
        super(ctx);
        registerInterface(IImmiEc.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CDFD400F");
    }
    private ImmiEcController getController() throws BOSException
    {
        return (ImmiEcController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ImmiEcCollection getImmiEcCollection() throws BOSException
    {
        try {
            return getController().getImmiEcCollection(getContext());
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
    public ImmiEcCollection getImmiEcCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getImmiEcCollection(getContext(), view);
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
    public ImmiEcCollection getImmiEcCollection(String oql) throws BOSException
    {
        try {
            return getController().getImmiEcCollection(getContext(), oql);
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
    public ImmiEcInfo getImmiEcInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getImmiEcInfo(getContext(), pk);
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
    public ImmiEcInfo getImmiEcInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getImmiEcInfo(getContext(), pk, selector);
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
    public ImmiEcInfo getImmiEcInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getImmiEcInfo(getContext(), oql);
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