package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SecuPayCountFactory
{
    private SecuPayCountFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.ISecuPayCount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPayCount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("059A646B") ,com.kingdee.eas.zjlw.social.ISecuPayCount.class);
    }
    
    public static com.kingdee.eas.zjlw.social.ISecuPayCount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPayCount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("059A646B") ,com.kingdee.eas.zjlw.social.ISecuPayCount.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.ISecuPayCount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPayCount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("059A646B"));
    }
    public static com.kingdee.eas.zjlw.social.ISecuPayCount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPayCount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("059A646B"));
    }
}