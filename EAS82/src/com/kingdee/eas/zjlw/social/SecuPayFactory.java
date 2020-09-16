package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SecuPayFactory
{
    private SecuPayFactory()
    {
    }
    public static com.kingdee.eas.zjlw.social.ISecuPay getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPay)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B83CBF04") ,com.kingdee.eas.zjlw.social.ISecuPay.class);
    }
    
    public static com.kingdee.eas.zjlw.social.ISecuPay getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPay)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B83CBF04") ,com.kingdee.eas.zjlw.social.ISecuPay.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.social.ISecuPay getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPay)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B83CBF04"));
    }
    public static com.kingdee.eas.zjlw.social.ISecuPay getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.social.ISecuPay)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B83CBF04"));
    }
}