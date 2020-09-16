package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PassportFactory
{
    private PassportFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IPassport getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassport)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AAE8B163") ,com.kingdee.eas.zjlw.certificates.IPassport.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IPassport getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassport)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AAE8B163") ,com.kingdee.eas.zjlw.certificates.IPassport.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IPassport getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassport)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AAE8B163"));
    }
    public static com.kingdee.eas.zjlw.certificates.IPassport getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassport)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AAE8B163"));
    }
}