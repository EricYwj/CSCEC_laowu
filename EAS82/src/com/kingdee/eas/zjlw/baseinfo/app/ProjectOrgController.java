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
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.zjlw.baseinfo.ProjectOrgCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ProjectOrgController extends CoreBillBaseController
{
    public ProjectOrgCollection getProjectOrgCollection(Context ctx) throws BOSException, RemoteException;
    public ProjectOrgCollection getProjectOrgCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ProjectOrgCollection getProjectOrgCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ProjectOrgInfo getProjectOrgInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ProjectOrgInfo getProjectOrgInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ProjectOrgInfo getProjectOrgInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}