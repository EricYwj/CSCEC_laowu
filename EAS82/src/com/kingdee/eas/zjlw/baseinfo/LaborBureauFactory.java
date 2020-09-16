package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LaborBureauFactory
{
    private LaborBureauFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILaborBureau getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILaborBureau)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B8FEE41C") ,com.kingdee.eas.zjlw.baseinfo.ILaborBureau.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ILaborBureau getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILaborBureau)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B8FEE41C") ,com.kingdee.eas.zjlw.baseinfo.ILaborBureau.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILaborBureau getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILaborBureau)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B8FEE41C"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILaborBureau getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILaborBureau)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B8FEE41C"));
    }
}