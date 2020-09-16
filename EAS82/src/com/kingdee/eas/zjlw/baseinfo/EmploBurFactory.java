package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EmploBurFactory
{
    private EmploBurFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IEmploBur getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IEmploBur)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1E095422") ,com.kingdee.eas.zjlw.baseinfo.IEmploBur.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IEmploBur getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IEmploBur)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1E095422") ,com.kingdee.eas.zjlw.baseinfo.IEmploBur.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IEmploBur getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IEmploBur)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1E095422"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IEmploBur getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IEmploBur)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1E095422"));
    }
}