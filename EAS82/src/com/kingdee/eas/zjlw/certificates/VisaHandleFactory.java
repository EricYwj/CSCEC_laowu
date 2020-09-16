package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VisaHandleFactory
{
    private VisaHandleFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IVisaHandle getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaHandle)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F224B6DA") ,com.kingdee.eas.zjlw.certificates.IVisaHandle.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IVisaHandle getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaHandle)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F224B6DA") ,com.kingdee.eas.zjlw.certificates.IVisaHandle.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IVisaHandle getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaHandle)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F224B6DA"));
    }
    public static com.kingdee.eas.zjlw.certificates.IVisaHandle getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IVisaHandle)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F224B6DA"));
    }
}