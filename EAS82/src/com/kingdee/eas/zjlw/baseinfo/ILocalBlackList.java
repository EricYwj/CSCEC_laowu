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

public interface ILocalBlackList extends IDataBase
{
    public LocalBlackListInfo getLocalBlackListInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LocalBlackListInfo getLocalBlackListInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LocalBlackListInfo getLocalBlackListInfo(String oql) throws BOSException, EASBizException;
    public LocalBlackListCollection getLocalBlackListCollection() throws BOSException;
    public LocalBlackListCollection getLocalBlackListCollection(EntityViewInfo view) throws BOSException;
    public LocalBlackListCollection getLocalBlackListCollection(String oql) throws BOSException;
}