package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExilivepermitEntryFactory
{
    private ExilivepermitEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IExilivepermitEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermitEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("24DC6BE6") ,com.kingdee.eas.zjlw.certificates.IExilivepermitEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IExilivepermitEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermitEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("24DC6BE6") ,com.kingdee.eas.zjlw.certificates.IExilivepermitEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IExilivepermitEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermitEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("24DC6BE6"));
    }
    public static com.kingdee.eas.zjlw.certificates.IExilivepermitEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermitEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("24DC6BE6"));
    }
}