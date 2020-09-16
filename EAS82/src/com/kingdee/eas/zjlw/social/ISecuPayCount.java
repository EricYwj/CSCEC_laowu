package com.kingdee.eas.zjlw.social;

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

public interface ISecuPayCount extends ICoreBillBase
{
    public SecuPayCountCollection getSecuPayCountCollection() throws BOSException;
    public SecuPayCountCollection getSecuPayCountCollection(EntityViewInfo view) throws BOSException;
    public SecuPayCountCollection getSecuPayCountCollection(String oql) throws BOSException;
    public SecuPayCountInfo getSecuPayCountInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SecuPayCountInfo getSecuPayCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SecuPayCountInfo getSecuPayCountInfo(String oql) throws BOSException, EASBizException;
}