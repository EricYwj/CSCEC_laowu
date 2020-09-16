package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjectOrgFactory
{
    private ProjectOrgFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjectOrg getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjectOrg)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4494DF79") ,com.kingdee.eas.zjlw.baseinfo.IProjectOrg.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IProjectOrg getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjectOrg)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4494DF79") ,com.kingdee.eas.zjlw.baseinfo.IProjectOrg.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjectOrg getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjectOrg)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4494DF79"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProjectOrg getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProjectOrg)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4494DF79"));
    }
}