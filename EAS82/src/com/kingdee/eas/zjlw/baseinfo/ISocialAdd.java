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

public interface ISocialAdd extends IDataBase
{
    public SocialAddInfo getSocialAddInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SocialAddInfo getSocialAddInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SocialAddInfo getSocialAddInfo(String oql) throws BOSException, EASBizException;
    public SocialAddCollection getSocialAddCollection() throws BOSException;
    public SocialAddCollection getSocialAddCollection(EntityViewInfo view) throws BOSException;
    public SocialAddCollection getSocialAddCollection(String oql) throws BOSException;
}