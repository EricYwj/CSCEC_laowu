package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VabaweatherFactory
{
    private VabaweatherFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IVabaweather getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IVabaweather)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0E7483CA") ,com.kingdee.eas.zjlw.social.IVabaweather.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IVabaweather getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IVabaweather)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0E7483CA") ,com.kingdee.eas.zjlw.social.IVabaweather.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IVabaweather getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IVabaweather)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0E7483CA"));
    }
    public static com.kingdee.eas.zjlw.social.IVabaweather getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IVabaweather)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0E7483CA"));
    }
}