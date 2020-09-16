package com.kingdee.eas.zjlw.baseinfo;

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

public interface ICooprationEntry extends ICoreBillEntryBase
{
    public CooprationEntryInfo getCooprationEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CooprationEntryInfo getCooprationEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CooprationEntryInfo getCooprationEntryInfo(String oql) throws BOSException, EASBizException;
    public CooprationEntryCollection getCooprationEntryCollection() throws BOSException;
    public CooprationEntryCollection getCooprationEntryCollection(EntityViewInfo view) throws BOSException;
    public CooprationEntryCollection getCooprationEntryCollection(String oql) throws BOSException;
}