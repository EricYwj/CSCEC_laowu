package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DistrGovernmentEntryFactory
{
    private DistrGovernmentEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IDistrGovernmentEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IDistrGovernmentEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7DF998C3") ,com.kingdee.eas.zjlw.baseinfo.IDistrGovernmentEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IDistrGovernmentEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IDistrGovernmentEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7DF998C3") ,com.kingdee.eas.zjlw.baseinfo.IDistrGovernmentEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IDistrGovernmentEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IDistrGovernmentEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7DF998C3"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IDistrGovernmentEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IDistrGovernmentEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7DF998C3"));
    }
}