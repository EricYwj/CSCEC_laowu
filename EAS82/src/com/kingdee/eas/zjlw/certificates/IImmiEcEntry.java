package com.kingdee.eas.zjlw.certificates;

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

public interface IImmiEcEntry extends ICoreBillEntryBase
{
    public ImmiEcEntryInfo getImmiEcEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ImmiEcEntryInfo getImmiEcEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ImmiEcEntryInfo getImmiEcEntryInfo(String oql) throws BOSException, EASBizException;
    public ImmiEcEntryCollection getImmiEcEntryCollection() throws BOSException;
    public ImmiEcEntryCollection getImmiEcEntryCollection(EntityViewInfo view) throws BOSException;
    public ImmiEcEntryCollection getImmiEcEntryCollection(String oql) throws BOSException;
}