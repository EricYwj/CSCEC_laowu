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

public class DoubEc extends CoreBillBase implements IDoubEc
{
    public DoubEc()
    {
        super();
        registerInterface(IDoubEc.class, this);
    }
    public DoubEc(Context ctx)
    {
        super(ctx);
        registerInterface(IDoubEc.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C594BCA7");
    }
    private DoubEcController getController() throws BOSException
    {
        return (DoubEcController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DoubEcCollection getDoubEcCollection() throws BOSException
    {
        try {
            return getController().getDoubEcCollection(getContext());
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
    public DoubEcCollection getDoubEcCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDoubEcCollection(getContext(), view);
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
    public DoubEcCollection getDoubEcCollection(String oql) throws BOSException
    {
        try {
            return getController().getDoubEcCollection(getContext(), oql);
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
    public DoubEcInfo getDoubEcInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDoubEcInfo(getContext(), pk);
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
    public DoubEcInfo getDoubEcInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDoubEcInfo(getContext(), pk, selector);
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
    public DoubEcInfo getDoubEcInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDoubEcInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}