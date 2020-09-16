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

public interface IVisaHandle extends ICoreBillBase
{
    public VisaHandleCollection getVisaHandleCollection() throws BOSException;
    public VisaHandleCollection getVisaHandleCollection(EntityViewInfo view) throws BOSException;
    public VisaHandleCollection getVisaHandleCollection(String oql) throws BOSException;
    public VisaHandleInfo getVisaHandleInfo(IObjectPK pk) throws BOSException, EASBizException;
    public VisaHandleInfo getVisaHandleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public VisaHandleInfo getVisaHandleInfo(String oql) throws BOSException, EASBizException;
}