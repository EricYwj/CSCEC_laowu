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

public interface IProfDp extends IDataBase
{
    public ProfDpInfo getProfDpInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProfDpInfo getProfDpInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProfDpInfo getProfDpInfo(String oql) throws BOSException, EASBizException;
    public ProfDpCollection getProfDpCollection() throws BOSException;
    public ProfDpCollection getProfDpCollection(EntityViewInfo view) throws BOSException;
    public ProfDpCollection getProfDpCollection(String oql) throws BOSException;
}