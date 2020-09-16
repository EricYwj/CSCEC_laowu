package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExilivepermitFactory
{
    private ExilivepermitFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IExilivepermit getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermit)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A3BABFEC") ,com.kingdee.eas.zjlw.certificates.IExilivepermit.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IExilivepermit getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermit)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A3BABFEC") ,com.kingdee.eas.zjlw.certificates.IExilivepermit.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IExilivepermit getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermit)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A3BABFEC"));
    }
    public static com.kingdee.eas.zjlw.certificates.IExilivepermit getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermit)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A3BABFEC"));
    }
}