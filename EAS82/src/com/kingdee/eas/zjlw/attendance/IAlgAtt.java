package com.kingdee.eas.zjlw.attendance;

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

public interface IAlgAtt extends ICoreBillBase
{
    public AlgAttCollection getAlgAttCollection() throws BOSException;
    public AlgAttCollection getAlgAttCollection(EntityViewInfo view) throws BOSException;
    public AlgAttCollection getAlgAttCollection(String oql) throws BOSException;
    public AlgAttInfo getAlgAttInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AlgAttInfo getAlgAttInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AlgAttInfo getAlgAttInfo(String oql) throws BOSException, EASBizException;
}