package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkTypeFactory
{
    private WorkTypeFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IWorkType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IWorkType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D8FB13D9") ,com.kingdee.eas.zjlw.baseinfo.IWorkType.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IWorkType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IWorkType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D8FB13D9") ,com.kingdee.eas.zjlw.baseinfo.IWorkType.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IWorkType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IWorkType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D8FB13D9"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IWorkType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IWorkType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D8FB13D9"));
    }
}