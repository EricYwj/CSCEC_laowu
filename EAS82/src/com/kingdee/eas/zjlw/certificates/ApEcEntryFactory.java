package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ApEcEntryFactory
{
    private ApEcEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IApEcEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IApEcEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("79520C14") ,com.kingdee.eas.zjlw.certificates.IApEcEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IApEcEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IApEcEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("79520C14") ,com.kingdee.eas.zjlw.certificates.IApEcEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IApEcEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IApEcEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("79520C14"));
    }
    public static com.kingdee.eas.zjlw.certificates.IApEcEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IApEcEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("79520C14"));
    }
}