package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WkPmtDstryECFactory
{
    private WkPmtDstryECFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstryEC getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstryEC)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A083F118") ,com.kingdee.eas.zjlw.certificates.IWkPmtDstryEC.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstryEC getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstryEC)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A083F118") ,com.kingdee.eas.zjlw.certificates.IWkPmtDstryEC.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstryEC getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstryEC)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A083F118"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstryEC getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstryEC)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A083F118"));
    }
}