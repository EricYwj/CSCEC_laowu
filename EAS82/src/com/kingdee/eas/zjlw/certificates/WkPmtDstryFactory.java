package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WkPmtDstryFactory
{
    private WkPmtDstryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9F77BEFA") ,com.kingdee.eas.zjlw.certificates.IWkPmtDstry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9F77BEFA") ,com.kingdee.eas.zjlw.certificates.IWkPmtDstry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9F77BEFA"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtDstry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtDstry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9F77BEFA"));
    }
}