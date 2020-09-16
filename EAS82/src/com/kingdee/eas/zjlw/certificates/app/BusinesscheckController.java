package com.kingdee.eas.zjlw.certificates.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.zjlw.certificates.BusinesscheckCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.zjlw.certificates.BusinesscheckInfo;
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

public interface BusinesscheckController extends CoreBillBaseController
{
    public BusinesscheckCollection getBusinesscheckCollection(Context ctx) throws BOSException, RemoteException;
    public BusinesscheckCollection getBusinesscheckCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BusinesscheckCollection getBusinesscheckCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public BusinesscheckInfo getBusinesscheckInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BusinesscheckInfo getBusinesscheckInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BusinesscheckInfo getBusinesscheckInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}