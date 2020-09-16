package com.kingdee.eas.zjlw.attendance.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.zjlw.attendance.AlgAttCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.zjlw.attendance.AlgAttInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface AlgAttController extends CoreBillBaseController
{
    public AlgAttCollection getAlgAttCollection(Context ctx) throws BOSException, RemoteException;
    public AlgAttCollection getAlgAttCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public AlgAttCollection getAlgAttCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public AlgAttInfo getAlgAttInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public AlgAttInfo getAlgAttInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public AlgAttInfo getAlgAttInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}