package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LivepermitEntryFactory
{
    private LivepermitEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.ILivepermitEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermitEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BDDF1E3A") ,com.kingdee.eas.zjlw.certificates.ILivepermitEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.ILivepermitEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermitEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BDDF1E3A") ,com.kingdee.eas.zjlw.certificates.ILivepermitEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.ILivepermitEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermitEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BDDF1E3A"));
    }
    public static com.kingdee.eas.zjlw.certificates.ILivepermitEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermitEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BDDF1E3A"));
    }
}