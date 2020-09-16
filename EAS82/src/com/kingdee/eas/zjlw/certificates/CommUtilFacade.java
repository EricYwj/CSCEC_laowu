package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.zjlw.certificates.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class CommUtilFacade extends AbstractBizCtrl implements ICommUtilFacade
{
    public CommUtilFacade()
    {
        super();
        registerInterface(ICommUtilFacade.class, this);
    }
    public CommUtilFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICommUtilFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B8BD53F9");
    }
    private CommUtilFacadeController getController() throws BOSException
    {
        return (CommUtilFacadeController)getBizController();
    }
    /**
     *根据分录ID查询BOTP关系-User defined method
     *@param entryID 分录主键
     *@return
     */
    public boolean ifHaveDestBills(String entryID) throws BOSException, EASBizException
    {
        try {
            return getController().ifHaveDestBills(getContext(), entryID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}