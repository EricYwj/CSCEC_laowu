package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkVisacancelEntryFactory
{
    private WorkVisacancelEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkVisacancelEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkVisacancelEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("554601F5") ,com.kingdee.eas.zjlw.certificates.IWorkVisacancelEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWorkVisacancelEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkVisacancelEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("554601F5") ,com.kingdee.eas.zjlw.certificates.IWorkVisacancelEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkVisacancelEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkVisacancelEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("554601F5"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkVisacancelEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkVisacancelEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("554601F5"));
    }
}