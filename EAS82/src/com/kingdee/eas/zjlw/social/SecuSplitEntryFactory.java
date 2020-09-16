package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SecuSplitEntryFactory
{
    private SecuSplitEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.ISecuSplitEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuSplitEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2F132F9C") ,com.kingdee.eas.zjlw.social.ISecuSplitEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.ISecuSplitEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuSplitEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2F132F9C") ,com.kingdee.eas.zjlw.social.ISecuSplitEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.ISecuSplitEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuSplitEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2F132F9C"));
    }
    public static com.kingdee.eas.zjlw.social.ISecuSplitEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuSplitEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2F132F9C"));
    }
}