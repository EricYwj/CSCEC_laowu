package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EpEcFactory
{
    private EpEcFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IEpEc getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEpEc)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6FD30C7A") ,com.kingdee.eas.zjlw.certificates.IEpEc.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IEpEc getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEpEc)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6FD30C7A") ,com.kingdee.eas.zjlw.certificates.IEpEc.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IEpEc getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEpEc)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6FD30C7A"));
    }
    public static com.kingdee.eas.zjlw.certificates.IEpEc getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEpEc)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6FD30C7A"));
    }
}