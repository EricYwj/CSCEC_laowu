package com.kingdee.eas.zjlw.social;

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
import com.kingdee.eas.zjlw.social.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ProjBWREtyEntry extends CoreBillEntryBase implements IProjBWREtyEntry
{
    public ProjBWREtyEntry()
    {
        super();
        registerInterface(IProjBWREtyEntry.class, this);
    }
    public ProjBWREtyEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IProjBWREtyEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E503FE68");
    }
    private ProjBWREtyEntryController getController() throws BOSException
    {
        return (ProjBWREtyEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProjBWREtyEntryInfo getProjBWREtyEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjBWREtyEntryInfo(getContext(), pk);
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
    public ProjBWREtyEntryInfo getProjBWREtyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjBWREtyEntryInfo(getContext(), pk, selector);
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
    public ProjBWREtyEntryInfo getProjBWREtyEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjBWREtyEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProjBWREtyEntryCollection getProjBWREtyEntryCollection() throws BOSException
    {
        try {
            return getController().getProjBWREtyEntryCollection(getContext());
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
    public ProjBWREtyEntryCollection getProjBWREtyEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjBWREtyEntryCollection(getContext(), view);
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
    public ProjBWREtyEntryCollection getProjBWREtyEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjBWREtyEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}