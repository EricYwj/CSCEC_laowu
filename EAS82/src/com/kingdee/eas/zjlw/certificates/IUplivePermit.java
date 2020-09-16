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

public interface IUplivePermit extends ICoreBillBase
{
    public UplivePermitCollection getUplivePermitCollection() throws BOSException;
    public UplivePermitCollection getUplivePermitCollection(EntityViewInfo view) throws BOSException;
    public UplivePermitCollection getUplivePermitCollection(String oql) throws BOSException;
    public UplivePermitInfo getUplivePermitInfo(IObjectPK pk) throws BOSException, EASBizException;
    public UplivePermitInfo getUplivePermitInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public UplivePermitInfo getUplivePermitInfo(String oql) throws BOSException, EASBizException;
}