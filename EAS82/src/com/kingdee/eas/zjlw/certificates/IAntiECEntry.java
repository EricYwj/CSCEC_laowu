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

public interface IAntiECEntry extends ICoreBillEntryBase
{
    public AntiECEntryInfo getAntiECEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AntiECEntryInfo getAntiECEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AntiECEntryInfo getAntiECEntryInfo(String oql) throws BOSException, EASBizException;
    public AntiECEntryCollection getAntiECEntryCollection() throws BOSException;
    public AntiECEntryCollection getAntiECEntryCollection(EntityViewInfo view) throws BOSException;
    public AntiECEntryCollection getAntiECEntryCollection(String oql) throws BOSException;
}