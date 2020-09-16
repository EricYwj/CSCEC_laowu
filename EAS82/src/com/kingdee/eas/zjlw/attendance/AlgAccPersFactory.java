package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AlgAccPersFactory
{
    private AlgAccPersFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAccPers getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAccPers)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("016A8E9F") ,com.kingdee.eas.zjlw.attendance.IAlgAccPers.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAlgAccPers getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAccPers)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("016A8E9F") ,com.kingdee.eas.zjlw.attendance.IAlgAccPers.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAccPers getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAccPers)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("016A8E9F"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAccPers getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAccPers)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("016A8E9F"));
    }
}