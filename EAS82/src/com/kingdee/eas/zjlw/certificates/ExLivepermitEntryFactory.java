package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExLivepermitEntryFactory
{
    private ExLivepermitEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IExLivepermitEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermitEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("31314547") ,com.kingdee.eas.zjlw.certificates.IExLivepermitEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IExLivepermitEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermitEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("31314547") ,com.kingdee.eas.zjlw.certificates.IExLivepermitEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IExLivepermitEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermitEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("31314547"));
    }
    public static com.kingdee.eas.zjlw.certificates.IExLivepermitEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermitEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("31314547"));
    }
}