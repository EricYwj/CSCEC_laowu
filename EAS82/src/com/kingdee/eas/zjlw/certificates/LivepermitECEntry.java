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

public class LivepermitECEntry extends CoreBillEntryBase implements ILivepermitECEntry
{
    public LivepermitECEntry()
    {
        super();
        registerInterface(ILivepermitECEntry.class, this);
    }
    public LivepermitECEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ILivepermitECEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7697EE5C");
    }
    private LivepermitECEntryController getController() throws BOSException
    {
        return (LivepermitECEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public LivepermitECEntryInfo getLivepermitECEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLivepermitECEntryInfo(getContext(), pk);
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
    public LivepermitECEntryInfo getLivepermitECEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLivepermitECEntryInfo(getContext(), pk, selector);
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
    public LivepermitECEntryInfo getLivepermitECEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLivepermitECEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LivepermitECEntryCollection getLivepermitECEntryCollection() throws BOSException
    {
        try {
            return getController().getLivepermitECEntryCollection(getContext());
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
    public LivepermitECEntryCollection getLivepermitECEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLivepermitECEntryCollection(getContext(), view);
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
    public LivepermitECEntryCollection getLivepermitECEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getLivepermitECEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}