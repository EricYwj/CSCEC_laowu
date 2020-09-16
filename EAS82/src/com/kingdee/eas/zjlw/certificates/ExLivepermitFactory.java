package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExLivepermitFactory
{
    private ExLivepermitFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IExLivepermit getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermit)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1EE9CDEB") ,com.kingdee.eas.zjlw.certificates.IExLivepermit.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IExLivepermit getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermit)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1EE9CDEB") ,com.kingdee.eas.zjlw.certificates.IExLivepermit.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IExLivepermit getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermit)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1EE9CDEB"));
    }
    public static com.kingdee.eas.zjlw.certificates.IExLivepermit getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermit)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1EE9CDEB"));
    }
}