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

public class ExilivepermitECEntry extends CoreBillEntryBase implements IExilivepermitECEntry
{
    public ExilivepermitECEntry()
    {
        super();
        registerInterface(IExilivepermitECEntry.class, this);
    }
    public ExilivepermitECEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IExilivepermitECEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("13788108");
    }
    private ExilivepermitECEntryController getController() throws BOSException
    {
        return (ExilivepermitECEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ExilivepermitECEntryInfo getExilivepermitECEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getExilivepermitECEntryInfo(getContext(), pk);
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
    public ExilivepermitECEntryInfo getExilivepermitECEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getExilivepermitECEntryInfo(getContext(), pk, selector);
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
    public ExilivepermitECEntryInfo getExilivepermitECEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getExilivepermitECEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ExilivepermitECEntryCollection getExilivepermitECEntryCollection() throws BOSException
    {
        try {
            return getController().getExilivepermitECEntryCollection(getContext());
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
    public ExilivepermitECEntryCollection getExilivepermitECEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getExilivepermitECEntryCollection(getContext(), view);
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
    public ExilivepermitECEntryCollection getExilivepermitECEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getExilivepermitECEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}