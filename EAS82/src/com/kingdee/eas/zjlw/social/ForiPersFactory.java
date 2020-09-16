package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiPersFactory
{
    private ForiPersFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IForiPers getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPers)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("32D9D096") ,com.kingdee.eas.zjlw.social.IForiPers.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IForiPers getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPers)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("32D9D096") ,com.kingdee.eas.zjlw.social.IForiPers.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IForiPers getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPers)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("32D9D096"));
    }
    public static com.kingdee.eas.zjlw.social.IForiPers getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPers)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("32D9D096"));
    }
}