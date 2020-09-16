package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AlgPersEntryFactory
{
    private AlgPersEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgPersEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgPersEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2438A4A4") ,com.kingdee.eas.zjlw.attendance.IAlgPersEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAlgPersEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgPersEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2438A4A4") ,com.kingdee.eas.zjlw.attendance.IAlgPersEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgPersEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgPersEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2438A4A4"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgPersEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgPersEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2438A4A4"));
    }
}