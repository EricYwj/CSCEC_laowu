package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BusinessVisaEntryFactory
{
    private BusinessVisaEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.personmess.IBusinessVisaEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IBusinessVisaEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3B452871") ,com.kingdee.eas.zjlw.personmess.IBusinessVisaEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.personmess.IBusinessVisaEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IBusinessVisaEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3B452871") ,com.kingdee.eas.zjlw.personmess.IBusinessVisaEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.personmess.IBusinessVisaEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IBusinessVisaEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3B452871"));
    }
    public static com.kingdee.eas.zjlw.personmess.IBusinessVisaEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.personmess.IBusinessVisaEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3B452871"));
    }
}