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

public interface IProjWage extends IDataBase
{
    public ProjWageInfo getProjWageInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProjWageInfo getProjWageInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProjWageInfo getProjWageInfo(String oql) throws BOSException, EASBizException;
    public ProjWageCollection getProjWageCollection() throws BOSException;
    public ProjWageCollection getProjWageCollection(EntityViewInfo view) throws BOSException;
    public ProjWageCollection getProjWageCollection(String oql) throws BOSException;
}