package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProfDpTreeFactory
{
    private ProfDpTreeFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProfDpTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProfDpTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("39552D71") ,com.kingdee.eas.zjlw.baseinfo.IProfDpTree.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.IProfDpTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProfDpTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("39552D71") ,com.kingdee.eas.zjlw.baseinfo.IProfDpTree.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProfDpTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProfDpTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("39552D71"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.IProfDpTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.IProfDpTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("39552D71"));
    }
}