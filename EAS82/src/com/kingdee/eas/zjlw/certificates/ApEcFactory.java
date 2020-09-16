package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ApEcFactory
{
    private ApEcFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IApEc getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IApEc)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6FD13AFE") ,com.kingdee.eas.zjlw.certificates.IApEc.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IApEc getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IApEc)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6FD13AFE") ,com.kingdee.eas.zjlw.certificates.IApEc.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IApEc getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IApEc)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6FD13AFE"));
    }
    public static com.kingdee.eas.zjlw.certificates.IApEc getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IApEc)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6FD13AFE"));
    }
}