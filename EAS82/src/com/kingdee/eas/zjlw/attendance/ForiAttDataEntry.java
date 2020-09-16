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

public class ForiAttDataEntry extends CoreBillEntryBase implements IForiAttDataEntry
{
    public ForiAttDataEntry()
    {
        super();
        registerInterface(IForiAttDataEntry.class, this);
    }
    public ForiAttDataEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IForiAttDataEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DBC50BEB");
    }
    private ForiAttDataEntryController getController() throws BOSException
    {
        return (ForiAttDataEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ForiAttDataEntryInfo getForiAttDataEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getForiAttDataEntryInfo(getContext(), pk);
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
    public ForiAttDataEntryInfo getForiAttDataEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getForiAttDataEntryInfo(getContext(), pk, selector);
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
    public ForiAttDataEntryInfo getForiAttDataEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getForiAttDataEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ForiAttDataEntryCollection getForiAttDataEntryCollection() throws BOSException
    {
        try {
            return getController().getForiAttDataEntryCollection(getContext());
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
    public ForiAttDataEntryCollection getForiAttDataEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getForiAttDataEntryCollection(getContext(), view);
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
    public ForiAttDataEntryCollection getForiAttDataEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getForiAttDataEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}