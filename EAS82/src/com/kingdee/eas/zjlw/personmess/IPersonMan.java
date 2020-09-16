package com.kingdee.eas.zjlw.personmess;

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

public interface IPersonMan extends ICoreBillBase
{
    public PersonManCollection getPersonManCollection() throws BOSException;
    public PersonManCollection getPersonManCollection(EntityViewInfo view) throws BOSException;
    public PersonManCollection getPersonManCollection(String oql) throws BOSException;
    public PersonManInfo getPersonManInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PersonManInfo getPersonManInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PersonManInfo getPersonManInfo(String oql) throws BOSException, EASBizException;
}