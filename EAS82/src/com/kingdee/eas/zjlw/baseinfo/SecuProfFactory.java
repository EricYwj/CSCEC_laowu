package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SecuProfFactory
{
    private SecuProfFactory()
    {
    }
    public static com.kingdee.eas.zjlw.baseinfo.ISecuProf getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISecuProf)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0F6A5DAB") ,com.kingdee.eas.zjlw.baseinfo.ISecuProf.class);
    }
    
    public static com.kingdee.eas.zjlw.baseinfo.ISecuProf getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISecuProf)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0F6A5DAB") ,com.kingdee.eas.zjlw.baseinfo.ISecuProf.class, objectCtx);
    }
    public static com.kingdee.eas.zjlw.baseinfo.ISecuProf getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISecuProf)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0F6A5DAB"));
    }
    public static com.kingdee.eas.zjlw.baseinfo.ISecuProf getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.zjlw.baseinfo.ISecuProf)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0F6A5DAB"));
    }
}