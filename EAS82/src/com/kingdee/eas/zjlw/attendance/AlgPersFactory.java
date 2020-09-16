package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AlgPersFactory
{
    private AlgPersFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgPers getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgPers)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4531886E") ,com.kingdee.eas.zjlw.attendance.IAlgPers.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAlgPers getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgPers)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4531886E") ,com.kingdee.eas.zjlw.attendance.IAlgPers.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgPers getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgPers)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4531886E"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgPers getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgPers)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4531886E"));
    }
}