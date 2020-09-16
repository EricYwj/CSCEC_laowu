package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class IfilentryFactory
{
    private IfilentryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IIfilentry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IIfilentry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8E28A641") ,com.kingdee.eas.zjlw.certificates.IIfilentry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IIfilentry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IIfilentry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8E28A641") ,com.kingdee.eas.zjlw.certificates.IIfilentry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IIfilentry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IIfilentry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8E28A641"));
    }
    public static com.kingdee.eas.zjlw.certificates.IIfilentry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IIfilentry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8E28A641"));
    }
}