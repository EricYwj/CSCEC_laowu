package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DoubQualifyEntryFactory
{
    private DoubQualifyEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IDoubQualifyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubQualifyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("63B6D9EE") ,com.kingdee.eas.zjlw.certificates.IDoubQualifyEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IDoubQualifyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubQualifyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("63B6D9EE") ,com.kingdee.eas.zjlw.certificates.IDoubQualifyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IDoubQualifyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubQualifyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("63B6D9EE"));
    }
    public static com.kingdee.eas.zjlw.certificates.IDoubQualifyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubQualifyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("63B6D9EE"));
    }
}