package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WkPmtUpdtFactory
{
    private WkPmtUpdtFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdt getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdt)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("894D9A7D") ,com.kingdee.eas.zjlw.certificates.IWkPmtUpdt.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdt getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdt)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("894D9A7D") ,com.kingdee.eas.zjlw.certificates.IWkPmtUpdt.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdt getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdt)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("894D9A7D"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdt getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdt)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("894D9A7D"));
    }
}