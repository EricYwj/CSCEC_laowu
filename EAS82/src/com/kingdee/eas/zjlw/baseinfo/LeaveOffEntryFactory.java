package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LeaveOffEntryFactory
{
    private LeaveOffEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILeaveOffEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILeaveOffEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3BFB4EEC") ,com.kingdee.eas.zjlw.baseinfo.ILeaveOffEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ILeaveOffEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILeaveOffEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3BFB4EEC") ,com.kingdee.eas.zjlw.baseinfo.ILeaveOffEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILeaveOffEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILeaveOffEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3BFB4EEC"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILeaveOffEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILeaveOffEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3BFB4EEC"));
    }
}