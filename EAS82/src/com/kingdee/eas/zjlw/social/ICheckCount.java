package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public interface ICheckCount extends ICoreBillBase
{
    public CheckCountCollection getCheckCountCollection() throws BOSException;
    public CheckCountCollection getCheckCountCollection(EntityViewInfo view) throws BOSException;
    public CheckCountCollection getCheckCountCollection(String oql) throws BOSException;
    public CheckCountInfo getCheckCountInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CheckCountInfo getCheckCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CheckCountInfo getCheckCountInfo(String oql) throws BOSException, EASBizException;
    public IObjectValue initBill(IObjectValue info) throws BOSException, EASBizException;
}