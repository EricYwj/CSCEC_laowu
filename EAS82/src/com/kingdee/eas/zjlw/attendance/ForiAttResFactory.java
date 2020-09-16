package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiAttResFactory
{
    private ForiAttResFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttRes getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttRes)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("05481FE3") ,com.kingdee.eas.zjlw.attendance.IForiAttRes.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IForiAttRes getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttRes)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("05481FE3") ,com.kingdee.eas.zjlw.attendance.IForiAttRes.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttRes getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttRes)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("05481FE3"));
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttRes getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttRes)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("05481FE3"));
    }
}