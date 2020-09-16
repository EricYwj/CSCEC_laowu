package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WkPmtTrnECFactory
{
    private WkPmtTrnECFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrnEC getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrnEC)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A058A67C") ,com.kingdee.eas.zjlw.certificates.IWkPmtTrnEC.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrnEC getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrnEC)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A058A67C") ,com.kingdee.eas.zjlw.certificates.IWkPmtTrnEC.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrnEC getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrnEC)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A058A67C"));
    }
    public static com.kingdee.eas.zjlw.certificates.IWkPmtTrnEC getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IWkPmtTrnEC)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A058A67C"));
    }
}