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

public class ProjChkCountEntry extends CoreBillEntryBase implements IProjChkCountEntry
{
    public ProjChkCountEntry()
    {
        super();
        registerInterface(IProjChkCountEntry.class, this);
    }
    public ProjChkCountEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IProjChkCountEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C2B924CC");
    }
    private ProjChkCountEntryController getController() throws BOSException
    {
        return (ProjChkCountEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProjChkCountEntryInfo getProjChkCountEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjChkCountEntryInfo(getContext(), pk);
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
    public ProjChkCountEntryInfo getProjChkCountEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjChkCountEntryInfo(getContext(), pk, selector);
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
    public ProjChkCountEntryInfo getProjChkCountEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjChkCountEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProjChkCountEntryCollection getProjChkCountEntryCollection() throws BOSException
    {
        try {
            return getController().getProjChkCountEntryCollection(getContext());
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
    public ProjChkCountEntryCollection getProjChkCountEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjChkCountEntryCollection(getContext(), view);
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
    public ProjChkCountEntryCollection getProjChkCountEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjChkCountEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}