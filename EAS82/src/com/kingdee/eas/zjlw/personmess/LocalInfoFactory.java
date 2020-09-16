package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LocalInfoFactory
{
    private LocalInfoFactory()
    {
    }
    public static com.kingdee.eas.zjlw.personmess.ILocalInfo getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.ILocalInfo)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("02055E59") ,com.kingdee.eas.zjlw.personmess.ILocalInfo.class);
    }
    
    public static com.kingdee.eas.zjlw.personmess.ILocalInfo getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.ILocalInfo)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("02055E59") ,com.kingdee.eas.zjlw.personmess.ILocalInfo.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.personmess.ILocalInfo getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.ILocalInfo)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("02055E59"));
    }
    public static com.kingdee.eas.zjlw.personmess.ILocalInfo getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.ILocalInfo)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("02055E59"));
    }
}