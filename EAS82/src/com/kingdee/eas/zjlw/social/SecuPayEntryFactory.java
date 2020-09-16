package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SecuPayEntryFactory
{
    private SecuPayEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.ISecuPayEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPayEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("05B61BCE") ,com.kingdee.eas.zjlw.social.ISecuPayEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.ISecuPayEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPayEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("05B61BCE") ,com.kingdee.eas.zjlw.social.ISecuPayEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.ISecuPayEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPayEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("05B61BCE"));
    }
    public static com.kingdee.eas.zjlw.social.ISecuPayEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPayEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("05B61BCE"));
    }
}