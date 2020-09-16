package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckRuleFactory
{
    private CheckRuleFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.ICheckRule getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.ICheckRule)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FEDB02E0") ,com.kingdee.eas.zjlw.attendance.ICheckRule.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.ICheckRule getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.ICheckRule)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FEDB02E0") ,com.kingdee.eas.zjlw.attendance.ICheckRule.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.ICheckRule getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.ICheckRule)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FEDB02E0"));
    }
    public static com.kingdee.eas.zjlw.attendance.ICheckRule getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.ICheckRule)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FEDB02E0"));
    }
}