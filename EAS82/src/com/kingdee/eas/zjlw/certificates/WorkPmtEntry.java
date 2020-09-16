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

public class WorkPmtEntry extends CoreBillEntryBase implements IWorkPmtEntry
{
    public WorkPmtEntry()
    {
        super();
        registerInterface(IWorkPmtEntry.class, this);
    }
    public WorkPmtEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IWorkPmtEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("19A0BB9D");
    }
    private WorkPmtEntryController getController() throws BOSException
    {
        return (WorkPmtEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WorkPmtEntryInfo getWorkPmtEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkPmtEntryInfo(getContext(), pk);
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
    public WorkPmtEntryInfo getWorkPmtEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkPmtEntryInfo(getContext(), pk, selector);
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
    public WorkPmtEntryInfo getWorkPmtEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkPmtEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WorkPmtEntryCollection getWorkPmtEntryCollection() throws BOSException
    {
        try {
            return getController().getWorkPmtEntryCollection(getContext());
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
    public WorkPmtEntryCollection getWorkPmtEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWorkPmtEntryCollection(getContext(), view);
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
    public WorkPmtEntryCollection getWorkPmtEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWorkPmtEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}