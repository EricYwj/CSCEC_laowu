package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class IfilentryEntryFactory
{
    private IfilentryEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IIfilentryEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IIfilentryEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C23A32B1") ,com.kingdee.eas.zjlw.certificates.IIfilentryEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IIfilentryEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IIfilentryEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C23A32B1") ,com.kingdee.eas.zjlw.certificates.IIfilentryEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IIfilentryEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IIfilentryEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C23A32B1"));
    }
    public static com.kingdee.eas.zjlw.certificates.IIfilentryEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IIfilentryEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C23A32B1"));
    }
}