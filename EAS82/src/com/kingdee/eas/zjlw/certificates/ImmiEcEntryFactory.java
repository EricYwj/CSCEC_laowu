package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ImmiEcEntryFactory
{
    private ImmiEcEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IImmiEcEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmiEcEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BBE389A3") ,com.kingdee.eas.zjlw.certificates.IImmiEcEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IImmiEcEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmiEcEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BBE389A3") ,com.kingdee.eas.zjlw.certificates.IImmiEcEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IImmiEcEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmiEcEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BBE389A3"));
    }
    public static com.kingdee.eas.zjlw.certificates.IImmiEcEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IImmiEcEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BBE389A3"));
    }
}