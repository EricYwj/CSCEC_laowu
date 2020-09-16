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

public class ForiPayrollEntry extends CoreBillEntryBase implements IForiPayrollEntry
{
    public ForiPayrollEntry()
    {
        super();
        registerInterface(IForiPayrollEntry.class, this);
    }
    public ForiPayrollEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IForiPayrollEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A25CA7ED");
    }
    private ForiPayrollEntryController getController() throws BOSException
    {
        return (ForiPayrollEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ForiPayrollEntryInfo getForiPayrollEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getForiPayrollEntryInfo(getContext(), pk);
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
    public ForiPayrollEntryInfo getForiPayrollEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getForiPayrollEntryInfo(getContext(), pk, selector);
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
    public ForiPayrollEntryInfo getForiPayrollEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getForiPayrollEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ForiPayrollEntryCollection getForiPayrollEntryCollection() throws BOSException
    {
        try {
            return getController().getForiPayrollEntryCollection(getContext());
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
    public ForiPayrollEntryCollection getForiPayrollEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getForiPayrollEntryCollection(getContext(), view);
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
    public ForiPayrollEntryCollection getForiPayrollEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getForiPayrollEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}