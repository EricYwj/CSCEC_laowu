package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkPmtFactory
{
    private WorkPmtFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkPmt getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmt)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D9F339D5") ,com.kingdee.eas.zjlw.certificates.IWorkPmt.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWorkPmt getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmt)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D9F339D5") ,com.kingdee.eas.zjlw.certificates.IWorkPmt.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkPmt getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmt)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D9F339D5"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkPmt getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmt)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D9F339D5"));
    }
}