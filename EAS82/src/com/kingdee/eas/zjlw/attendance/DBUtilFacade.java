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

public class DBUtilFacade extends AbstractBizCtrl implements IDBUtilFacade
{
    public DBUtilFacade()
    {
        super();
        registerInterface(IDBUtilFacade.class, this);
    }
    public DBUtilFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IDBUtilFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("91186DFE");
    }
    private DBUtilFacadeController getController() throws BOSException
    {
        return (DBUtilFacadeController)getBizController();
    }
    /**
     *dbQuery-User defined method
     *@param sql sql
     *@return
     */
    public boolean dbQuery(String sql) throws BOSException
    {
        try {
            return getController().dbQuery(getContext(), sql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *¡¨Ω”≤‚ ‘-User defined method
     *@return
     */
    public String chkConn() throws BOSException
    {
        try {
            return getController().chkConn(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}