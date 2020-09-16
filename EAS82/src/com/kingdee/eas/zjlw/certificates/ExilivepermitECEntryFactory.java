package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExilivepermitECEntryFactory
{
    private ExilivepermitECEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IExilivepermitECEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermitECEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("13788108") ,com.kingdee.eas.zjlw.certificates.IExilivepermitECEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IExilivepermitECEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermitECEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("13788108") ,com.kingdee.eas.zjlw.certificates.IExilivepermitECEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IExilivepermitECEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermitECEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("13788108"));
    }
    public static com.kingdee.eas.zjlw.certificates.IExilivepermitECEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IExilivepermitECEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("13788108"));
    }
}