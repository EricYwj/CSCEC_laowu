package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class NoCCEntryFactory
{
    private NoCCEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.personmess.INoCCEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.INoCCEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5880C6B1") ,com.kingdee.eas.zjlw.personmess.INoCCEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.personmess.INoCCEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.INoCCEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5880C6B1") ,com.kingdee.eas.zjlw.personmess.INoCCEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.personmess.INoCCEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.INoCCEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5880C6B1"));
    }
    public static com.kingdee.eas.zjlw.personmess.INoCCEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.INoCCEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5880C6B1"));
    }
}