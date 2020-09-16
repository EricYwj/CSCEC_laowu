package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CooprationFactory
{
    private CooprationFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ICoopration getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ICoopration)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("738569BE") ,com.kingdee.eas.zjlw.baseinfo.ICoopration.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ICoopration getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ICoopration)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("738569BE") ,com.kingdee.eas.zjlw.baseinfo.ICoopration.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ICoopration getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ICoopration)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("738569BE"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ICoopration getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ICoopration)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("738569BE"));
    }
}