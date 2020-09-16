package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WkPmtUpdtECFactory
{
    private WkPmtUpdtECFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEC getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEC)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6C50F7DB") ,com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEC.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEC getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEC)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6C50F7DB") ,com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEC.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEC getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEC)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6C50F7DB"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEC getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtUpdtEC)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6C50F7DB"));
    }
}