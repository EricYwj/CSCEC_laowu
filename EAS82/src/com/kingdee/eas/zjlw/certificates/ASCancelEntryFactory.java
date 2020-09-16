package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ASCancelEntryFactory
{
    private ASCancelEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IASCancelEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IASCancelEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5AEF27F5") ,com.kingdee.eas.zjlw.certificates.IASCancelEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IASCancelEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IASCancelEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5AEF27F5") ,com.kingdee.eas.zjlw.certificates.IASCancelEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IASCancelEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IASCancelEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5AEF27F5"));
    }
    public static com.kingdee.eas.zjlw.certificates.IASCancelEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IASCancelEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5AEF27F5"));
    }
}