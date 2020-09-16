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

public interface IProjFERAssd extends ICoreBillBase
{
    public ProjFERAssdCollection getProjFERAssdCollection() throws BOSException;
    public ProjFERAssdCollection getProjFERAssdCollection(EntityViewInfo view) throws BOSException;
    public ProjFERAssdCollection getProjFERAssdCollection(String oql) throws BOSException;
    public ProjFERAssdInfo getProjFERAssdInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProjFERAssdInfo getProjFERAssdInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProjFERAssdInfo getProjFERAssdInfo(String oql) throws BOSException, EASBizException;
}