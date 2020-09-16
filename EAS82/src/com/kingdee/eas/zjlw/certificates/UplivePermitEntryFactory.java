package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class UplivePermitEntryFactory
{
    private UplivePermitEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IUplivePermitEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermitEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CE17265F") ,com.kingdee.eas.zjlw.certificates.IUplivePermitEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IUplivePermitEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermitEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CE17265F") ,com.kingdee.eas.zjlw.certificates.IUplivePermitEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IUplivePermitEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermitEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CE17265F"));
    }
    public static com.kingdee.eas.zjlw.certificates.IUplivePermitEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IUplivePermitEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CE17265F"));
    }
}