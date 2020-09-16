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

public class ImmiEcEntry extends CoreBillEntryBase implements IImmiEcEntry
{
    public ImmiEcEntry()
    {
        super();
        registerInterface(IImmiEcEntry.class, this);
    }
    public ImmiEcEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IImmiEcEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BBE389A3");
    }
    private ImmiEcEntryController getController() throws BOSException
    {
        return (ImmiEcEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ImmiEcEntryInfo getImmiEcEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getImmiEcEntryInfo(getContext(), pk);
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
    public ImmiEcEntryInfo getImmiEcEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getImmiEcEntryInfo(getContext(), pk, selector);
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
    public ImmiEcEntryInfo getImmiEcEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getImmiEcEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ImmiEcEntryCollection getImmiEcEntryCollection() throws BOSException
    {
        try {
            return getController().getImmiEcEntryCollection(getContext());
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
    public ImmiEcEntryCollection getImmiEcEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getImmiEcEntryCollection(getContext(), view);
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
    public ImmiEcEntryCollection getImmiEcEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getImmiEcEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}