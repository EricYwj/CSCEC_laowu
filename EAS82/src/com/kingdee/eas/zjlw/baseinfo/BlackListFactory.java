package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BlackListFactory
{
    private BlackListFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IBlackList getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IBlackList)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5565A10F") ,com.kingdee.eas.zjlw.baseinfo.IBlackList.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IBlackList getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IBlackList)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5565A10F") ,com.kingdee.eas.zjlw.baseinfo.IBlackList.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IBlackList getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IBlackList)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5565A10F"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IBlackList getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IBlackList)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5565A10F"));
    }
}