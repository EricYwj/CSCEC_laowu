package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LaborBureauEntryFactory
{
    private LaborBureauEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILaborBureauEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILaborBureauEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7A7765B6") ,com.kingdee.eas.zjlw.baseinfo.ILaborBureauEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ILaborBureauEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILaborBureauEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7A7765B6") ,com.kingdee.eas.zjlw.baseinfo.ILaborBureauEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILaborBureauEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILaborBureauEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7A7765B6"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILaborBureauEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILaborBureauEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7A7765B6"));
    }
}