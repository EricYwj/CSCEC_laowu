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

public class ForiPersEntry extends CoreBillEntryBase implements IForiPersEntry
{
    public ForiPersEntry()
    {
        super();
        registerInterface(IForiPersEntry.class, this);
    }
    public ForiPersEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IForiPersEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0AC792F8");
    }
    private ForiPersEntryController getController() throws BOSException
    {
        return (ForiPersEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ForiPersEntryInfo getForiPersEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getForiPersEntryInfo(getContext(), pk);
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
    public ForiPersEntryInfo getForiPersEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getForiPersEntryInfo(getContext(), pk, selector);
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
    public ForiPersEntryInfo getForiPersEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getForiPersEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ForiPersEntryCollection getForiPersEntryCollection() throws BOSException
    {
        try {
            return getController().getForiPersEntryCollection(getContext());
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
    public ForiPersEntryCollection getForiPersEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getForiPersEntryCollection(getContext(), view);
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
    public ForiPersEntryCollection getForiPersEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getForiPersEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}