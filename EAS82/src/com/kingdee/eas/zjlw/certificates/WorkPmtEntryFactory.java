package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkPmtEntryFactory
{
    private WorkPmtEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkPmtEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmtEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("19A0BB9D") ,com.kingdee.eas.zjlw.certificates.IWorkPmtEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWorkPmtEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmtEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("19A0BB9D") ,com.kingdee.eas.zjlw.certificates.IWorkPmtEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkPmtEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmtEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("19A0BB9D"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkPmtEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmtEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("19A0BB9D"));
    }
}