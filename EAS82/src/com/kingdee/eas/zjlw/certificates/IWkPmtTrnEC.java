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

public interface IWkPmtTrnEC extends ICoreBillBase
{
    public WkPmtTrnECCollection getWkPmtTrnECCollection() throws BOSException;
    public WkPmtTrnECCollection getWkPmtTrnECCollection(EntityViewInfo view) throws BOSException;
    public WkPmtTrnECCollection getWkPmtTrnECCollection(String oql) throws BOSException;
    public WkPmtTrnECInfo getWkPmtTrnECInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WkPmtTrnECInfo getWkPmtTrnECInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WkPmtTrnECInfo getWkPmtTrnECInfo(String oql) throws BOSException, EASBizException;
}