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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IDistrGovernment extends IDataBase
{
    public DistrGovernmentInfo getDistrGovernmentInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DistrGovernmentInfo getDistrGovernmentInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DistrGovernmentInfo getDistrGovernmentInfo(String oql) throws BOSException, EASBizException;
    public DistrGovernmentCollection getDistrGovernmentCollection() throws BOSException;
    public DistrGovernmentCollection getDistrGovernmentCollection(EntityViewInfo view) throws BOSException;
    public DistrGovernmentCollection getDistrGovernmentCollection(String oql) throws BOSException;
}