package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LeaveManageEcFactory
{
    private LeaveManageEcFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.ILeaveManageEc getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManageEc)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AF777209") ,com.kingdee.eas.zjlw.certificates.ILeaveManageEc.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.ILeaveManageEc getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManageEc)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AF777209") ,com.kingdee.eas.zjlw.certificates.ILeaveManageEc.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.ILeaveManageEc getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManageEc)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AF777209"));
    }
    public static com.kingdee.eas.zjlw.certificates.ILeaveManageEc getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManageEc)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AF777209"));
    }
}