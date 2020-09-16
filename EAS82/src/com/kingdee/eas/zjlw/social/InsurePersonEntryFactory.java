package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InsurePersonEntryFactory
{
    private InsurePersonEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IInsurePersonEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IInsurePersonEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AC117643") ,com.kingdee.eas.zjlw.social.IInsurePersonEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IInsurePersonEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IInsurePersonEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AC117643") ,com.kingdee.eas.zjlw.social.IInsurePersonEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IInsurePersonEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IInsurePersonEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AC117643"));
    }
    public static com.kingdee.eas.zjlw.social.IInsurePersonEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IInsurePersonEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AC117643"));
    }
}