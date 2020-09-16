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

public interface IForiChecked extends ICoreBillBase
{
    public ForiCheckedCollection getForiCheckedCollection() throws BOSException;
    public ForiCheckedCollection getForiCheckedCollection(EntityViewInfo view) throws BOSException;
    public ForiCheckedCollection getForiCheckedCollection(String oql) throws BOSException;
    public ForiCheckedInfo getForiCheckedInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ForiCheckedInfo getForiCheckedInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ForiCheckedInfo getForiCheckedInfo(String oql) throws BOSException, EASBizException;
    public ForiCheckedInfo initBill(String infoId) throws BOSException, EASBizException;
}