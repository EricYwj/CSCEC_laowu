package com.kingdee.eas.zjlw.baseinfo;

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

public interface IBlackList extends IDataBase
{
    public BlackListInfo getBlackListInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BlackListInfo getBlackListInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BlackListInfo getBlackListInfo(String oql) throws BOSException, EASBizException;
    public BlackListCollection getBlackListCollection() throws BOSException;
    public BlackListCollection getBlackListCollection(EntityViewInfo view) throws BOSException;
    public BlackListCollection getBlackListCollection(String oql) throws BOSException;
}