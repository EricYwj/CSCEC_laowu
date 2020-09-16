package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExtAccountFactory
{
    private ExtAccountFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IExtAccount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IExtAccount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CA22973A") ,com.kingdee.eas.zjlw.baseinfo.IExtAccount.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IExtAccount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IExtAccount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CA22973A") ,com.kingdee.eas.zjlw.baseinfo.IExtAccount.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IExtAccount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IExtAccount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CA22973A"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IExtAccount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IExtAccount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CA22973A"));
    }
}