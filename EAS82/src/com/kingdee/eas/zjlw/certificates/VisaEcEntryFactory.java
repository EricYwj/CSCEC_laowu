package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VisaEcEntryFactory
{
    private VisaEcEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IVisaEcEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaEcEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B4EC0C02") ,com.kingdee.eas.zjlw.certificates.IVisaEcEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IVisaEcEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaEcEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B4EC0C02") ,com.kingdee.eas.zjlw.certificates.IVisaEcEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IVisaEcEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaEcEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B4EC0C02"));
    }
    public static com.kingdee.eas.zjlw.certificates.IVisaEcEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaEcEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B4EC0C02"));
    }
}