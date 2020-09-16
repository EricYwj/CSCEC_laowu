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

public interface IInsurePersonEntry extends ICoreBillEntryBase
{
    public InsurePersonEntryInfo getInsurePersonEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public InsurePersonEntryInfo getInsurePersonEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public InsurePersonEntryInfo getInsurePersonEntryInfo(String oql) throws BOSException, EASBizException;
    public InsurePersonEntryCollection getInsurePersonEntryCollection() throws BOSException;
    public InsurePersonEntryCollection getInsurePersonEntryCollection(EntityViewInfo view) throws BOSException;
    public InsurePersonEntryCollection getInsurePersonEntryCollection(String oql) throws BOSException;
}