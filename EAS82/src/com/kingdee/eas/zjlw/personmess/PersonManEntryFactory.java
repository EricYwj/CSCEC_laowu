package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonManEntryFactory
{
    private PersonManEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.personmess.IPersonManEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IPersonManEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7AE0860D") ,com.kingdee.eas.zjlw.personmess.IPersonManEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.personmess.IPersonManEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IPersonManEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7AE0860D") ,com.kingdee.eas.zjlw.personmess.IPersonManEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.personmess.IPersonManEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IPersonManEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7AE0860D"));
    }
    public static com.kingdee.eas.zjlw.personmess.IPersonManEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IPersonManEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7AE0860D"));
    }
}