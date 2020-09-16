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

public class ExilivepermitEC extends CoreBillBase implements IExilivepermitEC
{
    public ExilivepermitEC()
    {
        super();
        registerInterface(IExilivepermitEC.class, this);
    }
    public ExilivepermitEC(Context ctx)
    {
        super(ctx);
        registerInterface(IExilivepermitEC.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A00A7D8A");
    }
    private ExilivepermitECController getController() throws BOSException
    {
        return (ExilivepermitECController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ExilivepermitECCollection getExilivepermitECCollection() throws BOSException
    {
        try {
            return getController().getExilivepermitECCollection(getContext());
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
    public ExilivepermitECCollection getExilivepermitECCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getExilivepermitECCollection(getContext(), view);
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
    public ExilivepermitECCollection getExilivepermitECCollection(String oql) throws BOSException
    {
        try {
            return getController().getExilivepermitECCollection(getContext(), oql);
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
    public ExilivepermitECInfo getExilivepermitECInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getExilivepermitECInfo(getContext(), pk);
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
    public ExilivepermitECInfo getExilivepermitECInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getExilivepermitECInfo(getContext(), pk, selector);
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
    public ExilivepermitECInfo getExilivepermitECInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getExilivepermitECInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}