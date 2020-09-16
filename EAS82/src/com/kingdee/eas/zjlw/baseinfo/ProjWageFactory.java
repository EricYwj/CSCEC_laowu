package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjWageFactory
{
    private ProjWageFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjWage getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjWage)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9B59EC13") ,com.kingdee.eas.zjlw.baseinfo.IProjWage.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IProjWage getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjWage)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9B59EC13") ,com.kingdee.eas.zjlw.baseinfo.IProjWage.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjWage getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjWage)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9B59EC13"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjWage getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjWage)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9B59EC13"));
    }
}