package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForiCheckedFactory
{
    private ForiCheckedFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IForiChecked getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiChecked)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E6090E07") ,com.kingdee.eas.zjlw.social.IForiChecked.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IForiChecked getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiChecked)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E6090E07") ,com.kingdee.eas.zjlw.social.IForiChecked.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IForiChecked getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiChecked)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E6090E07"));
    }
    public static com.kingdee.eas.zjlw.social.IForiChecked getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IForiChecked)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E6090E07"));
    }
}