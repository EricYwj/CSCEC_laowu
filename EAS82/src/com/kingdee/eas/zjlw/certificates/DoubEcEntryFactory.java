package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DoubEcEntryFactory
{
    private DoubEcEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IDoubEcEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubEcEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("86FA2C0B") ,com.kingdee.eas.zjlw.certificates.IDoubEcEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IDoubEcEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubEcEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("86FA2C0B") ,com.kingdee.eas.zjlw.certificates.IDoubEcEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IDoubEcEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubEcEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("86FA2C0B"));
    }
    public static com.kingdee.eas.zjlw.certificates.IDoubEcEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubEcEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("86FA2C0B"));
    }
}