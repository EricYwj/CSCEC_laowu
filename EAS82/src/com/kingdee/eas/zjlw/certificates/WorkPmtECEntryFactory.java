package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkPmtECEntryFactory
{
    private WorkPmtECEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkPmtECEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmtECEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E867BEFF") ,com.kingdee.eas.zjlw.certificates.IWorkPmtECEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWorkPmtECEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmtECEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E867BEFF") ,com.kingdee.eas.zjlw.certificates.IWorkPmtECEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkPmtECEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmtECEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E867BEFF"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkPmtECEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmtECEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E867BEFF"));
    }
}