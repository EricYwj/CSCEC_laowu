package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ImmigrationEntryFactory
{
    private ImmigrationEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IImmigrationEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmigrationEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E48C97B9") ,com.kingdee.eas.zjlw.certificates.IImmigrationEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IImmigrationEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmigrationEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E48C97B9") ,com.kingdee.eas.zjlw.certificates.IImmigrationEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IImmigrationEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmigrationEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E48C97B9"));
    }
    public static com.kingdee.eas.zjlw.certificates.IImmigrationEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmigrationEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E48C97B9"));
    }
}