package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjFERAssdEntryFactory
{
    private ProjFERAssdEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IProjFERAssdEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFERAssdEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9E774A99") ,com.kingdee.eas.zjlw.social.IProjFERAssdEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IProjFERAssdEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFERAssdEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9E774A99") ,com.kingdee.eas.zjlw.social.IProjFERAssdEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IProjFERAssdEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFERAssdEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9E774A99"));
    }
    public static com.kingdee.eas.zjlw.social.IProjFERAssdEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFERAssdEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9E774A99"));
    }
}