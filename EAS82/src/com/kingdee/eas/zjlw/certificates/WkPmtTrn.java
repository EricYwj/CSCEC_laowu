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

public class WkPmtTrn extends CoreBillBase implements IWkPmtTrn
{
    public WkPmtTrn()
    {
        super();
        registerInterface(IWkPmtTrn.class, this);
    }
    public WkPmtTrn(Context ctx)
    {
        super(ctx);
        registerInterface(IWkPmtTrn.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("57027D5E");
    }
    private WkPmtTrnController getController() throws BOSException
    {
        return (WkPmtTrnController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WkPmtTrnCollection getWkPmtTrnCollection() throws BOSException
    {
        try {
            return getController().getWkPmtTrnCollection(getContext());
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
    public WkPmtTrnCollection getWkPmtTrnCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWkPmtTrnCollection(getContext(), view);
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
    public WkPmtTrnCollection getWkPmtTrnCollection(String oql) throws BOSException
    {
        try {
            return getController().getWkPmtTrnCollection(getContext(), oql);
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
    public WkPmtTrnInfo getWkPmtTrnInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtTrnInfo(getContext(), pk);
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
    public WkPmtTrnInfo getWkPmtTrnInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtTrnInfo(getContext(), pk, selector);
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
    public WkPmtTrnInfo getWkPmtTrnInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtTrnInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}