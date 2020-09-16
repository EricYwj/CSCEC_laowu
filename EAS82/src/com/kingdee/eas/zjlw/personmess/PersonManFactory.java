package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonManFactory
{
    private PersonManFactory()
    {
    }
    public static com.kingdee.eas.zjlw.personmess.IPersonMan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IPersonMan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7CBAA965") ,com.kingdee.eas.zjlw.personmess.IPersonMan.class);
    }
    
    public static com.kingdee.eas.zjlw.personmess.IPersonMan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IPersonMan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7CBAA965") ,com.kingdee.eas.zjlw.personmess.IPersonMan.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.personmess.IPersonMan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IPersonMan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7CBAA965"));
    }
    public static com.kingdee.eas.zjlw.personmess.IPersonMan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IPersonMan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7CBAA965"));
    }
}