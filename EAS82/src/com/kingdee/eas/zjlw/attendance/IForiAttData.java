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

public interface IForiAttData extends ICoreBillBase
{
    public ForiAttDataCollection getForiAttDataCollection() throws BOSException;
    public ForiAttDataCollection getForiAttDataCollection(EntityViewInfo view) throws BOSException;
    public ForiAttDataCollection getForiAttDataCollection(String oql) throws BOSException;
    public ForiAttDataInfo getForiAttDataInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ForiAttDataInfo getForiAttDataInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ForiAttDataInfo getForiAttDataInfo(String oql) throws BOSException, EASBizException;
}