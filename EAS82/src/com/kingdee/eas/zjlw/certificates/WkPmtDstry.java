package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WkPmtDstry extends CoreBillBase implements IWkPmtDstry
{
    public WkPmtDstry()
    {
        super();
        registerInterface(IWkPmtDstry.class, this);
    }
    public WkPmtDstry(Context ctx)
    {
        super(ctx);
        registerInterface(IWkPmtDstry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9F77BEFA");
    }
    private WkPmtDstryController getController() throws BOSException
    {
        return (WkPmtDstryController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public WkPmtDstryCollection getWkPmtDstryCollection() throws BOSException
    {
        try {
            return getController().getWkPmtDstryCollection(getContext());
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
    public WkPmtDstryCollection getWkPmtDstryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWkPmtDstryCollection(getContext(), view);
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
    public WkPmtDstryCollection getWkPmtDstryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWkPmtDstryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public WkPmtDstryInfo getWkPmtDstryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtDstryInfo(getContext(), pk);
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
    public WkPmtDstryInfo getWkPmtDstryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtDstryInfo(getContext(), pk, selector);
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
    public WkPmtDstryInfo getWkPmtDstryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWkPmtDstryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}