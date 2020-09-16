package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
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

public interface IBlackperson extends ITreeBase
{
    public BlackpersonInfo getBlackpersonInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BlackpersonInfo getBlackpersonInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BlackpersonInfo getBlackpersonInfo(String oql) throws BOSException, EASBizException;
    public BlackpersonCollection getBlackpersonCollection() throws BOSException;
    public BlackpersonCollection getBlackpersonCollection(EntityViewInfo view) throws BOSException;
    public BlackpersonCollection getBlackpersonCollection(String oql) throws BOSException;
}