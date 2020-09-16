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

public interface IProjectOrg extends ICoreBillBase
{
    public ProjectOrgCollection getProjectOrgCollection() throws BOSException;
    public ProjectOrgCollection getProjectOrgCollection(EntityViewInfo view) throws BOSException;
    public ProjectOrgCollection getProjectOrgCollection(String oql) throws BOSException;
    public ProjectOrgInfo getProjectOrgInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProjectOrgInfo getProjectOrgInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProjectOrgInfo getProjectOrgInfo(String oql) throws BOSException, EASBizException;
}