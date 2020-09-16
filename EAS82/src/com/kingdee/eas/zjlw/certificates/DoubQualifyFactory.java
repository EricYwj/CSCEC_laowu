package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DoubQualifyFactory
{
    private DoubQualifyFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IDoubQualify getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubQualify)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2205ACE4") ,com.kingdee.eas.zjlw.certificates.IDoubQualify.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IDoubQualify getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubQualify)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2205ACE4") ,com.kingdee.eas.zjlw.certificates.IDoubQualify.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IDoubQualify getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubQualify)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2205ACE4"));
    }
    public static com.kingdee.eas.zjlw.certificates.IDoubQualify getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubQualify)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2205ACE4"));
    }
}