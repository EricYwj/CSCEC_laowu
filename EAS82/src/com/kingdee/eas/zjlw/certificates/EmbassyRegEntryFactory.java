package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EmbassyRegEntryFactory
{
    private EmbassyRegEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IEmbassyRegEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEmbassyRegEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("595CEDBF") ,com.kingdee.eas.zjlw.certificates.IEmbassyRegEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IEmbassyRegEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEmbassyRegEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("595CEDBF") ,com.kingdee.eas.zjlw.certificates.IEmbassyRegEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IEmbassyRegEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEmbassyRegEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("595CEDBF"));
    }
    public static com.kingdee.eas.zjlw.certificates.IEmbassyRegEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IEmbassyRegEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("595CEDBF"));
    }
}