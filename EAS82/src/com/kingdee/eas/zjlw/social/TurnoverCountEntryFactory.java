package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TurnoverCountEntryFactory
{
    private TurnoverCountEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.ITurnoverCountEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ITurnoverCountEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1B67E714") ,com.kingdee.eas.zjlw.social.ITurnoverCountEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.ITurnoverCountEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ITurnoverCountEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1B67E714") ,com.kingdee.eas.zjlw.social.ITurnoverCountEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.ITurnoverCountEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ITurnoverCountEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1B67E714"));
    }
    public static com.kingdee.eas.zjlw.social.ITurnoverCountEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ITurnoverCountEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1B67E714"));
    }
}