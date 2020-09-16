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

public interface IAntiEC extends ICoreBillBase
{
    public AntiECCollection getAntiECCollection() throws BOSException;
    public AntiECCollection getAntiECCollection(EntityViewInfo view) throws BOSException;
    public AntiECCollection getAntiECCollection(String oql) throws BOSException;
    public AntiECInfo getAntiECInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AntiECInfo getAntiECInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AntiECInfo getAntiECInfo(String oql) throws BOSException, EASBizException;
    public void logOut(IObjectPK pk) throws BOSException, EASBizException;
}