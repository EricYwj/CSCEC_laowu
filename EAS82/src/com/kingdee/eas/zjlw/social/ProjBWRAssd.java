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

public class ProjBWRAssd extends CoreBillBase implements IProjBWRAssd
{
    public ProjBWRAssd()
    {
        super();
        registerInterface(IProjBWRAssd.class, this);
    }
    public ProjBWRAssd(Context ctx)
    {
        super(ctx);
        registerInterface(IProjBWRAssd.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EBE48B83");
    }
    private ProjBWRAssdController getController() throws BOSException
    {
        return (ProjBWRAssdController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProjBWRAssdCollection getProjBWRAssdCollection() throws BOSException
    {
        try {
            return getController().getProjBWRAssdCollection(getContext());
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
    public ProjBWRAssdCollection getProjBWRAssdCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjBWRAssdCollection(getContext(), view);
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
    public ProjBWRAssdCollection getProjBWRAssdCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjBWRAssdCollection(getContext(), oql);
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
    public ProjBWRAssdInfo getProjBWRAssdInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjBWRAssdInfo(getContext(), pk);
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
    public ProjBWRAssdInfo getProjBWRAssdInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjBWRAssdInfo(getContext(), pk, selector);
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
    public ProjBWRAssdInfo getProjBWRAssdInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjBWRAssdInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}