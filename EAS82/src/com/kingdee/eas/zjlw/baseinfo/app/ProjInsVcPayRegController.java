package com.kingdee.eas.zjlw.baseinfo.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.zjlw.baseinfo.ProjInsVcPayRegCollection;
import java.lang.String;
import com.kingdee.eas.zjlw.baseinfo.ProjInsVcPayRegInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ProjInsVcPayRegController extends CoreBillBaseController
{
    public ProjInsVcPayRegCollection getProjInsVcPayRegCollection(Context ctx) throws BOSException, RemoteException;
    public ProjInsVcPayRegCollection getProjInsVcPayRegCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ProjInsVcPayRegCollection getProjInsVcPayRegCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ProjInsVcPayRegInfo getProjInsVcPayRegInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ProjInsVcPayRegInfo getProjInsVcPayRegInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ProjInsVcPayRegInfo getProjInsVcPayRegInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}