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

public interface IProfDpTree extends ITreeBase
{
    public ProfDpTreeInfo getProfDpTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProfDpTreeInfo getProfDpTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProfDpTreeInfo getProfDpTreeInfo(String oql) throws BOSException, EASBizException;
    public ProfDpTreeCollection getProfDpTreeCollection() throws BOSException;
    public ProfDpTreeCollection getProfDpTreeCollection(EntityViewInfo view) throws BOSException;
    public ProfDpTreeCollection getProfDpTreeCollection(String oql) throws BOSException;
}