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

public interface IAttenceResult extends IDataBase
{
    public AttenceResultInfo getAttenceResultInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AttenceResultInfo getAttenceResultInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AttenceResultInfo getAttenceResultInfo(String oql) throws BOSException, EASBizException;
    public AttenceResultCollection getAttenceResultCollection() throws BOSException;
    public AttenceResultCollection getAttenceResultCollection(EntityViewInfo view) throws BOSException;
    public AttenceResultCollection getAttenceResultCollection(String oql) throws BOSException;
}