package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiPayrollFactory
{
    private ForiPayrollFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IForiPayroll getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPayroll)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8AE8DB85") ,com.kingdee.eas.zjlw.social.IForiPayroll.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IForiPayroll getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPayroll)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8AE8DB85") ,com.kingdee.eas.zjlw.social.IForiPayroll.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IForiPayroll getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPayroll)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8AE8DB85"));
    }
    public static com.kingdee.eas.zjlw.social.IForiPayroll getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPayroll)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8AE8DB85"));
    }
}