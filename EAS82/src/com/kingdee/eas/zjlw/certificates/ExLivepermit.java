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

public class ExLivepermit extends CoreBillBase implements IExLivepermit
{
    public ExLivepermit()
    {
        super();
        registerInterface(IExLivepermit.class, this);
    }
    public ExLivepermit(Context ctx)
    {
        super(ctx);
        registerInterface(IExLivepermit.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1EE9CDEB");
    }
    private ExLivepermitController getController() throws BOSException
    {
        return (ExLivepermitController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ExLivepermitCollection getExLivepermitCollection() throws BOSException
    {
        try {
            return getController().getExLivepermitCollection(getContext());
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
    public ExLivepermitCollection getExLivepermitCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getExLivepermitCollection(getContext(), view);
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
    public ExLivepermitCollection getExLivepermitCollection(String oql) throws BOSException
    {
        try {
            return getController().getExLivepermitCollection(getContext(), oql);
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
    public ExLivepermitInfo getExLivepermitInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getExLivepermitInfo(getContext(), pk);
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
    public ExLivepermitInfo getExLivepermitInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getExLivepermitInfo(getContext(), pk, selector);
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
    public ExLivepermitInfo getExLivepermitInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getExLivepermitInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ԭ��Ϊ���ŵ���-User defined method
     *@param PK PK
     */
    public void initForSplitBill(String PK) throws BOSException, EASBizException
    {
        try {
            getController().initForSplitBill(getContext(), PK);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}