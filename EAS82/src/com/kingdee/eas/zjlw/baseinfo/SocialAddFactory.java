package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SocialAddFactory
{
    private SocialAddFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ISocialAdd getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISocialAdd)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D91F19C6") ,com.kingdee.eas.zjlw.baseinfo.ISocialAdd.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ISocialAdd getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISocialAdd)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D91F19C6") ,com.kingdee.eas.zjlw.baseinfo.ISocialAdd.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ISocialAdd getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISocialAdd)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D91F19C6"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ISocialAdd getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISocialAdd)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D91F19C6"));
    }
}