package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class NoCCFactory
{
    private NoCCFactory()
    {
    }
    public static com.kingdee.eas.zjlw.personmess.INoCC getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.INoCC)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E3159241") ,com.kingdee.eas.zjlw.personmess.INoCC.class);
    }
    
    public static com.kingdee.eas.zjlw.personmess.INoCC getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.INoCC)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E3159241") ,com.kingdee.eas.zjlw.personmess.INoCC.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.personmess.INoCC getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.INoCC)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E3159241"));
    }
    public static com.kingdee.eas.zjlw.personmess.INoCC getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.INoCC)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E3159241"));
    }
}