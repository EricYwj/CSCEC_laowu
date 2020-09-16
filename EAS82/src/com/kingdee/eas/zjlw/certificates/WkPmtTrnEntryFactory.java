package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WkPmtTrnEntryFactory
{
    private WkPmtTrnEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrnEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrnEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AC6B45B4") ,com.kingdee.eas.zjlw.certificates.IWkPmtTrnEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrnEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrnEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AC6B45B4") ,com.kingdee.eas.zjlw.certificates.IWkPmtTrnEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrnEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrnEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AC6B45B4"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrnEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrnEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AC6B45B4"));
    }
}