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

public interface ICheckInOutTable extends IDataBase
{
    public CheckInOutTableInfo getCheckInOutTableInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CheckInOutTableInfo getCheckInOutTableInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CheckInOutTableInfo getCheckInOutTableInfo(String oql) throws BOSException, EASBizException;
    public CheckInOutTableCollection getCheckInOutTableCollection() throws BOSException;
    public CheckInOutTableCollection getCheckInOutTableCollection(EntityViewInfo view) throws BOSException;
    public CheckInOutTableCollection getCheckInOutTableCollection(String oql) throws BOSException;
    public String init() throws BOSException;
}