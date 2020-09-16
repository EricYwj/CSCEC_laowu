package com.kingdee.eas.zjlw.social;

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

public interface IProjFEREntry extends ICoreBillBase
{
    public ProjFEREntryCollection getProjFEREntryCollection() throws BOSException;
    public ProjFEREntryCollection getProjFEREntryCollection(EntityViewInfo view) throws BOSException;
    public ProjFEREntryCollection getProjFEREntryCollection(String oql) throws BOSException;
    public ProjFEREntryInfo getProjFEREntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProjFEREntryInfo getProjFEREntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProjFEREntryInfo getProjFEREntryInfo(String oql) throws BOSException, EASBizException;
}