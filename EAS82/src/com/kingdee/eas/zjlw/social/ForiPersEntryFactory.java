package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiPersEntryFactory
{
    private ForiPersEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IForiPersEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPersEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A0BF357C") ,com.kingdee.eas.zjlw.social.IForiPersEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IForiPersEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPersEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A0BF357C") ,com.kingdee.eas.zjlw.social.IForiPersEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IForiPersEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPersEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A0BF357C"));
    }
    public static com.kingdee.eas.zjlw.social.IForiPersEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiPersEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A0BF357C"));
    }
}