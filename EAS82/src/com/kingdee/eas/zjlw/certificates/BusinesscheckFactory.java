package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BusinesscheckFactory
{
    private BusinesscheckFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IBusinesscheck getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IBusinesscheck)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9E268297") ,com.kingdee.eas.zjlw.certificates.IBusinesscheck.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IBusinesscheck getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IBusinesscheck)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9E268297") ,com.kingdee.eas.zjlw.certificates.IBusinesscheck.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IBusinesscheck getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IBusinesscheck)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9E268297"));
    }
    public static com.kingdee.eas.zjlw.certificates.IBusinesscheck getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IBusinesscheck)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9E268297"));
    }
}