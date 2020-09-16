package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InsurePersonFactory
{
    private InsurePersonFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.IInsurePerson getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IInsurePerson)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("94B5EF6F") ,com.kingdee.eas.zjlw.social.IInsurePerson.class);
    }
    
    public static com.kingdee.eas.zjlw.social.IInsurePerson getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IInsurePerson)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("94B5EF6F") ,com.kingdee.eas.zjlw.social.IInsurePerson.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.IInsurePerson getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IInsurePerson)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("94B5EF6F"));
    }
    public static com.kingdee.eas.zjlw.social.IInsurePerson getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.IInsurePerson)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("94B5EF6F"));
    }
}