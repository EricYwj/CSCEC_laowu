package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BlackpersonFactory
{
    private BlackpersonFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IBlackperson getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IBlackperson)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CFB74766") ,com.kingdee.eas.zjlw.baseinfo.IBlackperson.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IBlackperson getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IBlackperson)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CFB74766") ,com.kingdee.eas.zjlw.baseinfo.IBlackperson.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IBlackperson getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IBlackperson)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CFB74766"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IBlackperson getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IBlackperson)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CFB74766"));
    }
}