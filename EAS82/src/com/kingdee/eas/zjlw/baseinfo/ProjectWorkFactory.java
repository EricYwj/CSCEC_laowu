package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjectWorkFactory
{
    private ProjectWorkFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjectWork getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjectWork)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4E0AA91C") ,com.kingdee.eas.zjlw.baseinfo.IProjectWork.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IProjectWork getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjectWork)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4E0AA91C") ,com.kingdee.eas.zjlw.baseinfo.IProjectWork.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjectWork getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjectWork)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4E0AA91C"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjectWork getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjectWork)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4E0AA91C"));
    }
}