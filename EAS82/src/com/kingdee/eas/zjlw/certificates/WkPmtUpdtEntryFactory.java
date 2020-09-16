package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WkPmtUpdtEntryFactory
{
    private WkPmtUpdtEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E27083F5") ,com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E27083F5") ,com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E27083F5"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E27083F5"));
    }
}