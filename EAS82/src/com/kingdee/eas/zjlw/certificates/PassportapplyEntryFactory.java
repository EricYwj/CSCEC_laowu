package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PassportapplyEntryFactory
{
    private PassportapplyEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IPassportapplyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassportapplyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E0D41B47") ,com.kingdee.eas.zjlw.certificates.IPassportapplyEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IPassportapplyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassportapplyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E0D41B47") ,com.kingdee.eas.zjlw.certificates.IPassportapplyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IPassportapplyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassportapplyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E0D41B47"));
    }
    public static com.kingdee.eas.zjlw.certificates.IPassportapplyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassportapplyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E0D41B47"));
    }
}