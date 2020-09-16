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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IAttence extends ICoreBillBase
{
    public AttenceCollection getAttenceCollection() throws BOSException;
    public AttenceCollection getAttenceCollection(EntityViewInfo view) throws BOSException;
    public AttenceCollection getAttenceCollection(String oql) throws BOSException;
    public AttenceInfo getAttenceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AttenceInfo getAttenceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AttenceInfo getAttenceInfo(String oql) throws BOSException, EASBizException;
}