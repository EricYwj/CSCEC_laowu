package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AlgCheckRulesEntryFactory
{
    private AlgCheckRulesEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgCheckRulesEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgCheckRulesEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2687386B") ,com.kingdee.eas.zjlw.attendance.IAlgCheckRulesEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAlgCheckRulesEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgCheckRulesEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2687386B") ,com.kingdee.eas.zjlw.attendance.IAlgCheckRulesEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgCheckRulesEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgCheckRulesEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2687386B"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgCheckRulesEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgCheckRulesEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2687386B"));
    }
}