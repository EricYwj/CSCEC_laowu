package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class UplivePermitFactory
{
    private UplivePermitFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IUplivePermit getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermit)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("45719DD3") ,com.kingdee.eas.zjlw.certificates.IUplivePermit.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IUplivePermit getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermit)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("45719DD3") ,com.kingdee.eas.zjlw.certificates.IUplivePermit.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IUplivePermit getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermit)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("45719DD3"));
    }
    public static com.kingdee.eas.zjlw.certificates.IUplivePermit getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermit)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("45719DD3"));
    }
}