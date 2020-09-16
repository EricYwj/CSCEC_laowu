package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AttenceEntryFactory
{
    private AttenceEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAttenceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttenceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D23F56AA") ,com.kingdee.eas.zjlw.attendance.IAttenceEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAttenceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttenceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D23F56AA") ,com.kingdee.eas.zjlw.attendance.IAttenceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAttenceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttenceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D23F56AA"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAttenceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttenceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D23F56AA"));
    }
}