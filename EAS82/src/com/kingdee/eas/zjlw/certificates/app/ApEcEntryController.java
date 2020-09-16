package com.kingdee.eas.zjlw.certificates.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.zjlw.certificates.ApEcEntryCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.zjlw.certificates.ApEcEntryInfo;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ApEcEntryController extends CoreBillEntryBaseController
{
    public ApEcEntryInfo getApEcEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ApEcEntryInfo getApEcEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ApEcEntryInfo getApEcEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public ApEcEntryCollection getApEcEntryCollection(Context ctx) throws BOSException, RemoteException;
    public ApEcEntryCollection getApEcEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ApEcEntryCollection getApEcEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}