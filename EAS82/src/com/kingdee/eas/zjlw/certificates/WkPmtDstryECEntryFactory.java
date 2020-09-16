package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WkPmtDstryECEntryFactory
{
    private WkPmtDstryECEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstryECEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstryECEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A63F163A") ,com.kingdee.eas.zjlw.certificates.IWkPmtDstryECEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstryECEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstryECEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A63F163A") ,com.kingdee.eas.zjlw.certificates.IWkPmtDstryECEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstryECEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstryECEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A63F163A"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstryECEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstryECEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A63F163A"));
    }
}