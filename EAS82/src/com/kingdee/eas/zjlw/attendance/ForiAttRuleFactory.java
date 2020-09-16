package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiAttRuleFactory
{
    private ForiAttRuleFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttRule getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttRule)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A3BC1819") ,com.kingdee.eas.zjlw.attendance.IForiAttRule.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IForiAttRule getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttRule)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A3BC1819") ,com.kingdee.eas.zjlw.attendance.IForiAttRule.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttRule getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttRule)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A3BC1819"));
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttRule getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttRule)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A3BC1819"));
    }
}