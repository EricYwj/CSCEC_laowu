package com.kingdee.eas.zjlw.personmess.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.zjlw.personmess.PersonManEntryInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.zjlw.personmess.PersonManEntryCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
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

public interface PersonManEntryController extends CoreBillEntryBaseController
{
    public PersonManEntryInfo getPersonManEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PersonManEntryInfo getPersonManEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PersonManEntryInfo getPersonManEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PersonManEntryCollection getPersonManEntryCollection(Context ctx) throws BOSException, RemoteException;
    public PersonManEntryCollection getPersonManEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PersonManEntryCollection getPersonManEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}