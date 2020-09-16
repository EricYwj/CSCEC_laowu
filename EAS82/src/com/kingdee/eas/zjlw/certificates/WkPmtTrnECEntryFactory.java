package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WkPmtTrnECEntryFactory
{
    private WkPmtTrnECEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrnECEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrnECEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F2B81F56") ,com.kingdee.eas.zjlw.certificates.IWkPmtTrnECEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrnECEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrnECEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F2B81F56") ,com.kingdee.eas.zjlw.certificates.IWkPmtTrnECEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrnECEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrnECEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F2B81F56"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrnECEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrnECEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F2B81F56"));
    }
}