package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjWageNormEntryFactory
{
    private ProjWageNormEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjWageNormEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjWageNormEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7285F743") ,com.kingdee.eas.zjlw.baseinfo.IProjWageNormEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IProjWageNormEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjWageNormEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7285F743") ,com.kingdee.eas.zjlw.baseinfo.IProjWageNormEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjWageNormEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjWageNormEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7285F743"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjWageNormEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjWageNormEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7285F743"));
    }
}