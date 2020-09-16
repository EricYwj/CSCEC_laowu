package com.kingdee.eas.zjlw.social;

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

public interface IProjFERAssdEntry extends ICoreBillEntryBase
{
    public ProjFERAssdEntryInfo getProjFERAssdEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProjFERAssdEntryInfo getProjFERAssdEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProjFERAssdEntryInfo getProjFERAssdEntryInfo(String oql) throws BOSException, EASBizException;
    public ProjFERAssdEntryCollection getProjFERAssdEntryCollection() throws BOSException;
    public ProjFERAssdEntryCollection getProjFERAssdEntryCollection(EntityViewInfo view) throws BOSException;
    public ProjFERAssdEntryCollection getProjFERAssdEntryCollection(String oql) throws BOSException;
}