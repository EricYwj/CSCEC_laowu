package com.kingdee.eas.zjlw.certificates.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.zjlw.certificates.ImmigrationInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.zjlw.certificates.ImmigrationCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ImmigrationController extends CoreBillBaseController
{
    public ImmigrationCollection getImmigrationCollection(Context ctx) throws BOSException, RemoteException;
    public ImmigrationCollection getImmigrationCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ImmigrationCollection getImmigrationCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ImmigrationInfo getImmigrationInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ImmigrationInfo getImmigrationInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ImmigrationInfo getImmigrationInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void internalAudit(Context ctx, IObjectPK PK) throws BOSException, EASBizException, RemoteException;
    public void LWAudit(Context ctx, IObjectPK PK) throws BOSException, EASBizException, RemoteException;
}