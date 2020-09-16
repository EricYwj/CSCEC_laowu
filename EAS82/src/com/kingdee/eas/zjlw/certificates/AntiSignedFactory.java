package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AntiSignedFactory
{
    private AntiSignedFactory()
    {
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiSigned getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiSigned)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EFBAA22F") ,com.kingdee.eas.zjlw.certificates.IAntiSigned.class);
    }
    
    public static com.kingdee.eas.zjlw.certificates.IAntiSigned getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiSigned)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EFBAA22F") ,com.kingdee.eas.zjlw.certificates.IAntiSigned.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiSigned getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiSigned)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EFBAA22F"));
    }
    public static com.kingdee.eas.zjlw.certificates.IAntiSigned getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.certificates.IAntiSigned)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EFBAA22F"));
    }
}