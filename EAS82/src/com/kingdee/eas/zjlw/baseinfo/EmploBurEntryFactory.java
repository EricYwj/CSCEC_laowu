package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EmploBurEntryFactory
{
    private EmploBurEntryFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IEmploBurEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IEmploBurEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D4B00970") ,com.kingdee.eas.zjlw.baseinfo.IEmploBurEntry.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IEmploBurEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IEmploBurEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D4B00970") ,com.kingdee.eas.zjlw.baseinfo.IEmploBurEntry.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IEmploBurEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IEmploBurEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D4B00970"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IEmploBurEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IEmploBurEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D4B00970"));
    }
}