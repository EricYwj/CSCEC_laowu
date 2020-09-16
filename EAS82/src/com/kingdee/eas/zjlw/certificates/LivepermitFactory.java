package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LivepermitFactory
{
    private LivepermitFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.ILivepermit getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermit)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B6FEE918") ,com.kingdee.eas.zjlw.certificates.ILivepermit.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.ILivepermit getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermit)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B6FEE918") ,com.kingdee.eas.zjlw.certificates.ILivepermit.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.ILivepermit getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermit)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B6FEE918"));
    }
    public static com.kingdee.eas.zjlw.certificates.ILivepermit getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ILivepermit)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B6FEE918"));
    }
}