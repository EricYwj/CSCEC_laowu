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

public class Attence extends CoreBillBase implements IAttence
{
    public Attence()
    {
        super();
        registerInterface(IAttence.class, this);
    }
    public Attence(Context ctx)
    {
        super(ctx);
        registerInterface(IAttence.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("53992AA8");
    }
    private AttenceController getController() throws BOSException
    {
        return (AttenceController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AttenceCollection getAttenceCollection() throws BOSException
    {
        try {
            return getController().getAttenceCollection(getContext());
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
    public AttenceCollection getAttenceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAttenceCollection(getContext(), view);
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
    public AttenceCollection getAttenceCollection(String oql) throws BOSException
    {
        try {
            return getController().getAttenceCollection(getContext(), oql);
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
    public AttenceInfo getAttenceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAttenceInfo(getContext(), pk);
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
    public AttenceInfo getAttenceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAttenceInfo(getContext(), pk, selector);
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
    public AttenceInfo getAttenceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAttenceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}