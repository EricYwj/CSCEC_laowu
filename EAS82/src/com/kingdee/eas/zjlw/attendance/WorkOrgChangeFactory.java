package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkOrgChangeFactory
{
    private WorkOrgChangeFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IWorkOrgChange getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IWorkOrgChange)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E652C85F") ,com.kingdee.eas.zjlw.attendance.IWorkOrgChange.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IWorkOrgChange getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IWorkOrgChange)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E652C85F") ,com.kingdee.eas.zjlw.attendance.IWorkOrgChange.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IWorkOrgChange getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IWorkOrgChange)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E652C85F"));
    }
    public static com.kingdee.eas.zjlw.attendance.IWorkOrgChange getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IWorkOrgChange)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E652C85F"));
    }
}