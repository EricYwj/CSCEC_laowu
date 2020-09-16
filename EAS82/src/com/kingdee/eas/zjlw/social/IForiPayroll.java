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

public interface IForiPayroll extends ICoreBillBase
{
    public ForiPayrollCollection getForiPayrollCollection() throws BOSException;
    public ForiPayrollCollection getForiPayrollCollection(EntityViewInfo view) throws BOSException;
    public ForiPayrollCollection getForiPayrollCollection(String oql) throws BOSException;
    public ForiPayrollInfo getForiPayrollInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ForiPayrollInfo getForiPayrollInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ForiPayrollInfo getForiPayrollInfo(String oql) throws BOSException, EASBizException;
    public void updateErrData(String projId) throws BOSException;
}