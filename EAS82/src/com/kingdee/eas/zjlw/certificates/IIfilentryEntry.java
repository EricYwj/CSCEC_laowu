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

public interface IIfilentryEntry extends ICoreBillEntryBase
{
    public IfilentryEntryInfo getIfilentryEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public IfilentryEntryInfo getIfilentryEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public IfilentryEntryInfo getIfilentryEntryInfo(String oql) throws BOSException, EASBizException;
    public IfilentryEntryCollection getIfilentryEntryCollection() throws BOSException;
    public IfilentryEntryCollection getIfilentryEntryCollection(EntityViewInfo view) throws BOSException;
    public IfilentryEntryCollection getIfilentryEntryCollection(String oql) throws BOSException;
}