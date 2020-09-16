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

public class VisaEcEntry extends CoreBillEntryBase implements IVisaEcEntry
{
    public VisaEcEntry()
    {
        super();
        registerInterface(IVisaEcEntry.class, this);
    }
    public VisaEcEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IVisaEcEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B4EC0C02");
    }
    private VisaEcEntryController getController() throws BOSException
    {
        return (VisaEcEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public VisaEcEntryInfo getVisaEcEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getVisaEcEntryInfo(getContext(), pk);
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
    public VisaEcEntryInfo getVisaEcEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getVisaEcEntryInfo(getContext(), pk, selector);
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
    public VisaEcEntryInfo getVisaEcEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getVisaEcEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public VisaEcEntryCollection getVisaEcEntryCollection() throws BOSException
    {
        try {
            return getController().getVisaEcEntryCollection(getContext());
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
    public VisaEcEntryCollection getVisaEcEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getVisaEcEntryCollection(getContext(), view);
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
    public VisaEcEntryCollection getVisaEcEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getVisaEcEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}