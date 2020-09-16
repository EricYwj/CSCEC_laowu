package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IWkPmtUpdtECEntry extends ICoreBillEntryBase
{
    public WkPmtUpdtECEntryInfo getWkPmtUpdtECEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WkPmtUpdtECEntryInfo getWkPmtUpdtECEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WkPmtUpdtECEntryInfo getWkPmtUpdtECEntryInfo(String oql) throws BOSException, EASBizException;
    public WkPmtUpdtECEntryCollection getWkPmtUpdtECEntryCollection() throws BOSException;
    public WkPmtUpdtECEntryCollection getWkPmtUpdtECEntryCollection(EntityViewInfo view) throws BOSException;
    public WkPmtUpdtECEntryCollection getWkPmtUpdtECEntryCollection(String oql) throws BOSException;
}