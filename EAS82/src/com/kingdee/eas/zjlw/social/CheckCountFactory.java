package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckCountFactory
{
    private CheckCountFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.ICheckCount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ICheckCount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A14A6DA7") ,com.kingdee.eas.zjlw.social.ICheckCount.class);
    }
    
    public static com.kingdee.eas.zjlw.social.ICheckCount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ICheckCount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A14A6DA7") ,com.kingdee.eas.zjlw.social.ICheckCount.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.ICheckCount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ICheckCount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A14A6DA7"));
    }
    public static com.kingdee.eas.zjlw.social.ICheckCount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ICheckCount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A14A6DA7"));
    }
}