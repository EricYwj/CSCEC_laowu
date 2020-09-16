package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiAttDataFactory
{
    private ForiAttDataFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttData getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttData)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A3B570C7") ,com.kingdee.eas.zjlw.attendance.IForiAttData.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IForiAttData getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttData)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A3B570C7") ,com.kingdee.eas.zjlw.attendance.IForiAttData.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttData getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttData)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A3B570C7"));
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttData getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttData)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A3B570C7"));
    }
}