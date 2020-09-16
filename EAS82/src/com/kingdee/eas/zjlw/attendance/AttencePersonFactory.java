package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AttencePersonFactory
{
    private AttencePersonFactory()
    {
    }
    public static com.kingdee.eas.zjlw.attendance.IAttencePerson getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttencePerson)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("87F1141D") ,com.kingdee.eas.zjlw.attendance.IAttencePerson.class);
    }
    
    public static com.kingdee.eas.zjlw.attendance.IAttencePerson getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttencePerson)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("87F1141D") ,com.kingdee.eas.zjlw.attendance.IAttencePerson.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.attendance.IAttencePerson getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttencePerson)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("87F1141D"));
    }
    public static com.kingdee.eas.zjlw.attendance.IAttencePerson getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.attendance.IAttencePerson)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("87F1141D"));
    }
}