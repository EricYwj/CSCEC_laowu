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

public class ProjBWREty extends CoreBillBase implements IProjBWREty
{
    public ProjBWREty()
    {
        super();
        registerInterface(IProjBWREty.class, this);
    }
    public ProjBWREty(Context ctx)
    {
        super(ctx);
        registerInterface(IProjBWREty.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0FDE242A");
    }
    private ProjBWREtyController getController() throws BOSException
    {
        return (ProjBWREtyController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ProjBWREtyCollection getProjBWREtyCollection() throws BOSException
    {
        try {
            return getController().getProjBWREtyCollection(getContext());
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
    public ProjBWREtyCollection getProjBWREtyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjBWREtyCollection(getContext(), view);
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
    public ProjBWREtyCollection getProjBWREtyCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjBWREtyCollection(getContext(), oql);
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
    public ProjBWREtyInfo getProjBWREtyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjBWREtyInfo(getContext(), pk);
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
    public ProjBWREtyInfo getProjBWREtyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjBWREtyInfo(getContext(), pk, selector);
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
    public ProjBWREtyInfo getProjBWREtyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjBWREtyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}