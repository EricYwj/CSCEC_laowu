package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AlgCheckRulesFactory
{
    private AlgCheckRulesFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgCheckRules getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgCheckRules)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("62697447") ,com.kingdee.eas.zjlw.attendance.IAlgCheckRules.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAlgCheckRules getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgCheckRules)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("62697447") ,com.kingdee.eas.zjlw.attendance.IAlgCheckRules.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgCheckRules getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgCheckRules)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("62697447"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgCheckRules getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgCheckRules)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("62697447"));
    }
}