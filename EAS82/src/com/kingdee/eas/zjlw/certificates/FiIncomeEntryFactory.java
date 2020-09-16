package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FiIncomeEntryFactory
{
    private FiIncomeEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IFiIncomeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IFiIncomeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("ACB6B0D5") ,com.kingdee.eas.zjlw.certificates.IFiIncomeEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IFiIncomeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IFiIncomeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("ACB6B0D5") ,com.kingdee.eas.zjlw.certificates.IFiIncomeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IFiIncomeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IFiIncomeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("ACB6B0D5"));
    }
    public static com.kingdee.eas.zjlw.certificates.IFiIncomeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IFiIncomeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("ACB6B0D5"));
    }
}