package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ImmiEcFactory
{
    private ImmiEcFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IImmiEc getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmiEc)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CDFD400F") ,com.kingdee.eas.zjlw.certificates.IImmiEc.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IImmiEc getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmiEc)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CDFD400F") ,com.kingdee.eas.zjlw.certificates.IImmiEc.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IImmiEc getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmiEc)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CDFD400F"));
    }
    public static com.kingdee.eas.zjlw.certificates.IImmiEc getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmiEc)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CDFD400F"));
    }
}