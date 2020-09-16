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

public interface ILaborBureau extends IDataBase
{
    public LaborBureauInfo getLaborBureauInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LaborBureauInfo getLaborBureauInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LaborBureauInfo getLaborBureauInfo(String oql) throws BOSException, EASBizException;
    public LaborBureauCollection getLaborBureauCollection() throws BOSException;
    public LaborBureauCollection getLaborBureauCollection(EntityViewInfo view) throws BOSException;
    public LaborBureauCollection getLaborBureauCollection(String oql) throws BOSException;
}