package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjBWREtyFactory
{
    private ProjBWREtyFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IProjBWREty getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWREty)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0FDE242A") ,com.kingdee.eas.zjlw.social.IProjBWREty.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IProjBWREty getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWREty)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0FDE242A") ,com.kingdee.eas.zjlw.social.IProjBWREty.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IProjBWREty getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWREty)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0FDE242A"));
    }
    public static com.kingdee.eas.zjlw.social.IProjBWREty getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWREty)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0FDE242A"));
    }
}