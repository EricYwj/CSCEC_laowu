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
import com.kingdee.eas.zjlw.personmess.NoCCInfo;
import com.kingdee.eas.zjlw.personmess.NoCCCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface NoCCController extends CoreBillBaseController
{
    public NoCCCollection getNoCCCollection(Context ctx) throws BOSException, RemoteException;
    public NoCCCollection getNoCCCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public NoCCCollection getNoCCCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public NoCCInfo getNoCCInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public NoCCInfo getNoCCInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public NoCCInfo getNoCCInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}