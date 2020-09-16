package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiPayrollEntryFactory
{
    private ForiPayrollEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IForiPayrollEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPayrollEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A25CA7ED") ,com.kingdee.eas.zjlw.social.IForiPayrollEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IForiPayrollEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPayrollEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A25CA7ED") ,com.kingdee.eas.zjlw.social.IForiPayrollEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IForiPayrollEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPayrollEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A25CA7ED"));
    }
    public static com.kingdee.eas.zjlw.social.IForiPayrollEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPayrollEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A25CA7ED"));
    }
}