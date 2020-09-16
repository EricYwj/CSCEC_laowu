package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LivepermitECFactory
{
    private LivepermitECFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.ILivepermitEC getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermitEC)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F2E90BB6") ,com.kingdee.eas.zjlw.certificates.ILivepermitEC.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.ILivepermitEC getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermitEC)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F2E90BB6") ,com.kingdee.eas.zjlw.certificates.ILivepermitEC.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.ILivepermitEC getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermitEC)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F2E90BB6"));
    }
    public static com.kingdee.eas.zjlw.certificates.ILivepermitEC getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermitEC)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F2E90BB6"));
    }
}