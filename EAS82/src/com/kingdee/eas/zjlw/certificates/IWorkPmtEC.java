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

public interface IWorkPmtEC extends ICoreBillBase
{
    public WorkPmtECCollection getWorkPmtECCollection() throws BOSException;
    public WorkPmtECCollection getWorkPmtECCollection(EntityViewInfo view) throws BOSException;
    public WorkPmtECCollection getWorkPmtECCollection(String oql) throws BOSException;
    public WorkPmtECInfo getWorkPmtECInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WorkPmtECInfo getWorkPmtECInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WorkPmtECInfo getWorkPmtECInfo(String oql) throws BOSException, EASBizException;
    public void dstry() throws BOSException;
}