package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AntiLogoutFactory
{
    private AntiLogoutFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiLogout getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiLogout)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E41D489D") ,com.kingdee.eas.zjlw.certificates.IAntiLogout.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IAntiLogout getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiLogout)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E41D489D") ,com.kingdee.eas.zjlw.certificates.IAntiLogout.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiLogout getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiLogout)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E41D489D"));
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiLogout getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiLogout)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E41D489D"));
    }
}