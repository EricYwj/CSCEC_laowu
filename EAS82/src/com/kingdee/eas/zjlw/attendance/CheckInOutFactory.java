package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckInOutFactory
{
    private CheckInOutFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.ICheckInOut getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.ICheckInOut)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DC02EC85") ,com.kingdee.eas.zjlw.attendance.ICheckInOut.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.ICheckInOut getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.ICheckInOut)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DC02EC85") ,com.kingdee.eas.zjlw.attendance.ICheckInOut.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.ICheckInOut getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.ICheckInOut)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DC02EC85"));
    }
    public static com.kingdee.eas.zjlw.attendance.ICheckInOut getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.ICheckInOut)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DC02EC85"));
    }
}