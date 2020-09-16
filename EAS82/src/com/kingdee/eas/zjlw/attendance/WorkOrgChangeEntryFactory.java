package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkOrgChangeEntryFactory
{
    private WorkOrgChangeEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IWorkOrgChangeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IWorkOrgChangeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2C46B353") ,com.kingdee.eas.zjlw.attendance.IWorkOrgChangeEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IWorkOrgChangeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IWorkOrgChangeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2C46B353") ,com.kingdee.eas.zjlw.attendance.IWorkOrgChangeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IWorkOrgChangeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IWorkOrgChangeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2C46B353"));
    }
    public static com.kingdee.eas.zjlw.attendance.IWorkOrgChangeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IWorkOrgChangeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2C46B353"));
    }
}