package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkVisacancelFactory
{
    private WorkVisacancelFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkVisacancel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkVisacancel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EA815C7D") ,com.kingdee.eas.zjlw.certificates.IWorkVisacancel.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWorkVisacancel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkVisacancel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EA815C7D") ,com.kingdee.eas.zjlw.certificates.IWorkVisacancel.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkVisacancel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkVisacancel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EA815C7D"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWorkVisacancel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWorkVisacancel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EA815C7D"));
    }
}