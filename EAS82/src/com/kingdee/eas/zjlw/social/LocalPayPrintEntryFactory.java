package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LocalPayPrintEntryFactory
{
    private LocalPayPrintEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.ILocalPayPrintEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ILocalPayPrintEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("779527A2") ,com.kingdee.eas.zjlw.social.ILocalPayPrintEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.ILocalPayPrintEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ILocalPayPrintEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("779527A2") ,com.kingdee.eas.zjlw.social.ILocalPayPrintEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.ILocalPayPrintEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ILocalPayPrintEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("779527A2"));
    }
    public static com.kingdee.eas.zjlw.social.ILocalPayPrintEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ILocalPayPrintEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("779527A2"));
    }
}