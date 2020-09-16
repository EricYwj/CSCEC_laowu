package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BusinessVisaFactory
{
    private BusinessVisaFactory()
    {
    }
    public static com.kingdee.eas.zjlw.personmess.IBusinessVisa getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IBusinessVisa)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E80B1881") ,com.kingdee.eas.zjlw.personmess.IBusinessVisa.class);
    }
    
    public static com.kingdee.eas.zjlw.personmess.IBusinessVisa getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IBusinessVisa)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E80B1881") ,com.kingdee.eas.zjlw.personmess.IBusinessVisa.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.personmess.IBusinessVisa getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IBusinessVisa)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E80B1881"));
    }
    public static com.kingdee.eas.zjlw.personmess.IBusinessVisa getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IBusinessVisa)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E80B1881"));
    }
}