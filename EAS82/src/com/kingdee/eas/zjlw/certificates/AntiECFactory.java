package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AntiECFactory
{
    private AntiECFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiEC getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiEC)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C067C111") ,com.kingdee.eas.zjlw.certificates.IAntiEC.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IAntiEC getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiEC)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C067C111") ,com.kingdee.eas.zjlw.certificates.IAntiEC.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiEC getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiEC)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C067C111"));
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiEC getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiEC)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C067C111"));
    }
}