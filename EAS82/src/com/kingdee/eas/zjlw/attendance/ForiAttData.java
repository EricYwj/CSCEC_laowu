package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.zjlw.attendance.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ForiAttData extends CoreBillBase implements IForiAttData
{
    public ForiAttData()
    {
        super();
        registerInterface(IForiAttData.class, this);
    }
    public ForiAttData(Context ctx)
    {
        super(ctx);
        registerInterface(IForiAttData.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A3B570C7");
    }
    private ForiAttDataController getController() throws BOSException
    {
        return (ForiAttDataController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ForiAttDataCollection getForiAttDataCollection() throws BOSException
    {
        try {
            return getController().getForiAttDataCollection(getContext());
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
    public ForiAttDataCollection getForiAttDataCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getForiAttDataCollection(getContext(), view);
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
    public ForiAttDataCollection getForiAttDataCollection(String oql) throws BOSException
    {
        try {
            return getController().getForiAttDataCollection(getContext(), oql);
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
    public ForiAttDataInfo getForiAttDataInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getForiAttDataInfo(getContext(), pk);
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
    public ForiAttDataInfo getForiAttDataInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getForiAttDataInfo(getContext(), pk, selector);
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
    public ForiAttDataInfo getForiAttDataInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getForiAttDataInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}