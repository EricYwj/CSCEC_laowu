package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VisaEcFactory
{
    private VisaEcFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IVisaEc getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaEc)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E3F67E50") ,com.kingdee.eas.zjlw.certificates.IVisaEc.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IVisaEc getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaEc)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E3F67E50") ,com.kingdee.eas.zjlw.certificates.IVisaEc.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IVisaEc getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaEc)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E3F67E50"));
    }
    public static com.kingdee.eas.zjlw.certificates.IVisaEc getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaEc)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E3F67E50"));
    }
}