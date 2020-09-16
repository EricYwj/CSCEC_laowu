package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.zjlw.personmess.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WorkVisaEntry extends CoreBillEntryBase implements IWorkVisaEntry
{
    public WorkVisaEntry()
    {
        super();
        registerInterface(IWorkVisaEntry.class, this);
    }
    public WorkVisaEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IWorkVisaEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("69119C40");
    }
    private WorkVisaEntryController getController() throws BOSException
    {
        return (WorkVisaEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WorkVisaEntryInfo getWorkVisaEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkVisaEntryInfo(getContext(), pk);
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
    public WorkVisaEntryInfo getWorkVisaEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkVisaEntryInfo(getContext(), pk, selector);
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
    public WorkVisaEntryInfo getWorkVisaEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkVisaEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WorkVisaEntryCollection getWorkVisaEntryCollection() throws BOSException
    {
        try {
            return getController().getWorkVisaEntryCollection(getContext());
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
    public WorkVisaEntryCollection getWorkVisaEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWorkVisaEntryCollection(getContext(), view);
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
    public WorkVisaEntryCollection getWorkVisaEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWorkVisaEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}