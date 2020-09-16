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

public interface IPayPrintEntry extends ICoreBillEntryBase
{
    public PayPrintEntryInfo getPayPrintEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PayPrintEntryInfo getPayPrintEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PayPrintEntryInfo getPayPrintEntryInfo(String oql) throws BOSException, EASBizException;
    public PayPrintEntryCollection getPayPrintEntryCollection() throws BOSException;
    public PayPrintEntryCollection getPayPrintEntryCollection(EntityViewInfo view) throws BOSException;
    public PayPrintEntryCollection getPayPrintEntryCollection(String oql) throws BOSException;
}