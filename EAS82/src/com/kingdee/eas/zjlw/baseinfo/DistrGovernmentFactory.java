package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DistrGovernmentFactory
{
    private DistrGovernmentFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IDistrGovernment getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IDistrGovernment)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DDE23CEF") ,com.kingdee.eas.zjlw.baseinfo.IDistrGovernment.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IDistrGovernment getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IDistrGovernment)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DDE23CEF") ,com.kingdee.eas.zjlw.baseinfo.IDistrGovernment.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IDistrGovernment getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IDistrGovernment)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DDE23CEF"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IDistrGovernment getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IDistrGovernment)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DDE23CEF"));
    }
}