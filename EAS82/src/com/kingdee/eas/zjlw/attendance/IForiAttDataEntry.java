package com.kingdee.eas.zjlw.attendance;

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

public interface IForiAttDataEntry extends ICoreBillEntryBase
{
    public ForiAttDataEntryInfo getForiAttDataEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ForiAttDataEntryInfo getForiAttDataEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ForiAttDataEntryInfo getForiAttDataEntryInfo(String oql) throws BOSException, EASBizException;
    public ForiAttDataEntryCollection getForiAttDataEntryCollection() throws BOSException;
    public ForiAttDataEntryCollection getForiAttDataEntryCollection(EntityViewInfo view) throws BOSException;
    public ForiAttDataEntryCollection getForiAttDataEntryCollection(String oql) throws BOSException;
}