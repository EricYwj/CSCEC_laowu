package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AlgAttResFactory
{
    private AlgAttResFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttRes getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttRes)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A62C4DB7") ,com.kingdee.eas.zjlw.attendance.IAlgAttRes.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAlgAttRes getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttRes)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A62C4DB7") ,com.kingdee.eas.zjlw.attendance.IAlgAttRes.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttRes getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttRes)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A62C4DB7"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttRes getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttRes)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A62C4DB7"));
    }
}