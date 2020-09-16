package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PmtAppFactory
{
    private PmtAppFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IPmtApp getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IPmtApp)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("62FD61F8") ,com.kingdee.eas.zjlw.baseinfo.IPmtApp.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IPmtApp getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IPmtApp)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("62FD61F8") ,com.kingdee.eas.zjlw.baseinfo.IPmtApp.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IPmtApp getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IPmtApp)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("62FD61F8"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IPmtApp getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IPmtApp)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("62FD61F8"));
    }
}