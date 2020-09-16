package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LeaveOffFactory
{
    private LeaveOffFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILeaveOff getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILeaveOff)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("34EF9126") ,com.kingdee.eas.zjlw.baseinfo.ILeaveOff.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ILeaveOff getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILeaveOff)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("34EF9126") ,com.kingdee.eas.zjlw.baseinfo.ILeaveOff.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILeaveOff getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILeaveOff)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("34EF9126"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILeaveOff getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILeaveOff)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("34EF9126"));
    }
}