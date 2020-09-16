package com.kingdee.eas.zjlw.attendance.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface dbQueryUtilFacadeController extends BizController
{
    public boolean dbQueryAndInit(Context ctx, String sql) throws BOSException, RemoteException;
}