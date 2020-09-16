package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EmbassyRegFactory
{
    private EmbassyRegFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IEmbassyReg getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEmbassyReg)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6EC4BA73") ,com.kingdee.eas.zjlw.certificates.IEmbassyReg.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IEmbassyReg getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEmbassyReg)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6EC4BA73") ,com.kingdee.eas.zjlw.certificates.IEmbassyReg.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IEmbassyReg getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEmbassyReg)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6EC4BA73"));
    }
    public static com.kingdee.eas.zjlw.certificates.IEmbassyReg getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEmbassyReg)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6EC4BA73"));
    }
}