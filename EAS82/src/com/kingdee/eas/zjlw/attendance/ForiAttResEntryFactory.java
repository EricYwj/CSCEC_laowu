package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiAttResEntryFactory
{
    private ForiAttResEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttResEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttResEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("754F6E4F") ,com.kingdee.eas.zjlw.attendance.IForiAttResEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IForiAttResEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttResEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("754F6E4F") ,com.kingdee.eas.zjlw.attendance.IForiAttResEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttResEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttResEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("754F6E4F"));
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttResEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttResEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("754F6E4F"));
    }
}