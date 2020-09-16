package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiAttDataEntryFactory
{
    private ForiAttDataEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttDataEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttDataEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DBC50BEB") ,com.kingdee.eas.zjlw.attendance.IForiAttDataEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IForiAttDataEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttDataEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DBC50BEB") ,com.kingdee.eas.zjlw.attendance.IForiAttDataEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttDataEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttDataEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DBC50BEB"));
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttDataEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttDataEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DBC50BEB"));
    }
}