package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DailyLabourFactory
{
    private DailyLabourFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IDailyLabour getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IDailyLabour)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6A4FF16A") ,com.kingdee.eas.zjlw.baseinfo.IDailyLabour.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IDailyLabour getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IDailyLabour)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6A4FF16A") ,com.kingdee.eas.zjlw.baseinfo.IDailyLabour.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IDailyLabour getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IDailyLabour)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6A4FF16A"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IDailyLabour getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IDailyLabour)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6A4FF16A"));
    }
}