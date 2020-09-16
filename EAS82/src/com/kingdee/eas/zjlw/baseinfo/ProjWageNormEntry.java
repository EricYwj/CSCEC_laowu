package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.zjlw.baseinfo.app.*;
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

public class ProjWageNormEntry extends CoreBillEntryBase implements IProjWageNormEntry
{
    public ProjWageNormEntry()
    {
        super();
        registerInterface(IProjWageNormEntry.class, this);
    }
    public ProjWageNormEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IProjWageNormEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7285F743");
    }
    private ProjWageNormEntryController getController() throws BOSException
    {
        return (ProjWageNormEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ProjWageNormEntryInfo getProjWageNormEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjWageNormEntryInfo(getContext(), pk);
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
    public ProjWageNormEntryInfo getProjWageNormEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjWageNormEntryInfo(getContext(), pk, selector);
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
    public ProjWageNormEntryInfo getProjWageNormEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjWageNormEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ProjWageNormEntryCollection getProjWageNormEntryCollection() throws BOSException
    {
        try {
            return getController().getProjWageNormEntryCollection(getContext());
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
    public ProjWageNormEntryCollection getProjWageNormEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjWageNormEntryCollection(getContext(), view);
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
    public ProjWageNormEntryCollection getProjWageNormEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjWageNormEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}