package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjBWRAssdFactory
{
    private ProjBWRAssdFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IProjBWRAssd getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWRAssd)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EBE48B83") ,com.kingdee.eas.zjlw.social.IProjBWRAssd.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IProjBWRAssd getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWRAssd)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EBE48B83") ,com.kingdee.eas.zjlw.social.IProjBWRAssd.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IProjBWRAssd getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWRAssd)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EBE48B83"));
    }
    public static com.kingdee.eas.zjlw.social.IProjBWRAssd getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWRAssd)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EBE48B83"));
    }
}