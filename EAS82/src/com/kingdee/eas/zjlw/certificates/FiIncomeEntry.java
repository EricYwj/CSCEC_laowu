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

public class FiIncomeEntry extends CoreBillEntryBase implements IFiIncomeEntry
{
    public FiIncomeEntry()
    {
        super();
        registerInterface(IFiIncomeEntry.class, this);
    }
    public FiIncomeEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFiIncomeEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("ACB6B0D5");
    }
    private FiIncomeEntryController getController() throws BOSException
    {
        return (FiIncomeEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FiIncomeEntryInfo getFiIncomeEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFiIncomeEntryInfo(getContext(), pk);
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
    public FiIncomeEntryInfo getFiIncomeEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFiIncomeEntryInfo(getContext(), pk, selector);
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
    public FiIncomeEntryInfo getFiIncomeEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFiIncomeEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FiIncomeEntryCollection getFiIncomeEntryCollection() throws BOSException
    {
        try {
            return getController().getFiIncomeEntryCollection(getContext());
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
    public FiIncomeEntryCollection getFiIncomeEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFiIncomeEntryCollection(getContext(), view);
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
    public FiIncomeEntryCollection getFiIncomeEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFiIncomeEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}