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

public interface ICertAdd extends IDataBase
{
    public CertAddInfo getCertAddInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CertAddInfo getCertAddInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CertAddInfo getCertAddInfo(String oql) throws BOSException, EASBizException;
    public CertAddCollection getCertAddCollection() throws BOSException;
    public CertAddCollection getCertAddCollection(EntityViewInfo view) throws BOSException;
    public CertAddCollection getCertAddCollection(String oql) throws BOSException;
}