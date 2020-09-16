package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EpEcEntryFactory
{
    private EpEcEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IEpEcEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEpEcEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CA63C818") ,com.kingdee.eas.zjlw.certificates.IEpEcEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IEpEcEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEpEcEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CA63C818") ,com.kingdee.eas.zjlw.certificates.IEpEcEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IEpEcEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEpEcEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CA63C818"));
    }
    public static com.kingdee.eas.zjlw.certificates.IEpEcEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEpEcEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CA63C818"));
    }
}