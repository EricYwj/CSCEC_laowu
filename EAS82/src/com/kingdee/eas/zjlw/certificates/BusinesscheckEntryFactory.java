package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BusinesscheckEntryFactory
{
    private BusinesscheckEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IBusinesscheckEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IBusinesscheckEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("25469C1B") ,com.kingdee.eas.zjlw.certificates.IBusinesscheckEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IBusinesscheckEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IBusinesscheckEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("25469C1B") ,com.kingdee.eas.zjlw.certificates.IBusinesscheckEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IBusinesscheckEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IBusinesscheckEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("25469C1B"));
    }
    public static com.kingdee.eas.zjlw.certificates.IBusinesscheckEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IBusinesscheckEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("25469C1B"));
    }
}