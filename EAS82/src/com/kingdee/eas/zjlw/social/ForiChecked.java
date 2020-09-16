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

public class ForiChecked extends CoreBillBase implements IForiChecked
{
    public ForiChecked()
    {
        super();
        registerInterface(IForiChecked.class, this);
    }
    public ForiChecked(Context ctx)
    {
        super(ctx);
        registerInterface(IForiChecked.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E6090E07");
    }
    private ForiCheckedController getController() throws BOSException
    {
        return (ForiCheckedController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ForiCheckedCollection getForiCheckedCollection() throws BOSException
    {
        try {
            return getController().getForiCheckedCollection(getContext());
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
    public ForiCheckedCollection getForiCheckedCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getForiCheckedCollection(getContext(), view);
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
    public ForiCheckedCollection getForiCheckedCollection(String oql) throws BOSException
    {
        try {
            return getController().getForiCheckedCollection(getContext(), oql);
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
    public ForiCheckedInfo getForiCheckedInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getForiCheckedInfo(getContext(), pk);
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
    public ForiCheckedInfo getForiCheckedInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getForiCheckedInfo(getContext(), pk, selector);
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
    public ForiCheckedInfo getForiCheckedInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getForiCheckedInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *实例化单据-User defined method
     *@param infoId 项目ID
     *@return
     */
    public ForiCheckedInfo initBill(String infoId) throws BOSException, EASBizException
    {
        try {
            return getController().initBill(getContext(), infoId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}