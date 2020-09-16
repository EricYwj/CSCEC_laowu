package com.kingdee.eas.zjlw.attendance.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.zjlw.attendance.AttenceResultInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.zjlw.attendance.AttenceResultCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface AttenceResultController extends DataBaseController
{
    public AttenceResultInfo getAttenceResultInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public AttenceResultInfo getAttenceResultInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public AttenceResultInfo getAttenceResultInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public AttenceResultCollection getAttenceResultCollection(Context ctx) throws BOSException, RemoteException;
    public AttenceResultCollection getAttenceResultCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public AttenceResultCollection getAttenceResultCollection(Context ctx, String oql) throws BOSException, RemoteException;
}