package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LeaveManageFactory
{
    private LeaveManageFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.ILeaveManage getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManage)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A447400B") ,com.kingdee.eas.zjlw.certificates.ILeaveManage.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.ILeaveManage getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManage)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A447400B") ,com.kingdee.eas.zjlw.certificates.ILeaveManage.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.ILeaveManage getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManage)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A447400B"));
    }
    public static com.kingdee.eas.zjlw.certificates.ILeaveManage getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILeaveManage)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A447400B"));
    }
}