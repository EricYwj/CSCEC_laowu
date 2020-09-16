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

public interface IProjBWREtyEntry extends ICoreBillEntryBase
{
    public ProjBWREtyEntryInfo getProjBWREtyEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProjBWREtyEntryInfo getProjBWREtyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProjBWREtyEntryInfo getProjBWREtyEntryInfo(String oql) throws BOSException, EASBizException;
    public ProjBWREtyEntryCollection getProjBWREtyEntryCollection() throws BOSException;
    public ProjBWREtyEntryCollection getProjBWREtyEntryCollection(EntityViewInfo view) throws BOSException;
    public ProjBWREtyEntryCollection getProjBWREtyEntryCollection(String oql) throws BOSException;
}