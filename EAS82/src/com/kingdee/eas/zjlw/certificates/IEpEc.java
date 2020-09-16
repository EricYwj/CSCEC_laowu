package com.kingdee.eas.zjlw.certificates;

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

public interface IEpEc extends ICoreBillBase
{
    public EpEcCollection getEpEcCollection() throws BOSException;
    public EpEcCollection getEpEcCollection(EntityViewInfo view) throws BOSException;
    public EpEcCollection getEpEcCollection(String oql) throws BOSException;
    public EpEcInfo getEpEcInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EpEcInfo getEpEcInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EpEcInfo getEpEcInfo(String oql) throws BOSException, EASBizException;
}