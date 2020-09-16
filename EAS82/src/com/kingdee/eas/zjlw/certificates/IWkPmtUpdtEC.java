package com.kingdee.eas.zjlw.certificates;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IWkPmtUpdtEC extends ICoreBillBase
{
    public WkPmtUpdtECCollection getWkPmtUpdtECCollection() throws BOSException;
    public WkPmtUpdtECCollection getWkPmtUpdtECCollection(EntityViewInfo view) throws BOSException;
    public WkPmtUpdtECCollection getWkPmtUpdtECCollection(String oql) throws BOSException;
    public WkPmtUpdtECInfo getWkPmtUpdtECInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WkPmtUpdtECInfo getWkPmtUpdtECInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WkPmtUpdtECInfo getWkPmtUpdtECInfo(String oql) throws BOSException, EASBizException;
}