package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SecuSplitFactory
{
    private SecuSplitFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.ISecuSplit getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuSplit)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9C3A0276") ,com.kingdee.eas.zjlw.social.ISecuSplit.class);
    }
    
    public static com.kingdee.eas.zjlw.social.ISecuSplit getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuSplit)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9C3A0276") ,com.kingdee.eas.zjlw.social.ISecuSplit.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.ISecuSplit getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuSplit)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9C3A0276"));
    }
    public static com.kingdee.eas.zjlw.social.ISecuSplit getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuSplit)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9C3A0276"));
    }
}