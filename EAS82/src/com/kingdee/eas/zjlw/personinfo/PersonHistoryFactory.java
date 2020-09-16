package com.kingdee.eas.zjlw.personinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonHistoryFactory
{
    private PersonHistoryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.personinfo.IPersonHistory getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.personinfo.IPersonHistory)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("45DA3855") ,com.kingdee.eas.zjlw.personinfo.IPersonHistory.class);
    }
    
    public static com.kingdee.eas.zjlw.personinfo.IPersonHistory getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personinfo.IPersonHistory)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("45DA3855") ,com.kingdee.eas.zjlw.personinfo.IPersonHistory.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.personinfo.IPersonHistory getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personinfo.IPersonHistory)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("45DA3855"));
    }
    public static com.kingdee.eas.zjlw.personinfo.IPersonHistory getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personinfo.IPersonHistory)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("45DA3855"));
    }
}