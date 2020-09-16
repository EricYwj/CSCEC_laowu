package com.kingdee.eas.zjlw.personmess;

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
import com.kingdee.eas.zjlw.personmess.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PersonMan extends CoreBillBase implements IPersonMan
{
    public PersonMan()
    {
        super();
        registerInterface(IPersonMan.class, this);
    }
    public PersonMan(Context ctx)
    {
        super(ctx);
        registerInterface(IPersonMan.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7CBAA965");
    }
    private PersonManController getController() throws BOSException
    {
        return (PersonManController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PersonManCollection getPersonManCollection() throws BOSException
    {
        try {
            return getController().getPersonManCollection(getContext());
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
    public PersonManCollection getPersonManCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPersonManCollection(getContext(), view);
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
    public PersonManCollection getPersonManCollection(String oql) throws BOSException
    {
        try {
            return getController().getPersonManCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PersonManInfo getPersonManInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonManInfo(getContext(), pk);
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
    public PersonManInfo getPersonManInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonManInfo(getContext(), pk, selector);
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
    public PersonManInfo getPersonManInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonManInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}