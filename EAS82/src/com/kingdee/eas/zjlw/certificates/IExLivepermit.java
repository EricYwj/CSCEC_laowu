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

public interface IExLivepermit extends ICoreBillBase
{
    public ExLivepermitCollection getExLivepermitCollection() throws BOSException;
    public ExLivepermitCollection getExLivepermitCollection(EntityViewInfo view) throws BOSException;
    public ExLivepermitCollection getExLivepermitCollection(String oql) throws BOSException;
    public ExLivepermitInfo getExLivepermitInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ExLivepermitInfo getExLivepermitInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ExLivepermitInfo getExLivepermitInfo(String oql) throws BOSException, EASBizException;
    public void initForSplitBill(String PK) throws BOSException, EASBizException;
}