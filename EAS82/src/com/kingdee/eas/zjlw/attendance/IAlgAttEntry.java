package com.kingdee.eas.zjlw.attendance;

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

public interface IAlgAttEntry extends ICoreBillEntryBase
{
    public AlgAttEntryInfo getAlgAttEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AlgAttEntryInfo getAlgAttEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AlgAttEntryInfo getAlgAttEntryInfo(String oql) throws BOSException, EASBizException;
    public AlgAttEntryCollection getAlgAttEntryCollection() throws BOSException;
    public AlgAttEntryCollection getAlgAttEntryCollection(EntityViewInfo view) throws BOSException;
    public AlgAttEntryCollection getAlgAttEntryCollection(String oql) throws BOSException;
}