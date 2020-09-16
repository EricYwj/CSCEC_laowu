package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProvGovernmentFactory
{
    private ProvGovernmentFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProvGovernment getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProvGovernment)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D129F9A8") ,com.kingdee.eas.zjlw.baseinfo.IProvGovernment.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IProvGovernment getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProvGovernment)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D129F9A8") ,com.kingdee.eas.zjlw.baseinfo.IProvGovernment.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProvGovernment getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProvGovernment)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D129F9A8"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProvGovernment getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProvGovernment)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D129F9A8"));
    }
}