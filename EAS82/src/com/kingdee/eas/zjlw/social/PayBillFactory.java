package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PayBillFactory
{
    private PayBillFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IPayBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("13D5E00F") ,com.kingdee.eas.zjlw.social.IPayBill.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IPayBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("13D5E00F") ,com.kingdee.eas.zjlw.social.IPayBill.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IPayBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("13D5E00F"));
    }
    public static com.kingdee.eas.zjlw.social.IPayBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("13D5E00F"));
    }
}