package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FiiEcFactory
{
    private FiiEcFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IFiiEc getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IFiiEc)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8A99EF93") ,com.kingdee.eas.zjlw.certificates.IFiiEc.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IFiiEc getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IFiiEc)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8A99EF93") ,com.kingdee.eas.zjlw.certificates.IFiiEc.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IFiiEc getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IFiiEc)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8A99EF93"));
    }
    public static com.kingdee.eas.zjlw.certificates.IFiiEc getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IFiiEc)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8A99EF93"));
    }
}