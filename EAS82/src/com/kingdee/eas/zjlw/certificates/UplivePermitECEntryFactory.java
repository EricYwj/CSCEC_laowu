package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class UplivePermitECEntryFactory
{
    private UplivePermitECEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IUplivePermitECEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermitECEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("58EE8141") ,com.kingdee.eas.zjlw.certificates.IUplivePermitECEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IUplivePermitECEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermitECEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("58EE8141") ,com.kingdee.eas.zjlw.certificates.IUplivePermitECEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IUplivePermitECEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermitECEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("58EE8141"));
    }
    public static com.kingdee.eas.zjlw.certificates.IUplivePermitECEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermitECEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("58EE8141"));
    }
}