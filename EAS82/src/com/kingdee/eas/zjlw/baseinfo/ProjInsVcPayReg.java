package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.eas.zjlw.baseinfo.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ProjInsVcPayReg extends CoreBillBase implements IProjInsVcPayReg
{
    public ProjInsVcPayReg()
    {
        super();
        registerInterface(IProjInsVcPayReg.class, this);
    }
    public ProjInsVcPayReg(Context ctx)
    {
        super(ctx);
        registerInterface(IProjInsVcPayReg.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0CF3389C");
    }
    private ProjInsVcPayRegController getController() throws BOSException
    {
        return (ProjInsVcPayRegController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProjInsVcPayRegCollection getProjInsVcPayRegCollection() throws BOSException
    {
        try {
            return getController().getProjInsVcPayRegCollection(getContext());
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
    public ProjInsVcPayRegCollection getProjInsVcPayRegCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjInsVcPayRegCollection(getContext(), view);
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
    public ProjInsVcPayRegCollection getProjInsVcPayRegCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjInsVcPayRegCollection(getContext(), oql);
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
    public ProjInsVcPayRegInfo getProjInsVcPayRegInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjInsVcPayRegInfo(getContext(), pk);
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
    public ProjInsVcPayRegInfo getProjInsVcPayRegInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjInsVcPayRegInfo(getContext(), pk, selector);
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
    public ProjInsVcPayRegInfo getProjInsVcPayRegInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjInsVcPayRegInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}