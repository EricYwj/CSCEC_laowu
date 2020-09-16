package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PayrollFactory
{
    private PayrollFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IPayroll getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayroll)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("13EBC865") ,com.kingdee.eas.zjlw.social.IPayroll.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IPayroll getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayroll)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("13EBC865") ,com.kingdee.eas.zjlw.social.IPayroll.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IPayroll getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayroll)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("13EBC865"));
    }
    public static com.kingdee.eas.zjlw.social.IPayroll getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayroll)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("13EBC865"));
    }
}