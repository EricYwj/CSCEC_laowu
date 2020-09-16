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

public interface ISecuSplit extends ICoreBillBase
{
    public SecuSplitCollection getSecuSplitCollection() throws BOSException;
    public SecuSplitCollection getSecuSplitCollection(EntityViewInfo view) throws BOSException;
    public SecuSplitCollection getSecuSplitCollection(String oql) throws BOSException;
    public SecuSplitInfo getSecuSplitInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SecuSplitInfo getSecuSplitInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SecuSplitInfo getSecuSplitInfo(String oql) throws BOSException, EASBizException;
    public SecuSplitInfo initBill(String PK, String fullInfoPk) throws BOSException, EASBizException;
}