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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CertAdd extends DataBase implements ICertAdd
{
    public CertAdd()
    {
        super();
        registerInterface(ICertAdd.class, this);
    }
    public CertAdd(Context ctx)
    {
        super(ctx);
        registerInterface(ICertAdd.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3F51642F");
    }
    private CertAddController getController() throws BOSException
    {
        return (CertAddController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public CertAddInfo getCertAddInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCertAddInfo(getContext(), pk);
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
    public CertAddInfo getCertAddInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCertAddInfo(getContext(), pk, selector);
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
    public CertAddInfo getCertAddInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCertAddInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CertAddCollection getCertAddCollection() throws BOSException
    {
        try {
            return getController().getCertAddCollection(getContext());
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
    public CertAddCollection getCertAddCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCertAddCollection(getContext(), view);
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
    public CertAddCollection getCertAddCollection(String oql) throws BOSException
    {
        try {
            return getController().getCertAddCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}