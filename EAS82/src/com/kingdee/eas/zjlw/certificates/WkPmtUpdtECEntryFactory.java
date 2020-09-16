package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WkPmtUpdtECEntryFactory
{
    private WkPmtUpdtECEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdtECEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdtECEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BC66D157") ,com.kingdee.eas.zjlw.certificates.IWkPmtUpdtECEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdtECEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdtECEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BC66D157") ,com.kingdee.eas.zjlw.certificates.IWkPmtUpdtECEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdtECEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdtECEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BC66D157"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdtECEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdtECEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BC66D157"));
    }
}