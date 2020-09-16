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

public interface IWorkPmtECEntry extends ICoreBillEntryBase
{
    public WorkPmtECEntryInfo getWorkPmtECEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WorkPmtECEntryInfo getWorkPmtECEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WorkPmtECEntryInfo getWorkPmtECEntryInfo(String oql) throws BOSException, EASBizException;
    public WorkPmtECEntryCollection getWorkPmtECEntryCollection() throws BOSException;
    public WorkPmtECEntryCollection getWorkPmtECEntryCollection(EntityViewInfo view) throws BOSException;
    public WorkPmtECEntryCollection getWorkPmtECEntryCollection(String oql) throws BOSException;
}