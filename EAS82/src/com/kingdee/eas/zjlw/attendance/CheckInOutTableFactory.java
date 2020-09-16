package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckInOutTableFactory
{
    private CheckInOutTableFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.ICheckInOutTable getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.ICheckInOutTable)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F4B26A49") ,com.kingdee.eas.zjlw.attendance.ICheckInOutTable.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.ICheckInOutTable getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.ICheckInOutTable)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F4B26A49") ,com.kingdee.eas.zjlw.attendance.ICheckInOutTable.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.ICheckInOutTable getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.ICheckInOutTable)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F4B26A49"));
    }
    public static com.kingdee.eas.zjlw.attendance.ICheckInOutTable getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.ICheckInOutTable)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F4B26A49"));
    }
}