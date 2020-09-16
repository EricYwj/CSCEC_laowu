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

public class SecuSplit extends CoreBillBase implements ISecuSplit
{
    public SecuSplit()
    {
        super();
        registerInterface(ISecuSplit.class, this);
    }
    public SecuSplit(Context ctx)
    {
        super(ctx);
        registerInterface(ISecuSplit.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9C3A0276");
    }
    private SecuSplitController getController() throws BOSException
    {
        return (SecuSplitController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SecuSplitCollection getSecuSplitCollection() throws BOSException
    {
        try {
            return getController().getSecuSplitCollection(getContext());
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
    public SecuSplitCollection getSecuSplitCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSecuSplitCollection(getContext(), view);
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
    public SecuSplitCollection getSecuSplitCollection(String oql) throws BOSException
    {
        try {
            return getController().getSecuSplitCollection(getContext(), oql);
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
    public SecuSplitInfo getSecuSplitInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuSplitInfo(getContext(), pk);
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
    public SecuSplitInfo getSecuSplitInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuSplitInfo(getContext(), pk, selector);
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
    public SecuSplitInfo getSecuSplitInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSecuSplitInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *实例化单据-User defined method
     *@param PK 若新增数据：pk=null，直接新增数据进行赋值；若编辑数据：pk为获取到的数据，重新新增数据，进行赋值传回
     *@param fullInfoPk 项目主键
     *@return
     */
    public SecuSplitInfo initBill(String PK, String fullInfoPk) throws BOSException, EASBizException
    {
        try {
            return getController().initBill(getContext(), PK, fullInfoPk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}