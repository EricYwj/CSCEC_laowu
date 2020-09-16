package com.kingdee.eas.zjlw.personmess;

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

public interface ILocalInfoEntry extends ICoreBillEntryBase
{
    public LocalInfoEntryInfo getLocalInfoEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LocalInfoEntryInfo getLocalInfoEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LocalInfoEntryInfo getLocalInfoEntryInfo(String oql) throws BOSException, EASBizException;
    public LocalInfoEntryCollection getLocalInfoEntryCollection() throws BOSException;
    public LocalInfoEntryCollection getLocalInfoEntryCollection(EntityViewInfo view) throws BOSException;
    public LocalInfoEntryCollection getLocalInfoEntryCollection(String oql) throws BOSException;
}