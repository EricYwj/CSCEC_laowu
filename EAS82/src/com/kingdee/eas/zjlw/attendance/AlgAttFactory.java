package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AlgAttFactory
{
    private AlgAttFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAtt getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAtt)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("54CFD629") ,com.kingdee.eas.zjlw.attendance.IAlgAtt.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAlgAtt getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAtt)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("54CFD629") ,com.kingdee.eas.zjlw.attendance.IAlgAtt.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAtt getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAtt)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("54CFD629"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAtt getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAtt)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("54CFD629"));
    }
}