package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiPersEntryFactory
{
    private ForiPersEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IForiPersEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiPersEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0AC792F8") ,com.kingdee.eas.zjlw.attendance.IForiPersEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IForiPersEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiPersEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0AC792F8") ,com.kingdee.eas.zjlw.attendance.IForiPersEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IForiPersEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiPersEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0AC792F8"));
    }
    public static com.kingdee.eas.zjlw.attendance.IForiPersEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiPersEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0AC792F8"));
    }
}