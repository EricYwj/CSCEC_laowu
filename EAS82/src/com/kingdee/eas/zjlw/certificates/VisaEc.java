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

public class VisaEc extends CoreBillBase implements IVisaEc
{
    public VisaEc()
    {
        super();
        registerInterface(IVisaEc.class, this);
    }
    public VisaEc(Context ctx)
    {
        super(ctx);
        registerInterface(IVisaEc.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E3F67E50");
    }
    private VisaEcController getController() throws BOSException
    {
        return (VisaEcController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public VisaEcCollection getVisaEcCollection() throws BOSException
    {
        try {
            return getController().getVisaEcCollection(getContext());
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
    public VisaEcCollection getVisaEcCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getVisaEcCollection(getContext(), view);
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
    public VisaEcCollection getVisaEcCollection(String oql) throws BOSException
    {
        try {
            return getController().getVisaEcCollection(getContext(), oql);
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
    public VisaEcInfo getVisaEcInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getVisaEcInfo(getContext(), pk);
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
    public VisaEcInfo getVisaEcInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getVisaEcInfo(getContext(), pk, selector);
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
    public VisaEcInfo getVisaEcInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getVisaEcInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}