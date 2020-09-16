package com.kingdee.eas.zjlw.baseinfo.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.zjlw.baseinfo.ProfDpCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.zjlw.baseinfo.ProfDpInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ProfDpController extends DataBaseController
{
    public ProfDpInfo getProfDpInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ProfDpInfo getProfDpInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ProfDpInfo getProfDpInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public ProfDpCollection getProfDpCollection(Context ctx) throws BOSException, RemoteException;
    public ProfDpCollection getProfDpCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ProfDpCollection getProfDpCollection(Context ctx, String oql) throws BOSException, RemoteException;
}