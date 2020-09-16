package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LabSupBurFactory
{
    private LabSupBurFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILabSupBur getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILabSupBur)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C39A7110") ,com.kingdee.eas.zjlw.baseinfo.ILabSupBur.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ILabSupBur getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILabSupBur)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C39A7110") ,com.kingdee.eas.zjlw.baseinfo.ILabSupBur.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILabSupBur getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILabSupBur)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C39A7110"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ILabSupBur getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ILabSupBur)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C39A7110"));
    }
}