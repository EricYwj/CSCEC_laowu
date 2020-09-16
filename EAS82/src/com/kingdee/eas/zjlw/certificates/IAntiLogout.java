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

public interface IAntiLogout extends ICoreBillBase
{
    public AntiLogoutCollection getAntiLogoutCollection() throws BOSException;
    public AntiLogoutCollection getAntiLogoutCollection(EntityViewInfo view) throws BOSException;
    public AntiLogoutCollection getAntiLogoutCollection(String oql) throws BOSException;
    public AntiLogoutInfo getAntiLogoutInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AntiLogoutInfo getAntiLogoutInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AntiLogoutInfo getAntiLogoutInfo(String oql) throws BOSException, EASBizException;
}