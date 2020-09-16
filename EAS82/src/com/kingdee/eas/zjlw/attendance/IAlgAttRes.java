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

public interface IAlgAttRes extends ICoreBillBase
{
    public AlgAttResCollection getAlgAttResCollection() throws BOSException;
    public AlgAttResCollection getAlgAttResCollection(EntityViewInfo view) throws BOSException;
    public AlgAttResCollection getAlgAttResCollection(String oql) throws BOSException;
    public AlgAttResInfo getAlgAttResInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AlgAttResInfo getAlgAttResInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AlgAttResInfo getAlgAttResInfo(String oql) throws BOSException, EASBizException;
}