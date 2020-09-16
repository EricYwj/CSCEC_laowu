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

public interface ILivepermitECEntry extends ICoreBillEntryBase
{
    public LivepermitECEntryInfo getLivepermitECEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LivepermitECEntryInfo getLivepermitECEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LivepermitECEntryInfo getLivepermitECEntryInfo(String oql) throws BOSException, EASBizException;
    public LivepermitECEntryCollection getLivepermitECEntryCollection() throws BOSException;
    public LivepermitECEntryCollection getLivepermitECEntryCollection(EntityViewInfo view) throws BOSException;
    public LivepermitECEntryCollection getLivepermitECEntryCollection(String oql) throws BOSException;
}