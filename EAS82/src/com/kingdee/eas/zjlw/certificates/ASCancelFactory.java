package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ASCancelFactory
{
    private ASCancelFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IASCancel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IASCancel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5D38767D") ,com.kingdee.eas.zjlw.certificates.IASCancel.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IASCancel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IASCancel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5D38767D") ,com.kingdee.eas.zjlw.certificates.IASCancel.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IASCancel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IASCancel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5D38767D"));
    }
    public static com.kingdee.eas.zjlw.certificates.IASCancel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IASCancel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5D38767D"));
    }
}