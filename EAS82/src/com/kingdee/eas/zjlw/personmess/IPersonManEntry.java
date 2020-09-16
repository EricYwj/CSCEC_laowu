package com.kingdee.eas.zjlw.personmess;

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

public interface IPersonManEntry extends ICoreBillEntryBase
{
    public PersonManEntryInfo getPersonManEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PersonManEntryInfo getPersonManEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PersonManEntryInfo getPersonManEntryInfo(String oql) throws BOSException, EASBizException;
    public PersonManEntryCollection getPersonManEntryCollection() throws BOSException;
    public PersonManEntryCollection getPersonManEntryCollection(EntityViewInfo view) throws BOSException;
    public PersonManEntryCollection getPersonManEntryCollection(String oql) throws BOSException;
}