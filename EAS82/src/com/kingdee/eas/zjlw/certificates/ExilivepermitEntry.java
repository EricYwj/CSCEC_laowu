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

public class ExilivepermitEntry extends CoreBillEntryBase implements IExilivepermitEntry
{
    public ExilivepermitEntry()
    {
        super();
        registerInterface(IExilivepermitEntry.class, this);
    }
    public ExilivepermitEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IExilivepermitEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("24DC6BE6");
    }
    private ExilivepermitEntryController getController() throws BOSException
    {
        return (ExilivepermitEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ExilivepermitEntryInfo getExilivepermitEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getExilivepermitEntryInfo(getContext(), pk);
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
    public ExilivepermitEntryInfo getExilivepermitEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getExilivepermitEntryInfo(getContext(), pk, selector);
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
    public ExilivepermitEntryInfo getExilivepermitEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getExilivepermitEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ExilivepermitEntryCollection getExilivepermitEntryCollection() throws BOSException
    {
        try {
            return getController().getExilivepermitEntryCollection(getContext());
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
    public ExilivepermitEntryCollection getExilivepermitEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getExilivepermitEntryCollection(getContext(), view);
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
    public ExilivepermitEntryCollection getExilivepermitEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getExilivepermitEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}