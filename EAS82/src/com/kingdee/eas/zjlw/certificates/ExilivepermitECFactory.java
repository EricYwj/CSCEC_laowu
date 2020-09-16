package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExilivepermitECFactory
{
    private ExilivepermitECFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IExilivepermitEC getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermitEC)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A00A7D8A") ,com.kingdee.eas.zjlw.certificates.IExilivepermitEC.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IExilivepermitEC getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermitEC)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A00A7D8A") ,com.kingdee.eas.zjlw.certificates.IExilivepermitEC.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IExilivepermitEC getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermitEC)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A00A7D8A"));
    }
    public static com.kingdee.eas.zjlw.certificates.IExilivepermitEC getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermitEC)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A00A7D8A"));
    }
}