package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AntiLogoutEntryFactory
{
    private AntiLogoutEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiLogoutEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiLogoutEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("12D8A9D5") ,com.kingdee.eas.zjlw.certificates.IAntiLogoutEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IAntiLogoutEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiLogoutEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("12D8A9D5") ,com.kingdee.eas.zjlw.certificates.IAntiLogoutEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiLogoutEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiLogoutEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("12D8A9D5"));
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiLogoutEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiLogoutEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("12D8A9D5"));
    }
}