package com.kingdee.eas.zjlw.personinfo;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IPersonHistory extends ICoreBillBase
{
    public PersonHistoryCollection getPersonHistoryCollection() throws BOSException;
    public PersonHistoryCollection getPersonHistoryCollection(EntityViewInfo view) throws BOSException;
    public PersonHistoryCollection getPersonHistoryCollection(String oql) throws BOSException;
    public PersonHistoryInfo getPersonHistoryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PersonHistoryInfo getPersonHistoryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PersonHistoryInfo getPersonHistoryInfo(String oql) throws BOSException, EASBizException;
}