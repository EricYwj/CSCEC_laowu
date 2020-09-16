package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AntiSignedEntryFactory
{
    private AntiSignedEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiSignedEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiSignedEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("99CE7B83") ,com.kingdee.eas.zjlw.certificates.IAntiSignedEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IAntiSignedEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiSignedEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("99CE7B83") ,com.kingdee.eas.zjlw.certificates.IAntiSignedEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiSignedEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiSignedEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("99CE7B83"));
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiSignedEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiSignedEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("99CE7B83"));
    }
}