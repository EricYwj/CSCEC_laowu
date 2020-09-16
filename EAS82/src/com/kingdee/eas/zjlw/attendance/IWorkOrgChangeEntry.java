package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IWorkOrgChangeEntry extends ICoreBillEntryBase
{
    public WorkOrgChangeEntryInfo getWorkOrgChangeEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WorkOrgChangeEntryInfo getWorkOrgChangeEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WorkOrgChangeEntryInfo getWorkOrgChangeEntryInfo(String oql) throws BOSException, EASBizException;
    public WorkOrgChangeEntryCollection getWorkOrgChangeEntryCollection() throws BOSException;
    public WorkOrgChangeEntryCollection getWorkOrgChangeEntryCollection(EntityViewInfo view) throws BOSException;
    public WorkOrgChangeEntryCollection getWorkOrgChangeEntryCollection(String oql) throws BOSException;
}