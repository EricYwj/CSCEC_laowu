package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExtAccountEntryFactory
{
    private ExtAccountEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IExtAccountEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IExtAccountEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4DDCF558") ,com.kingdee.eas.zjlw.baseinfo.IExtAccountEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IExtAccountEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IExtAccountEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4DDCF558") ,com.kingdee.eas.zjlw.baseinfo.IExtAccountEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IExtAccountEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IExtAccountEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4DDCF558"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IExtAccountEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IExtAccountEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4DDCF558"));
    }
}