package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LabSupBurEntryFactory
{
    private LabSupBurEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILabSupBurEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILabSupBurEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5F91D142") ,com.kingdee.eas.zjlw.baseinfo.ILabSupBurEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ILabSupBurEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILabSupBurEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5F91D142") ,com.kingdee.eas.zjlw.baseinfo.ILabSupBurEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILabSupBurEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILabSupBurEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5F91D142"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILabSupBurEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILabSupBurEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5F91D142"));
    }
}