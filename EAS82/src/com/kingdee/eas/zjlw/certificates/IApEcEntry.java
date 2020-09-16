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

public interface IApEcEntry extends ICoreBillEntryBase
{
    public ApEcEntryInfo getApEcEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ApEcEntryInfo getApEcEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ApEcEntryInfo getApEcEntryInfo(String oql) throws BOSException, EASBizException;
    public ApEcEntryCollection getApEcEntryCollection() throws BOSException;
    public ApEcEntryCollection getApEcEntryCollection(EntityViewInfo view) throws BOSException;
    public ApEcEntryCollection getApEcEntryCollection(String oql) throws BOSException;
}