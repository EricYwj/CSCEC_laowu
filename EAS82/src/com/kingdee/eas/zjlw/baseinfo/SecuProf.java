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

public class SecuProf extends DataBase implements ISecuProf
{
    public SecuProf()
    {
        super();
        registerInterface(ISecuProf.class, this);
    }
    public SecuProf(Context ctx)
    {
        super(ctx);
        registerInterface(ISecuProf.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0F6A5DAB");
    }
    private SecuProfController getController() throws BOSException
    {
        return (SecuProfController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public SecuProfInfo getSecuProfInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuProfInfo(getContext(), pk);
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
    public SecuProfInfo getSecuProfInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuProfInfo(getContext(), pk, selector);
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
    public SecuProfInfo getSecuProfInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuProfInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public SecuProfCollection getSecuProfCollection() throws BOSException
    {
        try {
            return getController().getSecuProfCollection(getContext());
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
    public SecuProfCollection getSecuProfCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSecuProfCollection(getContext(), view);
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
    public SecuProfCollection getSecuProfCollection(String oql) throws BOSException
    {
        try {
            return getController().getSecuProfCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}