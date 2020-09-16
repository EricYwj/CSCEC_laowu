package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AttenceDataFactory
{
    private AttenceDataFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAttenceData getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttenceData)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3853FA72") ,com.kingdee.eas.zjlw.attendance.IAttenceData.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAttenceData getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttenceData)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3853FA72") ,com.kingdee.eas.zjlw.attendance.IAttenceData.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAttenceData getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttenceData)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3853FA72"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAttenceData getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttenceData)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3853FA72"));
    }
}