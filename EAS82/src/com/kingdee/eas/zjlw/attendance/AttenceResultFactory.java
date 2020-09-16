package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AttenceResultFactory
{
    private AttenceResultFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAttenceResult getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttenceResult)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8B5B40E5") ,com.kingdee.eas.zjlw.attendance.IAttenceResult.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAttenceResult getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttenceResult)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8B5B40E5") ,com.kingdee.eas.zjlw.attendance.IAttenceResult.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAttenceResult getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttenceResult)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8B5B40E5"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAttenceResult getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttenceResult)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8B5B40E5"));
    }
}