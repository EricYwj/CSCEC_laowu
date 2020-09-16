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

public interface IDoubQualify extends ICoreBillBase
{
    public DoubQualifyCollection getDoubQualifyCollection() throws BOSException;
    public DoubQualifyCollection getDoubQualifyCollection(EntityViewInfo view) throws BOSException;
    public DoubQualifyCollection getDoubQualifyCollection(String oql) throws BOSException;
    public DoubQualifyInfo getDoubQualifyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DoubQualifyInfo getDoubQualifyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DoubQualifyInfo getDoubQualifyInfo(String oql) throws BOSException, EASBizException;
}