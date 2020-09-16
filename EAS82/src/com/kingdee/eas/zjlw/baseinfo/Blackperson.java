package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.zjlw.baseinfo.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Blackperson extends TreeBase implements IBlackperson
{
    public Blackperson()
    {
        super();
        registerInterface(IBlackperson.class, this);
    }
    public Blackperson(Context ctx)
    {
        super(ctx);
        registerInterface(IBlackperson.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CFB74766");
    }
    private BlackpersonController getController() throws BOSException
    {
        return (BlackpersonController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BlackpersonInfo getBlackpersonInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBlackpersonInfo(getContext(), pk);
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
    public BlackpersonInfo getBlackpersonInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBlackpersonInfo(getContext(), pk, selector);
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
    public BlackpersonInfo getBlackpersonInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBlackpersonInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BlackpersonCollection getBlackpersonCollection() throws BOSException
    {
        try {
            return getController().getBlackpersonCollection(getContext());
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
    public BlackpersonCollection getBlackpersonCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBlackpersonCollection(getContext(), view);
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
    public BlackpersonCollection getBlackpersonCollection(String oql) throws BOSException
    {
        try {
            return getController().getBlackpersonCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}