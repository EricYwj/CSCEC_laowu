package com.kingdee.eas.zjlw.certificates.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.zjlw.certificates.WkPmtDstryECCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.certificates.WkPmtDstryECInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface WkPmtDstryECController extends CoreBillBaseController
{
    public WkPmtDstryECCollection getWkPmtDstryECCollection(Context ctx) throws BOSException, RemoteException;
    public WkPmtDstryECCollection getWkPmtDstryECCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public WkPmtDstryECCollection getWkPmtDstryECCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public WkPmtDstryECInfo getWkPmtDstryECInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public WkPmtDstryECInfo getWkPmtDstryECInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public WkPmtDstryECInfo getWkPmtDstryECInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}