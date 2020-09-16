package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LeaveManageEntryFactory
{
    private LeaveManageEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.ILeaveManageEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManageEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3D062727") ,com.kingdee.eas.zjlw.certificates.ILeaveManageEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.ILeaveManageEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManageEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3D062727") ,com.kingdee.eas.zjlw.certificates.ILeaveManageEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.ILeaveManageEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManageEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3D062727"));
    }
    public static com.kingdee.eas.zjlw.certificates.ILeaveManageEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManageEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3D062727"));
    }
}