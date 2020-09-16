package com.kingdee.eas.zjlw.social.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.zjlw.social.CheckCountInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.zjlw.social.CheckCountCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CheckCountController extends CoreBillBaseController
{
    public CheckCountCollection getCheckCountCollection(Context ctx) throws BOSException, RemoteException;
    public CheckCountCollection getCheckCountCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CheckCountCollection getCheckCountCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CheckCountInfo getCheckCountInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CheckCountInfo getCheckCountInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CheckCountInfo getCheckCountInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public IObjectValue initBill(Context ctx, IObjectValue info) throws BOSException, EASBizException, RemoteException;
}