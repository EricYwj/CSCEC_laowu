package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AntiOutEcEntryFactory
{
    private AntiOutEcEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiOutEcEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiOutEcEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5AE464D9") ,com.kingdee.eas.zjlw.certificates.IAntiOutEcEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IAntiOutEcEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiOutEcEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5AE464D9") ,com.kingdee.eas.zjlw.certificates.IAntiOutEcEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiOutEcEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiOutEcEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5AE464D9"));
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiOutEcEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiOutEcEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5AE464D9"));
    }
}