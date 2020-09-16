package com.kingdee.eas.zjlw.social;

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

public interface ICheckCountEntry extends ICoreBillEntryBase
{
    public CheckCountEntryInfo getCheckCountEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CheckCountEntryInfo getCheckCountEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CheckCountEntryInfo getCheckCountEntryInfo(String oql) throws BOSException, EASBizException;
    public CheckCountEntryCollection getCheckCountEntryCollection() throws BOSException;
    public CheckCountEntryCollection getCheckCountEntryCollection(EntityViewInfo view) throws BOSException;
    public CheckCountEntryCollection getCheckCountEntryCollection(String oql) throws BOSException;
}