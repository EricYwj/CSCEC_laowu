package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LivepermitECEntryFactory
{
    private LivepermitECEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.ILivepermitECEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermitECEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7697EE5C") ,com.kingdee.eas.zjlw.certificates.ILivepermitECEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.ILivepermitECEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermitECEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7697EE5C") ,com.kingdee.eas.zjlw.certificates.ILivepermitECEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.ILivepermitECEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermitECEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7697EE5C"));
    }
    public static com.kingdee.eas.zjlw.certificates.ILivepermitECEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermitECEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7697EE5C"));
    }
}