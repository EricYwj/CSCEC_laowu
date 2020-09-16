package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckCountEntryFactory
{
    private CheckCountEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.ICheckCountEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ICheckCountEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BE2B1B0B") ,com.kingdee.eas.zjlw.social.ICheckCountEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.ICheckCountEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ICheckCountEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BE2B1B0B") ,com.kingdee.eas.zjlw.social.ICheckCountEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.ICheckCountEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ICheckCountEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BE2B1B0B"));
    }
    public static com.kingdee.eas.zjlw.social.ICheckCountEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ICheckCountEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BE2B1B0B"));
    }
}