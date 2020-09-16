package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WkPmtDstryEntryFactory
{
    private WkPmtDstryEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstryEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstryEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5A4AA598") ,com.kingdee.eas.zjlw.certificates.IWkPmtDstryEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstryEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstryEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5A4AA598") ,com.kingdee.eas.zjlw.certificates.IWkPmtDstryEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstryEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstryEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5A4AA598"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstryEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstryEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5A4AA598"));
    }
}