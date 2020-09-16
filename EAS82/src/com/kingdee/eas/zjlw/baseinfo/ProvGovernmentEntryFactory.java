package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProvGovernmentEntryFactory
{
    private ProvGovernmentEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProvGovernmentEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProvGovernmentEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("89D7E7AA") ,com.kingdee.eas.zjlw.baseinfo.IProvGovernmentEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IProvGovernmentEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProvGovernmentEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("89D7E7AA") ,com.kingdee.eas.zjlw.baseinfo.IProvGovernmentEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProvGovernmentEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProvGovernmentEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("89D7E7AA"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProvGovernmentEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProvGovernmentEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("89D7E7AA"));
    }
}