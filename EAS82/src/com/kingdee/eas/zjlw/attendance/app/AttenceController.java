package com.kingdee.eas.zjlw.attendance.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.zjlw.attendance.AttenceCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.zjlw.attendance.AttenceInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface AttenceController extends CoreBillBaseController
{
    public AttenceCollection getAttenceCollection(Context ctx) throws BOSException, RemoteException;
    public AttenceCollection getAttenceCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public AttenceCollection getAttenceCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public AttenceInfo getAttenceInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public AttenceInfo getAttenceInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public AttenceInfo getAttenceInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}