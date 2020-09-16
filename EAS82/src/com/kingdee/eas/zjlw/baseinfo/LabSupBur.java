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

public class LabSupBur extends DataBase implements ILabSupBur
{
    public LabSupBur()
    {
        super();
        registerInterface(ILabSupBur.class, this);
    }
    public LabSupBur(Context ctx)
    {
        super(ctx);
        registerInterface(ILabSupBur.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C39A7110");
    }
    private LabSupBurController getController() throws BOSException
    {
        return (LabSupBurController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public LabSupBurInfo getLabSupBurInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLabSupBurInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public LabSupBurInfo getLabSupBurInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLabSupBurInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public LabSupBurInfo getLabSupBurInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLabSupBurInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LabSupBurCollection getLabSupBurCollection() throws BOSException
    {
        try {
            return getController().getLabSupBurCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public LabSupBurCollection getLabSupBurCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLabSupBurCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public LabSupBurCollection getLabSupBurCollection(String oql) throws BOSException
    {
        try {
            return getController().getLabSupBurCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}