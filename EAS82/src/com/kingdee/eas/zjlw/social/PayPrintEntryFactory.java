package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PayPrintEntryFactory
{
    private PayPrintEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IPayPrintEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayPrintEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3BF29FCD") ,com.kingdee.eas.zjlw.social.IPayPrintEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IPayPrintEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayPrintEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3BF29FCD") ,com.kingdee.eas.zjlw.social.IPayPrintEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IPayPrintEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayPrintEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3BF29FCD"));
    }
    public static com.kingdee.eas.zjlw.social.IPayPrintEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayPrintEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3BF29FCD"));
    }
}