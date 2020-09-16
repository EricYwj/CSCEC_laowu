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

public interface IPassportapply extends ICoreBillBase
{
    public PassportapplyCollection getPassportapplyCollection() throws BOSException;
    public PassportapplyCollection getPassportapplyCollection(EntityViewInfo view) throws BOSException;
    public PassportapplyCollection getPassportapplyCollection(String oql) throws BOSException;
    public PassportapplyInfo getPassportapplyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PassportapplyInfo getPassportapplyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PassportapplyInfo getPassportapplyInfo(String oql) throws BOSException, EASBizException;
    public void internalAudit(IObjectPK PK) throws BOSException, EASBizException;
    public void UNinternalAudit(IObjectPK PK) throws BOSException, EASBizException;
    public void LWAudit(IObjectPK PK) throws BOSException, EASBizException;
}