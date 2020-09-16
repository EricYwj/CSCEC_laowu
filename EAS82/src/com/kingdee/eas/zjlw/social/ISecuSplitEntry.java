package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ISecuSplitEntry extends ICoreBillEntryBase
{
    public SecuSplitEntryInfo getSecuSplitEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SecuSplitEntryInfo getSecuSplitEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SecuSplitEntryInfo getSecuSplitEntryInfo(String oql) throws BOSException, EASBizException;
    public SecuSplitEntryCollection getSecuSplitEntryCollection() throws BOSException;
    public SecuSplitEntryCollection getSecuSplitEntryCollection(EntityViewInfo view) throws BOSException;
    public SecuSplitEntryCollection getSecuSplitEntryCollection(String oql) throws BOSException;
}