package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiCheckedEntryFactory
{
    private ForiCheckedEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IForiCheckedEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiCheckedEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6B61B6AB") ,com.kingdee.eas.zjlw.social.IForiCheckedEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IForiCheckedEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiCheckedEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6B61B6AB") ,com.kingdee.eas.zjlw.social.IForiCheckedEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IForiCheckedEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiCheckedEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6B61B6AB"));
    }
    public static com.kingdee.eas.zjlw.social.IForiCheckedEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiCheckedEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6B61B6AB"));
    }
}