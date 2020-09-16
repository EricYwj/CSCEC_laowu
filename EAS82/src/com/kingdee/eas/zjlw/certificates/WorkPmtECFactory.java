package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkPmtECFactory
{
    private WorkPmtECFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkPmtEC getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmtEC)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2A0C2133") ,com.kingdee.eas.zjlw.certificates.IWorkPmtEC.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWorkPmtEC getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmtEC)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2A0C2133") ,com.kingdee.eas.zjlw.certificates.IWorkPmtEC.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkPmtEC getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmtEC)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2A0C2133"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkPmtEC getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkPmtEC)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2A0C2133"));
    }
}