package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WageFactory
{
    private WageFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IWage getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IWage)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("87B4F216") ,com.kingdee.eas.zjlw.baseinfo.IWage.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IWage getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IWage)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("87B4F216") ,com.kingdee.eas.zjlw.baseinfo.IWage.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IWage getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IWage)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("87B4F216"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IWage getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IWage)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("87B4F216"));
    }
}