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

public interface IProjInsVcPayReg extends ICoreBillBase
{
    public ProjInsVcPayRegCollection getProjInsVcPayRegCollection() throws BOSException;
    public ProjInsVcPayRegCollection getProjInsVcPayRegCollection(EntityViewInfo view) throws BOSException;
    public ProjInsVcPayRegCollection getProjInsVcPayRegCollection(String oql) throws BOSException;
    public ProjInsVcPayRegInfo getProjInsVcPayRegInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProjInsVcPayRegInfo getProjInsVcPayRegInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProjInsVcPayRegInfo getProjInsVcPayRegInfo(String oql) throws BOSException, EASBizException;
}