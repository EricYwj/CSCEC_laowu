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

public interface IEmbassyReg extends ICoreBillBase
{
    public EmbassyRegCollection getEmbassyRegCollection() throws BOSException;
    public EmbassyRegCollection getEmbassyRegCollection(EntityViewInfo view) throws BOSException;
    public EmbassyRegCollection getEmbassyRegCollection(String oql) throws BOSException;
    public EmbassyRegInfo getEmbassyRegInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EmbassyRegInfo getEmbassyRegInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EmbassyRegInfo getEmbassyRegInfo(String oql) throws BOSException, EASBizException;
}