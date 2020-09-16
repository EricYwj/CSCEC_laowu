package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjFERAssdFactory
{
    private ProjFERAssdFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IProjFERAssd getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFERAssd)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A0C63D59") ,com.kingdee.eas.zjlw.social.IProjFERAssd.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IProjFERAssd getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFERAssd)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A0C63D59") ,com.kingdee.eas.zjlw.social.IProjFERAssd.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IProjFERAssd getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFERAssd)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A0C63D59"));
    }
    public static com.kingdee.eas.zjlw.social.IProjFERAssd getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjFERAssd)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A0C63D59"));
    }
}