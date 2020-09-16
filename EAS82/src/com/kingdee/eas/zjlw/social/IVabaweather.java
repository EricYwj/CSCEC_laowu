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

public interface IVabaweather extends ICoreBillBase
{
    public VabaweatherCollection getVabaweatherCollection() throws BOSException;
    public VabaweatherCollection getVabaweatherCollection(EntityViewInfo view) throws BOSException;
    public VabaweatherCollection getVabaweatherCollection(String oql) throws BOSException;
    public VabaweatherInfo getVabaweatherInfo(IObjectPK pk) throws BOSException, EASBizException;
    public VabaweatherInfo getVabaweatherInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public VabaweatherInfo getVabaweatherInfo(String oql) throws BOSException, EASBizException;
}