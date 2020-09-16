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

public interface IWkPmtDstryECEntry extends ICoreBillEntryBase
{
    public WkPmtDstryECEntryInfo getWkPmtDstryECEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WkPmtDstryECEntryInfo getWkPmtDstryECEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WkPmtDstryECEntryInfo getWkPmtDstryECEntryInfo(String oql) throws BOSException, EASBizException;
    public WkPmtDstryECEntryCollection getWkPmtDstryECEntryCollection() throws BOSException;
    public WkPmtDstryECEntryCollection getWkPmtDstryECEntryCollection(EntityViewInfo view) throws BOSException;
    public WkPmtDstryECEntryCollection getWkPmtDstryECEntryCollection(String oql) throws BOSException;
}