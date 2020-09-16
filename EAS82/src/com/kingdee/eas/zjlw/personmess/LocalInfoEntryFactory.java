package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LocalInfoEntryFactory
{
    private LocalInfoEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.personmess.ILocalInfoEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.ILocalInfoEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7C84C999") ,com.kingdee.eas.zjlw.personmess.ILocalInfoEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.personmess.ILocalInfoEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.ILocalInfoEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7C84C999") ,com.kingdee.eas.zjlw.personmess.ILocalInfoEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.personmess.ILocalInfoEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.ILocalInfoEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7C84C999"));
    }
    public static com.kingdee.eas.zjlw.personmess.ILocalInfoEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.ILocalInfoEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7C84C999"));
    }
}