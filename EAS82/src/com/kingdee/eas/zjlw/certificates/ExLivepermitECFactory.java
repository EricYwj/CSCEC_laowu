package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExLivepermitECFactory
{
    private ExLivepermitECFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IExLivepermitEC getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermitEC)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0BAE07C9") ,com.kingdee.eas.zjlw.certificates.IExLivepermitEC.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IExLivepermitEC getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermitEC)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0BAE07C9") ,com.kingdee.eas.zjlw.certificates.IExLivepermitEC.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IExLivepermitEC getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermitEC)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0BAE07C9"));
    }
    public static com.kingdee.eas.zjlw.certificates.IExLivepermitEC getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExLivepermitEC)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0BAE07C9"));
    }
}