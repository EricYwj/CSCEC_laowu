package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LocalBlackListFactory
{
    private LocalBlackListFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILocalBlackList getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILocalBlackList)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2D729580") ,com.kingdee.eas.zjlw.baseinfo.ILocalBlackList.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ILocalBlackList getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILocalBlackList)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2D729580") ,com.kingdee.eas.zjlw.baseinfo.ILocalBlackList.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILocalBlackList getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILocalBlackList)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2D729580"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILocalBlackList getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILocalBlackList)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2D729580"));
    }
}