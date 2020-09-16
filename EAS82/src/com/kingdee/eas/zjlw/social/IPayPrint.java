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

public interface IPayPrint extends ICoreBillBase
{
    public PayPrintCollection getPayPrintCollection() throws BOSException;
    public PayPrintCollection getPayPrintCollection(EntityViewInfo view) throws BOSException;
    public PayPrintCollection getPayPrintCollection(String oql) throws BOSException;
    public PayPrintInfo getPayPrintInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PayPrintInfo getPayPrintInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PayPrintInfo getPayPrintInfo(String oql) throws BOSException, EASBizException;
    public void initBill(String sql) throws BOSException, EASBizException;
}