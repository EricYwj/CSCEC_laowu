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

public class ForiAttResEntry extends CoreBillEntryBase implements IForiAttResEntry
{
    public ForiAttResEntry()
    {
        super();
        registerInterface(IForiAttResEntry.class, this);
    }
    public ForiAttResEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IForiAttResEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("754F6E4F");
    }
    private ForiAttResEntryController getController() throws BOSException
    {
        return (ForiAttResEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ForiAttResEntryInfo getForiAttResEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getForiAttResEntryInfo(getContext(), pk);
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
    public ForiAttResEntryInfo getForiAttResEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getForiAttResEntryInfo(getContext(), pk, selector);
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
    public ForiAttResEntryInfo getForiAttResEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getForiAttResEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ForiAttResEntryCollection getForiAttResEntryCollection() throws BOSException
    {
        try {
            return getController().getForiAttResEntryCollection(getContext());
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
    public ForiAttResEntryCollection getForiAttResEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getForiAttResEntryCollection(getContext(), view);
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
    public ForiAttResEntryCollection getForiAttResEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getForiAttResEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}