package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PassportEntryFactory
{
    private PassportEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IPassportEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassportEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9CCDCCCF") ,com.kingdee.eas.zjlw.certificates.IPassportEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IPassportEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassportEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9CCDCCCF") ,com.kingdee.eas.zjlw.certificates.IPassportEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IPassportEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassportEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9CCDCCCF"));
    }
    public static com.kingdee.eas.zjlw.certificates.IPassportEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassportEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9CCDCCCF"));
    }
}