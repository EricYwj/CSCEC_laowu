package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DoubEcFactory
{
    private DoubEcFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IDoubEc getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubEc)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C594BCA7") ,com.kingdee.eas.zjlw.certificates.IDoubEc.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IDoubEc getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubEc)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C594BCA7") ,com.kingdee.eas.zjlw.certificates.IDoubEc.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IDoubEc getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubEc)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C594BCA7"));
    }
    public static com.kingdee.eas.zjlw.certificates.IDoubEc getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IDoubEc)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C594BCA7"));
    }
}