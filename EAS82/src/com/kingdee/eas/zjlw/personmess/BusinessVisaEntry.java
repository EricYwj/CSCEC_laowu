package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.zjlw.personmess.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BusinessVisaEntry extends CoreBillEntryBase implements IBusinessVisaEntry
{
    public BusinessVisaEntry()
    {
        super();
        registerInterface(IBusinessVisaEntry.class, this);
    }
    public BusinessVisaEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBusinessVisaEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3B452871");
    }
    private BusinessVisaEntryController getController() throws BOSException
    {
        return (BusinessVisaEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public BusinessVisaEntryInfo getBusinessVisaEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBusinessVisaEntryInfo(getContext(), pk);
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
    public BusinessVisaEntryInfo getBusinessVisaEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBusinessVisaEntryInfo(getContext(), pk, selector);
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
    public BusinessVisaEntryInfo getBusinessVisaEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBusinessVisaEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public BusinessVisaEntryCollection getBusinessVisaEntryCollection() throws BOSException
    {
        try {
            return getController().getBusinessVisaEntryCollection(getContext());
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
    public BusinessVisaEntryCollection getBusinessVisaEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBusinessVisaEntryCollection(getContext(), view);
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
    public BusinessVisaEntryCollection getBusinessVisaEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBusinessVisaEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}