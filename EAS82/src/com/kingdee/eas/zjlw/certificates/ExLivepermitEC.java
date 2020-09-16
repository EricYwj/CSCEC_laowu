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

public class ExLivepermitEC extends CoreBillBase implements IExLivepermitEC
{
    public ExLivepermitEC()
    {
        super();
        registerInterface(IExLivepermitEC.class, this);
    }
    public ExLivepermitEC(Context ctx)
    {
        super(ctx);
        registerInterface(IExLivepermitEC.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0BAE07C9");
    }
    private ExLivepermitECController getController() throws BOSException
    {
        return (ExLivepermitECController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ExLivepermitECCollection getExLivepermitECCollection() throws BOSException
    {
        try {
            return getController().getExLivepermitECCollection(getContext());
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
    public ExLivepermitECCollection getExLivepermitECCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getExLivepermitECCollection(getContext(), view);
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
    public ExLivepermitECCollection getExLivepermitECCollection(String oql) throws BOSException
    {
        try {
            return getController().getExLivepermitECCollection(getContext(), oql);
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
    public ExLivepermitECInfo getExLivepermitECInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getExLivepermitECInfo(getContext(), pk);
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
    public ExLivepermitECInfo getExLivepermitECInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getExLivepermitECInfo(getContext(), pk, selector);
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
    public ExLivepermitECInfo getExLivepermitECInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getExLivepermitECInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}