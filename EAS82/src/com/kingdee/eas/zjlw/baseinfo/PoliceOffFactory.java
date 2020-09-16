package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PoliceOffFactory
{
    private PoliceOffFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IPoliceOff getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IPoliceOff)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F8831743") ,com.kingdee.eas.zjlw.baseinfo.IPoliceOff.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IPoliceOff getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IPoliceOff)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F8831743") ,com.kingdee.eas.zjlw.baseinfo.IPoliceOff.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IPoliceOff getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IPoliceOff)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F8831743"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IPoliceOff getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IPoliceOff)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F8831743"));
    }
}