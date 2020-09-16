package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SocialSeBurFactory
{
    private SocialSeBurFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ISocialSeBur getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISocialSeBur)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0EBD6AB2") ,com.kingdee.eas.zjlw.baseinfo.ISocialSeBur.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ISocialSeBur getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISocialSeBur)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0EBD6AB2") ,com.kingdee.eas.zjlw.baseinfo.ISocialSeBur.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ISocialSeBur getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISocialSeBur)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0EBD6AB2"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ISocialSeBur getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISocialSeBur)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0EBD6AB2"));
    }
}