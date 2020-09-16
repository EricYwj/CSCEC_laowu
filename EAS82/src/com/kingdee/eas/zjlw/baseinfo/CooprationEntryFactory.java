package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CooprationEntryFactory
{
    private CooprationEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ICooprationEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ICooprationEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6CAD1554") ,com.kingdee.eas.zjlw.baseinfo.ICooprationEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ICooprationEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ICooprationEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6CAD1554") ,com.kingdee.eas.zjlw.baseinfo.ICooprationEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ICooprationEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ICooprationEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6CAD1554"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ICooprationEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ICooprationEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6CAD1554"));
    }
}