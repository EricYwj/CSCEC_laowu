package com.kingdee.eas.zjlw.baseinfo.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.zjlw.baseinfo.ProfDpTreeCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.zjlw.baseinfo.ProfDpTreeInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ProfDpTreeController extends TreeBaseController
{
    public ProfDpTreeInfo getProfDpTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ProfDpTreeInfo getProfDpTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ProfDpTreeInfo getProfDpTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public ProfDpTreeCollection getProfDpTreeCollection(Context ctx) throws BOSException, RemoteException;
    public ProfDpTreeCollection getProfDpTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ProfDpTreeCollection getProfDpTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}