package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PayBillEntryFactory
{
    private PayBillEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IPayBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("646EE9A3") ,com.kingdee.eas.zjlw.social.IPayBillEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IPayBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("646EE9A3") ,com.kingdee.eas.zjlw.social.IPayBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IPayBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("646EE9A3"));
    }
    public static com.kingdee.eas.zjlw.social.IPayBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("646EE9A3"));
    }
}