package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.zjlw.attendance.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class dbQueryUtilFacade extends AbstractBizCtrl implements IdbQueryUtilFacade
{
    public dbQueryUtilFacade()
    {
        super();
        registerInterface(IdbQueryUtilFacade.class, this);
    }
    public dbQueryUtilFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IdbQueryUtilFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0B1C18A2");
    }
    private dbQueryUtilFacadeController getController() throws BOSException
    {
        return (dbQueryUtilFacadeController)getBizController();
    }
    /**
     *数据库查询并回写-User defined method
     *@param sql 查询语句
     *@return
     */
    public boolean dbQueryAndInit(String sql) throws BOSException
    {
        try {
            return getController().dbQueryAndInit(getContext(), sql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}