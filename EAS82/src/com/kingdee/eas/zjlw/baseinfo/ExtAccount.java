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

public class ExtAccount extends DataBase implements IExtAccount
{
    public ExtAccount()
    {
        super();
        registerInterface(IExtAccount.class, this);
    }
    public ExtAccount(Context ctx)
    {
        super(ctx);
        registerInterface(IExtAccount.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CA22973A");
    }
    private ExtAccountController getController() throws BOSException
    {
        return (ExtAccountController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ExtAccountInfo getExtAccountInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getExtAccountInfo(getContext(), pk);
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
    public ExtAccountInfo getExtAccountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getExtAccountInfo(getContext(), pk, selector);
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
    public ExtAccountInfo getExtAccountInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getExtAccountInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ExtAccountCollection getExtAccountCollection() throws BOSException
    {
        try {
            return getController().getExtAccountCollection(getContext());
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
    public ExtAccountCollection getExtAccountCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getExtAccountCollection(getContext(), view);
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
    public ExtAccountCollection getExtAccountCollection(String oql) throws BOSException
    {
        try {
            return getController().getExtAccountCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}