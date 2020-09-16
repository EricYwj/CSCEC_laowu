package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiPersFactory
{
    private ForiPersFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IForiPers getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiPers)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1B33F59A") ,com.kingdee.eas.zjlw.attendance.IForiPers.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IForiPers getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiPers)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1B33F59A") ,com.kingdee.eas.zjlw.attendance.IForiPers.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IForiPers getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiPers)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1B33F59A"));
    }
    public static com.kingdee.eas.zjlw.attendance.IForiPers getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiPers)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1B33F59A"));
    }
}