package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjFEREntryFactory
{
    private ProjFEREntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IProjFEREntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFEREntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("78378BDC") ,com.kingdee.eas.zjlw.social.IProjFEREntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IProjFEREntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFEREntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("78378BDC") ,com.kingdee.eas.zjlw.social.IProjFEREntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IProjFEREntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFEREntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("78378BDC"));
    }
    public static com.kingdee.eas.zjlw.social.IProjFEREntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFEREntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("78378BDC"));
    }
}