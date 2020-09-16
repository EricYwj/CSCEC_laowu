package com.kingdee.eas.zjlw.attendance;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICheckInOut extends IDataBase
{
    public CheckInOutInfo getCheckInOutInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CheckInOutInfo getCheckInOutInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CheckInOutInfo getCheckInOutInfo(String oql) throws BOSException, EASBizException;
    public CheckInOutCollection getCheckInOutCollection() throws BOSException;
    public CheckInOutCollection getCheckInOutCollection(EntityViewInfo view) throws BOSException;
    public CheckInOutCollection getCheckInOutCollection(String oql) throws BOSException;
    public boolean dbQuery(String sql) throws BOSException;
    public void init() throws BOSException;
}