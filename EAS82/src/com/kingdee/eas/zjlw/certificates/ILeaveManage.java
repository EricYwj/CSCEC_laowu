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

public interface ILeaveManage extends ICoreBillBase
{
    public LeaveManageCollection getLeaveManageCollection() throws BOSException;
    public LeaveManageCollection getLeaveManageCollection(EntityViewInfo view) throws BOSException;
    public LeaveManageCollection getLeaveManageCollection(String oql) throws BOSException;
    public LeaveManageInfo getLeaveManageInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LeaveManageInfo getLeaveManageInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LeaveManageInfo getLeaveManageInfo(String oql) throws BOSException, EASBizException;
}