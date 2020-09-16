package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TurnoverCountFactory
{
    private TurnoverCountFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.ITurnoverCount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ITurnoverCount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C83E7FFE") ,com.kingdee.eas.zjlw.social.ITurnoverCount.class);
    }
    
    public static com.kingdee.eas.zjlw.social.ITurnoverCount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ITurnoverCount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C83E7FFE") ,com.kingdee.eas.zjlw.social.ITurnoverCount.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.ITurnoverCount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ITurnoverCount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C83E7FFE"));
    }
    public static com.kingdee.eas.zjlw.social.ITurnoverCount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ITurnoverCount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C83E7FFE"));
    }
}