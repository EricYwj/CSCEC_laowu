package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LeaveManageEcEntryFactory
{
    private LeaveManageEcEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.ILeaveManageEcEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManageEcEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FEBB83E9") ,com.kingdee.eas.zjlw.certificates.ILeaveManageEcEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.ILeaveManageEcEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManageEcEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FEBB83E9") ,com.kingdee.eas.zjlw.certificates.ILeaveManageEcEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.ILeaveManageEcEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManageEcEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FEBB83E9"));
    }
    public static com.kingdee.eas.zjlw.certificates.ILeaveManageEcEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManageEcEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FEBB83E9"));
    }
}