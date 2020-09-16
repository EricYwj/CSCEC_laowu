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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IAlgattenceResult extends IDataBase
{
    public AlgattenceResultInfo getAlgattenceResultInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AlgattenceResultInfo getAlgattenceResultInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AlgattenceResultInfo getAlgattenceResultInfo(String oql) throws BOSException, EASBizException;
    public AlgattenceResultCollection getAlgattenceResultCollection() throws BOSException;
    public AlgattenceResultCollection getAlgattenceResultCollection(EntityViewInfo view) throws BOSException;
    public AlgattenceResultCollection getAlgattenceResultCollection(String oql) throws BOSException;
}