package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AlgAttDataFactory
{
    private AlgAttDataFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttData getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttData)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1F56FD73") ,com.kingdee.eas.zjlw.attendance.IAlgAttData.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAlgAttData getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttData)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1F56FD73") ,com.kingdee.eas.zjlw.attendance.IAlgAttData.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttData getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttData)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1F56FD73"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttData getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttData)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1F56FD73"));
    }
}