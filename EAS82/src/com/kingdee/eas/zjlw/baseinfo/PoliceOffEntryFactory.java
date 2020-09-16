package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PoliceOffEntryFactory
{
    private PoliceOffEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IPoliceOffEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IPoliceOffEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("972812EF") ,com.kingdee.eas.zjlw.baseinfo.IPoliceOffEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IPoliceOffEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IPoliceOffEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("972812EF") ,com.kingdee.eas.zjlw.baseinfo.IPoliceOffEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IPoliceOffEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IPoliceOffEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("972812EF"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IPoliceOffEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IPoliceOffEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("972812EF"));
    }
}