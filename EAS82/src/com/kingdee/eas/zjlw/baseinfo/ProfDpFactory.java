package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProfDpFactory
{
    private ProfDpFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProfDp getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProfDp)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("63421733") ,com.kingdee.eas.zjlw.baseinfo.IProfDp.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IProfDp getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProfDp)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("63421733") ,com.kingdee.eas.zjlw.baseinfo.IProfDp.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProfDp getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProfDp)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("63421733"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProfDp getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProfDp)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("63421733"));
    }
}