package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AlgAttDataEntryFactory
{
    private AlgAttDataEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttDataEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttDataEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("88BC8ABF") ,com.kingdee.eas.zjlw.attendance.IAlgAttDataEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAlgAttDataEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttDataEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("88BC8ABF") ,com.kingdee.eas.zjlw.attendance.IAlgAttDataEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttDataEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttDataEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("88BC8ABF"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAlgAttDataEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAlgAttDataEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("88BC8ABF"));
    }
}