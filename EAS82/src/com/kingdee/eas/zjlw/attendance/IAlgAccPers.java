package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IAlgAccPers extends IDataBase
{
    public AlgAccPersInfo getAlgAccPersInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AlgAccPersInfo getAlgAccPersInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AlgAccPersInfo getAlgAccPersInfo(String oql) throws BOSException, EASBizException;
    public AlgAccPersCollection getAlgAccPersCollection() throws BOSException;
    public AlgAccPersCollection getAlgAccPersCollection(EntityViewInfo view) throws BOSException;
    public AlgAccPersCollection getAlgAccPersCollection(String oql) throws BOSException;
}