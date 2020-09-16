package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProjBWREtyEntryFactory
{
    private ProjBWREtyEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IProjBWREtyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWREtyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E503FE68") ,com.kingdee.eas.zjlw.social.IProjBWREtyEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IProjBWREtyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWREtyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E503FE68") ,com.kingdee.eas.zjlw.social.IProjBWREtyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IProjBWREtyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWREtyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E503FE68"));
    }
    public static com.kingdee.eas.zjlw.social.IProjBWREtyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IProjBWREtyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E503FE68"));
    }
}