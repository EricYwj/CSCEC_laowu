package com.kingdee.eas.zjlw.baseinfo.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.zjlw.baseinfo.DistrGovernmentCollection;
import com.kingdee.eas.zjlw.baseinfo.DistrGovernmentInfo;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DistrGovernmentController extends DataBaseController
{
    public DistrGovernmentInfo getDistrGovernmentInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DistrGovernmentInfo getDistrGovernmentInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DistrGovernmentInfo getDistrGovernmentInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DistrGovernmentCollection getDistrGovernmentCollection(Context ctx) throws BOSException, RemoteException;
    public DistrGovernmentCollection getDistrGovernmentCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DistrGovernmentCollection getDistrGovernmentCollection(Context ctx, String oql) throws BOSException, RemoteException;
}