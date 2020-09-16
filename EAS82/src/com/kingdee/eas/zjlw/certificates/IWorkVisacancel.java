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

public interface IWorkVisacancel extends ICoreBillBase
{
    public WorkVisacancelCollection getWorkVisacancelCollection() throws BOSException;
    public WorkVisacancelCollection getWorkVisacancelCollection(EntityViewInfo view) throws BOSException;
    public WorkVisacancelCollection getWorkVisacancelCollection(String oql) throws BOSException;
    public WorkVisacancelInfo getWorkVisacancelInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WorkVisacancelInfo getWorkVisacancelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WorkVisacancelInfo getWorkVisacancelInfo(String oql) throws BOSException, EASBizException;
}