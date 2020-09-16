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

public interface IExilivepermit extends ICoreBillBase
{
    public ExilivepermitCollection getExilivepermitCollection() throws BOSException;
    public ExilivepermitCollection getExilivepermitCollection(EntityViewInfo view) throws BOSException;
    public ExilivepermitCollection getExilivepermitCollection(String oql) throws BOSException;
    public ExilivepermitInfo getExilivepermitInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ExilivepermitInfo getExilivepermitInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ExilivepermitInfo getExilivepermitInfo(String oql) throws BOSException, EASBizException;
}