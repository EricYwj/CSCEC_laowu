package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class UplivePermitECFactory
{
    private UplivePermitECFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IUplivePermitEC getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermitEC)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AF817DB1") ,com.kingdee.eas.zjlw.certificates.IUplivePermitEC.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IUplivePermitEC getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermitEC)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AF817DB1") ,com.kingdee.eas.zjlw.certificates.IUplivePermitEC.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IUplivePermitEC getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermitEC)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AF817DB1"));
    }
    public static com.kingdee.eas.zjlw.certificates.IUplivePermitEC getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermitEC)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AF817DB1"));
    }
}