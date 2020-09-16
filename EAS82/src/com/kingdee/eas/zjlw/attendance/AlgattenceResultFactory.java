package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AlgattenceResultFactory
{
    private AlgattenceResultFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgattenceResult getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgattenceResult)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("677B89D1") ,com.kingdee.eas.zjlw.attendance.IAlgattenceResult.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAlgattenceResult getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgattenceResult)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("677B89D1") ,com.kingdee.eas.zjlw.attendance.IAlgattenceResult.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgattenceResult getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgattenceResult)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("677B89D1"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgattenceResult getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgattenceResult)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("677B89D1"));
    }
}