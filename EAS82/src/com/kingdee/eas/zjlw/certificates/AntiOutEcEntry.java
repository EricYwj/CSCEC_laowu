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

public class AntiOutEcEntry extends CoreBillEntryBase implements IAntiOutEcEntry
{
    public AntiOutEcEntry()
    {
        super();
        registerInterface(IAntiOutEcEntry.class, this);
    }
    public AntiOutEcEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IAntiOutEcEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5AE464D9");
    }
    private AntiOutEcEntryController getController() throws BOSException
    {
        return (AntiOutEcEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AntiOutEcEntryInfo getAntiOutEcEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiOutEcEntryInfo(getContext(), pk);
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
    public AntiOutEcEntryInfo getAntiOutEcEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiOutEcEntryInfo(getContext(), pk, selector);
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
    public AntiOutEcEntryInfo getAntiOutEcEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAntiOutEcEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AntiOutEcEntryCollection getAntiOutEcEntryCollection() throws BOSException
    {
        try {
            return getController().getAntiOutEcEntryCollection(getContext());
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
    public AntiOutEcEntryCollection getAntiOutEcEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAntiOutEcEntryCollection(getContext(), view);
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
    public AntiOutEcEntryCollection getAntiOutEcEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getAntiOutEcEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}