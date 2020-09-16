package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AttenceFactory
{
    private AttenceFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAttence getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttence)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("53992AA8") ,com.kingdee.eas.zjlw.attendance.IAttence.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAttence getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttence)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("53992AA8") ,com.kingdee.eas.zjlw.attendance.IAttence.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAttence getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttence)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("53992AA8"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAttence getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttence)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("53992AA8"));
    }
}