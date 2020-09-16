package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LocalPayPrintFactory
{
    private LocalPayPrintFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.ILocalPayPrint getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ILocalPayPrint)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("15B29EB0") ,com.kingdee.eas.zjlw.social.ILocalPayPrint.class);
    }
    
    public static com.kingdee.eas.zjlw.social.ILocalPayPrint getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ILocalPayPrint)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("15B29EB0") ,com.kingdee.eas.zjlw.social.ILocalPayPrint.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.ILocalPayPrint getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ILocalPayPrint)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("15B29EB0"));
    }
    public static com.kingdee.eas.zjlw.social.ILocalPayPrint getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ILocalPayPrint)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("15B29EB0"));
    }
}