package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkVisaEntryFactory
{
    private WorkVisaEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.personmess.IWorkVisaEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IWorkVisaEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("69119C40") ,com.kingdee.eas.zjlw.personmess.IWorkVisaEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.personmess.IWorkVisaEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IWorkVisaEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("69119C40") ,com.kingdee.eas.zjlw.personmess.IWorkVisaEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.personmess.IWorkVisaEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IWorkVisaEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("69119C40"));
    }
    public static com.kingdee.eas.zjlw.personmess.IWorkVisaEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IWorkVisaEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("69119C40"));
    }
}