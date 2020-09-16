package com.kingdee.eas.zjlw.personmess;

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

public interface IBusinessVisa extends ICoreBillBase
{
    public BusinessVisaCollection getBusinessVisaCollection() throws BOSException;
    public BusinessVisaCollection getBusinessVisaCollection(EntityViewInfo view) throws BOSException;
    public BusinessVisaCollection getBusinessVisaCollection(String oql) throws BOSException;
    public BusinessVisaInfo getBusinessVisaInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BusinessVisaInfo getBusinessVisaInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BusinessVisaInfo getBusinessVisaInfo(String oql) throws BOSException, EASBizException;
    public void addName(String id) throws BOSException;
}