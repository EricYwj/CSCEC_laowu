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

public interface IExLivepermitEntry extends ICoreBillEntryBase
{
    public ExLivepermitEntryInfo getExLivepermitEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ExLivepermitEntryInfo getExLivepermitEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ExLivepermitEntryInfo getExLivepermitEntryInfo(String oql) throws BOSException, EASBizException;
    public ExLivepermitEntryCollection getExLivepermitEntryCollection() throws BOSException;
    public ExLivepermitEntryCollection getExLivepermitEntryCollection(EntityViewInfo view) throws BOSException;
    public ExLivepermitEntryCollection getExLivepermitEntryCollection(String oql) throws BOSException;
}