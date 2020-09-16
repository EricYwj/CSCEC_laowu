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

public interface IForiPersEntry extends ICoreBillEntryBase
{
    public ForiPersEntryInfo getForiPersEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ForiPersEntryInfo getForiPersEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ForiPersEntryInfo getForiPersEntryInfo(String oql) throws BOSException, EASBizException;
    public ForiPersEntryCollection getForiPersEntryCollection() throws BOSException;
    public ForiPersEntryCollection getForiPersEntryCollection(EntityViewInfo view) throws BOSException;
    public ForiPersEntryCollection getForiPersEntryCollection(String oql) throws BOSException;
}