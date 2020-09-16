package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

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
import com.kingdee.eas.zjlw.certificates.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ASCancelEntry extends CoreBillEntryBase implements IASCancelEntry
{
    public ASCancelEntry()
    {
        super();
        registerInterface(IASCancelEntry.class, this);
    }
    public ASCancelEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IASCancelEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5AEF27F5");
    }
    private ASCancelEntryController getController() throws BOSException
    {
        return (ASCancelEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ASCancelEntryInfo getASCancelEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getASCancelEntryInfo(getContext(), pk);
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
    public ASCancelEntryInfo getASCancelEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getASCancelEntryInfo(getContext(), pk, selector);
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
    public ASCancelEntryInfo getASCancelEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getASCancelEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ASCancelEntryCollection getASCancelEntryCollection() throws BOSException
    {
        try {
            return getController().getASCancelEntryCollection(getContext());
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
    public ASCancelEntryCollection getASCancelEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getASCancelEntryCollection(getContext(), view);
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
    public ASCancelEntryCollection getASCancelEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getASCancelEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}