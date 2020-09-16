package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjSecuProfFactory
{
    private ProjSecuProfFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjSecuProf getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjSecuProf)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("73D81128") ,com.kingdee.eas.zjlw.baseinfo.IProjSecuProf.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IProjSecuProf getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjSecuProf)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("73D81128") ,com.kingdee.eas.zjlw.baseinfo.IProjSecuProf.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjSecuProf getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjSecuProf)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("73D81128"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjSecuProf getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjSecuProf)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("73D81128"));
    }
}