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

public interface IWkPmtTrnEntry extends ICoreBillEntryBase
{
    public WkPmtTrnEntryInfo getWkPmtTrnEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WkPmtTrnEntryInfo getWkPmtTrnEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WkPmtTrnEntryInfo getWkPmtTrnEntryInfo(String oql) throws BOSException, EASBizException;
    public WkPmtTrnEntryCollection getWkPmtTrnEntryCollection() throws BOSException;
    public WkPmtTrnEntryCollection getWkPmtTrnEntryCollection(EntityViewInfo view) throws BOSException;
    public WkPmtTrnEntryCollection getWkPmtTrnEntryCollection(String oql) throws BOSException;
}