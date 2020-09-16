package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjectOrgEntryFactory
{
    private ProjectOrgEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjectOrgEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjectOrgEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D318FC79") ,com.kingdee.eas.zjlw.baseinfo.IProjectOrgEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IProjectOrgEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjectOrgEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D318FC79") ,com.kingdee.eas.zjlw.baseinfo.IProjectOrgEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjectOrgEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjectOrgEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D318FC79"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjectOrgEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjectOrgEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D318FC79"));
    }
}