package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CommUtilFacadeFactory
{
    private CommUtilFacadeFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.ICommUtilFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ICommUtilFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B8BD53F9") ,com.kingdee.eas.zjlw.certificates.ICommUtilFacade.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.ICommUtilFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ICommUtilFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B8BD53F9") ,com.kingdee.eas.zjlw.certificates.ICommUtilFacade.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.ICommUtilFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ICommUtilFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B8BD53F9"));
    }
    public static com.kingdee.eas.zjlw.certificates.ICommUtilFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.ICommUtilFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B8BD53F9"));
    }
}