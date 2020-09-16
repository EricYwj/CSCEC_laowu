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

public class EmbassyRegEntry extends CoreBillEntryBase implements IEmbassyRegEntry
{
    public EmbassyRegEntry()
    {
        super();
        registerInterface(IEmbassyRegEntry.class, this);
    }
    public EmbassyRegEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IEmbassyRegEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("595CEDBF");
    }
    private EmbassyRegEntryController getController() throws BOSException
    {
        return (EmbassyRegEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public EmbassyRegEntryInfo getEmbassyRegEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEmbassyRegEntryInfo(getContext(), pk);
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
    public EmbassyRegEntryInfo getEmbassyRegEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEmbassyRegEntryInfo(getContext(), pk, selector);
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
    public EmbassyRegEntryInfo getEmbassyRegEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEmbassyRegEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public EmbassyRegEntryCollection getEmbassyRegEntryCollection() throws BOSException
    {
        try {
            return getController().getEmbassyRegEntryCollection(getContext());
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
    public EmbassyRegEntryCollection getEmbassyRegEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEmbassyRegEntryCollection(getContext(), view);
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
    public EmbassyRegEntryCollection getEmbassyRegEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getEmbassyRegEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}