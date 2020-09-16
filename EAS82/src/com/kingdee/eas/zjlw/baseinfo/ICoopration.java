package com.kingdee.eas.zjlw.baseinfo;

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

public interface ICoopration extends ICoreBillBase
{
    public CooprationCollection getCooprationCollection() throws BOSException;
    public CooprationCollection getCooprationCollection(EntityViewInfo view) throws BOSException;
    public CooprationCollection getCooprationCollection(String oql) throws BOSException;
    public CooprationInfo getCooprationInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CooprationInfo getCooprationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CooprationInfo getCooprationInfo(String oql) throws BOSException, EASBizException;
}