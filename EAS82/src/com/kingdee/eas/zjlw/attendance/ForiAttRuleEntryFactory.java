package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiAttRuleEntryFactory
{
    private ForiAttRuleEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttRuleEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttRuleEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("74BC27D9") ,com.kingdee.eas.zjlw.attendance.IForiAttRuleEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IForiAttRuleEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttRuleEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("74BC27D9") ,com.kingdee.eas.zjlw.attendance.IForiAttRuleEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttRuleEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttRuleEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("74BC27D9"));
    }
    public static com.kingdee.eas.zjlw.attendance.IForiAttRuleEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IForiAttRuleEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("74BC27D9"));
    }
}