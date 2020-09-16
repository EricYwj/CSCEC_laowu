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

public class WorkPmtECEntry extends CoreBillEntryBase implements IWorkPmtECEntry
{
    public WorkPmtECEntry()
    {
        super();
        registerInterface(IWorkPmtECEntry.class, this);
    }
    public WorkPmtECEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IWorkPmtECEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E867BEFF");
    }
    private WorkPmtECEntryController getController() throws BOSException
    {
        return (WorkPmtECEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public WorkPmtECEntryInfo getWorkPmtECEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkPmtECEntryInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public WorkPmtECEntryInfo getWorkPmtECEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkPmtECEntryInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public WorkPmtECEntryInfo getWorkPmtECEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkPmtECEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public WorkPmtECEntryCollection getWorkPmtECEntryCollection() throws BOSException
    {
        try {
            return getController().getWorkPmtECEntryCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public WorkPmtECEntryCollection getWorkPmtECEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWorkPmtECEntryCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public WorkPmtECEntryCollection getWorkPmtECEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWorkPmtECEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}