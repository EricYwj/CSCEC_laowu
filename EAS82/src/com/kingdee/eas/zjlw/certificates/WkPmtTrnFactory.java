package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WkPmtTrnFactory
{
    private WkPmtTrnFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrn getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrn)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("57027D5E") ,com.kingdee.eas.zjlw.certificates.IWkPmtTrn.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrn getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrn)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("57027D5E") ,com.kingdee.eas.zjlw.certificates.IWkPmtTrn.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrn getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrn)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("57027D5E"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrn getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrn)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("57027D5E"));
    }
}