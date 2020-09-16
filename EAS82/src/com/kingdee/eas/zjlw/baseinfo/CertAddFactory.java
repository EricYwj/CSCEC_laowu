package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CertAddFactory
{
    private CertAddFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ICertAdd getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ICertAdd)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3F51642F") ,com.kingdee.eas.zjlw.baseinfo.ICertAdd.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ICertAdd getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ICertAdd)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3F51642F") ,com.kingdee.eas.zjlw.baseinfo.ICertAdd.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ICertAdd getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ICertAdd)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3F51642F"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ICertAdd getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ICertAdd)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3F51642F"));
    }
}