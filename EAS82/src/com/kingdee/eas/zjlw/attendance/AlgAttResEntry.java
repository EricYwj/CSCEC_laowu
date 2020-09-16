package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.zjlw.attendance.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AlgAttResEntry extends CoreBillEntryBase implements IAlgAttResEntry
{
    public AlgAttResEntry()
    {
        super();
        registerInterface(IAlgAttResEntry.class, this);
    }
    public AlgAttResEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IAlgAttResEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F6C2C4FB");
    }
    private AlgAttResEntryController getController() throws BOSException
    {
        return (AlgAttResEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AlgAttResEntryInfo getAlgAttResEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAttResEntryInfo(getContext(), pk);
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
    public AlgAttResEntryInfo getAlgAttResEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAttResEntryInfo(getContext(), pk, selector);
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
    public AlgAttResEntryInfo getAlgAttResEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgAttResEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AlgAttResEntryCollection getAlgAttResEntryCollection() throws BOSException
    {
        try {
            return getController().getAlgAttResEntryCollection(getContext());
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
    public AlgAttResEntryCollection getAlgAttResEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAlgAttResEntryCollection(getContext(), view);
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
    public AlgAttResEntryCollection getAlgAttResEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getAlgAttResEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}