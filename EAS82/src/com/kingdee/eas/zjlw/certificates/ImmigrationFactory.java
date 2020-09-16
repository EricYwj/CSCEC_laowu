package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ImmigrationFactory
{
    private ImmigrationFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IImmigration getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmigration)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DD9D3C39") ,com.kingdee.eas.zjlw.certificates.IImmigration.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IImmigration getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmigration)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DD9D3C39") ,com.kingdee.eas.zjlw.certificates.IImmigration.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IImmigration getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmigration)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DD9D3C39"));
    }
    public static com.kingdee.eas.zjlw.certificates.IImmigration getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmigration)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DD9D3C39"));
    }
}