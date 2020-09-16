package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjChkCountFactory
{
    private ProjChkCountFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IProjChkCount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjChkCount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A69B8F46") ,com.kingdee.eas.zjlw.social.IProjChkCount.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IProjChkCount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjChkCount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A69B8F46") ,com.kingdee.eas.zjlw.social.IProjChkCount.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IProjChkCount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjChkCount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A69B8F46"));
    }
    public static com.kingdee.eas.zjlw.social.IProjChkCount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjChkCount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A69B8F46"));
    }
}