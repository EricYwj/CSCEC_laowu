package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AntiOutEcFactory
{
    private AntiOutEcFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiOutEc getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiOutEc)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6AA1BB19") ,com.kingdee.eas.zjlw.certificates.IAntiOutEc.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IAntiOutEc getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiOutEc)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6AA1BB19") ,com.kingdee.eas.zjlw.certificates.IAntiOutEc.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiOutEc getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiOutEc)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6AA1BB19"));
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiOutEc getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiOutEc)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6AA1BB19"));
    }
}