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

public interface IWorkVisa extends ICoreBillBase
{
    public WorkVisaCollection getWorkVisaCollection() throws BOSException;
    public WorkVisaCollection getWorkVisaCollection(EntityViewInfo view) throws BOSException;
    public WorkVisaCollection getWorkVisaCollection(String oql) throws BOSException;
    public WorkVisaInfo getWorkVisaInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WorkVisaInfo getWorkVisaInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WorkVisaInfo getWorkVisaInfo(String oql) throws BOSException, EASBizException;
    public void bizPersonAudit(IObjectPK pk) throws BOSException, EASBizException;
    public void projectMessAudit(IObjectPK pk) throws BOSException, EASBizException;
}