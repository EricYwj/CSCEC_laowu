package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AntiECEntryFactory
{
    private AntiECEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiECEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiECEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E04B59E1") ,com.kingdee.eas.zjlw.certificates.IAntiECEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IAntiECEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiECEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E04B59E1") ,com.kingdee.eas.zjlw.certificates.IAntiECEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiECEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiECEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E04B59E1"));
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiECEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiECEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E04B59E1"));
    }
}