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

public class Exilivepermit extends CoreBillBase implements IExilivepermit
{
    public Exilivepermit()
    {
        super();
        registerInterface(IExilivepermit.class, this);
    }
    public Exilivepermit(Context ctx)
    {
        super(ctx);
        registerInterface(IExilivepermit.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A3BABFEC");
    }
    private ExilivepermitController getController() throws BOSException
    {
        return (ExilivepermitController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ExilivepermitCollection getExilivepermitCollection() throws BOSException
    {
        try {
            return getController().getExilivepermitCollection(getContext());
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
    public ExilivepermitCollection getExilivepermitCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getExilivepermitCollection(getContext(), view);
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
    public ExilivepermitCollection getExilivepermitCollection(String oql) throws BOSException
    {
        try {
            return getController().getExilivepermitCollection(getContext(), oql);
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
    public ExilivepermitInfo getExilivepermitInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getExilivepermitInfo(getContext(), pk);
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
    public ExilivepermitInfo getExilivepermitInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getExilivepermitInfo(getContext(), pk, selector);
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
    public ExilivepermitInfo getExilivepermitInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getExilivepermitInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}