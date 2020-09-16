package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PayrollEntryFactory
{
    private PayrollEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IPayrollEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayrollEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A08AC70D") ,com.kingdee.eas.zjlw.social.IPayrollEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IPayrollEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayrollEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A08AC70D") ,com.kingdee.eas.zjlw.social.IPayrollEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IPayrollEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayrollEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A08AC70D"));
    }
    public static com.kingdee.eas.zjlw.social.IPayrollEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IPayrollEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A08AC70D"));
    }
}