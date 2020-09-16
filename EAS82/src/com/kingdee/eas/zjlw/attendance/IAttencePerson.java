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

public interface IAttencePerson extends IDataBase
{
    public AttencePersonInfo getAttencePersonInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AttencePersonInfo getAttencePersonInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AttencePersonInfo getAttencePersonInfo(String oql) throws BOSException, EASBizException;
    public AttencePersonCollection getAttencePersonCollection() throws BOSException;
    public AttencePersonCollection getAttencePersonCollection(EntityViewInfo view) throws BOSException;
    public AttencePersonCollection getAttencePersonCollection(String oql) throws BOSException;
}