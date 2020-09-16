package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjInsVcPayRegFactory
{
    private ProjInsVcPayRegFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjInsVcPayReg getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjInsVcPayReg)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0CF3389C") ,com.kingdee.eas.zjlw.baseinfo.IProjInsVcPayReg.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IProjInsVcPayReg getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjInsVcPayReg)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0CF3389C") ,com.kingdee.eas.zjlw.baseinfo.IProjInsVcPayReg.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjInsVcPayReg getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjInsVcPayReg)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0CF3389C"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjInsVcPayReg getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjInsVcPayReg)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0CF3389C"));
    }
}