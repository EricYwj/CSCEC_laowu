package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjWageNormFactory
{
    private ProjWageNormFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjWageNorm getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjWageNorm)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("45B4CE6F") ,com.kingdee.eas.zjlw.baseinfo.IProjWageNorm.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IProjWageNorm getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjWageNorm)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("45B4CE6F") ,com.kingdee.eas.zjlw.baseinfo.IProjWageNorm.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjWageNorm getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjWageNorm)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("45B4CE6F"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjWageNorm getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjWageNorm)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("45B4CE6F"));
    }
}