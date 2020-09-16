package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkVisaFactory
{
    private WorkVisaFactory()
    {
    }
    public static com.kingdee.eas.zjlw.personmess.IWorkVisa getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IWorkVisa)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("570B3F52") ,com.kingdee.eas.zjlw.personmess.IWorkVisa.class);
    }
    
    public static com.kingdee.eas.zjlw.personmess.IWorkVisa getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IWorkVisa)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("570B3F52") ,com.kingdee.eas.zjlw.personmess.IWorkVisa.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.personmess.IWorkVisa getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IWorkVisa)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("570B3F52"));
    }
    public static com.kingdee.eas.zjlw.personmess.IWorkVisa getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IWorkVisa)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("570B3F52"));
    }
}