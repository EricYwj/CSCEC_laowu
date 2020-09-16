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

public class SecuPayCount extends CoreBillBase implements ISecuPayCount
{
    public SecuPayCount()
    {
        super();
        registerInterface(ISecuPayCount.class, this);
    }
    public SecuPayCount(Context ctx)
    {
        super(ctx);
        registerInterface(ISecuPayCount.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("059A646B");
    }
    private SecuPayCountController getController() throws BOSException
    {
        return (SecuPayCountController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SecuPayCountCollection getSecuPayCountCollection() throws BOSException
    {
        try {
            return getController().getSecuPayCountCollection(getContext());
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
    public SecuPayCountCollection getSecuPayCountCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSecuPayCountCollection(getContext(), view);
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
    public SecuPayCountCollection getSecuPayCountCollection(String oql) throws BOSException
    {
        try {
            return getController().getSecuPayCountCollection(getContext(), oql);
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
    public SecuPayCountInfo getSecuPayCountInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuPayCountInfo(getContext(), pk);
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
    public SecuPayCountInfo getSecuPayCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuPayCountInfo(getContext(), pk, selector);
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
    public SecuPayCountInfo getSecuPayCountInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuPayCountInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}