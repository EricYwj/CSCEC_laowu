package com.kingdee.eas.zjlw.attendance.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.zjlw.attendance.CheckRuleInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.eas.zjlw.attendance.CheckRuleCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CheckRuleController extends DataBaseController
{
    public CheckRuleInfo getCheckRuleInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CheckRuleInfo getCheckRuleInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CheckRuleInfo getCheckRuleInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CheckRuleCollection getCheckRuleCollection(Context ctx) throws BOSException, RemoteException;
    public CheckRuleCollection getCheckRuleCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CheckRuleCollection getCheckRuleCollection(Context ctx, String oql) throws BOSException, RemoteException;
}