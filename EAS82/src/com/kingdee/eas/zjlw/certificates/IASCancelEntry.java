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

public interface IASCancelEntry extends ICoreBillEntryBase
{
    public ASCancelEntryInfo getASCancelEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ASCancelEntryInfo getASCancelEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ASCancelEntryInfo getASCancelEntryInfo(String oql) throws BOSException, EASBizException;
    public ASCancelEntryCollection getASCancelEntryCollection() throws BOSException;
    public ASCancelEntryCollection getASCancelEntryCollection(EntityViewInfo view) throws BOSException;
    public ASCancelEntryCollection getASCancelEntryCollection(String oql) throws BOSException;
}