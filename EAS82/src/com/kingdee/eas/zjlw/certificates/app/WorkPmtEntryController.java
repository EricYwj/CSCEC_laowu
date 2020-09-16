package com.kingdee.eas.zjlw.certificates.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.zjlw.certificates.WorkPmtEntryInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface WorkPmtEntryController extends CoreBillEntryBaseController
{
    public WorkPmtEntryInfo getWorkPmtEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public WorkPmtEntryInfo getWorkPmtEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public WorkPmtEntryInfo getWorkPmtEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public WorkPmtEntryCollection getWorkPmtEntryCollection(Context ctx) throws BOSException, RemoteException;
    public WorkPmtEntryCollection getWorkPmtEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public WorkPmtEntryCollection getWorkPmtEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}