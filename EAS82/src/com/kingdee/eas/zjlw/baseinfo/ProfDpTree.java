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

public class ProfDpTree extends TreeBase implements IProfDpTree
{
    public ProfDpTree()
    {
        super();
        registerInterface(IProfDpTree.class, this);
    }
    public ProfDpTree(Context ctx)
    {
        super(ctx);
        registerInterface(IProfDpTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("39552D71");
    }
    private ProfDpTreeController getController() throws BOSException
    {
        return (ProfDpTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProfDpTreeInfo getProfDpTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProfDpTreeInfo(getContext(), pk);
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
    public ProfDpTreeInfo getProfDpTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProfDpTreeInfo(getContext(), pk, selector);
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
    public ProfDpTreeInfo getProfDpTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProfDpTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProfDpTreeCollection getProfDpTreeCollection() throws BOSException
    {
        try {
            return getController().getProfDpTreeCollection(getContext());
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
    public ProfDpTreeCollection getProfDpTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProfDpTreeCollection(getContext(), view);
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
    public ProfDpTreeCollection getProfDpTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getProfDpTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}