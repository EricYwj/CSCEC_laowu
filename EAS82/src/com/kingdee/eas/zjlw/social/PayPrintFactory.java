package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PayPrintFactory
{
    private PayPrintFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IPayPrint getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayPrint)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("67AF77A5") ,com.kingdee.eas.zjlw.social.IPayPrint.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IPayPrint getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayPrint)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("67AF77A5") ,com.kingdee.eas.zjlw.social.IPayPrint.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IPayPrint getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayPrint)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("67AF77A5"));
    }
    public static com.kingdee.eas.zjlw.social.IPayPrint getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayPrint)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("67AF77A5"));
    }
}