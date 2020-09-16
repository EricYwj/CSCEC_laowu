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

public class ForiCheckedEntry extends CoreBillEntryBase implements IForiCheckedEntry
{
    public ForiCheckedEntry()
    {
        super();
        registerInterface(IForiCheckedEntry.class, this);
    }
    public ForiCheckedEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IForiCheckedEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6B61B6AB");
    }
    private ForiCheckedEntryController getController() throws BOSException
    {
        return (ForiCheckedEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ForiCheckedEntryInfo getForiCheckedEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getForiCheckedEntryInfo(getContext(), pk);
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
    public ForiCheckedEntryInfo getForiCheckedEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getForiCheckedEntryInfo(getContext(), pk, selector);
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
    public ForiCheckedEntryInfo getForiCheckedEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getForiCheckedEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ForiCheckedEntryCollection getForiCheckedEntryCollection() throws BOSException
    {
        try {
            return getController().getForiCheckedEntryCollection(getContext());
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
    public ForiCheckedEntryCollection getForiCheckedEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getForiCheckedEntryCollection(getContext(), view);
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
    public ForiCheckedEntryCollection getForiCheckedEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getForiCheckedEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}