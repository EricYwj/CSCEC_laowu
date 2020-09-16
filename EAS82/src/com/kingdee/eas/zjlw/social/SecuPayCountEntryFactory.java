package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SecuPayCountEntryFactory
{
    private SecuPayCountEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.ISecuPayCountEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPayCountEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C9DABEC7") ,com.kingdee.eas.zjlw.social.ISecuPayCountEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.ISecuPayCountEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPayCountEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C9DABEC7") ,com.kingdee.eas.zjlw.social.ISecuPayCountEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.ISecuPayCountEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPayCountEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C9DABEC7"));
    }
    public static com.kingdee.eas.zjlw.social.ISecuPayCountEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPayCountEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C9DABEC7"));
    }
}