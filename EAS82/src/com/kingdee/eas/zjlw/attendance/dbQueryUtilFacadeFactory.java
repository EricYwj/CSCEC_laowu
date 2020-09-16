package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class dbQueryUtilFacadeFactory
{
    private dbQueryUtilFacadeFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IdbQueryUtilFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IdbQueryUtilFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0B1C18A2") ,com.kingdee.eas.zjlw.attendance.IdbQueryUtilFacade.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IdbQueryUtilFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IdbQueryUtilFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0B1C18A2") ,com.kingdee.eas.zjlw.attendance.IdbQueryUtilFacade.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IdbQueryUtilFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IdbQueryUtilFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0B1C18A2"));
    }
    public static com.kingdee.eas.zjlw.attendance.IdbQueryUtilFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IdbQueryUtilFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0B1C18A2"));
    }
}