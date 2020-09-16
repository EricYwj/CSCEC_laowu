package com.kingdee.eas.zjlw.social.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.zjlw.social.LocalPayPrintInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.zjlw.social.LocalPayPrintCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface LocalPayPrintController extends CoreBillBaseController
{
    public LocalPayPrintCollection getLocalPayPrintCollection(Context ctx) throws BOSException, RemoteException;
    public LocalPayPrintCollection getLocalPayPrintCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public LocalPayPrintCollection getLocalPayPrintCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public LocalPayPrintInfo getLocalPayPrintInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public LocalPayPrintInfo getLocalPayPrintInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public LocalPayPrintInfo getLocalPayPrintInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void initBill(Context ctx, String sql) throws BOSException, EASBizException, RemoteException;
}