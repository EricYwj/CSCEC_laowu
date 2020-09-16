package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VabaweatherEntryFactory
{
    private VabaweatherEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IVabaweatherEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IVabaweatherEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C19862C8") ,com.kingdee.eas.zjlw.social.IVabaweatherEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IVabaweatherEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IVabaweatherEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C19862C8") ,com.kingdee.eas.zjlw.social.IVabaweatherEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IVabaweatherEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IVabaweatherEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C19862C8"));
    }
    public static com.kingdee.eas.zjlw.social.IVabaweatherEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IVabaweatherEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C19862C8"));
    }
}