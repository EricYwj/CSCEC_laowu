package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AlgAttEntryFactory
{
    private AlgAttEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CB9CB3C9") ,com.kingdee.eas.zjlw.attendance.IAlgAttEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAlgAttEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CB9CB3C9") ,com.kingdee.eas.zjlw.attendance.IAlgAttEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CB9CB3C9"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CB9CB3C9"));
    }
}