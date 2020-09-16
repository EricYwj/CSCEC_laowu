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

public class AlgCheckRulesEntry extends CoreBillEntryBase implements IAlgCheckRulesEntry
{
    public AlgCheckRulesEntry()
    {
        super();
        registerInterface(IAlgCheckRulesEntry.class, this);
    }
    public AlgCheckRulesEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IAlgCheckRulesEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2687386B");
    }
    private AlgCheckRulesEntryController getController() throws BOSException
    {
        return (AlgCheckRulesEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AlgCheckRulesEntryInfo getAlgCheckRulesEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgCheckRulesEntryInfo(getContext(), pk);
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
    public AlgCheckRulesEntryInfo getAlgCheckRulesEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgCheckRulesEntryInfo(getContext(), pk, selector);
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
    public AlgCheckRulesEntryInfo getAlgCheckRulesEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAlgCheckRulesEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AlgCheckRulesEntryCollection getAlgCheckRulesEntryCollection() throws BOSException
    {
        try {
            return getController().getAlgCheckRulesEntryCollection(getContext());
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
    public AlgCheckRulesEntryCollection getAlgCheckRulesEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAlgCheckRulesEntryCollection(getContext(), view);
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
    public AlgCheckRulesEntryCollection getAlgCheckRulesEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getAlgCheckRulesEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}