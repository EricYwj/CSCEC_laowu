package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjBWRAssdEntryFactory
{
    private ProjBWRAssdEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IProjBWRAssdEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWRAssdEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F7C546AF") ,com.kingdee.eas.zjlw.social.IProjBWRAssdEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IProjBWRAssdEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWRAssdEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F7C546AF") ,com.kingdee.eas.zjlw.social.IProjBWRAssdEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IProjBWRAssdEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWRAssdEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F7C546AF"));
    }
    public static com.kingdee.eas.zjlw.social.IProjBWRAssdEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWRAssdEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F7C546AF"));
    }
}