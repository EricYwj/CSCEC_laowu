package com.kingdee.eas.zjlw.personmess.app;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.zjlw.personmess.LocalInfoInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.zjlw.personmess.LocalInfoCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface LocalInfoController extends CoreBillBaseController
{
    public LocalInfoCollection getLocalInfoCollection(Context ctx) throws BOSException, RemoteException;
    public LocalInfoCollection getLocalInfoCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public LocalInfoCollection getLocalInfoCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public LocalInfoInfo getLocalInfoInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public LocalInfoInfo getLocalInfoInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public LocalInfoInfo getLocalInfoInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}