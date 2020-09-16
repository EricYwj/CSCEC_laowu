package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FiIncomeFactory
{
    private FiIncomeFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IFiIncome getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IFiIncome)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FB56E19D") ,com.kingdee.eas.zjlw.certificates.IFiIncome.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IFiIncome getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IFiIncome)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FB56E19D") ,com.kingdee.eas.zjlw.certificates.IFiIncome.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IFiIncome getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IFiIncome)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FB56E19D"));
    }
    public static com.kingdee.eas.zjlw.certificates.IFiIncome getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IFiIncome)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FB56E19D"));
    }
}