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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IProjectWork extends ICoreBillBase
{
    public ProjectWorkCollection getProjectWorkCollection() throws BOSException;
    public ProjectWorkCollection getProjectWorkCollection(EntityViewInfo view) throws BOSException;
    public ProjectWorkCollection getProjectWorkCollection(String oql) throws BOSException;
    public ProjectWorkInfo getProjectWorkInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProjectWorkInfo getProjectWorkInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProjectWorkInfo getProjectWorkInfo(String oql) throws BOSException, EASBizException;
}