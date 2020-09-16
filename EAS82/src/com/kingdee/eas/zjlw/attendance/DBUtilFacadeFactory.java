package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DBUtilFacadeFactory
{
    private DBUtilFacadeFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IDBUtilFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IDBUtilFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("91186DFE") ,com.kingdee.eas.zjlw.attendance.IDBUtilFacade.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IDBUtilFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IDBUtilFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("91186DFE") ,com.kingdee.eas.zjlw.attendance.IDBUtilFacade.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IDBUtilFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IDBUtilFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("91186DFE"));
    }
    public static com.kingdee.eas.zjlw.attendance.IDBUtilFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IDBUtilFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("91186DFE"));
    }
}