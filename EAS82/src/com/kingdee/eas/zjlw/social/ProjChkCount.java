package com.kingdee.eas.zjlw.social;

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
import com.kingdee.eas.zjlw.social.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ProjChkCount extends CoreBillBase implements IProjChkCount
{
    public ProjChkCount()
    {
        super();
        registerInterface(IProjChkCount.class, this);
    }
    public ProjChkCount(Context ctx)
    {
        super(ctx);
        registerInterface(IProjChkCount.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A69B8F46");
    }
    private ProjChkCountController getController() throws BOSException
    {
        return (ProjChkCountController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ProjChkCountCollection getProjChkCountCollection() throws BOSException
    {
        try {
            return getController().getProjChkCountCollection(getContext());
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
    public ProjChkCountCollection getProjChkCountCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProjChkCountCollection(getContext(), view);
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
    public ProjChkCountCollection getProjChkCountCollection(String oql) throws BOSException
    {
        try {
            return getController().getProjChkCountCollection(getContext(), oql);
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
    public ProjChkCountInfo getProjChkCountInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProjChkCountInfo(getContext(), pk);
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
    public ProjChkCountInfo getProjChkCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProjChkCountInfo(getContext(), pk, selector);
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
    public ProjChkCountInfo getProjChkCountInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProjChkCountInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}