package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SocialSeBurEntryFactory
{
    private SocialSeBurEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ISocialSeBurEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISocialSeBurEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B4D38CE0") ,com.kingdee.eas.zjlw.baseinfo.ISocialSeBurEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ISocialSeBurEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISocialSeBurEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B4D38CE0") ,com.kingdee.eas.zjlw.baseinfo.ISocialSeBurEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ISocialSeBurEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISocialSeBurEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B4D38CE0"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ISocialSeBurEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISocialSeBurEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B4D38CE0"));
    }
}