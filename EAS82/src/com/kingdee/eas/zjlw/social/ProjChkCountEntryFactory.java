package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjChkCountEntryFactory
{
    private ProjChkCountEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IProjChkCountEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjChkCountEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C2B924CC") ,com.kingdee.eas.zjlw.social.IProjChkCountEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IProjChkCountEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjChkCountEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C2B924CC") ,com.kingdee.eas.zjlw.social.IProjChkCountEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IProjChkCountEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjChkCountEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C2B924CC"));
    }
    public static com.kingdee.eas.zjlw.social.IProjChkCountEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjChkCountEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C2B924CC"));
    }
}