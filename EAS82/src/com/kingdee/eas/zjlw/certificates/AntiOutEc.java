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

public class AntiOutEc extends CoreBillBase implements IAntiOutEc
{
    public AntiOutEc()
    {
        super();
        registerInterface(IAntiOutEc.class, this);
    }
    public AntiOutEc(Context ctx)
    {
        super(ctx);
        registerInterface(IAntiOutEc.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6AA1BB19");
    }
    private AntiOutEcController getController() throws BOSException
    {
        return (AntiOutEcController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public AntiOutEcCollection getAntiOutEcCollection() throws BOSException
    {
        try {
            return getController().getAntiOutEcCollection(getContext());
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
    public AntiOutEcCollection getAntiOutEcCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAntiOutEcCollection(getContext(), view);
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
    public AntiOutEcCollection getAntiOutEcCollection(String oql) throws BOSException
    {
        try {
            return getController().getAntiOutEcCollection(getContext(), oql);
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
    public AntiOutEcInfo getAntiOutEcInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiOutEcInfo(getContext(), pk);
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
    public AntiOutEcInfo getAntiOutEcInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiOutEcInfo(getContext(), pk, selector);
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
    public AntiOutEcInfo getAntiOutEcInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiOutEcInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}