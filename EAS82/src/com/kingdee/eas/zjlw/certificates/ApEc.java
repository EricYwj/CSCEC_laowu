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

public class ApEc extends CoreBillBase implements IApEc
{
    public ApEc()
    {
        super();
        registerInterface(IApEc.class, this);
    }
    public ApEc(Context ctx)
    {
        super(ctx);
        registerInterface(IApEc.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6FD13AFE");
    }
    private ApEcController getController() throws BOSException
    {
        return (ApEcController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ApEcCollection getApEcCollection() throws BOSException
    {
        try {
            return getController().getApEcCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public ApEcCollection getApEcCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getApEcCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public ApEcCollection getApEcCollection(String oql) throws BOSException
    {
        try {
            return getController().getApEcCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ApEcInfo getApEcInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getApEcInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public ApEcInfo getApEcInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getApEcInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public ApEcInfo getApEcInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getApEcInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ڹ��������-User defined method
     *@param PK ����
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
     *���ڹ�������˲�ͨ��-User defined method
     *@param PK ����
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
     *�������-User defined method
     *@param PK ����
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