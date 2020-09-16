package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjFEREntryEntryFactory
{
    private ProjFEREntryEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IProjFEREntryEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFEREntryEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BF3195F6") ,com.kingdee.eas.zjlw.social.IProjFEREntryEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IProjFEREntryEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFEREntryEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BF3195F6") ,com.kingdee.eas.zjlw.social.IProjFEREntryEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IProjFEREntryEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFEREntryEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BF3195F6"));
    }
    public static com.kingdee.eas.zjlw.social.IProjFEREntryEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFEREntryEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BF3195F6"));
    }
}