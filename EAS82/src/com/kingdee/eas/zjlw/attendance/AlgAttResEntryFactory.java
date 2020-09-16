package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AlgAttResEntryFactory
{
    private AlgAttResEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttResEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttResEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F6C2C4FB") ,com.kingdee.eas.zjlw.attendance.IAlgAttResEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAlgAttResEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttResEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F6C2C4FB") ,com.kingdee.eas.zjlw.attendance.IAlgAttResEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttResEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttResEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F6C2C4FB"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttResEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttResEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F6C2C4FB"));
    }
}