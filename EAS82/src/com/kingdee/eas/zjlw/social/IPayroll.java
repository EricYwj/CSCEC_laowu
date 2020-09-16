package com.kingdee.eas.zjlw.social;

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

public interface IPayroll extends ICoreBillBase
{
    public PayrollCollection getPayrollCollection() throws BOSException;
    public PayrollCollection getPayrollCollection(EntityViewInfo view) throws BOSException;
    public PayrollCollection getPayrollCollection(String oql) throws BOSException;
    public PayrollInfo getPayrollInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PayrollInfo getPayrollInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PayrollInfo getPayrollInfo(String oql) throws BOSException, EASBizException;
    public void updateErrData(String projId) throws BOSException;
}