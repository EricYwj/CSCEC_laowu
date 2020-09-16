package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExLivepermitECEntryFactory
{
    private ExLivepermitECEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IExLivepermitECEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermitECEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5DFC8629") ,com.kingdee.eas.zjlw.certificates.IExLivepermitECEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IExLivepermitECEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermitECEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5DFC8629") ,com.kingdee.eas.zjlw.certificates.IExLivepermitECEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IExLivepermitECEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermitECEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5DFC8629"));
    }
    public static com.kingdee.eas.zjlw.certificates.IExLivepermitECEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermitECEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5DFC8629"));
    }
}