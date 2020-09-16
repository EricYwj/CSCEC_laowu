package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VisaHandleEntryFactory
{
    private VisaHandleEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IVisaHandleEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaHandleEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CE5D99B8") ,com.kingdee.eas.zjlw.certificates.IVisaHandleEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IVisaHandleEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaHandleEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CE5D99B8") ,com.kingdee.eas.zjlw.certificates.IVisaHandleEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IVisaHandleEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaHandleEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CE5D99B8"));
    }
    public static com.kingdee.eas.zjlw.certificates.IVisaHandleEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaHandleEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CE5D99B8"));
    }
}