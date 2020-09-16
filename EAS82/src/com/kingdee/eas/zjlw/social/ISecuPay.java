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

public interface ISecuPay extends ICoreBillBase
{
    public SecuPayCollection getSecuPayCollection() throws BOSException;
    public SecuPayCollection getSecuPayCollection(EntityViewInfo view) throws BOSException;
    public SecuPayCollection getSecuPayCollection(String oql) throws BOSException;
    public SecuPayInfo getSecuPayInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SecuPayInfo getSecuPayInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SecuPayInfo getSecuPayInfo(String oql) throws BOSException, EASBizException;
}