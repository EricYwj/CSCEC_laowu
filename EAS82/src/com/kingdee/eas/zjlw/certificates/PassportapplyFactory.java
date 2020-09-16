package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PassportapplyFactory
{
    private PassportapplyFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IPassportapply getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassportapply)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9E5937EB") ,com.kingdee.eas.zjlw.certificates.IPassportapply.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IPassportapply getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassportapply)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9E5937EB") ,com.kingdee.eas.zjlw.certificates.IPassportapply.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IPassportapply getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassportapply)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9E5937EB"));
    }
    public static com.kingdee.eas.zjlw.certificates.IPassportapply getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IPassportapply)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9E5937EB"));
    }
}